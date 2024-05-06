package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.Phim;
import entity.PhongChieu;
import entity.Rap;
import entity.SuatChieu;
import enums.GioiHanTuoi;
import enums.LoaiPhongChieu;
import enums.TheLoai;
import enums.TrangThaiPhim;

public class Rap_Dao extends Dao<Rap>{
	private String tableName = "Rap";
	public Rap_Dao() {
		super("Rap");
		// TODO Auto-generated constructor stub
	}
	@Override
	public Rap readRow(ResultSet rs) {
		Rap rap = null;
		try {
			rap = new Rap(rs.getString("maRap"), rs.getString("tenRap"),
					rs.getString("diaChi"), rs.getString("sdtRap"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rap;
	}

	public ArrayList<Rap> getAllRap(){
		ArrayList<Rap> data = new ArrayList<Rap>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement statement = null;
		 ResultSet rs = null;

		try {
			String query = "Select * from Rap";
			// Tạo một đối tượng CallableStatement
			statement = con.createStatement();
			rs = statement.executeQuery(query);
			System.out.println(statement);
			
			while(rs.next()) {
				Rap rap = new Rap(rs.getString("maRap"), rs.getString("tenRap"),
						rs.getString("diaChi"), rs.getString("sdtRap"));
				data.add(rap);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	public PhongChieu getPhongChieu(String maPc){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		 ResultSet rs = null;
		 PhongChieu phongChieu = null;

		try {
			String query = "Select * from PhongChieu" + " where maPC = ?";
			statement=con.prepareStatement(query);
			statement.setString(1, maPc);
//			ResultSet rs = statement.executeQuery(query);
			 rs = statement.executeQuery(); // Corrected here
			
			while(rs.next()) {
				Rap rap = new Rap(rs.getString("rap"));
				phongChieu = new PhongChieu(rs.getString("maPC"),rs.getString("tenPC"),
						LoaiPhongChieu.valueOf(rs.getString("loaiPC")),rap);
				return phongChieu;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return phongChieu;
	}
	
	public ArrayList<PhongChieu> getAllPhongChieuByPhim(String maPhim ){
		ArrayList<PhongChieu> data = new ArrayList<PhongChieu>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		 ResultSet rs = null;

		try {
			String query = "Select * from SuatChieu" + " where phim = ?";
			statement=con.prepareStatement(query);
			statement.setString(1, maPhim);
//			ResultSet rs = statement.executeQuery(query);
			 rs = statement.executeQuery(); // Corrected here
			
			while(rs.next()) {
				PhongChieu phongChieu = getPhongChieu(rs.getString("phongChieu"));
				data.add(phongChieu);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	public ArrayList<SuatChieu> getAllSuatChieuOfPhim(String maPhim){
		ArrayList<SuatChieu> data = new ArrayList<SuatChieu>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		 ResultSet rs = null;

		try {
			String query = "Select * from SuatChieu" + " where phim " + " = ?";
			statement=con.prepareStatement(query);
			statement.setString(1, maPhim);
			System.out.println(statement);
//			ResultSet rs = statement.executeQuery(query);
			 rs = statement.executeQuery(); // Corrected here
			
			while(rs.next()) {
				Phim phim = new Phim(rs.getString("phim"));
				PhongChieu phongChieu = new PhongChieu(rs.getString("phongChieu"));
				SuatChieu suatChieu = new SuatChieu(rs.getString("maSC"),rs.getTime("thoiGianBatDau"),
						rs.getTime("thoiGianKetThuc"),phim,phongChieu);
				data.add(suatChieu);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	// Phương thức để lấy danh sách các ghế đã được chọn cho một suất chiếu
    public ArrayList<String> layGheDaChon(String maSuatChieu) {
    	ArrayList<String> gheDaChon = new ArrayList<>();
    	ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		 ResultSet rs = null;
        try {
            String query = "SELECT ghe FROM Ve WHERE suatChieu = ?";
            statement = con.prepareStatement(query);
            statement.setString(1, maSuatChieu);
            rs = statement.executeQuery();

            while (rs.next()) {
                String ghe = rs.getString("ghe");
                gheDaChon.add(ghe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gheDaChon;
    }
	@Override
	public void insertingStatement(PreparedStatement stmt, Rap t, Connection con) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updatingStatement(PreparedStatement stmt, Rap t, Connection con) {
		// TODO Auto-generated method stub
		
	}
}
