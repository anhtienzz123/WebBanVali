
function xemChiTiet(nhomThuongHieuId) {

	const url = `api/${nhomThuongHieuId}`;
	console.log('url: ', url);

	$.get(url, function(data, status) {

		const { id, tenThuongHieu, code } = data;

		if (status === 'success') {

			$("#xem-modal .id").html(`<span class="font-weight-bold">${id}</span>`);
			$("#xem-modal .tenThuongHieu").html(`<span class="font-weight-bold">${tenThuongHieu}</span>`);
			$("#xem-modal .code").html(`<span class="font-weight-bold">${code}</span>`);

		}
	});
}


function xoa(nhomThuongHieuId) {

	if (confirm("Bạn có chắc chắn xóa không ?")) {

		$.ajax({
			url: `api/${nhomThuongHieuId}`,
			type: 'DELETE',
			success: function() {

				capNhatDuLieu("");
				toastr.success('Xóa thành công')

			},
			error: function() {
				toastr.error('Không xóa được, vì đã có sản phẩm dùng')
			},

		});

	}
} 


$('#btnThem').click(function() {

	const giaTriDaNhap = $('#them-modal #tenThuongHieuThem').val();

	if (giaTriDaNhap.trim().length == 0) {
		$('#them-modal #errThem').text('Tên thương hiệu không được bỏ trống');
		return;
	}

	const url = "api";

	$.post(url, { tenThuongHieu: giaTriDaNhap }, function(data, status) {

		if (status === 'error') {
			toastr.error('Tên thương hiêu đã bị trùng');
			$('#them-modal #errThem').text('Tên thương hiệu đã trùng');

		} else {
			$('#them-modal').modal('hide');
			toastr.success('Thêm thành công')

			const { id, tenThuongHieu, code } = data;

			$("<tr>").appendTo($("#tableBody"))
				.append($("<td>").text(id))
				.append($("<td>").text(tenThuongHieu))
				.append($("<td>").text(code))
				.append(

					$("<td>").html(`
							<a   onClick="xemChiTiet('${id}')" 
													class="btn btn-primary btn-sm xem" data-toggle="modal"
													data-target="#xem-modal"> <i class="fas fa-folder">
													</i> Xem
												</a> <a 
													class="btn btn-info btn-sm sua" data-toggle="modal"
													data-target="#sua-modal"> <i class="fas fa-pencil-alt">
													</i> Sửa
												</a> <a onClick="xoa('${id}')" 
													class="btn btn-danger btn-sm xoa"> <i
														class="fas fa-trash"> </i> Xóa
												</a>
					
			   `)
				);

		}

	});

});

// lấy dữ liệu và đưa lên form sửa
function sua(nhomThuongHieuId) {


	// url lấy dữ liệu từ api
	const url = `api/${nhomThuongHieuId}`;


	// gọi api lấy dữ liệu
	$.get(url, function(data, status) {

		// data là dữ liệu nhận được
		const { id, tenThuongHieu } = data;

		if (status === 'success') {
			// set dữ liệu vào modal
			$("#sua-modal #id").val(id);
			$("#sua-modal #tenThuongHieu").val(tenThuongHieu);

		}
	});
}

// khi nhấn nút cập nhật
$('#btnCapNhat').click(function() {

	// lấy dữ liệu từ modal
	const id = $('#sua-modal #id').val();
	const tenThuongHieu = $('#sua-modal #tenThuongHieu').val();

	// kiểm tra không được bỏ trống
	if (tenThuongHieu.trim().length == 0) {
		$('#sua-modal #errThem').text('Tên thương hiệu không được bỏ trống');
		return;
	}

	const url = "api";

	$.ajax({
		url: url,
		type: 'PUT',
		contentType: 'application/json',
		data: JSON.stringify({ id, tenThuongHieu }),
		success: function() {

			capNhatDuLieu("");
			$('#sua-modal').modal('hide');
			toastr.success('Cập nhật thành công')

		},
		error: function() {
			toastr.error('Tên thương hiệu đã bị trùng')
		},

	});

});





function capNhatDuLieu(tenThuongHieu) {

	const url = `api?tenThuongHieu=${tenThuongHieu}`;
	$.get(url, function(data, status) {

		if (status === 'success') {
			console.log('data lay dc: ', data);
			renderDuLieu(data);
		}

	})
}


function renderDuLieu(data) {

	$("#tableBody").html("");

	$.each(data, (index, nhomThuongHieu) => {

		const { id, tenThuongHieu, code } = nhomThuongHieu;

		$("<tr>").appendTo($("#tableBody"))
			.append($("<td>").text(id))
			.append($("<td>").text(tenThuongHieu))
			.append($("<td>").text(code))
			.append(

				$("<td>").html(`
							<a   onClick="xemChiTiet('${id}')" 
													class="btn btn-primary btn-sm xem" data-toggle="modal"
													data-target="#xem-modal"> <i class="fas fa-folder">
													</i> Xem
												</a> <a 
													class="btn btn-info btn-sm sua" data-toggle="modal"
													data-target="#sua-modal"> <i class="fas fa-pencil-alt">
													</i> Sửa
												</a> <a onClick="xoa('${id}')" 
													class="btn btn-danger btn-sm xoa"> <i
														class="fas fa-trash"> </i> Xóa
												</a>
					
			   `)
			);
	});
}

