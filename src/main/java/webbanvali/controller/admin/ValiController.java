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

import webbanvali.dto.ValiChungDTO;
import webbanvali.dto.ValiChungResponseDTO;
import webbanvali.service.ValiService;
import webbanvali.utils.FileUploadProcessor;
import webbanvali.validator.ValiChungDTOValidator;

@Controller
@RequestMapping(value = "/admin/vali")
public class ValiController {

	@Autowired
	private ValiService valiService;
	
	@Autowired
	private ValiChungDTOValidator valiChungDTOValidator;
	
	@Autowired
	private FileUploadProcessor fileUploadProcessor;

	@GetMapping("/")
	public String trangChu(Model model,
			@RequestParam(name = "tenVali", required = false, defaultValue = "") String tenVali,
			@RequestParam(name = "chatLieu", required = false, defaultValue = "") String chatLieu,
			@RequestParam(name = "nhomVali", required = false, defaultValue = "") String nhomVali,
			@RequestParam(name = "thuongHieu", required = false, defaultValue = "") String thuongHieu) {

		List<ValiChungResponseDTO> valis = valiService.getValiChungTheoTenValiVaChatLieuVaNhomValiVaThuongHieu(tenVali,
				chatLieu, nhomVali, thuongHieu);

		model.addAttribute("valis", valis);

		return "valiAdmin";
	}

	@GetMapping("/them-vali")
	public String themVali(Model model) {

		Map<String, List<String>> luaChons = valiService.getTenOfTinhNangVaChatLieuVaThuongVaNhomVali();

		model.addAttribute("valiChung", new ValiChungDTO());
		model.addAttribute("tenTinhNangs", luaChons.get("tenTinhNangs"));
		model.addAttribute("tenChatLieus", luaChons.get("tenChatLieus"));
		model.addAttribute("tenThuongHieus", luaChons.get("tenThuongHieus"));
		model.addAttribute("tenNhomValis", luaChons.get("tenNhomValis"));

		return "themVali";
	}

	@PostMapping("/them-vali")
	public String themVali(@ModelAttribute("valiChung") ValiChungDTO valiChungDTO, BindingResult bindingResult) {

		valiChungDTOValidator.validate(valiChungDTO, bindingResult);

		if (!bindingResult.hasErrors()) {

			valiService.themVali(valiChungDTO);
		}

		return "redirect:/admin/vali/them-vali";
	}
	
	
	
}
