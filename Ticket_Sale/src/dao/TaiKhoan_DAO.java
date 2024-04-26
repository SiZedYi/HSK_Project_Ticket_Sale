package dao;

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

}
