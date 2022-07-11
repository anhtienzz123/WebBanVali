<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url value="/static/admin/" var="styleUrl" />


<c:forEach items="${valis}" var="x" varStatus="loop">

	<tr>

		<td>${loop.index + 1}</td>

		<td>${x.tenVali }</td>


		<td>${x.nhomVali }</td>
		<td>${x.thuongHieu }</td>
		<td>${x.soBienThe }</td>
		<td>${x.soLuong }</td>
		<td>${x.soDanhGia }</td>
		<td>${x.soBinhLuan }</td>


		<td><a onClick="xemChiTiet(${x.id})"
			class="btn btn-primary btn-sm xem" data-toggle="modal"
			data-target="#xem-modal"> <i class="fas fa-folder"></i> Xem
		</a> <a onClick="sua(${x.id})" class="btn btn-info btn-sm sua"
			data-toggle="modal" data-target="#sua-modal"> <i
				class="fas fa-pencil-alt"></i> Sửa
		</a> <a onClick="xoa(${x.id})" class="btn btn-danger btn-sm xoa"> <i
				class="fas fa-trash"> </i> Xóa
		</a></td>

	</tr>

</c:forEach>

