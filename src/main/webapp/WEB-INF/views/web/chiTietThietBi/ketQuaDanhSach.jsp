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


		
			<div class="row" class="san-pham__list">

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
		

	<script type="text/javascript"
		src="${styleUrlAdmin }plugins/jquery/jquery.min.js"></script>
	<script type="text/javascript"
		src="${styleUrl }js/chiTietVali/danhSachVali.js"></script>
</body>
</html>