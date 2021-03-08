package webbanvali.dto;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NguoiDungDTO {

	private String maNguoiDung;

	private String hoTen;
	private boolean gioiTinh;
	private String soDienThoai;
	private String diaChi;
	private String phuongXa;
	private String quanHuyen;
	private String tinhThanhPho;
	private String email;
	private String vaiTro;
	private boolean trangThai;
	
	public NguoiDungDTO(String maNguoiDung) {
		super();
		this.maNguoiDung = maNguoiDung;
	}
	
	
	
	
}
