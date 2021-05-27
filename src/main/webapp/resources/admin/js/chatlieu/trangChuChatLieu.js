
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

// khi nhấn nút thêm
$('#btnThem').click(function() {

	// lấy giá trị đã nhập
	const tenChatLieu = $('#them-modal #tenChatLieuThem').val();

	// kiểm tra không được bỏ trống
	if (tenChatLieu.trim().length == 0) {
		$('#them-modal #errThem').text('Tên chất liệu không được bỏ trống');
		return;
	}

	const url = "api";

	$.ajax({
		url: url,
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify({ tenChatLieu }),

		success: function() {

			capNhatDuLieu("");
			$('#them-modal').modal('hide');
			toastr.success('Thêm thành công')

		},
		error: function() {
			toastr.error('Tên chất liệu đã bị trùng')
		},

	});



});

$("#timKiemTenChatLieu").on("keyup", function() {

	capNhatDuLieu(this.value);

});



// lấy dữ liệu và đưa lên form sửa
function sua(chatLieuId) {


	// url lấy dữ liệu từ api
	const url = `api/${chatLieuId}`;


	// gọi api lấy dữ liệu
	$.get(url, function(data, status) {

		// data là dữ liệu nhận được
		const { id, tenChatLieu } = data;

		if (status === 'success') {
			// set dữ liệu vào modal
			$("#sua-modal #id").val(id);
			$("#sua-modal #tenChatLieu").val(tenChatLieu);

		}
	});
}

// khi nhấn nút cập nhật
$('#btnCapNhat').click(function() {

	// lấy dữ liệu từ modal
	const id = $('#sua-modal #id').val();
	const tenChatLieu = $('#sua-modal #tenChatLieu').val();

	// kiểm tra không được bỏ trống
	if (tenChatLieu.trim().length == 0) {
		$('#sua-modal #errThem').text('Tên chất liệu không được bỏ trống');
		return;
	}

	const url = "api";

	$.ajax({
		url: url,
		type: 'PUT',
		contentType: 'application/json',
		data: JSON.stringify({ id, tenChatLieu }),
		success: function() {

			capNhatDuLieu("");
			$('#sua-modal').modal('hide');
			toastr.success('Cập nhật thành công')

		},
		error: function() {
			toastr.error('Tên chất liệu đã bị trùng')
		},

	});

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

