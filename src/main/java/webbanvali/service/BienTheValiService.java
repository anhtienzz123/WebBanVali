package webbanvali.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import webbanvali.dto.BienTheValiAddDTO;
import webbanvali.dto.BienTheValiDTO;
import webbanvali.dto.BienTheValiTableDTO;
import webbanvali.dto.ChiTietBienTheValiDTO;
import webbanvali.dto.ChiTietValiDTO;

public interface BienTheValiService {

	BienTheValiDTO getTheoId(int valiId, int kichThuocId, int mauSacId);

	List<BienTheValiDTO> getBienTheValisTheoNhieuDieuKien(List<String> codeNhomValis, List<String> gias,
			List<String> codeThuongHieus, List<String> codeChatLieus, List<String> codeKichThuocs,
			List<String> codeMauSacs, List<String> codeTinhNangDacBiets, String loaiSapXep, int page, int size);
	
	List<BienTheValiDTO> getBienTheValisTheoTen(String tenVali);
	
	ChiTietValiDTO getChiTietValiDTO(String valiSlug, String kichThuocCode, String mauSacCode );
	
	List<BienTheValiDTO> getValisBanChay(int limit);
	List<BienTheValiDTO> getValisNoiBat(int limit);
	List<BienTheValiDTO> getValisKhuyenMai(int limit);
	
	boolean themBienTheVali(BienTheValiAddDTO bienTheValiAddDTO, MultipartFile file);
	boolean capNhatBienTheVali(BienTheValiAddDTO bienTheValiAddDTO, MultipartFile file);
	
	List<BienTheValiTableDTO> getBienTheValiTableDTOs();
	List<BienTheValiTableDTO> getBienTheValiTableDTOs(String tenVali, String tenKichThuoc, String tenMauSac);
	
	BienTheValiAddDTO getBienTheValiAdd(Integer valiId, Integer kichThuocId, Integer mauSacId);

	List<BienTheValiDTO> getBienTheValisTheoNhomVali(Integer nhomValiId);


	List<BienTheValiDTO> getBienTheValisTheoThuongHieu(Integer thuongHieuId);
	
	boolean xoa(Integer valiId, Integer kichThuocId, Integer mauSacId );
	
	ChiTietBienTheValiDTO getChiTietBienTheValiDTO(Integer valiId,Integer kichThuocId,Integer mauSacId);
	
}
