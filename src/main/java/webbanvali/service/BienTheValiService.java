package webbanvali.service;

import java.util.List;

import webbanvali.dto.BienTheValiDTO;

public interface BienTheValiService {

	BienTheValiDTO getTheoId(int valiId, int kichThuocId, int mauSacId);

	List<BienTheValiDTO> getBienTheValisTheoNhieuDieuKien(String codeNhomVali, double giaDau, double giaCuoi,
			List<String> codeThuongHieus, List<String> codeChatLieus, List<String> codeKichThuocs,
			List<String> codeMauSacs, List<String> codeTinhNangDacBiets);
	
	
}
