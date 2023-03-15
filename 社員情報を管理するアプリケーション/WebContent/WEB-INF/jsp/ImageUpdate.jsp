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
<h2>画像の編集</h2>
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
	<form method="post"  action="./imageupdate"  enctype="multipart/form-data"> 　　 <%-- jspからサーブレットに、画像を送るには、formタグで、"enctype=multipart/form-data"  --%>
	<input type="hidden"  name="action"  value="update">
		<dl>
			<dt>画像：</dt>
			<dd>
				<img src="./uploads/<%= employee.getImage() %>"><br>
				<input type="file" name="image" value="<%= employee.getImage() %>">
				<input type="hidden" name="oldImage" value="<%= employee.getImage() %>">
			</dd>

		</dl>
		<input type="hidden" name="id" value="<%= employee.getId() %>">
		<input type="hidden" name="action" value="update">
		<input type="submit" value="更新">
	</form>
</body>
</html>