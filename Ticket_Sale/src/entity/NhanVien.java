package entity;

import java.sql.Date;
import java.util.Objects;

import enums.GioiTinh;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private GioiTinh gioiTinh;
	private Date ngaySinh;
	private String cccd;
	private String noiCuTru;
	private String sdt;
	private String trinhDo;
	private String email;
	private Date ngayTuyenDung;
	private double luong;
	private NhanVien quanLy;
	
	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}
	
	public NhanVien(String maNV, String tenNV, GioiTinh gioiTinh, Date ngaySinh, String cccd, String noiCuTru,
			String sdt, String trinhDo, String email, Date ngayTuyenDung, double luong, NhanVien quanLy) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.cccd = cccd;
		this.noiCuTru = noiCuTru;
		this.sdt = sdt;
		this.trinhDo = trinhDo;
		this.email = email;
		this.ngayTuyenDung = ngayTuyenDung;
		this.luong = luong;
		this.quanLy = quanLy;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	
	public GioiTinh getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(GioiTinh gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getCccd() {
		return cccd;
	}
	public void setCccd(String cccd) {
		this.cccd = cccd;
	}
	public String getNoiCuTru() {
		return noiCuTru;
	}
	public void setNoiCuTru(String noiCuTru) {
		this.noiCuTru = noiCuTru;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getTrinhDo() {
		return trinhDo;
	}
	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getNgayTuyenDung() {
		return ngayTuyenDung;
	}
	public void setNgayTuyenDung(Date ngayTuyenDung) {
		this.ngayTuyenDung = ngayTuyenDung;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	public NhanVien getQuanLy() {
		return quanLy;
	}
	public void setQuanLy(NhanVien quanLy) {
		this.quanLy = quanLy;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh
				+ ", cccd=" + cccd + ", noiCuTru=" + noiCuTru + ", sdt=" + sdt + ", trinhDo=" + trinhDo + ", email="
				+ email + ", ngayTuyenDung=" + ngayTuyenDung + ", luong=" + luong + ", quanLy=" + quanLy + "]";
	}
	
	
	
}
