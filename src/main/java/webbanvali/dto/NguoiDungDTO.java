package webbanvali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import webbanvali.utils.ROLE;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NguoiDungDTO {

	private Integer id;

	private String hoTen;
	private boolean gioiTinh;
	private String soDienThoai;
	private String diaChi;
	private String phuongXa;
	private String quanHuyen;
	private String tinhThanhPho;
	private String email;
	private String matKhau;
	private ROLE vaiTro;
	private boolean trangThai;
	
	public NguoiDungDTO(int id) {
		super();
		this.id = id;
	}
	
	
	
	
}
