package dao;

import java.sql.Connection;
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

	
	public boolean create(Phim phim) {
		String trangThaiValue ="SAP_CHIEU";
		String theLoaiValue = "HANH_DONG";
		String gioiHanTuoiValue = "P";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n=0;
		
		// Xử lý enums trạng thái
	    if (phim.getTrangThai().toString().equals("Đang chiếu"))
	        trangThaiValue = "DANG_CHIEU";

	    // Xử lý enums thể loại
	    String selectedTheLoai = phim.getTheLoai().toString();
	    switch (selectedTheLoai) {
	        case "Hành động":
	            theLoaiValue = "HANH_DONG";
	            break;
	        case "Tình cảm":
	            theLoaiValue = "TINH_CAM";
	            break;
	        case "Hài hước":
	            theLoaiValue = "HAI_HUOC";
	            break;
	        case "Lãng mạn":
	            theLoaiValue = "LANG_MAN";
	            break;
	        case "Hoạt hình":
	            theLoaiValue = "HOAT_HINH";
	            break;
	        case "Hình sự":
	            theLoaiValue = "HINH_SU";
	            break;
	        case "Tài liệu":
	            theLoaiValue = "TAI_LIEU";
	            break;
	    }

		
		// Xử lý enum giới hạn tuổi
	    String selectedGhTuoi = phim.getGioiHanTuoi().toString();
	    switch (selectedGhTuoi) {
	        case "Mọi độ tuổi":
	            gioiHanTuoiValue = "P";
	            break;
	        case "Dưới 13 tuổi xem cùng cha,mẹ hoặc người giám hộ":
	            gioiHanTuoiValue = "K";
	            break;
	        case "Cấm khán giả dưới 13 tuổi":
	            gioiHanTuoiValue = "T13";
	            break;
	        case "Cấm khán giả dưới 16 tuổi":
	            gioiHanTuoiValue = "T16";
	            break;
	        case "Cấm khán giả dưới 18 tuổi":
	            gioiHanTuoiValue = "T18";
	            break;
	    }
		try {
			statement= con.prepareStatement("insert into" + 
		" Phim values(?,?,?,?,?,?,?)");
			statement.setString(1, phim.getMaPhim());
			statement.setString(2, phim.getTenPhim());
			statement.setString(3, trangThaiValue);
			statement.setDouble(4, phim.getGia());
			statement.setString(5, theLoaiValue);
			statement.setString(6, gioiHanTuoiValue);
			statement.setString(7, phim.getAnhPhim());
			n =statement.executeUpdate();	
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n>0;
	}
	
	public boolean update(Phim phim) {
	    String trangThaiValue = "SAP_CHIEU";
	    String theLoaiValue = "HANH_DONG";
	    String gioiHanTuoiValue = "P";
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement statement = null;
	    int n = 0;

	    // Xử lý enums trạng thái
	    if (phim.getTrangThai().toString().equals("Đang chiếu"))
	        trangThaiValue = "DANG_CHIEU";

	    // Xử lý enums thể loại
	    String selectedTheLoai = phim.getTheLoai().toString();
	    switch (selectedTheLoai) {
	        case "Hành động":
	            theLoaiValue = "HANH_DONG";
	            break;
	        case "Tình cảm":
	            theLoaiValue = "TINH_CAM";
	            break;
	        case "Hài hước":
	            theLoaiValue = "HAI_HUOC";
	            break;
	        case "Lãng mạn":
	            theLoaiValue = "LANG_MAN";
	            break;
	        case "Hoạt hình":
	            theLoaiValue = "HOAT_HINH";
	            break;
	        case "Hình sự":
	            theLoaiValue = "HINH_SU";
	            break;
	        case "Tài liệu":
	            theLoaiValue = "TAI_LIEU";
	            break;
	    }

	    // Xử lý enum giới hạn tuổi
	    String selectedGhTuoi = phim.getGioiHanTuoi().toString();
	    switch (selectedGhTuoi) {
	        case "Mọi độ tuổi":
	            gioiHanTuoiValue = "P";
	            break;
	        case "Dưới 13 tuổi xem cùng cha,mẹ hoặc người giám hộ":
	            gioiHanTuoiValue = "K";
	            break;
	        case "Cấm khán giả dưới 13 tuổi":
	            gioiHanTuoiValue = "T13";
	            break;
	        case "Cấm khán giả dưới 16 tuổi":
	            gioiHanTuoiValue = "T16";
	            break;
	        case "Cấm khán giả dưới 18 tuổi":
	            gioiHanTuoiValue = "T18";
	            break;
	    }

	    try {
	        statement = con.prepareStatement("UPDATE Phim " +
	                "SET tenPhim = ?, trangThai = ?, gia = ?, theLoai = ?, gioiHanTuoi = ?, hinhAnh = ? " +
	                "WHERE MaPhim = ?");
	        statement.setString(1, phim.getTenPhim());
	        statement.setString(2, trangThaiValue);
	        statement.setDouble(3, phim.getGia());
	        statement.setString(4, theLoaiValue);
	        statement.setString(5, gioiHanTuoiValue);
	        statement.setString(6, phim.getAnhPhim());
	        statement.setString(7, phim.getMaPhim());
	        n = statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return n > 0;
	}
	
	public boolean delete(String maPhim) {
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement statement = null;
	    int n = 0;

	    try {
	        statement = con.prepareStatement("DELETE FROM Phim WHERE maPhim = ?");
	        statement.setString(1, maPhim);
	        n = statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return n > 0;
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
