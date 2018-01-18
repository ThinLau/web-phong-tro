package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.DiaChi;
import connect.DBConnect;

public class DiaChiDao {

	//lay DiaChi qua mabaidang
		public DiaChi getDiaChi(int mabd)
		{
			DBConnect connect = new DBConnect();
			java.sql.Connection con = connect.getConnection();
				
				String sql="Select * from diachi where mabaidang = "+ mabd;
				PreparedStatement ps;
				try {
					ps = con.prepareCall(sql);
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						DiaChi dc = new DiaChi();
						dc.setMabaidang(mabd);
						dc.setTinh_tp(rs.getString("tinh_tp"));
						dc.setQuan_huyen(rs.getString("quan_huyen"));
						dc.setXa_phuong(rs.getString("xa_phuong"));
						dc.setDuong(rs.getString("duong"));
						dc.setDiachichinhxac(rs.getString("diachichinhxac"));
						dc.setToado(rs.getString("toado"));
						con.close();
						return dc;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
		}
	
	public void insertDiaChi(int mabd, String tinh_tp, String quan_huyen, String phuong_xa, String duong,
		String diachichinhxac,String toado)
		{
			try {
				DBConnect connect = new DBConnect();
				Connection con = connect.getConnection();
				
				String insertTableSQL = "insert into diachi"
						+ "(mabaidang, tinh_tp, quan_huyen,xa_phuong,duong,diachichinhxac,toado) values"
						+ "(?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
				preparedStatement.setInt(1, mabd);
				preparedStatement.setString(2, tinh_tp);
				preparedStatement.setString(3, quan_huyen);
				preparedStatement.setString(4, phuong_xa);
				preparedStatement.setString(5, duong);
				preparedStatement.setString(6, diachichinhxac);
				preparedStatement.setString(7, toado);
				// execute insert SQL statement
				preparedStatement .executeUpdate();
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	public void deleteDiaChi(int mabd)
			{
				try {
					DBConnect connect = new DBConnect();
					Connection con = connect.getConnection();
					
					String insertTableSQL = "delete from diachi where"
							+ "mabaidang"
							+ "?";
					PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
					preparedStatement.setInt(1, mabd);
					
					preparedStatement .executeUpdate();
					con.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
}
