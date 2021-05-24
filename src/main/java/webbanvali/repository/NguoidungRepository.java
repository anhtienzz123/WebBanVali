package webbanvali.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import webbanvali.entity.NguoiDung;
import webbanvali.utils.ROLE;

public interface NguoidungRepository extends JpaRepository<NguoiDung, Integer> {

	NguoiDung findByEmailAndTrangThai(String email, boolean trangThai);

	NguoiDung findByEmail(String email);

	List<NguoiDung> findAllByEmailContainingAndSoDienThoaiContainingAllIgnoreCase(String email, String soDienThoai,
			Pageable pageable);

	int countByNgayTaoAndVaiTro(LocalDate ngayTao, ROLE vaiTro);
}
