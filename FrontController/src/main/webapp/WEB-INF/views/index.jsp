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

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>


</head>

<body>


	<div class="wrapper">
		<!-- Navigation -->
		<%@ include file="./shared/navbar.jsp"%>

		<!-- Content -->
		<c:if test="${userclickhome == true}">
			<%@include file="home.jsp"%>
		</c:if>

		<c:if test="${userclickaboutus == true}">
			<%@include file="aboutus.jsp"%>
		</c:if>

		<c:if test="${userclickcontactus == true}">
			<%@include file="contactus.jsp"%>
		</c:if>
		
		<c:if test="${userclickallactiveproduct == true}">
			<%@include file="product.jsp"%>
		</c:if>
		<c:if test="${userclickcategoryproduct == true}">
			<%@include file="product.jsp"%>
		</c:if>
		
		<c:if test="${userclicksingleproduct == true}">
			<%@include file="singleproduct.jsp"%>
		</c:if>
		
		<c:if test="${userclickmanageproduct == true}">
			<%@include file="manageproduct.jsp"%>
		</c:if>

		<!-- Footer -->
		<%@ include file="./shared/footer.jsp"%>
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

