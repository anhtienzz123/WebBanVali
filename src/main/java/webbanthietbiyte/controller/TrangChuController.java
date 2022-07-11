package webbanvali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import webbanvali.entity.NguoiDung;
import webbanvali.repository.BienTheValiRepository;
import webbanvali.repository.HoaDonRepository;
import webbanvali.repository.NguoidungRepository;
import webbanvali.repository.ValiRepository;
import webbanvali.service.BannerService;
import webbanvali.service.BienTheValiService;
import webbanvali.service.NhomValiService;
import webbanvali.utils.ROLE;
import webbanvali.utils.TrangThaiDonHang;

@Controller
public class TrangChuController {

//	@Autowired
//	private PasswordEncoder passwordEncoder;

	@Autowired
	private NguoidungRepository nguoiDungRepository;

	@Autowired
	private ValiRepository valiRepository;
	
	@Autowired
	private BienTheValiRepository bienTheValiRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private HoaDonRepository hoaDonRepository;
	
	@Autowired
	private NhomValiService nhomValiService;
	
	@Autowired
	private BienTheValiService bienTheValiService;
	@Autowired
	private BannerService bannerService;
	
	private static final int SIZE = 4;
	
	@GetMapping(value = "/")
	public String trangChu(Model model) {
		
		
		
		model.addAttribute("nhomValis", nhomValiService.getNhomValis());
		model.addAttribute("valisBanChay", bienTheValiService.getValisBanChay(SIZE));
		model.addAttribute("valisNoiBat", bienTheValiService.getValisNoiBat(SIZE));
		model.addAttribute("valisKhuyenMai", bienTheValiService.getValisKhuyenMai(SIZE*2));
		model.addAttribute("banners", bannerService.getBanners());
		
		return "trangChu";
	}
	
	
	
	
	@GetMapping(value = "/them-tai-khoan")
	public String themTaiKhoan() {

		NguoiDung nguoiDung = new NguoiDung();
		nguoiDung.setId(111111);

		nguoiDung.setEmail("admin@gmail.com");
		nguoiDung.setMatKhau(passwordEncoder.encode("admin"));
		nguoiDung.setVaiTro(ROLE.ROLE_ADMIN);
		nguoiDung.setTrangThai(true);
		nguoiDung.setHoTen("Tiên Huỳnh");
		nguoiDung.setSoDienThoai("0935050211");
		nguoiDung.setDiaChi("38 Đường số 1,Phường 04,Quận Gò Vấp,Thành phố Hồ Chí Minh");
		nguoiDung.setMaXacNhan("dkasoo48298djs");

		NguoiDung nguoiDung1 = new NguoiDung();
		nguoiDung1.setId(222222);
		nguoiDung1.setEmail("user@gmail.com");
		nguoiDung1.setMatKhau(passwordEncoder.encode("user"));
		nguoiDung1.setVaiTro(ROLE.ROLE_USER);
		nguoiDung1.setTrangThai(true);
		nguoiDung1.setHoTen("Tuấn Nguyễn");
		nguoiDung1.setSoDienThoai("0935320219");
		nguoiDung1.setDiaChi("12 Nguyễn Văn Bảo,Phường 04,Quận Gò Vấp,Thành phố Hồ Chí Minh");
		nguoiDung1.setMaXacNhan("dkasoo48298djs");

		nguoiDungRepository.save(nguoiDung);
		nguoiDungRepository.save(nguoiDung1);

		return "trangChu";
	}

	@GetMapping(value = "/test")
	public String test() {

//		System.out.println("size: " + hoaDonRepository.findAllByIdAndSoDienThoaiGiaoHangAndTrangThaiDonHang("", TrangThaiDonHang.DANG_CHO_XU_LY).size());
//		
		
		
		return "redirect:/trang-chu";
	}
}
