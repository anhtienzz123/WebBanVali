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
<title>Chi tiết Vali</title>
<style type="text/css">
</style>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous" />

<link rel="stylesheet" href="${styleUrl}css/chiTietVali/chiTietVali.css" />


</head>
<body class="bg-light">

	<div class="main">
		<!-- Head-->
		<div class="bg-white">
			<div class="row info ">

				<!--left-->
				<div class="col-5 info__left">

					<img src="${valiImageUrl}/${vali.tenAnh}" width="100%" />
				</div>
				<!--end lef-->


				<div class="col-7 info__middle">

					<h4>${vali.tenVali }</h4>
					<div>
						<img
							src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
							alt="" /> <img
							src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
							alt="" /> <img
							src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
							alt="" /> <img
							src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
							alt="" /> <img
							src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
							alt="" /> <span> ${vali.soDanhGia } đánh giá</span>
					</div>
					<div>
						<p style="font-weight: bold;">
							Thương hiệu: <span class="text-danger">${vali.thuongHieu }</span>
						</p>
					</div>

					<hr>

					<div>
						<span class="info__middle__price">${vali.gia }</span>
						<del>${vali.giaGoc} </del>
						<span class="badge badge-danger">${vali.khuyenMai}%</span>
					</div>

					<div>
						<span style="font-weight: bold">Chọn màu sắc: </span> <br />

						<c:forEach items="${vali.mauSacs }" var="x">

							<a href='<c:url value="/san-pham/${x.code }" />'>
								<button type="button"
									class="button-custom ${x.chon ? 'active' : '' }">
									<span>${x.ten }</span> <br /> <span
										style="color: #e11b1e; font-weight: bold">${x.gia}</span>
								</button>
							</a>

						</c:forEach>

					</div>

					<div>
						<p style="font-weight: bold">Chọn kích thước:</p>
						<c:forEach items="${vali.kichThuocs }" var="x">

							<a href='<c:url value="/san-pham/${x.code }" />'>
								<button type="button"
									class="button-custom ${x.chon ? 'active' : '' }">
									<span>${x.ten }</span> <br /> <span
										style="color: #e11b1e; font-weight: bold">${x.gia}</span>
								</button>
							</a>

						</c:forEach>
					</div>



					<div>
						<div class="col-6">


							<a style="text-decoration: none;"
								href='<c:url value="/gio-hang/them-gio-hang?valiSlug=${vali.valiSlug}&kichThuocCode=${vali.kichThuocCode}&mauSacCode=${vali.mauSacCode}" />'>
								<button class="btn btn-outline-danger btn-block btn-lg"
									style="margin-top: 20px; font-weight: bold">Mua ngay</button>

							</a>
						</div>
					</div>

				</div>
			</div>
		</div>

		<!--End Head-->



		<!--Thong tin chi tiet-->
		<div class="bg-white  mt-3 p-2">
			<div class="row info-detail">
				<div class="col-8">${vali.moTa }</div>

				<div class="col-4">
					<table class="table">
						<tr>
							<th>Chất liệu:</th>
							<td>${vali.tenChatLieu }</td>
						</tr>

						<tr>
							<th>Trọng lượng:</th>
							<td>${vali.trongLuong}Kg</td>
						</tr>

						<tr>
							<th>Kích thước (dài x rộng x cao):</th>
							<td>${vali.moTaKichThuoc }</td>
						</tr>

						<tr>
							<th>Thể tích:</th>
							<td>${vali.theTich}L</td>
						</tr>

						<tr>
							<th>Bánh xe:</th>
							<td>${vali.banhXe }</td>
						</tr>

						<tr>
							<th>Dây kéo:</th>
							<td>${vali.dayKeo }</td>
						</tr>
						<tr>
							<th>Khóa:</th>
							<td>${vali.khoa }</td>
						</tr>

						<tr>
							<th>Thời gian bảo hành:</th>
							<td>${vali.thoiGianBaoHanh }</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!--End thong tin chi tiet-->




		<!--San pham lien quan  -->
		<div class="bg-white mt-3 p-2">

			<h5>Các sản phẩm liên quan</h5>
			<!-- tab -->
			<div class="card">
				<div class="card-header">
					<ul class=" nav nav-tabs card-header-tabs">
						<li class="nav-item"><a href="#tab1" data-toggle="tab"
							class="nav-link active">Sản phẩm bán chạy</a></li>

						<li class="nav-item"><a href="#tab2" data-toggle="tab"
							class="nav-link">Cùng thương hiệu</a></li>

						<li class="nav-item"><a href="#tab3" data-toggle="tab"
							class="nav-link">Cùng nhóm vali</a></li>


					</ul>
				</div>
			</div>
			<!-- Nội dung -->
			<div class="tab-content">

				<div class="tab-pane container active" id="tab1">
					<div class="card-body row">
						<c:forEach items="${valisBanChay }" var="v1">
							<div class="card col-3" style="width: 100%">
								<a
									href='<c:url value="/san-pham/${v1.valiSlug}?kichThuoc=${v1.kichThuocCode }&mauSac=${v1.mauSacCode }" />'><img
									src="${valiImageUrl}/${v1.tenAnh}" class="card-img-top"
									alt="..."></a>
								<div class="card-body">
									<h6 class="card-title">${v1.tenVali}</h6>
									<p class="card-text">

										<span class="color-and-bold">${v1.gia}</span> <br>
										<del>${v1.giaGocString}</del>
									</p>

								</div>
							</div>

						</c:forEach>
					</div>
				</div>
				<div class="tab-pane container fade" id="tab2">
					<div class="card-body row">
						<c:forEach items="${valisTheoThuongHieu }" var="v1">
							<div class="card col-3" style="width: 100%">
								<a
									href='<c:url value="/san-pham/${v1.valiSlug}?kichThuoc=${v1.kichThuocCode }&mauSac=${v1.mauSacCode }" />'><img
									src="${valiImageUrl}/${v1.tenAnh}" class="card-img-top"
									alt="..."></a>
								<div class="card-body">
									<h6 class="card-title">${v1.tenVali}</h6>
									<p class="card-text">

										<span class="color-and-bold">${v1.gia}</span><br>
										<del>${v1.giaGocString}</del>
									</p>

								</div>
							</div>

						</c:forEach>
					</div>
				</div>

				<div class="tab-pane container fade" id="tab3">
					<div class="card-body row">
						<c:forEach items="${valisTheoNhomVali }" var="v1">
							<div class="card col-3" style="width: 100%">
								<a
									href='<c:url value="/san-pham/${v1.valiSlug}?kichThuoc=${v1.kichThuocCode }&mauSac=${v1.mauSacCode }" />'><img
									src="${valiImageUrl}/${v1.tenAnh}" class="card-img-top"
									alt="..."></a>
								<div class="card-body">
									<h6 class="card-title">${v1.tenVali}</h6>
									<p class="card-text">

										<span class="color-and-bold">${v1.gia}</span><br>
										<del>${v1.giaGocString}</del>
									</p>

								</div>
							</div>

						</c:forEach>
					</div>
				</div>
			</div>
			<!--End cac san pham lien quan-->
		</div>

		<!--comment-->
		<div class="comment bg-white mt-3 p-2">

			<h5>${vali.soDanhGia } đánh giá về sản phẩm</h5>


			<div class="row mt-3">

				<div class="col-3 text-center">
					<span style="font-size: 24px">${valiComment.soDanhGiaTrungBinh}
					</span> <img
						src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
						alt="" />
				</div>


				<div class="col-4 t text-center">
					<table>
						<tr>
							<td style="width: 20%"><span>5 </span> <img
								src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
								alt="" /></td>
							<td style="width: 100%">
								<div class="progress">
									<div class="progress-bar bg-danger" role="progressbar"
										style="width: ${valiComment.nam}%"
										aria-valuenow="${valiComment.nam }" aria-valuemin="0"
										aria-valuemax="100"></div>
								</div>
							</td>

							<td style="margin-left: 10px">${valiComment.nam }%</td>
						</tr>

						<tr>
							<td style="width: 20%"><span>4 </span> <img
								src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
								alt="" /></td>
							<td style="width: 100%">
								<div class="progress">
									<div class="progress-bar bg-danger" role="progressbar"
										style="width:${valiComment.bon}%"
										aria-valuenow="${valiComment.bon}" aria-valuemin="0"
										aria-valuemax="100"></div>
								</div>
							</td>

							<td style="margin-left: 10px">${valiComment.bon}%</td>
						</tr>

						<tr>
							<td style="width: 20%"><span>3 </span> <img
								src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
								alt="" /></td>
							<td style="width: 100%">
								<div class="progress">
									<div class="progress-bar bg-danger" role="progressbar"
										style="width: ${valiComment.ba}%"
										aria-valuenow="${valiComment.ba }" aria-valuemin="0"
										aria-valuemax="100"></div>
								</div>
							</td>

							<td style="margin-left: 10px">${valiComment.ba }%</td>
						</tr>

						<tr>
							<td style="width: 20%"><span>2 </span> <img
								src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
								alt="" /></td>
							<td style="width: 100%">
								<div class="progress">
									<div class="progress-bar bg-danger" role="progressbar"
										style="width: ${valiComment.hai}%"
										aria-valuenow="${valiComment.hai }" aria-valuemin="0"
										aria-valuemax="100"></div>
								</div>
							</td>

							<td style="margin-left: 10px">${valiComment.hai }%</td>
						</tr>

						<tr>
							<td style="width: 20%"><span>1 </span> <img
								src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
								alt="" /></td>
							<td style="width: 100%">
								<div class="progress">
									<div class="progress-bar bg-danger" role="progressbar"
										style="width: ${valiComment.mot}%"
										aria-valuenow="${valiComment.mot}" aria-valuemin="0"
										aria-valuemax="100"></div>
								</div>
							</td>

							<td style="margin-left: 10px">${valiComment.mot}%</td>
						</tr>
					</table>
				</div>

				<div class="col-5">
					<sec:authorize access="!isAuthenticated()">

						<span style="font-size: 16px" class="badge badge-danger">Cần
							phải <a class="text-white" href="<c:url value="/login" />">Đăng
								nhập</a> để bình luận
						</span>

					</sec:authorize>
					<sec:authorize access="isAuthenticated()">

						<form method="get"
							action='<c:url value="/user/binh-luan-bai-viet"  />'>

							<div class="form-group row">
								<label class="col-sm-3 col-form-label">Nội dung</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="noiDung">
								</div>
							</div>

							<input type="hidden" name="valiSlug" value="${vali.valiSlug}" />
							<input type="hidden" name="mauSac" value="${vali.mauSacCode}" />
							<input type="hidden" name="kichThuoc"
								value="${vali.kichThuocCode}" />

							<fieldset class="form-group row">
								<legend class="col-form-label col-sm-3 float-sm-left pt-0">Đánh
									giá</legend>

								<div class="col-sm-9">

									<div class="form-check-inline">
										<input class="form-check-input" type="radio" name="rate"
											value="1"> <label class="form-check-label"> 1
										</label> <img
											src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
											alt="" />
									</div>

									<div class="form-check-inline">
										<input class="form-check-input" type="radio" name="rate"
											value="2"> <label class="form-check-label"> 2
										</label> <img
											src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
											alt="" />
									</div>


									<div class="form-check-inline">
										<input class="form-check-input" type="radio" name="rate"
											value="3"> <label class="form-check-label"> 3
										</label> <img
											src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
											alt="" />
									</div>

									<div class="form-check-inline">
										<input class="form-check-input" type="radio" name="rate"
											value="4"> <label class="form-check-label"> 4
										</label> <img
											src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
											alt="" />
									</div>

									<div class="form-check-inline">
										<input class="form-check-input" type="radio" name="rate"
											value="5" checked="checked"> <label
											class="form-check-label"> 5 </label> <img
											src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
											alt="" />
									</div>
								</div>
							</fieldset>

							<div class="form-group row">
								<div class="col-sm-10">
									<button class="btn btn-danger" type="submit">Gởi đánh
										giá của bạn</button>
								</div>
							</div>
						</form>



					</sec:authorize>

				</div>
			</div>
			<!--người dùng comment-->
			<div>
				<ul class="list-group list-group-flush">

					<c:forEach items="${valiComment.binhLuanDTOs}" var="x">
						<li class="list-group-item">
							<div>
								<span> <span style="font-weight: bold">${x.tenNguoiDung }

								</span> || ${x.thoiGian} || <c:forEach var="i" begin="1"
										end="${x.soDanhGia }">

										<img
											src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
											alt="" />

									</c:forEach>



								</span> <br> <span>${x.noiDung }</span>

								<sec:authorize access="hasRole('ADMIN')">

									<a
	href='<c:url value="/admin/binh-luan/xoa?nguoiDungId=${x.nguoiDungID }&valiId=${x.valiID}&valiSlug=${vali.valiSlug}&kichThuocCode=${vali.kichThuocCode}&mauSacCode=${vali.mauSacCode}"
											
										 />'   >Xóa</a>

								</sec:authorize>


							</div>
						</li>
					</c:forEach>


				</ul>
			</div>


		</div>

		<!--  end comment -->


	</div>


	<script type="text/javascript"
		src="${styleUrlAdmin }plugins/jquery/jquery.min.js"></script>
	<!-- Toastr -->
	<script src="${styleUrl }plugins/toastr/toastr.min.js"></script>
	
	<script type="text/javascript">
	
	</script>
</body>
</html>