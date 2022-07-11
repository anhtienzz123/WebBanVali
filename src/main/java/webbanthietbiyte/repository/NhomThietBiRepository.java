package webbanvali.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import webbanvali.entity.NhomVali;

public interface NhomValiRepository extends JpaRepository<NhomVali, Integer> {
	boolean existsByTenNhomVali(String tenNhomVali);

	List<NhomVali> findByTenNhomValiContainingIgnoreCase(String tenNhomVali);

	// nếu có thằng id khác trùng màu
	boolean existsByTenNhomValiAndIdNot(String tenNhomVali, Integer id);

	NhomVali findByTenNhomVali(String tenNhomVali);
}
