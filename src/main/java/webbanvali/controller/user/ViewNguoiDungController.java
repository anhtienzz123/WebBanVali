package webbanvali.controller.user;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import webbanvali.dto.NguoiDungDTO;
import webbanvali.service.DiaChiService;
import webbanvali.service.NguoiDungService;
import webbanvali.validator.NguoiDungValidator;

@Controller
@RequestMapping("/user")
public class ViewNguoiDungController {

	@Autowired
	private NguoiDungService nguoiDungService;

	@Autowired
	private DiaChiService diaChiService;
	
	@Autowired
	private NguoiDungValidator nguoiDungValidator;

	@RequestMapping(value = "/thong-tin")
	public String thongTin(Model model) {
		
		String emailNguoiDungDangNhap = SecurityContextHolder.getContext().getAuthentication().getName();

		NguoiDungDTO nguoiDungDTO = nguoiDungService.getTheoEmail(emailNguoiDungDangNhap);

		Map<String, String> thanhPhos = new TreeMap<String, String>();
		Map<String, String> quanHuyens = new TreeMap<String, String>();
		Map<String, String> phuongXas = new TreeMap<String, String>();

		String maThanhPho = "";
		for (Map<String, String> map : diaChiService.getDanhSachThanhPho()) {

			String maThanhPhoTempt = map.get("maThanhPho");
			String tenThanhPhoTempt = map.get("tenThanhPho");
			thanhPhos.put(maThanhPhoTempt, tenThanhPhoTempt);

			if (tenThanhPhoTempt.trim().equalsIgnoreCase(nguoiDungDTO.getTinhThanhPho().trim() ))
				maThanhPho = maThanhPhoTempt;

		}

		String maQuanHuyen = "";

		for (Map<String, String> map : diaChiService.getDanhSachQuanHuyenTheoMaThanhPho(maThanhPho)) {

			String maQuanHuyenTempt = map.get("maQuanHuyen");
			String tenQuanHuyenTempt = map.get("tenQuanHuyen");
			quanHuyens.put(maQuanHuyenTempt, tenQuanHuyenTempt);

			if (tenQuanHuyenTempt.trim().equalsIgnoreCase(nguoiDungDTO.getQuanHuyen().trim()))
				maQuanHuyen = maQuanHuyenTempt;

		}
		
		
		for (Map<String, String> map : diaChiService.getDanhSachPhuongXaTheoMaQuanHuyen(maQuanHuyen)) {
			String maPhuongXaTempt = map.get("maPhuongXa");
			String tenPhuongXaTempt = map.get("tenPhuongXa");
			phuongXas.put(maPhuongXaTempt, tenPhuongXaTempt);
		}
		
		model.addAttribute("nguoiDung", nguoiDungDTO);
		model.addAttribute("thanhPhos", thanhPhos);
		model.addAttribute("quanHuyens", quanHuyens);
		model.addAttribute("phuongXas", phuongXas);
	
		
		return "thongTinNguoiDung";
	}
	
	@PostMapping(value = "/thong-tin")
	public String thongTin( Model model,@ModelAttribute("nguoiDung") NguoiDungDTO nguoiDungDTO, BindingResult bindingResult) {
		
		
		nguoiDungDTO.setPhuongXa(diaChiService.getTenPhuongXaTheoMa(nguoiDungDTO.getPhuongXa()));
		nguoiDungDTO.setQuanHuyen(diaChiService.getTenQuanHuyenTheoMa(nguoiDungDTO.getQuanHuyen()));
		nguoiDungDTO.setTinhThanhPho(diaChiService.getTenTinhThanhPhoTheoMa(nguoiDungDTO.getTinhThanhPho()));
		
		
		// kiểm tra tính hợp lệ 
		nguoiDungValidator.validate(nguoiDungDTO, bindingResult);
	
		// nếu không lỗi
		if(!bindingResult.hasErrors()) {
			
			if(nguoiDungService.save(nguoiDungDTO) != null) {
				model.addAttribute("nguoiDung", nguoiDungDTO);
				
				
			}
		}
		
		return "redirect:/user/thong-tin";
	}
}
