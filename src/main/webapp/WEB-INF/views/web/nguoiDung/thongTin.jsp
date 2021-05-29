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

					<span class="font-weight-bold">THÔNG TIN TÀI KHOẢN</span>

					<div class="form-thong-tin mt-3">

						<form:form id="myForm" name="myForm" modelAttribute="nguoiDung"
							method="post" onsubmit="return(validate());">
							<form:hidden path="id" />

							<div class="form-group row">
								<label for="hoTen" class="col-sm-3 col-form-label">Họ
									Tên</label>

								<div class="col-sm-9">
									<form:input path="hoTen" cssClass="form-control" id="hoTen" />
									<form:errors path="hoTen" cssClass="error" />
									<label id="hoTenError" class="error"></label>

								</div>
							</div>

							<div class="form-group row">
								<label for="soDienThoai" class="col-sm-3 col-form-label">Số
									điện thoại</label>

								<div class="col-sm-9">
									<form:input path="soDienThoai" cssClass="form-control"
										id="soDienThoai" />
									<form:errors path="soDienThoai" cssClass="error" />
									<label id="soDienThoaiError" class="error"></label>
								</div>
							</div>

							<div class="form-group row">
								<label for="email" class="col-sm-3 col-form-label">Email</label>

								<div class="col-sm-9">
									<form:input path="email" cssClass="form-control" id="email"
										readonly="true" />
									<form:errors path="email" cssClass="error" />
									<label id="emailError" class="error"></label>
								</div>


							</div>
							<fieldset class="form-group row">
								<legend class="col-form-label col-sm-3 float-sm-left pt-0">Giới
									tính</legend>

								<div class="col-sm-9 ">
									<div class="form-check-inline">
										<form:radiobutton path="gioiTinh" value="true"
											cssClass="form-check-input" id="nam" />
										<label class="form-check-label" for="nam"> Nam </label>
									</div>
									<div class="form-check-inline">
										<form:radiobutton path="gioiTinh" value="false"
											cssClass="form-check-input" id="nu" />

										<label class="form-check-label" for="nu"> Nữ </label>
									</div>
								</div>

							</fieldset>

							<div class="form-group row ">

								<label class="col-sm-3 col-form-label"
									for="exampleFormControlSelect1"> Tỉnh/Thành phố</label>

								<div class="col-sm-9">

									<form:select path="tinhThanhPho" cssClass="form-control">
										<c:forEach items="${thanhPhos}" var="tp">

											<c:choose>
												<c:when test="${tp.getValue() eq nguoiDung.tinhThanhPho }">
													<option value="${tp.getKey()}" selected="true">${tp.getValue()}</option>
												</c:when>

												<c:otherwise>
													<option value="${tp.getKey()}">${tp.getValue()}</option>
												</c:otherwise>
											</c:choose>

										</c:forEach>
									</form:select>


								</div>
							</div>

							<div class="form-group row ">

								<label class="col-sm-3 col-form-label"
									for="exampleFormControlSelect1"> Quận huyện</label>
								<div class="col-sm-9">
									<form:select path="quanHuyen" cssClass="form-control">

										<c:forEach items="${quanHuyens}" var="qh">

											<c:choose>
												<c:when test="${qh.getValue() eq nguoiDung.quanHuyen }">
													<option value="${qh.getKey()}" selected="true">${qh.getValue()}</option>
												</c:when>

												<c:otherwise>
													<option value="${qh.getKey()}">${qh.getValue()}</option>
												</c:otherwise>
											</c:choose>

										</c:forEach>

									</form:select>

									<form:errors path="quanHuyen" cssClass="error" />
									<label id="quanHuyenError" class="error"></label>
								</div>
							</div>


							<div class="form-group row ">

								<label class="col-sm-3 col-form-label"
									for="exampleFormControlSelect1"> Phường xã</label>
								<div class="col-sm-9">
									<form:select path="phuongXa" cssClass="form-control">

										<c:forEach items="${phuongXas}" var="px">

											<c:choose>
												<c:when test="${px.getValue() eq nguoiDung.phuongXa }">
													<option value="${px.getKey()}" selected="true">${px.getValue()}</option>
												</c:when>

												<c:otherwise>
													<option value="${px.getKey()}">${px.getValue()}</option>
												</c:otherwise>
											</c:choose>

										</c:forEach>

									</form:select>

									<form:errors path="phuongXa" cssClass="error" />
									<label id="phuongXaError" class="error"></label>
								</div>
							</div>


							<div class="form-group row mt-2">
								<label for="inputPassword3" class="col-sm-3 col-form-label">Địa
									chỉ</label>
								<div class="col-sm-9">

									<form:textarea path="diaChi" cssClass="txtDiaChi"
										cssStyle="width: 100%; padding: 10px; border: 1px solid lightgray; border-radius: 5px"
										rows="5" />
									<form:errors path="diaChi" cssClass="error" />
									<label id="diaChiError" class="error"></label>
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
		src="${styleUrl }js/nguoiDung/nguoiDung.js"></script>
</body>
</html>