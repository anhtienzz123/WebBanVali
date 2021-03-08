package webbanvali.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(ChiTietHoaDon_PK.class)
public class ChiTietHoaDon implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maVali")
	private Vali vali;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maHoaDon")
	private HoaDon hoaDon;
	
	private double gia;
	private int soLuong;
	
}
