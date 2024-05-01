package enums;

public enum GioiHanTuoi {
	KHONG_GIOI_HAN("Không giới hạn"),
    TUOI_13("13"),
    TUOI_15("15"),
    TUOI_18("18");

	private String displayName;
    
    private GioiHanTuoi(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
