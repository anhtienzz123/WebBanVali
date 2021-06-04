<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng kí</title>

<style type="text/css">
.error {
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



				<c:url value='/dang-ki' var="urlDangKy" />
				<form:form action="${urlDangKy }" method="post" id="myForm"
					name="myForm" modelAttribute="nguoiDung"
					onsubmit="return(validate());">

					<div class="input-group mb-3">
						<form:hidden path="id" />
						<form:input path="hoTen" type="text" class="form-control"
							placeholder="Tên của bạn" />


						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-user"></span>
							</div>
						</div>


					</div>

					<div class="input-group mb-3">

						<form:errors path="hoTen" />
						<label id="hoTenError" class="error"></label>
					</div>

					<div class="input-group mb-3">
						<form:input path="email" name="email" type="email"
							class="form-control" placeholder="Email" />

						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-envelope"></span>
							</div>
						</div>


					</div>


					<div class="input-group mb-3">
						<form:errors path="email" cssStyle="error" />
						<label id="emailError" class="error"></label>
					</div>



					<div class="input-group mb-3">
						<form:input path="matKhau" type="password" class="form-control"
							placeholder="Mật khẩu" />

						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>


					</div>

					<div class="input-group mb-3">
						<form:errors path="matKhau" />
						<label id="matKhauError" class="error"></label>
					</div>



					<div class="input-group mb-3">
						<input type="password" class="form-control" id="nhapLaiMatKhau"
							name="nhapLaiMatKhau" placeholder="Nhập lại mật khẩu">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>

					<div class="input-group mb-3">

						<label id="nhapLaiMatKhauError" class="error"></label>
					</div>



					<div class="row">

						<!-- /.col -->
						<div class="col-12" style="text-align: center">
							<button type="submit" class="btn btn-primary btn-block">Đăng
								ký</button>
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

	<script type="text/javascript">
		function validate() {

			let hoTen = document.myForm.hoTen.value.trim();
			let email = document.myForm.email.value.trim();
			let matKhau = document.myForm.matKhau.value;
			let nhapLaiMatKhau = document.myForm.nhapLaiMatKhau.value;
			$("#hoTenError").text("");
			$("#emailError").text("");
			$("#matKhauError").text("");
			$("#nhapLaiMatKhauError").text("");

			let flag = true;

			// kiếm tra họ tên
			if (hoTen.length === 0) {
				$("#hoTenError").text("Họ tên không được bỏ trống");
				flag = false;
			}
			
			if (email.length === 0) {
				$("#emailError").text("Email không được bỏ trống");
				flag = false;
			}


			if (matKhau.length < 6) {
				$("#matKhauError").text("Mật khẩu phải từ 6 kí tự");
				flag = false;
			}

			if (matKhau !== nhapLaiMatKhau) {
				$("#nhapLaiMatKhauError").text("Mật khẩu không khớp");
				flag = false;
			}

			return flag;
		}
	</script>
</body>
</html>