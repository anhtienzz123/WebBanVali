package webbanvali.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietValiDTO {
    
	private String valiSlug;
	private String kichThuocCode;
	private String mauSacCode;
	private String tenVali;
    private int soDanhGia;
    private String thuongHieu;
    private int thuongHieuId;
    private int nhomValiId;
    private  String gia;
    private String giaGoc;
    private double khuyenMai;
    private String moTa;
    private String tenChatLieu;
    private String banhXe;
    private String dayKeo;
    private String khoa;
    private String thoiGianBaoHanh;
    private String theTich;
    private String trongLuong;
    private String moTaKichThuoc;
    private String tenAnh;
    
    private List<LoaiBienTheValiDTO> kichThuocs;
    private List<LoaiBienTheValiDTO> mauSacs;
    
    
   
}
