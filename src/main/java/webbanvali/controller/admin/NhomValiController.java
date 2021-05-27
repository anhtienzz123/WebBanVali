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

import webbanvali.dto.ChatLieuDTO;
import webbanvali.dto.MauSacDTO;
import webbanvali.dto.NhomValiDTO;
import webbanvali.dto.TinhNangDacBietDTO;
import webbanvali.service.NhomValiService;

@Controller
@RequestMapping(value = "/admin/nhom-vali")
public class NhomValiController {

	@Autowired
	private NhomValiService nhomValiService;

	@GetMapping(value = "/trang-chu")
	public String trangChu(Model model) {
		model.addAttribute("nhomValis", nhomValiService.getNhomValis());
		return "trangChuNhomValiAdmin";
	}

	@GetMapping(value = "/api")
	public ResponseEntity<List<NhomValiDTO>> getListTheoTen(@RequestParam("tenNhomVali") String tenNhomVali,
			Model model) {

		List<NhomValiDTO> nhomValiDTOs = nhomValiService.getNhomValisTheoTenNhomVali(tenNhomVali);

		return ResponseEntity.ok(nhomValiDTOs);

	}

	@GetMapping(value = "/api/{nhomValiId}")
	public @ResponseBody ResponseEntity<NhomValiDTO> getTheoId(@PathVariable("nhomValiId") int id) {

		NhomValiDTO nhomValiDTO = nhomValiService.getNhomValiTheoId(id);

		if (nhomValiDTO == null)
			return new ResponseEntity<NhomValiDTO>(HttpStatus.NOT_FOUND);

		return ResponseEntity.ok(nhomValiDTO);

	}

	// thêm
	@PostMapping(value = "/api")
	public @ResponseBody ResponseEntity<NhomValiDTO> them(@RequestBody NhomValiDTO nhomValiDTO1) {

		NhomValiDTO nhomValiDTO = nhomValiService.themNhomVali(nhomValiDTO1.getTenNhomVali());
		if (nhomValiDTO == null)
			return new ResponseEntity<NhomValiDTO>(HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(nhomValiDTO);

	}

	@DeleteMapping(value = "/api/{nhomValiId}")
	public @ResponseBody ResponseEntity<?> xoa(@PathVariable("nhomValiId") int nhomValiId) {

		if (nhomValiService.xoaNhomValiTheoId(nhomValiId))
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	// cập nhật
	@PutMapping(value = "/api")
	public @ResponseBody ResponseEntity<NhomValiDTO> capNhat(@RequestBody NhomValiDTO nhomValiDTO1) {

		NhomValiDTO nhomValiDTO = nhomValiService.capNhatNhomVali(nhomValiDTO1.getId(), nhomValiDTO1.getTenNhomVali());
		if (nhomValiDTO == null)
			return new ResponseEntity<NhomValiDTO>(HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(nhomValiDTO);

	}

}
