package webbanvali.converter;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import webbanvali.dto.NguoiDungDTO;
import webbanvali.entity.NguoiDung;
import webbanvali.utils.ROLE;

@Component
public class NguoiDungConverter {

	@Autowired
	private PasswordEncoder ps;

	public NguoiDung toNguoiDung(NguoiDungDTO nguoiDungDTO, NguoiDung nguoiDungOld) {

		if (nguoiDungDTO == null)
			return null;

		int id = nguoiDungDTO.getId();
		String email = nguoiDungDTO.getEmail();
		String hoTen = nguoiDungDTO.getHoTen();

		boolean gioiTinh = nguoiDungDTO.isGioiTinh();
		String soDienThoai = nguoiDungDTO.getSoDienThoai();

		// xử lí địa chỉ
		StringBuffer diaChiBuf = new StringBuffer(nguoiDungDTO.getDiaChi());
		diaChiBuf.append("," + nguoiDungDTO.getPhuongXa());
		diaChiBuf.append("," + nguoiDungDTO.getQuanHuyen());
		diaChiBuf.append("," + nguoiDungDTO.getTinhThanhPho());
		String diaChi = diaChiBuf.toString();

		ROLE vaiTro = nguoiDungDTO.getVaiTro() == null ? nguoiDungOld.getVaiTro() : nguoiDungDTO.getVaiTro();
		String matKhau = nguoiDungOld.getMatKhau();
		boolean trangThai = nguoiDungOld.isTrangThai();
		String maXacNhan = nguoiDungOld.getMaXacNhan();

		NguoiDung nguoiDung = new NguoiDung(id, hoTen, gioiTinh, soDienThoai, diaChi, email, matKhau, vaiTro, maXacNhan,
				trangThai);

		return nguoiDung;
	}

	public NguoiDung toNguoiDung1(NguoiDungDTO nguoiDungDTO, NguoiDung nguoiDungOld) {

		if (nguoiDungDTO == null)
			return null;

		int id = nguoiDungDTO.getId();
		String email = nguoiDungDTO.getEmail();
		String hoTen = nguoiDungDTO.getHoTen();

		boolean gioiTinh = nguoiDungDTO.isGioiTinh();
		String soDienThoai = nguoiDungDTO.getSoDienThoai();

		// xử lí địa chỉ
		StringBuffer diaChiBuf = new StringBuffer(nguoiDungDTO.getDiaChi());
		diaChiBuf.append("," + nguoiDungDTO.getPhuongXa());
		diaChiBuf.append("," + nguoiDungDTO.getQuanHuyen());
		diaChiBuf.append("," + nguoiDungDTO.getTinhThanhPho());
		String diaChi = diaChiBuf.toString();

		ROLE vaiTro = nguoiDungDTO.getVaiTro() == null ? nguoiDungOld.getVaiTro() : nguoiDungDTO.getVaiTro();
		String matKhau = nguoiDungDTO.getMatKhau();
		boolean trangThai = nguoiDungOld.isTrangThai();
		String maXacNhan = nguoiDungOld.getMaXacNhan();

		NguoiDung nguoiDung = new NguoiDung(id, hoTen, gioiTinh, soDienThoai, diaChi, email, matKhau, vaiTro, maXacNhan,
				trangThai);

		return nguoiDung;
	}

	public NguoiDungDTO toNguoiDungDTO(NguoiDung nguoiDung) {

		if (nguoiDung == null)
			return null;

		int maNguoiDung = nguoiDung.getId();
		String email = nguoiDung.getEmail();
		String matKhau = nguoiDung.getMatKhau();

		String hoTen = nguoiDung.getHoTen();
		boolean gioiTinh = nguoiDung.isGioiTinh();
		String soDienThoai = nguoiDung.getSoDienThoai();

		// xu lí địa chỉ
		String diaChi = null;
		String tinhThanhPho = null;
		String quanHuyen = null;
		String phuongXa = null;

		if (nguoiDung.getDiaChi() != null) {
			String[] diaChiTempt = nguoiDung.getDiaChi().split(",");
			diaChi = diaChiTempt[0];
			phuongXa = diaChiTempt[1];
			quanHuyen = diaChiTempt[2];
			tinhThanhPho = diaChiTempt[3];
		}
		ROLE vaiTro = nguoiDung.getVaiTro();
		boolean trangThai = nguoiDung.isTrangThai();

		/*
		 * NguoiDungDTO NguoiDungDTO = new NguoiDungDTO(maNguoiDung, hoTen, gioiTinh,
		 * soDienThoai, diaChi, phuongXa, quanHuyen, tinhThanhPho, email, vaiTro,
		 * trangThai);
		 */
		NguoiDungDTO nguoiDungDTO2 = new NguoiDungDTO(maNguoiDung, hoTen, gioiTinh, soDienThoai, diaChi, phuongXa,
				quanHuyen, tinhThanhPho, email, matKhau, vaiTro, trangThai);

		return nguoiDungDTO2;
	}

}
