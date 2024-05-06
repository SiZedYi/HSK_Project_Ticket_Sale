package enums;

public enum Quyen {
  NHANVIEN("Nhân viên"), QUANlY("Quản lý"), KHONG("Không");
  private final String displayname;
	private Quyen(String displayname) {
		this.displayname = displayname;
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return displayname ;
	}
	public static Quyen stringToQuyen(String quyenString) {
	    for (Quyen quyen : Quyen.values()) {
	        if (quyen.toString().equals(quyenString)) {
	            return quyen;
	        }
	    }
	    System.out.println(quyenString);
	    return KHONG; 
	}
}
