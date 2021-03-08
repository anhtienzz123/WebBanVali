const {origin, pathname} = location;

const URL_GET_QUAN_HUYEN = `${origin}/WebBanSach/dia-chi/quan-huyen`;
const URL_GET_PHUONG_XA = `${origin}/WebBanSach/dia-chi/phuong-xa`;

$('select').change(function () {
     let optionSelected = $(this).find("option:selected");
     let valueSelected  = optionSelected.val();
     let textSelected   = optionSelected.text();
     
     let id = $(this).attr('id');
     
     if(id === 'tinhThanhPho'){
    	 
    	 let urlQuanHuyen = `${URL_GET_QUAN_HUYEN}?maThanhPho=${valueSelected}`;
    	 
     	 $.get(urlQuanHuyen, function(data, status) {
    
     	      $("#quanHuyen").html("<option selected >Chọn Quận/Huyện</option>"+data);
     	      $("#phuongXa").html("<option selected >Chọn Phường/Xã</option>")
     	 });
     }
     
     if(id === 'quanHuyen'){
    	 let urlPhuongXa = `${URL_GET_PHUONG_XA}?maQuanHuyen=${valueSelected}`;
    	 
    	 $.get(urlPhuongXa, function(data, status) {
    	      $("#phuongXa").html("<option selected >Chọn Phường/Xã</option>" + data);
    	 });
     }
    
    
 });


