<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/static/web/" var="styleUrl" />
<c:url value="/static/admin/" var="styleUrlAdmin" />
<c:url value="/static/image/vali" var="valiImageUrl" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách sản phẩm</title>

<link rel="stylesheet"
	href="${styleUrl}css/chiTietVali/danhSachVali.css" />
</head>
<body id="bg-light">

	<!--Main-->
	<div class="main">
		<div class="row">
			<div class="col-3 khung-tim-kiem">
				<h3>Tìm kiếm</h3>

				<hr />

				<!--Nhóm vali-->
				<div>
					<h6>Nhóm vali</h6>

					<ul class="ml-3">

						<c:forEach items="${nhomValis}" var="x">

							<li>
								<div>
									<input class="nhomVali" type="checkbox" value="${x.key}"
										id="nhomVali-${x.key}" /> <label class="form-check-label p-0"
										for="nhomVali-${x.key}"> ${x.value } </label>
								</div>
							</li>

						</c:forEach>

					</ul>
				</div>
				<hr />
				<!--End nhóm vali-->

				<!-- Giá -->
				<div>
					<h6>Giá</h6>

					<ul class="ml-3">


						<c:forEach items="${gias}" var="x">

							<li>
								<div>
									<input class="gia" type="checkbox" value="${x.key}"
										id="gia-${x.key}" /> <label class="form-check-label p-0"
										for="gia-${x.key}"> ${x.value} </label>
								</div>
							</li>

						</c:forEach>


					</ul>
				</div>
				<hr />
				<!--End giá-->

				<!-- Thương hiệu -->
				<div>
					<h6>Thương hiệu</h6>

					<ul class="ml-3">

						<c:forEach items="${thuongHieus }" var="x">
							<li>
								<div>
									<input class="thuongHieu" type="checkbox" value="${x.key }"
										id="thuongHieu-${x.key }" /> <label
										class="form-check-label p-0" for="thuongHieu-${x.key }">
										${x.value } </label>
								</div>
							</li>

						</c:forEach>
					</ul>
				</div>
				<hr />
				<!--End thương hiệu-->

				<!--Chất liệu-->
				<div>
					<h6>Chất liệu</h6>

					<ul class="ml-3">

						<c:forEach items="${chatLieus }" var="x">
							<li>
								<div>
									<input class="chatLieu" type="checkbox" value="${x.key }"
										id="chatLieu-${x.key }" /> <label
										class="form-check-label p-0" for="chatLieu-${x.key }">
										${x.value } </label>
								</div>
							</li>

						</c:forEach>
					</ul>
				</div>
				<hr />
				<!--End chất liệu-->

				<!--Kích thước-->
				<div>
					<h6>Kích thước</h6>

					<ul class="ml-3">

						<c:forEach items="${kichThuocs }" var="x">
							<li>
								<div>
									<input class="kichThuoc" type="checkbox" value="${x.key }"
										id="kichThuoc-${x.key }" /> <label
										class="form-check-label p-0" for="kichThuoc-${x.key }">${x.value }
									</label>
								</div>
							</li>

						</c:forEach>
					</ul>
				</div>
				<hr />
				<!--End kích thước-->

				<!--Màu sắc-->

				<div>
					<h6>Màu sắc</h6>

					<ul class="ml-3">

						<c:forEach items="${mauSacs }" var="x">

							<li>
								<div>
									<input class="mauSac" type="checkbox" value="${x.key }"
										id="mauSac-${x.key }" /> <label class="form-check-label p-0"
										for="mauSac-${x.key }">${x.value }</label>
								</div>
							</li>
						</c:forEach>

					</ul>
				</div>
				<hr />
				<!--End màu sắc-->

				<!--Tính năng-->
				<div>
					<h6>Tính năng</h6>

					<ul class="ml-3">
						<c:forEach items="${tinhNangDacBiets }" var="x">
							<li>
								<div>
									<input class="tinhNang" type="checkbox" value="${x.key }"
										id="tinhNang-${x.key }" /> <label
										class="form-check-label p-0" for="tinhNang-${x.key }">
										${x.value }</label>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
				<hr />
				<!--End tính năng-->
			</div>
			<!--End khung tim kiem-->

			<div class="col-9 bg-light pl-3">
				<div class="san-pham">

					<div class="san-pham__header">
						<span>Sắp xếp theo: </span> <select class="form-control"
							id="loaiSapXep" style="width: 200px; display: inline-block">
							<option value="">Mặc định</option>
							<option value="gia-tang-dan">Giá tăng dần</option>
							<option value="gia-giam-dan">Giá giảm dần</option>
							<option value="khuyen-mai">Khuyến mãi</option>
						</select>
					</div>

					<div id="result-valis">
						<div class="row ">

							<c:forEach items="${valis }" var="x">


								<div class="col-3 san-pham__list__item">
									<div class="card card-san-pham" style="width: 100%;">
										<a
											href='<c:url value="/san-pham/${x.valiSlug}?kichThuoc=${x.kichThuocCode }&mauSac=${x.mauSacCode }" />'>
											<img src="${valiImageUrl}/${x.tenAnh}" class="card-img-top" />
										</a>
										<div class="card-body">
											<h6 class="card-title">${x.tenVali }</h6>
											<p class="card-text">
												<span
													style="font-weight: bold; color: #f7941e; font-size: 18px;">
													${x.getGiaString() } </span> <br />
												<del style="font-weight: 500; color: #888888">
													${x.getGiaGocString()}</del>
											</p>
											<span class="card-san-pham__khuyen-mai">${x.khuyenMai }%</span>
										</div>
									</div>

								</div>


							</c:forEach>


						</div>
					</div>




				</div>
			</div>
		</div>
	</div>
	<!--End main-->



	<script type="text/javascript"
		src="${styleUrlAdmin }plugins/jquery/jquery.min.js"></script>
	<script type="text/javascript"
		src="${styleUrl }js/chiTietVali/danhSachVali.js"></script>
</body>
</html>