package webbanvali.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbanvali.converter.BinhLuanConverter;
import webbanvali.converter.CommentConverter;
import webbanvali.dto.BinhLuanDTO;
import webbanvali.dto.ValiCommentDTO;
import webbanvali.entity.BinhLuan;
import webbanvali.entity.BinhLuan_PK;
import webbanvali.entity.NguoiDung;
import webbanvali.entity.Vali;
import webbanvali.repository.BinhLuanRepository;
import webbanvali.repository.NguoidungRepository;
import webbanvali.repository.ValiRepository;
import webbanvali.service.BinhLuanService;
import webbanvali.utils.ThongTinNguoiDung;

@Service
@Transactional
public class BinhLuanServiceImpl implements BinhLuanService {

	@Autowired
	private ValiRepository valiRepository;

	@Autowired
	private BinhLuanRepository binhLuanRepository;
	@Autowired
	private NguoidungRepository nguoidungRepository;

	@Autowired
	private CommentConverter commonConverter;
	@Autowired
	private BinhLuanConverter binhLuanConverter;

	@Override
	public ValiCommentDTO getValiCommentTheoValiSlug(String valiSlug) {

		Optional<Vali> valiOpt = valiRepository.findBySlug(valiSlug);

		if (!valiOpt.isPresent())
			return null;

		return commonConverter.convertValiToValiCommentDTO(valiOpt.get());
	}

	@Override
	public List<BinhLuanDTO> getBinhLuans(String email) {
		List<BinhLuan> result = binhLuanRepository.findAllByNguoiDungEmail(email);

		return result.stream().map(hd -> binhLuanConverter.toBinhLuanDTO(hd)).collect(Collectors.toList());
	}

	@Override
	public boolean xoaBinhLuanTheoValiIdVaNguoiDungId(Integer valiID, Integer nguoiDungID) {

		binhLuanRepository.deleteById(new BinhLuan_PK(nguoiDungID, valiID));
		return true;
	}

	@Override
	public boolean themBinhLuan(String valiSlug, String noiDung, Integer soSao) {

		BinhLuan binhLuan = new BinhLuan();

		String email = ThongTinNguoiDung.getUsername();
		NguoiDung nguoiDung = nguoidungRepository.findByEmail(email);
		binhLuan.setNguoiDung(nguoiDung);

		Vali vali = valiRepository.findBySlug(valiSlug).get();
		binhLuan.setVali(vali);

		binhLuan.setNoiDung(noiDung);
		binhLuan.setDanhGia(soSao);

		binhLuan.setThoiGianBinhLuan(LocalDateTime.now());

		try {

			binhLuanRepository.save(binhLuan);

			return true;

		} catch (Exception e) {

		}
		;

		return false;

	}

}
