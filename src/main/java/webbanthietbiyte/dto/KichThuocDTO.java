package webbanvali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KichThuocDTO {

	private Integer id;
	private String tenKichThuoc;
	private String code;
}
