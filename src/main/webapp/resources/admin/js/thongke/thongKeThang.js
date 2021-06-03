let thang = 6;
let nam = 2021;

$('#thangSelect').on('change', function() {
	   
   thang = this.value;

   timKiem();

});


$('#namSelect').on('change', function() {
	   
   nam = this.value;

   timKiem();

});


function timKiem() {
	
	const dataTimKiem = { thang,nam };

    const query = jQuery.param(dataTimKiem);

	const url = `api/thang?${query}`;


	$.get(url, function(data) {
	
        $("#result").html(data);

	});

}
