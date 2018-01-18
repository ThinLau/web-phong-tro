package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import models.TaiKhoan;

public class TaiKhoanDao {
	
	public List<TaiKhoan> getTaiKhoans()
	{
	DBConnect connect = new DBConnect();
	Connection con = connect.getConnection();
	
	String sql="select * from taikhoan where TenTK != 'admin'";
	PreparedStatement ps;
	try {
		ps = con.prepareCall(sql);
		ResultSet rs=ps.executeQuery();
		List<TaiKhoan> list_tk =new ArrayList<TaiKhoan>();
		while(rs.next()){
			String tentk = rs.getString("TenTK");
			String matkhau = rs.getString("MatKhau");
			String email = rs.getString("Email");
			String trangthai = rs.getString("TrangThai");
			Double cash = rs.getDouble("Cash");
			
			TaiKhoan tk = new TaiKhoan(tentk, matkhau, email, trangthai, cash);
			list_tk.add(tk);
		}
		con.close();
		return list_tk;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}
	public TaiKhoan login(String tentaikhoan, String matkhau)
	{
		try {
			DBConnect connect = new DBConnect();
			Connection con = connect.getConnection();
			
			String sql = "select * from taikhoan where TenTK = ?  and MatKhau = ?";
			
			ResultSet rs;
			PreparedStatement st =  con.prepareCall(sql);
			st.setString(1,tentaikhoan);
			st.setString(2,matkhau);
			
			rs = st.executeQuery();
			
				if(rs.next())
				{
					TaiKhoan tk =new TaiKhoan();
					tk.setTentk(rs.getString("TenTk"));
					tk.setMatkhau(rs.getString("MatKhau"));
					tk.setTrangthai(rs.getString("TrangThai"));
					tk.setEmail(rs.getString("Email"));
					tk.setCash(rs.getDouble("Cash"));
					con.close();
					return tk;
				}
				con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	}

	public ArrayList<TaiKhoan> getTKs()
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		
		String sql="Select * from taikhoan ";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			ArrayList<TaiKhoan> list_tk =new ArrayList<>();
			while(rs.next()){
				TaiKhoan tk =new TaiKhoan();
				tk.setTentk(rs.getString("TenTk"));
				tk.setMatkhau(rs.getString("MatKhau"));
				tk.setTrangthai(rs.getString("TrangThai"));
				tk.setEmail(rs.getString("Email"));
				list_tk.add(tk);
				
			}	
			con.close();
			return list_tk;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void insertTaiKhoan(String tentk, String matKhau, String email)
	{
		try {
			DBConnect connect = new DBConnect();
			java.sql.Connection con = connect.getConnection();
			
			String insertTableSQL = "insert into taikhoan"
					+ "(TenTK, MatKhau, Email,TrangThai,Cash) values"
					+ "(?,?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, tentk);
			preparedStatement.setString(2, matKhau);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, "Hoạt động");
			preparedStatement.setDouble(5,12);
			// execute insert SQL statement
			preparedStatement .executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}
		public void updateTaiKhoan(String tentk, Double cash)
		{
			try {
				DBConnect connect = new DBConnect();
				java.sql.Connection con = connect.getConnection();
				Statement st = con.createStatement();
				st.execute("update taikhoan set"
						+ "Cash = '"+ cash +"' where TenTK ='"+tentk+"'");
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public void updatePass(String tentk, String new_pass)
		{
			try {
				DBConnect connect = new DBConnect();
				java.sql.Connection con = connect.getConnection();
				
				String insertTableSQL = "update taikhoan set MatKhau=? "
						+ "where TenTK = ?";
				PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);

				preparedStatement.setString(1, new_pass);
				preparedStatement.setString(2, tentk);

				preparedStatement .executeUpdate();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void deleteTaiKhoan(String tentaikhoan)
		{
			DBConnect connect = new DBConnect();
			java.sql.Connection con = connect.getConnection();
			Statement st = null;
			
			try {
				st = con.createStatement();
				String sql="DELETE FROM taikhoan "+ "WHERE TenTK = '"+tentaikhoan+"'" ;
				st.execute(sql);
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public void blockAccount(String tentaikhoan)
		{
			DBConnect connect = new DBConnect();
			java.sql.Connection con = connect.getConnection();
			Statement st = null;
			
			try {
				System.out.println(tentaikhoan);
				st = con.createStatement();
				String sql="update taikhoan set TrangThai= N'Khóa' where tentaikhoan ='"+tentaikhoan+"'" ;
				st.execute(sql);
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public void OpenAccount(String tentaikhoan)
		{
			DBConnect connect = new DBConnect();
			java.sql.Connection con = connect.getConnection();
			Statement st = null;
			
			try {
				st = con.createStatement();
				String sql="update taikhoan set trangthai= N'Hoạt động' where tentaikhoan ='"+tentaikhoan+"'" ;
				st.execute(sql);
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public boolean checkemail(String email)
		{
			try {
				DBConnect connect = new DBConnect();
				java.sql.Connection con = connect.getConnection();
				ResultSet rs;
				Statement st = (Statement) con.createStatement();
				rs = st.executeQuery("select * from taikhoan where Email='"+email+"'");
					if(rs.next())
					{
						return true;
					}
					con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return false;
		}
		public boolean checkpass(String taikhoan, String pass)
		{
			try {
				DBConnect connect = new DBConnect();
				java.sql.Connection con = connect.getConnection();
				ResultSet rs;
				Statement st = (Statement) con.createStatement();
				rs = st.executeQuery("select * from taikhoan where TenTK = '"+taikhoan+"' and MatKhau='"+pass+"'");
					if(rs.next())
					{
						return true;
					}
					con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return false;
		}
		public boolean checktaikhoan(String tentk)
		{
			try {
				DBConnect connect = new DBConnect();
				java.sql.Connection con = connect.getConnection();
				ResultSet rs;
				Statement st = (Statement) con.createStatement();
				rs = st.executeQuery("select * from taikhoan where TenTK='"+tentk+"'");
					if(rs.next())
					{
						return true;
					}
					con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return false;
		}
		public ArrayList<TaiKhoan> getUsername(String tentk)
		{
			DBConnect connect = new DBConnect();
			java.sql.Connection con = connect.getConnection();
			
			String sql="Select * from taikhoan ";
			PreparedStatement ps;
			try {
				ps = con.prepareCall(sql);
				ResultSet rs=ps.executeQuery();
				ArrayList<TaiKhoan> list_tk =new ArrayList<>();
				while(rs.next()){
					TaiKhoan tk =new TaiKhoan();
					tk.setTentk(rs.getString("TenTk"));
					tk.setMatkhau(rs.getString("MatKhau"));
					tk.setTrangthai(rs.getString("TrangThai"));
					tk.setEmail(rs.getString("Email"));
					list_tk.add(tk);
					
				}	
				con.close();
				return list_tk;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
}
