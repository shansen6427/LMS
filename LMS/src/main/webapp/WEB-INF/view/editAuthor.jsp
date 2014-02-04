<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- saved from url=(0043)http://jquery.bassistance.de/validate/demo/ -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>Edit/Delete Author</title>

<script>
</script>

</head>
<body>

<table border=1>
	<tr>
		<td>Author Id</td>
		<td>Author Name</td>
		<td>Edit</td>
		<td>Delete</td>
	</tr>

	<c:forEach items="${authors}" var="auth" varStatus="loop">
	<tr>
		<td>${auth.authorId}</td>
		<td>${auth.authorName}</td>
		<td><a href="editThisAuthor?authId=${auth.authorId}">Edit</a></td>
		<td><a href="deleteThisAuthor?authId=${auth.authorId}">Delete</a></td>
	</tr>
	</c:forEach>

</table>

</body></html>