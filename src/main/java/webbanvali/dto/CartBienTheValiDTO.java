package webbanvali.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import webbanvali.utils.XuLyTien;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartBienTheValiDTO {

	private List<CartBienTheValiItemDTO> cartBienTheValiItemDTOs;

	
	
	public double tinhThanhTien() {

		double thanhTien = 0;

		for (CartBienTheValiItemDTO s : cartBienTheValiItemDTOs) {

			thanhTien += s.tinhThanhTien();
		}

		return thanhTien;

	}

	public String getThanhTienString() {

		return XuLyTien.dinhDangTien(tinhThanhTien());

	}

}
