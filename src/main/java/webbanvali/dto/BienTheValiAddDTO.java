package webbanvali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	private double gia;
	private double khuyenMai;
	private long soLuong;
	private String theTich;
	private String trongLuong;
	private String moTaKichThuoc;
	private boolean noiBat;
	private String tenAnh;
	
}
