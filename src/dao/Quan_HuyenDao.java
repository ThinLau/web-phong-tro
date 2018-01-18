package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Quan_Huyen;
import models.Tinh_TP;
import connect.DBConnect;

public class Quan_HuyenDao {
	
	public ArrayList<Quan_Huyen> getAllQuan_Huyen( )
	{
		DBConnect connect = new DBConnect();
		Connection con = connect.getConnection();
		
		String sql="select * from huyen_quan order by TenQuan ";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			ArrayList<Quan_Huyen> list_qh =new ArrayList<>();
			while(rs.next()){
				int maQuan_Huyen = rs.getInt("MaQuan");
				String tenQuan_Huyen = rs.getString("TenQuan");
				int maTinh_TP = rs.getInt("MaTP");
				Tinh_TPDao ttpd = new Tinh_TPDao();
				Tinh_TP ttp = ttpd.getTinh_TP(maTinh_TP);
				Quan_Huyen t_tp = new Quan_Huyen(maQuan_Huyen,tenQuan_Huyen,maTinh_TP,ttp);
				list_qh.add(t_tp);
			}
			con.close();
			return list_qh;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Quan_Huyen getQuan_Huyen(int maQuan_Huyen)
	{
		DBConnect connect = new DBConnect();
		Connection con = connect.getConnection();
		
		String sql="select * from huyen_quan where MaQuan ='"+maQuan_Huyen+"'";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String tenQuan_Huyen = rs.getString("TenQuan");
				int maTinh_TP = rs.getInt("MaTP");
				
				Tinh_TPDao ttpd = new Tinh_TPDao();
				Tinh_TP ttp = ttpd.getTinh_TP(maTinh_TP);
				Quan_Huyen qh = new Quan_Huyen(maQuan_Huyen,tenQuan_Huyen,maTinh_TP,ttp);
				con.close();
				return qh;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
