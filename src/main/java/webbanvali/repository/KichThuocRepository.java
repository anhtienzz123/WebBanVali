package webbanvali.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import webbanvali.entity.KichThuoc;



public interface KichThuocRepository extends JpaRepository<KichThuoc, Integer> {

	boolean existsByTenKichThuoc(String tenKichThuoc);

	List<KichThuoc> findByTenKichThuocContainingIgnoreCase(String tenKichThuoc);
	KichThuoc findByTenKichThuoc(String tenKichThuoc);
	// nếu có thằng id khác trùng màu
	boolean existsByTenKichThuocAndIdNot(String tenKichThuoc, Integer id);

}
