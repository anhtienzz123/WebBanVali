

const { origin, pathname } = location;

const URL_GET_NGUOI_DUNG = `${origin}${pathname}/v1/nguoi-dungs`;


let temptClear;


$("#liTruoc").click(function() {

	let page = parseInt($('#liTrang a').text());

	if (page == 1)
		return;

	$('#liTrang a').text(page - 1);

	capNhatDuLieu();

});

$("#liSau").click(function() {

	let page = parseInt($('#liTrang a').text());
	$('#liTrang a').text(page + 1);

	capNhatDuLieu(false);

});


$("#email").on("keyup", function() {

	$('#liTrang a').text('1');

	if (temptClear)
		clearTimeout(temptClear);

	temptClear = setTimeout(capNhatDuLieu, 1000);
});


$("#soDienThoai").on("keyup", function() {

	$('#liTrang a').text('1');

	if (temptClear)
		clearTimeout(temptClear);

	temptClear = setTimeout(capNhatDuLieu, 1000);
});


// loai true: tim kiem theo emai, soDienthoai
// loai false: next page

// return true: neu co du lieu
// return false: neu khong co du lieu
function capNhatDuLieu(loai = true) {

	let email = $("#email").val();
	let soDienThoai = $("#soDienThoai").val();
	let page = parseInt($('#liTrang a').text()) - 1;

	if (page == -1)
		return;

	let urlQuery = `${URL_GET_NGUOI_DUNG}?page=${page}&email=${email}&soDienThoai=${soDienThoai}`;
	console.log("origin: ", origin);
	console.log("pathname: ", pathname);


	location.hash = `?page=${page}&email=${email}&soDienThoai=${soDienThoai}`;



	$.get(urlQuery, function(data, status) {

		if (!loai && data.length == 0) {
			let page = parseInt($('#liTrang a').text());
			$('#liTrang a').text(page - 1);

			return;
		}


		renderDuLieu(data);
	});

}



// truyền vào dữ liệu và render ra
function renderDuLieu(data) {

	$("#tableBody").html("");

	$.each(data, (index, nguoiDung) => {
		const { id, hoTen, email, soDienThoai, diaChi, trangThai } = nguoiDung;

		const ketQuaRenderTrangThai = trangThai ? '<span class="badge badge-success">Hoạt động</span>' : '<span class="badge badge-warning">Chưa xác thực</span>';

		$("<tr>").appendTo($("#tableBody"))
			.append($("<td>").text(id))
			.append($("<td>").text(hoTen))
			.append($("<td>").text(email))
			.append($("<td>").text(soDienThoai))
			.append($("<td>").text(diaChi))
			.append($("<td>").html(ketQuaRenderTrangThai))
			.append(
				$("<td>").html(`<a  onClick="xemChiTietNguoiDung('${id}')"
													class="btn btn-primary btn-sm xem" data-toggle="modal"
													data-target="#xem-modal"> <i class="fas fa-folder">
													</i> Xem
												</a> <a 
													class="btn btn-info btn-sm sua" data-toggle="modal"
													data-target="#sua-modal"> <i class="fas fa-pencil-alt">
													</i> Sửa
												</a> <a onClick="xoaNguoiDung('${id}')"
													class="btn btn-danger btn-sm xoa"> <i
														class="fas fa-trash"> </i> Xóa
									</a>`));

	})
}



function xemChiTietNguoiDung(maNguoiDung) {

	const url = `${URL_GET_NGUOI_DUNG}/${maNguoiDung}`;

	$.get(url, function(data, status) {

		const { id, hoTen, gioiTinh, soDienThoai, email, diaChi, trangThai } = data;

		const gioiTinhResult = gioiTinh ? 'Nam' : 'Nữ';
		const trangThaiResult = trangThai ? 'Hoạt động' : 'Chưa xác nhận';

		if (status === 'success') {

			$("#xem-modal .maNguoiDung").html(`<span class="font-weight-bold">${id}</span>`);
			$("#xem-modal .hoTen").html(`<span class="font-weight-bold">${hoTen}</span>`);
			$("#xem-modal .gioiTinh").html(`<span class="font-weight-bold">${gioiTinhResult}</span>`);
			$("#xem-modal .soDienThoai").html(`<span class="font-weight-bold">${soDienThoai}</span>`);
			$("#xem-modal .email").html(`<span class="font-weight-bold">${email}</span>`);
			$("#xem-modal .diaChi").html(`<span class="font-weight-bold">${diaChi}</span>`);
			$("#xem-modal .trangThai").html(`<span class="font-weight-bold">${trangThaiResult}</span>`);
		}
	});
}


function xoaNguoiDung(maNguoiDung) {

	if (confirm("Bạn có chắc chắn xóa không ?")) {

		$.ajax({
			url: `${URL_GET_NGUOI_DUNG}/${maNguoiDung}`,
			type: 'DELETE',
			success: function(result) {
				location.reload();
			},
			error: function() {
				
				toastr.error('Xóa thất bại, người dùng đã có hóa đơn')
			},

		});

	}
}


