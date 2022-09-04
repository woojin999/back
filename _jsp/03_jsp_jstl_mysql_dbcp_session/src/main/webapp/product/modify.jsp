<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>

<div class="container mt-3">
<h2>Emp Modify</h2>
  <form action="./update.pd" method="post">
    <div class="mb-3 mt-3">
      <label for="pno" class="form-label">Pno:</label> <input
        type="text" class="form-control" id="pno" value="${pvo.pno }"
        name="pno" readonly>
    </div>    
    <div class="mb-3 mt-3">
      <label for="pname" class="form-label">Pname:</label> <input
        type="text" class="form-control" id="pname" value="${pvo.pname }"
        name="pname">
    </div> 
    <div class="mb-3 mt-3">
      <label for="price" class="form-label">Price:</label> <input
        type="text" class="form-control" id="price" value="${pvo.price }"
        name="price">
    </div>
    <div class="mb-3 mt-3">
      <label for="madeby" class="form-label">Madeby:</label> <input
        type="text" class="form-control" id="madeby" value="${pvo.madeby }"
        name="madeby">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>

<jsp:include page="../footer.jsp"/>