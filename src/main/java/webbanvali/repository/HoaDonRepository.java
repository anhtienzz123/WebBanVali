package webbanvali.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import webbanvali.entity.HoaDon;

public interface HoaDonRepository extends JpaRepository<HoaDon, String> {

	@Query("select hd from HoaDon hd where hd.id like %?1% and  hd.soDienThoaiGiaoHang like %?2% and hd.trangThaiDonHang like %?3%  order by TIME(hd.thoiGianDat) DESC")
	List<HoaDon> findAllByIdAndSoDienThoaiGiaoHangAndTrangThaiDonHang(String id, String soDienThoai, String trangThaiO,
			Pageable pageable);

	@Modifying
	@Query("update HoaDon hd set hd.trangThaiDonHang = ?2 where hd.id = ?1")
	int capNhatTrangThai(String id, String trangThai);
	
	
}
