package enums;

public enum PhuongThucThanhToan {
  	CASH("Tiền mặt"),
	MOMO("MOMO"),
	ATM("Thẻ ngân hàng"),
	VNPAY("VNPAY"),
	ZALOPAY("Zalo Pay"),
	BANKTRANSFER("Chuyển khoản qua ngân hàng");

	

	private final String displayname;
	
	private PhuongThucThanhToan(String displayname) {
		this.displayname= displayname;
	}
	
	@Override
	public String toString() {
		return displayname;
	}

}
