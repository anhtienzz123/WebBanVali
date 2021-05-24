package webbanvali.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import webbanvali.dto.BienTheValiAddDTO;

@Component
public class BienTheValiValidator   implements Validator{


	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return BienTheValiAddDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		// kiểm tra object
		if (!supports(target.getClass())) {
			return;
		}

		BienTheValiAddDTO bienTheValiAddDTO = (BienTheValiAddDTO) target;


	}

	
}
