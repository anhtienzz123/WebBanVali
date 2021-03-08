package webbanvali.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HoaDonDTO {

	private String maHoaDon;

	private String hoTenKhachHang;
	private String diaChiGiaoHang;
	private String soDienThoaiGiaoHang;
	private LocalDate thoiGianDat;
	private String trangThai;

	private NguoiDungDTO nguoiDung;
	private List<ChiTietHoaDonDTO> chiTietHoaDons;

	public HoaDonDTO() {
		chiTietHoaDons = new ArrayList<>();
	}

	public void themChiTietHoaDon(ValiDTO valiDTO) {

		for (ChiTietHoaDonDTO chiTietHoaDonDTOTempt : chiTietHoaDons) {

			// nếu đã có trong giỏ hàng
			if (chiTietHoaDonDTOTempt.getVali().getMaVali().equals(valiDTO.getMaVali())) {
				chiTietHoaDonDTOTempt.setSoLuong(chiTietHoaDonDTOTempt.getSoLuong() + 1);
				return;
			}

		}

		// còn chưa có
		ChiTietHoaDonDTO chiTietHoaDonDTO = new ChiTietHoaDonDTO(this.maHoaDon, valiDTO, valiDTO.getGia(), 1);
		chiTietHoaDons.add(chiTietHoaDonDTO);
	}

	public void giamChiTietHoaDon(String maVali) {

		for (ChiTietHoaDonDTO chiTietHoaDonDTOTempt : chiTietHoaDons) {

			// nếu đã có trong giỏ hàng
			if (chiTietHoaDonDTOTempt.getVali().getMaVali().equals(maVali)) {

				if (chiTietHoaDonDTOTempt.getSoLuong() > 1)
					chiTietHoaDonDTOTempt.setSoLuong(chiTietHoaDonDTOTempt.getSoLuong() - 1);
				else
					xoaChiTietHoaDon(maVali);

				return;
			}
		}

	}

	public void xoaChiTietHoaDon(String maVali) {

		Iterator<ChiTietHoaDonDTO> chiTietHoaDonIterator = chiTietHoaDons.iterator();

		while (chiTietHoaDonIterator.hasNext()) {

			if (chiTietHoaDonIterator.next().getVali().getMaVali().equals(maVali)) {
				chiTietHoaDonIterator.remove();
				break;
			}

		}
	}

}
