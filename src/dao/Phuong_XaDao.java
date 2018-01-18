package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Phuong_Xa;
import models.Quan_Huyen;
import connect.DBConnect;

public class Phuong_XaDao {


	public ArrayList<Phuong_Xa> getAllQuan_Huyen()
	{
		DBConnect connect = new DBConnect();
		Connection con = connect.getConnection();
		
		String sql="select * from xa_phuong order by TenPhuong ";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			ArrayList<Phuong_Xa> list_px =new ArrayList<>();
			while(rs.next()){
				int maPhuong_Xa = rs.getInt("MaPhuong");
				String tenPhuong_Xa = rs.getString("TenPhuong");
				int maQuan_Huyen = rs.getInt("MaQuan");
				Quan_HuyenDao qhd = new Quan_HuyenDao();
				Quan_Huyen qh = qhd.getQuan_Huyen(maQuan_Huyen);
				
				Phuong_Xa t_tp = new Phuong_Xa(maPhuong_Xa,tenPhuong_Xa,maQuan_Huyen,qh);
				list_px.add(t_tp);
			}
			con.close();
			return list_px;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Phuong_Xa getPhuong_Xa(int maPhuong_Xa)
	{
		DBConnect connect = new DBConnect();
		Connection con = connect.getConnection();
		
		String sql="select * from xa_phuong where MaPhuong ='"+maPhuong_Xa+"'";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String tenPhuong_Xa = rs.getString("TenPhuong");
				int maQuan_Huyen = rs.getInt("MaQuan");
				
				Quan_HuyenDao qhd = new Quan_HuyenDao();
				Quan_Huyen qh = qhd.getQuan_Huyen(maQuan_Huyen);
				Phuong_Xa px = new Phuong_Xa(maPhuong_Xa,tenPhuong_Xa,maQuan_Huyen,qh);
				con.close();
				return px;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
