package webbanvali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BannerDTO {

	private Integer id;
	private String tenAnh;
	private String tieuDe;
	private String noiDung;
}
