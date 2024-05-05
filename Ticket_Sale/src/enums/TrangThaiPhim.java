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
	
	public static TrangThaiPhim stringToTrangThaiPhim(String trangThaiString) {
	    for (TrangThaiPhim trangThai : TrangThaiPhim.values()) {
	        if (trangThai.toString().equals(trangThaiString)) {
	            return trangThai;
	        }
	    }
	    System.out.println(trangThaiString);
	    return null; 
	}

}
