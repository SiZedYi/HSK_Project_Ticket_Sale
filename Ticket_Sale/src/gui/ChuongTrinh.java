package gui;

public class ChuongTrinh {
   try {
    	ConnectDB.getInstance().connect();
    }catch(SQLException e ) {
    	e.printStackTrace();
    }
    new Login();
}
