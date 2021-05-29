package webbanvali.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin/thong-ke")
public class ThongKeController {

	@GetMapping(value = "/")
	public String trangChu() {
		
		
		return "thongKeAdmin";
	}
}
