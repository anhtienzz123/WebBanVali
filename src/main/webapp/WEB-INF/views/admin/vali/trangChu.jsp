<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url value="/static/admin/" var="styleUrl" />



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý Vali</title>
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

									<label for="tenMauSac" class="col-sm-1 col-form-label">Tên
										vali</label>
									<div class="col-sm-3">

										<!-- Tìm kiếm -->
										<input type="text" class="form-control" id="timKiemTenMauSac"
											placeholder="Nhập tên màu sắc">
									</div>

									<div class="col-sm-3">
										<button class="btn btn-info" data-toggle="modal"
											data-target="#them-modal">Thêm màu sắc</button>
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
											<th>Tên vali</th>
											
											<th>Nhóm vali</th>
											<th>Thương hiệu</th>
											<th>Số biến thể</th>
											<th>Số lượng</th>
											<th>Số đánh giá</th>
											<th>Số bình luận</th>
											<th>Thao tác</th>
										</tr>

									</thead>
									<tbody id="tableBody">

										<c:forEach items="${valis}" var="x">

											<tr>

												<td>${x.id }</td>

												<td>${x.tenVali }</td>

												
												<td>${x.nhomVali }</td>
												<td>${x.thuongHieu }</td>
												<td>${x.soBienThe }</td>
												<td>${x.soLuong }</td>
												<td>${x.soDanhGia }</td>
												<td>${x.soBinhLuan }</td>


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

	<script type="text/javascript"
		src="${styleUrl}plugins/jquery/jquery.min.js"></script>
	<!-- Toastr -->
	<script src="${styleUrl }plugins/toastr/toastr.min.js"></script>
</body>
</html>