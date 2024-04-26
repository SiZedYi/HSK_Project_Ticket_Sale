package entity;

import java.sql.Time;
import java.util.Objects;

public class Ve {
	private String maVe;
	private Time thoiGianIn;
	private Phim phim;
	private SuatChieu suatChieu;
	private Ghe ghe;
	private PhongChieu phongChieu;
	private HoaDon hoaDon;
	public Ve(String maVe, Time thoiGianIn, Phim phim, SuatChieu suatChieu, Ghe ghe, PhongChieu phongChieu,
			HoaDon hoaDon) {
		super();
		this.maVe = maVe;
		this.thoiGianIn = thoiGianIn;
		this.phim = phim;
		this.suatChieu = suatChieu;
		this.ghe = ghe;
		this.phongChieu = phongChieu;
		this.hoaDon = hoaDon;
	}
	public String getMaVe() {
		return maVe;
	}
	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}
	public Time getThoiGianIn() {
		return thoiGianIn;
	}
	public void setThoiGianIn(Time thoiGianIn) {
		this.thoiGianIn = thoiGianIn;
	}
	public Phim getPhim() {
		return phim;
	}
	public void setPhim(Phim phim) {
		this.phim = phim;
	}
	public SuatChieu getSuatChieu() {
		return suatChieu;
	}
	public void setSuatChieu(SuatChieu suatChieu) {
		this.suatChieu = suatChieu;
	}
	public Ghe getGhe() {
		return ghe;
	}
	public void setGhe(Ghe ghe) {
		this.ghe = ghe;
	}
	public PhongChieu getPhongChieu() {
		return phongChieu;
	}
	public void setPhongChieu(PhongChieu phongChieu) {
		this.phongChieu = phongChieu;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maVe);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ve other = (Ve) obj;
		return Objects.equals(maVe, other.maVe);
	}
	@Override
	public String toString() {
		return "Ve [maVe=" + maVe + ", thoiGianIn=" + thoiGianIn + ", phim=" + phim + ", suatChieu=" + suatChieu
				+ ", ghe=" + ghe + ", phongChieu=" + phongChieu + ", hoaDon=" + hoaDon + "]";
	}
	
	
}
