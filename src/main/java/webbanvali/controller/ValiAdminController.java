package webbanvali.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webbanvali.dto.BienTheValiDTO;
import webbanvali.dto.ChiTietValiDTO;
import webbanvali.dto.KeyValueDTO;
import webbanvali.dto.ValiCommentDTO;
import webbanvali.service.BannerService;
import webbanvali.service.BienTheValiService;
import webbanvali.service.BinhLuanService;
import webbanvali.service.ValiService;

@Controller
@RequestMapping("/san-pham")
public class ValiAdminController {

	private static final int SIZE = 12;

	@Autowired
	private BienTheValiService bienTheValiService;
	@Autowired
	private BinhLuanService binhLuanService;
	@Autowired
	private ValiService valiService;


	private static final int SIZE1 = 4;

	@GetMapping("/{slug}")
	public String chiTietVali(Model model, @PathVariable("slug") String slug,
			@RequestParam("kichThuoc") String kichThuoc, @RequestParam("mauSac") String mauSac) {

		ChiTietValiDTO result = bienTheValiService.getChiTietValiDTO(slug, kichThuoc, mauSac);
		ValiCommentDTO valiCommentDTO = binhLuanService.getValiCommentTheoValiSlug(slug);

		model.addAttribute("valisTheoNhomVali", bienTheValiService.getBienTheValisTheoNhomVali(result.getNhomValiId()));
		model.addAttribute("valisTheoThuongHieu",
				bienTheValiService.getBienTheValisTheoThuongHieu(result.getThuongHieuId()));
		model.addAttribute("valisBanChay", bienTheValiService.getValisBanChay(SIZE1));
		model.addAttribute("valiComment", valiCommentDTO);
		model.addAttribute("vali", result);
		return "chiTietVali";
	}

	@GetMapping("/")
	public String danhSachVali(Model model,
			@RequestParam(value = "tenVali",required = false ,defaultValue = "") String tenVali
			) {

		Map<String, List<KeyValueDTO>> tieuChis = valiService.getTieuChiTimKiem();

		model.addAttribute("nhomValis", tieuChis.get("nhomValis"));
		model.addAttribute("gias", tieuChis.get("gias"));
		model.addAttribute("thuongHieus", tieuChis.get("thuongHieus"));
		model.addAttribute("chatLieus", tieuChis.get("chatLieus"));
		model.addAttribute("kichThuocs", tieuChis.get("kichThuocs"));
		model.addAttribute("mauSacs", tieuChis.get("mauSacs"));
		model.addAttribute("tinhNangDacBiets", tieuChis.get("tinhNangDacBiets"));

		model.addAttribute("valis", bienTheValiService.getBienTheValisTheoTen(tenVali));

		return "danhSachVali";
	}

	@GetMapping("/api")
	public String danhSachValiApi(Model model,
			@RequestParam(value = "nhomValis", required = false) List<String> nhomValis,
			@RequestParam(value = "gias", required = false) List<String> gias,
			@RequestParam(value = "thuongHieus", required = false) List<String> thuongHieus,
			@RequestParam(value = "chatLieus", required = false) List<String> chatLieus,
			@RequestParam(value = "kichThuocs", required = false) List<String> kichThuocs,
			@RequestParam(value = "mauSacs", required = false) List<String> mauSacs,
			@RequestParam(value = "tinhNangs", required = false) List<String> tinhNangs,
			@RequestParam(value = "loaiSapXep", required = false, defaultValue = "0") String loaiSapXep,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = SIZE + "") int size

	) {

		List<BienTheValiDTO> ketQua = bienTheValiService.getBienTheValisTheoNhieuDieuKien(nhomValis, gias, thuongHieus,
				chatLieus, kichThuocs, mauSacs, tinhNangs, loaiSapXep, page, 1000);

		model.addAttribute("valis", ketQua);

		return "ketQuaDanhSach";
	}
}
