package webbanvali.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class BinhLuan_PK  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer nguoiDung;
	private Integer vali;
	
}
