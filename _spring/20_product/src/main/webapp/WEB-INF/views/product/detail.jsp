<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<div class="container mt-5">
	<h1>Product Detail</h1>
	<table class="table table-striped">
		<tr>
			<th>Pno</th>
			<td id="pnoVal">${pvo.pno }</td>
		</tr>
		<tr>
			<th>Category</th>
			<td>${pvo.category }</td>
		</tr>
		<tr>
			<th>Product Name</th>
			<td>${pvo.pname }</td>
		</tr>
		<tr>
			<th>Price</th>
			<td>${pvo.price }</td>
		</tr>
		<tr>
			<th>Writer</th>
			<td>${pvo.writer }</td>
		</tr>
		<tr>
			<th>Made By</th>
			<td>${pvo.madeBy }</td>
		</tr>
		<tr>
			<th>Reg At</th>
			<td>${pvo.regAt }</td>
		</tr>
		<tr>
			<th>Mod At</th>
			<td>${pvo.modAt }</td>
		</tr>
		<tr>
			<th>Description</th>
			<td>${pvo.description }</td>
		</tr>
	</table>
	<ul class="nav justify-content-center">
    <li class="nav-item">
      <a class="nav-link" href="/product/modify?pno=${pvo.pno }">Modify</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" id="productRemove">Remove</a>
    </li>    
  </ul>
  <form action="" id="productRmForm" style="display: none;" method="post">
  	<input type="hidden" id="pno" value="" name="pno">  	
  </form>
</div>
<script src="/resources/js/product.detail.js"></script>
<jsp:include page="../common/footer.jsp" />