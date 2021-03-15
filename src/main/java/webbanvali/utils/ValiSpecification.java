package webbanvali.utils;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import webbanvali.entity.ThuongHieu;
import webbanvali.entity.TinhNangDacBiet;
import webbanvali.entity.Vali;

public final class ValiSpecification {

	public static Specification<Vali> timKiemTheoNhieuDieuKien(String slugNhomSanPham, double giaTienDau,
			double giaTienCuoi, List<String> codeThuongHieus, List<String> codeChatLieus, List<String> codeKichThuocs,
			List<String> codeMauSacs, List<String> codeTinhNang) {

		return new Specification<Vali>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Vali> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				return cb.equal(root.get("tenVali"), "vali1");
			}

		};
	}

	public static Specification<Vali> timKiemTheoTenVali(String tenVali) {

		return (root, query, cb) -> {
			
			
			return cb.equal(root.get("tenVali"), tenVali);
			
		};
	}
	
	public static Specification<Vali> timKiemTheoSlug(String slug) {

		return new Specification<Vali>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Vali> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				
				return cb.equal(root.get("slug"), slug);
			}
		};
	}
	
	public static Specification<Vali> timKiemTheoThuongHieu(List<String> tenThuongHieus) {
		
		return (root, query, cb) -> {
			
			Join<Vali, ThuongHieu> thuongHieus = root.join("thuongHieu");
			
			return thuongHieus.get("tenThuongHieu").in(tenThuongHieus);
		};
	}
	
	public static Specification<Vali> timKiemTheoTenTinhNang(List<String> tenTinhNangs){
		
		return new Specification<Vali>() {

			private static final long serialVersionUID = 1L;
			@Override
			public Predicate toPredicate(Root<Vali> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				
				Join<Vali, TinhNangDacBiet> tinhNangJoin = root.join("tinhNangDacBiets");
				
				query.distinct(true);
				
				
				return tinhNangJoin.get("tenTinhNang").in(tenTinhNangs);
			}
			
		};
	}
	
}
