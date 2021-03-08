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

		NguoiDungDTO nguoiDungDTO = (NguoiDungDTO) target;

		if (!nguoiDungDTO.getEmail().matches("")) {

		}


		if (nguoiDungDTO.getHoTen() == null || nguoiDungDTO.getHoTen().trim().length() == 0) {
             errors.rejectValue("hoTen", "boTrong");
		}

		if(nguoiDungDTO.getSoDienThoai() != null) {
			if (!nguoiDungDTO.getSoDienThoai().matches("")) {

			}

			if (nguoiDungDTO.getDiaChi() == null || nguoiDungDTO.getDiaChi().trim().length() == 0) {

			}
			
			if (nguoiDungDTO.getVaiTro().equals("ROLE_USER") || nguoiDungDTO.getVaiTro().equals("ROLE_ADMIN") ) {

			}
		}
		
		

	}

}
