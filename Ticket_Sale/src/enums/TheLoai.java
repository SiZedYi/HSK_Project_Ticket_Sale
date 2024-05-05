package enums;

import java.util.ArrayList;

public enum TheLoai {
  	HANH_DONG("Hành động"), 
	TINH_CAM("Tình cảm"),
	HAI("Hài huớc"),
	LANG_MAN("Lãng mạn"),
	HOAT_HINH("Hoạt hình"),
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

	public static TheLoai stringToTheLoai(String theLoaiString) {
	    for (TheLoai theLoai : TheLoai.values()) {
	        if (theLoai.toString().equals(theLoaiString)) {
	            return theLoai;
	        }
	    }
	    System.out.println(theLoaiString);
	    return null; 
	}
	
	public static ArrayList<TheLoai> splitTheLoaiString(String theLoaiString) {
	    ArrayList<TheLoai> theLoaiList = new ArrayList<>();
	    String[] theLoaiArray = theLoaiString.split("\\|"); 
	    for (String theLoai : theLoaiArray) {
	
	        theLoaiList.add(stringToTheLoai(theLoai));
	    }
	    return theLoaiList;
	}
}
