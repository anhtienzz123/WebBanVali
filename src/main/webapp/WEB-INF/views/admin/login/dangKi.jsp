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
					    <form:hidden path="maNguoiDung"/>
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
						<form:errors path="email"  />
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
						<div class="col-8">
							<div class="icheck-primary">
								<input type="checkbox" id="agreeTerms" name="terms"
									value="agree"> <label for="agreeTerms"> I agree
									to the <a href="#">terms</a>
								</label>
							</div>
						</div>
						<!-- /.col -->
						<div class="col-4">
							<button type="submit" class="btn btn-primary btn-block">Đăng ký</button>
						</div>
						<!-- /.col -->
					</div>
				</form:form>

				<div class="social-auth-links text-center">
					<a href="#" class="btn btn-block btn-primary"> <i
						class="fab fa-facebook mr-2"></i> Sign up using Facebook
					</a> <a href="#" class="btn btn-block btn-danger"> <i
						class="fab fa-google-plus mr-2"></i> Sign up using Google+
					</a>
				</div>

				<a href="login.html" class="text-center">Bạn đã có tài khoản rồi</a>
			</div>
			<!-- /.form-box -->
		</div>
		<!-- /.card -->
	</div>
</body>
</html>