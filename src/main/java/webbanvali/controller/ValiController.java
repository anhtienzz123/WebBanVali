package webbanvali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import webbanvali.dto.ChiTietValiDTO;
import webbanvali.dto.ValiCommentDTO;
import webbanvali.service.BienTheValiService;
import webbanvali.service.BinhLuanService;

@Controller
public class ValiController {

	@Autowired
	private BienTheValiService bienTheValiService;
	@Autowired
	private BinhLuanService binhLuanService;
	

	@GetMapping("/san-pham/{slug}")
	public String chiTietVali(Model model, @PathVariable("slug") String slug,
			@RequestParam("kichThuoc") String kichThuoc, @RequestParam("mauSac") String mauSac) {

		ChiTietValiDTO result = bienTheValiService.getChiTietValiDTO(slug, kichThuoc, mauSac);
		ValiCommentDTO valiCommentDTO = binhLuanService.getValiCommentTheoValiSlug(slug);
		
		model.addAttribute("valiComment", valiCommentDTO);
		model.addAttribute("vali", result);
	

		return "chiTietVali";
	}
	
	@GetMapping("/san-pham/danh-sach/{slug}")
	public String danhSachVali() {
		
		return "";
	}
}
