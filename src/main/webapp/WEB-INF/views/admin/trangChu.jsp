<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/static/admin/" var="styleUrl" />

<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">Trang chủ</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Dashboard v1</li>
					</ol>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content-header -->

	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<!-- Small boxes (Stat box) -->
			<div class="row">
				<div class="col-lg-3 col-6">
					<!-- small box -->
					<div class="small-box bg-info">
						<div class="inner">
							<h3>${thongKe.soHoaDonMoi }</h3>

							<p>Đơn hàng mới</p>
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
							<h3>${thongKe.soHoaDonThanhCong }</h3>

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
							<h3>${thongKe.soNguoiDungMoi }</h3>

							<p>Người dùng mới</p>
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
							<h3>${thongKe.soBinhLuanMoi }</h3>

							<p>Bình luận mới</p>
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

			<!-- Row 2 -->
			<div class="row">

				<div class="col-12">
					<div class="card card-primary">
						<div class="card-header">
							<h3 class="card-title">Hóa đơn trong ngày</h3>
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
											<td>${hd.trangThai }</td>
										</tr>
									
									</c:forEach>
								</tbody>
							</table>
							
						</div>




					</div>
				</div>
			</div>
			
			<!-- Row 3 -->
			<div class="row">

				<div class="col-12">
					<div class="card card-primary">
						<div class="card-header">
							<h3 class="card-title">Người dùng đăng kí trong ngày</h3>
						</div>


						<div class="card-body">
						
							<table class="table table-striped">
								<thead>
									<tr>
										<th scope="col">STT</th>
										<th scope="col">Họ tên</th>
										<th scope="col">Email</th>
										<th scope="col">Số điện thoại</th>
									</tr>
								</thead>
								<tbody>
									
									
									<c:forEach items="${nguoiDungs }" var="x" varStatus="loop">
										<tr> 
											<td>${loop.index +1 }</td>
											<td>${x.hoTen }</td>
											<td>${x.email }</td>
											<td>${x.soDienThoai }</td>
											
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