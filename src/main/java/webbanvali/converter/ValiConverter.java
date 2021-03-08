package webbanvali.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import webbanvali.dto.ChiTietValiDTO;
import webbanvali.dto.NhomValiDTO;
import webbanvali.dto.ValiDTO;
import webbanvali.entity.Vali;

@Component
public class ValiConverter {

	public ValiDTO toDTO(Vali vali) {

		String maVali = vali.getMaVali();

		String tenVali = vali.getTenVali();
		String size = vali.getSize();
		String mau = vali.getMau();
		String slug = vali.getSlug();
		double gia = vali.getGia();
		int khuyenMai = vali.getKhuyenMai();
		long soLuong = vali.getSoLuong();
		String thuongHieu = vali.getThuongHieu();
		String chatLieu = vali.getChatLieu();
		double trongLuong = vali.getTrongLuong();
		String kichThuoc = vali.getKichThuoc();
		int theTich = vali.getTheTich();
		String banhXe = vali.getBanhXe();
		String dayKeo = vali.getDayKeo();
		String khoa = vali.getKhoa();
		String thoiGianBaoHanh = vali.getThoiGianBaoHanh();

		List<ChiTietValiDTO> chiTietValis = vali.getChiTietValis().stream().map(s -> {

			int maChiTietVali = s.getMaChiTietVali();
			String tenChiTiet = s.getTenChiTiet();
			String moTaChiTiet = s.getMoTaChiTiet();
			String tenAnh = s.getTenAnh();

			return new ChiTietValiDTO(maChiTietVali, tenChiTiet, moTaChiTiet, tenAnh);
		}).collect(Collectors.toList());

		NhomValiDTO nhomVali = new NhomValiDTO(vali.getNhomVali().getMaNhomVali(), vali.getNhomVali().getTenNhomVali(),
				vali.getNhomVali().getSlug());

		return new ValiDTO(maVali, tenVali, size, mau, slug, gia, khuyenMai, soLuong, thuongHieu, chatLieu, trongLuong,
				kichThuoc, theTich, banhXe, dayKeo, khoa, thoiGianBaoHanh, chiTietValis, nhomVali);
	}
}
