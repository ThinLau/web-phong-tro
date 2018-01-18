package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Duong;
import models.Phuong_Xa;
import connect.DBConnect;

public class DuongDao {
	public ArrayList<Duong> getAllDuong()
	{
		DBConnect connect = new DBConnect();
		Connection con = connect.getConnection();
		
		String sql="select * from duong order by TenDuong ";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			ArrayList<Duong> list_duong =new ArrayList<>();
			while(rs.next()){
				int maDuong = rs.getInt("MaDuong");
				String tenDuong = rs.getString("TenDuong");
				int maPhuong = rs.getInt("MaPhuong");
				Phuong_XaDao pxd = new Phuong_XaDao();
				Phuong_Xa px = pxd.getPhuong_Xa(maPhuong);
				
				Duong d = new Duong(maDuong, tenDuong, maPhuong, px);
				list_duong.add(d);
			}
			con.close();
			return list_duong;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Duong getDuong(int maDuong)
	{
		DBConnect connect = new DBConnect();
		Connection con = connect.getConnection();
		
		String sql="select * from xa_phuong where MaPhuong ='"+maDuong+"'";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String tenDuong = rs.getString("TenDuong");
				int maPhuong_Xa = rs.getInt("MaPhuong");
				
				Phuong_XaDao pxd = new Phuong_XaDao();
				Phuong_Xa px = pxd.getPhuong_Xa(maPhuong_Xa);
				Duong d = new Duong(maDuong, tenDuong, maPhuong_Xa, px);
				con.close();
				return d;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
