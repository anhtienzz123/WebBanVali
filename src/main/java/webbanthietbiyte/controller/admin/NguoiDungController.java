package webbanvali.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import webbanvali.dto.NguoiDungDTO;
import webbanvali.service.NguoiDungService;

@Controller(value = "nguoiDungAdmin")
@RequestMapping(value = "/admin/nguoi-dung")
public class NguoiDungController {

	@Autowired
	private NguoiDungService nguoiDungService;

	@GetMapping(value = "/trang-chu")
	public String danhSachNguoiDung(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "20") int size) {

		List<NguoiDungDTO> nguoiDungDTOs = nguoiDungService.getDanhSachNguoiDungTheoEmailVaSoDienThoai("", "", page,
				100);

		model.addAttribute("pageHienTai", page);
		model.addAttribute("nguoiDungs", nguoiDungDTOs);

		return "trangChuNguoiDungAdmin";
	}

	@GetMapping(value = "/cap-nhat/{id}")
	public String capNhatNguoiDung(Model model, @PathVariable("id") Integer id) {

		NguoiDungDTO nguoiDungDTO = nguoiDungService.getTheoMaNguoiDung(id).get();

		model.addAttribute("id", nguoiDungDTO.getId());
		model.addAttribute("hoTen", nguoiDungDTO.getHoTen());
		model.addAttribute("email", nguoiDungDTO.getEmail());
		model.addAttribute("trangThai", nguoiDungDTO.isTrangThai());
		model.addAttribute("vaiTro", nguoiDungDTO.getVaiTro());

		return "capNhatNguoiDungAdmin";
	}

	@PostMapping(value = "/cap-nhat/{id}")
	public String capNhatNguoiDung(@RequestParam("id") Integer id, @RequestParam("trangThai") boolean trangThai,
			@RequestParam("role") String role) {

		nguoiDungService.capNhatTrangThaiVaRole(id, trangThai, role);

		return "redirect:/admin/nguoi-dung/trang-chu";
	}

//	@GetMapping(value = "/danhSach")
//	public String danhSachNguoiDung1(Model model, HttpServletResponse res,@RequestParam(name = "page", defaultValue = "0") int page,
//				@RequestParam(name = "size", defaultValue = "5") int size 
//			){
//		
//		
//		List<NguoiDungDTO> nguoiDungDTOs = nguoiDungService.getDanhSachNguoiDungTheoEmailVaSoDienThoai("", "", page, size);
//		
//		model.addAttribute("pageHienTai", page);
//		model.addAttribute("nguoiDungs", nguoiDungDTOs);
//		
//		return "danhSachNguoiDungAdmin";
//	}

	@GetMapping(value = "/trang-chu/v1/nguoi-dungs")
	public @ResponseBody List<NguoiDungDTO> danhSachNguoiDung1(
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam(name = "soDienThoai", defaultValue = "") String soDienThoai) {

		List<NguoiDungDTO> nguoiDungDTOs = nguoiDungService.getDanhSachNguoiDungTheoEmailVaSoDienThoai(email,
				soDienThoai, page, 100);
		System.out.println("email: " + email);
		System.out.println("size: " + nguoiDungDTOs.size());
		nguoiDungDTOs.forEach(s -> System.out.println(s));

		return nguoiDungDTOs;
	}

	@GetMapping(value = "/trang-chu/v1/nguoi-dungs/{nguoiDungId}")
	public ResponseEntity<NguoiDungDTO> getNguoiDungTheoMaNguoiDung(
			@PathVariable(name = "nguoiDungId", required = true) int nguoiDungId) {

		Optional<NguoiDungDTO> ketQuaNguoiDungDTO = nguoiDungService.getTheoMaNguoiDung(nguoiDungId);

		if (ketQuaNguoiDungDTO.isPresent())
			return new ResponseEntity<>(ketQuaNguoiDungDTO.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@DeleteMapping(value = "/trang-chu/v1/nguoi-dungs/{nguoiDungId}")
	public ResponseEntity<?> xoaNguoiDungTheoMaNguoiDung(
			@PathVariable(name = "nguoiDungId", required = true) int nguoiDungId) {

		boolean ketQuaXoa = nguoiDungService.xoaNguoiDungTheoMaNguoiDung(nguoiDungId);

		if (ketQuaXoa)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
