let nhomValis = [];
let gias = [];
let thuongHieus = [];
let chatLieus = [];
let kichThuocs = [];
let mauSacs = [];
let tinhNangs = [];
let page = 0;
let size =12;
let loaiSapXep = '';

$(".nhomVali").click(() => {

	nhomValis = [];
	const mang = document.getElementsByClassName("nhomVali");

	for (const x of mang) {
		if (x.checked) {
			nhomValis.push(x.value);
		}
	}

	timKiem();
});


$(".gia").click(() => {


	gias = [];
	const mang = document.getElementsByClassName("gia");

	for (const x of mang) {
		if (x.checked) {
			gias.push(x.value);
		}
	}

	timKiem();
})


$(".thuongHieu").click(() => {

	thuongHieus = [];
	const mang = document.getElementsByClassName("thuongHieu");

	for (const x of mang) {
		if (x.checked) {
			thuongHieus.push(x.value);
		}
	}

	timKiem();
})


$(".chatLieu").click(() => {
	chatLieus = [];
	const mang = document.getElementsByClassName("chatLieu");

	for (const x of mang) {
		if (x.checked) {
			chatLieus.push(x.value);
		}
	}

	timKiem();
})


$(".kichThuoc").click(() => {
	kichThuocs = [];
	const mang = document.getElementsByClassName("kichThuoc");

	for (const x of mang) {
		if (x.checked) {
			kichThuocs.push(x.value);
		}
	}

	timKiem();
})

$(".mauSac").click(() => {
	mauSacs = [];
	const mang = document.getElementsByClassName("mauSac");

	for (const x of mang) {
		if (x.checked) {
			mauSacs.push(x.value);
		}
	}

	timKiem();
})


$(".tinhNang").click(() => {
	tinhNangs = [];
	const mang = document.getElementsByClassName("tinhNang");

	for (const x of mang) {
		if (x.checked) {
			tinhNangs.push(x.value);
		}
	}

	timKiem();
})



$('#loaiSapXep').on('change', function() {
	   
   loaiSapXep = this.value;

   timKiem();

});


function timKiem() {
	const dataTimKiem = { nhomValis, gias, thuongHieus, chatLieus, kichThuocs, mauSacs, tinhNangs, loaiSapXep,page, size };

    const query = jQuery.param(dataTimKiem).replaceAll("%5B%5D","");

	const url = `api?${query}`;


	$.get(url, function(data) {
	
        $("#result-valis").html(data);

	});

}
