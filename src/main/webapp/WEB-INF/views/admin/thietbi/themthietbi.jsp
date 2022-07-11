<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/static/admin/" var="styleUrl" />
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm vali</title>
<link rel="stylesheet" href="${styleUrl }plugins/toastr/toastr.min.css">
<!-- summernote -->
<link rel="stylesheet"
	href="${styleUrl }plugins/summernote/summernote-bs4.min.css">

<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>

	<div class="content-wrapper">
		<section class="content">

			<div class="container-fluid">

				<div class="row">


					<div class="col-12">
						<div class="card card-primary">
							<div class="card-header">
								<h3 class="card-title">Form nhập Vali</h3>
							</div>
							<!-- /.card-header -->

							<!-- Form add -->

							<form:form modelAttribute="valiChung" method="post" id="myForm"
								name="myForm" enctype="multipart/form-data"
								onsubmit="return(validate());" >

								<div class="card-body">

									<div class="row">

										<form:hidden path="id" />
										<div class="form-group col-12">
											<label>Tên vali</label>


											<form:input path="tenVali" cssClass="form-control" />
											<label id="tenValiErr" class="error"></label>
											<form:errors cssClass="error" path="tenVali" />

										</div>


										<div class="form-group col-6">
											<label>Bánh xe</label>

											<form:input path="banhXe" cssClass="form-control" />
											<label id="banhXeErr" class="error"></label>
											<form:errors cssClass="error" path="banhXe" />


										</div>

										<div class="form-group col-6">
											<label>Dây kéo</label>

											<form:input path="dayKeo" cssClass="form-control" />
											<label id="dayKeoErr" class="error"></label>
											<form:errors cssClass="error" path="dayKeo" />

										</div>

										<div class="form-group col-6">

											<label>Khóa</label>

											<form:input path="khoa" cssClass="form-control" />
											<label id="khoaErr" class="error"></label>
											<form:errors cssClass="error" path="khoa" />
										</div>

										<div class="form-group col-6">
											<label>Thời gian bảo hành</label>

											<form:input path="thoiGianBaoHanh" cssClass="form-control" />
											<label id="thoiGianBaoHanhErr" class="error"></label>
											<form:errors cssClass="error" path="thoiGianBaoHanh" />
										</div>

										<div class="col-6">
											<!-- select -->
											<div class="form-group">

												<label>Tính năng</label>

												<form:select path="tinhNangs" cssClass="form-control">

													<c:forEach items="${tenTinhNangs }" var="x">


														<c:if test="${fn:contains(valiChung.getTinhNangs(), x)}">
															<option value="${x}" selected="selected">${x }</option>
														</c:if>

														<c:if
															test="${not fn:contains(valiChung.getTinhNangs(), x)}">
															<option value="${x}">${x }</option>
														</c:if>



													</c:forEach>

												</form:select>


											</div>
										</div>

										<div class="col-6">
											<!-- select -->
											<div class="form-group">
												<label>Chất liệu</label>


												<form:select path="tenChatLieu" cssClass="form-control">

													<c:forEach items="${tenChatLieus }" var="x">


														<c:if test="${valiChung.tenChatLieu == x }">
															<option value="${x}" selected="selected">${x }</option>
														</c:if>

														<c:if test="${valiChung.tenChatLieu != x }">
															<option value="${x}">${x }</option>
														</c:if>



													</c:forEach>

												</form:select>


											</div>
										</div>

										<div class="col-6">
											<!-- select -->
											<div class="form-group">
												<label>Thương hiệu</label>

												<form:select path="tenThuongHieu" cssClass="form-control">

													<c:forEach items="${tenThuongHieus }" var="x">

														<c:if test="${valiChung.tenThuongHieu == x }">
															<option value="${x}" selected="selected">${x }</option>
														</c:if>

														<c:if test="${valiChung.tenThuongHieu != x }">
															<option value="${x}">${x }</option>
														</c:if>


													</c:forEach>

												</form:select>
											</div>
										</div>

										<div class="col-6">
											<!-- select -->
											<div class="form-group">
												<label>Nhóm vali</label>

												<form:select path="tenNhomVali" cssClass="form-control">

													<c:forEach items="${tenNhomValis }" var="x">


														<c:if test="${valiChung.tenNhomVali == x }">
															<option value="${x}" selected="selected">${x }</option>
														</c:if>

														<c:if test="${valiChung.tenNhomVali != x }">
															<option value="${x}">${x }</option>
														</c:if>

													</c:forEach>

												</form:select>
											</div>
										</div>



										<!-- Mo ta -->
										<div class="col-12">

											<label>Mô tả</label>

											<form:textarea path="moTa" id="summernote" />


										</div>
										<!-- End mo to -->




									</div>





								</div>
								<!-- /.card-body -->

								<div class="card-footer">
									<button type="submit" class="btn btn-primary">Submit</button>
								</div>
							</form:form>

							<!-- End form -->
						</div>

					</div>

				</div>

			</div>

		</section>

	</div>




	<script type="text/javascript"
		src="${styleUrl}plugins/jquery/jquery.min.js"></script>
	<!-- Toastr -->
	<script src="${styleUrl }plugins/toastr/toastr.min.js"></script>

	<!-- bs-custom-file-input -->
	<script
		src="${styleUrl}plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>

	<!-- Summernote -->
	<script src="${styleUrl }plugins/summernote/summernote-bs4.min.js"></script>



	<script src="${styleUrl }js/vali/themVali.js"></script>

	<script>
		$(function() {
			bsCustomFileInput.init();
		});

		$(function() {

			$('#summernote').summernote()

		});
	</script>
</body>
</html>