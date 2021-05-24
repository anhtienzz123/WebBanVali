
// hàm lấy dữ liệu từ api và cập nhật vào view
function xemChiTiet(mauSacId) {

	// url lấy dữ liệu từ api
	const url = `api/${mauSacId}`;


	// gọi api lấy dữ liệu
	$.get(url, function(data, status) {

		// data là dữ liệu nhận được
		const { id, tenMau, code } = data;
		

		if (status === 'success') {
			// set dữ liệu
			
			
			$("#xem-modal .id").html(`<span class="font-weight-bold">${id}</span>`);
			$("#xem-modal .tenMau").html(`<span class="font-weight-bold">${tenMau}</span>`);
			$("#xem-modal .code").html(`<span class="font-weight-bold">${code}</span>`);

		}
	});


}

// khi nhấn nút thêm
$('#btnThem').click(function() {

	// lấy giá trị đã nhập
	const tenMau = $('#them-modal #tenMauSacThem').val();

	// kiểm tra không được bỏ trống
	if (tenMau.trim().length == 0) {
		$('#them-modal #errThem').text('Tên màu không được bỏ trống');
		return;
	}

	const url = "api";

	$.ajax({
		url: url,
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify({ tenMau }),
		
		success: function() {

			capNhatDuLieu("");
			$('#them-modal').modal('hide');
			toastr.success('Thêm thành công')

		},
		error: function() {
			toastr.error('Tên màu đã bị trùng')
		},

	});

	

});

// lấy dữ liệu và đưa lên form sửa
function sua(mauSacId) {


	// url lấy dữ liệu từ api
	const url = `api/${mauSacId}`;


	// gọi api lấy dữ liệu
	$.get(url, function(data, status) {

		// data là dữ liệu nhận được
		const { id, tenMau } = data;

		if (status === 'success') {
			// set dữ liệu vào modal
			$("#sua-modal #id").val(id);
			$("#sua-modal #tenMau").val(tenMau);

		}
	});
}

// khi nhấn nút cập nhật
$('#btnCapNhat').click(function() {

	// lấy dữ liệu từ modal
	const id = $('#sua-modal #id').val();
	const tenMau = $('#sua-modal #tenMau').val();

	// kiểm tra không được bỏ trống
	if (tenMau.trim().length == 0) {
		$('#sua-modal #errThem').text('Tên màu không được bỏ trống');
		return;
	}

	const url = "api";

	$.ajax({
		url: url,
		type: 'PUT',
		contentType: 'application/json',
		data: JSON.stringify({ id, tenMau }),
		success: function() {

			capNhatDuLieu("");
			$('#sua-modal').modal('hide');
			toastr.success('Cập nhật thành công')

		},
		error: function() {
			toastr.error('Tên màu đã bị trùng')
		},

	});

});




// hàm xóa sản phẩm
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



// khi nhập vào ô tìm kiếm
$("#timKiemTenMauSac").on("keyup", function() {


	capNhatDuLieu(this.value);

});



// hàm thay đổi dữ liệu table
function renderDuLieu(data) {

	// xóa dữ liệu table đã có
	$("#tableBody").html("");

	// lặp qua dữ liệu
	$.each(data, (index, mauSac) => {

		const { id, tenMau, code } = mauSac;

		// tạo tr trong #tableBody
		$("<tr>").appendTo($("#tableBody"))
			// thêm td vào tr
			.append(  $("<td>").text(id)  )
			.append( $("<td>").text(tenMau) )
			.append( $("<td>").text(code) )
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

// hàm tìm kiếm theo tên màu
function capNhatDuLieu(tenMau) {

	const url = `api?tenMau=${tenMau}`;
	$.get(url, function(data) {


		renderDuLieu(data);
		

	})
}

