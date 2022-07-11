package webbanvali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoTaValiDTO {

	private Integer id;
	private String tenMoTa;
	private String noiDung;
	private String tenAnh;
	
}
