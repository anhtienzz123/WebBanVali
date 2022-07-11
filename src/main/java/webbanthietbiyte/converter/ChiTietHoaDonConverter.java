package webbanvali.converter;

import org.springframework.stereotype.Component;

import webbanvali.dto.BienTheValiDTO;
import webbanvali.dto.ChiTietHoaDonDTO;

import webbanvali.dto.HoaDonDTO;
import webbanvali.entity.ChiTietHoaDon;
import webbanvali.entity.HoaDon;

@Component
public class ChiTietHoaDonConverter {

	public ChiTietHoaDonDTO toChiTietHoaDonDTO(ChiTietHoaDon chiTietHoaDon) {

		
		if (chiTietHoaDon == null)
			return null;

		ChiTietHoaDonDTO chiTietHoaDonDTO = new ChiTietHoaDonDTO();

		chiTietHoaDonDTO.setHoaDonId(Integer.parseInt(chiTietHoaDon.getHoaDon().getId()));
		chiTietHoaDonDTO.setValiId(String.valueOf(chiTietHoaDon.getBienTheVali().getVali().getId()));
		chiTietHoaDonDTO.setTenVali(chiTietHoaDon.getBienTheVali().getVali().getTenVali());
		chiTietHoaDonDTO.setGia(chiTietHoaDon.getGia());
		chiTietHoaDonDTO.setKhuyenMai(chiTietHoaDon.getKhuyenMai());
		chiTietHoaDonDTO.setSoLuong(chiTietHoaDon.getSoLuong());

		return chiTietHoaDonDTO;
	}

	public HoaDonDTO toHoaDonDTO(HoaDon hoaDon) {

		if (hoaDon == null)
			return null;

		return null;
	}
}
