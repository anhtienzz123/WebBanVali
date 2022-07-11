package webbanvali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValiChungResponseDTO {

	private Integer id;
	private String tenVali;
	private String chatLieu;
	private String nhomVali;
	private String thuongHieu;
	private int soBienThe;
	private long soLuong;
	private double soDanhGia;
	private int soBinhLuan;
	
	
}
