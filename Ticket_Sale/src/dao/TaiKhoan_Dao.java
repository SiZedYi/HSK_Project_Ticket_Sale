package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;
import enums.Quyen;

public class TaiKhoan_Dao extends Dao{
	
private static TaiKhoan_Dao instance;
	
	public static TaiKhoan_Dao getInstance() {
		return instance;
	}
	
	public TaiKhoan_Dao() {
		super("TaiKhoan");
		// TODO Auto-generated constructor stub
		instance = this;
	}

	
	
	@Override
	public TaiKhoan readRow(ResultSet rs) {
	    try {
	        String maTK = rs.getString(1);
	        String tenDangNhap = rs.getString(2);
	        String matKhau = rs.getString(3);
	        NhanVien nhanVien = new NhanVien(rs.getString(4)); 
	        Quyen quyen = Quyen.stringToQuyen(rs.getString(5)); 
	        TaiKhoan taiKhoan = new TaiKhoan(maTK, tenDangNhap, matKhau, nhanVien, quyen);
	        return taiKhoan;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	@Override
	public void insertingStatement(PreparedStatement stmt, Object t, Connection con) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatingStatement(PreparedStatement stmt, Object t, Connection con) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean create(TaiKhoan taiKhoan) {
        int n = 0;
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String query = "INSERT INTO TaiKhoan (maTK, tenDangNhap, matKhau, nhanVien, quyen) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement newStmt = con.prepareStatement(query);
            newStmt.setNString(1, taiKhoan.getMaTK());
            newStmt.setNString(2, taiKhoan.getTenDangNhap());
            newStmt.setNString(3, taiKhoan.getMatKhau());
            newStmt.setNString(4, taiKhoan.getNhanVien().getMaNV());
            newStmt.setNString(5, taiKhoan.getQuyen().toString());
            n = newStmt.executeUpdate();
            newStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }

    public boolean update(TaiKhoan taiKhoan) {
        int n = 0;
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String query = "UPDATE TaiKhoan SET tenDangNhap=?, matKhau=?, nhanVien=?, quyen=? WHERE maTK=?";
            PreparedStatement updateStmt = con.prepareStatement(query);
            
            updateStmt.setNString(1, taiKhoan.getTenDangNhap());
            updateStmt.setNString(2, taiKhoan.getMatKhau());
            updateStmt.setNString(3, taiKhoan.getNhanVien().getMaNV());
            updateStmt.setNString(4, taiKhoan.getQuyen().toString());
            updateStmt.setNString(5, taiKhoan.getMaTK());
            n = updateStmt.executeUpdate();
            updateStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }

    public boolean delete(String maTK) {
        int n = 0;
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String query = "DELETE FROM TaiKhoan WHERE maTK=?";
            PreparedStatement deleteStmt = con.prepareStatement(query);
            deleteStmt.setString(1, maTK);
            n = deleteStmt.executeUpdate();
            deleteStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }

}
