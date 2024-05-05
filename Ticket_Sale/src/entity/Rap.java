package entity;

import java.util.Objects;

public class Rap {
	private String maRap;
	private String tenRap;
	private String diaChi;
	private String sdtRap;
	public Rap(String maRap, String tenRap, String diaChi, String sdtRap) {
		super();
		this.maRap = maRap;
		this.tenRap = tenRap;
		this.diaChi = diaChi;
		this.sdtRap = sdtRap;
	}
	public Rap(String maRap) {
		super();
		this.maRap = maRap;
	}
	public String getMaRap() {
		return maRap;
	}
	public void setMaRap(String maRap) {
		this.maRap = maRap;
	}
	public String getTenRap() {
		return tenRap;
	}
	public void setTenRap(String tenRap) {
		this.tenRap = tenRap;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdtRap() {
		return sdtRap;
	}
	public void setSdtRap(String sdtRap) {
		this.sdtRap = sdtRap;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maRap);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rap other = (Rap) obj;
		return Objects.equals(maRap, other.maRap);
	}
	@Override
	public String toString() {
		return "Rap [maRap=" + maRap + ", tenRap=" + tenRap + ", diaChi=" + diaChi + ", sdtRap=" + sdtRap + "]";
	}
	
	
}
