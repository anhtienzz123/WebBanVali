package webbanvali.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import webbanvali.entity.PhuongXa;

public interface PhuongXaRepository extends JpaRepository<PhuongXa, String>{

	List<PhuongXa> findAllByMaQuanHuyen(String maQuanHuyen);
}
