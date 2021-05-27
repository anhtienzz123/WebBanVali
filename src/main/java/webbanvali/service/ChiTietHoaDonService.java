package webbanvali.service;

import java.util.List;

import webbanvali.dto.ChiTietHoaDonDTO;


public interface ChiTietHoaDonService {

	

	List<ChiTietHoaDonDTO> getChiTietHoaDonChungs2(String hoaDonId);

	ChiTietHoaDonDTO getChiTietHoaDonTheoMaHoaDon(String maHoaDon);

}
