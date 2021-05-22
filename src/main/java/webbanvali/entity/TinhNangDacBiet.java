package webbanvali.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tinh_nang_dac_biet")
public class TinhNangDacBiet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "ten_tinh_nang")
	private String tenTinhNang;
	private String code;

	public TinhNangDacBiet(String tenTinhNang, String code) {
		super();
		this.tenTinhNang = tenTinhNang;
		this.code = code;
	}

	public TinhNangDacBiet(Integer id, String tenTinhNang, String code) {
		super();
		this.id = id;
		this.tenTinhNang = tenTinhNang;
		this.code = code;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "vali_tinh_nang", // Tạo ra một join Table
			joinColumns = @JoinColumn(name = "tinh_nang_id"), // Cột id class hiện tại
			inverseJoinColumns = @JoinColumn(name = "vali_id") // Cột id của class dưới
	)
	private List<Vali> valis;

}
