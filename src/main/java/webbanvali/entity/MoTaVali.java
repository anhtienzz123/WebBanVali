package webbanvali.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mo_ta_vali")
public class MoTaVali implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ten_mo_ta")
	private String tenMoTa;
	
	@Lob
	@Column(name = "noi_dung")
	private String noiDung;
	@Column(name = "ten_anh")
	private String tenAnh;
	
	@ManyToOne
	@JoinColumn(name = "vali_id", referencedColumnName = "id", foreignKey = @ForeignKey(name="fk_motavali_vali"))
	private Vali vali;
	
}
