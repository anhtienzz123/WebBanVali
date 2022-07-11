package webbanvali.dto;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import webbanvali.utils.XuLyTien;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonThongKeDTO {

	private String id;
	private String email;
	private String hoTen;
	
	private double tongTien;
	private String trangThai;
	
	public String getTongTienString() {
		
		return XuLyTien.dinhDangTien(tongTien);
	}
	
	
	
}
