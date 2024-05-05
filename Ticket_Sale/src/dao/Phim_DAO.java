package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.Phim;
import enums.GioiHanTuoi;
import enums.TheLoai;
import enums.TrangThaiPhim;

public class Phim_DAO extends Dao<Phim>{
	private String tableName = "Phim";
	public Phim_DAO() {
		super("Phim");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Phim readRow(ResultSet rs) {
		Phim phim = null;
		
		try {
			// TODO Auto-generated method stub
			ArrayList<TheLoai> listTheLoai = new ArrayList<TheLoai>();
			listTheLoai.add(TheLoai.valueOf(rs.getString("theLoai")));
			phim = new Phim(rs.getString("maPhim"), rs.getString("tenPhim"),
					rs.getString("hinhAnh"), TrangThaiPhim.valueOf(rs.getString("trangThai")), 
					rs.getDouble("gia"), listTheLoai , GioiHanTuoi.valueOf(rs.getString("gioiHanTuoi")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phim;
	}

	@Override
	public void insertingStatement(PreparedStatement stmt, Phim t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatingStatement(PreparedStatement stmt, Phim t) {
		// TODO Auto-generated method stub
		
	}

}
