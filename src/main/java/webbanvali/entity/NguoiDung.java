package webbanvali.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NguoiDung implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String maNguoiDung;

	private String hoTen;
	private boolean gioiTinh;
	private String soDienThoai;
	private String diaChi;
	private String email;
	private String matKhau;
	private String vaiTro;
	private String maXacNhan;
	private boolean trangThai;

	@OneToMany(mappedBy = "nguoiDung")
	private List<HoaDon> hoaDons;
	
	@OneToMany(mappedBy = "nguoiDung")
	private List<BinhLuan> binhLuans;

	public NguoiDung(String maNguoiDung, String email, String matKhau, String vaiTro) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.email = email;
		this.matKhau = matKhau;
		this.vaiTro = vaiTro;
	}

	public NguoiDung(String maNguoiDung, String email, String hoTen, boolean gioiTinh,
			String soDienThoai, String diaChi, String vaiTro, boolean trangThai) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.email = email;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.vaiTro = vaiTro;
		this.trangThai = trangThai;
	}
	
	
	
	
	
	
}
