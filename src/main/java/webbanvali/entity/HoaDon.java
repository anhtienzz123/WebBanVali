package webbanvali.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HoaDon implements Serializable{
	 
	
	private static final long serialVersionUID = 1L;

	@Id
	private String maHoaDon;
	
	private String hoTenKhachHang;
	private String diaChiGiaoHang;
	private String soDienThoaiGiaoHang;
	private LocalDate thoiGianDat;
	private String trangThai;
	
	@ManyToOne
	@JoinColumn(name = "maNguoiDung")
	private NguoiDung nguoiDung;
	
	@OneToMany(mappedBy = "hoaDon")
	private List<ChiTietHoaDon> chiTietHoaDons;
	
}
