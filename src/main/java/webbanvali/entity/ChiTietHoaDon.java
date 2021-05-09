package webbanvali.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chi_tiet_hoa_don")
@IdClass(ChiTietHoaDon_PK.class)
public class ChiTietHoaDon implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "vali_id", referencedColumnName = "vali_id"),
			@JoinColumn(name = "kich_thuoc_id", referencedColumnName = "kich_thuoc_id"),
			@JoinColumn(name = "mau_sac_id", referencedColumnName = "mau_sac_id") })
	private BienTheVali bienTheVali;

	@Id
	@ManyToOne
	@JoinColumn(name = "hoa_don_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_cthd_hoadon"))
	private HoaDon hoaDon;

	private double gia;
	@Column(name = "khuyen_mai")
	private double khuyenMai;
	@Column(name = "so_luong")
	private int soLuong;

	public double tinhGia() {

		return gia - (gia / 100)*khuyenMai;
	}

	public double tinhThanhTien() {

		return tinhGia() * soLuong;
	}

}
