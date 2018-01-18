package models;

public class Duong {
	int maDuong;
	String tenDuong;
	int maPhuong;
	Phuong_Xa px;
	
	public int getMaDuong() {
		return maDuong;
	}

	public void setMaDuong(int maDuong) {
		this.maDuong = maDuong;
	}

	public String getTenDuong() {
		return tenDuong;
	}

	public void setTenDuong(String tenDuong) {
		this.tenDuong = tenDuong;
	}

	public int getMaPhuong() {
		return maPhuong;
	}

	public void setMaPhuong(int maPhuong) {
		this.maPhuong = maPhuong;
	}

	public Phuong_Xa getPx() {
		return px;
	}

	public void setPx(Phuong_Xa px) {
		this.px = px;
	}
	
	public Duong(int maDuong, String tenDuong, int maPhuong, Phuong_Xa px) {
		super();
		this.maDuong = maDuong;
		this.tenDuong = tenDuong;
		this.maPhuong = maPhuong;
		this.px = px;
	}

	public Duong()
	{
		super();
	}
}
