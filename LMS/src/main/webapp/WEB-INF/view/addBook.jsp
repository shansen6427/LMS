<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add Book</title>
</head>
<body>

<form action="saveBook" method="post">
	<input type="hidden" name="method" value="addBook" />
	Title: <input type="text" name="title" value="${book.title}"/><br/>
	Author: <form:select path="book.author.authorId" 
					items="${authorMap}"></form:select><br/>
	Publisher: <form:select path="book.publisher.publisherId" 
					items="${publisherMap}"></form:select><br/>
	
	<input type="submit" />	
</form>

</body>
</html>