<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course Schedule</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/courseSchedule.css">
</head>
<body>
<header>
ISS Course Recommender
</header>
<br>
<br>
<p>List of Recommended Courses with their respective Schedule.</p>
<div class="scroll">
<c:forEach var="course" items="${course}" varStatus="status">
<div class="row">
  <div class="column">
    <div class="card">
    <div class="heading">
      <h3>${course.courseName}</h3>
     </div>
     <div class="cardBody">
      <table>
	  <tr>
	  <td><b>Class Name</b></td>
	  <td>${courseSchedule[status.index].className}</td>
	  </tr>
	  <tr>
	  <td><b>Class Time</b></td>
	  <td>${courseSchedule[status.index].classTime}</td>
	  </tr>
	  <tr>
	  <td><b>Start Date</b></td>
	  <td>${courseSchedule[status.index].startDate}</td>
	  </tr>
	  <tr>
	  <td><b>End Date</b></td>
	  <td>${courseSchedule[status.index].endTime}</td>
	  </tr>
	  </table>
     </div> 
    </div>
  </div>
</div>
</c:forEach>
</div>
</body>
</html>