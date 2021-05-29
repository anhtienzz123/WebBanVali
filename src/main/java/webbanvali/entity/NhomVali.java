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
@Table(name = "nhom_vali")
public class NhomVali implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "ten_nhom_vali")
	private String tenNhomVali;
	private String code;

	@OneToMany(mappedBy = "nhomVali")
	private List<Vali> valis;

	public NhomVali(Integer id, String tenNhomVali, String code) {
		super();
		this.id = id;
		this.tenNhomVali = tenNhomVali;
		this.code = code;
	}

	public NhomVali(String tenNhomVali, String code) {
		super();
		this.tenNhomVali = tenNhomVali;
		this.code = code;
	}

	public NhomVali(String tenNhomVali) {
		super();
		this.tenNhomVali = tenNhomVali;
	}

}
