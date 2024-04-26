package entity;

import java.util.Objects;

import enums.LoaiPhongChieu;

public class PhongChieu {
	private String maPC;
	private String tenPC;
	private LoaiPhongChieu loaiPC;
	private Rap rap;
	public PhongChieu(String maPC, String tenPC, LoaiPhongChieu loaiPC, Rap rap) {
		super();
		this.maPC = maPC;
		this.tenPC = tenPC;
		this.loaiPC = loaiPC;
		this.rap = rap;
	}
	public String getMaPC() {
		return maPC;
	}
	public void setMaPC(String maPC) {
		this.maPC = maPC;
	}
	public String getTenPC() {
		return tenPC;
	}
	public void setTenPC(String tenPC) {
		this.tenPC = tenPC;
	}
	public LoaiPhongChieu getLoaiPC() {
		return loaiPC;
	}
	public void setLoaiPC(LoaiPhongChieu loaiPC) {
		this.loaiPC = loaiPC;
	}
	public Rap getRap() {
		return rap;
	}
	public void setRap(Rap rap) {
		this.rap = rap;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPC);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongChieu other = (PhongChieu) obj;
		return Objects.equals(maPC, other.maPC);
	}
	@Override
	public String toString() {
		return "PhongChieu [maPC=" + maPC + ", tenPC=" + tenPC + ", loaiPC=" + loaiPC + ", rap=" + rap + "]";
	}
	
	
}
