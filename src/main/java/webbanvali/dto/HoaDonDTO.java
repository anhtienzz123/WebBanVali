package webbanvali.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import webbanvali.utils.XuLyTien;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonDTO {

	private String id;
	private String tenKhachHang;
	private String diaChi;
	private String email;
	private String thoiGianDat;
	private String trangThai;
	
	private List<ChiTietHoaDonDTO> chiTietHoaDons;
	
	public String getTongTienString() {
		
		double total = 0;
		for (ChiTietHoaDonDTO chiTietHoaDonDTO : chiTietHoaDons) {
			
			total += chiTietHoaDonDTO.getTongTien();
		}
		
		return XuLyTien.dinhDangTien(total);
	}
}
