package webbanvali.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValiChungDTO {

	private Integer id;
	private String tenVali;
	private String banhXe;
	private String dayKeo;
	private String khoa;
	private String thoiGianBaoHanh;
	private List<String> tinhNangs;
	private String tenChatLieu;
	private String tenThuongHieu;
	private String tenNhomVali;
	private String moTa;
	
	
	
}
