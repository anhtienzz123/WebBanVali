package webbanvali.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbanvali.dto.MauSacDTO;
import webbanvali.dto.ThuongHieuDTO;
import webbanvali.entity.MauSac;
import webbanvali.entity.ThuongHieu;
import webbanvali.repository.MauSacRepository;
import webbanvali.repository.NhomThuongHieuRepository;
import webbanvali.service.MauSacService;
import webbanvali.service.NhomThuongHieuService;
import webbanvali.utils.HamDungChung;

@Service
public class NhomThuongHieuServiceImpl implements NhomThuongHieuService {

	@Autowired
	private NhomThuongHieuRepository nhomThuongHieuRepository;

	@Override
	public List<ThuongHieuDTO> getThuongHieus() {
		List<ThuongHieu> thuongHieus = nhomThuongHieuRepository.findAll();

		return thuongHieus.stream().map(s -> new ThuongHieuDTO(s.getId(), s.getTenThuongHieu(), s.getCode()))
				.collect(Collectors.toList());
	}

	@Override
	public ThuongHieuDTO themThuongHieu(String tenThuongHieu) {

		// nếu như đã tồn tại rồi
		if (nhomThuongHieuRepository.existsByTenThuongHieu(tenThuongHieu))
			return null;

		String code = HamDungChung.toSlug(tenThuongHieu);
		ThuongHieu thuongHieuResult = nhomThuongHieuRepository.save(new ThuongHieu(tenThuongHieu, code));
		return new ThuongHieuDTO(thuongHieuResult.getId(), thuongHieuResult.getTenThuongHieu(),
				thuongHieuResult.getCode());
	}

	/*
	 * @Override public ThuongHieuDTO cap(Integer id, String tenThuongHieu) {
	 * 
	 * if (mauSacRepository.existsByTenMauAndIdNot(tenMauSac, id)) { return null; }
	 * 
	 * String code = HamDungChung.toSlug(tenMauSac); MauSac mauSacResult =
	 * nhomThuongHieuRepository.save(new MauSac(id, tenMauSac, code)); return new
	 * MauSacDTO(mauSacResult.getId(), mauSacResult.getTenMau(),
	 * mauSacResult.getCode());
	 * 
	 * }
	 */
	@Override
	public ThuongHieuDTO getThuongHieuTheoId(int id) {

		ThuongHieuDTO thuongHieuDTO = nhomThuongHieuRepository.findById(id)
				.map(s -> new ThuongHieuDTO(s.getId(), s.getTenThuongHieu(), s.getCode())).orElse(null);

		return thuongHieuDTO;
	}

	@Override
	public boolean xoaThuongHieuTheoId(int id) {

		if (!nhomThuongHieuRepository.existsById(id))
			return false;

		nhomThuongHieuRepository.delete(nhomThuongHieuRepository.findById(id).get());

		return true;
	}

	@Override
	public List<ThuongHieuDTO> getThuongHieusTheoTenThuongHieu(String tenThuongHieu) {

		List<ThuongHieu> thuongHieus = nhomThuongHieuRepository.findByTenThuongHieuContainingIgnoreCase(tenThuongHieu);

		return thuongHieus.stream().map(s -> new ThuongHieuDTO(s.getId(), s.getTenThuongHieu(), s.getCode()))
				.collect(Collectors.toList());
	}

	@Override
	public ThuongHieuDTO capNhaThuongHieu(Integer id, String tenThuongHieu) {
		// TODO Auto-generated method stub
		if (nhomThuongHieuRepository.existsByTenThuongHieuAndIdNot(tenThuongHieu, id)) {
			return null;
		}

		String code = HamDungChung.toSlug(tenThuongHieu);
		ThuongHieu thuongHieuResult = nhomThuongHieuRepository.save(new ThuongHieu(id, tenThuongHieu, code));
		return new ThuongHieuDTO(thuongHieuResult.getId(), thuongHieuResult.getTenThuongHieu(), thuongHieuResult.getCode());
	}

}
