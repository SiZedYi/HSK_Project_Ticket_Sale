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
	
	public static PhuongThucThanhToan StringToPhuongThucThanhToan(String ptttString) {
		if(ptttString.equals(CASH.toString()))
			return CASH;
		if(ptttString.equals(MOMO.toString()))
			return MOMO;
		if(ptttString.equals(ATM.toString()))
			return ATM;
		if(ptttString.equals(VNPAY.toString()))
			return VNPAY;
		if(ptttString.equals(ZALOPAY.toString()))
			return ZALOPAY;
		if(ptttString.equals(BANKTRANSFER.toString()))
			return BANKTRANSFER;
		System.out.println(ptttString);
		return null;
	}

}
