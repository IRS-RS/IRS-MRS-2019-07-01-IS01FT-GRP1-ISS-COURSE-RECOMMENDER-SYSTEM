<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/recommendCourse.css">
</head>
<body>
<header>
ISS Course Recommender
</header>
<br>
<br>
<form method="post" action="scheduleCourses"> 
<div class="scrollmenu">
<c:forEach var="course" items="${courses}"> 
<div class="row">
	<div class="column">
		<label for="${course.courseName}">${course.courseName}</label>
		<input type="checkbox" name="checkbox" id="${course.courseName}" value="${course.courseId}" onclick="myFunction(this);">
	</div>
</div>
</c:forEach>
</div>
<br>
<div class="container">
<c:forEach var="course" items="${courses}" varStatus="status"> 
<fieldset id="${course.courseId}">
<span onclick="this.parentElement.style.display='none'" class="closebtn">&times;</span>
<h2>${course.courseName}</h2>
<table>
<tr>
<td><b>Reference No</b></td>
<td>${course.reference}</td>
</tr>
<tr>
<td><b>Duration</b></td>
<td>${course.duration}</td>
</tr>
<tr>
<td><b>Introduction</b></td>
<td>${course.introduction}</td>
</tr>
<tr>
<td><b>Prerequisite</b></td>
<td>${course.prerequisite}</td>
</tr>
<tr>
<td><b>What would you learn!</b></td>
<td>${course.takeAway}</td>
</tr>
<tr>
<td><b>Agenda</b></td>
<td>${course.topicCovered}</td>
</tr>
<tr>
<td><b>Fees(Net)</b></td>
<td>${feenc[status.index]}</td>
<td><b>Fees(Concession)</b></td>
<td>${feec[status.index]}</td>
</tr>
<tr>
<td><b>Exam Fee</b></td>
<td>${ef[status.index]}</td>
</tr>
</table>
</fieldset>
</c:forEach>
</div>
<input type="submit" name="submit">
</form>
<footer>
<script type="text/javascript" src="javascript/recommendCourse.js"></script>
</footer>
</body>
</html>