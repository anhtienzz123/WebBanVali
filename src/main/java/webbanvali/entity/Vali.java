package webbanvali.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vali  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
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
	
	@OneToMany(mappedBy = "vali", fetch = FetchType.EAGER)
	private List<ChiTietVali> chiTietValis;
	
	@OneToMany(mappedBy = "vali")
	private List<BinhLuan> binhLuans;
	
	@ManyToOne
	@JoinColumn(name = "maNhomVali")
	private NhomVali nhomVali;

	
	
}
