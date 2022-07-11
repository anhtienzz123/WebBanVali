<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/static/admin/" var="styleUrl" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết biến thể vali</title>
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

							
							<div class="row">
								
								
								<div class="col-12">
									
									<div class="table-responsive">
										<table class="table">
										
											<tr>
												<th style="width: 40%">Tên vali:</th>
												<th>${data.tenVali }</th>
											</tr>
											
											<tr>
												<th style="width: 40%">Kích thước</th>
												<th>${data.tenKichThuoc }</th>
											</tr>
											
											<tr>
												<th style="width: 40%">Màu sắc</th>
												<th>${data.tenMau }</th>
											</tr>
											
											<tr>
												<th style="width: 40%">Bánh xe</th>
												<th>${data.banhXe }</th>
											</tr>
											
											<tr>
												<th style="width: 40%">Dây kéo</th>
												<th>${data.dayKeo }</th>
											</tr>
											
											<tr>
												<th style="width: 40%">Khóa</th>
												<th>${data.khoa }</th>
											</tr>
											
											<tr>
												<th style="width: 40%">Thời gian bảo hành</th>
												<th>${data.thoiGianBaoHanh }</th>
											</tr>
											
											<tr>
												<th style="width: 40%">Thể tích</th>
												<th>${data.theTich }</th>
											</tr>
											
											<tr>
												<th style="width: 40%">Trọng lượng</th>
												<th>${data.trongLuong }</th>
											</tr>
											
											<tr>
												<th style="width: 40%">Mô tả kích thước</th>
												<th>${data.moTaKichThuoc }</th>
											</tr>
											
											<tr>
												<th style="width: 40%">Nổi bật</th>
												<th>${data.noiBat }</th>
											</tr>
											
											<tr>
												<th style="width: 40%">Chất liệu</th>
												<th>${data.tenChatLieu }</th>
											</tr>
											
											<tr>
												<th style="width: 40%">Nhóm vali</th>
												<th>${data.tenNhomVali }</th>
											</tr>
											
											<tr>
												<th style="width: 40%">Thương hiệu</th>
												<th>${data.tenThuongHieu }</th>
											</tr>
											
											
											<tr>
												<th style="width: 40%">Giá</th>
												<th>${data.gia }</th>
											</tr>
											
											<tr>
												<th style="width: 40%">Khuyến mãi</th>
												<th>${data.khuyenMai }</th>
											</tr>
											
											<tr>
												<th style="width: 40%">Số lượng</th>
												<th>${data.soLuong }</th>
											</tr>
											
											<tr>
												<th style="width: 40%">Ảnh</th>
												<th>
													<img alt="" width="50%" src='<c:url value="/static/image/vali/${data.anh }"  />'>
												</th>
											</tr>
											
											<tr>
												<th style="width: 40%">Mô tả</th>
												<th>
													 ${data.moTa }
												</th>
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