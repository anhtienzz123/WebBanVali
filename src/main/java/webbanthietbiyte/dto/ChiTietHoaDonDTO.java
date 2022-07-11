package webbanvali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import webbanvali.utils.XuLyTien;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietHoaDonDTO {

	private int hoaDonId;
	private String valiId;
	private String tenVali;
	// private BienTheValiDTO bienTheVali;
	private double gia;
	private double khuyenMai;
	private int soLuong;

	public String getGiaGocString() {
		return XuLyTien.dinhDangTien(gia);
	}
	
	public String getGiaString() {

		return XuLyTien.dinhDangTien((gia - (gia / 100 * khuyenMai)));
	}

	public double getTongTien() {

		return (gia - (gia / 100 * khuyenMai)) * soLuong;

	}

	public String getTongTienString() {

		return XuLyTien.dinhDangTien(getTongTien());
	}

}
