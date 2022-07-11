package webbanvali.controller.user;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import webbanvali.dto.NguoiDungDTO;

import webbanvali.service.NguoiDungService;
import webbanvali.validator.MatKhauValidator;
import webbanvali.validator.NguoiDungValidator;

@Controller
@RequestMapping("/user")
public class DoiMatKhauController {
	@Autowired
	private PasswordEncoder ps;
	@Autowired
	private NguoiDungService nguoiDungService;

	@Autowired
	private MatKhauValidator matKhauValidator;

	@RequestMapping(value = "/doi-mk")
	public String thongTin(Model model) {

		String emailNguoiDungDangNhap = SecurityContextHolder.getContext().getAuthentication().getName();

		NguoiDungDTO nguoiDungDTO = nguoiDungService.getTheoEmail(emailNguoiDungDangNhap);

		model.addAttribute("matKhau", nguoiDungDTO);

		nguoiDungDTO.setMatKhau("");

		return "doiMK";
	}

	// Thực hiện đổi mật khẩu /*

	@PostMapping(value = "/doi-mk")
	public String thongTin(Model model, @ModelAttribute("matKhau") NguoiDungDTO nguoiDungDTO,
			@RequestParam("matKhauMoi") String password1, @RequestParam("matKhauXacNhan") String password2,
			BindingResult bindingResult) {

		String emailNguoiDungDangNhap = SecurityContextHolder.getContext().getAuthentication().getName();
		NguoiDungDTO oldPass = nguoiDungService.getTheoEmail(emailNguoiDungDangNhap);

		if (ps.matches(nguoiDungDTO.getMatKhau(), oldPass.getMatKhau())) {
			if (!password1.equals(password2)) {
			} else if (password1.equals(password2)) {
				oldPass.setMatKhau(ps.encode(password1));

				// kiểm tra tính hợp lệ
				matKhauValidator.validate(nguoiDungDTO, bindingResult);
				// nếu không lỗi
				if (!bindingResult.hasErrors()) {
					if (nguoiDungService.save1(oldPass) != null) {
						model.addAttribute("matKhau", oldPass);
					}
				}
			}
		} else {
			model.addAttribute("matKhau", "mật khẩu không đúng");
		}
		return "redirect:/user/doi-mk";

	}
}
