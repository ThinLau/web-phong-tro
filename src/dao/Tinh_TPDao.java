package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Tinh_TP;
import connect.DBConnect;

public class Tinh_TPDao {

	public ArrayList<Tinh_TP> getTinh_TPs()
	{
		try {
			DBConnect connect = new DBConnect();
			Connection con = connect.getConnection();
			
			String sql="select * from tinh_tp order by TenTP ";
			PreparedStatement ps;
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			ArrayList<Tinh_TP> list_ttp =new ArrayList<>();
			while(rs.next()){
				int maTinh_TP = rs.getInt("MaTP");
				String tenTinh_TP = rs.getString("TenTP");
				
				Tinh_TP t_tp = new Tinh_TP(maTinh_TP,tenTinh_TP);
				list_ttp.add(t_tp);
			}
			con.close();
			return list_ttp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Tinh_TP getTinh_TP(int maTinh_TP)
	{
		DBConnect connect = new DBConnect();
		Connection con = connect.getConnection();
		
		String sql="select * from tinh_tp where MaTP ='"+maTinh_TP+"'";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String tenTinh_TP = rs.getString("TenTP");
				
				Tinh_TP ttp = new Tinh_TP(maTinh_TP,tenTinh_TP);
				con.close();
				return ttp;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
