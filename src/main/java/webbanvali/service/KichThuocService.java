package webbanvali.service;

import java.util.List;

import webbanvali.dto.KichThuocDTO;

public interface KichThuocService {

	List<KichThuocDTO> getKichThuocs();

	List<KichThuocDTO> getKichThuocsTheoTen(String tenKichThuoc);

	KichThuocDTO getKichThuocTheoId(int id);

	KichThuocDTO themKichThuoc(String tenKichThuoc);
	KichThuocDTO capNhatKichThuoc(Integer id, String tenKichThuoc);

	boolean xoaKichThuocTheoId(int id);
	


}

