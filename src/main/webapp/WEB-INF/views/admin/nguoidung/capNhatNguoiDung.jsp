<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url value="/static/admin/" var="styleUrl" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật người dùng</title>
</head>
<body>

	<div class="content-wrapper">

		<section class="content">

			<div class="bg-white  " style="padding: 30px">

				<form  method="post">

					<input type="hidden" name="id" value="${id }" /> 
					
					<div class="form-group">
						<label>Họ tên:</label>

						<div class="input-group">

							<span id="hoTenForm">${hoTen }</span>
						</div>
						<!-- /.input group -->
					</div>
					<!-- /.form group -->

					<!-- form group -->
					<div class="form-group">
						<label>Email:</label>

						<div class="input-group">

							<span id="emailForm">${email }</span>
						</div>
						<!-- /.input group -->
					</div>
					<!-- /.form group -->


					<div class="form-group">
						<label>Hoạt động</label> <br>
						<div class="form-check-inline">
							<label class="form-check-label"> <input id="trangThai" name="trangThai"
								type="radio" value="true" class="form-check-input"
								${trangThai == true ? 'checked' : '' } /> Kích hoạt
							</label>
						</div>
						<div class="form-check-inline">

							<label class="form-check-label" id="trangThai"   > <input name="trangThai"
								type="radio" value="false" class="form-check-input"
								${trangThai == false ? 'checked' : '' } /> Không kích hoạt
							</label>

						</div>

					</div>


					<div class="form-group">
						<label>Vai trò</label> <br>
						<div class="form-check-inline">
							<label class="form-check-label"> <input type="radio" name="role"
								value="ROLE_USER" class="form-check-input" id="role" ${vaiTro == 'ROLE_USER' ? 'checked' : '' } /> User
							</label>
						</div>
						<div class="form-check-inline">

							<label class="form-check-label"> <input type="radio" name="role"
								value="ROLE_ADMIN" class="form-check-input" id="role" ${vaiTro == 'ROLE_ADMIN' ? 'checked' : '' } /> Admin
							</label>

						</div>

					</div>

					<button class="btn btn-primary" type="submit">Cập nhật</button>

				</form>


			</div>



		</section>

	</div>
</body>
</html>