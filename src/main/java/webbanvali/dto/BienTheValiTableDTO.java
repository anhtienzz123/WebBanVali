package webbanvali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BienTheValiTableDTO {

	private Integer valiId;
	private String tenVali;
	private Integer kichThuocId;
	private String tenKichThuoc;
	private Integer mauSacId;
	private String tenMauSac;
	private long soLuong;
	private double gia;
	private double khuyenMai;
	private boolean noiBat;
}
