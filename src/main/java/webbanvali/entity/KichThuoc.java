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
@Table(name = "kich_thuoc")
public class KichThuoc implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "ten_kich_thuoc")
	private String tenKichThuoc;
	private String code;

	public KichThuoc(String tenKichThuoc, String code) {
		super();
		this.tenKichThuoc = tenKichThuoc;
		this.code = code;
	}

	public KichThuoc(Integer id, String tenKichThuoc, String code) {
		super();
		this.id = id;
		this.tenKichThuoc = tenKichThuoc;
		this.code = code;
	}

	@OneToMany(mappedBy = "kichThuoc")
	private List<BienTheVali> bienTheValis;

}
