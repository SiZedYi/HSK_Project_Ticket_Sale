package entity;

import java.util.ArrayList;
import java.util.Objects;

import enums.GioiHanTuoi;
import enums.TheLoai;
import enums.TrangThaiPhim;

public class Phim {
	private String maPhim;
	private String tenPhim;
	private TrangThaiPhim trangThai;
	private double gia;
	private ArrayList<TheLoai> theLoai;
	private GioiHanTuoi gioiHanTuoi;

	private String hinhAnh;
	
	public Phim(String maPhim, String tenPhim, String anhPhim, TrangThaiPhim trangThai, double gia, ArrayList<TheLoai> theLoai,
			GioiHanTuoi gioiHanTuoi) {

		super();
		this.maPhim = maPhim;
		this.tenPhim = tenPhim;
		this.trangThai = trangThai;
		this.gia = gia;
		this.theLoai = theLoai;
		this.gioiHanTuoi = gioiHanTuoi;
	}
	public Phim(String maPhim) {
		super();
		this.maPhim = maPhim;
	}
	
	public String getMaPhim() {
		return maPhim;
	}
	public void setMaPhim(String maPhim) {
		this.maPhim = maPhim;
	}
	public String getTenPhim() {
		return tenPhim;
	}
	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}
	public TrangThaiPhim getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(TrangThaiPhim trangThai) {
		this.trangThai = trangThai;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public ArrayList<TheLoai> getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(ArrayList<TheLoai> theLoai) {
		this.theLoai = theLoai;
	}
	public GioiHanTuoi getGioiHanTuoi() {
		return gioiHanTuoi;
	}
	public void setGioiHanTuoi(GioiHanTuoi gioiHanTuoi) {
		this.gioiHanTuoi = gioiHanTuoi;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phim other = (Phim) obj;
		return Objects.equals(maPhim, other.maPhim);
	}
	@Override
	public String toString() {

		return "Phim [maPhim=" + maPhim + ", tenPhim=" + tenPhim + ", trangThai=" + trangThai
				+ ", gia=" + gia + ", theLoai=" + theLoai + ", gioiHanTuoi=" + gioiHanTuoi + ", hinhAnh=" + hinhAnh
				+ "]";

	}
	
	
}
