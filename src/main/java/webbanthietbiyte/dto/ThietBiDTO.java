package webbanvali.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValiDTO {

	private Integer id;
	private String tenVali;
	private String slug;
	private String banhXe;
	private String dayKeo;
	private String khoa;
	private String thoiGianBaoHanh;
	
	private List<MoTaValiDTO> moTaValis;
	private List<TinhNangDacBietDTO> tinhNangDacBiets;
//	private List<BienTheValiDTO> bienTheValis;
	
	private ChatLieuDTO chatLieuDTO;
	private ThuongHieuDTO thuongHieuDTO;
	private NhomValiDTO nhomVali;
	
	

}
