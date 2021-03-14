package webbanvali.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webbanvali.dto.BienTheValiDTO;
import webbanvali.dto.HoaDonDTO;
import webbanvali.service.BienTheValiService;

@Controller
@RequestMapping(value = "/gio-hang")
public class GioHangController {

	@Autowired
	private BienTheValiService bienTheValiService;

	@GetMapping(value = "/xem-gio-hang")
	public String xemGioHang(HttpServletRequest request, HttpSession session) {

		HoaDonDTO hoaDonDTO = (HoaDonDTO) session.getAttribute("gioHang");

		if (hoaDonDTO != null) {
			request.setAttribute("chiTietHoaDons", hoaDonDTO.getChiTietHoaDons());
		}

		return "product/xemgiohang";
	}

	@GetMapping(value = "/them-gio-hang")
	public String themGioHang(HttpServletRequest request, HttpSession session,
			@RequestParam(name = "valiId", required = true) int valiId,
			@RequestParam(name = "kichThuocId", required = true) int kichThuocId,
			@RequestParam(name = "mauSacId", required = true) int mauSacId) {

		BienTheValiDTO bienTheValiDTO = bienTheValiService.getTheoId(valiId, kichThuocId, mauSacId);

		HoaDonDTO hoaDonDTO;

		if (session.getAttribute("gioHang") == null) {
			hoaDonDTO = new HoaDonDTO();
		} else {
			hoaDonDTO = (HoaDonDTO) session.getAttribute("gioHang");
		}

		hoaDonDTO.themChiTietHoaDon(bienTheValiDTO);
		session.setAttribute("gioHang", hoaDonDTO);

		return "redirect:/xem-gio-hang";
	}

	@GetMapping(value = "/giam-gio-hang")
	public String giamSachGioHang(HttpServletRequest request, HttpSession session,
			@RequestParam(name = "valiId", required = true) int valiId,
			@RequestParam(name = "kichThuocId", required = true) int kichThuocId,
			@RequestParam(name = "mauSacId", required = true) int mauSacId) {

		HoaDonDTO hoaDonDTO = (HoaDonDTO) session.getAttribute("gioHang");

		if (hoaDonDTO != null) {

			hoaDonDTO.giamChiTietHoaDon(bienTheValiService.getTheoId(valiId, kichThuocId, mauSacId));

			if (hoaDonDTO.getChiTietHoaDons().isEmpty()) {
				session.removeAttribute("gioHang");
			} else {
				session.setAttribute("gioHang", hoaDonDTO);
			}
		}

		return "redirect:/xem-gio-hang";
	}

	@GetMapping(value = "/xoa-gio-hang/{maVali}")
	public String xoaGioHang(HttpServletRequest request, HttpSession session, 
			@RequestParam(name = "valiId", required = true) int valiId,
			@RequestParam(name = "kichThuocId", required = true) int kichThuocId,
			@RequestParam(name = "mauSacId", required = true) int mauSacId
	) {

		HoaDonDTO hoaDonDTO = (HoaDonDTO) session.getAttribute("gioHang");

		if (hoaDonDTO != null) {

			hoaDonDTO.xoaChiTietHoaDon(bienTheValiService.getTheoId(valiId, kichThuocId, mauSacId));

			if (hoaDonDTO.getChiTietHoaDons().isEmpty()) {
				session.removeAttribute("gioHang");
			} else {
				session.setAttribute("gioHang", hoaDonDTO);
			}
		}

		return "redirect:/xem-gio-hang";
	}
}
