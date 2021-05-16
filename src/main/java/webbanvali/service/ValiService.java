package webbanvali.service;

import java.util.List;
import java.util.Map;

import webbanvali.dto.KeyValueDTO;
import webbanvali.dto.ValiDTO;

public interface ValiService {

	ValiDTO getValiTheoMaVali(Integer maVali);
	
	Map<String, List<KeyValueDTO> > getTieuChiTimKiem();
}
