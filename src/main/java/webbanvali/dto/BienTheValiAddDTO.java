package webbanvali.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BienTheValiAddDTO {

	private Integer valiId;
	private Integer kichThuocId;
	private Integer mauSacId;
	private String tenVali;
	private String tenKichThuoc;
	private String tenMauSac;
	
	@Setter(AccessLevel.NONE)
	private double gia;
	@Setter(AccessLevel.NONE)
	private double khuyenMai;
	@Setter(AccessLevel.NONE)
	private long soLuong;
	private String theTich;
	private String trongLuong;
	private String moTaKichThuoc;
	private boolean noiBat;
	private String tenAnh;
	
	public void setGia(Double gia) {
		
		if(gia == null) {
			this.gia = 0;
			return;
		}
		
		this.gia = gia;
	}

	public void setKhuyenMai(Double khuyenMai) {
		
		if(khuyenMai == null) {
			this.khuyenMai = 0;
			return;
		}
		
		
		this.khuyenMai = khuyenMai;
	}

	public void setSoLuong(Long soLuong) {
		
		if(soLuong == null) {
			this.soLuong = 0;
			return;
		}
		
		
		this.soLuong = soLuong;
	}
	
	
	
	
}
