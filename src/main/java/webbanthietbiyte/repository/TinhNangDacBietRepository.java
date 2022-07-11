package webbanvali.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import webbanvali.entity.TinhNangDacBiet;

public interface TinhNangDacBietRepository extends JpaRepository<TinhNangDacBiet, Integer> {
	boolean existsByTenTinhNang(String tenTinhNang);

	List<TinhNangDacBiet> findByTenTinhNangContainingIgnoreCase(String tenTinhNang);

	boolean existsByTenTinhNangAndIdNot(String tenTinhNang, Integer id);

	
	TinhNangDacBiet findByTenTinhNang(String tenTinhNang);
}
