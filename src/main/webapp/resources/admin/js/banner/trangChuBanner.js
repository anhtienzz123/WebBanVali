
// hàm lấy dữ liệu từ api và cập nhật vào view
function xemChiTiet(bannerId) {

	// url lấy dữ liệu từ api
	const url = `api/${bannerId}`;


	// gọi api lấy dữ liệu
	$.get(url, function(data, status) {

		// data là dữ liệu nhận được
		const { id, tenAnh, tieuDe, noiDung } = data;


		if (status === 'success') {
			// set dữ liệu


			$("#xem-modal .id").html(`<span class="font-weight-bold">${id}</span>`);
			$("#xem-modal .tenAnh").html(`<span class="font-weight-bold">${tenAnh}</span>`);
			$("#xem-modal .tieuDe").html(`<span class="font-weight-bold">${tieuDe}</span>`);
			$("#xem-modal .noiDung").html(`<span class="font-weight-bold">${noiDung}</span>`);

		}
	});


}

// khi nhấn nút thêm
$('#btnThem').click(function() {

	// lấy giá trị đã nhập
	const tenAnh = $('#them-modal #InputFile').val();

	// kiểm tra không được bỏ trống
	if (tenAnh.trim().length == 0) {
		$('#them-modal #errThem').text('Tên banner không được bỏ trống');
		return;
	}

	const url = "api";

	$.ajax({
		url: url,
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify({ tenAnh }),

		success: function() {

			capNhatDuLieu("");
			$('#them-modal').modal('hide');
			toastr.success('Thêm thành công')

		},
		error: function() {
			toastr.error('Tên banner đã bị trùng')
		},

	});



});

// lấy dữ liệu và đưa lên form sửa
function sua(bannerId) {


	// url lấy dữ liệu từ api
	const url = `api/${bannerId}`;


	// gọi api lấy dữ liệu
	$.get(url, function(data, status) {

		// data là dữ liệu nhận được
		const { id, tenAnh, tieuDe, noiDung } = data;

		if (status === 'success') {
			// set dữ liệu vào modal
			$("#sua-modal #id").val(id);
			$("#sua-modal #tenAnh").val(tenAnh);
			$("#sua-modal #tieuDe").val(tieuDe);
			$("#sua-modal #noiDung").val(noiDung);

		}
	});
}

// khi nhấn nút cập nhật
$('#btnCapNhat').click(function() {

	// lấy dữ liệu từ modal
	const id = $('#sua-modal #id').val();
	const tenAnh = $('#sua-modal #tenAnh').val();

	// kiểm tra không được bỏ trống
	if (tenAnh.trim().length == 0) {
		$('#sua-modal #errThem').text('Tên banner không được bỏ trống');
		return;
	}

	const url = "api";

	$.ajax({
		url: url,
		type: 'PUT',
		contentType: 'application/json',
		data: JSON.stringify({ id, tenAnh }),
		success: function() {

			capNhatDuLieu("");
			$('#sua-modal').modal('hide');
			toastr.success('Cập nhật thành công')

		},
		error: function() {
			toastr.error('Tên banner đã bị trùng')
		},

	});

});




// hàm xóa sản phẩm
function xoa(bannerId) {

	if (confirm("Bạn có chắc chắn xóa không ?")) {

		$.ajax({
			url: `api/${bannerId}`,
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
$("#timKiemTenBanner").on("keyup", function() {


	capNhatDuLieu(this.value);

});



// hàm thay đổi dữ liệu table
function renderDuLieu(data) {

	// xóa dữ liệu table đã có
	$("#tableBody").html("");

	// lặp qua dữ liệu
	$.each(data, (index, banner) => {

		const { id, tenAnh, tieuDe, noiDung } = banner;

		// tạo tr trong #tableBody
		$("<tr>").appendTo($("#tableBody"))
			// thêm td vào tr
			.append($("<td>").text(id))
			.append($("<td>").text(tenAnh))
			.append($("<td>").text(tieuDe))
			.append($("<td>").text(noiDung))
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
function capNhatDuLieu(tenAnh) {

	const url = `api?tenAnh=${tenAnh}`;
	$.get(url, function(data) {


		renderDuLieu(data);


	})
}

