<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<c:url value="/static/web/" var="styleUrl" />
<c:url value="/static/admin/" var="styleUrlAdmin" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${styleUrl }css/nguoiDung/nguoiDung.css">
</head>
<body>
	<div class="main bg-light">

		<div class="bg-white" style="width: 80%; margin: 0 auto;">

			<div class="row">

				<div id="danh-muc" class="col-4 bg-light">

					<div class="card">
						<div class="card-header bg-white px-4 py-4">
							<span class="text-warning font-weight-bold">TÀI KHOẢN</span>
						</div>
						<ul class="list-group list-group-flush"
							style="width: 90%; margin: 0 auto;">
							<li class="list-group-item"><a
								href=' <c:url value="/user/thong-tin" />'>Thông tin tài
									khoản</a></li>
							<li class="list-group-item"><a
								href=' <c:url value="/user/doi-mk" />'> Đổi mật khẩu</a></li>
							<li class="list-group-item"><a
								href=' <c:url value="/user/don-hang" />'>Đơn hàng của tôi</a></li>
							<li class="list-group-item"><a
								href=' <c:url value="/user/binh-luan" />'>Nhận xét của tôi</a></li>
						</ul>
					</div>

				</div>


				<div class="col-8 px-4 py-2 border bg-white rounded">

					<span class="font-weight-bold">ĐƠN HÀNG CỦA TÔI</span>

					<div class="form-thong-tin mt-3">

						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Mã Đơn</th>
									<th>Ngày Đặt</th>
									<th>Tên Vali</th>
									<th>Tổng Tiền</th>
									<th>Trạng Thái</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${donHangs }" var="o">
									<tr>
										<td>${o.id}</td>
										<td>${o.thoiGianDat }</td>
 										<td>${o.tenVali}</td>
 										<td>${o.tongTien }</td>
										<td>${o.trangThaiDonHang }</td>
									</tr>

								</c:forEach>
							</tbody>

						</table>



					</div>

				</div>


			</div>



		</div>

	</div>

	<script type="text/javascript"
		src="${styleUrlAdmin }plugins/jquery/jquery.min.js"></script>
	<script type="text/javascript"
		src="${styleUrl }js/nguoiDung/doiMatKhau.js"></script>
</body>
</html>
