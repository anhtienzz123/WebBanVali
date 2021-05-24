package webbanvali.service.impl;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbanvali.dto.KichThuocDTO;
import webbanvali.entity.KichThuoc;
import webbanvali.repository.KichThuocRepository;
import webbanvali.service.KichThuocService;
import webbanvali.utils.HamDungChung;

@Service
public class KichThuocServiceImpl implements KichThuocService {

	@Autowired
	private KichThuocRepository kichThuocRepository;

	@Override
	public List<KichThuocDTO> getKichThuocs() {
		
		List<KichThuoc> kichThuocs = kichThuocRepository.findAll();
		
//		List<MauSacDTO> result = new ArrayList<MauSacDTO>();
//				
//	
//		for (MauSac mauSac : mauSacs) {
//			
//			MauSacDTO mauSacDTO = new MauSacDTO(mauSac.getId(), mauSac.getTenMau(), mauSac.getCode());
//			
//			result.add(mauSacDTO);
//			
//		}
//		
//		return result;

		return kichThuocs.stream().map(s -> new KichThuocDTO(s.getId(), s.getTenKichThuoc(), s.getCode()))
				.collect(Collectors.toList());
	}

	@Override
	public KichThuocDTO themKichThuoc(String tenKichThuoc)  {

		// nếu như đã tồn tại rồi
		if (kichThuocRepository.existsByTenKichThuoc(tenKichThuoc))
			return null;

		String code = HamDungChung.toSlug(tenKichThuoc);
		
		KichThuoc kichThuocResult = kichThuocRepository.save(new KichThuoc(tenKichThuoc, code));
		return new KichThuocDTO(kichThuocResult.getId(), kichThuocResult.getTenKichThuoc(), kichThuocResult.getCode());
	}

	@Override
	public KichThuocDTO capNhatKichThuoc(Integer id, String tenKichThuoc) {

		// kiểm tra thằng khác có màu giống
		if (kichThuocRepository.existsByTenKichThuocAndIdNot(tenKichThuoc, id)) {
			return null;
		}

		String code = HamDungChung.toSlug(tenKichThuoc);
		KichThuoc kichThuocResult = kichThuocRepository.save(new KichThuoc(id, tenKichThuoc, code));
		return new KichThuocDTO(kichThuocResult.getId(), kichThuocResult.getTenKichThuoc(), kichThuocResult.getCode());

	}

	@Override
	public KichThuocDTO getKichThuocTheoId(int id) {

		KichThuocDTO kichThuocDTO = kichThuocRepository.findById(id)
				.map(s -> new KichThuocDTO(s.getId(), s.getTenKichThuoc(), s.getCode())).orElse(null);
		
		

		return kichThuocDTO;
	}

	@Override
	public boolean xoaKichThuocTheoId(int id) {

		if (!kichThuocRepository.existsById(id))
			return false;

//		mauSacRepository.delete(mauSacRepository.findById(id).get());
		kichThuocRepository.deleteById(id);

		return true;
	}

	@Override
	public List<KichThuocDTO> getKichThuocsTheoTen(String tenKichThuoc) {

		List<KichThuoc> kichThuocs = kichThuocRepository.findByTenKichThuocContainingIgnoreCase(tenKichThuoc);

		return kichThuocs.stream().map(s -> new KichThuocDTO(s.getId(), s.getTenKichThuoc(), s.getCode()))
				.collect(Collectors.toList());
	}

	


	

	

	

}
