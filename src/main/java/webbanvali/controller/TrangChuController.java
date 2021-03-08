package webbanvali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import webbanvali.entity.NguoiDung;
import webbanvali.repository.NguoidungRepository;

@Controller
public class TrangChuController {

	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private NguoidungRepository nguoiDungRepository;
	
	@RequestMapping(value = "/trang-chu")
	public String trangChu() {
		

		return "trangChu";
	}
	
	@RequestMapping(value = "/them-tai-khoan")
	public String themTaiKhoan() {
		
		NguoiDung nguoiDung = new NguoiDung();
		nguoiDung.setMaNguoiDung("123");
		nguoiDung.setEmail("admin@gmail.com");
		nguoiDung.setMatKhau(passwordEncoder.encode("admin"));
		nguoiDung.setVaiTro("ROLE_ADMIN");
		nguoiDung.setTrangThai(true);
		
		NguoiDung nguoiDung1 = new NguoiDung();
		nguoiDung1.setMaNguoiDung("456");
		nguoiDung1.setEmail("user@gmail.com");
		nguoiDung1.setMatKhau(passwordEncoder.encode("user"));
		nguoiDung1.setVaiTro("ROLE_USER");
		nguoiDung1.setTrangThai(true);
	
		nguoiDungRepository.save(nguoiDung);
		nguoiDungRepository.save(nguoiDung1);
		
		
		return "trangChu";
	}
}
