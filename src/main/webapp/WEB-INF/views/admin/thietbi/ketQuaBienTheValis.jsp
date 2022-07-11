<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url value="/static/admin/" var="styleUrl" />

<c:forEach items="${bienTheValis}" var="x" varStatus="loop">

	<tr>


		<td>${loop.index + 1}</td>
		<td>${x.tenVali }</td>
		<td>${x.tenKichThuoc }</td>
		<td>${x.tenMauSac }</td>
		<td>${x.soLuong }</td>
		<td>${x.gia }</td>
		<td>${x.khuyenMai }</td>
		<td><c:if test="${x.noiBat}">

				<span class="badge badge-success">Nổi bật</span>
			</c:if> <c:if test="${x.noiBat == false}">

				<span class="badge badge-danger">Mặc định</span>
			</c:if></td>


		<td><a class="btn btn-primary btn-sm xem" data-toggle="modal"
			data-target="#xem-modal"> <i class="fas fa-folder"></i> Xem
		</a> <a class="btn btn-info btn-sm sua"
			href='<c:url value="/admin/vali/sua-bien-the-vali?valiId=${x.valiId}&kichThuocId=${x.kichThuocId }&mauSacId=${x.mauSacId }" />'>
				<i class="fas fa-pencil-alt"></i> Sửa
		</a> <a onclick="xoa(${x.valiId}, ${x.kichThuocId }, ${x.mauSacId })"
			class="btn btn-danger btn-sm xoa"> <i class="fas fa-trash"> </i>
				Xóa
		</a></td>

	</tr>

</c:forEach>
