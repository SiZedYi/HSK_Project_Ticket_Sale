package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import entity.HoaDon;
import entity.NhanVien;
import enums.GioiTinh;
import enums.PhuongThucThanhToan;

public class NhanVien_Dao extends Dao{
	
	private static NhanVien_Dao instance;
	
	public static NhanVien_Dao getInstance() {

		return instance;
	}

	public NhanVien_Dao() {
		super("NhanVien");
		// TODO Auto-generated constructor stub
		instance = this;
	}

	@Override
	public NhanVien readRow(ResultSet rs) {
		try {
			String maNV = rs.getString(1);
			String tenNV = rs.getString(2);
			GioiTinh gioiTinh = GioiTinh.stringToPhuongThucGioiTinh(rs.getString(3));
			Date ngaySinh = rs.getDate(4);
			String cccd = rs.getString(5);
			String noiCuTru = rs.getString(6);
			String sdt = rs.getString(7);
			String trinhDo = rs.getString(8);
			String email = rs.getString(9);
			Date ngayTuyenDung = rs.getDate(10);
			double luong = rs.getDouble(11);
			NhanVien quanLy = new NhanVien(rs.getString(3));
			NhanVien nv = new NhanVien(maNV, tenNV, gioiTinh, ngaySinh, cccd, noiCuTru, sdt, trinhDo, email, ngayTuyenDung, luong, quanLy);
			return nv;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void insertingStatement(PreparedStatement stmt, Object t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatingStatement(PreparedStatement stmt, Object t) {
		// TODO Auto-generated method stub
		
	}

}
