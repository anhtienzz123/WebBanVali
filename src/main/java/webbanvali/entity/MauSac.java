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
@Table(name = "mau_sac")
public class MauSac implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ten_mau")
	private String tenMau;
	private String code;
	
	@OneToMany(mappedBy = "mauSac")
	private List<BienTheVali> bienTheValis;

	public MauSac(Integer id, String tenMau, String code) {
		super();
		this.id = id;
		this.tenMau = tenMau;
		this.code = code;
	}

	public MauSac(String tenMau, String code) {
		super();
		this.tenMau = tenMau;
		this.code = code;
	}
	
	
}
