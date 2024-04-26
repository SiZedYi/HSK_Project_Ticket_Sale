package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public static Connection con = null;
	private String dataBaseName = "CinemaDatabase"; //Fill this parameter with database's name
	private String localHost = "1433";
	private String user = "sa";
	private String password = "anhthang123";
	
	private static ConnectDB instance = new ConnectDB();
	
	public static ConnectDB getInstance() {
		return instance;
	}
	
	public void connect() throws SQLException {
		String url = "jdbc:sqlserver://localhost:"+ localHost+ ";databasename=" + dataBaseName;
		con = DriverManager.getConnection(url, user, password); 
	}
	
	public void disconnect() {
		if(con != null) {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
}
