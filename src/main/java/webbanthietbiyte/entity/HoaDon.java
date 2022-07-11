package webbanvali.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hoa_don")
public class HoaDon implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "ho_ten_khach_hang")
	private String hoTenKhachHang;
	@Column(name = "so_dien_thoai_giao_hang")
	private String soDienThoaiGiaoHang;
	@Column(name = "dia_chi_giao_hang")
	private String diaChiGiaoHang;
	private String email;
	@Column(name = "ghi_chu")
	private String ghiChu;
	@Column(name = "thoi_gian_dat")
	private LocalDateTime thoiGianDat;
	@Column(name = "trang_thai_don_hang")
	private String trangThaiDonHang;

	@ManyToOne
	@JoinColumn(name = "nguoi_dung_id", referencedColumnName = "id",
				foreignKey = @ForeignKey(name = "fk_hoadon_nguoidung")
			   )
	private NguoiDung nguoiDung;

	@OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL)
	private List<ChiTietHoaDon> chiTietHoaDons;
	
	public double tinhThanhTien() {
		
		double tongTien = 0;
		
		for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDons) {
		
			tongTien += chiTietHoaDon.tinhThanhTien();
		}
		
		return tongTien;
		
	}
}
