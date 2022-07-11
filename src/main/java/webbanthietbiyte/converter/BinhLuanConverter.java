package webbanvali.converter;

import org.springframework.stereotype.Component;

import webbanvali.dto.BinhLuanDTO;
import webbanvali.entity.BinhLuan;
import webbanvali.utils.XuLiNgay;

@Component
public class BinhLuanConverter {

	public BinhLuanDTO toBinhLuanDTO(BinhLuan binhLuan) {

		if (binhLuan == null)
			return null;

		BinhLuanDTO binhLuanDTO = new BinhLuanDTO();
		binhLuanDTO.setNguoiDungID(binhLuan.getNguoiDung().getId());
		binhLuanDTO.setTenVali(binhLuan.getVali().getTenVali());
		binhLuanDTO.setValiID(binhLuan.getVali().getId());
		binhLuanDTO.setSlugVali(binhLuan.getVali().getSlug());
		binhLuanDTO.setNoiDung(binhLuan.getNoiDung());
		binhLuanDTO.setSoDanhGia(binhLuan.getDanhGia());
		binhLuanDTO.setTenNguoiDung(binhLuan.getNguoiDung().getHoTen());
		binhLuanDTO.setThoiGian(XuLiNgay.toString(binhLuan.getThoiGianBinhLuan()));

		return binhLuanDTO;
	}

}
