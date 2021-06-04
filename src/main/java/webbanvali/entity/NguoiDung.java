package webbanvali.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import webbanvali.utils.ROLE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nguoi_dung")
public class NguoiDung implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name = "ho_ten")
	private String hoTen;
	@Column(name = "gioi_tinh")
	private boolean gioiTinh;
	@Column(name = "so_dien_thoai")
	private String soDienThoai;
	@Column(name = "dia_chi")
	private String diaChi;
	private String email;
	@Column(name = "mat_khau")
	private String matKhau;
	@Column(name = "ngay_tao")
	private LocalDate ngayTao;
	@Column(name = "vai_tro")
	@Enumerated(EnumType.STRING)
	private ROLE vaiTro;
	@Column(name = "ma_xac_nhan")
	private String maXacNhan;
	@Column(name = "trang_thai")
	private boolean trangThai;
	

	@OneToMany(mappedBy = "nguoiDung")
	private List<HoaDon> hoaDons;
	
	@OneToMany(mappedBy = "nguoiDung")
	private List<BinhLuan> binhLuans;
	

	
	
	public NguoiDung(int id, String hoTen,String email, String matKhau, ROLE vaiTro, LocalDate ngayTao, String diaChi, String soDienThoai) {
		super();
		
		this.id = id;
		this.hoTen = hoTen;
		this.email = email;
		this.matKhau = matKhau;
		this.vaiTro = vaiTro;
		this.ngayTao = ngayTao;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		
	}

	public NguoiDung(int id, String email, String hoTen, boolean gioiTinh,
			String soDienThoai, String diaChi, ROLE vaiTro, boolean trangThai) {
		super();
		this.id = id;
		this.email = email;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.vaiTro = vaiTro;
		this.trangThai = trangThai;
	}

	public NguoiDung(int id, String hoTen, boolean gioiTinh, String soDienThoai, String diaChi,
			String email, String matKhau, ROLE vaiTro, String maXacNhan, boolean trangThai) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.email = email;
		this.matKhau = matKhau;
		this.vaiTro = vaiTro;
		this.maXacNhan = maXacNhan;
		this.trangThai = trangThai;
	}

	public NguoiDung(Integer id) {
		super();
		this.id = id;
	}

}
