<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link  rel="stylesheet" href="<c:url value='/static/css/hello.css'  />"    /> 
</head>
<body>
    
    <h1>${name}</h1>
    <p> ${hello} </p>
    <p>tien dep trai</p>
    <p> test reload123</p>
</body>
</html>