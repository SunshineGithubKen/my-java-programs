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
	String department = employee.getDepartment();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報管理ツール</title>
<link rel="stylesheet" href="./css/common.css">
</head>
<body>
<h2>社員の登録情報の編集</h2>
<a href="./employeelist">社員一覧へ</a>　
<a href="./add">社員の新規追加登録へ</a>　
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
	<form method="post" action="./edit" enctype="multipart/form-data">
	<input type="hidden" name="action" value="edit">
		<dl>
			<dt>名前：</dt>
			<dd><input type="text" name="name" value="<%= employee.getName() %>"></dd>
			<dt>年齢：</dt>
			<dd><input type="text" name="age" value="<%= employee.getAge() %>"></dd>
			<dt>性別：</dt>
			<dd>
				<input type="radio" name="gender" value="男性" ${ employee.getGender() == "男性" ? "checked" : "" }> 男性　
				<input type="radio" name="gender" value="女性" ${ employee.getGender() == "女性" ? "checked" : "" }> 女性　
			</dd>
			<dt>住所：</dt>
			<dd><input type="text" name="address" value="<%= employee.getAddress() %>"></dd>
			<dt>所属：</dt>
			<dd><%= department %>
				<select name="department">
<% for(String value : departments) { %>
	<% if (value.equals(department)) { %>
			      	<option selected><%= value %></option>
	<% } else { %>
			      	<option><%= value %></option>
	<% } %>
<% } %>
				</select>
			</dd>

		</dl>
		<input type="hidden" name="id" value="<%= employee.getId() %>">
		<input type="hidden" name="action" value="edit">
		<input type="submit" value="更新">
	</form>
</body>
</html>