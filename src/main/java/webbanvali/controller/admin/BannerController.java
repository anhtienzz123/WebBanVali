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

import webbanvali.dto.BannerDTO;
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

	@GetMapping(value = "/api")
	public @ResponseBody List<BannerDTO> getListTheoTen(@RequestParam("tenAnh") String tenAnh, Model model) {

		List<BannerDTO> bannerDTOs = bannerService.getBannersTheoTenAnh(tenAnh);

		return bannerDTOs;

	}

	// Xem Chi Tiet
	@GetMapping(value = "/api/{bannerId}")
	public @ResponseBody ResponseEntity<BannerDTO> getTheoId(@PathVariable("bannerId") int id) {

		BannerDTO bannerDTOs = bannerService.getBannerTheoId(id);

		if (bannerDTOs == null)
			// status: 404
			return new ResponseEntity<BannerDTO>(HttpStatus.NOT_FOUND);
		// status: 200 success

		return ResponseEntity.ok(bannerDTOs);

	}


	@PostMapping(value = "/api")
	public @ResponseBody ResponseEntity<BannerDTO> them(@RequestBody BannerDTO bannner01) {

		BannerDTO bannerDTO = bannerService.themBanner(bannner01.getTenAnh());
		if (bannerDTO == null)
			return new ResponseEntity<BannerDTO>(HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(bannerDTO);

	}

	// cập nhật
	@PutMapping(value = "/api")
	public @ResponseBody ResponseEntity<BannerDTO> capNhat(@RequestBody BannerDTO bannner01) {

		BannerDTO bannerDTO = bannerService.capNhatBanner(bannner01.getId(), bannner01.getTenAnh());
		if (bannerDTO == null)
			return new ResponseEntity<BannerDTO>(HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(bannerDTO);

	}

	@DeleteMapping(value = "/api/{bannerId}")
	public @ResponseBody ResponseEntity<?> xoa(@PathVariable("bannerId") int bannerId) {

		if (bannerService.xoaBannerTheoId(bannerId))
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
