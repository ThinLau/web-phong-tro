package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.ChuTro;
import connect.DBConnect;

public class ChuTroDao {

	public ArrayList<ChuTro> getChuTros()
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		
		String sql="select * from chutro";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			ArrayList<ChuTro> list_ct =new ArrayList<>();
			while(rs.next()){
				String mact = rs.getString("MaCT");
				String hoten = rs.getString("HoTen");
				String diachi = rs.getString("DiaChi");
				String sdt = rs.getString("SoDT");
				String email = rs.getString("Email");
				String cmnd = rs.getString("CMND");
				
				ChuTro ct = new ChuTro(mact, hoten, diachi, sdt, email, cmnd);
				list_ct.add(ct);
			}
			con.close();
			return list_ct;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//lay ChuTro qua maCT
	public ChuTro getChuTro(String mact)
	{
		DBConnect connect = new DBConnect();
		Connection con = connect.getConnection();
			String sql="Select * from chutro where MaCT ='"+ mact+"'";
			PreparedStatement ps;
			try {
				ps = con.prepareCall(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					ChuTro ct = new ChuTro();
					ct.setMact(mact);
					ct.setHoten(rs.getString("HoTen"));
					ct.setDiachi(rs.getString("DiaChi"));
					ct.setSdt(rs.getString("SoDT"));
					ct.setCmnd(rs.getString("CMND"));
					ct.setEmail(rs.getString("Email"));
					con.close();
					return ct;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
	public void insertChuTro(String mact, String hoten, String diachi, String sodt, String email, String CMND)
	{
		try {
			DBConnect connect = new DBConnect();
			java.sql.Connection con = connect.getConnection();
			
			String insertTableSQL = "insert into chutro"
					+ "(MaCT, HoTen, DiaChi, SoDT, Email, CMND) values"
					+ "(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, mact);
			preparedStatement.setString(2, hoten);
			preparedStatement.setString(3, diachi);
			preparedStatement.setString(4, sodt);
			preparedStatement.setString(5, email);
			preparedStatement.setString(6, CMND);

			// execute insert SQL statement
			preparedStatement .executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateChuTro(String mact, String hoten, String diachi, String sodt, String email, String CMND)
	{
		try {
			DBConnect connect = new DBConnect();
			java.sql.Connection con = connect.getConnection();
			
			String insertTableSQL = "update chutro set HoTen = ?, DiaChi=?, SoDT=?, Email=?, CMND=? "
					+ "where MaCT = ?";
			PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setString(6, mact);
			preparedStatement.setString(1, hoten);
			preparedStatement.setString(2, diachi);
			preparedStatement.setString(3, sodt);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, CMND);

			// execute insert SQL statement
			preparedStatement .executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}