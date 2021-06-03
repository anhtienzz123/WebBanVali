<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng kí</title>

<style type="text/css">
	.error{
		color: red;
	}
</style>
</head>
<body>


	<div class="register-box">
		<div class="card card-outline card-primary">
			<div class="card-header text-center">
				<a href="../../index2.html" class="h1"><b>Đăng</b>Ký</a>
			</div>
			<div class="card-body">
				<p class="login-box-msg">Đăng ký tài khoản mới</p>

                
     
                <c:url value='/dang-ki'  var="urlDangKy" />
				<form:form action="${urlDangKy }" method="post" modelAttribute="nguoiDung"  >
					<div class="input-group mb-3">
					    <form:hidden path="id"/>
						<form:input path="hoTen" type="text" class="form-control" placeholder="Tên của bạn" />
						<form:errors path="hoTen"  />
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-user"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<form:input path="email" name="email" type="email" class="form-control" placeholder="Email" />
						<br /> 
						<form:errors path="email"  cssStyle="error" />
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-envelope"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<form:input path="matKhau" type="password" class="form-control" placeholder="Mật khẩu" />
						<form:errors path="matKhau"  />
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="password" class="form-control"
							placeholder="Nhập lại mật khẩu">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					<div class="row">
						
						<!-- /.col -->
						<div class="col-12" style="text-align: center">
							<button type="submit" class="btn btn-primary btn-block">Đăng ký</button>
						</div>
						<!-- /.col -->
					</div>
				</form:form>


				<a href="login.html" class="text-center">Bạn đã có tài khoản rồi</a>
			</div>
			<!-- /.form-box -->
		</div>
		<!-- /.card -->
	</div>
</body>
</html>