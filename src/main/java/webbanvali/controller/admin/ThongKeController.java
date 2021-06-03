package webbanvali.controller.admin;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webbanvali.service.ThongKeService;

@Controller
@RequestMapping(value = "/admin/thong-ke")
public class ThongKeController {

	@Autowired
	private ThongKeService thongKeService;

	@GetMapping(value = "/")
	public String trangChu() {

		return "thongKeAdmin";
	}

	@GetMapping(value = "/thang")
	public String thongKeThang(Model model) {

		LocalDate now = LocalDate.now();
		int thang = now.getMonthValue();
		int nam = now.getYear();

		model.addAttribute("thang", thang);
		model.addAttribute("nam", nam);
		
		model.addAttribute("soHoaDon", thongKeService.soHoaDonTrongThang(thang, nam));
		model.addAttribute("soHoaDonThanhCong", thongKeService.soHoaDonThanhCongTrongThang(thang, nam));
		model.addAttribute("doanhThu", thongKeService.doanhThuTrongThang(thang, nam));
		model.addAttribute("soNguoiDung", thongKeService.soNguoiDungTrongThang(thang, nam));
		model.addAttribute("hoaDonThongKes", thongKeService.thongKeSoLuongValiTrongThang(thang, nam));
		model.addAttribute("hoaDons", thongKeService.getHoaDonsTheoThang(thang, nam));
		
		

		return "thongKeThangAdmin";
	}
	
	@GetMapping(value = "/api/thang")
	public String apiThongKeThang(Model model, @RequestParam("thang")  int thang, @RequestParam("nam")  int nam  ) {

		
		
		
		model.addAttribute("thang", thang);
		model.addAttribute("nam", nam);
		
		model.addAttribute("soHoaDon", thongKeService.soHoaDonTrongThang(thang, nam));
		model.addAttribute("soHoaDonThanhCong", thongKeService.soHoaDonThanhCongTrongThang(thang, nam));
		model.addAttribute("doanhThu", thongKeService.doanhThuTrongThang(thang, nam));
		model.addAttribute("soNguoiDung", thongKeService.soNguoiDungTrongThang(thang, nam));
		model.addAttribute("hoaDonThongKes", thongKeService.thongKeSoLuongValiTrongThang(thang, nam));
		model.addAttribute("hoaDons", thongKeService.getHoaDonsTheoThang(thang, nam));
		
		

		return "ketQuaThongKeThangAdmin";
	}
	

	@GetMapping(value = "/nam")
	public String thongKeNam(Model model) {

		int nam = LocalDate.now().getYear();

		model.addAttribute("nam", nam);
		
		model.addAttribute("soHoaDon", thongKeService.soHoaDonTrongNam(nam));
		model.addAttribute("soHoaDonThanhCong", thongKeService.soHoaDonThanhCongTrongNam(nam));
		model.addAttribute("doanhThu", thongKeService.doanhThuTrongNam(nam));
		model.addAttribute("soNguoiDung", thongKeService.soNguoiDungTrongNam(nam));
		model.addAttribute("hoaDonThongKes", thongKeService.thongKeSoLuongValiTrongNam(nam));
		model.addAttribute("hoaDons", thongKeService.getHoaDonsTheoNam(nam));
		return "thongKeNamAdmin";
	}
	
	@GetMapping(value = "/api/nam")
	public String apiThongKeNam(Model model, @RequestParam("nam")  int nam ) {

	
		model.addAttribute("soHoaDon", thongKeService.soHoaDonTrongNam(nam));
		model.addAttribute("soHoaDonThanhCong", thongKeService.soHoaDonThanhCongTrongNam(nam));
		model.addAttribute("doanhThu", thongKeService.doanhThuTrongNam(nam));
		model.addAttribute("soNguoiDung", thongKeService.soNguoiDungTrongNam(nam));
		model.addAttribute("hoaDonThongKes", thongKeService.thongKeSoLuongValiTrongNam(nam));
		model.addAttribute("hoaDons", thongKeService.getHoaDonsTheoNam(nam));
		return "ketQuaThongKeNamAdmin";
	}
	
	

}
