<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<c:set var="pvo" value="${pdto.pvo }"/>
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
			<th>ReadCount</th>
			<td>${pvo.readCount }</td>
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
	<div class="d-flex mb-3">
	<c:forEach items="${pdto.fileList }" var="fvo">
	<c:choose>
		<c:when test="${fvo.fileType == 1 }">
			<div class="p-2 flex-fill bg-info">
			<img class="th_img"
			 src="/upload/${fn:replace(fvo.saveDir,'\\','/')}/${fvo.uuid }_th_${fvo.fileName } ">
			</div>	
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
    </c:forEach>
  	</div>
	<ul class="nav justify-content-center">
    <li class="nav-item">
      <a class="nav-link" href="/product/list?pageNo=${pgvo.pageNo }&qty=${pgvo.qty}&type=${pgvo.type}&kw=${pgvo.kw}">List</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/product/modify?pno=${pvo.pno }&pageNo=${pgvo.pageNo }&qty=${pgvo.qty}&type=${pgvo.type}&kw=${pgvo.kw}">Modify</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" id="productRemove">Remove</a>
    </li>    
  </ul>
  <form action="" id="productRmForm" style="display: none;" method="post">
  	<input type="hidden" id="pno" value="" name="pno">  	
  	<input type="hidden" value="${pgvo.pageNo }" name="pageNo">  	
  	<input type="hidden" value="${pgvo.qty }" name="qty"> 
  	<input type="hidden" value="${pgvo.type }" name="type"> 	
  	<input type="hidden" value="${pgvo.kw }" name="kw"> 	
  </form>
</div>

<!-- image Modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal2" id="modalBtn2" style="display:none;">
    Open modal
  </button>
<div class="modal" id="myModal2">
  <div class="modal-dialog modal-xl" style="position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%);">
    <div class="modal-content" style="background-color:rgba(0,0,0,0); border:0;" id="modalZone2">
    </div>
  </div>
</div>

<!-- Button to Open the Modal -->
<button type="button" style="display:none;" id="modalBtn" 
class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">
  Open modal
</button>
<!-- The Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Modal Heading</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        Modal body..
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-success modSbmBtn" data-cno="">Submit</button>
      </div>

    </div>
  </div>
</div>
<div class="container mt-3">
  <h2>Comment</h2>
    <div class="input-group mb-3">
      <span class="input-group-text" id="cmtWriter">
      <sec:authorize access="isAuthenticated()">
      	<sec:authentication property="principal.mvo.email" var="authEmail"/>
      	${authEmail }
      </sec:authorize>
      </span>
      <input type="text" class="form-control" placeholder="Add Comment" id="cmtText">
    	<button type="button" class="btn btn-primary" id="cmtSbmBtn">ADD</button>
    </div>   
  <table class="table table-striped" id="cmtZone"></table>
  <div class="text-center" style="visibility: hidden;">  	
  	<button type="button" data-page="1"
  	 id="moreBtn" class="btn btn-outline-secondary">
  	MORE +
  	</button>
  </div>
</div>
<script src="/resources/js/product.detail.js"></script>
<script src="/resources/js/product.comment.js"></script>
<script>
document.addEventListener('DOMContentLoaded', function(){
	getCommentList(document.getElementById('pnoVal').innerText);
	if(document.getElementById('cmtWriter').innerText == ''){
		document.getElementById('cmtText').disabled = true;
		document.getElementById('cmtSbmBtn').classList.add("disabled");
	}
});
</script>
<jsp:include page="../common/footer.jsp" />