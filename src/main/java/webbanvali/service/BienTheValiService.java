package webbanvali.service;

import webbanvali.dto.BienTheValiDTO;

public interface BienTheValiService {
	
	BienTheValiDTO getTheoId(int valiId, int kichThuocId, int mauSacId);
}
