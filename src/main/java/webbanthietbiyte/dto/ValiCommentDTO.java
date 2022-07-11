package webbanvali.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValiCommentDTO {

	private double soDanhGiaTrungBinh;
	private int nam;
	private int bon;
	private int ba;
	private int hai;
	private int mot;
	
	private List<BinhLuanDTO> binhLuanDTOs;
	
}
