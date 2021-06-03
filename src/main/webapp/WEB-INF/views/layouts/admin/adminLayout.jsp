<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/static/admin/" var="styleUrl" />

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
	href="${styleUrl}plugins/fontawesome-free/css/all.min.css">

<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">

<!-- Tempusdominus Bootstrap 4 -->
<link rel="stylesheet"
	href="${styleUrl }plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">

<!-- iCheck -->
<link rel="stylesheet"
	href="${styleUrl }plugins/icheck-bootstrap/icheck-bootstrap.min.css">

<!-- JQVMap -->
<link rel="stylesheet" href="${styleUrl }plugins/jqvmap/jqvmap.min.css">

<!-- Theme style -->
<link rel="stylesheet" href="${styleUrl }dist/css/adminlte.min.css">

<!-- overlayScrollbars -->
<link rel="stylesheet"
	href="${styleUrl }plugins/overlayScrollbars/css/OverlayScrollbars.min.css">

<!-- Daterange picker -->
<link rel="stylesheet"
	href="${styleUrl }plugins/daterangepicker/daterangepicker.css">

<!-- summernote -->
<link rel="stylesheet"
	href="${styleUrl }plugins/summernote/summernote-bs4.min.css">
</head>
<body class=" layout-fixed layout-navbar-fixed">

	<div class="wrapper">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>


	<!-- 
	  <script src="${styleUrl }plugins/jquery/jquery.min.js"></script>

	   <script src="${styleUrl }plugins/jquery-ui/jquery-ui.min.js"></script>
	-->

	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<!--
	<script>
		$.widget.bridge('uibutton', $.ui.button)
	</script> 
	 -->

	<!-- Bootstrap 4 -->
	<script src="${styleUrl }plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- ChartJS -->
	<script src="${styleUrl }plugins/chart.js/Chart.min.js"></script>

	<!-- Sparkline -->
	<script src="${styleUrl }plugins/sparklines/sparkline.js"></script>

	<!-- JQVMap -->
	<script src="${styleUrl }plugins/jqvmap/jquery.vmap.min.js"></script>
	<script src="${styleUrl }plugins/jqvmap/maps/jquery.vmap.usa.js"></script>

	<!-- jQuery Knob Chart -->
	<script src="${styleUrl }plugins/jquery-knob/jquery.knob.min.js"></script>

	<!-- daterangepicker -->
	<script src="${styleUrl }plugins/moment/moment.min.js"></script>
	<script src="${styleUrl }plugins/daterangepicker/daterangepicker.js"></script>

	<!-- Tempusdominus Bootstrap 4 -->
	<script
		src="${styleUrl }plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>

	<!-- Summernote -->
	<script src="${styleUrl }plugins/summernote/summernote-bs4.min.js"></script>

	<!-- overlayScrollbars -->
	<script
		src="${styleUrl }plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>

	<!-- AdminLTE App -->
	<script src="${styleUrl }dist/js/adminlte.js"></script>

	<!-- AdminLTE for demo purposes -->
	<script src="${styleUrl }dist/js/demo.js"></script>

	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<!-- <script src="${styleUrl }dist/js/pages/dashboard.js"></script> -->
</body>
</html>