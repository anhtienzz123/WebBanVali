package webbanvali.utils;

public enum TrangThaiDonHang {

	DANG_CHO_XU_LY("Đang chờ xử lý"), DANG_XU_LY("Đang xử lý"), DANG_GIAO_HANG("Đang giao hàng"),
	HUY_DON_HANG("Hủy đơn hàng");

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
