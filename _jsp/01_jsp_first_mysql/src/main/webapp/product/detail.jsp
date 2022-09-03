<%@page import="domain.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Detail</title>
</head>
<%
	ProductVO pvo = (ProductVO)request.getAttribute("pvo");
%>
<body>
	<table border="1">
		<tr>
			<th>PNO</th>
			<td><%=pvo.getPno() %></td>
		</tr>
		<tr>
			<th>PNAME</th>
			<td><%=pvo.getPname() %></td>
		</tr>
		<tr>
			<th>PRICE</th>
			<td><%=pvo.getPrice() %></td>
		</tr>
		<tr>
			<th>REGDATE</th>
			<td><%=pvo.getRegdate() %></td>
		</tr>
		<tr>
			<th>MADE BY</th>
			<td><%=pvo.getMadeby() %></td>
		</tr>
	</table>
	<h2></h2>
	  <form method="post" action="member.jsp">
    <select name="key">
    <option value="pno">pno</option>
    <option value="pname">pname</option>
    <option value="price">price</option>
    <option value="regdate">regdate</option>
    <option value="madeby">madeby</option>
    <br><br>
  </select>
        <input type="text" name="name">
        <input type="submit" value="검색하기">
    </form>
	<h3><a href="./edit.pd?pno=<%=pvo.getPno()%>">Product Modify</a></h3>
	<h3><a href="">Product Remove</a></h3>
</body>
</html>