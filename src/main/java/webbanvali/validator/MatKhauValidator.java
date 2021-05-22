package webbanvali.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import webbanvali.dto.NguoiDungDTO;

@Component
public class MatKhauValidator implements Validator {

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

		// mật khẩu không được bỏ trống
		if (nguoiDungDTO.getMatKhau() == null ||nguoiDungDTO.getMatKhau().trim().length() == 0) {
			errors.rejectValue("matKhau", "boTrong");
		}

	}

}
