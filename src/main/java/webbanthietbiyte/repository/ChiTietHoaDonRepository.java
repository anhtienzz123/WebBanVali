package webbanvali.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import webbanvali.entity.BinhLuan;
import webbanvali.entity.ChiTietHoaDon;
import webbanvali.entity.HoaDon;
import webbanvali.entity.QuanHuyen;

public interface ChiTietHoaDonRepository extends JpaRepository<ChiTietHoaDon, String> {

	

//	@Query("select hd from ChiTietHoaDon hd where hd.hoaDonId like %?1%  order by TIME(hd.soLuong) DESC")
//	List<ChiTietHoaDon> findAllById( String nguoiDungId);
	
	// lấy tất cả comment theo email cua nguoi dung
		List<ChiTietHoaDon> findAllByHoaDonId(String email);

		

}
