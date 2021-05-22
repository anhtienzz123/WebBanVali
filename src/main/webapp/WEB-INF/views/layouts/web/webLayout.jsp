<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<c:url value="/static/web/" var="styleUrl" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Web</title>

<link rel="stylesheet" href="${styleUrl }bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="${styleUrl }css/main.css">
</head>
<body class="bg-light">

	<div>
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>



	<script src="${styleUrl }bootstrap/bootstrap.bundle.min.js">
		
	</script>
	<script src="https://kit.fontawesome.com/c44a1ab3b1.js"
		crossorigin="anonymous"></script>
</body>
</html>