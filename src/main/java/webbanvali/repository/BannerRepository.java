package webbanvali.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import webbanvali.entity.Banner;

public interface BannerRepository extends JpaRepository<Banner, Integer> {
	
	boolean existsByTenAnh(String tenAnh);

	List<Banner> findByTenAnhContainingIgnoreCase(String tenAnh);

	boolean existsByTenAnhAndIdNot(String tenAnh, Integer id);

	Banner findByTenAnh(String tenAnh);
	
}
