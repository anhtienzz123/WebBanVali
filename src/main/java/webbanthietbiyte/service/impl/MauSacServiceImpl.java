package webbanvali.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbanvali.dto.MauSacDTO;
import webbanvali.entity.MauSac;
import webbanvali.repository.MauSacRepository;
import webbanvali.service.MauSacService;
import webbanvali.utils.HamDungChung;

@Service
public class MauSacServiceImpl implements MauSacService {

	@Autowired
	private MauSacRepository mauSacRepository;

	@Override
	public List<MauSacDTO> getMauSacs() {
		
		List<MauSac> mauSacs = mauSacRepository.findAll();
		return mauSacs.stream().map(s -> new MauSacDTO(s.getId(), s.getTenMau(), s.getCode()))
				.collect(Collectors.toList());
	}

	@Override
	public MauSacDTO themMauSac(String tenMauSac) {

		// nếu như đã tồn tại rồi
		if (mauSacRepository.existsByTenMau(tenMauSac))
			return null;

		String code = HamDungChung.toSlug(tenMauSac);
		
		MauSac mauSacResult = mauSacRepository.save(new MauSac(tenMauSac, code));
		return new MauSacDTO(mauSacResult.getId(), mauSacResult.getTenMau(), mauSacResult.getCode());
	}

	@Override
	public MauSacDTO capNhatMauSac(Integer id, String tenMauSac) {

		// kiểm tra thằng khác có màu giống
		if (mauSacRepository.existsByTenMauAndIdNot(tenMauSac, id)) {
			return null;
		}

		String code = HamDungChung.toSlug(tenMauSac);
		MauSac mauSacResult = mauSacRepository.save(new MauSac(id, tenMauSac, code));
		return new MauSacDTO(mauSacResult.getId(), mauSacResult.getTenMau(), mauSacResult.getCode());

	}

	@Override
	public MauSacDTO getMauSacTheoId(int id) {

		MauSacDTO mauSacDTO = mauSacRepository.findById(id)
				.map(s -> new MauSacDTO(s.getId(), s.getTenMau(), s.getCode())).orElse(null);
		
		

		return mauSacDTO;
	}

	@Override
	public boolean xoaMauSacTheoId(int id) {

		if (!mauSacRepository.existsById(id))
			return false;

//		mauSacRepository.delete(mauSacRepository.findById(id).get());
		mauSacRepository.deleteById(id);

		return true;
	}

	@Override
	public List<MauSacDTO> getMauSacsTheoTenMau(String tenMau) {

		List<MauSac> mauSacs = mauSacRepository.findByTenMauContainingIgnoreCase(tenMau);

		return mauSacs.stream().map(s -> new MauSacDTO(s.getId(), s.getTenMau(), s.getCode()))
				.collect(Collectors.toList());
	}

}
