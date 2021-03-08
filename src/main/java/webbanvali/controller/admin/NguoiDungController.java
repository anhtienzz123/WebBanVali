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
			@RequestParam(name = "size", defaultValue = "5") int size) {

		List<NguoiDungDTO> nguoiDungDTOs = nguoiDungService.getDanhSachNguoiDungTheoEmailVaSoDienThoai("", "", page,
				size);

		model.addAttribute("pageHienTai", page);
		model.addAttribute("nguoiDungs", nguoiDungDTOs);

		return "trangChuNguoiDungAdmin";
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
				soDienThoai, page, size);
		System.out.println("email: " + email);
		System.out.println("size: " + nguoiDungDTOs.size());

		return nguoiDungDTOs;
	}

	@GetMapping(value = "/trang-chu/v1/nguoi-dungs/{maNguoiDung}")
	public ResponseEntity<NguoiDungDTO> getNguoiDungTheoMaNguoiDung(
			@PathVariable(name = "maNguoiDung", required = true) String maNguoiDung) {

		Optional<NguoiDungDTO> ketQuaNguoiDungDTO = nguoiDungService.getTheoMaNguoiDung(maNguoiDung);

		if (ketQuaNguoiDungDTO.isPresent())
			return new ResponseEntity<>(ketQuaNguoiDungDTO.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	
	@DeleteMapping(value = "/trang-chu/v1/nguoi-dungs/{maNguoiDung}")
	public ResponseEntity<?> xoaNguoiDungTheoMaNguoiDung(@PathVariable(name = "maNguoiDung", required = true) String maNguoiDung){
		
		boolean ketQuaXoa = nguoiDungService.xoaNguoiDungTheoMaNguoiDung(maNguoiDung);
		
		if(ketQuaXoa)
			return new ResponseEntity<>(true,HttpStatus.OK);
		else
			return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
	}
	
	

}
