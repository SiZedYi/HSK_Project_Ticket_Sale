package dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Phim;
import enums.GioiHanTuoi;
import enums.TheLoai;
import enums.TrangThaiPhim;

public class Phim_Dao extends Dao{
	
	private static Phim_Dao instance;
	
	public static Phim_Dao getInstance() {
		return instance;
	}

	
	public Phim_Dao() {
		super("Phim");
		// TODO Auto-generated constructor stub
		instance = this;
	}



	@Override
	public Phim readRow(ResultSet rs) {
	    try {
	        String maPhim = rs.getString(1);
	        String tenPhim = rs.getString(2);
	        TrangThaiPhim trangThai = TrangThaiPhim.stringToTrangThaiPhim(rs.getString(3));
	        double gia = rs.getFloat(4);
	        ArrayList<TheLoai> theLoai = TheLoai.splitTheLoaiString(rs.getString(5)); 
	        GioiHanTuoi gioiHanTuoi = GioiHanTuoi.stringToGioiHanTuoi(rs.getString(6));
	        String hinhAnh = rs.getString(7);
	        Phim phim = new Phim(maPhim, tenPhim, trangThai, gia, theLoai, gioiHanTuoi, hinhAnh);
	        return phim;
	    } catch (SQLException e) {
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
