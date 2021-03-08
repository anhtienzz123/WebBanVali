package webbanvali.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webbanvali.dto.NguoiDungDTO;
import webbanvali.service.NguoiDungService;
import webbanvali.utils.XuLiNgay;
import webbanvali.validator.NguoiDungValidator;

@Controller
public class LoginController {

	@Autowired
	private NguoiDungValidator nguoiDungValidator;

	@Autowired
	private NguoiDungService nguoiDungService;

	@GetMapping(value = "/login")
	public String login() {

		return "loginForm";
	}

	@GetMapping(value = "/dang-ki")
	public String dangKi(Model model) {

		String maNguoiDung = XuLiNgay.formatDate(LocalDate.now()) + RandomStringUtils.randomAlphanumeric(4);

		NguoiDungDTO nguoiDung = new NguoiDungDTO(maNguoiDung);

		model.addAttribute("nguoiDung", nguoiDung);

		return "dangKi";
	}

	@PostMapping(value = "/dang-ki")
	public String dangKi(HttpServletRequest request, @ModelAttribute("nguoiDung") NguoiDungDTO nguoiDungDTO,
			BindingResult bindingResult) {

		nguoiDungValidator.validate(nguoiDungDTO, bindingResult);

		// nếu có lỗi
		if (bindingResult.hasErrors()) {
			return "dangKi";
		}

		// không có lỗi
		String baseUrl = "http://" + request.getHeader("host");
		nguoiDungService.themNguoiDungVaGoiEmail(nguoiDungDTO, baseUrl);

		return "redirect:/login";
	}

	@GetMapping(value = "/xac-thuc-email")
	public String xacThucEmail(@RequestParam(name = "email", required = true) String email,
			@RequestParam(name = "token", required = true) String token) {

		boolean ketQuaXacThuc = nguoiDungService.xacThucEmail(email, token);

		if (ketQuaXacThuc)
			return "redirect:/TrangChu";

		return "redirect:/error";
	}

	@GetMapping(value = "/quen-mat-khau")
	public String quenMatKhau() {

		return "quenMatKhau";
	}

	@PostMapping(value = "/quen-mat-khau")
	public String quenMatKhau(HttpServletRequest request,
			@RequestParam(value = "email", required = true) String email) {

		nguoiDungService.goiEmailQuenMatKhau(email, request.getHeader("host"));

		return "redirect:/login";
	}

	@GetMapping(value = "/quen-mat-khau/nhap-mat-khau")
	public String xacNhanMatKhau(Model model, @RequestParam(name = "email", required = true) String email,
			@RequestParam(name = "token", required = true) String token) {

		model.addAttribute("email", email);
		model.addAttribute("token", token);

		return "xacNhanMatKhau";
	}

	@PostMapping(value = "/quen-mat-khau/nhap-mat-khau")
	public String xacNhanMatKhau(Model model, @RequestParam(name = "email", required = true) String email,
			@RequestParam(name = "token", required = true) String token,
			@RequestParam(name = "matKhau", required = true) String matKhau) {

		boolean result = nguoiDungService.xacThucMatKhau(email, token, matKhau);

		if (result)
			return "redirect:/login";

		return "error";
	}

}
