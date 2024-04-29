package enums;

public enum TheLoai {
  	HANH_DONG("Hành động"), 
	TINH_CAM("Tình cảm"),
	HAI("Hài huớc"),
	LANG_MAN("Lãng mạn"),
	HOAT_HINNH("Hoạt hình"),
	HINH_SU("Hình sự"),
	TAI_LIEU("Tài liệu");
	
	
	private final String displayname;
	
	private TheLoai(String displayname) {
		this.displayname= displayname;
	}
	
	@Override
	public String toString() {
		return displayname;
	}


}
