<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="common/header.jsp" />
<jsp:include page="common/nav.jsp" />

<div class="container mt-3">
  <h2>스프링!</h2>
  <div class="mt-4 p-5 bg-primary text-white rounded">
    <h1>Spring Frame work Example</h1> 
    <P>  The time on the server is ${serverTime}. </P>
  </div>
</div>
<script>
let isLogin = '<c:out value="${isLogin}"/>';
let isLogout = '<c:out value="${isLogout}"/>';

if (parseInt(isLogin)){
	alert("로그인 완료");
}
if (parseInt(isLogout)){
	alert("로그아웃 완료");
}
	/* alert("로그인" + (parseInt(isLogin) ? "완료" : "실패"));
	alert("로그아웃" + (parseInt(isLogout) ? "완료" : "실패")); */
	
	
</script>
<jsp:include page="common/footer.jsp" />
