package webbanvali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietHoaDonDTO {

	private int hoaDonId;
	private String valiId;
	private String tenVali;
	//private BienTheValiDTO bienTheVali;
	private double gia;
	private double khuyenMai;
	private int soLuong;
	
}
