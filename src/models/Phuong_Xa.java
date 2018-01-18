package models;

public class Phuong_Xa {
	int maPhuong_Xa;
	String tenPhuong_Xa;
	int maQuan_Huyen;
	Quan_Huyen qh; 
	public Quan_Huyen getQh() {
		return qh;
	}
	public void setQh(Quan_Huyen qh) {
		this.qh = qh;
	}
	public int getMaPhuong_Xa() {
		return maPhuong_Xa;
	}
	public void setMaPhuong_Xa(int maPhuong_Xa) {
		this.maPhuong_Xa = maPhuong_Xa;
	}
	public String getTenPhuong_Xa() {
		return tenPhuong_Xa;
	}
	public void setTenPhuong_Xa(String tenPhuong_Xa) {
		this.tenPhuong_Xa = tenPhuong_Xa;
	}
	public int getMaQuan_Huyen() {
		return maQuan_Huyen;
	}
	public void setMaQuan_Huyen(int maQuan_Huyen) {
		this.maQuan_Huyen = maQuan_Huyen;
	}
	public Phuong_Xa(int maPhuong_Xa, String tenPhuong_Xa,
			int maQuan_Huyen, Quan_Huyen qh) {
		super();
		this.maPhuong_Xa = maPhuong_Xa;
		this.tenPhuong_Xa = tenPhuong_Xa;
		this.maQuan_Huyen = maQuan_Huyen;
		this.qh = qh;
	}
	public Phuong_Xa() {
		super();
	}
	
}
