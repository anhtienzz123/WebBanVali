

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



