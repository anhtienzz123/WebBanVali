package webbanvali.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "banner")
public class Banner implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tenAnh;
	private String tieuDe;
	private String noiDung;

	public Banner(String tenAnh, String tieuDe, String noiDung) {
		super();
		this.tenAnh = tenAnh;
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
	}

}