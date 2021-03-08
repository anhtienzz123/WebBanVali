package webbanvali.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import webbanvali.entity.NguoiDung;

public interface NguoidungRepository extends JpaRepository<NguoiDung, String> {

	NguoiDung findByEmailAndTrangThai(String email, boolean trangThai);

	NguoiDung findByEmail(String email);

	List<NguoiDung> findAllByEmailContainingAndSoDienThoaiContainingAllIgnoreCase(String email, String soDienThoai,
			Pageable pageable);
}
