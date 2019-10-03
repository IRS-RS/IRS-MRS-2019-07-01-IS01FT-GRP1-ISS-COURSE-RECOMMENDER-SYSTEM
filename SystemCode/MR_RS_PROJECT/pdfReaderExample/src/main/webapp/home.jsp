<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Landing Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
<header>
ISS Course Recommender
</header>
<br>
<br>
<form method="post" action="response" enctype="multipart/form-data">
<div id="form">
<fieldset>
<legend>Upload Your Resume:</legend>
<input type="file" name="file" id="file">
<label for="file" id="files">Upload Resume:</label>
<p id="filename"></p>
<br>
<input type="submit" value="Evaluate" id="Evaluate">
</fieldset>
</div>
</form>
<br>

<form method="post" action="ParentCourse">
<div class="form">
<fieldset>
<legend>Fill Form Manually</legend>
<input type="submit" value="Explore Courses">
</fieldset>
</div>
</form>
<footer>
</footer>
<script type="text/javascript" src="javascript/home.js"></script>
</body>

</html>