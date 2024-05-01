package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.TaiKhoan;

public class TaiKhoan_DAO extends Dao<TaiKhoan>{

	public TaiKhoan_DAO() {
		super("TaiKhoan");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void readRow() {
		System.out.println("hi this is tk dao");
		
	}

	@Override
	public TaiKhoan readRow(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertingStatement(PreparedStatement stmt, TaiKhoan t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatingStatement(PreparedStatement stmt, TaiKhoan t) {
		// TODO Auto-generated method stub
		
	}

}
