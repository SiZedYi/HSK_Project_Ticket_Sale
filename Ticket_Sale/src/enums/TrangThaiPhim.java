package enums;

public enum TrangThaiPhim {
  	SAPCHIEU("Sắp chiếu"),DANGCHIEU("Đang chiếu"); 
	
	private final String displayname;
	
	private  TrangThaiPhim(String displayname) {
		this.displayname= displayname;
	}
	
	@Override
	public String toString() {
		return displayname;
	}


}
