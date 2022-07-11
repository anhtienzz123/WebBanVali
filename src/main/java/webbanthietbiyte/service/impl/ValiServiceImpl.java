package webbanvali.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbanvali.converter.ValiConverter;
import webbanvali.dto.KeyValueDTO;
import webbanvali.dto.ValiChungDTO;
import webbanvali.dto.ValiChungResponseDTO;
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
@Transactional
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
	public Vali getValiTheoID(Integer maVali) {
		Vali vali = valiRepository.findById(maVali).get();

		if (vali == null)
			return null;

		return vali;

	}

	@Override
	public Map<String, List<KeyValueDTO>> getTieuChiTimKiem() {

		Map<String, List<KeyValueDTO>> result = new HashMap<>();

		result.put("nhomValis", nhomValiRepository.findAll().stream()
				.map(s -> new KeyValueDTO(s.getCode(), s.getTenNhomVali())).collect(Collectors.toList()));

		result.put("gias", ChuoiConstant.getGiasConstant());
		result.put("thuongHieus", thuongHieuRepository.findAll().stream()
				.map(s -> new KeyValueDTO(s.getCode(), s.getTenThuongHieu())).collect(Collectors.toList()));

		result.put("chatLieus", chatLieuRepository.findAll().stream()
				.map(s -> new KeyValueDTO(s.getCode(), s.getTenChatLieu())).collect(Collectors.toList()));

		result.put("kichThuocs", kichThuocRepository.findAll().stream()
				.map(s -> new KeyValueDTO(s.getCode(), s.getTenKichThuoc())).collect(Collectors.toList()));

		result.put("mauSacs", mauSacRepository.findAll().stream().map(s -> new KeyValueDTO(s.getCode(), s.getTenMau()))
				.collect(Collectors.toList()));

		result.put("tinhNangDacBiets", tinhNangDacBietRepository.findAll().stream()
				.map(s -> new KeyValueDTO(s.getCode(), s.getTenTinhNang())).collect(Collectors.toList()));

		return result;
	}

	@Override
	public List<ValiChungResponseDTO> getValiChungTheoTenValiVaChatLieuVaNhomValiVaThuongHieu(String tenVali,
			String chatLieu, String nhomVali, String thuongHieu) {

		return valiRepository
				.findByTenValiContainingAndChatLieuTenChatLieuContainingAndThuongHieuTenThuongHieuContainingAndNhomValiTenNhomValiContaining(
						tenVali, chatLieu, thuongHieu, nhomVali)
				.stream().map(s -> valiConverter.toValiChungDTO(s)).collect(Collectors.toList());
	}

	@Override
	public Map<String, List<String>> getTenOfTinhNangVaChatLieuVaThuongVaNhomVali() {

		Map<String, List<String>> result = new HashMap<>();

		List<String> tenTinhNangs = tinhNangDacBietRepository.findAll().stream().map(s -> s.getTenTinhNang())
				.collect(Collectors.toList());
		result.put("tenTinhNangs", tenTinhNangs);

		List<String> tenChatLieus = chatLieuRepository.findAll().stream().map(s -> s.getTenChatLieu())
				.collect(Collectors.toList());
		result.put("tenChatLieus", tenChatLieus);

		List<String> tenThuongHieus = thuongHieuRepository.findAll().stream().map(s -> s.getTenThuongHieu())
				.collect(Collectors.toList());
		result.put("tenThuongHieus", tenThuongHieus);

		List<String> tenNhomValis = nhomValiRepository.findAll().stream().map(s -> s.getTenNhomVali())
				.collect(Collectors.toList());
		result.put("tenNhomValis", tenNhomValis);

		return result;
	}

	@Override
	public boolean themVali(ValiChungDTO valiChungDTO) {

		valiChungDTO.setId(0);
		Vali result = valiRepository.save(valiConverter.toVali(valiChungDTO));

		if (result != null)
			return true;

		return false;
	}

	@Override
	public Map<String, List<String>> getTenOfValiVaKichThuocVaMauSac() {

		Map<String, List<String>> result = new HashMap<>();

		List<String> tenValis = valiRepository.findAll().stream().map(s -> s.getTenVali()).collect(Collectors.toList());

		result.put("tenValis", tenValis);

		List<String> tenKichThuocs = kichThuocRepository.findAll().stream().map(s -> s.getTenKichThuoc())
				.collect(Collectors.toList());
		result.put("tenKichThuocs", tenKichThuocs);

		List<String> tenMauSacs = mauSacRepository.findAll().stream().map(s -> s.getTenMau())
				.collect(Collectors.toList());
		result.put("tenMauSacs", tenMauSacs);

		return result;
	}

	@Override
	public ValiChungDTO getValiChungById(Integer id) {

		if (!valiRepository.existsById(id))
			return null;

		ValiChungDTO valiChungDTO = new ValiChungDTO();

		Vali vali = valiRepository.findById(id).get();

		valiChungDTO.setId(vali.getId());
		valiChungDTO.setTenVali(vali.getTenVali());
		valiChungDTO.setBanhXe(vali.getBanhXe());
		valiChungDTO.setDayKeo(vali.getDayKeo());
		valiChungDTO.setKhoa(vali.getKhoa());
		valiChungDTO.setThoiGianBaoHanh(vali.getThoiGianBaoHanh());
		valiChungDTO.setTinhNangs(
				vali.getTinhNangDacBiets().stream().map(s -> s.getTenTinhNang()).collect(Collectors.toList()));

		valiChungDTO.setTenChatLieu(vali.getChatLieu().getTenChatLieu());
		valiChungDTO.setTenThuongHieu(vali.getThuongHieu().getTenThuongHieu());
		valiChungDTO.setTenNhomVali(vali.getNhomVali().getTenNhomVali());
		valiChungDTO.setMoTa(vali.getMoTa());

		return valiChungDTO;
	}
	
	@Override
	public boolean capNhatVali(Integer id,ValiChungDTO valiChungDTO) {
		
		valiChungDTO.setId(id);
		
		Vali result = valiRepository.save(valiConverter.toVali(valiChungDTO));

		if (result != null)
			return true;

		return false;
		
		
		
	}
	
	@Override
	public boolean xoa(Integer id) {
		
		try {
			valiRepository.deleteById(id);
			
			return true;
		} catch (Exception e) {
			
			return false;
		}
		
		
	}
}
