package webbanvali.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import webbanvali.converter.BienTheValiConverter;
import webbanvali.dto.BienTheValiDTO;
import webbanvali.entity.BienTheVali;
import webbanvali.entity.BienTheVali_PK;
import webbanvali.repository.BienTheValiRepository;
import webbanvali.service.BienTheValiService;
import webbanvali.utils.BienTheValiSpecification;

@Service
public class BienTheValiServiceImpl implements BienTheValiService {

	@Autowired
	private BienTheValiRepository bienTheValiRepository;

	@Autowired
	private BienTheValiConverter bienTheValiConverter;

	@Override
	public BienTheValiDTO getTheoId(int valiId, int kichThuocId, int mauSacId) {

		Optional<BienTheVali> tempt = bienTheValiRepository.findById(new BienTheVali_PK(valiId, kichThuocId, mauSacId));

		if (tempt.isPresent()) {
			return bienTheValiConverter.toDTO(tempt.get());
		}

		return null;
	}

	@Override
	public List<BienTheValiDTO> getBienTheValisTheoNhieuDieuKien(String codeNhomVali, double giaDau, double giaCuoi,
			List<String> codeThuongHieus, List<String> codeChatLieus, List<String> codeKichThuocs,
			List<String> codeMauSacs, List<String> codeTinhNangDacBiets) {

		Specification<BienTheVali> dieuKien = Specification
				.where(BienTheValiSpecification.timKiemTheoCodeNhomVali(codeNhomVali));

		// nếu chọn giá
		if (giaDau != 0)
			dieuKien.and(BienTheValiSpecification.timKiemTheoKhoangGia(giaDau, giaCuoi));

		if (codeThuongHieus != null && codeThuongHieus.size() > 0)
			dieuKien.and(BienTheValiSpecification.timKiemTheoCodeThuongHieus(codeThuongHieus));

		if (codeChatLieus != null && codeChatLieus.size() > 0)
			dieuKien.and(BienTheValiSpecification.timKiemTheoCodeChatLieus(codeChatLieus));

		if (codeKichThuocs != null && codeKichThuocs.size() > 0)
			dieuKien.and(BienTheValiSpecification.timKiemTheoCodeKichThuocs(codeKichThuocs));

		if (codeMauSacs != null && codeMauSacs.size() > 0)
			dieuKien.and(BienTheValiSpecification.timKiemTheoCodeMauSacs(codeMauSacs));

		if (codeTinhNangDacBiets != null && codeTinhNangDacBiets.size() > 0)
			dieuKien.and(BienTheValiSpecification.timKiemTheoCodeTinhNangDacBiets(codeTinhNangDacBiets));
		


		return bienTheValiRepository.findAll(dieuKien).stream().map(s -> bienTheValiConverter.toDTO(s))
				.collect(Collectors.toList());
	}

}
