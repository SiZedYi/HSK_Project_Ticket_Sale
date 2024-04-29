package enums;

public enum GioiHanTuoi {
  P("Mọi độ tuổi"),
	K("Dưới 13 tuổi xem cùng cha,mẹ hoặc người giám hộ"),
	T13("Cấm khán giả dưới 13 tuổi"),
	T16("Cấm khán giả dưới 16 tuổi"),
	T18("Cấm khán giả dưới 18 tuổi");
	
	
	
	
	private final String displayname;
	
	private GioiHanTuoi (String displayname) {
		this.displayname= displayname;
	}
	
	@Override
	public String toString() {
		return displayname;
	}


}
