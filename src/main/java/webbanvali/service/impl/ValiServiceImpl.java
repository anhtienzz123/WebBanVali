package webbanvali.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbanvali.converter.ValiConverter;
import webbanvali.dto.KeyValueDTO;
import webbanvali.dto.ValiDTO;
import webbanvali.entity.Vali;
import webbanvali.repository.ChatLieuRepository;
import webbanvali.repository.KichThuocRepository;
import webbanvali.repository.MauSacRepository;
import webbanvali.repository.NhomValiRepository;
import webbanvali.repository.ThuongHieuRepository;
import webbanvali.repository.TinhNangDacBietRepository;
import webbanvali.repository.ValiRepository;
import webbanvali.service.ValiService;
import webbanvali.utils.ChuoiConstant;

@Service
public class ValiServiceImpl implements ValiService {

	@Autowired
	private ValiRepository valiRepository;

	@Autowired
	private ValiConverter valiConverter;

	@Autowired
	private NhomValiRepository nhomValiRepository;
	@Autowired
	private ThuongHieuRepository thuongHieuRepository;
	@Autowired
	private ChatLieuRepository chatLieuRepository;
	@Autowired
	private KichThuocRepository kichThuocRepository;
	@Autowired
	private MauSacRepository mauSacRepository;
	@Autowired
	private TinhNangDacBietRepository tinhNangDacBietRepository;
	

	@Override
	public ValiDTO getValiTheoMaVali(Integer maVali) {

		Vali vali = valiRepository.findById(maVali).get();

		if (vali == null)
			return null;

		ValiDTO sachDTO = valiConverter.toDTO(vali);

		return sachDTO;
	}

	@Override
	public Map<String, List<KeyValueDTO>> getTieuChiTimKiem() {

		Map<String, List<KeyValueDTO>> result = new HashMap<>();

		
		result.put("nhomValis", nhomValiRepository.findAll().stream()
				.map(s -> new KeyValueDTO(s.getCode(), s.getTenNhomVali())).collect(Collectors.toList()) );
		
		result.put("gias", ChuoiConstant.getGiasConstant());
		result.put("thuongHieus", thuongHieuRepository.findAll().stream()
				.map(s -> new KeyValueDTO(s.getCode(), s.getTenThuongHieu())).collect(Collectors.toList()) );
		
		result.put("chatLieus", chatLieuRepository.findAll().stream()
				.map(s -> new KeyValueDTO(s.getCode(), s.getTenChatLieu())).collect(Collectors.toList()) );
		
		result.put("kichThuocs", kichThuocRepository.findAll().stream()
				.map(s -> new KeyValueDTO(s.getCode(), s.getTenKichThuoc())).collect(Collectors.toList()) );
		
		result.put("mauSacs", mauSacRepository.findAll().stream()
				.map(s -> new KeyValueDTO(s.getCode(), s.getTenMau())).collect(Collectors.toList()) );
		
		result.put("tinhNangDacBiets", tinhNangDacBietRepository.findAll().stream()
				.map(s -> new KeyValueDTO(s.getCode(), s.getTenTinhNang())).collect(Collectors.toList()) );

		return result;
	}

}
