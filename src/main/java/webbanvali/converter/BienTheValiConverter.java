package webbanvali.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webbanvali.dto.BienTheValiAddDTO;
import webbanvali.dto.BienTheValiDTO;
import webbanvali.dto.BienTheValiTableDTO;
import webbanvali.dto.ChiTietValiDTO;
import webbanvali.dto.KichThuocDTO;
import webbanvali.dto.LoaiBienTheValiDTO;
import webbanvali.dto.MauSacDTO;
import webbanvali.dto.ValiDTO;
import webbanvali.entity.BienTheVali;
import webbanvali.entity.KichThuoc;
import webbanvali.entity.MauSac;
import webbanvali.entity.Vali;
import webbanvali.repository.BienTheValiRepository;
import webbanvali.repository.KichThuocRepository;
import webbanvali.repository.MauSacRepository;
import webbanvali.repository.ValiRepository;
import webbanvali.utils.XuLyTien;

@Component
public class BienTheValiConverter {

	@Autowired
	private ValiConverter valiConverter;

	@Autowired
	private BienTheValiRepository bienTheValiRepository;
	@Autowired
	private ValiRepository valiRepository;
	@Autowired
	private KichThuocRepository kichThuocRepository;
	@Autowired
	private MauSacRepository mauSacRepository;

	public BienTheValiDTO toDTO(BienTheVali bienTheVali) {

		String trongLuong = bienTheVali.getTrongLuong();
		String moTaKichThuoc = bienTheVali.getMoTaKichThuoc();
		String theTich = bienTheVali.getTheTich();
		double gia = bienTheVali.getGia();
		double khuyenMai = bienTheVali.getKhuyenMai();
		long soLuong = bienTheVali.getSoLuong();
		Set<String> tenAnhs = new HashSet<String>(bienTheVali.getTenAnhs());

		ValiDTO valiDTO = Optional.ofNullable(bienTheVali.getVali()).map(s -> valiConverter.toDTO(s)).orElse(null);
		KichThuocDTO kichThuocDTO = Optional.ofNullable(bienTheVali.getKichThuoc()).map(s -> {
			return new KichThuocDTO(s.getId(), s.getTenKichThuoc(), s.getCode());
		}).orElse(null);
		MauSacDTO mauSacDTO = Optional.ofNullable(bienTheVali.getMauSac()).map(s -> {
			return new MauSacDTO(s.getId(), s.getTenMau(), s.getCode());
		}).orElse(null);

//		return new BienTheValiDTO(valiDTO, kichThuocDTO, mauSacDTO, trongLuong, moTaKichThuoc, theTich, gia, khuyenMai,
//				soLuong, tenAnhs);

		return null;
	}

	public ChiTietValiDTO toChiTietValiDTO(BienTheVali bienTheVali) {

		String valiSlug = bienTheVali.getVali().getSlug();
		String kichThuocCode = bienTheVali.getKichThuoc().getCode();
		String mauSacCode = bienTheVali.getMauSac().getCode();

		String tenVali = bienTheVali.getVali().getTenVali() + " " + bienTheVali.getKichThuoc().getTenKichThuoc() + " "
				+ bienTheVali.getMauSac().getTenMau();
		int soDanhGia = bienTheVali.getVali().getBinhLuans().size();
		String thuongHieu = bienTheVali.getVali().getThuongHieu().getTenThuongHieu();
		int thuongHieuId = bienTheVali.getVali().getThuongHieu().getId();
		int nhomValiId = bienTheVali.getVali().getNhomVali().getId();
		String giaGoc = XuLyTien.dinhDangTien(bienTheVali.getGia());
		double khuyenMai = bienTheVali.getKhuyenMai();
		String gia = XuLyTien.dinhDangTien(bienTheVali.getGia() - ((bienTheVali.getGia() * 1.0 / 100) * khuyenMai));

		String moTa = bienTheVali.getVali().getMoTa();
		String tenChatLieu = bienTheVali.getVali().getChatLieu().getTenChatLieu();
		String banhXe = bienTheVali.getVali().getBanhXe();
		String dayKeo = bienTheVali.getVali().getDayKeo();
		String khoa = bienTheVali.getVali().getKhoa();
		String thoiGianBaoHanh = bienTheVali.getVali().getThoiGianBaoHanh();
		String theTich = bienTheVali.getTheTich();
		String trongLuong = bienTheVali.getTrongLuong();
		String moTaKichThuoc = bienTheVali.getMoTaKichThuoc();
		String tenAnh = bienTheVali.getTenAnh();
		System.out.println("tenAnh: " + tenAnh);

		String tenMauSac = bienTheVali.getMauSac().getTenMau();
		String tenKichThuoc = bienTheVali.getKichThuoc().getTenKichThuoc();

		Integer validId = bienTheVali.getVali().getId();

		List<LoaiBienTheValiDTO> kichThuocs = new ArrayList<>();
		for (Object[] kichThuocTempt : bienTheValiRepository.getKichThuocsTheoValiId(validId)) {

			String ten = (String) kichThuocTempt[0];
			String code = bienTheVali.getVali().getSlug() + "?kichThuoc=" + kichThuocTempt[1] + "&mauSac="
					+ kichThuocTempt[2];
			double giaTempt = (double) kichThuocTempt[3];
			double khuyenMaiTempt = (double) kichThuocTempt[4];
			String giaStringTempt = XuLyTien.dinhDangTien(giaTempt - ((giaTempt * 1.0 / 100) * khuyenMaiTempt));
			boolean chon = ten.equals(tenKichThuoc);

			kichThuocs.add(new LoaiBienTheValiDTO(ten, code, giaStringTempt, chon));

		}

		List<LoaiBienTheValiDTO> mauSacs = new ArrayList<>();
		for (Object[] mauSacTempt : bienTheValiRepository.getMauSacsTheoValiIdVaKichThuocId(validId,
				bienTheVali.getKichThuoc().getId())) {
			String ten = (String) mauSacTempt[0];
			String code = bienTheVali.getVali().getSlug() + "?kichThuoc=" + bienTheVali.getKichThuoc().getCode()
					+ "&mauSac=" + mauSacTempt[1];
			double giaTempt = (double) mauSacTempt[2];
			double khuyenMaiTempt = (double) mauSacTempt[3];
			String giaStringTempt = XuLyTien.dinhDangTien(giaTempt - ((giaTempt * 1.0 / 100) * khuyenMaiTempt));
			boolean chon = ten.equals(tenMauSac);

			mauSacs.add(new LoaiBienTheValiDTO(ten, code, giaStringTempt, chon));
		}

		return new ChiTietValiDTO(valiSlug, kichThuocCode, mauSacCode, tenVali, soDanhGia, thuongHieu, thuongHieuId,
				nhomValiId, gia, giaGoc, khuyenMai, moTa, tenChatLieu, banhXe, dayKeo, khoa, thoiGianBaoHanh, theTich,
				trongLuong, moTaKichThuoc, tenAnh, kichThuocs, mauSacs);
	}

	public BienTheValiDTO toBienTheValiDTO(BienTheVali bienTheVali) {

		String valiSlug = bienTheVali.getVali().getSlug();
		String kichThuocCode = bienTheVali.getKichThuoc().getCode();
		String mauSacCode = bienTheVali.getMauSac().getCode();
		String tenVali = bienTheVali.getVali().getTenVali() + " " + bienTheVali.getKichThuoc().getTenKichThuoc() + " "
				+ bienTheVali.getMauSac().getTenMau();
		double khuyenMai = bienTheVali.getKhuyenMai();
		String gia = XuLyTien.dinhDangTien(bienTheVali.getGia() - ((bienTheVali.getGia() * 1.0 / 100) * khuyenMai));
		double giaGoc = bienTheVali.getGia();
		String giaGocString = XuLyTien.dinhDangTien(bienTheVali.getGia());
		String tenAnh = bienTheVali.getTenAnh();

		return new BienTheValiDTO(valiSlug, kichThuocCode, mauSacCode, tenVali, giaGoc, gia,giaGocString, khuyenMai, tenAnh);

	}

	public BienTheVali toBienTheVali(BienTheValiAddDTO bienTheValiAddDTO) {

		BienTheVali bienTheVali = new BienTheVali();

		Vali vali = valiRepository.findByTenVali(bienTheValiAddDTO.getTenVali());
		bienTheVali.setVali(vali);

		KichThuoc kichThuoc = kichThuocRepository.findByTenKichThuoc(bienTheValiAddDTO.getTenKichThuoc());
		bienTheVali.setKichThuoc(kichThuoc);

		MauSac mauSac = mauSacRepository.findByTenMau(bienTheValiAddDTO.getTenMauSac());
		bienTheVali.setMauSac(mauSac);

		bienTheVali.setTrongLuong(bienTheValiAddDTO.getTrongLuong());
		bienTheVali.setTheTich(bienTheValiAddDTO.getTheTich());
		bienTheVali.setMoTaKichThuoc(bienTheValiAddDTO.getMoTaKichThuoc());
		bienTheVali.setGia(bienTheValiAddDTO.getGia());
		bienTheVali.setKhuyenMai(bienTheValiAddDTO.getKhuyenMai());
		bienTheVali.setSoLuong(bienTheValiAddDTO.getSoLuong());
		bienTheVali.setNoiBat(bienTheValiAddDTO.isNoiBat());
		bienTheVali.setTenAnh(bienTheValiAddDTO.getTenAnh());

		return bienTheVali;
	}

	public BienTheValiTableDTO toBienTheValiTableDTO(BienTheVali bienTheVali) {

		BienTheValiTableDTO bienTheValiTableDTO = new BienTheValiTableDTO();
		bienTheValiTableDTO.setValiId(bienTheVali.getVali().getId());
		bienTheValiTableDTO.setTenVali(bienTheVali.getVali().getTenVali());
		bienTheValiTableDTO.setKichThuocId(bienTheVali.getKichThuoc().getId());
		bienTheValiTableDTO.setTenKichThuoc(bienTheVali.getKichThuoc().getTenKichThuoc());
		bienTheValiTableDTO.setMauSacId(bienTheVali.getMauSac().getId());
		bienTheValiTableDTO.setTenMauSac(bienTheVali.getMauSac().getTenMau());
		bienTheValiTableDTO.setSoLuong(bienTheVali.getSoLuong());
		bienTheValiTableDTO.setGia(bienTheVali.getGia());
		bienTheValiTableDTO.setKhuyenMai(bienTheVali.getKhuyenMai());
		bienTheValiTableDTO.setNoiBat(bienTheVali.isNoiBat());

		return bienTheValiTableDTO;

	}

	public BienTheValiAddDTO toBienTheValiAddDTO(BienTheVali bienTheVali) {

		BienTheValiAddDTO bienTheValiAddDTO = new BienTheValiAddDTO();

		bienTheValiAddDTO.setValiId(bienTheVali.getVali().getId());
		bienTheValiAddDTO.setKichThuocId(bienTheVali.getKichThuoc().getId());
		bienTheValiAddDTO.setMauSacId(bienTheVali.getMauSac().getId());
		bienTheValiAddDTO.setTenVali(bienTheVali.getVali().getTenVali());
		bienTheValiAddDTO.setTenKichThuoc(bienTheVali.getKichThuoc().getTenKichThuoc());
		bienTheValiAddDTO.setTenMauSac(bienTheVali.getMauSac().getTenMau());
		bienTheValiAddDTO.setGia(bienTheVali.getGia());
		bienTheValiAddDTO.setKhuyenMai(bienTheVali.getKhuyenMai());
		bienTheValiAddDTO.setSoLuong(bienTheVali.getSoLuong());
		bienTheValiAddDTO.setTheTich(bienTheVali.getTheTich());
		bienTheValiAddDTO.setTrongLuong(bienTheVali.getTrongLuong());
		bienTheValiAddDTO.setMoTaKichThuoc(bienTheVali.getMoTaKichThuoc());
		bienTheValiAddDTO.setNoiBat(bienTheVali.isNoiBat());
		bienTheValiAddDTO.setTenAnh(bienTheVali.getTenAnh());

		return bienTheValiAddDTO;

	}
}
