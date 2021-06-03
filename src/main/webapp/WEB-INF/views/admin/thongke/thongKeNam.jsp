<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/static/admin/" var="styleUrl" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thống kê năm</title>
</head>
<body>

	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<div class="content-header">
			<div class="container-fluid">
			
			
				<div class="row mb-2">
					<div class="col-sm-12"
						style="background: white; padding: 20px; border-radius: 5px">

						<span>Chọn thời gian: </span> <select class="form-control"
							style="width: 20%; display: inline" id="namSelect">
							<option value="2018" ${nam == 2018 ? 'selected' : '' }>2018</option>
							<option value="2019" ${nam == 2019 ? 'selected' : '' }>
								2019</option>
							<option value="2020" ${nam == 2020 ? 'selected' : '' }>
								2020</option>
							<option value="2021" ${nam == 2021 ? 'selected' : '' }>
								2021</option>
							<option value="2022" ${nam == 2022 ? 'selected' : '' }>
								2022</option>
							<option value="2023" ${nam == 2023 ? 'selected' : '' }>
								2023</option>
							<option value="2024" ${nam == 2024 ? 'selected' : '' }>
								2024</option>
							<option value="2025" ${nam == 2025 ? 'selected' : '' }>
								2025</option>

						</select>

					</div>



				</div>

			</div>

		</div>
		<!-- /.content-header -->

		<!-- Main content -->
		<section class="content">
			<div class="container-fluid" id="result">
				
				<div class="row">
					<div class="col-lg-3 col-6">
						<!-- small box -->
						<div class="small-box bg-info">
							<div class="inner">
								<h3>${soHoaDon}</h3>

								<p>Tất cả đơn hàng</p>
							</div>
							<div class="icon">
								<i class="ion ion-bag"></i>
							</div>

						</div>
					</div>
					<!-- ./col -->
					<div class="col-lg-3 col-6">
						<!-- small box -->
						<div class="small-box bg-success">
							<div class="inner">
								<h3>${soHoaDonThanhCong }</h3>

								<p>Đơn hàng thành công</p>
							</div>
							<div class="icon">
								<i class="ion ion-stats-bars"></i>
							</div>

						</div>
					</div>
					<!-- ./col -->
					<div class="col-lg-3 col-6">
						<!-- small box -->
						<div class="small-box bg-warning">
							<div class="inner">
								<h3>${doanhThu }</h3>

								<p>Doanh thu</p>
							</div>
							<div class="icon">
								<i class="ion ion-person-add"></i>
							</div>

						</div>
					</div>
					<!-- ./col -->
					<div class="col-lg-3 col-6">
						<!-- small box -->
						<div class="small-box bg-danger">
							<div class="inner">
								<h3>${soNguoiDung }</h3>

								<p>Người dùng mới</p>
							</div>
							<div class="icon">
								<i class="ion ion-pie-graph"></i>
							</div>
							<!-- 
							<a href="#" class="small-box-footer">Xem <i
							class="fas fa-arrow-circle-right"></i></a>
						 -->
						</div>
					</div>
					<!-- ./col -->
				</div>
				<!-- /.row -->

				<!-- row 2 -->
				<div class="row">

					<div class="col-12">
						<div class="card card-primary">
							<div class="card-header">
								<h3 class="card-title">Sản phẩm trong năm</h3>
							</div>


							<div class="card-body">

								<table class="table table-striped">

									<thead>
										<tr>
											<th scope="col">STT</th>
											<th scope="col">Tên vali</th>
											<th scope="col">Số lượng</th>
											<th scope="col">Doanh thu</th>
										</tr>
									</thead>

									<tbody>


										<c:forEach items="${hoaDonThongKes }" var="x" varStatus="loop">
											<tr>
												<td>${loop.index +1 }</td>
												<td>${x.tenVali }</td>
												<td>${x.soLuong }</td>
												<td>${x.doanhThu }</td>

											</tr>

										</c:forEach>

									</tbody>
								</table>

							</div>




						</div>
					</div>
				</div>

				<!-- row 3 -->
				<div class="row">

					<div class="col-12">
						<div class="card card-primary">
							<div class="card-header">
								<h3 class="card-title">Hóa đơn trong năm</h3>
							</div>


							<div class="card-body">

								<table class="table table-striped">
									<thead>
										<tr>
											<th scope="col">STT</th>
											<th scope="col">Mã hóa đơn</th>
											<th scope="col">Họ tên</th>
											<th scope="col">Email</th>
											<th scope="col">Tổng tiền</th>
											<th scope="col">Trạng thái</th>
										</tr>
									</thead>
									<tbody>


										<c:forEach items="${hoaDons }" var="hd" varStatus="loop">
											<tr>
												<td>${loop.index +1 }</td>
												<td>${hd.id }</td>
												<td>${hd.hoTen }</td>
												<td>${hd.email }</td>
												<td>${hd.getTongTienString()}</td>
												<td><c:if test="${hd.trangThai == 'Đang chờ xử lý' }">
														<span class="badge badge-primary">Đang chờ xử lý</span>
													</c:if> <c:if test="${hd.trangThai == 'Đang xử lý' }">
														<span class="badge badge-warning">Đang xử lý</span>
													</c:if> <c:if test="${hd.trangThai == 'Đang vận chuyển' }">
														<span class="badge badge-info">Đang vận chuyển</span>
													</c:if> <c:if test="${hd.trangThai == 'Giao hàng thành công' }">
														<span class="badge badge-success">Giao hàng thành
															công</span>
													</c:if> <c:if test="${hd.trangThai == 'Hủy đơn hàng' }">
														<span class="badge badge-danger">Hủy đơn hàng</span>
													</c:if></td>
											</tr>

										</c:forEach>
									</tbody>
								</table>

							</div>




						</div>
					</div>
				</div>





			</div>
			<!-- /.container-fluid -->
		</section>
		<!-- /.content -->
	</div>

	<script src="${styleUrl }plugins/jquery/jquery.min.js"></script>
	<script src="${styleUrl }js/thongke/thongKeNam.js"></script>
</body>
</html>

