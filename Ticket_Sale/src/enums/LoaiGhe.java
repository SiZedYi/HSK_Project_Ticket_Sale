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

}
