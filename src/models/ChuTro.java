package models;

public class ChuTro {
	String mact;
	String hoten;
	String diachi;
	String sdt;
	String cmnd;
	String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMact() {
		return mact;
	}
	public void setMact(String mact) {
		this.mact = mact;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public ChuTro(String mact, String hoten, String diachi, String sdt,String email, String cmnd) {
		super();
		this.mact = mact;
		this.hoten = hoten;
		this.diachi = diachi;
		this.sdt = sdt;
		this.cmnd = cmnd;
		this.email = email;
	}
	public ChuTro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
