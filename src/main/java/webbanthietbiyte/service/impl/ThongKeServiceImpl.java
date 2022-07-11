package webbanvali.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbanvali.converter.ThongKeConverter;
import webbanvali.dto.HoaDonThongKeDTO;
import webbanvali.dto.NguoiDungThongKeDTO;
import webbanvali.dto.ThongKeSoDTO;
import webbanvali.dto.ValiThongKeDTO;
import webbanvali.repository.BienTheValiRepository;
import webbanvali.repository.BinhLuanRepository;
import webbanvali.repository.HoaDonRepository;
import webbanvali.repository.NguoidungRepository;
import webbanvali.service.ThongKeService;
import webbanvali.utils.ROLE;
import webbanvali.utils.TrangThaiDonHang;
import webbanvali.utils.XuLyTien;

@Service
@Transactional
public class ThongKeServiceImpl implements ThongKeService {

	@Autowired
	private NguoidungRepository nguoiDungRepository;

	@Autowired
	private HoaDonRepository hoaDonRepository;

	@Autowired
	private BinhLuanRepository binhLuanRepository;
	@Autowired
	private BienTheValiRepository bienTheValiRepository;

	@Autowired
	private ThongKeConverter thongKeConverter;

	@Override
	public ThongKeSoDTO getThongKeMoiNhat() {

		ThongKeSoDTO thongKeSoDTO = new ThongKeSoDTO();
		thongKeSoDTO.setSoHoaDonMoi(hoaDonRepository.countByTrangThaiDonHang(TrangThaiDonHang.DANG_CHO_XU_LY.getTen()));
		thongKeSoDTO
				.setSoHoaDonThanhCong(hoaDonRepository.countByTrangThaiDonHang(TrangThaiDonHang.THANH_CONG.getTen()));
		thongKeSoDTO.setSoNguoiDungMoi(nguoiDungRepository.countByNgayTaoAndVaiTro(LocalDate.now(), ROLE.ROLE_USER));
		thongKeSoDTO.setSoBinhLuanMoi(binhLuanRepository.getSoBinhLuanMoiNhat());

		return thongKeSoDTO;
	}

	@Override
	public List<HoaDonThongKeDTO> getHoaDonsTheoNgay(int day, int month, int year) {

		return hoaDonRepository.getHoaDonTheoNgay(day, month, year).stream()
				.map(hd -> thongKeConverter.toHoaDonThongKeDTO(hd)).collect(Collectors.toList());
	}

	@Override
	public List<NguoiDungThongKeDTO> getNguoiDungsTheoNgay(int day, int month, int year) {

		return nguoiDungRepository.getNguoiDungsTheoNgay(day, month, year).stream()
				.map(nd -> thongKeConverter.toNguoiDungThongKeDTO(nd)).collect(Collectors.toList());
	}

	@Override
	public int soHoaDonTrongThang(int thang, int nam) {

		return hoaDonRepository.soHoaDonTrongThang(thang, nam);
	}

	@Override
	public int soHoaDonThanhCongTrongThang(int thang, int nam) {

		return hoaDonRepository.soHoaDonThanhCongTrongThang(thang, nam);
	}

	@Override
	public String doanhThuTrongThang(int thang, int nam) {

		double result = hoaDonRepository.getDoanhThuTrongThang(thang, nam) == null ? 0
				: hoaDonRepository.getDoanhThuTrongThang(thang, nam);

		return XuLyTien.dinhDangTien(result);
	}

	@Override
	public int soNguoiDungTrongThang(int thang, int nam) {

		return nguoiDungRepository.soNguoiDungsTheoThang(thang, nam);
	}

	@Override
	public List<ValiThongKeDTO> thongKeSoLuongValiTrongThang(int thang, int nam) {

		return bienTheValiRepository.getSoLuongValiTrongThang(thang, nam).stream().map(s -> {

			ValiThongKeDTO tempt = new ValiThongKeDTO();

			tempt.setTenVali((String) s[0]);
			tempt.setSoLuong(Integer.valueOf(String.valueOf(s[1])));
			tempt.setDoanhThu(XuLyTien.dinhDangTien((double) s[2]));

			return tempt;

		}).collect(Collectors.toList());
	}

	@Override
	public int soHoaDonTrongNam(int nam) {

		return hoaDonRepository.soHoaDonTrongNam(nam);
	}

	@Override
	public int soHoaDonThanhCongTrongNam(int nam) {
		// TODO Auto-generated method stub
		return hoaDonRepository.soHoaDonThanhCongTrongNam(nam);
	}

	@Override
	public String doanhThuTrongNam(int nam) {
		double result = hoaDonRepository.getDoanhThuTrongNam(nam) == null ? 0
				: hoaDonRepository.getDoanhThuTrongNam(nam);

		return XuLyTien.dinhDangTien(result);
	}

	@Override
	public int soNguoiDungTrongNam(int nam) {

		return nguoiDungRepository.soNguoiDungsTheoNam(nam);
	}

	@Override
	public List<ValiThongKeDTO> thongKeSoLuongValiTrongNam(int nam) {

		return bienTheValiRepository.getSoLuongValiTrongNam(nam).stream().map(s -> {

			ValiThongKeDTO tempt = new ValiThongKeDTO();

			tempt.setTenVali((String) s[0]);
			tempt.setSoLuong(Integer.valueOf(String.valueOf(s[1])));
			tempt.setDoanhThu(XuLyTien.dinhDangTien((double) s[2]));

			return tempt;

		}).collect(Collectors.toList());
	}

	@Override
	public List<HoaDonThongKeDTO> getHoaDonsTheoThang(int thang, int nam) {
		// TODO Auto-generated method stub
		return hoaDonRepository.getHoaDonTheoThang(thang, nam).stream()
				.map(hd -> thongKeConverter.toHoaDonThongKeDTO(hd)).collect(Collectors.toList());
	}

	@Override
	public List<HoaDonThongKeDTO> getHoaDonsTheoNam(int nam) {
	
		return hoaDonRepository.getHoaDonTheoNam(nam).stream().map(hd -> thongKeConverter.toHoaDonThongKeDTO(hd))
				.collect(Collectors.toList());
	}

}
