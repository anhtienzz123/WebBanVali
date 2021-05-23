package webbanvali.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import webbanvali.dto.ValiChungDTO;

@Component
public class ValiChungDTOValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return ValiChungDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		// kiểm tra object
		if (!supports(target.getClass())) {
			return;
		}
		
		ValiChungDTO valiChungDTO = (ValiChungDTO) target;

	}
}
