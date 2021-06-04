package webbanvali.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import webbanvali.converter.NguoiDungConverter;
import webbanvali.dto.NguoiDungDTO;
import webbanvali.entity.NguoiDung;
import webbanvali.repository.NguoidungRepository;
import webbanvali.service.NguoiDungService;
import webbanvali.utils.EmailSender;
import webbanvali.utils.ROLE;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {

	@Autowired
	private NguoidungRepository nguoiDungRepository;

	@Autowired
	private NguoiDungConverter nguoiDungConverter;

	@Autowired
	private EmailSender emailSender;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public boolean themNguoiDungVaGoiEmail(NguoiDungDTO nguoiDungDTO, String host) {

		boolean result = false;

		try {

			String maXacNhan = RandomStringUtils.randomAlphanumeric(20);
			nguoiDungDTO.setVaiTro(ROLE.ROLE_USER);

			// lưu xuống
			int maNguoiDung = nguoiDungRepository.save(new NguoiDung(nguoiDungDTO.getId(), nguoiDungDTO.getHoTen(),
					nguoiDungDTO.getEmail(), passwordEncoder.encode(nguoiDungDTO.getMatKhau()), ROLE.ROLE_USER,
					LocalDate.now(), "38 Đường số 1,Phường 04,Quận Gò Vấp,Thành phố Hồ Chí Minh", "")).getId();

			// tạo ra mã xác thực
			NguoiDung nguoiDungDaLuu = nguoiDungRepository.findById(maNguoiDung).get();
			nguoiDungDaLuu.setMaXacNhan(maXacNhan);

			nguoiDungRepository.save(nguoiDungDaLuu);

			// gởi email
			String linkXacThuc = host + "/WebBanVali/xac-thuc-email?email=" + nguoiDungDTO.getEmail() + "&token="
					+ maXacNhan;
			emailSender.sendEmail(nguoiDungDTO.getEmail(), "Xác thực email", linkXacThuc);

			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean xacThucEmail(String email, String token) {

		NguoiDung nguoiDung = nguoiDungRepository.findByEmail(email);

		if (nguoiDung == null)
			return false;

		if (nguoiDung.getMaXacNhan().equals(token)) {
			nguoiDung.setTrangThai(true);

			nguoiDungRepository.save(nguoiDung);

			return true;
		}

		return false;
	}

	@Override
	public NguoiDungDTO save(NguoiDungDTO nguoiDungDTO) {

		if (nguoiDungDTO == null)
			return null;

		NguoiDung nguoiDungOld = nguoiDungRepository.findById(nguoiDungDTO.getId()).get();

		NguoiDung nguoiDungResult = nguoiDungRepository
				.save(nguoiDungConverter.toNguoiDung(nguoiDungDTO, nguoiDungOld));

		NguoiDungDTO nguoiDungDTOResult = nguoiDungConverter.toNguoiDungDTO(nguoiDungResult);

		return nguoiDungDTOResult;
	}

	@Override
	public NguoiDungDTO save1(NguoiDungDTO nguoiDungDTO) {

		if (nguoiDungDTO == null)
			return null;

		NguoiDung nguoiDungOld = nguoiDungRepository.findById(nguoiDungDTO.getId()).get();

		NguoiDung nguoiDungResult = nguoiDungRepository
				.save(nguoiDungConverter.toNguoiDung1(nguoiDungDTO, nguoiDungOld));

		NguoiDungDTO nguoiDungDTOResult = nguoiDungConverter.toNguoiDungDTO(nguoiDungResult);

		return nguoiDungDTOResult;
	}

	@Override
	public boolean goiEmailQuenMatKhau(String email, String host) {

		NguoiDung nguoiDung = nguoiDungRepository.findByEmailAndTrangThai(email, true);

		if (nguoiDung == null)
			return false;

		String randomMaXacNhan = RandomStringUtils.randomAlphanumeric(20);
		nguoiDung.setMaXacNhan(randomMaXacNhan);

		nguoiDungRepository.save(nguoiDung);

		String content = "http://" + host + "/WebBanVali/quen-mat-khau/nhap-mat-khau?email=" + email + "&token="
				+ randomMaXacNhan;
		emailSender.sendEmail(email, "Quên mật khẩu", content);

		return true;
	}

	@Override
	public boolean xacThucMatKhau(String email, String token, String matKhau) {

		NguoiDung nguoiDung = nguoiDungRepository.findByEmailAndTrangThai(email, true);

		if (nguoiDung == null)
			return false;

		if (nguoiDung.getMaXacNhan().equals(token)) {
			nguoiDung.setMatKhau(passwordEncoder.encode(matKhau));

			nguoiDungRepository.save(nguoiDung);

			return true;
		}

		return false;
	}

	@Override
	public List<NguoiDungDTO> getDanhSachNguoiDungTheoEmailVaSoDienThoai(String email, String soDienThoai, int page,
			int size) {

		List<NguoiDungDTO> nguoiDungDTOs = new ArrayList<NguoiDungDTO>();

		List<NguoiDung> nguoiDungs = nguoiDungRepository.findAllByEmailContainingAndSoDienThoaiContainingAllIgnoreCase(
				email, soDienThoai, PageRequest.of(page, size));

		for (NguoiDung nguoiDung : nguoiDungs) {

			nguoiDungDTOs.add(nguoiDungConverter.toNguoiDungDTO(nguoiDung));
		}

		return nguoiDungDTOs;
	}

	@Override
	public Optional<NguoiDungDTO> getTheoMaNguoiDung(int maNguoiDung) {

		NguoiDung nguoiDung = nguoiDungRepository.findById(maNguoiDung).orElse(null);

		Optional<NguoiDungDTO> nguoiDungOptional = Optional.ofNullable(nguoiDungConverter.toNguoiDungDTO(nguoiDung));

		return nguoiDungOptional;
	}

	@Override
	public boolean xoaNguoiDungTheoMaNguoiDung(int maNguoiDung) {

		if (!nguoiDungRepository.existsById(maNguoiDung))
			return false;

		try {

			nguoiDungRepository.delete(nguoiDungRepository.findById(maNguoiDung).get());

			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public NguoiDungDTO getTheoEmail(String email) {

		NguoiDung nguoiDung = nguoiDungRepository.findByEmail(email);

		return nguoiDungConverter.toNguoiDungDTO(nguoiDung);
	}

	@Override
	public NguoiDung getBuoiDungTheoEmail(String mail) {
		NguoiDung nguoiDung = nguoiDungRepository.findByEmail(mail);
		if (nguoiDung == null)
			return null;

		return nguoiDung;

	}

	@Override
	public boolean capNhatTrangThaiVaRole(Integer id, boolean trangThai, String role) {

		if (!nguoiDungRepository.existsById(id)) {
			return false;
		}

		NguoiDung nguoiDung = nguoiDungRepository.findById(id).get();

		nguoiDung.setTrangThai(trangThai);

		nguoiDung.setVaiTro(ROLE.valueOf(role));

		nguoiDungRepository.save(nguoiDung);

		return true;
	}

}
