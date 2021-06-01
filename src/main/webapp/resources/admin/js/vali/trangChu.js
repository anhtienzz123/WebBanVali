

let tenVali = "";
let nhomVali = "";
let thuongHieu = "";

$("#tenVali").on("keyup", function() {

	tenVali = this.value;

	timKiem();

});


$('#nhomValis').on('change', function() {

	nhomVali = this.value;

	timKiem();

});

$('#thuongHieus').on('change', function() {

	thuongHieu = this.value;

	timKiem();

});


function timKiem() {

	const query = jQuery.param({ tenVali, nhomVali, thuongHieu });

	const url = `api?${query}`;

	$.get(url, function(data, status) {

		$("#tableBody").html(data);
	});

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