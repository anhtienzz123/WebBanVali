const { origin, pathname } = location;

function validate() {

	let matKhau = document.myForm.matKhau.value.trim();
	let matKhauMoi = document.myForm.matKhauMoi.value.trim();
	let matKhauXacNhan = document.myForm.matKhauXacNhan.value.trim();

	let flag = true;

	// kiếm tra mật khẩu
	if (matKhau.length === 0) {
		$("#matKhauError").text("Mật Khẩu không được bỏ trống");
		flag = false;
	}

	// kiểm tra mật khẩu mới
	if (matKhauMoi.length === 0) {
		$("#matKhauMoiError").text("mật khẩu mới không được bỏ trống");
		flag = false;
	}

	// kiểm tra mật khẩu xác nhận
	if (matKhauXacNhan.length === 0) {
		$("#matKhauXacNhanError").text("không được bỏ trống");
		flag = false;
	} else {

		if (matKhauMoi.trim() === matKhauXacNhan.trim()) {
			flag = true;
		} else {
			$("#matKhauXacNhanError").text("mật khẩu không khớp");
			flag = false;
		}

	}

	return flag;
}

