package webbanvali.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import webbanvali.dto.BinhLuanDTO;
import webbanvali.dto.ValiCommentDTO;
import webbanvali.entity.BinhLuan;
import webbanvali.entity.Vali;
import webbanvali.utils.XuLiNgay;

@Component
public class CommentConverter {

	public ValiCommentDTO convertValiToValiCommentDTO(Vali vali) {

		if (vali == null)
			return null;

		int tongSoBinhLuan = vali.getBinhLuans().size();

		if (tongSoBinhLuan == 0)
			return new ValiCommentDTO(0, 0, 0, 0, 0, 0, new ArrayList<>());

		double soDanhGiaTrungBinh = 0;
		int nam = 0;
		int bon = 0;
		int ba = 0;
		int hai = 0;
		int mot = 0;

		List<BinhLuanDTO> binhLuanDTOs = new ArrayList<>();
		int commentNumber = 0;

		for (BinhLuan binhLuan : vali.getBinhLuans()) {

			if (commentNumber < 10) {

				BinhLuanDTO binhLuanDTO = new BinhLuanDTO(binhLuan.getNguoiDung().getId(),
						binhLuan.getVali().getTenVali(), binhLuan.getVali().getId(), binhLuan.getVali().getSlug(),
						binhLuan.getNguoiDung().getHoTen(), XuLiNgay.toString(binhLuan.getThoiGianBinhLuan()),
						binhLuan.getDanhGia(), binhLuan.getNoiDung());

				binhLuanDTOs.add(binhLuanDTO);
				commentNumber++;
			}

			int danhGiaTempt = binhLuan.getDanhGia();

			soDanhGiaTrungBinh += danhGiaTempt;

			switch (danhGiaTempt) {
			case 1:
				mot++;
				break;

			case 2:
				hai++;
				break;

			case 3:
				ba++;
				break;

			case 4:
				bon++;
				break;

			case 5:
				nam++;
				break;

			default:
				break;
			}

		}

		soDanhGiaTrungBinh /= tongSoBinhLuan;
		nam = (int) Math.round((nam * 1.00 / tongSoBinhLuan) * 100);
		bon = (int) Math.round((bon * 1.00 / tongSoBinhLuan) * 100);
		ba = (int) Math.round((ba * 1.00 / tongSoBinhLuan) * 100);
		hai = (int) Math.round((hai * 1.00 / tongSoBinhLuan) * 100);
		mot = (int) Math.round((mot * 1.00 / tongSoBinhLuan) * 100);

		return new ValiCommentDTO(Math.round(soDanhGiaTrungBinh*100)*1.0/100, nam, bon, ba, hai, mot, binhLuanDTOs);
	}
}
