package webbanvali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BinhLuanDTO {
	private Integer nguoiDungID;
	private String tenVali;
	private Integer valiID;
	private String slugVali;
	private String tenNguoiDung;
	private String thoiGian;
	private int soDanhGia;
	private String noiDung;
	// mở cái tin nhắn yêu cầu của tao đi mày
	
	
}
