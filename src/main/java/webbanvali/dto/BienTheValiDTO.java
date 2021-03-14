package webbanvali.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BienTheValiDTO {

	private ValiDTO valiDTO;
	private KichThuocDTO kichThuocDTO;
	private MauSacDTO mauSacDTO;
	private double trongLuong;
	private String moTaKichThuoc;
	private double theTich;
	private double gia;
	private double khuyenMai;
	private long soLuong;
	private Set<String> tenAnhs;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BienTheValiDTO other = (BienTheValiDTO) obj;
		
		if(this.getValiDTO().getId().equals(other.getValiDTO().getId()) &&
		   this.getKichThuocDTO().getId().equals(other.getKichThuocDTO().getId()) &&
		   this.getMauSacDTO().getId().equals(other.getMauSacDTO().getId())) {
			return true;
		}
		
		return false;
		
		
	}
	
	
	 
	
}
