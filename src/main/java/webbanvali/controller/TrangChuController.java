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
		nguoiDung.setHoTen("Tiên Huỳnh");
		nguoiDung.setSoDienThoai("0935050211");
		nguoiDung.setDiaChi("38 Đường số 1,Phường 04,Quận Gò Vấp,Thành phố Hồ Chí Minh");
		nguoiDung.setMaXacNhan("dkasoo48298djs");
		
		
		NguoiDung nguoiDung1 = new NguoiDung();
		nguoiDung1.setMaNguoiDung("456");
		nguoiDung1.setEmail("user@gmail.com");
		nguoiDung1.setMatKhau(passwordEncoder.encode("user"));
		nguoiDung1.setVaiTro("ROLE_USER");
		nguoiDung1.setTrangThai(true);
		nguoiDung1.setHoTen("Tuấn Nguyễn");
		nguoiDung1.setSoDienThoai("0935320219");
		nguoiDung1.setDiaChi("12 Nguyễn Văn Bảo,Phường 04,Quận Gò Vấp,Thành phố Hồ Chí Minh");
		nguoiDung1.setMaXacNhan("dkasoo48298djs");
	
		nguoiDungRepository.save(nguoiDung);
		nguoiDungRepository.save(nguoiDung1);
		
		
		return "trangChu";
	}
}
