package webbanvali.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(BinhLuan_PK.class)
public class BinhLuan implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maNguoiDung")
	private NguoiDung nguoiDung;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maVali")
	private Vali vali;
	
	@Lob
	private String noiDung;
	
	private int danhGia;
	private LocalDate thoiGianBinhLuan;
	
	
}
