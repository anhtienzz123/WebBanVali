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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import webbanvali.dto.BienTheValiAddDTO;
import webbanvali.dto.ChiTietBienTheValiDTO;
import webbanvali.dto.KeyValueDTO;
import webbanvali.service.BienTheValiService;
import webbanvali.service.ValiService;
import webbanvali.validator.BienTheValiValidator;

@Controller
@RequestMapping(value = "/admin/vali")
public class BienTheValiController {

	@Autowired
	private ValiService valiService;

	@Autowired
	private BienTheValiService bienTheValiService;
	@Autowired
	private BienTheValiValidator bienTheValiValidator;

	@GetMapping("/bien-the-valis")
	public String getAll(Model model,
			@RequestParam(name = "tenVali", required = false, defaultValue = "") String tenVali,
			@RequestParam(name = "tenKichThuoc", required = false, defaultValue = "") String tenKichThuoc,
			@RequestParam(name = "tenMauSac", required = false, defaultValue = "") String tenMauSac) {

		model.addAttribute("bienTheValis",
				bienTheValiService.getBienTheValiTableDTOs(tenVali, tenKichThuoc, tenMauSac));

		Map<String, List<KeyValueDTO>> tieuChis = valiService.getTieuChiTimKiem();
		model.addAttribute("kichThuocs", tieuChis.get("kichThuocs"));
		model.addAttribute("mauSacs", tieuChis.get("mauSacs"));

		return "bienTheValiAdmin";

	}

	@GetMapping("/api-bien-the-valis")
	public String getAllApi(Model model,
			@RequestParam(name = "tenVali", required = false, defaultValue = "") String tenVali,
			@RequestParam(name = "tenKichThuoc", required = false, defaultValue = "") String tenKichThuoc,
			@RequestParam(name = "tenMauSac", required = false, defaultValue = "") String tenMauSac) {

		model.addAttribute("bienTheValis",
				bienTheValiService.getBienTheValiTableDTOs(tenVali, tenKichThuoc, tenMauSac));

		return "ketQuaBienTheValisAdmin";

	}
	
	@GetMapping("/chi-tiet")
	public String chiTietBienTheVali(Model model,
			@RequestParam("valiId") Integer valiId,
			@RequestParam("kichThuocId") Integer kichThuocId,
			@RequestParam("mauSacId") Integer mauSacId) {

		ChiTietBienTheValiDTO result = bienTheValiService.getChiTietBienTheValiDTO(valiId, kichThuocId, mauSacId);
		model.addAttribute("data", result);
		
		return "chiTietBienTheValiAdmin";

	}
	
	
	@DeleteMapping("/api-bien-the-valis/xoa")
	public ResponseEntity<?> delete(Model model,
			@RequestParam("valiId") Integer valiId,
			@RequestParam("kichThuocId") Integer kichThuocId,
			@RequestParam("mauSacId") Integer mauSacId) {

		
		if(bienTheValiService.xoa(valiId, kichThuocId, mauSacId)) {
			
			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@GetMapping("/them-bien-the-vali")
	public String themBienTheVali(Model model) {

		setLuaChons(model);
		model.addAttribute("bienTheValiAdd", new BienTheValiAddDTO());
		return "themBienTheVali";
	}

	@PostMapping("/them-bien-the-vali")
	public String themBienTheVali(Model model,@ModelAttribute("bienTheValiAdd") BienTheValiAddDTO bienTheValiAddDTO,
			@RequestParam("file") MultipartFile file, BindingResult bindingResult) {

		bienTheValiAddDTO.setValiId(0);
		bienTheValiAddDTO.setKichThuocId(0);
		bienTheValiAddDTO.setMauSacId(0);
		bienTheValiValidator.validate(bienTheValiAddDTO, bindingResult);

		if (bindingResult.hasErrors()) {

			setLuaChons(model);
			return "themBienTheVali";
		}

		bienTheValiService.themBienTheVali(bienTheValiAddDTO, file);

		return "redirect:/admin/vali/bien-the-valis";
	}

	@GetMapping("/sua-bien-the-vali")
	public String suaBienTheVali(Model model, @RequestParam("valiId") Integer valiId,
			@RequestParam("kichThuocId") Integer kichThuocId, @RequestParam("mauSacId") Integer mauSacId) {


		BienTheValiAddDTO bienTheVali = bienTheValiService.getBienTheValiAdd(valiId, kichThuocId, mauSacId);
		model.addAttribute("bienTheValiAdd", bienTheVali);
	

		return "capNhatBienTheVali";

	}

	@PostMapping("/sua-bien-the-vali")
	public String suaBienTheVali(Model model, @ModelAttribute("bienTheValiAdd") BienTheValiAddDTO bienTheValiAddDTO,
		@RequestParam(value = "file", required = false)MultipartFile file, BindingResult bindingResult) {

		bienTheValiValidator.validate(bienTheValiAddDTO, bindingResult);

		if (bindingResult.hasErrors()) {

			return "themBienTheVali";
		}
		
		
		bienTheValiService.capNhatBienTheVali(bienTheValiAddDTO, file);

		return "redirect:/admin/vali/bien-the-valis";

	}

	private void setLuaChons(Model model) {

		Map<String, List<String>> luaChons = valiService.getTenOfValiVaKichThuocVaMauSac();

		model.addAttribute("tenValis", luaChons.get("tenValis"));
		model.addAttribute("tenKichThuocs", luaChons.get("tenKichThuocs"));
		model.addAttribute("tenMauSacs", luaChons.get("tenMauSacs"));
	}

}
