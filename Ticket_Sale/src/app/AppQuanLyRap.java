package app;

import dao.TaiKhoan_DAO;

public class AppQuanLyRap {
	public static void main(String[] args) {
		TaiKhoan_DAO tkd = new TaiKhoan_DAO();
		tkd.getAllData();
	}
}
