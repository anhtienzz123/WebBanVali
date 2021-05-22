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
import webbanvali.service.MauSacService;

@Controller
@RequestMapping(value = "/admin/mau-sac")
public class MauSacController {

	@Autowired
	private MauSacService mauSacService;
	
	
	@GetMapping(value = "/trang-chu")
	public String trangChu(Model model) {
		model.addAttribute("mauSacs", mauSacService.getMauSacs());
		return "trangChuMauSacAdmin";
	}
	
	@GetMapping(value = "/api")
	public @ResponseBody List<MauSacDTO> getListTheoTen(@RequestParam("tenMau") String tenMau , Model model){
		
		List<MauSacDTO> mauSacDTOs = mauSacService.getMauSacsTheoTenMau(tenMau);
		
		return mauSacDTOs;
		
	}
	
	// Xem Chi Tiet
	@GetMapping(value = "/api/{mauSacId}")
	public @ResponseBody ResponseEntity<MauSacDTO> getTheoId(@PathVariable("mauSacId") int id){
		
		MauSacDTO mauSacDTO =  mauSacService.getMauSacTheoId(id);
		
		if(mauSacDTO == null)
			// status: 404
			return new ResponseEntity<MauSacDTO>(HttpStatus.NOT_FOUND);
		// status: 200 success
		
		return ResponseEntity.ok(mauSacDTO);
		
	}
	
	// thêm
	@PostMapping(value = "/api")
	public @ResponseBody ResponseEntity<MauSacDTO> them(@RequestBody MauSacDTO mauSacDTO1){
		
		MauSacDTO mauSacDTO =  mauSacService.themMauSac(mauSacDTO1.getTenMau());
		if(mauSacDTO == null)
			return new ResponseEntity<MauSacDTO>(HttpStatus.BAD_REQUEST);
		
		return ResponseEntity.ok(mauSacDTO);
		
	}
	
	// cập nhật
	@PutMapping(value = "/api")
	public @ResponseBody ResponseEntity<MauSacDTO> capNhat(@RequestBody MauSacDTO mauSacDTO1){
		
		
		MauSacDTO mauSacDTO =  mauSacService.capNhatMauSac(mauSacDTO1.getId(),mauSacDTO1.getTenMau());
		if(mauSacDTO == null)
			return new ResponseEntity<MauSacDTO>(HttpStatus.BAD_REQUEST);
		
		return ResponseEntity.ok(mauSacDTO);
		
	}
	
	@DeleteMapping(value = "/api/{mauSacId}")
	public @ResponseBody ResponseEntity<?> xoa(@PathVariable("mauSacId") int mauSacId){
		
		if(mauSacService.xoaMauSacTheoId(mauSacId))
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	

}
