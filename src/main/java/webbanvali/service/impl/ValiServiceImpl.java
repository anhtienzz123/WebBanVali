package webbanvali.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbanvali.converter.ValiConverter;
import webbanvali.dto.ValiDTO;
import webbanvali.entity.Vali;
import webbanvali.repository.ValiRepository;
import webbanvali.service.ValiService;

@Service
public class ValiServiceImpl implements ValiService{

	@Autowired
	private ValiRepository valiRepository;
	
	@Autowired
	private ValiConverter valiConverter;
	
	@Override
	public ValiDTO getValiTheoMaVali(String maVali) {
		
		Vali vali = valiRepository.findById(maVali).get();
		
		if(vali == null)
			return null;
		
		ValiDTO sachDTO = valiConverter.toDTO(vali);
		
		return sachDTO;
	}

	
}
