<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/add-student-style.css">
<title>Add-student-form</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>List Student</h2>
		</div>
	</div>

	<div id="container">
		<h2>Add Student</h2>
		<form action="student" method="get">
			<input type="hidden" name="command" value="ADD">
			<table>
				<tbody>
					<tr>
						<td><lable>First Name: </lable></td>
						<td><input type="text" name="firstName" /></td>
					</tr>
					<tr>
						<td><lable>Last Name: </lable></td>
						<td><input type="text" name="lastName" /></td>
					</tr>
					<tr>
						<td><lable>Email: </lable></td>
						<td><input type="text" name="email" /></td>
					</tr>
					<tr>
						<td><lable></lable></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form>

		<div sytle="clear:both;"></div>
		<p>
			<a href="student">Back to list</a>
		</p>
	</div>
</body>
</html>