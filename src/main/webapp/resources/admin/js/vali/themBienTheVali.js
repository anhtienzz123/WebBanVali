function validate() {

	let gia = document.myForm.gia.value.trim();
	let khuyenMai = document.myForm.khuyenMai.value.trim();
	let soLuong = document.myForm.soLuong.value;
	let theTich = document.myForm.theTich.value;
	let trongLuong = document.myForm.trongLuong.value.trim();
	let moTaKichThuoc = document.myForm.moTaKichThuoc.value.trim();

	$("#giaErr").text("");
	$("#khuyenMaiErr").text("");
	$("#soLuongErr").text("");
	$("#theTichErr").text("");
	$("#trongLuongErr").text("");
	$("#moTaKichThuocErr").text("");

	let flag = true;

	try {


		if (isNaN(gia)) {

			$("#giaErr").text("Giá sai định dạng");
			flag = false;

		} else {


			if (gia < 0) {
				$("#giaErr").text("Giá không được nhỏ hơn 0");
				flag = false;
			}
		}



	} catch (e) {


	}

	try {

		if (isNaN(khuyenMai)) {

			$("#khuyenMaiErr").text("Khuyến mãi sai định dạng");
			flag = false;

		} else {


			if (khuyenMai < 0) {
				$("#khuyenMaiErr").text("Khuyến mãi không được nhỏ hơn 0");
				flag = false;
			}
		}

	} catch (e) {


	}

	try {


		if (isNaN(soLuong)) {

			$("#soLuongErr").text("Số lượng sai định dạng");
			flag = false;

		} else {


			if (soLuong < 0) {
				$("#soLuongErr").text("Số lượng không được nhỏ hơn 0");
				flag = false;
			}
		}



	} catch (e) {


	}





	if (theTich.length === 0) {
		$("#theTichErr").text("Thể tích không được bỏ trống");
		flag = false;
	}

	if (trongLuong.length === 0) {
		$("#trongLuongErr").text("Trọng lượng không được bỏ trống");
		flag = false;
	}

	if (moTaKichThuoc.length === 0) {
		$("#moTaKichThuocErr").text("Mô tả kích thước không được bỏ trống");
		flag = false;
	}

	return flag;
}