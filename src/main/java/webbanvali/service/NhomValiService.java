package webbanvali.service;

import java.util.List;


import webbanvali.dto.NhomValiDTO;

public interface NhomValiService {
	List<NhomValiDTO> getNhomValis();

	List<NhomValiDTO> getNhomValisTheoTenNhomVali(String tenNhomVali);

	NhomValiDTO getNhomValiTheoId(int id);

	NhomValiDTO themNhomVali(String tenNhomVali);

	boolean xoaNhomValiTheoId(int id);
}
