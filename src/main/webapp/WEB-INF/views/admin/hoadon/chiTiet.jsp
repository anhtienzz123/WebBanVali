<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/static/admin/" var="styleUrl" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết hóa đơn</title>
</head>
<body>

	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">

		<section class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-12">
						


						<!-- Main content -->
						<div class="invoice p-3 mb-3">

							<!-- title row -->
							<div class="row">
								<div class="col-12">
									<h4>
										Mã đơn hàng: ${hoaDon.id } <small class="float-right">Ngày
											đặt: ${hoaDon.thoiGianDat }</small>
									</h4>
								</div>
								<!-- /.col -->
							</div>
							<!-- info row -->
							<div class="row invoice-info">

								<div class="col-sm-12 invoice-col">
									Thông tin khách hàng
									<address>
										<strong>${hoaDon.tenKhachHang }</strong> <br /> <span>Địa
											chỉ: ${hoaDon.diaChi }</span> <br /> <span>Email:
											${hoaDon.email }</span> <br /> <span>Trạng thái:
											${hoaDon.trangThai }</span>

									</address>
								</div>


							</div>
							<!-- /.row -->

							<!-- Table row -->
							<div class="row">
								<div class="col-12 table-responsive">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>STT</th>
												<th>Tên vali</th>
												<th>Giá</th>
												<th>Khuyến mãi</th>
												<th>Số lượng</th>
												<th>Tổng tiền</th>
											</tr>
										</thead>
										<tbody>

											<c:forEach items="${hoaDon.chiTietHoaDons }" var="x"
												varStatus="loop">

												<tr>
													<td>${loop.index +1 }</td>
													<td>${x.tenVali }</td>
													<td>${x.getGiaGocString()  }</td>
													<td>${x.khuyenMai } %</td>
													<td>${x.soLuong }</td>
													<td>${x.getTongTienString() }</td>
												</tr>


											</c:forEach>


										</tbody>
									</table>
								</div>
								<!-- /.col -->
							</div>
							<!-- /.row -->

							<div class="row">
								<!-- accepted payments column -->
								<div class="col-6">
									
								</div>
								
								<div class="col-6">
									
									<div class="table-responsive">
										<table class="table">
										
											<tr>
												<th style="width: 50%">Tổng tiền:</th>
												<th>${hoaDon.getTongTienString() }</th>
											</tr>
											
										</table>
									</div>
								</div>
								<!-- /.col -->
							</div>
							<!-- /.row -->

							
						</div>
						<!-- /.invoice -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->

	<script type="text/javascript"
		src="${styleUrl}plugins/jquery/jquery.min.js"></script>
	<script src="${styleUrl }plugins/toastr/toastr.min.js"></script>

</body>
</html>