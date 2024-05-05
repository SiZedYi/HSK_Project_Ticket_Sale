package enums;

public enum LoaiPhongChieu {
  	BASIC("Cơ bản"), P_4D("4D"), PREMIUM("Premium Cinema");
	
	
	private final String displayname;
	
	private LoaiPhongChieu (String displayname) {
		this.displayname= displayname;
	}
	
	@Override
	public String toString() {
		return displayname;
	}
	public static LoaiPhongChieu stringToLoaiPhongChieu(String lpcString) {
	    for (LoaiPhongChieu lpc : LoaiPhongChieu.values()) {
	        if (lpc.toString().equals(lpcString)) {
	            return lpc;
	        }
	    }
	    System.out.println(lpcString);
	    return null; 
	}
}
