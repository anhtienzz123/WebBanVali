package webbanvali.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbanvali.dto.TinhNangDacBietDTO;
import webbanvali.entity.TinhNangDacBiet;
import webbanvali.repository.TinhNangDacBietRepository;
import webbanvali.service.TinhNangDacBietService;
import webbanvali.utils.HamDungChung;

@Service
public class TinhNangDacBietImpl implements TinhNangDacBietService {
	@Autowired
	private TinhNangDacBietRepository tinhNangDacBietRepository;

	@Override
	public List<TinhNangDacBietDTO> getTinhNangDacBiets() {
		List<TinhNangDacBiet> tinhNangDacBiets = tinhNangDacBietRepository.findAll();

		return tinhNangDacBiets.stream().map(s -> new TinhNangDacBietDTO(s.getId(), s.getTenTinhNang(), s.getCode()))
				.collect(Collectors.toList());
	}

	@Override
	public List<TinhNangDacBietDTO> getTinhNangDacBietsTheoTenTinhNang(String tenTinhNang) {
		List<TinhNangDacBiet> tinhNangDacBiets = tinhNangDacBietRepository
				.findByTenTinhNangContainingIgnoreCase(tenTinhNang);

		return tinhNangDacBiets.stream().map(s -> new TinhNangDacBietDTO(s.getId(), s.getTenTinhNang(), s.getCode()))
				.collect(Collectors.toList());
	}

	@Override
	public TinhNangDacBietDTO getTinhNangDacBietTheoId(int id) {

		TinhNangDacBietDTO tinhNangDacBietDTO = tinhNangDacBietRepository.findById(id)
				.map(s -> new TinhNangDacBietDTO(s.getId(), s.getTenTinhNang(), s.getCode())).orElse(null);
		return tinhNangDacBietDTO;
	}

	@Override
	public TinhNangDacBietDTO themTinhNangDacBiet(String tenTinhNang) {
		if (tinhNangDacBietRepository.existsByTenTinhNang(tenTinhNang))
			return null;

		String code = HamDungChung.toSlug(tenTinhNang);

		TinhNangDacBiet TinhNangDacBietResult = tinhNangDacBietRepository.save(new TinhNangDacBiet(tenTinhNang, code));
		return new TinhNangDacBietDTO(TinhNangDacBietResult.getId(), TinhNangDacBietResult.getTenTinhNang(),
				TinhNangDacBietResult.getCode());
	}

	@Override
	public TinhNangDacBietDTO capNhatTinhNangDacBiet(Integer id, String tenTinhNang) {
		if (tinhNangDacBietRepository.existsByTenTinhNangAndIdNot(tenTinhNang, id)) {
			return null;
		}

		String code = HamDungChung.toSlug(tenTinhNang);
		TinhNangDacBiet TinhNangDacBietResult = tinhNangDacBietRepository
				.save(new TinhNangDacBiet(id, tenTinhNang, code));
		return new TinhNangDacBietDTO(TinhNangDacBietResult.getId(), TinhNangDacBietResult.getTenTinhNang(),
				TinhNangDacBietResult.getCode());
	}

	@Override
	public boolean xoaTinhNangDacBietTheoId(int id) {
		if (!tinhNangDacBietRepository.existsById(id))
			return false;

//		mauSacRepository.delete(mauSacRepository.findById(id).get());
		tinhNangDacBietRepository.deleteById(id);

		return true;
	}

}
