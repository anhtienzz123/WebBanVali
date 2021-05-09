<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:url value="/static/web/" var="styleUrl" />
<c:url value="/static/admin/" var="styleUrlAdmin" />
<c:url value="/static/image/vali" var="valiImageUrl" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết Vali</title>

 	<link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
      integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
      crossorigin="anonymous"
    />
    
    <link rel="stylesheet" href="${styleUrl}css/chiTietVali/chiTietVali.css" />
    

</head>
<body class="bg-light">

	<div class="main">

		<!-- Head-->
		<div class="bg-white">
			<div class="row info ">

				<!--left-->
				<div class="col-5 info__left">

					<img
						src="${valiImageUrl}/${vali.tenAnh}" width="100%" />
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
								<button type="button" class="button-custom ${x.chon ? 'active' : '' }">
									<span>${x.ten }</span> <br /> 
									<span style="color: #e11b1e; font-weight: bold">${x.gia}</span>
								</button>
							</a>
							
						</c:forEach>
						
					</div>

					<div>
						<p style="font-weight: bold">Chọn kích thước:</p>
						<c:forEach items="${vali.kichThuocs }" var="x">
						
							<a href='<c:url value="/san-pham/${x.code }" />'>
								<button type="button" class="button-custom ${x.chon ? 'active' : '' }">
									<span>${x.ten }</span> <br /> 
									<span style="color: #e11b1e; font-weight: bold">${x.gia}</span>
								</button>
							</a>
							
						</c:forEach>
					</div>



					<div>
						<div class="col-6">
							
							 
							 <a style="text-decoration: none; " href='<c:url value="/gio-hang/them-gio-hang?valiSlug=${vali.valiSlug}&kichThuocCode=${vali.kichThuocCode}&mauSacCode=${vali.mauSacCode}" />'>
								<button class="btn btn-outline-danger btn-block btn-lg" 
									style="margin-top: 20px; font-weight: bold">
								Mua ngay
								
								</button>
								
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
				<div class="col-8">
					${vali.moTa }
				</div>

				<div class="col-4">
					<table class="table">
						<tr>
							<th>Chất liệu:</th>
							<td>${vali.tenChatLieu }</td>
						</tr>

						<tr>
							<th>Trọng lượng:</th>
							<td>${vali.trongLuong} Kg</td>
						</tr>

						<tr>
							<th>Kích thước (dài x rộng x cao):</th>
							<td>${vali.moTaKichThuoc }</td>
						</tr>

						<tr>
							<th>Thể tích:</th>
							<td>${vali.theTich} L</td>
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

			<div class="card">

				<div class="card-header">
					<ul class="nav nav-tabs card-header-tabs">
						<li class="nav-item"><a class="nav-link active" href="#">Sản
								phẩm bán chạy</a></li>
						<li class="nav-item"><a class="nav-link " href="#">Cùng
								thương hiệu</a></li>
						<li class="nav-item"><a class="nav-link disabled" href="#"
							tabindex="-1" aria-disabled="true">Cùng nhóm vali</a></li>
					</ul>
				</div>
				<div class="card-body row">
					<div class="card col-3" style="width: 100%">
						<img
							src="https://cdn0.fahasa.com/media/catalog/product/cache/1/small_image/400x400/9df78eab33525d08d6e5fb8d27136e95/i/m/image_180436.jpg"
							class="card-img-top" alt="...">
						<div class="card-body">
							<h6 class="card-title">Vali Pisani Rayan PP008_28</h6>
							<p class="card-text">

								<span class="color-and-bold">20.000.000đ</span>
								<del>20.000.000đ</del>
							</p>

						</div>
					</div>

					
				</div>

			</div>
		</div>
		<!--End cac san pham lien quan-->


		<!--comment-->
		<div class="comment bg-white mt-3 p-2">

			<h5>${vali.soDanhGia } đánh giá về sản phẩm</h5>


			<div class="row mt-3">
				<div class="col-4 text-center">
					<span style="font-size: 24px">${valiComment.soDanhGiaTrungBinh} </span> <img
						src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
						alt="" />
				</div>

				<div class="col-4 text-center">
					<table>
						<tr>
							<td style="width: 20%"><span>5 </span> <img
								src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
								alt="" /></td>
							<td style="width: 100%">
								<div class="progress">
									<div class="progress-bar bg-danger" role="progressbar"
										style="width: ${valiComment.nam}%" aria-valuenow="${valiComment.nam }" aria-valuemin="0"
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
										style="width:${valiComment.bon}%" aria-valuenow="${valiComment.bon}" aria-valuemin="0"
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
										style="width: ${valiComment.ba}%" aria-valuenow="${valiComment.ba }" aria-valuemin="0"
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
										style="width: ${valiComment.hai}%" aria-valuenow="${valiComment.hai }" aria-valuemin="0"
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
										style="width: ${valiComment.mot}%" aria-valuenow="${valiComment.mot}" aria-valuemin="0"
										aria-valuemax="100"></div>
								</div>
							</td>

							<td style="margin-left: 10px">${valiComment.mot}%</td>
						</tr>
					</table>
				</div>

				<div class="col-4 text-center">
					<sec:authorize access="!isAuthenticated()">
  						
  						<span style="font-size: 16px" class="badge badge-danger">Cần phải <a class="text-white" href="<c:url value="/login" />">Đăng nhập</a> để bình luận   </span>
  						
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
 						 <button class="btn btn-danger">Gởi đánh giá của bạn</button>
					</sec:authorize>
					
				</div>
			</div>

			<!--người dùng comment-->
			<div>
				<ul class="list-group list-group-flush">
				
					<c:forEach items="${valiComment.binhLuanDTOs}" var="x">
						<li class="list-group-item">
							<div>
								<span>
								
									<span
										style="font-weight: bold">${x.tenNguoiDung }
								
									</span>
									|| ${x.thoiGian} ||
									<c:forEach var = "i" begin = "1" end = "${x.soDanhGia }">
				
										<img
											src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
											alt="" />   
											
									</c:forEach>
						
									
								
								</span>
								<br>
								 <span>${x.noiDung }</span>
							</div>
						</li>
					</c:forEach>
					
				
				</ul>
			</div>


		</div>

        <!--  end comment -->
	</div>

	

	

	<script type="text/javascript" src="${styleUrlAdmin }plugins/jquery/jquery.min.js"></script>
	
	
</body>
</html>