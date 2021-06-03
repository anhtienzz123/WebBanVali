let nam = 2021;


$('#namSelect').on('change', function() {
	   
   nam = this.value;

   timKiem();

});


function timKiem() {
	
	const dataTimKiem = { nam };

    const query = jQuery.param(dataTimKiem);

	const url = `api/nam?${query}`;


	$.get(url, function(data) {
	
        $("#result").html(data);

	});

}
