package webbanvali.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import webbanvali.dto.ChiTietHoaDonDTO;
import webbanvali.dto.HoaDonChungDTO;
import webbanvali.dto.HoaDonDTO;
import webbanvali.entity.BienTheVali;
import webbanvali.entity.ChiTietHoaDon;
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
		hoaDonChungDTO.setTenVali(hoaDon.getChiTietHoaDons().get(0).getBienTheVali().getVali().getTenVali());
		hoaDonChungDTO.setDiaChiGiaoHang(hoaDon.getDiaChiGiaoHang());
		hoaDonChungDTO.setThoiGianDat(XuLiNgay.toString(hoaDon.getThoiGianDat()));
		hoaDonChungDTO.setTongTien(XuLyTien.dinhDangTien(hoaDon.tinhThanhTien()));
		hoaDonChungDTO.setTrangThaiDonHang(hoaDon.getTrangThaiDonHang());

		return hoaDonChungDTO;
	}
	
	public HoaDonDTO toHoaDonDTO(HoaDon hoaDon) {
		
		if (hoaDon == null)
			return null;
		
		HoaDonDTO result = new HoaDonDTO();
		
		result.setId(hoaDon.getId());
		result.setTenKhachHang(hoaDon.getHoTenKhachHang());
		result.setDiaChi(hoaDon.getDiaChiGiaoHang());
		result.setEmail(hoaDon.getEmail());
		result.setThoiGianDat(XuLiNgay.toString(hoaDon.getThoiGianDat()));
		result.setTrangThai(hoaDon.getTrangThaiDonHang());
		
		List<ChiTietHoaDonDTO> chiTietHoaDonDTOs = new ArrayList<>();
		
		for (ChiTietHoaDon chiTietHoaDon : hoaDon.getChiTietHoaDons()) {
			
			ChiTietHoaDonDTO tempt = new ChiTietHoaDonDTO();
			
			BienTheVali bienTheVali = chiTietHoaDon.getBienTheVali();
			tempt.setTenVali(bienTheVali.getVali().getTenVali() + " " + bienTheVali.getKichThuoc().getTenKichThuoc() + " " +bienTheVali.getMauSac().getTenMau());
			
			tempt.setGia(chiTietHoaDon.getGia());
			tempt.setKhuyenMai(chiTietHoaDon.getKhuyenMai());
			tempt.setSoLuong(chiTietHoaDon.getSoLuong());
			
			
			chiTietHoaDonDTOs.add(tempt);
			
		}
		
		result.setChiTietHoaDons(chiTietHoaDonDTOs);
		
		
		return result;
	}
}
