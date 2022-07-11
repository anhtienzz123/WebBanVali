package webbanvali.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PhuongXa implements Serializable {

	
private static final long serialVersionUID = 1L;
	
	@Id
	private String maPhuongXa;
	
	private String ten;
	private String loai;
	
	private String maQuanHuyen;
}
