package webbanvali.service;

import java.util.List;

import webbanvali.dto.TinhNangDacBietDTO;

public interface TinhNangDacBietService {

	List<TinhNangDacBietDTO> getTinhNangDacBiets();

	List<TinhNangDacBietDTO> getTinhNangDacBietsTheoTenTinhNang(String tenTinhNang);

	TinhNangDacBietDTO getTinhNangDacBietTheoId(int id);

	TinhNangDacBietDTO themTinhNangDacBiet(String tenTinhNang);

	TinhNangDacBietDTO capNhatTinhNangDacBiet(Integer id, String tenTinhNang);

	boolean xoaTinhNangDacBietTheoId(int id);

}
