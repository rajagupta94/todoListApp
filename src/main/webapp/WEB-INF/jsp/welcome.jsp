<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="common/navigation.jspf" %>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container"><h3>Welcome <b>'${username}'</b>> user ! Manage your <a href='${pageContext.request.contextPath}/list-todos'>Todos</a> here.</h3></div>


</body>
</html>