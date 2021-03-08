package webbanvali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietHoaDonDTO {

	private String maHoaDon;
	private ValiDTO vali;
	private double gia;
	private int soLuong;
}
