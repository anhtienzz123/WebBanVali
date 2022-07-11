package webbanvali.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NgoaiLeController {

	@RequestMapping(value = "/403")
	public String loi() {
		
		return "error403";
	}
}
