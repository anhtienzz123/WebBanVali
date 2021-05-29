<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<c:url value="/static/web/" var="styleUrl" />
<c:url value="/static/admin/" var="styleUrlAdmin" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${styleUrl }css/nguoiDung/nguoiDung.css">
</head>
<body>
	<div class="main bg-light">

		<div class="bg-white" style="width: 80%; margin: 0 auto;">

			<div class="row">

				<div id="danh-muc" class="col-4 bg-light">

					<div class="card">
						<div class="card-header bg-white px-4 py-4">
							<span class="text-warning font-weight-bold">TÀI KHOẢN</span>
						</div>
						<ul class="list-group list-group-flush"
							style="width: 90%; margin: 0 auto;">
							<li class="list-group-item"><a
								href=' <c:url value="/user/thong-tin" />'>Thông tin tài
									khoản</a></li>
							<li class="list-group-item"><a
								href=' <c:url value="/user/doi-mk" />'> Đổi mật khẩu</a></li>
							<li class="list-group-item"><a
								href=' <c:url value="/user/don-hang" />'>Đơn hàng của tôi</a></li>
							<li class="list-group-item"><a
								href=' <c:url value="/user/binh-luan" />'>Nhận xét của tôi</a></li>
						</ul>
					</div>

				</div>


				<div class="col-8 px-4 py-2 border bg-white rounded">

					<span class="font-weight-bold">ĐỔI MẬT KHẨU</span>

					<div class="form-thong-tin mt-3">

						<form:form id="myForm" name="myForm" modelAttribute="matKhau"
							method="post" onsubmit="return(validate());">
							<form:hidden path="id" />
							<div class="form-group row">
								<label for="matKhau" class="col-sm-3 col-form-label">Mật
									Khẩu</label>

								<div class="col-sm-9">
									<form:password path="matKhau"  cssClass="form-control" id="matKhau"  />
									<form:errors path="matKhau" cssClass="error" />
									<label id="matKhauError" class="error"></label>
								</div>
							</div>

							<div class="form-group row">
								<label for="matKhauMoi" class="col-sm-3 col-form-label">Mật
									Khẩu Mới</label>

								<div class="col-sm-9">
									<form:password path="" cssClass="form-control" id="matKhauMoi"
										name="matKhauMoi" />
									<form:errors path="" cssClass="error" />
									<label id="matKhauMoiError" class="error"></label>
								</div>
							</div>
							<div class="form-group row">
								<label for="matKhauXacNhan" class="col-sm-3 col-form-label">Xác
									Nhận Mật Khẩu</label>

								<div class="col-sm-9">
									<form:password path="" cssClass="form-control" id="matKhauXacNhan"
										name="matKhauXacNhan" />
									<form:errors path="" cssClass="error" />
									<label id="matKhauXacNhanError" class="error"></label>
								</div>
							</div>


							<div class="form-group text-center">

								<button type="submit" class="btn btn-primary">Cập nhật</button>

							</div>

						</form:form>

					</div>

				</div>


			</div>



		</div>

	</div>

	<script type="text/javascript"
		src="${styleUrlAdmin }plugins/jquery/jquery.min.js"></script>
	<script type="text/javascript"
		src="${styleUrl }js/nguoiDung/doiMatKhau.js"></script>
</body>
</html>
