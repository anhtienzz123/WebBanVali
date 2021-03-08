package webbanvali.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webbanvali.service.DiaChiService;

@Controller
@RequestMapping(value = "/dia-chi")
public class DiaChiController {

	@Autowired
	private DiaChiService diaChiService;

	@GetMapping(value = "/quan-huyen")
	public void getQuanHuyen(@RequestParam(name = "maThanhPho", required = true) String maThanhPho,
			HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		List<Map<String, String>> result = diaChiService.getDanhSachQuanHuyenTheoMaThanhPho(maThanhPho);

		for (Map<String, String> map : result) {
			out.format("<option value='%s'>%s</option>\n", map.get("maQuanHuyen"), map.get("tenQuanHuyen"));
		}

	}
	
	@GetMapping(value = "/phuong-xa")
	public void getPhuongXa(@RequestParam(name = "maQuanHuyen", required = true) String maQuanHuyen,
			HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		List<Map<String, String>> result = diaChiService.getDanhSachPhuongXaTheoMaQuanHuyen(maQuanHuyen);

		for (Map<String, String> map : result) {
			out.format("<option value='%s'>%s</option>\n", map.get("maPhuongXa"), map.get("tenPhuongXa"));
		}

	}
}
