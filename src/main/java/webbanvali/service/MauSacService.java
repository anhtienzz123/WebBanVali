package webbanvali.service;

import java.util.List;

import webbanvali.dto.MauSacDTO;

public interface MauSacService {

	List<MauSacDTO> getMauSacs();

	List<MauSacDTO> getMauSacsTheoTenMau(String tenMau);

	MauSacDTO getMauSacTheoId(int id);

	MauSacDTO themMauSac(String tenMauSac);
	MauSacDTO capNhatMauSac(Integer id, String tenMauSac);

	boolean xoaMauSacTheoId(int id);
	


}
