<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<div class="container mt-3">
  <h2>Member Register</h2>
  <form action="/member/register" method="post" enctype="multipart/form-data">
    <div class="mb-3 mt-3">
      <label for="email">Email:</label>
      <div class="input-group">
      	<input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
      	<button type="button" class="btn btn-success" id="dupleCheck">중복확인</button>
      </div>
    </div>
    <div class="mb-3">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>    
    <div class="mb-3">
      <label for="nick">Nickname:</label>
      <input type="text" class="form-control" id="nick" placeholder="Enter nickname" name="nickName">
    </div>
    <div class="mb-3">
      <label for="attach">Image Attach:</label>
      <input type="file" class="form-control" style="display: none;"
       id="files" name="fileAttached">
      <div class="d-grid">
      <button type="button" id="attachTrigger"
       class="btn btn-outline-primary btn-block d-block">Attach Image</button>
      </div>
      <div class="my-3" id="fileZone"></div> 
    </div>    
    <button type="submit" class="btn btn-primary" id="regBtn">Submit</button>
  </form>
</div>
<script>
	document.getElementById('attachTrigger').addEventListener('click', () => {
		document.getElementById('files').click();
	});
</script>
<script src="/resources/js/member.register.js"></script>
<script src="/resources/js/product.register.js"></script>
<jsp:include page="../common/footer.jsp" />