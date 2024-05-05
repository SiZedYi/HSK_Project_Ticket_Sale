package enums;

public enum GioiTinh {
	NAM("Nam"),
	NU("Nữ");
	
	private final String displayname;
	
	private GioiTinh(String displayname) {
		this.displayname= displayname;
	}
	
	@Override
	public String toString() {
		return displayname;
	}
	
	public static GioiTinh stringToPhuongThucGioiTinh(String ptttString) {
		if(ptttString.equals(NAM.toString()))
			return NAM;
		if(ptttString.equals(NU.toString()))
			return NU;
		System.out.println(ptttString);
		return null;
	}
}
