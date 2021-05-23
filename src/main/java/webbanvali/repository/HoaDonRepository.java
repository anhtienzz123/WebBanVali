package webbanvali.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import webbanvali.entity.HoaDon;

public interface HoaDonRepository extends JpaRepository<HoaDon, String> {

	@Query("select hd from HoaDon hd where hd.id like %?1% and  hd.soDienThoaiGiaoHang like %?2% and hd.trangThaiDonHang like %?3%  order by TIME(hd.thoiGianDat) DESC")
	List<HoaDon> findAllByIdAndSoDienThoaiGiaoHangAndTrangThaiDonHang(String id, String soDienThoai, String trangThai,
			Pageable pageable);

	@Modifying
	@Query("update HoaDon hd set hd.trangThaiDonHang = ?2 where hd.id = ?1")
	int capNhatTrangThai(String id, String trangThai);
	
	
	@Query(value = "select count(*) from hoa_don\r\n"
			+ "where day(thoi_gian_dat) = day(now()) and month(thoi_gian_dat) = month(now()) and year(thoi_gian_dat) = year(now())\r\n"
			+ "and trang_thai_don_hang = ?1", nativeQuery = true)
	int countByTrangThaiDonHang(String trangThaiDonHang);
}
