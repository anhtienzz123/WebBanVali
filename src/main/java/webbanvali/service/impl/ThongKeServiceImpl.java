package webbanvali.service.impl;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbanvali.dto.ThongKeSoDTO;
import webbanvali.repository.BinhLuanRepository;
import webbanvali.repository.HoaDonRepository;
import webbanvali.repository.NguoidungRepository;
import webbanvali.service.ThongKeService;
import webbanvali.utils.ROLE;
import webbanvali.utils.TrangThaiDonHang;

@Service
@Transactional
public class ThongKeServiceImpl implements ThongKeService {

	@Autowired
	private NguoidungRepository nguoiDungRepository;

	@Autowired
	private HoaDonRepository hoaDonRepository;

	@Autowired
	private BinhLuanRepository binhLuanRepository;

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

}
