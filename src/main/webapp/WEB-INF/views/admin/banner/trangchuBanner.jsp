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

									<label for="tenAnh" class="col-sm-1 col-form-label">Tên
										Banner</label>
									<div class="col-sm-3">

										<!-- Tìm kiếm -->
										<input type="text" class="form-control" id="timKiemTenBanner"
											placeholder="Nhập tên Banner">
									</div>

									<div class="col-sm-3">
										<button class="btn btn-info" data-toggle="modal"
											data-target="#them-modal">Thêm tên banner</button>
									</div>

								</div>

							</div>
							<!-- End thêm + tìm kiếm -->

							<!-- Table hiển thị dữ liệu -->
							<div id="tableData" class="card-body">
								<table class="table table-bordered table-hover">
									<thead>
										<tr>
											<th>Mã banner</th>
											<th>Tên banner</th>
											<th>Tiêu đề</th>
											<th>Nội dung</th>
											<th>Thao tác</th>
										</tr>

									</thead>
									<tbody id="tableBody">

										<c:forEach items="${banners}" var="x">

											<tr>

												<td>${x.id }</td>

												<td>${x.tenAnh }</td>

												<td>${x.tieuDe }</td>
												<td>${x.noiDung}</td>


												<td><a onClick="xemChiTiet(${x.id})"
													class="btn btn-primary btn-sm xem" data-toggle="modal"
													data-target="#xem-modal"> <i class="fas fa-folder"></i>
														Xem
												</a> <a onClick="sua(${x.id})" class="btn btn-info btn-sm sua"
													data-toggle="modal" data-target="#sua-modal"> <i
														class="fas fa-pencil-alt"></i> Sửa
												</a> <a onClick="xoa(${x.id})" class="btn btn-danger btn-sm xoa">
														<i class="fas fa-trash"> </i> Xóa
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

	<!-- Xem Modal -->
	<div class="modal fade" id="xem-modal" tabindex='-1'>
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Chi tiết banner</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					<div class="row">
						<div class="col-4">Mã banner</div>

						<div class="col-8 id"></div>
					</div>

					<div class="row">
						<div class="col-4">Tên banner</div>

						<div class="col-8 tenAnh"></div>

					</div>


					<div class="row">
						<div class="col-4">Tiêu đề</div>

						<div class="col-8 tieuDe"></div>

					</div>
					<div class="row">
						<div class="col-4">Nội dung</div>

						<div class="col-8 noiDung"></div>

					</div>


				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
				</div>

			</div>
		</div>
	</div>
	<!-- End modal xem -->

	<!-- Modal thêm -->
	<div class="modal fade" id="them-modal" tabindex='-1'>
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Thêm Banner</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">

					<div class="form-group">
						<!-- Modal body		<label>Tên Banner</label> <input type="text" class="form-control"
							id="tenBannerThem" placeholder="Nhập tên banner"> <span
							id="errThem" style="color: red;"> </span> -->
						<label>Hình ảnh</label>

						<div class="input-group">
							<div class="custom-file">
								<input type="file" class="custom-file-input" id="InputFile"
									name="file"> <label class="custom-file-label"
									for="exampleInputFile">Choose file</label>
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
					<button type="button" class="btn btn-primary" id="btnThem">Thêm</button>
				</div>

			</div>
		</div>
	</div>
	<!-- End modal thêm -->


	<!--  Modal Cập nhật -->
	<div class="modal fade" id="sua-modal" tabindex='-1'>
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Cập nhật Banner</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">

					<div class="form-group">
						<input type="hidden" id="id" />
						<!--  Modal Cập nhật	 <label>Tên Banner</label> <input
							type="text" class="form-control" id="tenAnh"
							placeholder="Nhập tên banner"> <span id="errThem"
							style="color: red;"> </span> -->

						<label>Hình ảnh</label>

						<div class="input-group">
							<div class="custom-file">
								<input type="file" class="custom-file-input"
									id="tenAnh" name="file"> <label
									class="custom-file-label" for="exampleInputFile">Choose
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
					<button type="button" class="btn btn-primary" id="btnCapNhat">Cập
						nhật</button>
				</div>

			</div>
		</div>
	</div>
	<!-- End Modal cập nhật -->




	<script type="text/javascript"
		src="${styleUrl}plugins/jquery/jquery.min.js"></script>
	<!-- Toastr -->
	<script src="${styleUrl }plugins/toastr/toastr.min.js"></script>
	<script type="text/javascript"
		src="${styleUrl}js/banner/trangChuBanner.js"></script>

</body>
</html>