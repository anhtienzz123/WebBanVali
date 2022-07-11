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

import webbanvali.dto.TinhNangDacBietDTO;
import webbanvali.service.TinhNangDacBietService;

@Controller
@RequestMapping(value = "/admin/tinh-nang-dac-biet")
public class TinhNangDacBietController {
	@Autowired
	private TinhNangDacBietService tinhNangDacBietService;

	@GetMapping(value = "/trang-chu")
	public String trangChu(Model model) {
		model.addAttribute("tinhNangDacBiets", tinhNangDacBietService.getTinhNangDacBiets());
		return "trangChuTinhNangDacBietAdmin";
	}

	@GetMapping(value = "/api")
	public @ResponseBody List<TinhNangDacBietDTO> getListTheoTen(@RequestParam("tenTinhNang") String tenTinhNang,
			Model model) {

		List<TinhNangDacBietDTO> tinhNangDacBietDTOs = tinhNangDacBietService
				.getTinhNangDacBietsTheoTenTinhNang(tenTinhNang);

		return tinhNangDacBietDTOs;

	}

	@GetMapping(value = "/api/{tinhNangDacBietId}")
	public @ResponseBody ResponseEntity<TinhNangDacBietDTO> getTheoId(@PathVariable("tinhNangDacBietId") int id) {

		TinhNangDacBietDTO tinhNangDacBietDTO = tinhNangDacBietService.getTinhNangDacBietTheoId(id);

		if (tinhNangDacBietDTO == null)
			// status: 404
			return new ResponseEntity<TinhNangDacBietDTO>(HttpStatus.NOT_FOUND);
		// status: 200 success

		return ResponseEntity.ok(tinhNangDacBietDTO);

	}

	// thêm
	@PostMapping(value = "/api")
	public @ResponseBody ResponseEntity<TinhNangDacBietDTO> them(@RequestBody TinhNangDacBietDTO tinhNangDacBietDTO1) {

		TinhNangDacBietDTO tinhNangDacBietDTO = tinhNangDacBietService
				.themTinhNangDacBiet(tinhNangDacBietDTO1.getTenTinhNang());
		if (tinhNangDacBietDTO == null)
			return new ResponseEntity<TinhNangDacBietDTO>(HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(tinhNangDacBietDTO);

	}

	// cập nhật
	@PutMapping(value = "/api")
	public @ResponseBody ResponseEntity<TinhNangDacBietDTO> capNhat(@RequestBody TinhNangDacBietDTO tinhNangDacBietDTO1) {

		TinhNangDacBietDTO tinhNangDacBietDTO = tinhNangDacBietService
				.capNhatTinhNangDacBiet(tinhNangDacBietDTO1.getId(), tinhNangDacBietDTO1.getTenTinhNang());
		if (tinhNangDacBietDTO == null)
			return new ResponseEntity<TinhNangDacBietDTO>(HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(tinhNangDacBietDTO);

	}
	
	@DeleteMapping(value = "/api/{tinhNangDacBietId}")
	public @ResponseBody ResponseEntity<?> xoa(@PathVariable("tinhNangDacBietId") int tinhNangDacBietId){
		
		if(tinhNangDacBietService.xoaTinhNangDacBietTheoId(tinhNangDacBietId))
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
}
