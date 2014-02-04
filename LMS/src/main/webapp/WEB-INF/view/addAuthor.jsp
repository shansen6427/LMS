<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- saved from url=(0043)http://jquery.bassistance.de/validate/demo/ -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>Add Author</title>

<script src="js/jquery.js"></script>
<script src="js/jquery-1.9.0.js"></script>
<script src="js/jquery.validate.js"></script>

<script>
$().ready(function() {
	$("#authorForm").validate({
			rules: {
					authorName: {
						 required: true
					}
				},
			messages: {
				authorName: "Please give a valid Author", 
			}			
	});
});
</script>

</head>
<body>

<form id="authorForm" method="post" action="saveAuthor" novalidate="novalidate">
	<input type="hidden" value="addAuthor" name="method" />
	Author Name: <input type="text" id="authorName" name="authorName" required 
						value="${auth.authorName}"/><br/>
	<input type="submit" value="Submit"/>	
</form>

</body></html>