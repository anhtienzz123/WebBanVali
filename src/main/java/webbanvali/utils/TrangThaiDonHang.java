package webbanvali.utils;

public enum TrangThaiDonHang {

	TAT_CA("Tất cả"),DANG_CHO_XU_LY("Đang chờ xử lý"), DANG_XU_LY("Đang xử lý"), DANG_GIAO_HANG("Đang giao hàng"),
	HUY_DON_HANG("Hủy đơn hàng"), THANH_CONG("Thành công");

	private String ten;

	private TrangThaiDonHang(String ten) {
		this.ten = ten;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

}
