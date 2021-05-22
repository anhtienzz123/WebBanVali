package webbanvali.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import webbanvali.dto.NguoiDungDTO;

@Component
public class NguoiDungValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return NguoiDungDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		// kiểm tra object
		if (!supports(target.getClass())) {
			return;
		}

		NguoiDungDTO nguoiDungDTO = (NguoiDungDTO) target;

		if (nguoiDungDTO.getHoTen() == null || nguoiDungDTO.getHoTen().trim().length() == 0) {
			errors.rejectValue("hoTen", "boTrong");

		}

		// số điện thoại không được bỏ trống
		if (nguoiDungDTO.getSoDienThoai().trim().length() == 0) {
			errors.rejectValue("soDienThoai", null, "Số điện thoại không được bỏ trống");
		} else {

			// số điện thoại phải có 10 số
			if (!nguoiDungDTO.getSoDienThoai().trim().matches("\\d{10}")) {
				errors.rejectValue("soDienThoai", null, "Số điện thoại không đúng định dạng");
			}

		}

		// email không được bỏ trống
		if (nguoiDungDTO.getEmail().trim().length() == 0) {
			errors.rejectValue("email", null, "Email không được bỏ trống");
		} else {
			
			// email phải đúng định dạng
			if (!nguoiDungDTO.getEmail().trim().matches("^[A-Za-z0-9+_.-]+@(.+)$" )) {
				errors.rejectValue("email", null, "Email không đúng định dạng");
			}

		}
		
		// kiểm tra địa chỉ
		if(nguoiDungDTO.getDiaChi().trim().length() == 0 ) {
			errors.rejectValue("diaChi", null, "Địa chỉ không được bỏ trống");
		}
		
		if(nguoiDungDTO.getPhuongXa() == null) {
			errors.rejectValue("phuongXa", null, "Phường xã chưa chọn");
		}
		
		if(nguoiDungDTO.getQuanHuyen() == null) {
			errors.rejectValue("quanHuyen", null, "Quận huyện chưa chọn");
		}

		if(nguoiDungDTO.getTinhThanhPho() == null) {
			errors.rejectValue("tinhThanhPho", null, "Tỉnh/Thành phố chưa chọn");
		}
		
		

		
	}

}
