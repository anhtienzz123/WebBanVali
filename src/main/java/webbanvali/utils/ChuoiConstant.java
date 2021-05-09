package webbanvali.utils;

import java.util.ArrayList;
import java.util.List;

import webbanvali.dto.KeyValueDTO;

public class ChuoiConstant {

	public static final String KEY_DUOI_1_TRIEU = "DUOI_1_TRIEU";
	public static final String KEY_TU_1_2_TRIEU = "TU_1_2_TRIEU";
	public static final String KEY_TU_2_3_TRIEU = "TU_2_3_TRIEU";
	public static final String KEY_TREN_3_TRIEU = "TREN_3_TRIEU";

	public static final String DUOI_1_TRIEU = "Dưới 1 triệu";
	public static final String TU_1_2_TRIEU = "Từ 1 - 2 triệu";
	public static final String TU_2_3_TRIEU = "Từ 2 - 3 triệu";
	public static final String TREN_3_TRIEU = "Trên 3 triệu";
	
	public static final String GIA_TANG_DAN = "gia-tang-dan";
	public static final String GIA_GIAM_DAN = "gia-giam-dan";
	public static final String KHUYEN_MAI = "khuyen-mai";

	public static List<KeyValueDTO> getGiasConstant() {

		List<KeyValueDTO> ketQua = new ArrayList<>();

		ketQua.add(new KeyValueDTO(KEY_DUOI_1_TRIEU, DUOI_1_TRIEU));
		ketQua.add(new KeyValueDTO(KEY_TU_1_2_TRIEU, TU_1_2_TRIEU));
		ketQua.add(new KeyValueDTO(KEY_TU_2_3_TRIEU, TU_2_3_TRIEU));
		ketQua.add(new KeyValueDTO(KEY_TREN_3_TRIEU, TREN_3_TRIEU));

		return ketQua;

	}

}
