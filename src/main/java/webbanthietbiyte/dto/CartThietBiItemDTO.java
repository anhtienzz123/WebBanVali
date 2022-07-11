package webbanvali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import webbanvali.utils.XuLyTien;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartBienTheValiItemDTO {

	private BienTheValiDTO bienTheValiDTO;
	private int soLuong;
	private boolean trangThai;

	public double tinhThanhTien() {

		return bienTheValiDTO.tinhGia() * soLuong;

	}

	public String getThanhTienString() {
		return XuLyTien.dinhDangTien(tinhThanhTien());

	}

}
