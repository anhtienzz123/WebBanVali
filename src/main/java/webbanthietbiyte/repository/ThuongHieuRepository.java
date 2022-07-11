package webbanvali.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import webbanvali.entity.ThuongHieu;


public interface NhomThuongHieuRepository extends JpaRepository<ThuongHieu, Integer> {
	boolean existsByTenThuongHieu(String tenThuongHieu);
	List<ThuongHieu> findByTenThuongHieuContainingIgnoreCase(String tenThuongHieu);
	
	// nếu có thằng id khác trùng màu
		boolean existsByTenThuongHieuAndIdNot(String tenThuongHieu, Integer id);
}
