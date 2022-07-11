package webbanvali.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webbanvali.dto.BinhLuanDTO;
import webbanvali.service.BinhLuanService;
import webbanvali.utils.ThongTinNguoiDung;

@Controller
@RequestMapping("/user")
public class xemBinhLuanController {

	@Autowired
	private BinhLuanService binhLuanService;

	@RequestMapping(value = "/binh-luan")
	public String thongTin(Model model) {

		String emailNguoiDungDangNhap = ThongTinNguoiDung.getUsername();
		List<BinhLuanDTO> binhLuans = binhLuanService.getBinhLuans(emailNguoiDungDangNhap);
		model.addAttribute("binhLuans", binhLuans);
		System.out.println(binhLuans.toString());
		return "xemBinhLuan";
	}

	// Thực hiện xoá bình luận /*
	@GetMapping(value = "/xoa-binh-luan")
	public String xoa(Model model, @RequestParam("valiID") Integer valiID,
			@RequestParam("nguoiDungID") Integer nguoiDungID) {

		binhLuanService.xoaBinhLuanTheoValiIdVaNguoiDungId(valiID, nguoiDungID);

		return "redirect:/user/binh-luan";

	}

	@GetMapping(value = "/binh-luan-bai-viet")
	public String binhLuanBaiViet(@RequestParam("valiSlug") String valiSlug, @RequestParam("noiDung") String noiDung
			, @RequestParam("rate") int soDanhGia, @RequestParam("kichThuoc") String kichThuocCode,  @RequestParam("mauSac") String mauSacCode
			) {

		System.out.println("valuSlug: " + valiSlug);
		System.out.println("kichThuoc: " + kichThuocCode);
		System.out.println("mauSac: " + mauSacCode);
		System.out.println("noiDung: " + noiDung);
		System.out.println("rate: " + soDanhGia);
		binhLuanService.themBinhLuan(valiSlug, noiDung, soDanhGia);
		return "redirect:/san-pham/"+valiSlug+"?kichThuoc="+kichThuocCode+"&mauSac="+mauSacCode;
	}
}
