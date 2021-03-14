package webbanvali.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbanvali.converter.BienTheValiConverter;
import webbanvali.dto.BienTheValiDTO;
import webbanvali.entity.BienTheVali;
import webbanvali.entity.BienTheVali_PK;
import webbanvali.repository.BienTheValiRepository;
import webbanvali.service.BienTheValiService;

@Service
public class BienTheValiServiceImpl implements BienTheValiService{

	@Autowired
	private BienTheValiRepository bienTheValiRepository;
	
	@Autowired
	private BienTheValiConverter bienTheValiConverter;
	
	@Override
	public BienTheValiDTO getTheoId(int valiId, int kichThuocId, int mauSacId) {
		
		Optional<BienTheVali> tempt = bienTheValiRepository.findById(new BienTheVali_PK(valiId, kichThuocId, mauSacId));
		
		if(tempt.isPresent()) {
			return bienTheValiConverter.toDTO(tempt.get());
		}
		
		return null;
	}

	
}
