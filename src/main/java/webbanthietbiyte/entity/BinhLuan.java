package webbanvali.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@Table(name = "binh_luan")
@IdClass(BinhLuan_PK.class)
public class BinhLuan implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "nguoi_dung_id", referencedColumnName = "id", foreignKey = @ForeignKey(name="fk_binhluan_nguoidung"))
	private NguoiDung nguoiDung;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "vali_id" , referencedColumnName = "id", foreignKey = @ForeignKey(name="fk_binhluan_vali"))
	private Vali vali;
	
	@Lob
	@Column(name = "noi_dung")
	private String noiDung;
	
	@Column(name = "danh_gia")
	private int danhGia;
	@Column(name = "thoi_gian_binh_luan")
	private LocalDateTime thoiGianBinhLuan;
	
	
}
