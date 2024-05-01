package enums;

public enum TrangThaiPhim {
  	SAP_CHIEU("Sắp chiếu"),DANG_CHIEU("Đang chiếu"); 
	
	private final String displayname;
	
	private  TrangThaiPhim(String displayname) {
		this.displayname= displayname;
	}
	
	@Override
	public String toString() {
		return displayname;
	}


}
