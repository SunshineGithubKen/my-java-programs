<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.EmployeeBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
List<EmployeeBean> employees = (ArrayList<EmployeeBean>) request.getAttribute("employees");
	List<String> errorMessages = (ArrayList<String>) request.getAttribute("errorMessages");
	List<String> messages = (ArrayList<String>) request.getAttribute("messages");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報管理ツール</title>
<link rel="stylesheet" href="./css/common.css">
</head>
<body>

<h2>社員一覧</h2>

<form method="get" action="./add" >
<input type="submit" value="社員の新規追加登録">

</form>
<hr>
<%
if( errorMessages != null ) {
%>
<ul>
	<%
	for(String errorMessage : errorMessages){
	%>
	<li class="error"><%=errorMessage%></li>
	<%
	}
	%>
</ul>
<%
}
%>
<%
if( messages != null ) {
%>
<ul>
	<%
	for(String message : messages){
	%>
	<li class="success"><%=message%></li>
	<%
	}
	%>
</ul>
<%
}
%>
	<%
	if ((employees != null) && (employees.size() > 0)) {
	%>
	<table border="1">
	<thead>
		<tr>
			<th>操作</th>
			<th>社員ID</th>
			<th>名前</th>
			<th>部署名</th>

		</tr>
		</thead>
		<tbody>
  <%
  for(EmployeeBean employee : employees){
  %>
		<tr>
	        <td>
				<form method="get" action="./edit">
					<input type="hidden" name="id" value="<%= employee.getId() %>">
					<input type="hidden" name="action" value="edit">
					<input type="submit" value="編集">
				</form>
				<form method="get" action="./imageupdate">
					<input type="hidden" name="id" value="<%= employee.getId() %>">
					<input type="hidden" name="action" value="edit">
					<input type="submit" value="画像の編集">
				</form>
				<form method="post" action="./delete">
					<input type="hidden" name="id" value="<%= employee.getId() %>">
					<input type="hidden" name="action" value="delete">
					<input type="submit" value="削除">
				</form>
			</td>
	        <td><%= employee.getId() %></td>
	        <td><%= employee.getName() %></td>
	        <td><%= employee.getDepartment() %></td>

		</tr>
  <% } %>
       </tbody>
	</table>
<%} else{ %>
	<p>登録された「社員データ」はまだありません。</p>
	  <% } %>
</body>
</html>