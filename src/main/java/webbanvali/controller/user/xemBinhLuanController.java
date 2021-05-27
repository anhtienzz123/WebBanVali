package webbanvali.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import webbanvali.dto.BinhLuanDTO;
import webbanvali.dto.HoaDonChungDTO;
import webbanvali.dto.NguoiDungDTO;

import webbanvali.dto.ValiDTO;
import webbanvali.service.BinhLuanService;
import webbanvali.service.HoaDonService;
import webbanvali.service.NguoiDungService;
import webbanvali.service.ValiService;
import webbanvali.utils.ThongTinNguoiDung;
import webbanvali.validator.MatKhauValidator;
import webbanvali.validator.NguoiDungValidator;

@Controller
@RequestMapping("/user")
public class xemBinhLuanController {

	@Autowired
	private BinhLuanService binhLuanService;

	@RequestMapping(value = "/binh-luan")
	public String thongTin(Model model) {

		String emailNguoiDungDangNhap = ThongTinNguoiDung.getUsername();
		List<BinhLuanDTO> binhLuans = binhLuanService.getBinhLuans(emailNguoiDungDangNhap);
		model.addAttribute("binhLuans", binhLuans);
		System.out.println(binhLuans.toString());
		return "xemBinhLuan";
	}

	// Thực hiện xoá bình luận /*
	@GetMapping(value = "/xoa-binh-luan")
	public String xoa(Model model, @RequestParam("valiID") Integer valiID,
			@RequestParam("nguoiDungID") Integer nguoiDungID) {

		binhLuanService.xoaBinhLuanTheoValiIdVaNguoiDungId(valiID, nguoiDungID);

		return "redirect:/user/binh-luan";

	}

}
