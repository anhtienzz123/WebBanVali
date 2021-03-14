package webbanvali.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import webbanvali.utils.TrangThaiDonHang;

@Data
@AllArgsConstructor
public class HoaDonDTO {

	private int id;

	private String hoTenKhachHang;
	private String soDienThoaiGiaoHang;
	private String diaChiGiaoHang;
	private String email;
	private String ghiChu;
	private LocalDate thoiGianDat;
	private TrangThaiDonHang trangThaiDonHang;

	private NguoiDungDTO nguoiDung;
	private List<ChiTietHoaDonDTO> chiTietHoaDons;

	public HoaDonDTO() {
		chiTietHoaDons = new ArrayList<>();
	}

	public void themChiTietHoaDon(BienTheValiDTO bienTheValiDTO) {

		for (ChiTietHoaDonDTO chiTietHoaDonDTOTempt : chiTietHoaDons) {
			// nếu đã có trong giỏ hàng
			if (chiTietHoaDonDTOTempt.getBienTheVali().equals(bienTheValiDTO) ) {
				chiTietHoaDonDTOTempt.setSoLuong(chiTietHoaDonDTOTempt.getSoLuong() + 1);
				return;
			}

		}
		// còn chưa có
		ChiTietHoaDonDTO chiTietHoaDonDTO = new ChiTietHoaDonDTO(this.id, bienTheValiDTO, bienTheValiDTO.getGia(),bienTheValiDTO.getKhuyenMai(), 1);
		chiTietHoaDons.add(chiTietHoaDonDTO);
	}

	public void giamChiTietHoaDon(BienTheValiDTO bienTheValiDTO) {

		for (ChiTietHoaDonDTO chiTietHoaDonDTOTempt : chiTietHoaDons) {

			// nếu đã có trong giỏ hàng
			if (chiTietHoaDonDTOTempt.getBienTheVali().equals(bienTheValiDTO) ) {

				if (chiTietHoaDonDTOTempt.getSoLuong() > 1)
					chiTietHoaDonDTOTempt.setSoLuong(chiTietHoaDonDTOTempt.getSoLuong() - 1);
				else
					xoaChiTietHoaDon(bienTheValiDTO);

				return;
			}
		}

	}

	public void xoaChiTietHoaDon(BienTheValiDTO bienTheValiDTO) {

		Iterator<ChiTietHoaDonDTO> chiTietHoaDonIterator = chiTietHoaDons.iterator();

		while (chiTietHoaDonIterator.hasNext()) {
			if (chiTietHoaDonIterator.next().getBienTheVali().equals(bienTheValiDTO)) {
				chiTietHoaDonIterator.remove();
				break;
			}

		}
	}

}
