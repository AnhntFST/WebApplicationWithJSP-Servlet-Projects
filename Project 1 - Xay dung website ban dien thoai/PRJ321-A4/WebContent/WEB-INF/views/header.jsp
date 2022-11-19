<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"  href="/PRJ321-A4/URLToResourcesFolder/css/bootstrap.min.css">
<title>${param.title}</title>
</head>
<body>
<c:set var="username" value="${message}"></c:set>
<div class="jumbotron jumbotron-fluid m-0"  style="background-color: #3C3B3A;">
  <div class="container">
  	 <div class="row">
	   		<div class="col-md-3">
	   			<h1 class="text-white">PRJ321x</h1>
	   			<p class="text-primary">Welcome to my Website</p>
	   			<p class="text-uppercase text-light">${user}</p>
	   		</div>
	   		<div class="col-md-3">
				<select class="custom-select bg-light">
				  <option selected>Categories</option>
				  <option value="1">Iphone 11</option>
				  <option value="2">Iphone X</option>
				  <option value="3">Iphone 8</option>
				</select>
			</div>
			<div class="col-md-6">
				<form class="form-inline my-2 my-lg-0" action="" method="get">
				  <input type ="hidden" name="action" value="SEARCH">
			      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search">
			      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			    </form>
	   		</div>
   	 </div>
  </div>
</div>
<nav class="navbar navbar-expand-sm navbar-light" style="background: #625F5F;">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link  text-warning" href="${pageContext.request.servletContext.contextPath}/">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link  text-white" href="#">Products</a>
      </li>
      <li class="nav-item">
        <a class="nav-link  text-white" href="#">About Us</a>
      </li>
    </ul>
     <span class="navbar-text">
     	<c:choose>
     		<c:when test="${empty username}">
        		<a class="nav-link  text-white" href="#">Sign in</a>
        	</c:when>
        	<c:otherwise>
        		<a class="nav-link  text-white" href="${pageContext.request.servletContext.contextPath}/register?action=logout">Log out</a>
        	</c:otherwise>
        </c:choose>
    </span>
    <span class="navbar-text">
        <a class="nav-link  text-white" href="${pageContext.request.servletContext.contextPath}/loginForm">Login</a>
    </span>
  </div>
</nav>
	<hr class="bg-success mt-1">