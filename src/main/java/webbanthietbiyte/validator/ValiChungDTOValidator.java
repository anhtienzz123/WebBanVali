package webbanvali.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import webbanvali.dto.ValiChungDTO;
import webbanvali.repository.ChatLieuRepository;
import webbanvali.repository.NhomThuongHieuRepository;
import webbanvali.repository.NhomValiRepository;
import webbanvali.repository.ValiRepository;

@Component
public class ValiChungDTOValidator implements Validator {

	@Autowired
	private ValiRepository valiRepository;
	@Autowired
	private ChatLieuRepository chatLieuRepository;
	@Autowired
	private NhomThuongHieuRepository nhomThuongHieuRepository;
	@Autowired
	private NhomValiRepository nhomValiRepository;
	
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

		if (valiRepository.existsByIdNotAndTenVali(valiChungDTO.getId(), valiChungDTO.getTenVali())) {
			errors.rejectValue("tenVali", null, "Tên sản phẩm đã trùng");
		}

		if (valiChungDTO.getBanhXe().trim().length() == 0) {
			errors.rejectValue("banhXe", null, "Bánh xe không được bỏ trống");
		}
		if (valiChungDTO.getDayKeo().trim().length() == 0) {
			errors.rejectValue("dayKeo", null, "Dây kéo không được bỏ trống");
		}
		if (valiChungDTO.getKhoa().trim().length() == 0) {
			errors.rejectValue("khoa", null, "Khóa không được bỏ trống");
		}
		if (valiChungDTO.getThoiGianBaoHanh().trim().length() == 0) {
			errors.rejectValue("thoiGianBaoHanh", null, "Thời gian bảo hành không được bỏ trống");
		}
		if (valiChungDTO.getMoTa().trim().length() == 0) {
			errors.rejectValue("moTa", null, "Mô tả không được bỏ trống");
		}

		// nếu không tồn tại
		if (!chatLieuRepository.existsByTenChatLieu(valiChungDTO.getTenChatLieu())) {
			errors.rejectValue("tenChatLieu", null, "Tên chất liệu không tồn tại");
		}
		if (!nhomThuongHieuRepository.existsByTenThuongHieu(valiChungDTO.getTenThuongHieu())) {
			errors.rejectValue("tenChatLieu", null, "Tên thương hiệu không tồn tại");
		}
		if (!nhomValiRepository.existsByTenNhomVali(valiChungDTO.getTenNhomVali())) {
			errors.rejectValue("tenChatLieu", null, "Tên nhóm vali không tồn tại");
		}
		
		

	}
}
