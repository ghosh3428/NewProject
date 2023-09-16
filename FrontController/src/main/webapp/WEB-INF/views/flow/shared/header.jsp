<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


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

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>


</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	
		<a class="navbar-brand" href="${flowExecutionUrl}&_eventId=home" >Online Shopping</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
</nav>