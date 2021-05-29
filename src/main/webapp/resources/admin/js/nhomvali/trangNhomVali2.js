
// hàm lấy dữ liệu từ api và cập nhật vào view
function xemChiTiet(nhomValiId) {

	// url lấy dữ liệu từ api
	const url = `api/${nhomValiId}`;


	// gọi api lấy dữ liệu
	$.get(url, function(data, status) {

		// data là dữ liệu nhận được
		const { id, tenNhomVali, code } = data;

		if (status === 'success') {
			// set dữ liệu
			$("#xem-modal .id").html(`<span class="font-weight-bold">${id}</span>`);
			$("#xem-modal .tenNhomVali").html(`<span class="font-weight-bold">${tenNhomVali}</span>`);
			$("#xem-modal .code").html(`<span class="font-weight-bold">${code}</span>`);

		}
	});


}

// khi nhấn nút thêm
$('#btnThem').click(function() {

	// lấy giá trị đã nhập
	const tenNhomVali = $('#them-modal #tenNhomValiThem').val();

	// kiểm tra không được bỏ trống
	if (tenNhomVali.trim().length == 0) {
		$('#them-modal #errThem').text('Tên nhóm vali không được bỏ trống');
		return;
	}

	const url = "api";

	$.ajax({
		url: url,
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify({ tenNhomVali }),

		success: function() {

			capNhatDuLieu("");
			$('#them-modal').modal('hide');
			toastr.success('Thêm thành công')

		},
		error: function() {
			toastr.error('Tên nhóm vali đã bị trùng')
		},

	});



});

// lấy dữ liệu và đưa lên form sửa
function sua(nhomValiId) {


	// url lấy dữ liệu từ api
	const url = `api/${nhomValiId}`;


	// gọi api lấy dữ liệu
	$.get(url, function(data, status) {

		// data là dữ liệu nhận được
		const { id, tenNhomVali } = data;

		if (status === 'success') {
			// set dữ liệu vào modal
			$("#sua-modal #id").val(id);
			$("#sua-modal #tenNhomVali").val(tenNhomVali);

		}
	});
}

// khi nhấn nút cập nhật
$('#btnCapNhat').click(function() {

	// lấy dữ liệu từ modal
	const id = $('#sua-modal #id').val();
	const tenNhomVali = $('#sua-modal #tenNhomVali').val();

	// kiểm tra không được bỏ trống
	if (tenNhomVali.trim().length == 0) {
		$('#sua-modal #errThem').text('Tên nhóm Vali không được bỏ trống');
		return;
	}

	const url = "api";

	$.ajax({
		url: url,
		type: 'PUT',
		contentType: 'application/json',
		data: JSON.stringify({ id, tenNhomVali }),
		success: function() {

			capNhatDuLieu("");
			$('#sua-modal').modal('hide');
			toastr.success('Cập nhật thành công')

		},
		error: function() {
			toastr.error('Tên Nhóm Vali đã bị trùng')
		},

	});

});




// hàm xóa sản phẩm
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



// khi nhập vào ô tìm kiếm
$("#timKiemTenNhomVali").on("keyup", function() {

	capNhatDuLieu(this.value);

});



// hàm thay đổi dữ liệu table
function renderDuLieu(data) {

	// xóa dữ liệu table đã có
	$("#tableBody").html("");

	// lặp qua dữ liệu
	$.each(data, (index, nhomVali) => {

		const { id, tenNhomVali, code } = nhomVali;

		// tạo tr trong #tableBody
		$("<tr>").appendTo($("#tableBody"))
			// thêm td vào tr
			.append($("<td>").text(id))
			.append($("<td>").text(tenNhomVali))
			.append($("<td>").text(code))
			.append(
				$("<td>").html(`
							<a   onClick="xemChiTiet('${id}')" 
							     class="btn btn-primary btn-sm xem" data-toggle="modal"
								 data-target="#xem-modal">
								
								 <i class="fas fa-folder"></i> Xem
							
							</a>
							
							<a onClick="sua(${id})"
								 class="btn btn-info btn-sm sua" data-toggle="modal"
							     data-target="#sua-modal">
		
								 <i class="fas fa-pencil-alt"></i> Sửa
							
							</a> 
							
							<a onClick="xoa('${id}')" 
								 class="btn btn-danger btn-sm xoa">
							
								 <i	class="fas fa-trash"> </i> Xóa
						
							</a>
					
			   `)
			);
	});
}

// hàm tìm kiếm theo tên nhóm vali
function capNhatDuLieu(tenNhomVali) {

	const url = `api?tenNhomVali=${tenNhomVali}`;
	$.get(url, function(data, status) {

		if (status === 'success') {

			renderDuLieu(data);
		}

	})
}

