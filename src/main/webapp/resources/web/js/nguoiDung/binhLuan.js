const { origin, pathname } = location;


// hàm xóa bình luận
function xoa(valiID) {

	if (confirm("Bạn có chắc chắn xóa không ?")) {

		$.ajax({
			url: `binh-luan/${valiID}`,
			type: 'DELETE',
			success: function() {
				toastr.success('Xóa thành công')
			},
			error: function() {
				toastr.error('không xoá được')
			},

		});

	}
}



