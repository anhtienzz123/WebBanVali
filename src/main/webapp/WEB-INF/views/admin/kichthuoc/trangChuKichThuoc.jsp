<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/static/admin/" var="styleUrl"   />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý kích thước</title>

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

								<div class="form-group row"  >
								
									<label for="tenKichThuoc" class="col-sm-1 col-form-label">Tên Kích Thước</label>
									<div class="col-sm-3">
									    
									    <!-- Tìm kiếm -->
										<input type="text" class="form-control" id="timKiemTenKichThuoc"
											placeholder="Nhập tên kích thước">
									</div>
									
									<div class="col-sm-3">
									     <button class="btn btn-info"
									     	data-toggle="modal"
											data-target="#them-modal">
									 
									     Thêm kích thước</button>
									</div>
									
								</div>
								
							</div>
							<!-- End thêm + tìm kiếm -->

							<!-- Table hiển thị dữ liệu -->
							<div id="tableData" class="card-body">
								<table class="table table-bordered table-hover">
									<thead>
										<tr>
											<th>Mã kích thước</th>
											<th>Tên kích thước</th>
											<th>Code</th>
											<th>Thao tác</th>
										</tr>

									</thead>
									<tbody id="tableBody">

										<c:forEach items="${kichThuocs}" var="x" varStatus="loop">
				
											<tr>

												<td>${loop.index + 1 }</td>

												<td>${x.tenKichThuoc }</td>

												<td>${x.code }</td>

							
												<td>
													<a   onClick="xemChiTiet(${x.id})" 
														 class="btn btn-primary btn-sm xem" data-toggle="modal"
														 data-target="#xem-modal">
														  <i class="fas fa-folder"></i> Xem
													</a> 
													
													<a onClick="sua(${x.id})"
														class="btn btn-info btn-sm sua" data-toggle="modal"
														data-target="#sua-modal">
														  	<i class="fas fa-pencil-alt"></i> Sửa
													</a> 
													
													<a onClick="xoa(${x.id})" 
														class="btn btn-danger btn-sm xoa">
														 	<i class="fas fa-trash"> </i> Xóa
													</a>
												</td>

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
					<h4 class="modal-title">Chi tiết kích thước</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					<div class="row">
						<div class="col-4">Mã kích thước</div>

						<div class="col-8 id"></div>
					</div>

					<div class="row">
						<div class="col-4">Tên kích thước</div>

						<div class="col-8 tenKichThuocCT"></div>

					</div>


					<div class="row">
						<div class="col-4">Code</div>

						<div class="col-8 code"></div>

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
					<h4 class="modal-title">Thêm kích thước</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">

					<div class="form-group">
						<label>Tên kích thước</label>
						<input
							type="text" class="form-control" id="tenKichThuocThem"
							placeholder="Nhập tên kích thước"
						>
							
						<span
							id="errThem"  style="color: red;">
							
						</span>
						
						
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
					<h4 class="modal-title">Cập nhật kích thước</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">

					<div class="form-group">
						<input type="hidden" id="id" />
						<label>Tên kích thước</label>
						<input
							type="text" class="form-control" id="tenKichThuoc"
							placeholder="Nhập tên kích thước"
						>
							
						<span
							id="errThem"  style="color: red;">
							
						</span>
						
						
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					
					<button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
					<button type="button" class="btn btn-primary" id="btnCapNhat">Cập nhật</button>
				</div>

			</div>
		</div>
	</div>
	<!-- End Modal cập nhật -->
	
	
	
	
	<script type="text/javascript" src="${styleUrl}plugins/jquery/jquery.min.js"></script>
	<!-- Toastr -->
	<script src="${styleUrl }plugins/toastr/toastr.min.js"></script>
	<script type="text/javascript" src="${styleUrl}js/kichthuoc/trangchuKichThuoc.js" ></script>
	
</body>
</html>