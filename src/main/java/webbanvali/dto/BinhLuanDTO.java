package webbanvali.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BinhLuanDTO {

	private NguoiDungDTO nguoiDung;
	private String maVali;
	private String noiDung;
	private int danhGia;
	private LocalDate ngayBinhLuan;
	
	
}
