package webbanvali.controller.admin;

import java.util.List;

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

import webbanvali.dto.HoaDonChungDTO;
import webbanvali.dto.HoaDonDTO;
import webbanvali.service.HoaDonService;

@Controller
@RequestMapping(value = "/admin/hoa-don")
public class HoaDonController {

	@Autowired
	private HoaDonService hoaDonService;

	@GetMapping("/")
	public String trangChu(Model model, @RequestParam(value = "id", defaultValue = "") String id,
			@RequestParam(value = "soDienThoai", defaultValue = "") String soDienThoai,
			@RequestParam(value = "trangThai", defaultValue = "") String trangThai,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "30") int size) {

		List<HoaDonChungDTO> hoaDonChungDTOs = hoaDonService.getHoaDonChungs(id, soDienThoai, trangThai, page, size);
		model.addAttribute("hoaDons", hoaDonChungDTOs);

		return "hoaDonAdmin";
	}
	
	@GetMapping("/{id}")
	public String chiTiet(@PathVariable("id") String id, Model model) {
		
		HoaDonDTO hoaDonDTO = hoaDonService.getTheoId(id);
		model.addAttribute("hoaDon", hoaDonDTO);
		System.out.println("size: " + hoaDonDTO.getTongTienString());
		
		return "chiTietHoaDonAdmin";
	}

	@GetMapping("/api")
	public String timKiemHoaDon(Model model, @RequestParam(value = "id", defaultValue = "") String id,
			@RequestParam(value = "soDienThoai", defaultValue = "") String soDienThoai,
			@RequestParam(value = "trangThai", defaultValue = "") String trangThai,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "30") int size) {

		List<HoaDonChungDTO> hoaDonChungDTOs = hoaDonService.getHoaDonChungs(id, soDienThoai, trangThai, page, size);
		model.addAttribute("hoaDons", hoaDonChungDTOs);

		return "ketQuaHoaDonsAdmin";
	}

	@GetMapping("/api/trang-thai")
	public ResponseEntity<?> capNhatTrangThai(@RequestParam("id") String id,
			@RequestParam("trangThai") String trangThai) {

		if (hoaDonService.capNhatTrangThai(id, trangThai)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/api/{id}")
	public ResponseEntity<HoaDonDTO> getTheoId(@PathVariable("id") String id){
		
		HoaDonDTO hoaDonDTO = hoaDonService.getTheoId(id);
		
		if(hoaDonDTO == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<HoaDonDTO>(hoaDonDTO, HttpStatus.OK);
		
		
	}

	@DeleteMapping("/api/{id}")
	public ResponseEntity<?> xoaHoaDon(@PathVariable("id") String id) {

		if (hoaDonService.xoaHoaDon(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
