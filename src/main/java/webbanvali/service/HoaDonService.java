package webbanvali.service;

import java.util.List;

import webbanvali.dto.HoaDonChungDTO;
import webbanvali.dto.HoaDonDTO;

public interface HoaDonService {

	List<HoaDonChungDTO> getHoaDonChungs(String id, String soDienThoai, String trangThai, int page, int size);

	List<HoaDonChungDTO> getHoaDonChungs1(String id, String soDienThoai);

	List<HoaDonChungDTO> getHoaDonChungs2(String soDienThoai);

	boolean capNhatTrangThai(String id, String trangThai);

	HoaDonDTO getTheoId(String id);

	boolean xoaHoaDon(String id);

}
