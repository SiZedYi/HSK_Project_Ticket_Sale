package enums;

public enum TrangThaiPhim {
    DANG_CHIEU("Đang chiếu"), 
    CHUA_CHIEU("Chưa chiếu"),
    HET_CHIEU("Hết chiếu");
    
    private String displayName;
    
    private TrangThaiPhim(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
