package webbanvali.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import webbanvali.entity.KichThuoc;

public interface KichThuocRepository  extends JpaRepository<KichThuoc, Integer>{

	KichThuoc findByTenKichThuoc(String tenKichThuoc);
}
