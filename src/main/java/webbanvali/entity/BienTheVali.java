package webbanvali.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bien_the_vali")
@IdClass(BienTheVali_PK.class)
public class BienTheVali implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "vali_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_bienthevali_vali"))
	private Vali vali;

	@Id
	@ManyToOne
	@JoinColumn(name = "kich_thuoc_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_bienthevali_kichthuoc"))
	private KichThuoc kichThuoc;

	@Id
	@ManyToOne
	@JoinColumn(name = "mau_sac_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_bienthevali_mausac"))
	private MauSac mauSac;

	@Column(name = "trong_luong")
	private String trongLuong;
	@Column(name = "mo_ta_kich_thuoc")
	private String moTaKichThuoc;
	@Column(name = "the_tich")
	private String theTich;
	private double gia;
	@Column(name = "khuyen_mai")
	private double khuyenMai;
	@Column(name = "so_luong")
	private long soLuong;

	@Column(name = "ten_anh")
	private String tenAnh;

	@Column(name = "noi_bat")
	private boolean noiBat;

	@ElementCollection
	@CollectionTable(name = "anh_vali", joinColumns = { @JoinColumn(name = "vali_id"),
			@JoinColumn(name = "kich_thuoc_id"), @JoinColumn(name = "mau_sac_id") })
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "tenAnh", nullable = false)
	private Set<String> tenAnhs;

	@OneToMany(mappedBy = "bienTheVali")
	private List<ChiTietHoaDon> chiTietHoaDons;

}
