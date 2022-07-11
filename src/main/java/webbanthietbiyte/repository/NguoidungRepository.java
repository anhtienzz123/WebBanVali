package webbanvali.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import webbanvali.entity.NguoiDung;
import webbanvali.utils.ROLE;

public interface NguoidungRepository extends JpaRepository<NguoiDung, Integer> {

	NguoiDung findByEmailAndTrangThai(String email, boolean trangThai);

	boolean existsByEmail(String email);
	NguoiDung findByEmail(String email);

	List<NguoiDung> findAllByEmailContainingAndSoDienThoaiContainingAllIgnoreCase(String email, String soDienThoai,
			Pageable pageable);

	int countByNgayTaoAndVaiTro(LocalDate ngayTao, ROLE vaiTro);
	
	@Query(value="select * \r\n"
			+ "from nguoi_dung\r\n"
			+ "where vai_tro = 'ROLE_USER' and day(ngay_tao) = ?1 and month(ngay_tao) = ?2 and year(ngay_tao) = ?3", nativeQuery = true)
	List<NguoiDung> getNguoiDungsTheoNgay(int ngay, int thang, int nam);
	
	@Query(value="select * \r\n"
			+ "from nguoi_dung\r\n"
			+ "where vai_tro = 'ROLE_USER' and month(ngay_tao) = ?1 and year(ngay_tao) = ?2", nativeQuery = true)
	List<NguoiDung> getNguoiDungsTheoThang(int thang, int nam);
	
	@Query(value="select * \r\n"
			+ "from nguoi_dung\r\n"
			+ "where vai_tro = 'ROLE_USER' and year(ngay_tao) = ?1", nativeQuery = true)
	List<NguoiDung> getNguoiDungsTheoNam(int nam);
	
	@Query(value="select count(*) \r\n"
			+ "from nguoi_dung\r\n"
			+ "where vai_tro = 'ROLE_USER' and month(ngay_tao) = ?1 and year(ngay_tao) = ?2", nativeQuery = true)
	Integer soNguoiDungsTheoThang(int thang, int nam);
	
	@Query(value="select count(*) \r\n"
			+ "from nguoi_dung\r\n"
			+ "where vai_tro = 'ROLE_USER' and year(ngay_tao) = ?1", nativeQuery = true)
	Integer soNguoiDungsTheoNam(int nam);
	
	
}
