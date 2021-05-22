
// hàm lấy dữ liệu từ api và cập nhật vào view
function xemChiTiet(kichThuocId) {

	// url lấy dữ liệu từ api
	const url = `api/${kichThuocId}`;


	// gọi api lấy dữ liệu
	$.get(url, function(data, status) {

		// data là dữ liệu nhận được
		const { id, tenKichThuoc, code } = data;
		

		if (status === 'success') {
			// set dữ liệu
			
			
			$("#xem-modal .id").html(`<span class="font-weight-bold">${id}</span>`);
			$("#xem-modal .tenKichThuocCT").html(`<span class="font-weight-bold">${tenKichThuoc}</span>`);
			$("#xem-modal .code").html(`<span class="font-weight-bold">${code}</span>`);

		}
	});


}

// khi nhấn nút thêm
$('#btnThem').click(function() {

	// lấy giá trị đã nhập
	const tenKichThuoc = $('#them-modal #tenKichThuocThem').val();

	// kiểm tra không được bỏ trống
	if (tenKichThuoc.trim().length == 0) {
		$('#them-modal #errThem').text('Tên kích thước không được bỏ trống');
		return;
	}

	const url = "api";

	$.ajax({
		url: url,
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify({ tenKichThuoc }),
		
		success: function() {

			capNhatDuLieu("");
			$('#them-modal').modal('hide');
			toastr.success('Thêm thành công')

		},
		error: function() {
			toastr.error('Tên kích thước đã bị trùng')
		},

	});

	

});

// lấy dữ liệu và đưa lên form sửa
function sua(kichThuocId) {


	// url lấy dữ liệu từ api
	const url = `api/${kichThuocId}`;


	// gọi api lấy dữ liệu
	$.get(url, function(data, status) {

		// data là dữ liệu nhận được
		const { id, tenKichThuoc } = data;

		if (status === 'success') {
			// set dữ liệu vào modal
			$("#sua-modal #id").val(id);
			$("#sua-modal #tenKichThuoc").val(tenKichThuoc);

		}
	});
}

// khi nhấn nút cập nhật
$('#btnCapNhat').click(function() {

	// lấy dữ liệu từ modal
	const id = $('#sua-modal #id').val();
	const tenKichThuoc = $('#sua-modal #tenKichThuoc').val();

	// kiểm tra không được bỏ trống
	if (tenKichThuoc.trim().length == 0) {
		$('#sua-modal #errThem').text('Tên kích thước không được bỏ trống');
		return;
	}

	const url = "api";

	$.ajax({
		url: url,
		type: 'PUT',
		contentType: 'application/json',
		data: JSON.stringify({ id, tenKichThuoc }),
		success: function() {

			capNhatDuLieu("");
			$('#sua-modal').modal('hide');
			toastr.success('Cập nhật thành công')

		},
		error: function() {
			toastr.error('Tên kích thước đã bị trùng')
		},

	});

});




// hàm xóa sản phẩm
function xoa(kichThuocId) {

	if (confirm("Bạn có chắc chắn xóa không ?")) {

		$.ajax({
			url: `api/${kichThuocId}`,
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
$("#timKiemTenKichThuoc").on("keyup", function() {


	capNhatDuLieu(this.value);

});



// hàm thay đổi dữ liệu table
function renderDuLieu(data) {

	// xóa dữ liệu table đã có
	$("#tableBody").html("");

	// lặp qua dữ liệu
	$.each(data, (index, kichThuoc) => {

		const { id, tenKichThuoc, code } = kichThuoc;

		// tạo tr trong #tableBody
		$("<tr>").appendTo($("#tableBody"))
			// thêm td vào tr
			.append(  $("<td>").text(id)  )
			.append( $("<td>").text(tenKichThuoc) )
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
function capNhatDuLieu(tenKichThuoc) {

	const url = `api?tenKichThuoc=${tenKichThuoc}`;
	$.get(url, function(data) {


		renderDuLieu(data);
		

	})
}

