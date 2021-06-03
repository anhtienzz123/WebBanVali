<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/static/admin/" var="styleUrl" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý Banner</title>

<!-- Toastr -->
<link rel="stylesheet" href="${styleUrl }plugins/toastr/toastr.min.css">
</head>
<body>

	<div class="content-wrapper">
		<section class="content">

			<div class="container-fluid">

				<div class="row">

					<div class="col-12">
						<div class="card">


							<!-- Thêm + tìm kiếm -->
							<div class="card-header">

								<div class="form-group row">

									<div class="col-sm-3">
										<button class="btn btn-info" data-toggle="modal"
											data-target="#them-modal">Thêm Banner</button>
									</div>

								</div>

							</div>
							<!-- End thêm + tìm kiếm -->

							<!-- Table hiển thị dữ liệu -->
							<div id="tableData" class="card-body">
								<table class="table table-bordered table-hover">
									<thead>
										<tr>
											<th>STT</th>
											<th>Tên banner</th>
											<th>Tiêu đề</th>
											<th>Thao tác</th>
										</tr>

									</thead>
									<tbody id="tableBody">

										<c:forEach items="${banners}" var="x" varStatus="loop">

											<tr>

												<td>${loop.index + 1 }</td>

												<td>${x.tenAnh }</td>

												<td>${x.tieuDe }</td>
												<td><a onClick="xoa(${x.id})"
													class="btn btn-danger btn-sm xoa"> <i
														class="fas fa-trash"> </i> Xóa
												</a></td>

											</tr>

										</c:forEach>


									</tbody>
								</table>
							</div>
							<!--End Table hiển thị dữ liệu -->


						</div>
					</div>


				</div>

			</div>

		</section>

	</div>


	<!-- Modal thêm -->
	<div class="modal fade" id="them-modal" tabindex='-1'>
		<div class="modal-dialog">
			<form action='<c:url value="/admin/banner/" />' method="post"
				enctype="multipart/form-data">
				<div class="modal-content">
					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">Thêm Banner</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<!-- Modal body -->
					<div class="modal-body">

						<div class="form-group">

							<div class="form-group">
								<label>Tiêu đề</label> <input type="text" class="form-control"
									name="tieuDe">
							</div>




							<label>Hình ảnh</label>

							<div class="input-group">
								<div class="custom-file">
									<input type="file" class="custom-file-input" name="file">
									<label class="custom-file-label" for="exampleInputFile">Chọn
										file</label>
								</div>
								<div class="input-group-append">
									<span class="input-group-text">Upload</span>
								</div>
							</div>

						</div>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">

						<button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
						<button type="submit" class="btn btn-primary" id="btnThem">Thêm</button>
					</div>

				</div>

			</form>
		</div>
	</div>
	<!-- End modal thêm -->


	<



	<script type="text/javascript"
		src="${styleUrl}plugins/jquery/jquery.min.js"></script>
	<!-- Toastr -->
	<script src="${styleUrl }plugins/toastr/toastr.min.js"></script>
	<script type="text/javascript"
		src="${styleUrl}js/banner/trangChuBanner.js"></script>

	<!-- bs-custom-file-input -->
	<script
		src="${styleUrl}plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>





	<script>
		$(function() {
			bsCustomFileInput.init();
		});
	</script>

</body>
</html>