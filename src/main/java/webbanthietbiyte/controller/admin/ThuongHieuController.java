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

import webbanvali.dto.MauSacDTO;
import webbanvali.dto.ThuongHieuDTO;

import webbanvali.service.NhomThuongHieuService;


@Controller
@RequestMapping(value = "/admin/thuong-hieu")
public class NhomThuongHieuController {

	@Autowired
	private NhomThuongHieuService nhomThuongHieuService;
	
	
	@GetMapping(value = "/trang-chu")
	public String trangChu(Model model) {
		model.addAttribute("thuongHieus", nhomThuongHieuService.getThuongHieus());
		return "trangChuNhomThuongHieuAdmin";
	}
	
	@GetMapping(value = "/api")
	public ResponseEntity<List<ThuongHieuDTO>> getListTheoTen(@RequestParam("tenThuongHieu") String tenThuongHieu , Model model){
		
		List<ThuongHieuDTO> thuongHieuDTOs = nhomThuongHieuService.getThuongHieusTheoTenThuongHieu(tenThuongHieu);
		
		return ResponseEntity.ok(thuongHieuDTOs);
		
	}
	
	
	@GetMapping(value = "/api/{thuongHieuId}")
	public @ResponseBody ResponseEntity<ThuongHieuDTO> getTheoId(@PathVariable("thuongHieuId") int id){
		
		ThuongHieuDTO thuongHieuDTO =  nhomThuongHieuService.getThuongHieuTheoId(id);
		
		if(thuongHieuDTO == null)
			return new ResponseEntity<ThuongHieuDTO>(HttpStatus.NOT_FOUND);
		
		return ResponseEntity.ok(thuongHieuDTO);
		
	}
	
	@PostMapping(value = "/api")
	public @ResponseBody ResponseEntity<ThuongHieuDTO> them(ThuongHieuDTO thuongHieuDTO1){
		
	ThuongHieuDTO thuongHieuDTO =  nhomThuongHieuService.themThuongHieu(thuongHieuDTO1.getTenThuongHieu());
		if(thuongHieuDTO == null)
			return new ResponseEntity<ThuongHieuDTO>(HttpStatus.BAD_REQUEST);
		
		return ResponseEntity.ok(thuongHieuDTO);
		
	}
	
	@DeleteMapping(value = "/api/{thuongHieuId}")
	public @ResponseBody ResponseEntity<?> xoa(@PathVariable("thuongHieuId") int thuongHieuId){
		
		if(nhomThuongHieuService.xoaThuongHieuTheoId(thuongHieuId))
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	// cập nhật
	@PutMapping(value = "/api")
	public @ResponseBody ResponseEntity<ThuongHieuDTO> capNhat(@RequestBody ThuongHieuDTO thuongHieuDTO1){
		
		
		ThuongHieuDTO thuongHieuDTO =  nhomThuongHieuService.capNhaThuongHieu(thuongHieuDTO1.getId(),thuongHieuDTO1.getTenThuongHieu());
		if(thuongHieuDTO == null)
			return new ResponseEntity<ThuongHieuDTO>(HttpStatus.BAD_REQUEST);
		
		return ResponseEntity.ok(thuongHieuDTO);
		
	}
	
}
