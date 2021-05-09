<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/static/image/vali" var="valiImageUrl" />


<div>

	<c:forEach items="${valis }" var="x">
		<!--Moi san pham-->
		<div>
			<div class="san-pham__list__item">
				<div class="card card-san-pham" style="width: 100%; border: 1px solid white;">
					<img src="${valiImageUrl}/${x.tenAnh}" class="card-img-top" />
					<div class="card-body">
						<h6 class="card-title">${x.tenVali }</h6>
						<p class="card-text">
							<span style="font-weight: bold; color: #f7941e; font-size: 18px;">
								${x.getGiaString() } </span> <br />
							<del style="font-weight: 500; color: #888888">
								${x.getGiaGocString()}</del>
						</p>
						<span class="card-san-pham__khuyen-mai">${x.khuyenMai }%</span>
					</div>
				</div>
			</div>
		</div>

		<!--End moi san pham-->

	</c:forEach>
</div>