package webbanvali.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import webbanvali.converter.ChiTietHoaDonConverter;
import webbanvali.converter.HoaDonConverter;
import webbanvali.dto.ChiTietHoaDonDTO;
import webbanvali.dto.HoaDonChungDTO;
import webbanvali.dto.HoaDonDTO;
import webbanvali.entity.ChiTietHoaDon;
import webbanvali.entity.HoaDon;
import webbanvali.entity.Vali;
import webbanvali.repository.ChiTietHoaDonRepository;
import webbanvali.repository.HoaDonRepository;
import webbanvali.service.ChiTietHoaDonService;
import webbanvali.service.HoaDonService;

@Service
@Transactional
public class ChiTietHoaDonServiceImpl implements ChiTietHoaDonService {

	@Autowired
	private ChiTietHoaDonRepository chiTietHoaDonRepository;

	@Autowired
	private ChiTietHoaDonConverter chiTietHoaDonConverter;

	@Override
	public List<ChiTietHoaDonDTO> getChiTietHoaDonChungs2(String email) {

		List<ChiTietHoaDon> result = chiTietHoaDonRepository.findAllByHoaDonId(email);

		return result.stream().map(hd -> chiTietHoaDonConverter.toChiTietHoaDonDTO(hd)).collect(Collectors.toList());

	}

	@Override
	public ChiTietHoaDonDTO getChiTietHoaDonTheoMaHoaDon(String maHoaDon) {
		ChiTietHoaDon chiTietHoaDon = chiTietHoaDonRepository.findById(maHoaDon).get();

		if (chiTietHoaDon == null)
			return null;

		ChiTietHoaDonDTO sachDTO = chiTietHoaDonConverter.toChiTietHoaDonDTO(chiTietHoaDon);

		return sachDTO;
	}

}
