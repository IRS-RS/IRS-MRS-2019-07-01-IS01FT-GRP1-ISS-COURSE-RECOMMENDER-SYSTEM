<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Information</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/personalInfo.css">
</head>
<body>
<header>
ISS Course Recommender
</header>
<br>
<br>
<div class="container">
<form method="post" action="recommendCourses" enctype="multipart/form-data">
<div id="form">
<fieldset>
<legend>Personal Information:</legend>
<label for="fname">Name</label>
<input type="text" id="fname" name="firstname" placeholder="First Name" value="${user.name}">
<label for="email">Email</label>
<input type="text" id="email" name="email" placeholder="Email Id" value="${user.email}">
<label for="Age">Age</label>
<input type="Number" id="Age" name="Age" min="18" max="100" required>
<label for="nationality" id="N">Nationality</label>
<div id="nationality">
<input type="radio" name="Nationality" value="Foriegner" id="Foriegner">Foreigner
<input type="radio" name="Nationality" value="PR" id="PR">PR
<input type="radio" name="Nationality" value="Citizen" id="Citizen">Citizen
</div>
<br>
<label for="fee" id="F">Fee Funding</label>
<div id="fee">
<input type="radio" name="fee" value="Self" id="Self">Self
<input type="radio" name="fee" value="CS" id="CS">Company Sponsored
</div>
<br>

<label for="Subsidry" id="S">Subsidiary</label>
<div id="Subsidry">
<div id="Subsidry-S">
<input type="radio" name="Subsidry-S" value="SFMCES">Skills Future Mid-Career Enhanced Subsidy
<input type="radio" name="Subsidry-S" value="WTS">Workfare Training Support
</div>
<div id="Subsidry-C">
<input type="radio" name="Subsidry-C" value="SFMCES">Skills Future Mid-Career Enhanced Subsidy
<input type="radio" name="Subsidry-C" value="WTS">Workfare Training Support
</div>
</div>
</fieldset>
</div>
<div id="form">
<fieldset>
<legend>Professional Information:</legend>
<label for="WE">Work Experience</label>
<input type="number" id="WE" name="Work Experience" min="0" max="60" value="${user.workExperience}">
<label for="KP">Key Positions Held</label>
<textarea id="KP" name="Key Positions Held" placeholder="Developer, Manager,CTO,CIO...." style="height:60px">${user.keyPositions}</textarea>
<label for="TechSkills">Technical Skills</label>
<textarea id="TechSkills" name="Technical Skills" placeholder="Programming,Web Development,Python...." style="height:60px">${user.technicalSkills}</textarea>
</fieldset>
</div>

<div id="form">
<fieldset>
<legend>Educational Information:</legend>
<label for="HL">Degree Held</label>
<input type="text" id="HL" name="Degree Held" placeholder="Bachelors of Science" value="${user.degree}">
</fieldset>
</div>

<br>
<input type="Submit" value="Submit" style="width:200px">
</form>
</div>
<br>
<footer>
<script type="text/javascript" src="javascript/personalinfo.js"></script>
</footer>
</body>
</html>
