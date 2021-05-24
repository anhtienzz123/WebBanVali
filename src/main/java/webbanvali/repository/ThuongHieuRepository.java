package webbanvali.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import webbanvali.entity.ThuongHieu;

public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, Integer> {

	ThuongHieu findByTenThuongHieu(String tenThuongHieu);
}
