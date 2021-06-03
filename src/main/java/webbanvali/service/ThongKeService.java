package webbanvali.service;

import java.util.List;

import webbanvali.dto.HoaDonThongKeDTO;
import webbanvali.dto.NguoiDungThongKeDTO;
import webbanvali.dto.ThongKeSoDTO;
import webbanvali.dto.ValiThongKeDTO;

public interface ThongKeService {

	ThongKeSoDTO getThongKeMoiNhat();

	List<HoaDonThongKeDTO> getHoaDonsTheoNgay(int day, int month, int year);

	List<NguoiDungThongKeDTO> getNguoiDungsTheoNgay(int day, int month, int year);

	// Thống kê theo tháng
	int soHoaDonTrongThang(int thang, int nam);

	int soHoaDonThanhCongTrongThang(int thang, int nam);

	String doanhThuTrongThang(int thang, int nam);

	int soNguoiDungTrongThang(int thang, int nam);
	
	List<ValiThongKeDTO> thongKeSoLuongValiTrongThang(int thang, int nam);
	List<HoaDonThongKeDTO> getHoaDonsTheoThang(int thang, int nam);

	// Thống kê theo nam
	int soHoaDonTrongNam(int nam);

	int soHoaDonThanhCongTrongNam(int nam);

	String doanhThuTrongNam(int nam);

	int soNguoiDungTrongNam(int nam);
	
	List<ValiThongKeDTO> thongKeSoLuongValiTrongNam( int nam);
	List<HoaDonThongKeDTO> getHoaDonsTheoNam( int nam);

}
