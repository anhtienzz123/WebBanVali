package webbanvali.controller.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webbanvali.dto.KeyValueDTO;
import webbanvali.dto.ValiChungDTO;
import webbanvali.dto.ValiChungResponseDTO;
import webbanvali.service.ValiService;
import webbanvali.validator.ValiChungDTOValidator;

@Controller
@RequestMapping(value = "/admin/vali")
public class ValiController {

	@Autowired
	private ValiService valiService;
	
	@Autowired
	private ValiChungDTOValidator valiChungDTOValidator;
	
	

	@GetMapping("/")
	public String trangChu(Model model,
			@RequestParam(name = "tenVali", required = false, defaultValue = "") String tenVali,
			@RequestParam(name = "nhomVali", required = false, defaultValue = "") String nhomVali,
			@RequestParam(name = "thuongHieu", required = false, defaultValue = "") String thuongHieu) {

		List<ValiChungResponseDTO> valis = valiService.getValiChungTheoTenValiVaChatLieuVaNhomValiVaThuongHieu(tenVali,
				"", nhomVali, thuongHieu);

		Map<String, List<KeyValueDTO>> tieuChis = valiService.getTieuChiTimKiem();
		
		model.addAttribute("nhomValis", tieuChis.get("nhomValis"));
		model.addAttribute("thuongHieus", tieuChis.get("thuongHieus"));
		model.addAttribute("valis", valis);

		return "valiAdmin";
	}
	
	@GetMapping("/api")
	public String ketQuaTrangChu(Model model,
			@RequestParam(name = "tenVali", required = false, defaultValue = "") String tenVali,
			@RequestParam(name = "nhomVali", required = false, defaultValue = "") String nhomVali,
			@RequestParam(name = "thuongHieu", required = false, defaultValue = "") String thuongHieu) {

		List<ValiChungResponseDTO> valis = valiService.getValiChungTheoTenValiVaChatLieuVaNhomValiVaThuongHieu(tenVali,
				"", nhomVali, thuongHieu);
		
		
		model.addAttribute("valis", valis);
		return "ketQuaValiAdmin";
	}
	
	@DeleteMapping("/api/xoa/{id}")
	public ResponseEntity<?> xoaVali(@PathVariable("id") Integer id){
		
		if(valiService.xoa(id))
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/them-vali")
	public String themVali(Model model) {

		setLuaChons(model);
		model.addAttribute("valiChung", new ValiChungDTO());

		return "themVali";
	}

	@PostMapping("/them-vali")
	public String themVali(Model model, @ModelAttribute("valiChung") ValiChungDTO valiChungDTO, BindingResult bindingResult) {

		valiChungDTO.setId(0);
		valiChungDTOValidator.validate(valiChungDTO, bindingResult);

		if (bindingResult.hasErrors()) {

			setLuaChons(model);
			return "themVali";
		}
		valiService.themVali(valiChungDTO);
		return "redirect:/admin/vali/";
	}
	

	@GetMapping("/sua-vali/{id}")
	public String suaVali(Model model, @PathVariable("id") Integer id) {

		
		setLuaChons(model);
		ValiChungDTO valiChungDTO = valiService.getValiChungById(id);
		
		model.addAttribute("valiChung", valiChungDTO);
		
		

		return "themVali";
	}

	@PostMapping("/sua-vali/{id}")
	public String suaVali(@PathVariable("id") Integer id,@ModelAttribute("valiChung") ValiChungDTO valiChungDTO, BindingResult bindingResult) {

		valiChungDTOValidator.validate(valiChungDTO, bindingResult);

		if (!bindingResult.hasErrors()) {

			valiService.capNhatVali(id,valiChungDTO);
		}
		
	
		return "redirect:/admin/vali/";
	}
	
	
	
	private void setLuaChons(Model model) {

		Map<String, List<String>> luaChons = valiService.getTenOfTinhNangVaChatLieuVaThuongVaNhomVali();

		
		model.addAttribute("tenTinhNangs", luaChons.get("tenTinhNangs"));
		model.addAttribute("tenChatLieus", luaChons.get("tenChatLieus"));
		model.addAttribute("tenThuongHieus", luaChons.get("tenThuongHieus"));
		model.addAttribute("tenNhomValis", luaChons.get("tenNhomValis"));
	}
	
}
