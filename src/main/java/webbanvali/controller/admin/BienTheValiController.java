package webbanvali.controller.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import webbanvali.dto.BienTheValiAddDTO;
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
	public String getAll(Model model

	) {

		model.addAttribute("bienTheValis", bienTheValiService.getBienTheValiTableDTOs());

		return "bienTheValiAdmin";

	}

	@GetMapping("/them-bien-the-vali")
	public String themBienTheVali(Model model) {

		setLuaChons(model);
		model.addAttribute("bienTheValiAdd", new BienTheValiAddDTO());
		return "themBienTheVali";
	}

	@PostMapping("/them-bien-the-vali")
	public String themBienTheVali(@ModelAttribute("bienTheValiAdd") BienTheValiAddDTO bienTheValiAddDTO,
			@RequestParam("file") MultipartFile file, BindingResult bindingResult) {

		bienTheValiValidator.validate(bienTheValiAddDTO, bindingResult);

		if (bindingResult.hasErrors()) {

			return "themBienTheVali";
		}

		bienTheValiService.themBienTheVali(bienTheValiAddDTO, file);

		return "redirect:/admin/vali/bien-the-valis";
	}

	@GetMapping("/sua-bien-the-vali")
	public String suaBienTheVali(Model model, @RequestParam("valiId") Integer valiId,
			@RequestParam("kichThuocId") Integer kichThuocId, @RequestParam("mauSacId") Integer mauSacId) {

		setLuaChons(model);

		BienTheValiAddDTO bienTheVali = bienTheValiService.getBienTheValiAdd(valiId, kichThuocId, mauSacId);
		model.addAttribute("bienTheValiAdd", bienTheVali);

		return "themBienTheVali";

	}

	@PostMapping("/sua-bien-the-vali")
	public String suaBienTheVali(Model model, @ModelAttribute("bienTheValiAdd") BienTheValiAddDTO bienTheValiAddDTO,
			MultipartFile file, BindingResult bindingResult) {

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
