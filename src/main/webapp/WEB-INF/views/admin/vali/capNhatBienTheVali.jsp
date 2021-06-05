<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/static/admin/" var="styleUrl" />



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật biến thể vali</title>
<link rel="stylesheet" href="${styleUrl }plugins/toastr/toastr.min.css">

<style type="text/css">
	.error{
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


							<form:form method="post" modelAttribute="bienTheValiAdd" id="myForm" name="myForm"
								enctype="multipart/form-data"  onsubmit="return(validate());"  >
								<div class="card-body">

									
									<form:hidden path="tenAnh"/>
									<form:hidden path="tenVali"/>
									<form:hidden path="tenKichThuoc"/>
									<form:hidden path="tenMauSac"/>
									
									<div class="row">

										<div class="col-12">
											<!-- select -->
											<div class="form-group">

												<label>Tên Vali</label>
												<p>${bienTheValiAdd.tenVali}</p>
												
												


											</div>
										</div>

										<div class="col-6">
											<!-- select -->
											<div class="form-group">

												<label>Kích thước</label>
												<p>${bienTheValiAdd.tenKichThuoc}</p>
											</div>
										</div>

										<div class="col-6">
											<!-- select -->
											<div class="form-group">

												<label>Màu sắc</label>
												<p>${bienTheValiAdd.tenMauSac}</p>


											</div>
										</div>

										<div class="form-group col-6">
											<label>Giá</label>
											
											<form:input path="gia" cssClass="form-control" />
											<label id="giaErr" class="error"></label>
											<form:errors path="gia"  cssClass="error" />

										</div>


										<div class="form-group col-6">
											<label>Khuyến mãi</label>

											<form:input path="khuyenMai" cssClass="form-control" />
											<label id="khuyenMaiErr" class="error"></label>
											<form:errors path="khuyenMai" cssClass="error" />


										</div>

										<div class="form-group col-6">
											<label>Số lượng</label>

											<form:input path="soLuong" cssClass="form-control" />
											<label id="soLuongErr" class="error"></label>
											<form:errors path="soLuong" cssClass="error" />

										</div>



										<div class="form-group col-6">
											<label>Nổi bật</label>
											<br>
											<div class="form-check-inline">
												<label class="form-check-label"> 
													
												<form:radiobutton path="noiBat" value="true"   cssClass="form-check-input"  /> Nổi bật
												</label>
											</div>
											<div class="form-check-inline">
												<label class="form-check-label">
												<form:radiobutton path="noiBat" value="false"   cssClass="form-check-input"  />Không nổi bật
												</label>
											</div>
											
											
											

										</div>



										<div class="form-group col-4">

											<label>Thể tích</label>

											<form:input path="theTich" cssClass="form-control" />
											<label id="theTichErr" class="error"></label>
											<form:errors path="theTich" cssClass="error" />
										</div>

										<div class="form-group col-4">

											<label>Trọng lượng</label>

											<form:input path="trongLuong" cssClass="form-control" />
											<label id="trongLuongErr" class="error"></label>
											<form:errors path="trongLuong" cssClass="error" />
										</div>

										<div class="form-group col-4">

											<label>Mô tả kích thước</label>

											<form:input path="moTaKichThuoc" cssClass="form-control" />
											<label id="moTaKichThuocErr" class="error"></label>
											<form:errors path="moTaKichThuoc"  cssClass="error"/>
										</div>

										<div class="col-12">
										
											<div class="form-group">
												<label>Hình ảnh</label>

												<div class="input-group">
													<div class="custom-file">
														<input type="file" class="custom-file-input"
															id="exampleInputFile"  name="file"  > <label
															class="custom-file-label" for="exampleInputFile">Choose
															file</label>
													</div>
													<div class="input-group-append">
														<span class="input-group-text">Upload</span>
													</div>
												</div>


											</div>

										</div>
										
										<div>
											
											<button class="btn btn-primary"  type="submit" >Xác nhận</button>
											
										</div>


									</div>
								</div>

							</form:form>
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




<script src="${styleUrl }js/vali/themBienTheVali.js"></script>
	<script>
		$(function() {
			bsCustomFileInput.init();
		});
		
		
	</script>
</body>
</html>