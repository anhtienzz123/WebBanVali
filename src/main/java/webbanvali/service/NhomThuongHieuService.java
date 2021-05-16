package webbanvali.service;

import java.util.List;

import webbanvali.dto.ThuongHieuDTO;

public interface NhomThuongHieuService {
	List<ThuongHieuDTO> getThuongHieus();

	List<ThuongHieuDTO> getThuongHieusTheoTenThuongHieu(String tenThuongHieu);

	ThuongHieuDTO getThuongHieuTheoId(int id);

	ThuongHieuDTO themThuongHieu(String tenThuongHieuu);

	ThuongHieuDTO capNhaThuongHieu(Integer id, String tenThuongHieu);

	boolean xoaThuongHieuTheoId(int id);
}
