package webbanvali.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import webbanvali.dto.NhomValiDTO;
import webbanvali.dto.ThuongHieuDTO;
import webbanvali.dto.TinhNangDacBietDTO;
import webbanvali.entity.NhomVali;
import webbanvali.entity.ThuongHieu;
import webbanvali.entity.TinhNangDacBiet;
import webbanvali.repository.NhomValiRepository;
import webbanvali.service.NhomValiService;
import webbanvali.utils.HamDungChung;

@Service
public class NhomValiServiceImpl implements NhomValiService {

	@Autowired
	private NhomValiRepository nhomValiRepository;

	@Override
	public List<NhomValiDTO> getNhomValis() {
		List<NhomVali> nhomValis = nhomValiRepository.findAll(PageRequest.of(0, 5)).getContent();
		

		return nhomValis.stream().map(s -> new NhomValiDTO(s.getId(), s.getTenNhomVali(), s.getCode()))
				.collect(Collectors.toList());
	}

	@Override
	public List<NhomValiDTO> getNhomValisTheoTenNhomVali(String tenNhomVali) {
		// TODO Auto-generated method stub
		List<NhomVali> nhomValis = nhomValiRepository.findByTenNhomValiContainingIgnoreCase(tenNhomVali);

		return nhomValis.stream().map(s -> new NhomValiDTO(s.getId(), s.getTenNhomVali(), s.getCode()))
				.collect(Collectors.toList());
	}

	@Override
	public NhomValiDTO getNhomValiTheoId(int id) {
		// TODO Auto-generated method stub

		NhomValiDTO chatLieuDTO = nhomValiRepository.findById(id)
				.map(s -> new NhomValiDTO(s.getId(), s.getTenNhomVali(), s.getCode())).orElse(null);

		return chatLieuDTO;

	}

	@Override
	public NhomValiDTO themNhomVali(String tenNhomVali) {
		// TODO Auto-generated method stub
		// nếu như đã tồn tại rồi
		if (nhomValiRepository.existsByTenNhomVali(tenNhomVali))
			return null;

		String code = HamDungChung.toSlug(tenNhomVali);
		NhomVali nhomValiResult = nhomValiRepository.save(new NhomVali(tenNhomVali, code));
		return new NhomValiDTO(nhomValiResult.getId(), nhomValiResult.getTenNhomVali(), nhomValiResult.getCode());

	}
	@Override
	public boolean xoaNhomValiTheoId(int id) {
		// TODO Auto-generated method stub
		if (!nhomValiRepository.existsById(id))
			return false;

		nhomValiRepository.delete(nhomValiRepository.findById(id).get());

		return true;

	}

	@Override
	public NhomValiDTO capNhatNhomVali(Integer id, String tenNhomVali) {
		if (nhomValiRepository.existsByTenNhomValiAndIdNot(tenNhomVali, id)) {
			return null;
		}

		String code = HamDungChung.toSlug(tenNhomVali);
		NhomVali nhomValiResult = nhomValiRepository.save(new NhomVali(id, tenNhomVali, code));
		return new NhomValiDTO(nhomValiResult.getId(), nhomValiResult.getTenNhomVali(), nhomValiResult.getCode());
	}


}
