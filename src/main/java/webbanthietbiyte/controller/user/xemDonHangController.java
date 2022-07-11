package webbanvali.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import webbanvali.dto.BienTheValiDTO;
import webbanvali.dto.ChiTietHoaDonDTO;
import webbanvali.dto.HoaDonChungDTO;
import webbanvali.dto.NguoiDungDTO;
import webbanvali.entity.BienTheVali;
import webbanvali.service.ChiTietHoaDonService;
import webbanvali.service.HoaDonService;
import webbanvali.service.NguoiDungService;
import webbanvali.utils.XuLiNgay;

@Controller
@RequestMapping("/user")
public class xemDonHangController {

	@Autowired
	private HoaDonService hoaDonService;

	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;

	@Autowired
	private NguoiDungService nguoiDungService;

	@RequestMapping(value = "/don-hang")
	public String thongTin(Model model) {
		String emailNguoiDungDangNhap = SecurityContextHolder.getContext().getAuthentication().getName();
		NguoiDungDTO nguoiDungDTO = nguoiDungService.getTheoEmail(emailNguoiDungDangNhap);

		List<HoaDonChungDTO> donHangs = hoaDonService.getHoaDonChungs2(nguoiDungDTO.getSoDienThoai());

		System.out.println(donHangs.toString());
		model.addAttribute("donHangs", donHangs);

		return "xemDonHang";
	}

	// /*

	@PostMapping(value = "/don-hang")
	public String thongTin(Model model, @ModelAttribute("donHangs") HoaDonChungDTO donHangChungDTO,
			BindingResult bindingResult) {
		return "redirect:/user/don-hang";

	}

}
