package webbanvali.service.impl;

import static webbanvali.utils.BienTheValiSpecification.hasCodeChatLieus;
import static webbanvali.utils.BienTheValiSpecification.hasCodeKichThuocs;
import static webbanvali.utils.BienTheValiSpecification.hasCodeMauSacs;
import static webbanvali.utils.BienTheValiSpecification.hasCodeNhomValis;
import static webbanvali.utils.BienTheValiSpecification.hasCodeThuongHieus;
import static webbanvali.utils.BienTheValiSpecification.hasCodeTinhNangDacBiets;
import static webbanvali.utils.BienTheValiSpecification.hasKhoangGias;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import webbanvali.converter.BienTheValiConverter;
import webbanvali.dto.BienTheValiAddDTO;
import webbanvali.dto.BienTheValiDTO;
import webbanvali.dto.BienTheValiTableDTO;
import webbanvali.dto.ChiTietBienTheValiDTO;
import webbanvali.dto.ChiTietValiDTO;
import webbanvali.entity.BienTheVali;
import webbanvali.entity.BienTheVali_PK;
import webbanvali.entity.Vali;
import webbanvali.repository.BienTheValiRepository;
import webbanvali.service.BienTheValiService;
import webbanvali.utils.ChuoiConstant;
import webbanvali.utils.FileUploadProcessor;
import webbanvali.utils.XuLyTien;

@Service
@Transactional
public class BienTheValiServiceImpl implements BienTheValiService {

	@Autowired
	private BienTheValiRepository bienTheValiRepository;

	@Autowired
	private BienTheValiConverter bienTheValiConverter;
	@Autowired
	private FileUploadProcessor fileUploadProcessor;

	@Override
	public BienTheValiDTO getTheoId(int valiId, int kichThuocId, int mauSacId) {

		Optional<BienTheVali> tempt = bienTheValiRepository.findById(new BienTheVali_PK(valiId, kichThuocId, mauSacId));

		if (tempt.isPresent()) {
			return bienTheValiConverter.toDTO(tempt.get());
		}

		return null;
	}

	@Override
	public List<BienTheValiDTO> getBienTheValisTheoNhieuDieuKien(List<String> codeNhomValis, List<String> gias,
			List<String> codeThuongHieus, List<String> codeChatLieus, List<String> codeKichThuocs,
			List<String> codeMauSacs, List<String> codeTinhNangDacBiets, String loaiSapXep, int page, int size) {

		Specification<BienTheVali> dieuKien = Specification.where(hasCodeNhomValis(codeNhomValis))
				.and(hasKhoangGias(gias)).and(hasCodeThuongHieus(codeThuongHieus)).and(hasCodeChatLieus(codeChatLieus))
				.and(hasCodeKichThuocs(codeKichThuocs)).and(hasCodeMauSacs(codeMauSacs))
				.and(hasCodeTinhNangDacBiets(codeTinhNangDacBiets));

		Sort sort = Sort.unsorted();

		if (loaiSapXep != null) {

			if (loaiSapXep.equals(ChuoiConstant.GIA_TANG_DAN)) {

				sort = Sort.by("gia").ascending();
			}

			if (loaiSapXep.equals(ChuoiConstant.GIA_GIAM_DAN)) {

				sort = Sort.by("gia").descending();
			}

			if (loaiSapXep.equals(ChuoiConstant.KHUYEN_MAI)) {

				sort = Sort.by("khuyenMai").ascending();
			}

		}

		return bienTheValiRepository.findAll(dieuKien, PageRequest.of(page, size, sort)).stream()
				.map(s -> bienTheValiConverter.toBienTheValiDTO(s)).collect(Collectors.toList());
	}
	
	@Override
	public List<BienTheValiDTO> getBienTheValisTheoTen(String tenVali) {
		
		return bienTheValiRepository.findByValiTenValiContaining(tenVali, PageRequest.of(0,1000)).stream()
				.map(s -> bienTheValiConverter.toBienTheValiDTO(s)).collect(Collectors.toList());
	}

	@Override
	public ChiTietValiDTO getChiTietValiDTO(String valiSlug, String kichThuocCode, String mauSacCode) {

		BienTheVali bienTheVali = bienTheValiRepository.findByValiSlugAndKichThuocCodeAndMauSacCode(valiSlug,
				kichThuocCode, mauSacCode);

		return bienTheValiConverter.toChiTietValiDTO(bienTheVali);
	}

	@Override
	public List<BienTheValiDTO> getValisBanChay(int limit) {

		return bienTheValiRepository.getValisBanChay(limit).stream().map(s -> bienTheValiConverter.toBienTheValiDTO(s))
				.collect(Collectors.toList());
	}

	@Override
	public List<BienTheValiDTO> getValisNoiBat(int limit) {

		return bienTheValiRepository.findAllByNoiBatTrue(PageRequest.of(0, limit)).stream()
				.map(s -> bienTheValiConverter.toBienTheValiDTO(s)).collect(Collectors.toList());
	}

	@Override
	public List<BienTheValiDTO> getValisKhuyenMai(int size) {

		return bienTheValiRepository.findAllByOrderByKhuyenMaiDesc(PageRequest.of(0, size)).stream()
				.map(s -> bienTheValiConverter.toBienTheValiDTO(s)).collect(Collectors.toList());
	}

	@Override

	public List<BienTheValiDTO> getBienTheValisTheoThuongHieu(Integer thuongHieuId) {

		return bienTheValiRepository.findAllByTenThuongHieu(thuongHieuId).stream()
				.map(s -> bienTheValiConverter.toBienTheValiDTO(s)).collect(Collectors.toList());

	}

	@Override
	public List<BienTheValiDTO> getBienTheValisTheoNhomVali(Integer nhomValiId) {
		return bienTheValiRepository.findAllByNhomVali(nhomValiId).stream()
				.map(s -> bienTheValiConverter.toBienTheValiDTO(s)).collect(Collectors.toList());
	}

	@Override
	public boolean themBienTheVali(BienTheValiAddDTO bienTheValiAddDTO, MultipartFile file) {

		try {
			String fileName = fileUploadProcessor.saveFile(file);
			bienTheValiAddDTO.setTenAnh(fileName);
			bienTheValiRepository.save(bienTheValiConverter.toBienTheVali(bienTheValiAddDTO));

			return true;
		} catch (Exception e) {

		}
		;

		return false;

	}

	@Override
	public List<BienTheValiTableDTO> getBienTheValiTableDTOs() {
		return bienTheValiRepository.findAll().stream().map(s -> bienTheValiConverter.toBienTheValiTableDTO(s))
				.collect(Collectors.toList());
	}

	@Override
	public List<BienTheValiTableDTO> getBienTheValiTableDTOs(String tenVali, String tenKichThuoc, String tenMauSac) {

		return bienTheValiRepository
				.findByValiTenValiContainingAndKichThuocCodeContainingAndMauSacCodeContaining(tenVali, tenKichThuoc,
						tenMauSac)
				.stream().map(s -> bienTheValiConverter.toBienTheValiTableDTO(s)).collect(Collectors.toList());
	}

	@Override
	public BienTheValiAddDTO getBienTheValiAdd(Integer valiId, Integer kichThuocId, Integer mauSacId) {

		BienTheVali bienTheVali = bienTheValiRepository.findById(new BienTheVali_PK(valiId, kichThuocId, mauSacId))
				.get();

		return bienTheValiConverter.toBienTheValiAddDTO(bienTheVali);
	}

	@Override
	public boolean capNhatBienTheVali(BienTheValiAddDTO bienTheValiAddDTO, MultipartFile file) {

		try {

			if (file.getOriginalFilename().trim().equals("")) {

				bienTheValiRepository.save(bienTheValiConverter.toBienTheVali(bienTheValiAddDTO));

			} else {
				fileUploadProcessor.deleteFile(bienTheValiAddDTO.getTenAnh());
				String fileName = fileUploadProcessor.saveFile(file);
				bienTheValiAddDTO.setTenAnh(fileName);
				bienTheValiRepository.save(bienTheValiConverter.toBienTheVali(bienTheValiAddDTO));
			}

			return true;
		} catch (Exception e) {

		}
		;

		return false;

	}

	@Override
	public boolean xoa(Integer id, Integer kichThuocId, Integer mauSacId) {

		try {

			bienTheValiRepository.deleteById(new BienTheVali_PK(id, kichThuocId, mauSacId));

			return true;

		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public ChiTietBienTheValiDTO getChiTietBienTheValiDTO(Integer valiId, Integer kichThuocId, Integer mauSacId) {
		BienTheVali bienTheVali = bienTheValiRepository.findById(new BienTheVali_PK(valiId, kichThuocId, mauSacId))
				.get();
		Vali vali = bienTheVali.getVali();

		ChiTietBienTheValiDTO result = new ChiTietBienTheValiDTO();

		result.setTenVali(vali.getTenVali());
		result.setTenKichThuoc(bienTheVali.getKichThuoc().getTenKichThuoc());
		result.setTenMau(bienTheVali.getMauSac().getTenMau());
		result.setBanhXe(vali.getBanhXe());
		result.setDayKeo(vali.getDayKeo());
		result.setKhoa(vali.getKhoa());
		result.setThoiGianBaoHanh(vali.getThoiGianBaoHanh());
		result.setTheTich(bienTheVali.getTheTich());
		result.setTrongLuong(bienTheVali.getTrongLuong());
		result.setMoTaKichThuoc(bienTheVali.getMoTaKichThuoc());
		result.setNoiBat(bienTheVali.isNoiBat());
		result.setTenChatLieu(vali.getChatLieu().getTenChatLieu());
		result.setTenNhomVali(vali.getNhomVali().getTenNhomVali());
		result.setTenThuongHieu(vali.getThuongHieu().getTenThuongHieu());
		result.setGia(XuLyTien.dinhDangTien(bienTheVali.getGia()));
		result.setKhuyenMai(bienTheVali.getKhuyenMai());
		result.setSoLuong(bienTheVali.getSoLuong());
		result.setAnh(bienTheVali.getTenAnh());
		result.setMoTa(vali.getMoTa());

		return result;
	}

	
	
}
