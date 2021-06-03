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

	@Query("select hd from HoaDon hd where hd.id like %?1% and  hd.soDienThoaiGiaoHang like %?2%  order by TIME(hd.thoiGianDat) DESC")
	List<HoaDon> findAllByIdAndSoDienThoaiGiaoHang(String id, String soDienThoai);

	@Query("select hd from HoaDon hd where hd.soDienThoaiGiaoHang like %?1%  order by TIME(hd.thoiGianDat) DESC")
	List<HoaDon> findAllBySoDienThoaiGiaoHang(String soDienThoai);

	@Modifying
	@Query("update HoaDon hd set hd.trangThaiDonHang = ?2 where hd.id = ?1")
	int capNhatTrangThai(String id, String trangThai);

	@Query(value = "select count(*) from hoa_don\r\n"
			+ "where day(thoi_gian_dat) = day(now()) and month(thoi_gian_dat) = month(now()) and year(thoi_gian_dat) = year(now())\r\n"
			+ "and trang_thai_don_hang = ?1", nativeQuery = true)
	int countByTrangThaiDonHang(String trangThaiDonHang);

	@Query(value = "select * \r\n" + "from hoa_don\r\n"
			+ "where day(thoi_gian_dat) = ?1 and month(thoi_gian_dat) = ?2 and year(thoi_gian_dat) = ?3", nativeQuery = true)
	List<HoaDon> getHoaDonTheoNgay(int ngay, int thang, int nam);

	// Thống kê tháng

	// lấy tất cả đơn hàng
	@Query(value = "select count(*)\r\n" + "from hoa_don\r\n"
			+ "where month(thoi_gian_dat) = ?1 and year(thoi_gian_dat) = ?2", nativeQuery = true)
	Integer soHoaDonTrongThang(int month, int year);

	// lấy tất cả đơn hàng thành công trong tháng
	@Query(value = "select count(*)\r\n" + "from hoa_don\r\n"
			+ "where month(thoi_gian_dat) = ?1 and year(thoi_gian_dat) = ?2\r\n"
			+ "and trang_thai_don_hang = 'Giao hàng thành công'", nativeQuery = true)
	Integer soHoaDonThanhCongTrongThang(int month, int year);

	// lấy doanh thu trong tháng
	@Query(value = "select sum( ( cthd.gia - (  (cthd.gia/100) * cthd.khuyen_mai  ) ) * cthd.so_luong )  as doanh_thu\r\n"
			+ "from hoa_don as hd\r\n" + "inner join chi_tiet_hoa_don as cthd on hd.id = cthd.hoa_don_id\r\n"
			+ "where month(hd.thoi_gian_dat) = ?1 and year(hd.thoi_gian_dat) = ?2\r\n"
			+ "and hd.trang_thai_don_hang = 'Giao hàng thành công' ", nativeQuery = true)
	Double getDoanhThuTrongThang(int thang, int nam);
	
	@Query(value = "select * \r\n" + "from hoa_don\r\n"
			+ "where  month(thoi_gian_dat) = ?1 and year(thoi_gian_dat) = ?2", nativeQuery = true)
	List<HoaDon> getHoaDonTheoThang(int thang, int nam);

	
	// = Thống kê năm =
	// lấy tất cả đơn hàng
	@Query(value = "select count(*)\r\n" + "from hoa_don\r\n"
			+ "where  year(thoi_gian_dat) = ?1", nativeQuery = true)
	Integer soHoaDonTrongNam(int nam);

	// lấy tất cả đơn hàng thành công trong tháng
	@Query(value = "select count(*)\r\n" + "from hoa_don\r\n"
			+ "where  year(thoi_gian_dat) = ?1\r\n"
			+ "and trang_thai_don_hang = 'Giao hàng thành công'", nativeQuery = true)
	Integer soHoaDonThanhCongTrongNam( int nam);

	// lấy doanh thu trong năm
	@Query(value = "select sum( ( cthd.gia - (  (cthd.gia/100) * cthd.khuyen_mai  ) ) * cthd.so_luong )  as doanh_thu\r\n"
			+ "from hoa_don as hd\r\n" + "inner join chi_tiet_hoa_don as cthd on hd.id = cthd.hoa_don_id\r\n"
			+ "where year(hd.thoi_gian_dat) = ?1\r\n"
			+ "and hd.trang_thai_don_hang = 'Giao hàng thành công' ", nativeQuery = true)
	Double getDoanhThuTrongNam( int nam);
	
	@Query(value = "select * \r\n" + "from hoa_don\r\n"
			+ "where year(thoi_gian_dat) = ?1", nativeQuery = true)
	List<HoaDon> getHoaDonTheoNam( int nam);

}
