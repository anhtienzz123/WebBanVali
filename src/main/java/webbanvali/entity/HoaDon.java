package webbanvali.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import webbanvali.utils.TrangThaiDonHang;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hoa_don")
public class HoaDon implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

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
	private LocalDate thoiGianDat;
	@Column(name = "trang_thai_don_hang")
	@Enumerated(EnumType.STRING)
	private TrangThaiDonHang trangThaiDonHang;

	@ManyToOne
	@JoinColumn(name = "nguoi_dung_id", referencedColumnName = "id",
				foreignKey = @ForeignKey(name = "fk_hoadon_nguoidung")
			   )
	private NguoiDung nguoiDung;

	@OneToMany(mappedBy = "hoaDon")
	private List<ChiTietHoaDon> chiTietHoaDons;
}
