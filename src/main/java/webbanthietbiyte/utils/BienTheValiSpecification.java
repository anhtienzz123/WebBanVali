package webbanvali.utils;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;

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

	public static Specification<BienTheVali> hasCodeNhomValis(List<String> codeNhomValis) {

		return (root, query, cb) -> {

			if (codeNhomValis == null || codeNhomValis.size() == 0)
				return null;

			Join<BienTheVali, Vali> valiJoin = root.join("vali");
			Join<Vali, NhomVali> nhomValiJoin = valiJoin.join("nhomVali");

			return nhomValiJoin.get("code").in(codeNhomValis);
		};

	}

	public static Specification<BienTheVali> hasKhoangGias(List<String> gias) {

		return (root, query, cb) -> {

			if (gias == null || gias.size() == 0)
				return null;

			List<Predicate> predicates = new ArrayList<>();

			for (String s : gias) {

				if (s.equals(ChuoiConstant.KEY_DUOI_1_TRIEU)) {
					predicates.add(cb.lessThanOrEqualTo(root.get("gia"), 1000000));
				}

				if (s.equals(ChuoiConstant.KEY_TU_1_2_TRIEU)) {
					predicates.add(cb.between(root.get("gia"), 1000000, 2000000));
				}

				if (s.equals(ChuoiConstant.KEY_TU_2_3_TRIEU)) {
					predicates.add((cb.between(root.get("gia"), 2000000, 3000000)));
				}

				if (s.equals(ChuoiConstant.KEY_TREN_3_TRIEU)) {
					predicates.add(cb.greaterThanOrEqualTo(root.get("gia"), 3000000));

				}
			}

			Predicate[] predicateResults = new Predicate[predicates.size()];
			predicates.toArray(predicateResults);

			return cb.or(predicateResults);

		};
	}

	public static Specification<BienTheVali> hasCodeThuongHieus(List<String> codeThuongHieus) {

		return (root, query, cb) -> {

			if (codeThuongHieus == null || codeThuongHieus.size() == 0)
				return null;

			Join<BienTheVali, Vali> valiJoin = root.join("vali");
			Join<Vali, ThuongHieu> thuongHieuJoin = valiJoin.join("thuongHieu");

			return thuongHieuJoin.get("code").in(codeThuongHieus);
		};
	}

	public static Specification<BienTheVali> hasCodeChatLieus(List<String> codeChatLieus) {

		return (root, query, cb) -> {

			if (codeChatLieus == null || codeChatLieus.size() == 0)
				return null;

			Join<BienTheVali, Vali> valiJoin = root.join("vali");
			Join<Vali, ChatLieu> chatLieuJoin = valiJoin.join("chatLieu");

			return chatLieuJoin.get("code").in(codeChatLieus);
		};
	}

	public static Specification<BienTheVali> hasCodeKichThuocs(List<String> codeKichThuocs) {

		return (root, query, cb) -> {

			if (codeKichThuocs == null || codeKichThuocs.size() == 0)
				return null;

			Join<BienTheVali, KichThuoc> kichThuocJoin = root.join("kichThuoc");

			return kichThuocJoin.get("code").in(codeKichThuocs);
		};
	}

	public static Specification<BienTheVali> hasCodeMauSacs(List<String> codeMauSacs) {

		return (root, query, cb) -> {

			if (codeMauSacs == null || codeMauSacs.size() == 0)
				return null;

			Join<BienTheVali, MauSac> mauSacJoin = root.join("mauSac");

			return mauSacJoin.get("code").in(codeMauSacs);
		};
	}

	public static Specification<BienTheVali> hasCodeTinhNangDacBiets(List<String> codeTinhNangDacBiets) {

		return (root, query, cb) -> {

			if (codeTinhNangDacBiets == null || codeTinhNangDacBiets.size() == 0)
				return null;

			Join<BienTheVali, Vali> valiJoin = root.join("vali");
			Join<Vali, TinhNangDacBiet> tinhNangDacBietJoin = valiJoin.join("tinhNangDacBiets");

			return tinhNangDacBietJoin.get("code").in(codeTinhNangDacBiets);
		};
	}

}
