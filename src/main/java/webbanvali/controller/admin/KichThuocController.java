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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import webbanvali.dto.KichThuocDTO;
import webbanvali.service.KichThuocService;

@Controller
@RequestMapping(value = "/admin/kich-thuoc")
public class KichThuocController {

	@Autowired
	private KichThuocService kichThuocService;

	@GetMapping(value = "/trang-chu")
	public String trangChu(Model model) {
		model.addAttribute("kichThuocs", kichThuocService.getKichThuocs());
		return "kichThuocAdmin";
	}

	@GetMapping(value = "/api")
	public @ResponseBody List<KichThuocDTO> getListTheoTen(@RequestParam("tenKichThuoc") String tenKichThuoc,
			Model model) {

		List<KichThuocDTO> kichThuocDTOs = kichThuocService.getKichThuocsTheoTen(tenKichThuoc);

		return kichThuocDTOs;

	}

	// Xem Chi Tiet
	@GetMapping(value = "/api/{kichThuocId}")
	public @ResponseBody ResponseEntity<KichThuocDTO> getTheoId(@PathVariable("kichThuocId") int id) {

		KichThuocDTO kichThuocDTO = kichThuocService.getKichThuocTheoId(id);

		if (kichThuocDTO == null)
			// status: 404
			return new ResponseEntity<KichThuocDTO>(HttpStatus.NOT_FOUND);
		// status: 200 success

		return ResponseEntity.ok(kichThuocDTO);

	}

	// thêm
	@PostMapping(value = "/api")
	public @ResponseBody ResponseEntity<KichThuocDTO> them(@RequestBody KichThuocDTO kichThuocDTO1) {

		KichThuocDTO kichThuocDTO = kichThuocService.themKichThuoc(kichThuocDTO1.getTenKichThuoc());
		if (kichThuocDTO == null)
			return new ResponseEntity<KichThuocDTO>(HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(kichThuocDTO);

	}

	// cập nhật
	@PutMapping(value = "/api")
	public @ResponseBody ResponseEntity<KichThuocDTO> capNhat(@RequestBody KichThuocDTO kichThuocDTO1) {

		KichThuocDTO kichThuocDTO = kichThuocService.capNhatKichThuoc(kichThuocDTO1.getId(),
				kichThuocDTO1.getTenKichThuoc());
		if (kichThuocDTO == null)
			return new ResponseEntity<KichThuocDTO>(HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(kichThuocDTO);

	}

	@DeleteMapping(value = "/api/{kichThuocId}")
	public @ResponseBody ResponseEntity<?> xoa(@PathVariable("kichThuocId") int kichThuocId) {

		if (kichThuocService.xoaKichThuocTheoId(kichThuocId))
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
