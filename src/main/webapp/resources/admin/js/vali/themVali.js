function validate() {

	let tenVali = document.myForm.tenVali.value.trim();
	let banhXe = document.myForm.banhXe.value.trim();
	let dayKeo = document.myForm.dayKeo.value;
	let khoa = document.myForm.khoa.value;
	let thoiGianBaoHanh = document.myForm.thoiGianBaoHanh.value.trim();
	
	$("#tenValiErr").text("");
	$("#banhXeErr").text("");
	$("#dayKeoErr").text("");
	$("#khoaErr").text("");
	$("#thoiGianBaoHanhErr").text("");

	let flag = true;

	
	if (tenVali.length === 0) {
		$("#tenValiErr").text("Tên vali không được bỏ trống");
		flag = false;
	}

	if (banhXe.length === 0) {
		$("#banhXeErr").text("Bánh xe không được bỏ trống");
		flag = false;
	}

	if (dayKeo.length === 0) {
		$("#dayKeoErr").text("Dây kéo không được bỏ trống");
		flag = false;
	}

	if (khoa.length === 0) {
		$("#khoaErr").text("Khóa không được bỏ trống");
		flag = false;
	}

	if (thoiGianBaoHanh.length === 0) {
		$("#thoiGianBaoHanhErr").text("Thời gian bảo hành không được bỏ trống");
		flag = false;
	}

	return flag;
}