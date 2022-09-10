<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />


<div class="container mt-5">
	<h1 class="text-center mb-3">Member Detail</h1>
	<ul class="list-group mb-3">
		<li class="list-group-item" id="emVal">${mvo.email }</li>
		<li class="list-group-item">Nick : ${mvo.nickName }</li>
		<li class="list-group-item">Reg At : ${mvo.regAt }</li>
		<li class="list-group-item">Last Login : ${mvo.lastLogin }</li>
		<li class="list-group-item">Grade : ${mvo.grade }</li>
	</ul>
	<a class="btn btn-primary" href="/member/modify?email=${mvo.email }">Member Modify</a> 
	<a class="btn btn-primary" id="memberRemove">Member Remove</a>
	
	<form action="" id="memberRmForm" style="display: none;" method="post">
		<input type="hidden" id="em" value="" name="email">
	</form>
</div>
<script src="/resources/js/member.detail.js"></script>
<jsp:include page="../common/footer.jsp" />
