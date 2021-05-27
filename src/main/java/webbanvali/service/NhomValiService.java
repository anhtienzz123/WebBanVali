package webbanvali.service;

import java.util.List;

import webbanvali.dto.NhomValiDTO;
import webbanvali.dto.ThuongHieuDTO;
import webbanvali.dto.TinhNangDacBietDTO;

public interface NhomValiService {
	List<NhomValiDTO> getNhomValis();

	List<NhomValiDTO> getNhomValisTheoTenNhomVali(String tenNhomVali);

	NhomValiDTO getNhomValiTheoId(int id);

	NhomValiDTO capNhatNhomVali(Integer id, String tenNhomVali);

	boolean xoaNhomValiTheoId(int id);

	NhomValiDTO themNhomVali(String tenNhomVali);

}
