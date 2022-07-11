package webbanvali.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import webbanvali.service.BannerService;

@Controller
@RequestMapping(value = "/admin/banner")
public class BannerController {

	@Autowired
	private BannerService bannerService;

	@GetMapping(value = "/trang-chu")
	public String trangChu(Model model) {
		model.addAttribute("banners", bannerService.getBanners());
		
		return "trangChuBanner";
	}

	
	@PostMapping(value = "/")
	public String themBanner(Model model, @RequestParam("tieuDe") String tieuDe, @RequestParam("file") MultipartFile file) {

		bannerService.themBanner(tieuDe, file);
		return "redirect:/admin/banner/trang-chu";
	}

	
	@DeleteMapping(value = "/api/{bannerId}")
	public @ResponseBody ResponseEntity<?> xoa(@PathVariable("bannerId") int bannerId) {

		if (bannerService.xoaBannerTheoId(bannerId))
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
