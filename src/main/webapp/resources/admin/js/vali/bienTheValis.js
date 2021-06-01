

let tenVali = "";
let tenKichThuoc = "";
let tenMauSac = "";

$("#tenVali").on("keyup", function() {

	tenVali = this.value;

	timKiem();

});


$('#kichThuocs').on('change', function() {

	tenKichThuoc = this.value;

	timKiem();

});

$('#mauSacs').on('change', function() {

	tenMauSac = this.value;

	timKiem();

});




function timKiem() {

	const query = jQuery.param({ tenVali, tenKichThuoc, tenMauSac });

	const url = `api-bien-the-valis?${query}`;

	$.get(url, function(data, status) {

		$("#tableBody").html(data);
	});

}

function xoa(valiId, kichThuocId, mauSacId){
	
	const query = jQuery.param({ valiId, kichThuocId, mauSacId });
	
	const url = `api-bien-the-valis/xoa?${query}`; 
	
	
}


// hàm xóa sản phẩm
function xoa(valiId, kichThuocId, mauSacId) {

	if (confirm("Bạn có chắc chắn xóa không ?")) {

		const query = jQuery.param({ valiId, kichThuocId, mauSacId });
		const url = `api-bien-the-valis/xoa?${query}`; 

		$.ajax({
			url: url,
			type: 'DELETE',
			success: function() {

				toastr.success('Xóa thành công');
				timKiem();
				
				

			},
			error: function() {
				toastr.error('Xóa thất bại vì đã có hóa đơn');
			},

		});

	}
}
