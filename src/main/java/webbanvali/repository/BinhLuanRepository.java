package webbanvali.repository;

<<<<<<< HEAD
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
=======
import org.springframework.data.jpa.repository.JpaRepository;
>>>>>>> 646c00355fe87dadcb7a284943792f8a0db65636
import org.springframework.data.jpa.repository.Query;

import webbanvali.entity.BinhLuan;
import webbanvali.entity.BinhLuan_PK;
<<<<<<< HEAD
import webbanvali.entity.HoaDon;
import webbanvali.entity.Vali;

public interface BinhLuanRepository extends JpaRepository<BinhLuan, BinhLuan_PK> {

	// lấy tất cả comment theo email cua nguoi dung
	List<BinhLuan> findAllByNguoiDungEmail(String email);
	
	// tìm comment theo valiID va nguoiDungId
		

	

}
=======

public interface BinhLuanRepository extends JpaRepository<BinhLuan, BinhLuan_PK>{

	
	@Query(value = "select count(*) from binh_luan\r\n"
			+ "where day(thoi_gian_binh_luan) = day(now())\r\n"
			+ "and month(thoi_gian_binh_luan) = month(now())\r\n"
			+ "and year(thoi_gian_binh_luan) = year(now())", nativeQuery = true)
	int getSoBinhLuanMoiNhat();
	
}
>>>>>>> 646c00355fe87dadcb7a284943792f8a0db65636
