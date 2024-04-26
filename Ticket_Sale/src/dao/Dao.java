package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;

public abstract class Dao<T> {
	private String tableName;
	
	public Dao(String tableName){
		this.tableName = tableName;
	}
	
	public ArrayList<T> getAllData(){
		/*
		ArrayList<T> data = new ArrayList<T>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String getAllQuery = "Select * from " + tableName;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(getAllQuery);
			
			while(rs.next()) {
				ReadRow();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}*/
		System.out.println("1");
		readRow();
		System.out.println("2");
		return null;
	}
	public abstract void readRow();
	
	public ArrayList<T> getById(){
		ArrayList<T> data = new ArrayList<T>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String query = "";
			statement=con.prepareStatement(query);
			statement.setString(1, query);
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				data.add(readRow(rs));
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
		return null;
	}
	
	public abstract T readRow(ResultSet	rs);
	
}
