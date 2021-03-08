package webbanvali.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class TrangChuAdmin {

	@GetMapping(value = "/TrangChu")
	public String index() {
		
		return "trangChuAdmin";
	}
	
	
}
