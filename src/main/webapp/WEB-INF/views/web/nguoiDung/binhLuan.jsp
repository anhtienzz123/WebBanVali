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

					<span class="font-weight-bold">NHẬN XÉT CỦA TÔI</span>

					<div class="form-thong-tin mt-3">


						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Tên Sản Phẩm</th>
									<th>Ngày Bình Luận</th>
									<th>Đánh Giá</th>
									<th>Nội Dung Bình Luân</th>
									<th>Thao Tác</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${binhLuans }" var="o">
									<tr>
										<td><a
											href="#">${o.tenVali}</a></td>
										<td>${o.thoiGian }</td>
										<td>${o.soDanhGia}<img
											src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
											alt="" />
										</td>
										<td>${o.noiDung }</td>
										<td><a
										  href='<c:url value="/user/xoa-binh-luan?valiID=${o.valiID}&nguoiDungID=${o.nguoiDungID } "/>'									  
											class="btn btn-danger btn-sm xoa"> <i
												class="fas fa-trash"> </i> Xóa
										</a></td>
										
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
	
</body>
</html>
