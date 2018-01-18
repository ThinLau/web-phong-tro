package models;

public class TaiKhoan {
	String tentk;
	String matkhau;
	String email;
	String trangthai;
	double cash;
	public String getTentk() {
		return tentk;
	}
	public void setTentk(String tentk) {
		this.tentk = tentk;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public double getCash() {
		return cash;
	}
	public void setCash(double cash) {
		this.cash = cash;
	}
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiKhoan(String tentk, String matkhau, String email,
			String tranthai, double cash) {
		super();
		this.tentk = tentk;
		this.matkhau = matkhau;
		this.email = email;
		this.trangthai = tranthai;
		this.cash = cash;
	}
	
	
	
}
