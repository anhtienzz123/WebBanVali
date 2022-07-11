package webbanvali.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import webbanvali.entity.MauSac;

public interface MauSacRepository extends JpaRepository<MauSac, Integer> {

	boolean existsByTenMau(String tenMau);
	
	List<MauSac> findByTenMauContainingIgnoreCase(String tenMau);
	
	// nếu có thằng id khác trùng màu
	boolean existsByTenMauAndIdNot(String tenMau, Integer id);
	
	MauSac findByTenMau(String tenMau);
	
}
