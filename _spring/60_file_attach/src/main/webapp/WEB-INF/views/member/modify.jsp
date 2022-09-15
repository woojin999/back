<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<div class="container mt-5">
	<h1>Member Modify</h1>
	<form action="/member/modify" method="post" enctype="multipart/form-data">
		<div class="mb-3 mt-3">
			<label for="email">Email:</label> <input type="email"
				class="form-control" id="email" placeholder="Enter email"
				name="email" value="${mdto.mvo.email }" readonly>
		</div>
		<div class="mb-3">
			<label for="pwd">Password:</label> <input type="password"
				class="form-control" id="pwd" placeholder="Enter password"
				name="pwd" value="${mdto.mvo.pwd }">
		</div>
		<div class="mb-3">
			<label for="nick">Nickname:</label> <input type="text"
				class="form-control" id="nick" placeholder="Enter nickname"
				name="nickName" value="${mdto.mvo.nickName}">
		</div>
		<c:if test="${ses.grade == 99 }">
			<div class="mb-3">
				<label for="grade">Grade:</label> <input type="text"
					class="form-control" id="grade" placeholder="Enter grade"
					name="nickName" value="${mdto.mvo.grade}">
			</div>
		</c:if>
		<div class="mb-3">
      <label for="attach">File Attach:</label>
      <input type="file" class="form-control" style="display: none;"
       id="files" name="fileAttached" multiple>
      <div class="d-grid">
      <button type="button" id="attachTrigger"
       class="btn btn-outline-primary btn-block d-block">Attach Files</button>
      </div>
      <div class="my-3" id="fileZone"></div> 
    </div>
		<button type="submit" class="btn btn-primary" id="regBtn">Submit</button>
	</form>
</div>
<hr>
<div class="container mt-3">
  <ul class="list-group list-group-flush">  
    <li class="list-group-item d-flex justify-content-between align-items-center">
    ${mdto.fvo.fileName }
    <span class="badge bg-primary rounded-pill">${mdto.fvo.fileSize }</span>    
    <button data-uuid="${mdto.fvo.uuid }"
     class="btn btn-outline-danger btn-sm fileDelBtn">X</button>
  </li>
  </ul>
</div>
<script>
	document.getElementById('attachTrigger').addEventListener('click', () => {
		document.getElementById('files').click();
	});
</script>
<script src="/resources/js/product.register.js"></script>
<script src="/resources/js/member.modify.js"></script>
<jsp:include page="../common/footer.jsp" />