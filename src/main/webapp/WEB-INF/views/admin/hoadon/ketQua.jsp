<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach items="${hoaDons}" var="x">

	<tr>

		<td>${x.id }</td>

		<td>${x.hoTenKhachHang }</td>

		<td>${x.soDienThoaiGiaoHang }</td>

		<td>${x.thoiGianDat }</td>
		<td>${x.tongTien }</td>




		<td>
			<!-- Đang chờ xử lý --> <c:if
				test="${x.trangThaiDonHang == 'Đang chờ xử lý' }">

				<div class="btn-group" role="group">
					<button id="btnGroupDrop1" type="button"
						class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">${ x.trangThaiDonHang}</button>
					<div class="dropdown-menu" aria-labelledby="btnGroupDrop1">

						<a class="dropdown-item" href="#"
							onclick="capNhatTrangThai(${x.id}, 'Đang xử lý')">Đang xử lý</a>
						<a class="dropdown-item" href="#"
							onclick="capNhatTrangThai(${x.id}, 'Hủy đơn hàng')">Hủy đơn
							hàng</a>
					</div>

				</div>

			</c:if> <c:if test="${x.trangThaiDonHang == 'Đang xử lý' }">

				<div class="btn-group" role="group">
					<button id="btnGroupDrop2" type="button"
						class="btn btn-warning dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">${ x.trangThaiDonHang}</button>
					<div class="dropdown-menu" aria-labelledby="btnGroupDrop2">

						<a class="dropdown-item" href="#"
							onclick="capNhatTrangThai(${x.id}, 'Đang vận chuyển')">Đang
							vận chuyển</a> <a class="dropdown-item" href="#"
							onclick="capNhatTrangThai(${x.id}, 'Hủy đơn hàng')">Hủy đơn
							hàng</a>
					</div>

				</div>

			</c:if> <c:if test="${x.trangThaiDonHang == 'Đang vận chuyển' }">

				<div class="btn-group" role="group">
					<button id="btnGroupDrop3" type="button"
						class="btn btn-info dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">${ x.trangThaiDonHang}</button>
					<div class="dropdown-menu" aria-labelledby="btnGroupDrop3">

						<a class="dropdown-item" href="#"
							onclick="capNhatTrangThai(${x.id}, 'Giao hàng thành công')">Giao
							hàng thành công</a> <a class="dropdown-item" href="#"
							onclick="capNhatTrangThai(${x.id}, 'Hủy đơn hàng')">Hủy đơn
							hàng</a>
					</div>

				</div>

			</c:if> <c:if test="${x.trangThaiDonHang == 'Giao hàng thành công' }">

				<div class="btn-group" role="group">
					<button id="btnGroupDrop4" type="button" class="btn btn-success">${ x.trangThaiDonHang}</button>


				</div>

			</c:if> <c:if test="${x.trangThaiDonHang == 'Hủy đơn hàng' }">
				<div class="btn-group" role="group">
					<button id="btnGroupDrop5" type="button" class="btn btn-danger">${ x.trangThaiDonHang}</button>


				</div>


			</c:if>

		</td>

		<td><a href='<c:url value="/admin/hoa-don/${x.id}"  />'
			class="btn btn-primary btn-sm xem"> <i
				class="fas fa-folder"></i> Xem
		</a>
	</tr>

</c:forEach>

