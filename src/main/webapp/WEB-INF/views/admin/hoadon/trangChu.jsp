<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/static/admin/" var="styleUrl" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý hóa đơn</title>
</head>
<body>

	<div class="content-wrapper">
		<section class="content">

			<div class="container-fluid">

				<div class="card">

					<!-- Thêm + tìm kiếm -->
					<div class="card-header ">

						<div class="form-group row " style="text-align: center">


							<label class="col-sm-1 col-form-label"> Mã đơn</label>

							<div>
								<!-- Tìm kiếm -->
								<input type="text" class="form-control" id="txtId"
									placeholder="Nhập mã đơn hàng ">
							</div>

							<label class="col-sm-1 col-form-label"> SĐT</label>

							<div>
								<!-- Tìm kiếm -->
								<input type="text" class="form-control" id="txtSoDienThoai"
									placeholder="Nhập số điện thoại ">
							</div>

							<label class="col-sm-1 col-form-label">Trạng thái</label>
							<div>

								<select class="form-control" id="slTrangThai">
									<option value="">Tất cả</option>
									<option value="Đang chờ xử lý">Đang chờ xử lý</option>
									<option value="Đang xử lý">Đang xử lý</option>
									<option value="Đang vận chuyển">Đang vận chuyển</option>
									<option value="Giao hàng thành công">Giao hàng thành
										công</option>
									<option value="Hủy đơn hàng">Hủy đơn hàng</option>

								</select>
							</div>

						</div>

					</div>
					<!-- End thêm + tìm kiếm -->

					<!-- Table hiển thị dữ liệu -->
					<div id="tableData" class="card-body">
						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>Mã hóa đơn</th>
									<th>Họ tên</th>
									<th>Số điện thoại</th>

									<th>Thời gian đặt</th>
									<th>Tổng tiền</th>
									<th>Trạng thái đơn hàng</th>
									<th>Thao tác</th>

								</tr>

							</thead>
							<tbody id="tableBody">

								<c:forEach items="${hoaDons}" var="x">

									<tr>

										<td>${x.id }</td>

										<td>${x.hoTenKhachHang }</td>

										<td>${x.soDienThoaiGiaoHang }</td>

										<td>${x.thoiGianDat }</td>
										<td>${x.tongTien }</td>




										<td>
											<!-- Đang chờ xử lý --> <c:if
												test="${x.trangThaiDonHang == 'Đang chờ xử lý' }">

												<div class="btn-group" role="group">
													<button id="btnGroupDrop1" type="button"
														class="btn btn-primary dropdown-toggle"
														data-toggle="dropdown" aria-haspopup="true"
														aria-expanded="false">${ x.trangThaiDonHang}</button>
													<div class="dropdown-menu" aria-labelledby="btnGroupDrop1">

														<a class="dropdown-item" href="#"
															onclick="capNhatTrangThai(${x.id}, 'Đang xử lý')">Đang
															xử lý</a> <a class="dropdown-item" href="#"
															onclick="capNhatTrangThai(${x.id}, 'Hủy đơn hàng')">Hủy
															đơn hàng</a>
													</div>

												</div>

											</c:if> <c:if test="${x.trangThaiDonHang == 'Đang xử lý' }">

												<div class="btn-group" role="group">
													<button id="btnGroupDrop2" type="button"
														class="btn btn-warning dropdown-toggle"
														data-toggle="dropdown" aria-haspopup="true"
														aria-expanded="false">${ x.trangThaiDonHang}</button>
													<div class="dropdown-menu" aria-labelledby="btnGroupDrop2">

														<a class="dropdown-item" href="#"
															onclick="capNhatTrangThai(${x.id}, 'Đang vận chuyển')">Đang
															vận chuyển</a> <a class="dropdown-item" href="#"
															onclick="capNhatTrangThai(${x.id}, 'Hủy đơn hàng')">Hủy
															đơn hàng</a>
													</div>

												</div>

											</c:if> <c:if test="${x.trangThaiDonHang == 'Đang vận chuyển' }">

												<div class="btn-group" role="group">
													<button id="btnGroupDrop3" type="button"
														class="btn btn-info dropdown-toggle"
														data-toggle="dropdown" aria-haspopup="true"
														aria-expanded="false">${ x.trangThaiDonHang}</button>
													<div class="dropdown-menu" aria-labelledby="btnGroupDrop3">

														<a class="dropdown-item" href="#"
															onclick="capNhatTrangThai(${x.id}, 'Giao hàng thành công')">Giao
															hàng thành công</a> <a class="dropdown-item" href="#"
															onclick="capNhatTrangThai(${x.id}, 'Hủy đơn hàng')">Hủy
															đơn hàng</a>
													</div>

												</div>

											</c:if> <c:if
												test="${x.trangThaiDonHang == 'Giao hàng thành công' }">

												<div class="btn-group" role="group">
													<button id="btnGroupDrop4" type="button"
														class="btn btn-success">${ x.trangThaiDonHang}</button>


												</div>

											</c:if> <c:if test="${x.trangThaiDonHang == 'Hủy đơn hàng' }">
												<div class="btn-group" role="group">
													<button id="btnGroupDrop5" type="button"
														class="btn btn-danger">${ x.trangThaiDonHang}</button>


												</div>


											</c:if>

										</td>

										<td><a href='<c:url value="/admin/hoa-don/${x.id}"  />'
											class="btn btn-primary btn-sm xem" 
											> <i class="fas fa-folder"></i>
												Xem
										</a> 
										




									</tr>

								</c:forEach>


							</tbody>
						</table>
					</div>
					<!--End Table hiển thị dữ liệu -->

				</div>

			</div>

		</section>

		<script type="text/javascript"
			src="${styleUrl}plugins/jquery/jquery.min.js"></script>
		<script src="${styleUrl }plugins/toastr/toastr.min.js"></script>
		<script type="text/javascript" src="${styleUrl}js/hoadon/trangChu.js"></script>

	</div>
</body>
</html>