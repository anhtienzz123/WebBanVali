package webbanvali.controller.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webbanvali.service.BinhLuanService;

@Controller
@RequestMapping("/admin/binh-luan")
public class BinhLuanController {

	@Autowired
	private BinhLuanService binhLuanService;

	@GetMapping("/xoa")
	public void xoaBinhLuan(HttpServletResponse res,@RequestParam("nguoiDungId") Integer nguoiDungId,
			@RequestParam("valiId") Integer valiId,
			@RequestParam("valiSlug") String valiSlug,
			@RequestParam("kichThuocCode") String kichThuocCode,
			@RequestParam("mauSacCode") String mauSacCode
			)  {

		binhLuanService.xoaBinhLuanTheoValiIdVaNguoiDungId(valiId, nguoiDungId);
		try {
			res.sendRedirect("/WebBanVali/san-pham/"+valiSlug+"?kichThuoc="+kichThuocCode+"&mauSac="+mauSacCode);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
