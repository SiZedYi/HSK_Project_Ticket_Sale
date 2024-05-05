package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import connectDB.ConnectDB;

import java.sql.Connection;
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
			NhanVien quanLy = new NhanVien(rs.getString(12));
			NhanVien nv = new NhanVien(maNV, tenNV, gioiTinh, ngaySinh, cccd, noiCuTru, sdt, trinhDo, email, ngayTuyenDung, luong, quanLy);
			return nv;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void insertingStatement(PreparedStatement stmt, Object t, Connection con) {
		return ;
		
	}

	@Override
	public void updatingStatement(PreparedStatement stmt, Object t, Connection con) {
		// TODO Auto-generated method stub
		
	}

	
	public boolean create(NhanVien nv) {
		int n = 0;
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String query = "insert into NhanVien (maNV, tenNV, gioiTinh, ngaySinh, cccd, noiCuTru, sdt, trinhDo, email, ngayTuyenDung, luong, quanLy)" + "Values (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement newStmt=con.prepareStatement(query);
			newStmt.setNString(1, nv.getMaNV());
			newStmt.setNString(2, nv.getTenNV());
			newStmt.setNString(3, nv.getGioiTinh().toString());
			newStmt.setDate(4, nv.getNgaySinh());
			newStmt.setNString(5, nv.getCccd());
			newStmt.setNString(6, nv.getNoiCuTru());
			newStmt.setNString(7, nv.getSdt());
			newStmt.setNString(8, nv.getTrinhDo());
			newStmt.setNString(9, nv.getEmail());
			newStmt.setDate(10, nv.getNgayTuyenDung());
			newStmt.setFloat(11, (float) nv.getLuong());
			newStmt.setNString(12, nv.getQuanLy().getMaNV());
			n = newStmt.executeUpdate();
			newStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean update(NhanVien nv) {
	    int n = 0;
	    try {
	        Connection con = ConnectDB.getInstance().getConnection();
	        String query = "UPDATE NhanVien SET tenNV=?, gioiTinh=?, ngaySinh=?, cccd=?, noiCuTru=?, sdt=?, trinhDo=?, email=?, ngayTuyenDung=?, luong=?, quanLy=? WHERE maNV=?";
	        PreparedStatement updateStmt = con.prepareStatement(query);
	        updateStmt.setNString(1, nv.getTenNV());
	        updateStmt.setNString(2, nv.getGioiTinh().toString());
	        updateStmt.setDate(3, nv.getNgaySinh());
	        updateStmt.setNString(4, nv.getCccd());
	        updateStmt.setNString(5, nv.getNoiCuTru());
	        updateStmt.setNString(6, nv.getSdt());
	        updateStmt.setNString(7, nv.getTrinhDo());
	        updateStmt.setNString(8, nv.getEmail());
	        updateStmt.setDate(9, nv.getNgayTuyenDung());
	        updateStmt.setFloat(10, (float) nv.getLuong());
	        updateStmt.setNString(11, nv.getQuanLy().getMaNV());
	        updateStmt.setNString(12, nv.getMaNV());
	        n = updateStmt.executeUpdate();
	        updateStmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return n > 0;
	}
	
	public boolean delete(String maNV) {
	    int n = 0;
	    try {
	        Connection con = ConnectDB.getInstance().getConnection();
	        String query = "DELETE FROM NhanVien WHERE maNV=?";
	        PreparedStatement deleteStmt = con.prepareStatement(query);
	        deleteStmt.setNString(1, maNV);
	        n = deleteStmt.executeUpdate();
	        deleteStmt.close();
	    } catch (SQLException e) {
	        // Handle exception
	        e.printStackTrace();
	    }
	    return n > 0;
	}
}
