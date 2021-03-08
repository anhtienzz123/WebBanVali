<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/static/admin/"  var="styleUrl"    />

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- Google Font: Source Sans Pro -->
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
		
	<!-- Font Awesome -->
	<link rel="stylesheet"
		href="${styleUrl }plugins/fontawesome-free/css/all.min.css">
		
	<!-- icheck bootstrap -->
	<link rel="stylesheet"
		href="${styleUrl }plugins/icheck-bootstrap/icheck-bootstrap.min.css">
		
	<!-- Theme style -->
	<link rel="stylesheet" href="${styleUrl }dist/css/adminlte.min.css">
</head>
<body class="hold-transition login-page register-page">

	<div class="login-box">
	   <tiles:insertAttribute name="body" />
	</div>


	<!-- jQuery -->
	<script src="${styleUrl }plugins/jquery/jquery.min.js"></script>
	
	<!-- Bootstrap 4 -->
	<script src="${styleUrl }plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	
	<!-- AdminLTE App -->
	<script src="${styleUrl }dist/js/adminlte.min.js"></script>
</body>
</html>