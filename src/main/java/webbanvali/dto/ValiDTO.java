package webbanvali.dto;

import java.util.List;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ValiDTO {

	private String maVali;

	private String tenVali;
	private String size;
	private String mau;
	private String slug;
	private double gia;
	private int khuyenMai;
	private long soLuong;
	private String thuongHieu;
	private String chatLieu;
	private double trongLuong;
	private String kichThuoc;
	private int theTich;
	private String banhXe;
	private String dayKeo;
	private String khoa;
	private String thoiGianBaoHanh;
	
	private List<ChiTietValiDTO> chiTietValis;
	
	private NhomValiDTO nhomValiDTO;

}
