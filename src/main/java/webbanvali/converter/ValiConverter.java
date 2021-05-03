package webbanvali.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import webbanvali.dto.ChatLieuDTO;
import webbanvali.dto.MoTaValiDTO;
import webbanvali.dto.NhomValiDTO;
import webbanvali.dto.ThuongHieuDTO;
import webbanvali.dto.TinhNangDacBietDTO;
import webbanvali.dto.ValiDTO;
import webbanvali.entity.Vali;

@Component
public class ValiConverter {

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
		
		List<MoTaValiDTO> moTaValis= new ArrayList<MoTaValiDTO>();
		

		List<TinhNangDacBietDTO> tinhNangDacBiets = vali.getTinhNangDacBiets().stream().map(s -> {
			return new TinhNangDacBietDTO(s.getId(), s.getTenTinhNang(),s.getCode());
		}).collect(Collectors.toList());

		ChatLieuDTO chatLieuDTO = Optional.ofNullable(vali.getChatLieu()).map(s -> {
			return new ChatLieuDTO(s.getId(), s.getTenChatLieu(), s.getCode());
		}).orElse(null);
		
		
		ThuongHieuDTO thuongHieuDTO = Optional.ofNullable(vali.getThuongHieu()).map(s -> {
			return new ThuongHieuDTO(s.getId(), s.getTenThuongHieu(), s.getCode());
		}).orElse(null);
		
		NhomValiDTO nhomVali = Optional.ofNullable(vali.getNhomVali()).map(s -> {
			return new NhomValiDTO(s.getId(), s.getTenNhomVali(), s.getCode());
		}).orElse(null);;

		return new ValiDTO(id, tenVali, slug, banhXe, dayKeo, khoa, thoiGianBaoHanh, moTaValis, tinhNangDacBiets, chatLieuDTO, thuongHieuDTO, nhomVali);
	}
}
