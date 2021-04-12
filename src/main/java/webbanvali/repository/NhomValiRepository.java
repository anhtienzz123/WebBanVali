package webbanvali.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import webbanvali.entity.NhomVali;


public interface NhomValiRepository extends JpaRepository<NhomVali, Integer> {
	boolean existsByTenNhomVali(String tenNhomVali);
	List<NhomVali> findByTenNhomValiContainingIgnoreCase(String tenNhomVali);
}
