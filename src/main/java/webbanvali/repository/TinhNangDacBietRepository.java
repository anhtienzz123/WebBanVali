package webbanvali.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import webbanvali.entity.TinhNangDacBiet;

public interface TinhNangDacBietRepository extends JpaRepository<TinhNangDacBiet, Integer>{

	
	TinhNangDacBiet findByTenTinhNang(String tenTinhNang);
}
