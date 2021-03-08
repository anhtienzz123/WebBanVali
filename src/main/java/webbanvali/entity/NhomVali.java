package webbanvali.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NhomVali implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private String maNhomVali;
	private String tenNhomVali;
	private String slug;
	
	@OneToMany(mappedBy = "nhomVali")
	private List<Vali> valis;
	
}
