package webbanvali.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import webbanvali.utils.XuLyTien;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BienTheValiDTO {

	private String valiSlug;
	private String kichThuocCode;
	private String mauSacCode;
	private String tenVali;
	private double giaGoc;
	private String gia;
	private String giaGocString;
	private double khuyenMai;
	private String tenAnh;

	public double tinhGia() {
		return giaGoc - ((giaGoc / 100) * khuyenMai);
	}

	public String getGiaString() {
		return XuLyTien.dinhDangTien(tinhGia());
	}

	public String getGiaGocString() {
		return XuLyTien.dinhDangTien(giaGoc);
	}

}
