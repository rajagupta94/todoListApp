<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="common/navigation.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<title>Todo's List</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container">
<h2>${username}'s Todo List</h2>

	<table class="table table-striped">
		<caption>Task list</caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Updated Date</th>
				<th>Is Completed?</th>
				<th>Action</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${todos}" var="todo">
			<tr>
				<td>${todo.desc}</td>
				<td>${todo.targetDate}</td>
				<td>${todo.done}</td>
				<td><a type="button" class="btn btn-warning" href="${pageContext.request.contextPath}/delete-todo?id=${todo.id}">Delete</a>
				<a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/update-todo?id=${todo.id}">Update</a>
				</td>
			</tr>
			</c:forEach>
			
		</tbody>
	</table>

	<div><a class="button" href="${pageContext.request.contextPath}/add-todo">Add Todo</a></div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
</body>
</html>