<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp" />

<!-- Header -->
<header class="ex-header">
  <div class="container py-5">
    <div class="row">
      <div class="col-xl-10 offset-xl-1">
        <h1 class="text-center">회원 가입</h1>
      </div>
      <!-- end of col -->
    </div>
    <!-- end of row -->
  </div>
  <!-- end of container -->
</header>
<!-- end of ex-header -->
<!-- end of header -->


<!-- Basic -->
<div class="ex-form-1 pt-1 pb-5">
  <div class="container">
    <div class="row">
      <div class="col-xl-6 offset-xl-3">
        <div class="text-box mt-1 mb-5">
        

          <!-- Sign Up Form -->
          <form action="/mem/register" method="post">
            <div class="mb-4 form-floating">
              <input type="email" class="form-control" id="floatingInput"
                placeholder="name@example.com" name="email" required> <label
                for="floatingInput">Email</label>
            </div>
            <div class="mb-4 form-floating">
              <input type="password" class="form-control" id="floatingPassword"
                placeholder="Password" name="pwd" required> <label for="floatingPassword">Password</label>
            </div>
            <div class="mb-4 form-floating">
              <input type="text" class="form-control" id="floatingInput2" name="name"
                placeholder="Your Nick Name" required> <label for="floatingInput">Name</label>
            </div>
            <div class="mb-4 form-floating">
              <input type="text" class="form-control" id="floatingInput2" name="phone"
                placeholder="phone" required> <label for="floatingInput">phone</label>
            </div>
            <div class="mb-4 form-floating">
              <input type="text" class="form-control" id="floatingInput2" name="address"
                placeholder="address" required> <label for="floatingInput">address</label>
            </div>
          
            <button type="submit" class="btn btn-success text-white mt-4">회원가입
              </button>
          </form>
          <!-- end of sign up form -->

        </div>
        <!-- end of text-box -->
      </div>
      <!-- end of col -->
    </div>
    <!-- end of row -->
  </div>
  <!-- end of container -->
</div>
<!-- end of ex-basic-1 -->
<!-- end of basic -->

<jsp:include page="../footer.jsp" />
















