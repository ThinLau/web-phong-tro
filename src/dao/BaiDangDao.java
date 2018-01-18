package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.BaiDang;
import models.ChuTro;
import models.DiaChi;
import connect.DBConnect;

public class BaiDangDao {

	public List<BaiDang> getBaiDangs()
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		
		String sql="select * from baidang order by ngaydang desc,giodang desc";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			List<BaiDang> list_bd =new ArrayList<BaiDang>();
			while(rs.next()){
				int mabd = rs.getInt("MaBD");
				String tieude = rs.getString("TieuDe");
				String ngaydang = rs.getString("ngaydang");
				String ngayhethan = rs.getString("ngayhethan");
				ngayhethan = ngayhethan.substring(8,10)+"-"+ngayhethan.substring(5,7) + "-" + ngayhethan.substring(0, 4);
				ngaydang = ngaydang.substring(8,10)+"-"+ngaydang.substring(5,7) + "-" + ngaydang.substring(0, 4);				
				String giodang = rs.getString("giodang");
				int soluongphong = rs.getInt("soluongphong");
				String mota = rs.getString("mota");
				mota= mota.replaceAll("<br/>"," ");
				if(mota.length() > 142)
					mota = mota.substring(0, 200)+"...";
				
				String giaphong = rs.getString("giaphong");
				String anh = rs.getString("anhbia");
				int dientich = rs.getInt("dientich");
				int songuoi = rs.getInt("songuoi");
				String loaitin = rs.getString("loaitin");
				String doituong = rs.getString("doituong");
				String trangthai = rs.getString("trangthai");
				ChuTroDao ctd = new ChuTroDao();
				DiaChiDao dcd = new DiaChiDao();
				
				DiaChi dc = dcd.getDiaChi(mabd);

				String mact = rs.getString("MaCT");
				ChuTro ct = ctd.getChuTro(mact);
				//System.out.println(ct.getHoten());
				BaiDang bd = new BaiDang(mabd, tieude, ngaydang, giodang,
						soluongphong, mota, giaphong, anh, dientich, songuoi, 
						loaitin, doituong,trangthai, ct,dc, ngayhethan);
				
				list_bd.add(bd);
				
			}
			con.close();
			return list_bd;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<BaiDang> getBaiDangs_CT(String mact)
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		
		String sql="select * from baidang where MaCT = '"+mact+"' order by ngaydang desc,giodang desc";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			List<BaiDang> list_bd =new ArrayList<BaiDang>();
			while(rs.next()){
				int mabd = rs.getInt("MaBD");
				String tieude = rs.getString("TieuDe");
				String ngaydang = rs.getString("ngaydang");
				String ngayhethan = rs.getString("ngayhethan");
				ngayhethan = ngayhethan.substring(8,10)+"-"+ngayhethan.substring(5,7) + "-" + ngayhethan.substring(0, 4);
				ngaydang = ngaydang.substring(8,10)+"-"+ngaydang.substring(5,7) + "-" + ngaydang.substring(0, 4);				
				String giodang = rs.getString("giodang");
				int soluongphong = rs.getInt("soluongphong");
				String mota = rs.getString("mota");
				if(mota.length() > 142)
					mota = mota.substring(0, 142)+"...";
				
				String giaphong = rs.getString("giaphong");
				String anh = rs.getString("anhbia");
				int dientich = rs.getInt("dientich");
				int songuoi = rs.getInt("songuoi");
				String loaitin = rs.getString("loaitin");
				String doituong = rs.getString("doituong");
				String trangthai = rs.getString("trangthai");
				ChuTroDao ctd = new ChuTroDao();
				DiaChiDao dcd = new DiaChiDao();
				
				DiaChi dc = dcd.getDiaChi(mabd);

				ChuTro ct = ctd.getChuTro(mact);
				//System.out.println(ct.getHoten());
				BaiDang bd = new BaiDang(mabd, tieude, ngaydang, giodang,
						soluongphong, mota, giaphong, anh, dientich, songuoi, 
						loaitin, doituong,trangthai, ct,dc, ngayhethan);
				
				list_bd.add(bd);
				
			}
			con.close();
			return list_bd;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<BaiDang> getBaiDangs_chutro()
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		
		String sql="select * from baidang where MaCT != 'admin' order by ngaydang desc,giodang desc";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			List<BaiDang> list_adminbd =new ArrayList<BaiDang>();
			while(rs.next()){
				int mabd = rs.getInt("MaBD");
				String tieude = rs.getString("TieuDe");
				String ngaydang = rs.getString("ngaydang");
				String ngayhethan = rs.getString("ngayhethan");
				ngayhethan = ngayhethan.substring(8,10)+"-"+ngayhethan.substring(5,7) + "-" + ngayhethan.substring(0, 4);
				ngaydang = ngaydang.substring(8,10)+"-"+ngaydang.substring(5,7) + "-" + ngaydang.substring(0, 4);				
				String giodang = rs.getString("giodang");
				int soluongphong = rs.getInt("soluongphong");
				String mota = rs.getString("mota");
				if(mota.length() > 142)
					mota = mota.substring(0, 142)+"...";
				
				String giaphong = rs.getString("giaphong");
				String anh = rs.getString("anhbia");
				int dientich = rs.getInt("dientich");
				int songuoi = rs.getInt("songuoi");
				String loaitin = rs.getString("loaitin");
				String doituong = rs.getString("doituong");
				String trangthai = rs.getString("trangthai");
				ChuTroDao ctd = new ChuTroDao();
				DiaChiDao dcd = new DiaChiDao();
				
				DiaChi dc = dcd.getDiaChi(mabd);

				String mact = rs.getString("MaCT");
				ChuTro ct = ctd.getChuTro(mact);
				//System.out.println(ct.getHoten());
				BaiDang bd = new BaiDang(mabd, tieude, ngaydang, giodang,
						soluongphong, mota, giaphong, anh, dientich, songuoi, 
						loaitin, doituong,trangthai, ct,dc, ngayhethan);
				
				list_adminbd.add(bd);
				
			}
			con.close();
			return list_adminbd;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// Tin moidang
	
	public BaiDang getBaiDang(int mabaidang)
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		
		String sql="select * from baidang where MaBD =" +mabaidang;
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int mabd = rs.getInt("MaBD");
				String tieude = rs.getString("TieuDe");
				String ngaydang = rs.getString("ngaydang");
				ngaydang = ngaydang.substring(8,10)+"-"+ngaydang.substring(5,7) + "-" + ngaydang.substring(0, 4);
				String ngayhethan = rs.getString("ngayhethan");
				ngayhethan = ngayhethan.substring(8,10)+"-"+ngayhethan.substring(5,7) + "-" + ngayhethan.substring(0, 4);
				String giodang = rs.getString("giodang");
				int soluongphong = rs.getInt("soluongphong");
				String mota = rs.getString("mota");
				String giaphong = rs.getString("giaphong");
				String anh = rs.getString("anhbia");
				int dientich = rs.getInt("dientich");
				int songuoi = rs.getInt("songuoi");
				String loaitin = rs.getString("loaitin");
				String doituong = rs.getString("doituong");
				String trangthai = rs.getString("trangthai");
				
				ChuTroDao ctd = new ChuTroDao();
				DiaChiDao dcd = new DiaChiDao();
				
				DiaChi dc = dcd.getDiaChi(mabd);

				String mact = rs.getString("MaCT");
				ChuTro ct = ctd.getChuTro(mact);
				BaiDang bd = new BaiDang(mabd, tieude, ngaydang, giodang,
						soluongphong, mota, giaphong, anh, dientich, songuoi, 
						loaitin, doituong,trangthai, ct,dc,ngayhethan);
				con.close();
				return bd;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int getLastMaBD()
	{
		DBConnect connect = new DBConnect();
		Connection con = connect.getConnection();
		
		String sql="SELECT MaBD FROM baidang ORDER BY  MaBD DESC LIMIT  1";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				return Integer.parseInt(rs.getString("MaBD"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public boolean insertBaiDang(int mabd, String tieude,String mact, String loaichuyenmuc,String mota, String giaphong, 
			int songuoi, int dientich, String doituong, String ngaydang, String giodang, String anhbia, String ngayhethan)
	{
		try {
			DBConnect connect = new DBConnect();
			Connection con = connect.getConnection();
			
			String insertTableSQL = "insert into baidang"
					+ "(MaBD, TieuDe, MaCT,ngaydang,giodang,mota,giaphong,dientich,songuoi,loaitin,"
					+ "doituong,anhbia,trangthai,ngayhethan) values"
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setInt(1, mabd);
			preparedStatement.setString(2, tieude);
			preparedStatement.setString(3, mact);
			preparedStatement.setString(4, ngaydang);
			preparedStatement.setString(5, giodang);
			preparedStatement.setString(6, mota);
			preparedStatement.setString(7, giaphong);
			preparedStatement.setInt(8, dientich);
			preparedStatement.setInt(9, songuoi);
			preparedStatement.setString(10, loaichuyenmuc);
			preparedStatement.setString(11, doituong);
			preparedStatement.setString(12, anhbia);
			preparedStatement.setString(13, "Chưa duyệt");
			preparedStatement.setString(14, ngayhethan);
			// execute insert SQL statement
			preparedStatement .executeUpdate();
			con.close();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateBaiDang(int mabd, String tieude,String mact, String loaichuyenmuc,String mota, String giaphong, 
			int songuoi, int dientich, String doituong, String ngaydang, String giodang, String anhbia, String ngayhethan)
	{
		try {
			DBConnect connect = new DBConnect();
			Connection con = connect.getConnection();
			
			String insertTableSQL = "update baidang set"
					+ "(TieuDe = ?, MaCT=?,mota=?,giaphong=?,dientich=?,songuoi=?,loaitin=?,doituong=?,anhbia=?)  "
					+" where MaBD= ?";
			PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setInt(10, mabd);
			preparedStatement.setString(1, tieude);
			preparedStatement.setString(2, mact);
			preparedStatement.setString(3, mota);
			preparedStatement.setString(4, giaphong);
			preparedStatement.setInt(5, dientich);
			preparedStatement.setInt(6, songuoi);
			preparedStatement.setString(7, loaichuyenmuc);
			preparedStatement.setString(8, doituong);
			preparedStatement.setString(9, anhbia);
			// execute insert SQL statement
			preparedStatement .executeUpdate();
			con.close();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public void deleteBaiDang(int mabd)
	{
		try {
			DBConnect connect = new DBConnect();
			Connection con = connect.getConnection();
			
			String insertTableSQL = "delete from baidang "
					+" where MaBD= ?";
			PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setInt(1, mabd);
			
			// execute insert SQL statement
			preparedStatement .executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<BaiDang> getBaiDangs_trangthai()
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		
		String sql="select * from baidang where MaCT != 'admin' and trangthai = 'Chưa duyệt' order by ngaydang desc,giodang desc";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			List<BaiDang> list_trangthai =new ArrayList<BaiDang>();
			while(rs.next()){
				int mabd = rs.getInt("MaBD");
				String tieude = rs.getString("TieuDe");
				String ngaydang = rs.getString("ngaydang");
				String ngayhethan = rs.getString("ngayhethan");
				ngayhethan = ngayhethan.substring(8,10)+"-"+ngayhethan.substring(5,7) + "-" + ngayhethan.substring(0, 4);
				ngaydang = ngaydang.substring(8,10)+"-"+ngaydang.substring(5,7) + "-" + ngaydang.substring(0, 4);				
				String giodang = rs.getString("giodang");
				int soluongphong = rs.getInt("soluongphong");
				String mota = rs.getString("mota");
				if(mota.length() > 142)
					mota = mota.substring(0, 142)+"...";
				
				String giaphong = rs.getString("giaphong");
				String anh = rs.getString("anhbia");
				int dientich = rs.getInt("dientich");
				int songuoi = rs.getInt("songuoi");
				String loaitin = rs.getString("loaitin");
				String doituong = rs.getString("doituong");
				String trangthai = rs.getString("trangthai");
				ChuTroDao ctd = new ChuTroDao();
				DiaChiDao dcd = new DiaChiDao();
				
				DiaChi dc = dcd.getDiaChi(mabd);

				String mact = rs.getString("MaCT");
				ChuTro ct = ctd.getChuTro(mact);
				BaiDang bd = new BaiDang(mabd, tieude, ngaydang, giodang,
						soluongphong, mota, giaphong, anh, dientich, songuoi, 
						loaitin, doituong,trangthai, ct,dc, ngayhethan);
				
				list_trangthai.add(bd);
				
			}
			con.close();
			return list_trangthai;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void updateTrangThaibd(int mabd)
	{
		try {
			DBConnect connect = new DBConnect();
			Connection con = connect.getConnection();
			
			String insertTableSQL = "update baidang set"
					+ " TrangThai=? "
					+" where MaBD= ?";
			PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setInt(2, mabd);
			preparedStatement.setString(1, "Đã duyệt");
			
			// execute insert SQL statement
			preparedStatement .executeUpdate();
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
}
