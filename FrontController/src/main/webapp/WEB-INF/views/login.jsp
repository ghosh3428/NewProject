<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url var="css" value="/rs/css" />
<spring:url var="js" value="/rs/js" />
<spring:url var="images" value="/rs/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Online shopping website">
<meta name="author" content="Debabrato Ghosh">
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Datatables  CSS -->
<link href="${css}/jquery.dataTables.css" rel="stylesheet">
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myStyle.css" rel="stylesheet">


</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top navbar-dark bg-dark" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<a class="navbar-brand" href="${contextRoot}/home">Online
					Shopping</a>
			</div>
		</div>
	</nav>
	<br/>
	<div class="wrapper">
		<div class="content">

			<div class="container">
				<c:if test="${not empty message}">
					<div class="row">
						<div class="offset-md-3 col-md-6">
							<div class="alert alert-danger fade-in">${message}</div>
						</div>
					</div>
				</c:if>
				<c:if test="${not empty logout}">
					<div class="row">
						<div class="offset-md-3 col-md-6">
							<div class="alert alert-success fade-in">${logout}</div>
						</div>
					</div>
				</c:if>
				<div class="row">

					<div class="offset-md-3 col-md-6">

						<div class="card ">

							<div class="card-heading bg-success text-light">
								<h1 class="text-center text-light">Login</h1>
							</div>

							<div class="card-body">
								<form action="${contextRoot}/login" method="POST"
									class="form-horizontal" id="loginForm">

									<div class="form-group row">
										<label for="username" class="col-md-4 control-label text-primary">Email:
										</label>
										<div class="col-md-8">
											<input type="text" name="username" id="username"
												class="form-control" />
										</div>
									</div>
									<div class="form-group row">
										<label for="password" class="col-md-4 control-label">Password:
										</label>
										<div class="col-md-8">
											<input type="password" name="password" id="password"
												class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<div class="offset-md-4 col-md-8">
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" /> <input type="submit"
												value="Login" class="btn btn-primary" />
										</div>
									</div>
								</form>

							</div>
							<div class="card-footer">
								<div class="text-right">
									New User - <a href="${contextRoot}/register">Register Here</a>
								</div>
							</div>

						</div>

					</div>

				</div>

			</div>
		</div>
	</div>



	<!-- JQuery core JavaScript -->
	<script src="${js}/jquery.min.js"></script>

	<!-- Bootstrap core JavaScript -->
	<script src="${js}/bootstrap.min.js"></script>

	<!-- Datatables JavaScript -->
	<script src="${js}/jquery.dataTables.js"></script>
	<script src="${js}/dataTables.bootstrap.js"></script>
	<script src="${js}/bootbox.min.js"></script>
	<!-- DCustom JavaScript -->
	<script src="${js}/myscript.js"></script>
</body>

</html>

