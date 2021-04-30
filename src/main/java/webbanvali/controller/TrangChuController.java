package webbanvali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import webbanvali.entity.NguoiDung;
import webbanvali.repository.BienTheValiRepository;
import webbanvali.repository.NguoidungRepository;
import webbanvali.repository.ValiRepository;
import webbanvali.utils.BienTheValiSpecification;
import webbanvali.utils.ROLE;

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

	@RequestMapping(value = "/trang-chu")
	public String trangChu() {

		return "trangChu";
	}

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/them-tai-khoan")
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

		// Test 1
//		Specification<Vali> specification = Specification.where(ValiSpecification.timKiemTheoTenVali("vali 1"))
//				.and(ValiSpecification.timKiemTheoSlug("slug"));
//		valiRepository.findAll(specification, PageRequest.of(0, 1)).forEach(s -> System.out.println(s.getId()));

		// Test 2

//		List<String> tenThuongHieus = Arrays.asList("thuonghieu1", "thuonghieu2");
//
//		valiRepository.findAll(ValiSpecification.timKiemTheoThuongHieu(tenThuongHieus))
//				.forEach(s -> System.out.println(s.getTenVali()));
		
//		List<String> tenTinhNangs = Arrays.asList("tinhnang1","tinhnang2" ,"tinhnang3");
//		List<String> tenThuongHieus = Arrays.asList("thuonghieu1", "thuonghieu2");
//		
//		Specification<Vali> condition = Specification.where(ValiSpecification.timKiemTheoTenTinhNang(tenTinhNangs)).and(ValiSpecification.timKiemTheoThuongHieu(tenThuongHieus));
//
//		
//		valiRepository.findAll(condition).forEach(s -> System.out.println(s.getTenVali()));
		
		// test bien the
		
		bienTheValiRepository.findAll(BienTheValiSpecification.timKiemTheoCodeNhomVali("nhom-vali-1")).forEach(s -> System.out.println(s.getVali().getTenVali()));
		
		return "redirect:/trang-chu";
	}
}
