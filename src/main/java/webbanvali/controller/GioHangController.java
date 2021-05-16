package webbanvali.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webbanvali.dto.CartDTO;
import webbanvali.service.GioHangService;
import webbanvali.service.NguoiDungService;

@Controller
@RequestMapping(value = "/gio-hang")
public class GioHangController {

	@Autowired
	private GioHangService gioHangService;
	@Autowired
	private NguoiDungService nguoiDungService;

	@GetMapping(value = "")
	public String xemGioHang(Model model, HttpSession session) {

		CartDTO cartDTO = (CartDTO) session.getAttribute("gioHang");

		if (cartDTO != null) {
			model.addAttribute("cart", gioHangService.convertCartDTOToCartBienTheValiDTO(cartDTO));
		}

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		model.addAttribute("nguoiDung", nguoiDungService.getTheoEmail(username));

		return "gioHang";
	}

	@GetMapping(value = "/them-gio-hang")
	public String themGioHang(HttpSession session, @RequestParam(name = "valiSlug") String valiSlug,
			@RequestParam(name = "kichThuocCode") String kichThuocCode,
			@RequestParam(name = "mauSacCode") String mauSacCode) {

		

		CartDTO cartDTO;

		if (session.getAttribute("gioHang") == null) {
			cartDTO = new CartDTO();
		} else {
			cartDTO = (CartDTO) session.getAttribute("gioHang");
		}

		cartDTO.them(valiSlug, kichThuocCode, mauSacCode);
		session.setAttribute("gioHang", cartDTO);
		System.out.println("=====gioHang: " + cartDTO);

		return "redirect:/gio-hang";
	}

	@GetMapping(value = "/giam-gio-hang")
	public String giamSachGioHang(HttpSession session, @RequestParam(name = "valiSlug") String valiSlug,
			@RequestParam(name = "kichThuocCode") String kichThuocCode,
			@RequestParam(name = "mauSacCode") String mauSacCode) {

		CartDTO cartDTO = (CartDTO) session.getAttribute("gioHang");

		if (cartDTO != null) {

			cartDTO.giam(valiSlug, kichThuocCode, mauSacCode);

			if (cartDTO.getCartItemDTOs().isEmpty()) {
				session.removeAttribute("gioHang");

			} else {
				session.setAttribute("gioHang", cartDTO);
			}
		}

		return "redirect:/gio-hang";
	}

	@GetMapping(value = "/xoa-gio-hang/{maVali}")
	public String xoaGioHang(HttpServletRequest request, HttpSession session,
			@RequestParam(name = "valiSlug") String valiSlug,
			@RequestParam(name = "kichThuocCode") String kichThuocCode,
			@RequestParam(name = "mauSacCode") String mauSacCode) {

		CartDTO cartDTO = (CartDTO) session.getAttribute("gioHang");

		if (cartDTO != null) {

			cartDTO.xoa(valiSlug, kichThuocCode, mauSacCode);

			if (cartDTO.getCartItemDTOs().isEmpty()) {
				session.removeAttribute("gioHang");
			} else {
				session.setAttribute("gioHang", cartDTO);
			}
		}

		return "redirect:/gio-hang";
	}

	@GetMapping(value = "/dat-hang")
	public String datHang(HttpSession session) {

		CartDTO cartDTO = (CartDTO) session.getAttribute("gioHang");

		if (gioHangService.datHang(cartDTO)) {

			session.removeAttribute("gioHang");
			return "ketQuaDatHang";
		}

		return "redirect:/gio-hang";

	}
}
