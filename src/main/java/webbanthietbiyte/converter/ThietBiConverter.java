package webbanvali.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webbanvali.dto.ChatLieuDTO;
import webbanvali.dto.MoTaValiDTO;
import webbanvali.dto.NhomValiDTO;
import webbanvali.dto.ThuongHieuDTO;
import webbanvali.dto.TinhNangDacBietDTO;
import webbanvali.dto.ValiChungDTO;
import webbanvali.dto.ValiChungResponseDTO;
import webbanvali.dto.ValiDTO;
import webbanvali.entity.ChatLieu;
import webbanvali.entity.NhomVali;
import webbanvali.entity.ThuongHieu;
import webbanvali.entity.TinhNangDacBiet;
import webbanvali.entity.Vali;
import webbanvali.repository.ChatLieuRepository;
import webbanvali.repository.NhomValiRepository;
import webbanvali.repository.ThuongHieuRepository;
import webbanvali.repository.TinhNangDacBietRepository;
import webbanvali.repository.ValiRepository;
import webbanvali.utils.HamDungChung;

@Component
public class ValiConverter {

	@Autowired
	private TinhNangDacBietRepository tinhNangDacBietRepository;
	@Autowired
	private ChatLieuRepository chatLieuRepository;
	@Autowired
	private ThuongHieuRepository thuongHieuRepository;
	@Autowired
	private NhomValiRepository nhomValiRepository;
	@Autowired
	private ValiRepository valiRepository;

	public ValiDTO toDTO(Vali vali) {

		Integer id = vali.getId();
		String tenVali = vali.getTenVali();
		String slug = vali.getSlug();
		String banhXe = vali.getBanhXe();
		String dayKeo = vali.getDayKeo();
		String khoa = vali.getKhoa();
		String thoiGianBaoHanh = vali.getThoiGianBaoHanh();

//		List<MoTaValiDTO> moTaValis = vali.getMoTaValis().stream().map(s -> {
//			return new MoTaValiDTO(s.getId(), s.getTenMoTa(), s.getNoiDung(), s.getTenAnh());
//		}).collect(Collectors.toList());

		List<MoTaValiDTO> moTaValis = new ArrayList<MoTaValiDTO>();

		List<TinhNangDacBietDTO> tinhNangDacBiets = vali.getTinhNangDacBiets().stream().map(s -> {
			return new TinhNangDacBietDTO(s.getId(), s.getTenTinhNang(), s.getCode());
		}).collect(Collectors.toList());

		ChatLieuDTO chatLieuDTO = Optional.ofNullable(vali.getChatLieu()).map(s -> {
			return new ChatLieuDTO(s.getId(), s.getTenChatLieu(), s.getCode());
		}).orElse(null);

		ThuongHieuDTO thuongHieuDTO = Optional.ofNullable(vali.getThuongHieu()).map(s -> {
			return new ThuongHieuDTO(s.getId(), s.getTenThuongHieu(), s.getCode());
		}).orElse(null);

		NhomValiDTO nhomVali = Optional.ofNullable(vali.getNhomVali()).map(s -> {
			return new NhomValiDTO(s.getId(), s.getTenNhomVali(), s.getCode());
		}).orElse(null);
		;

		return new ValiDTO(id, tenVali, slug, banhXe, dayKeo, khoa, thoiGianBaoHanh, moTaValis, tinhNangDacBiets,
				chatLieuDTO, thuongHieuDTO, nhomVali);
	}

	public ValiChungResponseDTO toValiChungDTO(Vali vali) {

		ValiChungResponseDTO valiChungDTO = new ValiChungResponseDTO();

		valiChungDTO.setId(vali.getId());
		valiChungDTO.setTenVali(vali.getTenVali());
		valiChungDTO.setChatLieu(vali.getChatLieu().getTenChatLieu());
		valiChungDTO.setNhomVali(vali.getNhomVali().getTenNhomVali());
		valiChungDTO.setThuongHieu(vali.getThuongHieu().getTenThuongHieu());
		valiChungDTO.setSoBienThe(vali.getBienTheValis().size());
		valiChungDTO.setSoLuong(vali.getBienTheValis().stream().mapToLong(s -> s.getSoLuong()).sum());
		valiChungDTO.setSoDanhGia(vali.getBinhLuans().stream().mapToInt(s -> s.getDanhGia()).average().orElse(0));
		valiChungDTO.setSoBinhLuan(vali.getBinhLuans().size());

		return valiChungDTO;
	}

	public Vali toVali(ValiChungDTO valiChungDTO) {

		if(valiChungDTO == null)
			return null;
		
		Integer id = valiChungDTO.getId();
		
		Vali vali = new Vali();
		
		if(id != 0) {
			vali = valiRepository.findById(id).get();
		}else {
			vali.setId(0);
		}
		
		
		vali.setTenVali(valiChungDTO.getTenVali());
		vali.setSlug(HamDungChung.toSlug(valiChungDTO.getTenVali()));
		vali.setBanhXe(valiChungDTO.getBanhXe());
		vali.setDayKeo(valiChungDTO.getDayKeo());
		vali.setKhoa(valiChungDTO.getKhoa());
		vali.setThoiGianBaoHanh(valiChungDTO.getThoiGianBaoHanh());
		vali.setMoTa(valiChungDTO.getMoTa());

		List<TinhNangDacBiet> tinhNangDacBiets = valiChungDTO.getTinhNangs().stream()
				.map(s -> tinhNangDacBietRepository.findByTenTinhNang(s)).collect(Collectors.toList());
		vali.setTinhNangDacBiets(tinhNangDacBiets);

		ChatLieu chatLieu = chatLieuRepository.findByTenChatLieu(valiChungDTO.getTenChatLieu());
		vali.setChatLieu(chatLieu);

		ThuongHieu thuongHieu = thuongHieuRepository.findByTenThuongHieu(valiChungDTO.getTenThuongHieu());
		vali.setThuongHieu(thuongHieu);

		NhomVali nhomVali = nhomValiRepository.findByTenNhomVali(valiChungDTO.getTenNhomVali());
		vali.setNhomVali(nhomVali);

		return vali;
	}
}
