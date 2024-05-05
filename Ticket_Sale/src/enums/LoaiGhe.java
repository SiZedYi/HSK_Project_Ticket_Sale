package enums;

public enum LoaiGhe {
  GHETIEUCHUAN("Ghế tiêu chuẩn"), GHEVIP("Ghế VIP"),GHECOUPLE("Ghế COUPLE");
	
	
	
	private final String displayname;
	
	private LoaiGhe (String displayname) {
		this.displayname= displayname;
	}
	
	@Override
	public String toString() {
		return displayname;
	}
	public static LoaiGhe stringToLoaiGhe(String lgString) {
	    for (LoaiGhe lg : LoaiGhe.values()) {
	        if (lg.toString().equals(lgString)) {
	            return lg;
	        }
	    }
	    System.out.println(lgString);
	    return null;
	}

}
