<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.EmployeeBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
     List<String> departments = (List<String>) request.getAttribute("departments");
	List<String> errorMessages = (ArrayList<String>) request.getAttribute("errorMessages");
	List<String> messages = (ArrayList<String>) request.getAttribute("messages");
	EmployeeBean employee = (EmployeeBean) request.getAttribute("employee");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報管理ツール</title>
<link rel="stylesheet" href="./css/common.css">
</head>
<body>
<h2>社員情報　新規登録</h2>
<a href="./employeelist">社員一覧へ</a>　
<hr>
<% if( errorMessages != null ) { %>
<ul>
	<% for(String errorMessage : errorMessages){ %>
	<li class="error"><%= errorMessage %></li>
	<% } %>
</ul>
<% } %>
<% if( messages != null ) { %>
<ul>
	<% for(String message : messages){ %>
	<li class="success"><%= message %></li>
	<% } %>
</ul>
<% } %>
	<form method="post" action="./add" enctype="multipart/form-data">
		<dl>
			<dt>名前：</dt>
			<dd><input type="text" name="name" value=""></dd>
			<dt>年齢：</dt>
			<dd><input type="text" name="age" value=""></dd>
			<dt>性別：</dt>
			<dd>
				<input type="radio" name="gender" value="男性"> 男性　
				<input type="radio" name="gender" value="女性"> 女性　
			</dd>
			<dt>住所：</dt>
			<dd><input type="text" name="address" value=""></dd>
			<dt>所属：</dt>
			<dd>
				<select name="department">

  <c:forEach var="value" items="${departments}">
			      	<option><c:out value="${value}" /></option>
  </c:forEach>
				</select>
			</dd>
			<dt>画像：</dt>
			<dd>
				<input type="file" name="image" value="">
			</dd>
		</dl>
		<input type="hidden" name="action" value="add">
		<input type="submit" value="登録">
	</form>
</body>
</html>