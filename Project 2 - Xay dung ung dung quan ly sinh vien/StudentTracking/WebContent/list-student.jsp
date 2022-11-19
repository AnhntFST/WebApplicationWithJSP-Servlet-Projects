<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
	 	<h2>List Student</h2>
	</div>
</div>

	<div id="container">
		<div id="content">
		<input type="button" value="Add Student"
			   onclick="window.location.href='ad-student-form.jsp'; return false"
			   class ="add-student-button"
		>
		  <!--  add a search box -->
            <form action="student" method="GET">
        
                <input type="hidden" name="command" value="SEARCH" />
            
                Search student: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-student-button" />
            
            </form>
			<table border="1">
				<tr>

					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="student" items="${LIST_STUDENT}">
					<c:url var="tempLink" value="student">
						<c:param name="command" value="LOAD"></c:param>
						<c:param name="id" value="${student.id}"></c:param>
					</c:url>
					<c:url var="deleteLink" value="student">
						<c:param name="command" value="DELETE"></c:param>
						<c:param name="id" value="${student.id}"></c:param>
					</c:url>
					<tr>

						<td><c:out value="${student.firstName}" /></td>
						<td><c:out value="${student.lastName}" /></td>
						<td><c:out value="${student.email}" /></td>
						<td>
							<a href="${tempLink}">UPDATE</a>|
							<a href="${deleteLink}">DELETE</a>
						</td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
</body>
</html>