package webbanvali.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "thuong_hieu")
public class ThuongHieu implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "ten_thuong_hieu")
	private String tenThuongHieu;
	private String code;

	@OneToMany(mappedBy = "thuongHieu")
	private List<Vali> valis;

	public ThuongHieu(String tenThuongHieu, String code) {
		super();
		this.tenThuongHieu = tenThuongHieu;
		this.code = code;
	}

	public ThuongHieu(Integer id, String tenThuongHieu, String code) {
		super();
		this.id = id;
		this.tenThuongHieu = tenThuongHieu;
		this.code = code;
	}
}
