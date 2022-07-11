package webbanvali.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "vali")
public class Vali  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ten_vali")
	private String tenVali;
	private String slug;
	@Column(name = "banh_Xe")
	private String banhXe;
	@Column(name = "day_keo")
	private String dayKeo;
	private String khoa;
	@Column(name = "thoi_gian_bao_hanh")
	private String thoiGianBaoHanh;
	private String moTa;
	
	
//	@OneToMany(mappedBy = "vali", fetch = FetchType.EAGER)
//	private List<MoTaVali> moTaValis;
	
	@ManyToMany(mappedBy = "valis")
	private List<TinhNangDacBiet> tinhNangDacBiets;
	
	@OneToMany(mappedBy = "vali")
	private List<BinhLuan> binhLuans;
	
	@ManyToOne
	@JoinColumn(name = "chat_lieu_id", referencedColumnName = "id", foreignKey = @ForeignKey(name="fk_vali_chatlieu"))
	private ChatLieu chatLieu;
	
	@ManyToOne
	@JoinColumn(name = "thuong_hieu_id" , referencedColumnName = "id", foreignKey = @ForeignKey(name="fk_vali_thuonghieu"))
	private ThuongHieu thuongHieu;
	
	@ManyToOne
	@JoinColumn(name = "nhom_vali_id" , referencedColumnName = "id", foreignKey = @ForeignKey(name="fk_vali_nhomvali"))
	private NhomVali nhomVali;
	
	@OneToMany(mappedBy = "vali")
	private List<BienTheVali> bienTheValis;
	
	

}
