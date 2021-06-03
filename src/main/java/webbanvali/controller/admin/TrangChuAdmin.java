package webbanvali.controller.admin;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import webbanvali.service.ThongKeService;

@Controller
@RequestMapping(value = "/admin")
public class TrangChuAdmin {

	@Autowired
	private ThongKeService thongKeService;
	
	@GetMapping(value = "/trang-chu")
	public String index(Model model) {
		
		LocalDate now = LocalDate.now();
		int day = now.getDayOfMonth();
		int month = now.getMonthValue();
		int year = now.getYear();
		
		model.addAttribute("thongKe", thongKeService.getThongKeMoiNhat());
		model.addAttribute("hoaDons", thongKeService.getHoaDonsTheoNgay(day, month, year));
		model.addAttribute("nguoiDungs", thongKeService.getNguoiDungsTheoNgay(day, month, year));
		
		return "trangChuAdmin";
	}
	
	
}
