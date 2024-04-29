package enums;

public enum Quyen {
  NHANVIEN("Nhân viên"), QUANlY("Quản lý");
  private final String displayname;
	private Quyen(String displayname) {
		this.displayname = displayname;
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return displayname ;
	}

}
