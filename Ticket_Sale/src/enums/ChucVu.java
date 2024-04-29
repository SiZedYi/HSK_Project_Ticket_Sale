package enums;

public enum ChucVu {
  NHANVIEN("Nhân viên"), QUANlY("Quản lý");
  private final String displayname;
	private ChucVu(String displayname) {
		this.displayname = displayname;
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return displayname ;
	}
	

}
