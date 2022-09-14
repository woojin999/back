<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<div class="container mt-5">
	<h1>Product List
	<c:if test="${ses.email ne null }">
		<a href="/product/register" class="btn btn-primary">Register</a>
	</c:if>
	</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Pno</th>
				<th>Category</th>
				<th>Product Name</th>
				<th>Price</th>
				<th>Writer</th>
				<th>Mod At</th>
				<th>Read Count</th>
				<th>Cmt Qty</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="pvo">
				<tr>
					<td>${pvo.pno }</td>
					<td>${pvo.category }</td>
					<td><a href="/product/detail?pno=${pvo.pno }&pageNo=${pgn.pgvo.pageNo }&qty=${pgn.pgvo.qty}">${pvo.pname }</a></td>
					<td>${pvo.price}</td>
					<td>${pvo.writer}</td>
					<td>${pvo.modAt}</td>
					<td>${pvo.readCount }</td>
					<td>${pvo.cmtQty }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<ul class="pagination justify-content-center">
		<c:if test="${pgn.prev }">
	    <li class="page-item">
	    <a class="page-link" href="/product/list?pageNo=${pgn.startPage-1 }&qty=${pgn.pgvo.qty}">Prev</a>
	    </li>
	    </c:if>
	    <c:forEach begin="${pgn.startPage }" end="${pgn.endPage }" var="i">
	    <li class="page-item ${pgn.pgvo.pageNo == i ? 'active':'' }">
	    <a class="page-link" href="/product/list?pageNo=${i }&qty=${pgn.pgvo.qty}">${i }</a>
	    </li>
	   	</c:forEach>
	   	<c:if test="${pgn.next }">
	    <li class="page-item">
	    <a class="page-link" href="/product/list?pageNo=${pgn.endPage + 1 }&qty=${pgn.pgvo.qty}">Next</a>
	    </li>
	    </c:if>
  	</ul>
</div>
<jsp:include page="../common/footer.jsp" />