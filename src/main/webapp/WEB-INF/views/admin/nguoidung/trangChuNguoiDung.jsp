<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/static/admin/" var="styleUrl" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lí người dùng</title>

<link rel="stylesheet"
	href="${styleUrl }css/nguoidung/trangChuNguoiDung.css" />
	
</head>
<body>

	<div class="content-wrapper">
		<section class="content">

			<div class="container-fluid">

				<div class="row">

					<div class="col-12">
						<div class="card">
							<div class="card-header">

								<form class="form-inline" action="#">
									<label for="email" class="mr-sm-2">Email: </label> <input
										type="email" class="form-control mb-2 mr-sm-2"
										placeholder="Nhập email" id="email"> <label for="pwd"
										class="mr-sm-2">Số điện thoại:</label> <input type="tel"
										class="form-control mb-2 mr-sm-2"
										placeholder="Nhập số điện thoại" id="soDienThoai">

									<!-- 
									
									<div class="form-check mb-2 mr-sm-2">
										<label class="form-check-label"> <input
											class="form-check-input" type="checkbox"> Remember me
										</label>
									</div>
									 -->

								</form>
							</div>
							<!-- /.card-header -->

							<div id="tableData" class="card-body">
								<table class="table table-bordered table-hover">
									<thead>
										<tr>
											<th>Mã người dùng</th>
											<th>Họ tên</th>
											<th>Email</th>
											<th>Số điện thoại</th>
											<th>Địa chỉ</th>
											<th>Trạng thái</th>
											<th>Thao tác</th>
										</tr>

									</thead>
									<tbody id="tableBody">

										<c:forEach items="${nguoiDungs}" var="nguoiDung">
				
											<tr>

												<td>${nguoiDung.maNguoiDung }</td>

												<td>${nguoiDung.hoTen }</td>

												<td>${nguoiDung.email }</td>

												<td>${nguoiDung.soDienThoai }</td>

												<td>${nguoiDung.diaChi }</td>
												<td><c:choose>
														<c:when test="${nguoiDung.trangThai == true }">
															<span class="badge badge-success">Hoạt động</span>
														</c:when>
														<c:otherwise>
															<span class="badge badge-warning">Chưa xác thực</span>
														</c:otherwise>
													</c:choose></td>

												<td><a   onClick="xemChiTietNguoiDung('${nguoiDung.maNguoiDung}')" 
													class="btn btn-primary btn-sm xem" data-toggle="modal"
													data-target="#xem-modal"> <i class="fas fa-folder">
													</i> Xem
												</a> <a 
													class="btn btn-info btn-sm sua" data-toggle="modal"
													data-target="#sua-modal"> <i class="fas fa-pencil-alt">
													</i> Sửa
												</a> <a onClick="xoaNguoiDung('${nguoiDung.maNguoiDung}')" 
													class="btn btn-danger btn-sm xoa"> <i
														class="fas fa-trash"> </i> Xóa
												</a></td>

											</tr>

										</c:forEach>


									</tbody>
								</table>
							</div>
							<!-- /.card-body -->
							<div class="card-footer clearfix">
								<ul class="pagination pagination-sm m-0 float-right">
									<c:url value="/admin/nguoi-dung/?page" var="url" />

									<li id="liTruoc" class="page-item"><a
										class="page-link">&laquo;</a></li>

									<li id="liTrang" value="default" class="page-item"><a
										class="page-link">1</a></li>


									<li id="liSau" value="v1/nguoi-dungs?page=1" class="page-item"><a
										class="page-link">&raquo;</a></li>

								</ul>
							</div>
						</div>
					</div>


				</div>

			</div>

		</section>


	</div>

	<div class="modal fade" id="xem-modal" tabindex='-1'>
		<div class="modal-dialog">

			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Chi tiết người dùng</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">

					<div class="row">
						<div class="col-4">Mã người dùng</div>

						<div class="col-8 maNguoiDung">dsds</div>

					</div>


					<div class="row">
						<div class="col-4">Họ tên</div>

						<div class="col-8 hoTen">dsds</div>

					</div>


					<div class="row">
						<div class="col-4">Giới tính</div>

						<div class="col-8 gioiTinh"></div>

					</div>


					<div class="row">
						<div class="col-4">Số điện thoại</div>

						<div class="col-8 soDienThoai"></div>

					</div>


					<div class="row">
						<div class="col-4">Email</div>

						<div class="col-8 email"></div>

					</div>


					<div class="row">
						<div class="col-4">Địa chỉ</div>

						<div class="col-8 diaChi"></div>

					</div>


					<div class="row">
						<div class="col-4">Trạng thái</div>

						<div class="col-8 trangThai"></div>

					</div>



				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
				</div>

			</div>
		</div>
	</div>


	<div class="modal fade" id="sua-modal" tabindex='-1'>

		<div class="modal-dialog modal-lg">

			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Cập nhật người dùng1</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->

				<div class="modal-body">

					<div class="card card-danger">
						<div class="card-header">
							<h3 class="card-title">Input masks</h3>
						</div>

						<div class="card-body">
							<!-- form group -->
							<div class="form-group">
								<label>Họ tên:</label>

								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"><i
											class="far fa-calendar-alt"></i></span>
									</div>
									<input type="text" class="form-control">
								</div>
								<!-- /.input group -->
							</div>
							<!-- /.form group -->

							<!-- form group -->
							<div class="form-group">
								<label>Số điện thoại:</label>

								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"><i
											class="far fa-calendar-alt"></i></span>
									</div>
									<input type="text" class="form-control">
								</div>
								<!-- /.input group -->
							</div>
							<!-- /.form group -->

							<!-- form group -->
							<div class="form-group">
								<label>Email:</label>

								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"><i
											class="far fa-calendar-alt"></i></span>
									</div>
									<input type="text" class="form-control">
								</div>
								<!-- /.input group -->
							</div>
							<!-- /.form group -->

							<!-- form group -->
							<div class="form-group">
								<label class="col-sm-2 col-form-label p-0"
									for="exampleFormControlSelect1"> Địa chỉ</label>

								<div class="col-sm-12  p-0">

									<div class="row">
										<div class="col pr-1">
											<select class="form-control " id="exampleFormControlSelect1">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
											</select>
										</div>

										<div class="col p-0">
											<select class="form-control "  id="exampleFormControlSelect1">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
											</select>
										</div>

										<div class="col  pl-1">
											<select class="form-control " id="exampleFormControlSelect1">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
											</select>
										</div>

									</div>

								</div>


							</div>
							<!-- /.form group -->








						</div>
						<!-- /.card-body -->
					</div>
					<!-- /.card -->

				</div>
				<!-- /.card-body -->




			

			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
			</div>
			
		</div>

		</div>
	</div>







	<script src="${styleUrl }plugins/jquery/jquery.min.js"></script>

	<script src="${styleUrl}js/nguoidung/trangChuNguoiDung.js"></script>


</body>
</html>