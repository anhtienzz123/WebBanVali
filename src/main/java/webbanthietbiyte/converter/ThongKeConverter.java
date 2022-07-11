package webbanvali.converter;

import org.springframework.stereotype.Component;

import webbanvali.dto.HoaDonThongKeDTO;
import webbanvali.dto.NguoiDungThongKeDTO;
import webbanvali.entity.ChiTietHoaDon;
import webbanvali.entity.HoaDon;
import webbanvali.entity.NguoiDung;

@Component
public class ThongKeConverter {

	public HoaDonThongKeDTO toHoaDonThongKeDTO(HoaDon hoaDon) {

		if (hoaDon == null)
			return null;

		HoaDonThongKeDTO hoaDonThongKeDTO = new HoaDonThongKeDTO();

		hoaDonThongKeDTO.setId(hoaDon.getId());
		hoaDonThongKeDTO.setEmail(hoaDon.getEmail());
		hoaDonThongKeDTO.setHoTen(hoaDon.getHoTenKhachHang());
		hoaDonThongKeDTO.setTrangThai(hoaDon.getTrangThaiDonHang());

		double total = 0;

		for (ChiTietHoaDon chiTietHoaDon : hoaDon.getChiTietHoaDons()) {

			total += chiTietHoaDon.tinhThanhTien();
		}

		hoaDonThongKeDTO.setTongTien(total);

		return hoaDonThongKeDTO;
	}
	
	public NguoiDungThongKeDTO toNguoiDungThongKeDTO(NguoiDung nguoiDung) {
		
		if(nguoiDung == null)
			return null;
		
		NguoiDungThongKeDTO result = new NguoiDungThongKeDTO();
		
		result.setEmail(nguoiDung.getEmail());
		result.setHoTen(nguoiDung.getHoTen());
		result.setSoDienThoai(nguoiDung.getSoDienThoai());
		
		return result;
		
	}
}
