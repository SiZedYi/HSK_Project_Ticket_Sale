package entity;

import java.util.Objects;

import enums.LoaiGhe;

public class Ghe {
	private String maGhe;
	private LoaiGhe loaiGhe;
	private double giaGhe;
	private boolean coTheDat;
	private PhongChieu phongChieu;
	public Ghe(String maGhe, LoaiGhe loaiGhe, double giaGhe, boolean coTheDat, PhongChieu phongChieu) {
		super();
		this.maGhe = maGhe;
		this.loaiGhe = loaiGhe;
		this.giaGhe = giaGhe;
		this.coTheDat = coTheDat;
		this.phongChieu = phongChieu;
	}
	public String getMaGhe() {
		return maGhe;
	}
	public void setMaGhe(String maGhe) {
		this.maGhe = maGhe;
	}
	public LoaiGhe getLoaiGhe() {
		return loaiGhe;
	}
	public void setLoaiGhe(LoaiGhe loaiGhe) {
		this.loaiGhe = loaiGhe;
	}
	public double getGiaGhe() {
		return giaGhe;
	}
	public void setGiaGhe(double giaGhe) {
		this.giaGhe = giaGhe;
	}
	public boolean isCoTheDat() {
		return coTheDat;
	}
	public void setCoTheDat(boolean coTheDat) {
		this.coTheDat = coTheDat;
	}
	public PhongChieu getPhongChieu() {
		return phongChieu;
	}
	public void setPhongChieu(PhongChieu phongChieu) {
		this.phongChieu = phongChieu;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maGhe);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ghe other = (Ghe) obj;
		return Objects.equals(maGhe, other.maGhe);
	}
	@Override
	public String toString() {
		return "Ghe [maGhe=" + maGhe + ", loaiGhe=" + loaiGhe + ", giaGhe=" + giaGhe + ", coTheDat=" + coTheDat
				+ ", phongChieu=" + phongChieu + "]";
	}
	
		
}
