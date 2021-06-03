let id = "";
let soDienThoai = "";
let trangThai = "";



$("#txtId").on("keyup", function() {

	id = this.value;

	timKiem();

});


$("#txtSoDienThoai").on("keyup", function() {

	soDienThoai = this.value;

	timKiem();

});

$('#slTrangThai').on('change', function() {

	trangThai = this.value;

	timKiem();

});

function timKiem() {

	const query = jQuery.param({ id, soDienThoai, trangThai });

	const url = `api?${query}`;

	$.get(url, function(data, status) {

		$("#tableBody").html(data);
	});

}


// cap nhat trang thai

function capNhatTrangThai(id, trangThai) {

	const query = jQuery.param({ id, trangThai });

	const url = `api/trang-thai?${query}`;
	
	console.log('url: ', url);


	$.ajax({
		url: url,
		type: 'GET',
		success: function() {


			timKiem();


		},
		error: function() {
			toastr.error('Không xóa được, vì đã có sản phẩm dùng')
		},

	});


}


//Xóa
function xoa(id) {

	if (confirm("Bạn có chắc chắn xóa không ?")) {

		$.ajax({
			url: `api/xoa/${id}`,
			type: 'DELETE',
			success: function() {

			    timKiem();
				toastr.success('Xóa thành công');

			},
			error: function() {
				toastr.error('Xóa thất bại');
			},

		});

	}
}

