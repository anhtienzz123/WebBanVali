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
<title>Quản lý biến thể Vali</title>
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
											
											<th>Tên vali</th>
											<th>Kích thước</th>
											<th>Màu sắc</th>
											<th>Số lượng</th>
											<th>Giá</th>
											<th>Khuyến mãi</th>
											<th>Nổi bật</th>
											<th>Thao tác</th>
										</tr>

									</thead>
									<tbody id="tableBody">

										<c:forEach items="${bienTheValis}" var="x">

											<tr>

												

												<td>${x.tenVali }</td>

												
												<td>${x.tenKichThuoc }</td>
												<td>${x.tenMauSac }</td>
												<td>${x.soLuong }</td>
												<td>${x.gia }</td>
												<td>${x.khuyenMai }</td>
												<td>
													
													<c:if test="${x.noiBat}">
														
														<span class="badge badge-success">Nổi bật</span>
													</c:if>
													
													<c:if test="${x.noiBat == false}">
														
														<span class="badge badge-danger">Mặc định</span>
													</c:if>
												
												</td>


												<td><a 
													class="btn btn-primary btn-sm xem" data-toggle="modal"
													data-target="#xem-modal"> <i class="fas fa-folder"></i>
														Xem
												</a> <a class="btn btn-info btn-sm sua"
										href='<c:url value="/admin/vali/sua-bien-the-vali?valiId=${x.valiId}&kichThuocId=${x.kichThuocId }&mauSacId=${x.mauSacId }" />'
													    > <i
														class="fas fa-pencil-alt"></i> Sửa
												</a> <a  class="btn btn-danger btn-sm xoa">
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