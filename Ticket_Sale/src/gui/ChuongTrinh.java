package gui;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import dao.NhanVien_Dao;
import dao.Phim_Dao;
import dao.TaiKhoan_Dao;
import entity.NhanVien;
import enums.GioiTinh;

public class ChuongTrinh {

    public static void main(String[] args) {
    	//ConnectDB
		ConnectDB dbConnection = new ConnectDB();
        try {
			dbConnection.connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        //Start all Dao here
        Phim_Dao phimDao = new Phim_Dao();
        NhanVien_Dao nhanVienDao = new NhanVien_Dao();
        TaiKhoan_Dao taiKhoanDao = new TaiKhoan_Dao();
        
    	//////////////
        new Login();

        try {
        	ConnectDB.getInstance().connect();
        }catch(SQLException e ) {
        	e.printStackTrace();

        }
    }
}
