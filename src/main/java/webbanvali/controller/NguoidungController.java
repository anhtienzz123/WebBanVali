package webbanvali.controller;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import webbanvali.dto.NguoiDungDTO;
import webbanvali.service.DiaChiService;
import webbanvali.service.NguoiDungService;

@Controller
@RequestMapping(value = "/user")
public class NguoidungController {

	@Autowired
	private NguoiDungService nguoiDungService;

	@Autowired
	private DiaChiService diaChiServiceImpl;

	@RequestMapping(value = "/thong-tin")
	public String thongTin(Model model) {
		
		String emailNguoiDungDangNhap = SecurityContextHolder.getContext().getAuthentication().getName();

		NguoiDungDTO nguoiDungDTO = nguoiDungService.getTheoEmail(emailNguoiDungDangNhap);

		Map<String, String> thanhPhos = new TreeMap<String, String>();
		Map<String, String> quanHuyens = new TreeMap<String, String>();
		Map<String, String> phuongXas = new TreeMap<String, String>();

		String maThanhPho = "";
		for (Map<String, String> map : diaChiServiceImpl.getDanhSachThanhPho()) {

			String maThanhPhoTempt = map.get("maThanhPho");
			String tenThanhPhoTempt = map.get("tenThanhPho");
			thanhPhos.put(maThanhPhoTempt, tenThanhPhoTempt);

			if (tenThanhPhoTempt.trim().equalsIgnoreCase(nguoiDungDTO.getTinhThanhPho().trim() ))
				maThanhPho = maThanhPhoTempt;

		}

		String maQuanHuyen = "";
		System.out.println("maThanhpho: " + maThanhPho);
		for (Map<String, String> map : diaChiServiceImpl.getDanhSachQuanHuyenTheoMaThanhPho(maThanhPho)) {

			String maQuanHuyenTempt = map.get("maQuanHuyen");
			String tenQuanHuyenTempt = map.get("tenQuanHuyen");
			quanHuyens.put(maQuanHuyenTempt, tenQuanHuyenTempt);

			if (tenQuanHuyenTempt.trim().equalsIgnoreCase(nguoiDungDTO.getQuanHuyen().trim()))
				maQuanHuyen = maQuanHuyenTempt;

		}
		
		System.out.println("maQuanHuyen: " + maQuanHuyen);
		
		for (Map<String, String> map : diaChiServiceImpl.getDanhSachPhuongXaTheoMaQuanHuyen(maQuanHuyen)) {
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
}
