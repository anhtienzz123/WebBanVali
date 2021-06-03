package webbanvali.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import webbanvali.entity.Vali;

public interface ValiRepository extends JpaRepository<Vali, Integer>, JpaSpecificationExecutor<Vali> {

	Optional<Vali> findBySlug(String valiSlug);
	Vali findByTenVali(String tenVali);
	
	boolean existsByIdNotAndTenVali(Integer id, String tenVali);
	
	List<Vali> findByTenValiContainingAndChatLieuTenChatLieuContainingAndThuongHieuTenThuongHieuContainingAndNhomValiTenNhomValiContaining(
			String tenVali, String chatLieu, String thuongHieu, String nhomVali);

}
