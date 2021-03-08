package webbanvali.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import webbanvali.dto.HoaDonDTO;
import webbanvali.dto.ValiDTO;
import webbanvali.service.ValiService;

@Controller
@RequestMapping(value = "/gio-hang")
public class GioHangController {

	@Autowired
	private ValiService valiService;

	@GetMapping(value = "/xem-gio-hang")
	public String xemGioHang(HttpServletRequest request, HttpSession session) {

		HoaDonDTO hoaDonDTO = (HoaDonDTO) session.getAttribute("gioHang");

		if (hoaDonDTO != null) {
			request.setAttribute("chiTietHoaDons", hoaDonDTO.getChiTietHoaDons());
		}

		return "product/xemgiohang";
	}

	@GetMapping(value = "/them-gio-hang/{maVali}")
	public String themGioHang(HttpServletRequest request, HttpSession session, @PathVariable("maVali") String maVali) {

		ValiDTO valiDTO = valiService.getValiTheoMaVali(maVali);

		HoaDonDTO hoaDonDTO;

		if (session.getAttribute("gioHang") == null) {
			hoaDonDTO = new HoaDonDTO();

		} else {
			hoaDonDTO = (HoaDonDTO) session.getAttribute("gioHang");
		}

		hoaDonDTO.themChiTietHoaDon(valiDTO);
		session.setAttribute("gioHang", hoaDonDTO);

		return "redirect:/xem-gio-hang";
	}

	@GetMapping(value = "/giam-gio-hang/{maVali}")
	public String giamSachGioHang(HttpServletRequest request, HttpSession session,
			@PathVariable("maVali") String maVali) {

		HoaDonDTO hoaDonDTO = (HoaDonDTO) session.getAttribute("gioHang");

		if (hoaDonDTO != null) {

			hoaDonDTO.giamChiTietHoaDon(maVali);

			if (hoaDonDTO.getChiTietHoaDons().isEmpty()) {
				session.removeAttribute("gioHang");
			} else {
				session.setAttribute("gioHang", hoaDonDTO);
			}
		}

		return "redirect:/xem-gio-hang";
	}

	@GetMapping(value = "/xoa-gio-hang/{maVali}")
	public String xoaGioHang(HttpServletRequest request, HttpSession session, @PathVariable("maVali") String maVali) {

		HoaDonDTO hoaDonDTO = (HoaDonDTO) session.getAttribute("gioHang");

		if (hoaDonDTO != null) {

			hoaDonDTO.xoaChiTietHoaDon(maVali);

			if (hoaDonDTO.getChiTietHoaDons().isEmpty()) {
				session.removeAttribute("gioHang");
			} else {
				session.setAttribute("gioHang", hoaDonDTO);
			}
		}

		return "redirect:/xem-gio-hang";
	}
}
