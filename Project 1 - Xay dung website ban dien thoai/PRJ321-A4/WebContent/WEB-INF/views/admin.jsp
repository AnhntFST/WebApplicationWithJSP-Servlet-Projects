<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"  href="/PRJ321-A4/URLToResourcesFolder/css/bootstrap.min.css">
<title>Admin page</title>
</head>
<!-- Body -->
<div class="container-fluid">
<h5> Welcome <c:out value="${message}"></c:out></h5>
	<div class = "row">
		<div class="col-2 text-center"  style="background-image: url('/PRJ321-A4/URLToResourcesFolder/images/anh-ao-dai-dung.jpg');background-repeat:inherit; background-position: center;background-size: cover; ">
			<h4 class="text-warning">1849 TEAM</h4>
			<div class="d-flex flex-column">
			  <div class="p-2"><a href="">Dashboard</a></div>
			  <div class="p-2"><a href="">Staff Manager</a></div>
			</div>	
		</div>
		
		<div class="col-10">
			<div class="row mb-1 pr-4 " style="background-image: url('/PRJ321-A4/URLToResourcesFolder/images/nha-alpha.jpg');background-repeat:no-repeat	; background-position: center; height: 20rem; width: 100%;">
				<div class="d-inline-flex p-2 ">
					<c:url var="backlink" value="login">
						<c:param name="action" value="LOGOUT"></c:param>
					</c:url>
					<a class="text-danger" href="${backlink}">Log out</a>
				</div>
			</div>
			<div class="row pr-4">
				<div class="col-6">
					<table class="table table-hover table-dark">
					<thead>
					    <tr>
					      <th class="bg-success" colspan="4" scope="col">Members of the team</th>
					    </tr>
					  </thead>
					  <thead>
					    <tr>
					      <th scope="col">ID</th>
					      <th scope="col">Name</th>
					      <th scope="col">Student ID</th>
					      <th scope="col">Class</th>
					    </tr>
					  </thead>
					  <tbody>
					    <tr>
					      <th scope="row">1</th>
					      <td>Member 1</td>
					      <td>Member code1</td>
					      <td>Class 1</td>
					    </tr>
					    <tr>
					      <th scope="row">2</th>
					      <td>Member 2</td>
					      <td>Member code2</td>
					      <td>Class 2</td>
					    </tr>
					    <tr>
					      <th scope="row">3</th>
					      <td>Member 3</td>
					      <td>Member code3</td>
					      <td>Class 3</td>
					    </tr>
					  </tbody>
					</table>
				</div>
					
			</div>
		</div>
	</div>

</div>
<!-- footer -->
<c:import url="footer.jsp"></c:import>
