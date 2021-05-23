package webbanvali.controller.admin;

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
		
		model.addAttribute("thongKe", thongKeService.getThongKeMoiNhat());
		
		return "trangChuAdmin";
	}
	
	
}
