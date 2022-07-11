package webbanvali.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import webbanvali.entity.BienTheVali;
import webbanvali.entity.BienTheVali_PK;

public interface BienTheValiRepository
		extends JpaRepository<BienTheVali, BienTheVali_PK>, JpaSpecificationExecutor<BienTheVali> {

	BienTheVali findByValiSlugAndKichThuocCodeAndMauSacCode(String valiSlug, String kichThuocCode, String mauSacCode);
	
	List<BienTheVali> findByValiTenValiAndKichThuocTenKichThuocAndMauSacTenMau(String tenVali, String tenKichThuoc, String tenMauSac);

	@Query(value = "select  kich_thuoc.ten_kich_thuoc, kich_thuoc.code as kichThuocCode, mau_sac.code as mauSacCode ,bien_the_vali.gia, bien_the_vali.khuyen_mai  from \r\n"
			+ "bien_the_vali inner join kich_thuoc on bien_the_vali.kich_thuoc_id = kich_thuoc.id\r\n"
			+ "inner join mau_sac on bien_the_vali.mau_sac_id  = mau_sac.id\r\n" + "where  vali_id = ?1 \r\n"
			+ "group by kich_thuoc_id", nativeQuery = true)
	List<Object[]> getKichThuocsTheoValiId(Integer valiId);

	@Query(value = "select  mau_sac.ten_mau, mau_sac.code, gia, khuyen_mai   from \r\n" + "bien_the_vali\r\n"
			+ "inner join mau_sac on bien_the_vali.mau_sac_id  = mau_sac.id\r\n"
			+ "where  vali_id = ?1 and kich_thuoc_id = ?2 \r\n" + "group by mau_sac_id", nativeQuery = true)
	List<Object[]> getMauSacsTheoValiIdVaKichThuocId(Integer valiId, Integer kichThuocId);

	@Query(value = "select btv.*\r\n" + "from bien_the_vali as btv\r\n" + "inner join chi_tiet_hoa_don as cthd\r\n"
			+ "on btv.vali_id = cthd.vali_id and btv.kich_thuoc_id = cthd.kich_thuoc_id and btv.mau_sac_id = cthd.mau_sac_id\r\n"
			+ "group by btv.vali_id, btv.kich_thuoc_id, btv.mau_sac_id\r\n" + "order by sum(cthd.so_luong) desc\r\n"
			+ "limit ?1", nativeQuery = true)
	List<BienTheVali> getValisBanChay(int limit);

	List<BienTheVali> findAllByNoiBatTrue(Pageable page);

	List<BienTheVali> findAllByOrderByKhuyenMaiDesc(Pageable page);

	List<BienTheVali> findByValiTenValiContainingAndKichThuocCodeContainingAndMauSacCodeContaining(String tenVali,
			String tenKichThuoc, String tenMau);

	@Query(value = "select   btv.*  from bien_the_vali as btv\r\n"
			+ "			inner join vali as vl on btv.vali_id = vl.id\r\n"
			+ "			where  thuong_hieu_id = ?1  group by btv.vali_id", nativeQuery = true)
	List<BienTheVali> findAllByTenThuongHieu(Integer thuongHieuId);

	@Query(value = "select   btv.*  from bien_the_vali as btv\r\n"
			+ "			inner join vali as vl on btv.vali_id = vl.id\r\n"
			+ "			where  nhom_vali_id = ?1  group by btv.vali_id", nativeQuery = true)
	List<BienTheVali> findAllByNhomVali(Integer nhomValiId);
	
	
	@Query(value = "select concat(vali.ten_vali, ' ' ,kich_thuoc.ten_kich_thuoc, ' ', mau_sac.ten_mau) as ten_vali,\r\n"
			+ "	sum(cthd.so_luong) as so_luong, sum( ( cthd.gia - ( (cthd.gia/100) * cthd.khuyen_mai  ) ) * cthd.so_luong ) as doanh_thu\r\n"
			+ "from bien_the_vali as btv\r\n"
			+ "inner join vali on btv.vali_id = vali.id\r\n"
			+ "inner join kich_thuoc on btv.kich_thuoc_id = kich_thuoc.id\r\n"
			+ "inner join mau_sac on btv.mau_sac_id = mau_sac.id\r\n"
			+ "inner join chi_tiet_hoa_don as cthd\r\n"
			+ "on  btv.vali_id = cthd.vali_id and   btv.kich_thuoc_id = cthd.kich_thuoc_id and btv.mau_sac_id = cthd.mau_sac_id\r\n"
			+ "inner join hoa_don as hd\r\n"
			+ "on cthd.hoa_don_id = hd.id\r\n"
			+ "where month(hd.thoi_gian_dat) = ?1 and year(hd.thoi_gian_dat) = ?2  and hd.trang_thai_don_hang = 'Giao hàng thành công'\r\n"
			+ "group by btv.vali_id, btv.kich_thuoc_id, btv.mau_sac_id\r\n"
			+ "order by so_luong desc, doanh_thu desc", nativeQuery = true)
	List<Object[]> getSoLuongValiTrongThang(int thang, int nam);
	
	@Query(value = "select concat(vali.ten_vali, ' ' ,kich_thuoc.ten_kich_thuoc, ' ', mau_sac.ten_mau) as ten_vali,\r\n"
			+ "	sum(cthd.so_luong) as so_luong, sum( ( cthd.gia - ( (cthd.gia/100) * cthd.khuyen_mai  ) ) * cthd.so_luong ) as doanh_thu\r\n"
			+ "from bien_the_vali as btv\r\n"
			+ "inner join vali on btv.vali_id = vali.id\r\n"
			+ "inner join kich_thuoc on btv.kich_thuoc_id = kich_thuoc.id\r\n"
			+ "inner join mau_sac on btv.mau_sac_id = mau_sac.id\r\n"
			+ "inner join chi_tiet_hoa_don as cthd\r\n"
			+ "on  btv.vali_id = cthd.vali_id and   btv.kich_thuoc_id = cthd.kich_thuoc_id and btv.mau_sac_id = cthd.mau_sac_id\r\n"
			+ "inner join hoa_don as hd\r\n"
			+ "on cthd.hoa_don_id = hd.id\r\n"
			+ "where  year(hd.thoi_gian_dat) = ?1  and hd.trang_thai_don_hang = 'Giao hàng thành công'\r\n"
			+ "group by btv.vali_id, btv.kich_thuoc_id, btv.mau_sac_id\r\n"
			+ "order by so_luong desc, doanh_thu desc", nativeQuery = true)
	List<Object[]> getSoLuongValiTrongNam( int nam);
	
	List<BienTheVali> findByValiTenValiContaining(String tenVali, Pageable pageable);

	boolean existsByValiTenValiContainingAndKichThuocTenKichThuocContainingAndMauSacTenMauContaining(String tenVali, String tenKichThuoc, String tenMau);
}
