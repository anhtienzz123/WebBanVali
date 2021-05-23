package webbanvali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import webbanvali.entity.BinhLuan;
import webbanvali.entity.BinhLuan_PK;

public interface BinhLuanRepository extends JpaRepository<BinhLuan, BinhLuan_PK>{

	
	@Query(value = "select count(*) from binh_luan\r\n"
			+ "where day(thoi_gian_binh_luan) = day(now())\r\n"
			+ "and month(thoi_gian_binh_luan) = month(now())\r\n"
			+ "and year(thoi_gian_binh_luan) = year(now())", nativeQuery = true)
	int getSoBinhLuanMoiNhat();
	
}
