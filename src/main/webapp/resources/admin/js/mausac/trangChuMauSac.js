
function xemChiTiet(mauSacId) {

	const url = `api/${mauSacId}`;
	console.log('url: ', url);

	$.get(url, function(data, status) {

		const { id, tenMau, code } = data;

		if (status === 'success') {

			$("#xem-modal .id").html(`<span class="font-weight-bold">${id}</span>`);
			$("#xem-modal .tenMau").html(`<span class="font-weight-bold">${tenMau}</span>`);
			$("#xem-modal .code").html(`<span class="font-weight-bold">${code}</span>`);

		}
	});
}


function xoa(mauSacId) {

	if (confirm("Bạn có chắc chắn xóa không ?")) {

		$.ajax({
			url: `api/${mauSacId}`,
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

	const giaTriDaNhap = $('#them-modal #tenMauSacThem').val();

	if (giaTriDaNhap.trim().length == 0) {
		$('#them-modal #errThem').text('Tên màu không được bỏ trống');
		return;
	}

	const url = "api";

	$.post(url, { tenMau: giaTriDaNhap }, function(data, status) {

		if (status === 'success') {

			$('#them-modal').modal('hide');
			toastr.success('Thêm thành công')

			const { id, tenMau, code } = data;

			$("<tr>").appendTo($("#tableBody"))
				.append($("<td>").text(id))
				.append($("<td>").text(tenMau))
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

		} else {
			$('#them-modal #errThem').text('Tên màu đã trùng');
		}

	});

});


$("#timKiemTenMauSac").on("keyup", function() {

	capNhatDuLieu(this.value);

});


function capNhatDuLieu(tenMau) {

	const url = `api?tenMau=${tenMau}`;
	$.get(url, function(data, status) {

		if (status === 'success') {
			console.log('data lay dc: ', data);
			renderDuLieu(data);
		}

	})
}


function renderDuLieu(data) {

	$("#tableBody").html("");

	$.each(data, (index, mauSac) => {

		const { id, tenMau, code } = mauSac;

		$("<tr>").appendTo($("#tableBody"))
			.append($("<td>").text(id))
			.append($("<td>").text(tenMau))
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

