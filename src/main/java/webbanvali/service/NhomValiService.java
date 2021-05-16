package webbanvali.service;

import java.util.List;


import webbanvali.dto.NhomValiDTO;
import webbanvali.dto.ThuongHieuDTO;

public interface NhomValiService {
	List<NhomValiDTO> getNhomValis();

	List<NhomValiDTO> getNhomValisTheoTenNhomVali(String tenNhomVali);

	NhomValiDTO getNhomValiTheoId(int id);

	NhomValiDTO themNhomVali(String tenNhomVali);
	NhomValiDTO capNhatNhomVali(Integer id, String tenNhomVali);

	boolean xoaNhomValiTheoId(int id);
}
