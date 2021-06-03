package webbanvali.service;

import java.util.List;
import java.util.Map;

import webbanvali.dto.KeyValueDTO;
import webbanvali.dto.ValiChungDTO;
import webbanvali.dto.ValiChungResponseDTO;
import webbanvali.dto.ValiDTO;
import webbanvali.entity.Vali;

public interface ValiService {

	ValiDTO getValiTheoMaVali(Integer maVali);

	Map<String, List<KeyValueDTO>> getTieuChiTimKiem();

	List<ValiChungResponseDTO> getValiChungTheoTenValiVaChatLieuVaNhomValiVaThuongHieu(String tenVali, String chatLieu,
			String nhomVali, String thuongHieu);

	Map<String, List<String>> getTenOfTinhNangVaChatLieuVaThuongVaNhomVali();
	Map<String, List<String>> getTenOfValiVaKichThuocVaMauSac();
	boolean themVali(ValiChungDTO valiChungDTO);
	boolean capNhatVali(Integer id ,ValiChungDTO valiChungDTO);

	Vali getValiTheoID(Integer maVali);
	
	ValiChungDTO getValiChungById(Integer id);
	
	boolean xoa(Integer id);
}
