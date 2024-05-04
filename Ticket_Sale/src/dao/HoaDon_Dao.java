package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import entity.HoaDon;
import enums.PhuongThucThanhToan;

public class HoaDon_Dao extends Dao{

	public HoaDon_Dao() {
		super("HoaDon");
		// TODO Auto-generated constructor stub
	}

	@Override
	public HoaDon readRow(ResultSet rs) {
		try {
			String maHD = rs.getString(1);
			double soTien = rs.getDouble(2);
			Time thoiGianXuat = rs.getTime(3);
			PhuongThucThanhToan pttt = PhuongThucThanhToan.StringToPhuongThucThanhToan(rs.getString(4));
			HoaDon hoaDonDaDoc = new HoaDon(maHD, soTien, thoiGianXuat, pttt);
			return hoaDonDaDoc;
			
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
