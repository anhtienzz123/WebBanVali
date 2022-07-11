package webbanvali.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbanvali.converter.BienTheValiConverter;
import webbanvali.dto.BienTheValiDTO;
import webbanvali.dto.CartBienTheValiDTO;
import webbanvali.dto.CartBienTheValiItemDTO;
import webbanvali.dto.CartDTO;
import webbanvali.dto.CartItemDTO;
import webbanvali.entity.BienTheVali;
import webbanvali.entity.ChiTietHoaDon;
import webbanvali.entity.HoaDon;
import webbanvali.entity.NguoiDung;
import webbanvali.repository.BienTheValiRepository;
import webbanvali.repository.HoaDonRepository;
import webbanvali.repository.NguoidungRepository;
import webbanvali.service.GioHangService;
import webbanvali.utils.ThongTinNguoiDung;
import webbanvali.utils.TrangThaiDonHangConstant;

@Service
@Transactional
public class GioHangServiceImpl implements GioHangService {

	@Autowired
	private BienTheValiRepository bienTheValiRepository;

	@Autowired
	private NguoidungRepository nguoiDungRepository;

	@Autowired
	private BienTheValiConverter bienTheValiConverter;

	@Autowired
	private HoaDonRepository hoaDonRepository;

	@Override
	public CartBienTheValiDTO convertCartDTOToCartBienTheValiDTO(CartDTO cartDTO) {

		List<CartBienTheValiItemDTO> cartBienTheValiItemDTOs = new ArrayList<>();

		for (CartItemDTO cartItemDTO : cartDTO.getCartItemDTOs()) {

			BienTheVali bienTheVali = bienTheValiRepository.findByValiSlugAndKichThuocCodeAndMauSacCode(cartItemDTO.getSlug(),
					cartItemDTO.getKichThuocCode(), cartItemDTO.getMauSacCode());
			
			BienTheValiDTO bienTheValiDTO = bienTheValiConverter.toBienTheValiDTO(
					bienTheVali);

			int soLuong = cartItemDTO.getSoLuong();
			
			boolean trangThai = bienTheVali.getSoLuong() <= soLuong ? true : false;
			
			CartBienTheValiItemDTO cartBienTheValiItemDTO = new CartBienTheValiItemDTO(bienTheValiDTO,
					cartItemDTO.getSoLuong(), trangThai);

			cartBienTheValiItemDTOs.add(cartBienTheValiItemDTO);
		}

		return new CartBienTheValiDTO(cartBienTheValiItemDTOs);
	}

	@Override
	public boolean datHang(CartDTO cartDTO) {

		if (cartDTO == null || cartDTO.getCartItemDTOs().isEmpty())
			return false;

		NguoiDung nguoiDung = nguoiDungRepository.findByEmail(ThongTinNguoiDung.getUsername());

		HoaDon hoaDon = new HoaDon();

		hoaDon.setId(RandomStringUtils.randomNumeric(9));
		hoaDon.setHoTenKhachHang(nguoiDung.getHoTen());
		hoaDon.setSoDienThoaiGiaoHang(nguoiDung.getSoDienThoai());
		hoaDon.setDiaChiGiaoHang(nguoiDung.getDiaChi());
		hoaDon.setEmail(nguoiDung.getEmail());
		hoaDon.setGhiChu("");
		hoaDon.setThoiGianDat(LocalDateTime.now());
		hoaDon.setTrangThaiDonHang(TrangThaiDonHangConstant.DANG_CHO_XU_LY);
		hoaDon.setNguoiDung(nguoiDung);

		List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<>();

		for (CartItemDTO cartItemDTO : cartDTO.getCartItemDTOs()) {

			BienTheVali bienTheVali = bienTheValiRepository.findByValiSlugAndKichThuocCodeAndMauSacCode(
					cartItemDTO.getSlug(), cartItemDTO.getKichThuocCode(), cartItemDTO.getMauSacCode());

			// nếu hết sản phẩm
			if (bienTheVali.getSoLuong() < cartItemDTO.getSoLuong()) {

				return false;
			}

			bienTheVali.setSoLuong(bienTheVali.getSoLuong() - cartItemDTO.getSoLuong());
			bienTheValiRepository.save(bienTheVali);

			ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
			chiTietHoaDon.setHoaDon(hoaDon);
			chiTietHoaDon.setBienTheVali(bienTheVali);
			chiTietHoaDon.setGia(bienTheVali.getGia());
			chiTietHoaDon.setKhuyenMai(bienTheVali.getKhuyenMai());
			chiTietHoaDon.setSoLuong(cartItemDTO.getSoLuong());

			chiTietHoaDons.add(chiTietHoaDon);

		}

		hoaDon.setChiTietHoaDons(chiTietHoaDons);
		hoaDonRepository.save(hoaDon);

		return true;
	}

}
