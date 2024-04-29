package enums;

public enum LoaiPhongChieu {
  	BASIC("Cơ bản"), P4D("4D"), PREMIUM("Premium Cinema");
	
	
	private final String displayname;
	
	private LoaiPhongChieu (String displayname) {
		this.displayname= displayname;
	}
	
	@Override
	public String toString() {
		return displayname;
	}

}
