package entity;

import java.sql.Time;
import java.util.Objects;

public class SuatChieu {
	private String maSC;
	private Time thoiGianBatDau;
	private Time thoiGianKetThuc;
	private PhongChieu phongChieu;
	public SuatChieu(String maSC, Time thoiGianBatDau, Time thoiGianKetThuc, PhongChieu phongChieu) {
		super();
		this.maSC = maSC;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.phongChieu = phongChieu;
	}
	public String getMaSC() {
		return maSC;
	}
	public void setMaSC(String maSC) {
		this.maSC = maSC;
	}
	public Time getThoiGianBatDau() {
		return thoiGianBatDau;
	}
	public void setThoiGianBatDau(Time thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}
	public Time getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public void setThoiGianKetThuc(Time thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	public PhongChieu getPhongChieu() {
		return phongChieu;
	}
	public void setPhongChieu(PhongChieu phongChieu) {
		this.phongChieu = phongChieu;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maSC);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuatChieu other = (SuatChieu) obj;
		return Objects.equals(maSC, other.maSC);
	}
	@Override
	public String toString() {
		return "SuatChieu [maSC=" + maSC + ", thoiGianBatDau=" + thoiGianBatDau + ", thoiGianKetThuc=" + thoiGianKetThuc
				+ ", phongChieu=" + phongChieu + "]";
	}
	
	
}
