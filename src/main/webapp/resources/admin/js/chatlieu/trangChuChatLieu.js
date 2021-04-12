
function xemChiTiet(chatLieuId) {

	const url = `api/${chatLieuId}`;
	console.log('url: ', url);

	$.get(url, function(data, status) {

		const { id, tenChatLieu, code } = data;

		if (status === 'success') {

			$("#xem-modal .id").html(`<span class="font-weight-bold">${id}</span>`);
			$("#xem-modal .tenChatLieu").html(`<span class="font-weight-bold">${tenChatLieu}</span>`);
			$("#xem-modal .code").html(`<span class="font-weight-bold">${code}</span>`);

		}
	});
}


function xoa(chatLieuId) {

	if (confirm("Bạn có chắc chắn xóa không ?")) {

		$.ajax({
			url: `api/${chatLieuId}`,
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

	const giaTriDaNhap = $('#them-modal #tenChatLieuThem').val();

	if (giaTriDaNhap.trim().length == 0) {
		$('#them-modal #errThem').text('Tên chất liệu không được bỏ trống');
		return;
	}

	const url = "api";

	$.post(url, { tenChatLieu: giaTriDaNhap }, function(data, status) {

		if (status === 'success') {

			$('#them-modal').modal('hide');
			toastr.success('Thêm thành công')

			const { id, tenChatLieu, code } = data;

			$("<tr>").appendTo($("#tableBody"))
				.append($("<td>").text(id))
				.append($("<td>").text(tenChatLieu))
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
			$('#them-modal #errThem').text('Tên chất liệu đã trùng');
		}

	});

});


$("#timKiemTenChatLieu").on("keyup", function() {

	capNhatDuLieu(this.value);

});


function capNhatDuLieu(tenChatLieu) {

	const url = `api?tenChatLieu=${tenChatLieu}`;
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

		const { id, tenChatLieu, code } = chatLieu;

		$("<tr>").appendTo($("#tableBody"))
			.append($("<td>").text(id))
			.append($("<td>").text(tenChatLieu))
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

