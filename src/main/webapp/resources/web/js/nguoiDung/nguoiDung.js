const { origin, pathname } = location;


const URL_GET_QUAN_HUYEN = `${origin}/WebBanVali/dia-chi/quan-huyen`;
const URL_GET_PHUONG_XA = `${origin}/WebBanVali/dia-chi/phuong-xa`;

$('select').change(function() {
	let optionSelected = $(this).find("option:selected");
	let valueSelected = optionSelected.val();
	let textSelected = optionSelected.text();

	let id = $(this).attr('id');

	if (id === 'tinhThanhPho') {

		let urlQuanHuyen = `${URL_GET_QUAN_HUYEN}?maThanhPho=${valueSelected}`;

		$.get(urlQuanHuyen, function(data, status) {

			$("#quanHuyen").html("<option selected >Chọn Quận/Huyện</option>" + data);
			$("#phuongXa").html("<option selected >Chọn Phường/Xã</option>")
		});
	}

	if (id === 'quanHuyen') {
		let urlPhuongXa = `${URL_GET_PHUONG_XA}?maQuanHuyen=${valueSelected}`;

		$.get(urlPhuongXa, function(data, status) {
			$("#phuongXa").html("<option selected >Chọn Phường/Xã</option>" + data);
		});
	}


});


function validate() {

	let hoTen = document.myForm.hoTen.value.trim();
	let soDienThoai = document.myForm.soDienThoai.value.trim();
	//let tinhThanhPho = document.myForm.tinhThanhPho.value.trim();
	let quanHuyen = document.myForm.quanHuyen.value;
	let phuongXa = document.myForm.phuongXa.value;
	let diaChi = document.myForm.diaChi.value.trim();

	let flag = true;

	// kiếm tra họ tên
	if (hoTen.length === 0) {
		$("#hoTenError").text("Họ tên không được bỏ trống");
		flag = false;
	}

	// kiểm tra số điện thoại
	let regexSoDienThoai = /((09|03|07|08|05)+([0-9]{8})\b)/g;
	if (soDienThoai.length === 0) {
		$("#soDienThoaiError").text("Số điện thoại không được bỏ trống");
		flag = false;
	} else {

		if (!regexSoDienThoai.test(soDienThoai) ) {
			$("#soDienThoaiError").text("Số điện thoại sai định dạng");
			flag = false;
		}

	}

	// kiểm tra quận huyện
	if(quanHuyen === 'Chọn Quận/Huyện'){
		$("#quanHuyenError").text("Quận huyện không được bỏ trống");
		flag = false;
	}
	
	// kiểm tra phường xã
	if(phuongXa === 'Chọn Phường/Xã'){
		$("#phuongXaError").text("Phường xã không được bỏ trống");
		flag = false;
	}
	
	// kiểm tra đường
	if(diaChi.length === 0 ){
		$("#diaChiError").text("Địa chỉ không được bỏ trống");
		flag = false;
	}
	
	return flag;
}


