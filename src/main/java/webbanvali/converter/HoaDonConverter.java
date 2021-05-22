package webbanvali.converter;

import org.springframework.stereotype.Component;

import webbanvali.dto.HoaDonChungDTO;
import webbanvali.dto.HoaDonDTO;
import webbanvali.entity.HoaDon;
import webbanvali.utils.XuLiNgay;
import webbanvali.utils.XuLyTien;

@Component
public class HoaDonConverter {

	public HoaDonChungDTO toHoaDonChungDTO(HoaDon hoaDon) {

		if (hoaDon == null)
			return null;

		HoaDonChungDTO hoaDonChungDTO = new HoaDonChungDTO();

		hoaDonChungDTO.setId(hoaDon.getId());
		hoaDonChungDTO.setHoTenKhachHang(hoaDon.getHoTenKhachHang());
		hoaDonChungDTO.setSoDienThoaiGiaoHang(hoaDon.getSoDienThoaiGiaoHang());
		hoaDonChungDTO.setDiaChiGiaoHang(hoaDon.getDiaChiGiaoHang());
		hoaDonChungDTO.setThoiGianDat(XuLiNgay.toString(hoaDon.getThoiGianDat()));
		hoaDonChungDTO.setTongTien(XuLyTien.dinhDangTien(hoaDon.tinhThanhTien()));
		hoaDonChungDTO.setTrangThaiDonHang(hoaDon.getTrangThaiDonHang());

		return hoaDonChungDTO;
	}
	
	public HoaDonDTO toHoaDonDTO(HoaDon hoaDon) {
		
		if (hoaDon == null)
			return null;
		
		return null;
	}
}
