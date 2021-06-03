package webbanvali.service;

import java.util.List;
import java.util.Optional;

import webbanvali.dto.NguoiDungDTO;
import webbanvali.entity.NguoiDung;

public interface NguoiDungService {

	NguoiDungDTO save(NguoiDungDTO nguoiDungDTO);
	NguoiDungDTO save1(NguoiDungDTO nguoiDungDTO);
	boolean themNguoiDungVaGoiEmail(NguoiDungDTO nguoiDungDTO, String host);
	boolean xacThucEmail(String email, String token);
	boolean goiEmailQuenMatKhau(String email,String host);
	boolean xacThucMatKhau(String email, String token, String matKhau);
	List<NguoiDungDTO> getDanhSachNguoiDungTheoEmailVaSoDienThoai(String email, String soDienThoai, int page, int size);
	Optional<NguoiDungDTO> getTheoMaNguoiDung(int maNguoiDung);
	boolean xoaNguoiDungTheoMaNguoiDung(int maNguoiDung);
	NguoiDungDTO getTheoEmail(String email);
	NguoiDung getBuoiDungTheoEmail(String mail);
	
	boolean capNhatTrangThaiVaRole(Integer id, boolean trangThai, String role);
	
	
}
