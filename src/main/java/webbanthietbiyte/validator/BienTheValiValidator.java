package webbanvali.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import webbanvali.dto.BienTheValiAddDTO;
import webbanvali.repository.BienTheValiRepository;

@Component
public class BienTheValiValidator implements Validator {

	@Autowired
	private BienTheValiRepository bienTheValiRepository;

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

		BienTheValiAddDTO bienTheVali = (BienTheValiAddDTO) target;

		// trùng id
		if (  bienTheVali.getValiId() == 0 && bienTheVali.getKichThuocId() ==0&& bienTheVali.getMauSacId() == 0 &&   bienTheValiRepository.existsByValiTenValiContainingAndKichThuocTenKichThuocContainingAndMauSacTenMauContaining(
				  bienTheVali.getTenVali(), bienTheVali.getTenKichThuoc(), bienTheVali.getTenMauSac())) {
			errors.rejectValue("valiId", null, "Sản phẩm đã có");
			errors.rejectValue("kichThuocId", null, "Sản phẩm đã có");
			errors.rejectValue("mauSacId", null, "Sản phẩm đã có");
		}

		if (bienTheVali.getGia() <= 0) {
			errors.rejectValue("gia", null, "Giá phải lớn hơn không");
		}
		if (bienTheVali.getKhuyenMai() <= 0) {
			errors.rejectValue("khuyenMai", null, "Khuyến mãi phải lớn hơn không");
		}
		if (bienTheVali.getSoLuong() <= 0) {
			errors.rejectValue("soLuong", null, "Số lượng phải lớn hơn không");
		}
		if (bienTheVali.getTheTich().trim().length() == 0) {
			errors.rejectValue("theTich", null, "Thể tích không được bỏ trống");
		}
		if (bienTheVali.getTrongLuong().trim().length() == 0) {
			errors.rejectValue("trongLuong", null, "Trọng Lượng không được bỏ trống");
		}
		if (bienTheVali.getMoTaKichThuoc().trim().length() == 0) {
			errors.rejectValue("moTaKichThuoc", null, "Mô tả kích thước không được bỏ trống");
		}

	}

}
