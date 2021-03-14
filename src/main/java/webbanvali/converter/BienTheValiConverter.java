package webbanvali.converter;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webbanvali.dto.BienTheValiDTO;
import webbanvali.dto.KichThuocDTO;
import webbanvali.dto.MauSacDTO;
import webbanvali.dto.ValiDTO;
import webbanvali.entity.BienTheVali;

@Component
public class BienTheValiConverter {

	@Autowired
	private ValiConverter valiConverter;

	public BienTheValiDTO toDTO(BienTheVali bienTheVali) {

		double trongLuong = bienTheVali.getTrongLuong();
		String moTaKichThuoc = bienTheVali.getMoTaKichThuoc();
		double theTich = bienTheVali.getTheTich();
		double gia = bienTheVali.getGia();
		double khuyenMai = bienTheVali.getKhuyenMai();
		long soLuong = bienTheVali.getSoLuong();
		Set<String> tenAnhs = new HashSet<String>(bienTheVali.getTenAnhs());

		ValiDTO valiDTO = Optional.ofNullable(bienTheVali.getVali()).map(s -> valiConverter.toDTO(s)).orElse(null);
		KichThuocDTO kichThuocDTO = Optional.ofNullable(bienTheVali.getKichThuoc()).map(s -> {
			return new KichThuocDTO(s.getId(), s.getTenKichThuoc(), s.getCode());
		}).orElse(null);
		MauSacDTO mauSacDTO = Optional.ofNullable(bienTheVali.getMauSac()).map(s -> {
			return new MauSacDTO(s.getId(), s.getTenMau(), s.getCode());
		}).orElse(null);
		;

		return new BienTheValiDTO(valiDTO, kichThuocDTO, mauSacDTO, trongLuong, moTaKichThuoc, theTich, gia, khuyenMai,
				soLuong, tenAnhs);
	}
}
