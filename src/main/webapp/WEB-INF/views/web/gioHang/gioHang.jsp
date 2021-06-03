<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<c:url value="/static/web/" var="styleUrl" />
<c:url value="/static/admin/" var="styleUrlAdmin" />
<c:url value="/static/image/vali" var="valiImageUrl" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous" />

<link rel="stylesheet" href="${styleUrl}css/gioHang/gioHang.css" />

</head>
<body class="bg-light">

	<div class="main">
		<div class="row">
			<!--ben trai-->
			<div class="col-8 bg-white product-list">

				<!-- thong tin moi san pham-->

				<c:forEach items="${cart.cartBienTheValiItemDTOs }" var="x">
					<div class="row">
						<div class="col-3">
							<img src="${valiImageUrl}/${x.bienTheValiDTO.tenAnh }" alt=""
								width="100%" />
						</div>
						<div class="col-6">
							<p>
								<a style="font-size: 20px; color: black; font-weight: 500"
									href="<c:url value="/san-pham/${x.bienTheValiDTO.valiSlug }?kichThuoc=${x.bienTheValiDTO.kichThuocCode}&mauSac=${x.bienTheValiDTO.mauSacCode}" />">

									${x.bienTheValiDTO.tenVali }</a>
							</p>

							<span style="font-weight: bold">${ x.bienTheValiDTO.getGiaString()}</span>
							<br />
							<del style="color: lightgray; font-weight: bold">${ x.bienTheValiDTO.getGiaGocString()}</del>
							<span class="badge badge-danger">-${x.bienTheValiDTO.khuyenMai}%</span>
							<br />

							<c:if test="${x.trangThai }">
								<span class="badge badge-danger">Không đủ số lượng</span>
							</c:if>


						</div>

						<div class="col-3">
							<div class="btn-group" role="group" aria-label="Basic example"
								style="border: 1px solid #e6e6e6">
								<a
									href='<c:url value="/gio-hang/giam-gio-hang?valiSlug=${x.bienTheValiDTO.valiSlug}&kichThuocCode=${x.bienTheValiDTO.kichThuocCode }&mauSacCode=${x.bienTheValiDTO.mauSacCode }" />'>

									<button type="button" class="btn btn-default">
										<i class="fas fa-minus"></i>
									</button>
								</a>

								<button type="button" class="btn btn-default">${x.soLuong }</button>

								<a
									href='<c:url value="/gio-hang/them-gio-hang?valiSlug=${x.bienTheValiDTO.valiSlug}&kichThuocCode=${x.bienTheValiDTO.kichThuocCode }&mauSacCode=${x.bienTheValiDTO.mauSacCode }" />'>
									<button type="button" class="btn btn-default">
										<i class="fas fa-plus"></i>
									</button>
								</a>
							</div>

							<!--Thanh tien-->
							<div class="mt-1">
								<span>Thành tiền</span> <br /> <span
									style="color: #f7941e; font-weight: bold">${x.getThanhTienString()}</span>
							</div>
						</div>
					</div>
					<hr />
				</c:forEach>

				<!--End thong tin moi san pham-->
			</div>
			<!--End cot ben trai-->

			<!-- ben phai-->
			<div class="col-4">
				<!-- dia chi nhan hang-->
				<div>
					<div class="card"
						style="border: 1px solid white; border-radius: 5px">
						<div class="card-body">

							<sec:authorize access="isAuthenticated()">
								<div>
									<h5 class="card-title">${nguoiDung.hoTen }</h5>
									<h6 class="card-subtitle mb-2 text-muted">${nguoiDung.soDienThoai }</h6>
									<p class="card-text text-muted" style="font-weight: 500">
										<span>${nguoiDung.diaChi.concat(", ") } </span> <span>${nguoiDung.phuongXa.concat(", ") }
										</span> <span>${nguoiDung.quanHuyen.concat(", ")} </span> <span>${nguoiDung.tinhThanhPho.concat(".") }
										</span>
									</p>
									<hr />
								</div>
							</sec:authorize>


							<!-- tong tien-->
							<div>
								<div>
									<span class="text-muted">Thành tiền: </span> <span
										style="float: right; font-weight: 500">${ cart.getThanhTienString()}</span>
								</div>

								<div>
									<span class="text-muted">Tổng tiền: </span> <span
										style="float: right; font-weight: bold; color: #f7941e">${ cart.getThanhTienString() }</span>
								</div>


								<c:if test="${!cart.getTrangThai() }">
									<a href='<c:url value="/gio-hang/dat-hang" />'>
										<button
											class="btn btn-outline-danger btn-block mt-2 btn-dat-hang">


											<span> Đặt hàng</span>
										</button>
									</a>
								</c:if>
								
								<c:if test="${cart.getTrangThai() }">
									<a href=''>
										<button
											class="btn btn-outline-danger btn-block mt-2 btn-dat-hang"
												disabled="disabled"
											>
											

											<span>Không thể đặt hàng</span>
										</button>
									</a>
								</c:if>
								
								


								<!-- 
									<sec:authorize access="!isAuthenticated()">
									<a href='<c:url value="/login"  />'>
										<button
											class="btn btn-outline-danger btn-block mt-2 btn-dat-hang">
											<span>Bạn cần đăng nhập để đặt hàng</span>
										</button>
									</a>
								</sec:authorize>
								
								 -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript"
		src="${styleUrlAdmin }plugins/jquery/jquery.min.js"></script>
</body>
</html>