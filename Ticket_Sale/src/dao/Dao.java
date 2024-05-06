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
	
	public abstract T readRow(ResultSet	rs);
	public abstract void insertingStatement(PreparedStatement stmt, T t,  Connection con);
	public abstract void updatingStatement(PreparedStatement stmt, T t,  Connection con);
	
	public ArrayList<T> getAllData(){
		
		ArrayList<T> data = new ArrayList<T>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String getAllQuery = "Select * from " + tableName;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(getAllQuery);
			while(rs.next()) {
				data.add(readRow(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public ArrayList<T> getByAttribute(String attribute, String filterValue){
		ArrayList<T> data = new ArrayList<T>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String query = "Select * from " + tableName + " where " + attribute + " = N\'" + filterValue + "\'";
			
			statement=con.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
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
		return data;
	}
	public ArrayList<T> getByAttribute(String attribute, int filterValue){
		ArrayList<T> data = new ArrayList<T>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String query = "Select * from " + tableName + " where " + attribute + " = ?";
			statement=con.prepareStatement(query);
			statement.setInt(1, filterValue);
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
		return data;
	}
	public ArrayList<T> getByAttribute(String attribute, boolean filterValue){
		ArrayList<T> data = new ArrayList<T>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String query = "Select * from " + tableName + " where " + attribute + " = ?";
			statement=con.prepareStatement(query);
			statement.setBoolean(1, filterValue);
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
		return data;
	}

	
	public boolean create(T t) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		
		int n = 0;
		try {
			insertingStatement(stmt, t, ConnectDB.getInstance().getConnection());
			
			n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return n > 0;
	}
	
	public boolean update(T t) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		
		int n = 0;
		try {
			updatingStatement(stmt, t, con);
			n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

}
