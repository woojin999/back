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
					<td><a href="/product/detail?pno=${pvo.pno }">${pvo.pname }</a></td>
					<td>${pvo.price}</td>
					<td>${pvo.writer}</td>
					<td>${pvo.modAt}</td>
					<td>${pvo.readCount }</td>
					<td>${pvo.cmtQty }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<jsp:include page="../common/footer.jsp" />