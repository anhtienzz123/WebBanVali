package webbanvali.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import webbanvali.converter.HoaDonConverter;
import webbanvali.dto.HoaDonChungDTO;
import webbanvali.dto.HoaDonDTO;
import webbanvali.entity.BienTheVali;
import webbanvali.entity.ChiTietHoaDon;
import webbanvali.entity.HoaDon;
import webbanvali.repository.BienTheValiRepository;
import webbanvali.repository.HoaDonRepository;
import webbanvali.service.HoaDonService;
import webbanvali.utils.TrangThaiDonHangConstant;

@Service
@Transactional
public class HoaDonServiceImpl implements HoaDonService {

	@Autowired
	private HoaDonRepository hoaDonRepository;

	@Autowired
	private HoaDonConverter hoaDonConverter;
	
	@Autowired
	private BienTheValiRepository bienTheValiRepository;

	@Override
	public List<HoaDonChungDTO> getHoaDonChungs(String id, String soDienThoai, String trangThai, int page, int size) {

		List<HoaDon> result = hoaDonRepository.findAllByIdAndSoDienThoaiGiaoHangAndTrangThaiDonHang(id, soDienThoai,
				trangThai, PageRequest.of(page, size));

		return result.stream().map(hd -> hoaDonConverter.toHoaDonChungDTO(hd)).collect(Collectors.toList());
	}

	@Override
	public List<HoaDonChungDTO> getHoaDonChungs1(String id, String soDienThoai) {

		List<HoaDon> result = hoaDonRepository.findAllByIdAndSoDienThoaiGiaoHang(id, soDienThoai);

		return result.stream().map(hd -> hoaDonConverter.toHoaDonChungDTO(hd)).collect(Collectors.toList());
	}

	@Override
	public List<HoaDonChungDTO> getHoaDonChungs2(String soDienThoai) {

		List<HoaDon> result = hoaDonRepository.findAllBySoDienThoaiGiaoHang(soDienThoai);

		return result.stream().map(hd -> hoaDonConverter.toHoaDonChungDTO(hd)).collect(Collectors.toList());
	}

	@Override
	public boolean capNhatTrangThai(String id, String trangThai) {

		if (!hoaDonRepository.existsById(id)) {

			return false;
		}

		int result = hoaDonRepository.capNhatTrangThai(id, trangThai);
		
		if(trangThai.equals(TrangThaiDonHangConstant.HUY_DON_HANG)){
			
			HoaDon hoaDon = hoaDonRepository.findById(id).get();
			
			for (ChiTietHoaDon chiTietHoaDon : hoaDon.getChiTietHoaDons()) {
				
				BienTheVali bienTheVali = chiTietHoaDon.getBienTheVali();
				
				bienTheVali.setSoLuong(bienTheVali.getSoLuong() + chiTietHoaDon.getSoLuong());
				
				bienTheValiRepository.save(bienTheVali);
				
				
			}
			
			
		}
		

		if (result > 0)
			return true;

		return false;

	}

	@Override
	public HoaDonDTO getTheoId(String id) {

		return hoaDonRepository.findById(id).map(s -> hoaDonConverter.toHoaDonDTO(s)).orElse(null);
	}

	@Override
	public boolean xoaHoaDon(String id) {

		if (!hoaDonRepository.existsById(id)) {
			return false;
		}
		hoaDonRepository.deleteById(id);
		return true;
	}

}
