package webbanvali.service;

import java.util.List;

import webbanvali.dto.BienTheValiDTO;
import webbanvali.dto.ChiTietValiDTO;

public interface BienTheValiService {

	BienTheValiDTO getTheoId(int valiId, int kichThuocId, int mauSacId);

	List<BienTheValiDTO> getBienTheValisTheoNhieuDieuKien(String codeNhomVali, double giaDau, double giaCuoi,
			List<String> codeThuongHieus, List<String> codeChatLieus, List<String> codeKichThuocs,
			List<String> codeMauSacs, List<String> codeTinhNangDacBiets);
	
	ChiTietValiDTO getChiTietValiDTO(String valiSlug, String kichThuocCode, String mauSacCode );
	
	List<BienTheValiDTO> getValisBanChay(int limit);
	List<BienTheValiDTO> getValisNoiBat(int limit);
	List<BienTheValiDTO> getValisKhuyenMai(int limit);
	
}
