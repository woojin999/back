<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp" />
<jsp:include page="../nav.jsp" />
<div class="container mt-3">
	<form action="./insert.em" method="post">
		<div class="mb-3 mt-3">
			<label for="empno" class="form-label">Empno:</label> <input
				type="text" class="form-control" id="empno"
				placeholder="Enter empno" name="empno">
		</div>
		<div class="mb-3">
			<label for="pwd" class="form-label">Password:</label> <input
				type="password" class="form-control" id="pwd"
				placeholder="Enter password" name="pwd">
		</div>
		<div class="mb-3 mt-3">
      <label for="ename" class="form-label">Ename:</label> <input
        type="text" class="form-control" id="ename"
        placeholder="Enter ename" name="ename">
    </div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
<jsp:include page="../footer.jsp" />