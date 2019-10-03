<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course Stream Selection</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/displaycourses.css">
</head>
<body>
<header>
ISS Course Recommender
</header>
<br>
<br>
<form action="/details" method="post">
<fieldset>
<span id="career"> Career-Start-in</span> 
<select name="options" id="options">
<c:forEach var="courses" items="${course}">
<option value="${courses.id}">${courses.name}</option>
</c:forEach>
<option value=10 selected>All Courses</option>
</select>
<input  type="submit" name="submit" type="submit" value="Search Courses"/>
</fieldset>
</form>
<br>
<fieldset id="fieldsetoptions">
<h3 id="fieldseth3"></h3>
<h4 id="fieldseth4"></h4>
<p id="fieldsetp"></p>
<script type="text/javascript" src="javascript/displaycourses.js"></script>
</fieldset>
</body>
</html>