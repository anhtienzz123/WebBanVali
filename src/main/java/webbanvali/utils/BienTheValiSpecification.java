package webbanvali.utils;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import webbanvali.entity.BienTheVali;
import webbanvali.entity.ChatLieu;
import webbanvali.entity.KichThuoc;
import webbanvali.entity.MauSac;
import webbanvali.entity.NhomVali;
import webbanvali.entity.ThuongHieu;
import webbanvali.entity.TinhNangDacBiet;
import webbanvali.entity.Vali;

public final class BienTheValiSpecification {

	public static Specification<BienTheVali> timKiemTheoCodeNhomVali(String codeNhomVali) {

		return new Specification<BienTheVali>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<BienTheVali> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Join<BienTheVali, Vali> valiJoin = root.join("vali");
				Join<Vali, NhomVali> nhomValiJoin = valiJoin.join("nhomVali");

				// return cb.equal(nhomValiJoin.get(NhomVali_.code), nhomValiJoin);
				return cb.equal(nhomValiJoin.get("code"), codeNhomVali);

			}

		};
	}

	public static Specification<BienTheVali> timKiemTheoKhoangGia(double giaDau, double giaCuoi) {

		return new Specification<BienTheVali>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<BienTheVali> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.between(root.get("gia"), giaDau, giaCuoi);
			}

		};
	}

	public static Specification<BienTheVali> timKiemTheoCodeThuongHieus(List<String> codeThuongHieus) {

		return new Specification<BienTheVali>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<BienTheVali> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				Join<BienTheVali, Vali> valiJoin = root.join("vali");
				Join<Vali, ThuongHieu> thuongHieuJoin = valiJoin.join("thuongHieu");

				return thuongHieuJoin.get("code").in(codeThuongHieus);
			}

		};
	}

	public static Specification<BienTheVali> timKiemTheoCodeChatLieus(List<String> codeChatLieus) {

		return new Specification<BienTheVali>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<BienTheVali> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				Join<BienTheVali, Vali> valiJoin = root.join("vali");
				Join<Vali, ChatLieu> chatLieuJoin = valiJoin.join("chatLieu");

				return chatLieuJoin.get("code").in(codeChatLieus);
			}

		};
	}

	public static Specification<BienTheVali> timKiemTheoCodeKichThuocs(List<String> codeKichThuocs) {

		return new Specification<BienTheVali>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<BienTheVali> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				Join<BienTheVali, KichThuoc> kichThuocJoin = root.join("kichThuoc");

				return kichThuocJoin.get("code").in(codeKichThuocs);
			}

		};
	}

	public static Specification<BienTheVali> timKiemTheoCodeMauSacs(List<String> codeMauSacs) {

		return new Specification<BienTheVali>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<BienTheVali> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				Join<BienTheVali, MauSac> mauSacJoin = root.join("mauSac");

				return mauSacJoin.get("code").in(codeMauSacs);
			}

		};
	}

	public static Specification<BienTheVali> timKiemTheoCodeTinhNangDacBiets(List<String> codeTinhNangDacBiets) {

		return new Specification<BienTheVali>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<BienTheVali> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				Join<BienTheVali, Vali> valiJoin = root.join("vali");
				Join<Vali, TinhNangDacBiet> tinhNangDacBietJoin = valiJoin.join("tinhNangDacBiets");

				return tinhNangDacBietJoin.get("code").in(codeTinhNangDacBiets);
			}

		};
	}

}
