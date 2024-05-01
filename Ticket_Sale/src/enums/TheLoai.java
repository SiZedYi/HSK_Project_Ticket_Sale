package enums;

public enum TheLoai {
    HANH_DONG("Hành động"),
    TINH_CAM("Tình cảm"),
    HOAT_HINH("Hoạt hình"),
    KINH_DI("Kinh dị"),
    VIEN_TUONG("Viễn tưởng"),
    HOI_HOP("Hồi hộp"),
    TAM_LY("Tâm lý"),
    GIAO_DUC("Giáo dục"),
    CHIEN_TRANH("Chiến tranh"),
    THE_THAO("Thể thao");

    private String displayName;

    private TheLoai(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
