package entity;

import java.sql.Time;
import java.util.Objects;

import enums.PhuongThucThanhToan;

public class HoaDon {
	private String maHD;
	private double soTien;
	private Time thoiGianXuat;
	private PhuongThucThanhToan phuongThucThanhToan;
	private NhanVien nhanVien;
	public HoaDon(String maHD, double soTien, Time thoiGianXuat, PhuongThucThanhToan phuongThucThanhToan,
			NhanVien nhanVien) {
		super();
		this.maHD = maHD;
		this.soTien = soTien;
		this.thoiGianXuat = thoiGianXuat;
		this.phuongThucThanhToan = phuongThucThanhToan;
		this.nhanVien = nhanVien;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public double getSoTien() {
		return soTien;
	}
	public void setSoTien(double soTien) {
		this.soTien = soTien;
	}
	public Time getThoiGianXuat() {
		return thoiGianXuat;
	}
	public void setThoiGianXuat(Time thoiGianXuat) {
		this.thoiGianXuat = thoiGianXuat;
	}
	public PhuongThucThanhToan getPhuongThucThanhToan() {
		return phuongThucThanhToan;
	}
	public void setPhuongThucThanhToan(PhuongThucThanhToan phuongThucThanhToan) {
		this.phuongThucThanhToan = phuongThucThanhToan;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maHD);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHD, other.maHD);
	}
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", soTien=" + soTien + ", thoiGianXuat=" + thoiGianXuat
				+ ", phuongThucThanhToan=" + phuongThucThanhToan + ", nhanVien=" + nhanVien + "]";
	}
	
	
}
