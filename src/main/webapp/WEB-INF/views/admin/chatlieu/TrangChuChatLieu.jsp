<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/static/admin/" var="styleUrl"   />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý chất liệu</title>

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
							<div class="card-header">

								<div class="form-group row"  >
								
									<label for="tenChatLieu" class="col-sm-1 col-form-label">Tên chất liệu</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" id="timKiemTenChatLieu"
											placeholder="Nhập tên chất liệu">
									</div>
									
									<div class="col-sm-3">
									     <button class="btn btn-info"
									     	data-toggle="modal"
											data-target="#them-modal">
									 
									     Thêm chất liệu</button>
									</div>
									
									
								</div>
								
								
							</div>
							<!-- /.card-header -->

							<div id="tableData" class="card-body">
								<table class="table table-bordered table-hover">
									<thead>
										<tr>
											<th>Mã chất liệu</th>
											<th>Tên chất liệu</th>
											<th>Code</th>
											<th>Thao tác</th>
										</tr>

									</thead>
									<tbody id="tableBody">

										<c:forEach items="${chatLieus}" var="x">
				
											<tr>

												<td>${x.id }</td>

												<td>${x.tenChatLieu }</td>

												<td>${x.code }</td>

							
												<td><a   onClick="xemChiTiet('${x.id}')" 
													class="btn btn-primary btn-sm xem" data-toggle="modal"
													data-target="#xem-modal"> <i class="fas fa-folder">
													</i> Xem
												</a> <a 
													class="btn btn-info btn-sm sua" data-toggle="modal"
													data-target="#sua-modal"> <i class="fas fa-pencil-alt">
													</i> Sửa
												</a> <a onClick="xoa('${x.id}')" 
													class="btn btn-danger btn-sm xoa"> <i
														class="fas fa-trash"> </i> Xóa
												</a></td>

											</tr>

										</c:forEach>


									</tbody>
								</table>
							</div>
							<!-- /.card-body -->
							
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
					<h4 class="modal-title">Chi tiết chất liệu</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					<div class="row">
						<div class="col-4">Mã chất liệu</div>

						<div class="col-8 id"></div>
					</div>

					<div class="row">
						<div class="col-4">Tên chất liệu</div>

						<div class="col-8 tenChatLieu"></div>

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
	
	<!-- Modal thêm -->
	<div class="modal fade" id="them-modal" tabindex='-1'>
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Thêm chất liệu</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">

					<div class="form-group">
						<label>Tên chất liệu</label>
						<input
							type="text" class="form-control" id="tenChatLieuThem"
							placeholder="Nhập tên chất liệu"
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
	
	
	
	
	<script type="text/javascript" src="${styleUrl}plugins/jquery/jquery.min.js"></script>
	<!-- Toastr -->
	<script src="${styleUrl }plugins/toastr/toastr.min.js"></script>
	<script type="text/javascript" src="${styleUrl}js/chatlieu/trangChuChatLieu.js" ></script>
	
</body>
</html>