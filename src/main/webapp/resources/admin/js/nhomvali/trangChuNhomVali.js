
function xemChiTiet(nhomValiId) {

	const url = `api/${nhomValiId}`;
	console.log('url: ', url);

	$.get(url, function(data, status) {

		const { id, tenNhomVali, code } = data;

		if (status === 'success') {

			$("#xem-modal .id").html(`<span class="font-weight-bold">${id}</span>`);
			$("#xem-modal .tenNhomVali").html(`<span class="font-weight-bold">${tenNhomVali}</span>`);
			$("#xem-modal .code").html(`<span class="font-weight-bold">${code}</span>`);

		}
	});
}


function xoa(nhomValiId) {

	if (confirm("Bạn có chắc chắn xóa không ?")) {

		$.ajax({
			url: `api/${nhomValiId}`,
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

	const giaTriDaNhap = $('#them-modal #tenNhomValiThem').val();

	if (giaTriDaNhap.trim().length == 0) {
		$('#them-modal #errThem').text('Tên nhóm Vali không được bỏ trống');
		return;
	}

	const url = "api";

	$.post(url, { tenNhomVali: giaTriDaNhap }, function(data, status) {

		if (status === 'success') {

			$('#them-modal').modal('hide');
			toastr.success('Thêm thành công')

			const { id, tenNhomVali, code } = data;

			$("<tr>").appendTo($("#tableBody"))
				.append($("<td>").text(id))
				.append($("<td>").text(tenNhomVali))
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
			$('#them-modal #errThem').text('Tên nhóm vali đã trùng');
		}

	});

});


$("#timKiemTenNhomVali").on("keyup", function() {

	capNhatDuLieu(this.value);

});


function capNhatDuLieu(tenNhomVali) {

	const url = `api?tenNhomVali=${tenNhomVali}`;
	$.get(url, function(data, status) {

		if (status === 'success') {
			console.log('data lay dc: ', data);
			renderDuLieu(data);
		}

	})
}


function renderDuLieu(data) {

	$("#tableBody").html("");

	$.each(data, (index, chatLieu) => {

		const { id, tenNhomVali, code } = nhomVali;

		$("<tr>").appendTo($("#tableBody"))
			.append($("<td>").text(id))
			.append($("<td>").text(tenNhomVali))
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

