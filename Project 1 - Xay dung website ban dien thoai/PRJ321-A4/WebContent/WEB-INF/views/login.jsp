<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Header -->
<c:import url="header.jsp">
	<c:param name="title" value="Login" />
</c:import>
<!-- Body -->
<div class="container">
		<div class="jumbotron border border-primary">
			<div class="row">
				<div class="col-md-6 bg-white ">
					<div class="card-header text-center display-3">Sign in</div>
					<h5> <c:out value="${message}"></c:out></h5>
					<div class="card-body">	
						<form action="login" method="post">
							<div class="form-group">
								<label for="username" class="form-label">Email</label>
								<input type="text" name="email" id="username" class="form-control"
									placeholder="Enter Your Email" value="<c:out value="${inputInfo.email}"></c:out>"/>
							</div>
							<div class="form-group">
								<label for="input-password" class="form-label">Password</label>
								<input type="text" name="password" id="input-password" class="form-control"
									placeholder="Enter Your Password" value="<c:out value="${inputInfo.password}"></c:out>"/>
							</div>
							<button type="submit" class="btn btn-primary">Login</button>
						</form>
		
					</div>
					<div class="d-flex justify-content-between bg-light">
						<div class="p-2">
							<button class="btn btn-danger btn-md">Cancel</button>
							
						</div>
						<div class="p-2">
							<p>
								Forgot <a href="">password?</a>
							</p>
						</div>
					</div>
				</div>	
				<div class="col-md-6 bg-dark  text-center  text-white my-auto ">
					<h1 class="display-3">Welcome Back</h1>
					<h1>To keep connected with us please login with your personal info</h1>
				</div>
			</div>
		</div>
	</div>
<!-- footer -->
<c:import url="footer.jsp"></c:import>
