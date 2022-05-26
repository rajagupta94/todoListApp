<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="common/navigation.jspf" %>
<html>
<head>
<meta charset="UTF-8">
<title>Add Todo</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
<h4>Add a new task</h4>
		<form:form method="post" modelAttribute="todo">
		<form:hidden path="id"/>
			<fieldset class="form-group">
				<form:label path="desc">Description</form:label> 
				<form:input path="desc" name="desc" type="text"
					class="form-control" required="required"/>
					<form:errors path="desc" cssClass="text-warning" />
				<form:radiobutton path="done" name="done" value="true"/>Completed
    					<br/>
				<form:radiobutton path="done" name="done" value="false"/>In Progress
    					
			</fieldset>

			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>