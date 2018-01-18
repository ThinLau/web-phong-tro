package models;

public class Quan_Huyen {
	int maQuan_Huyen;
	String tenQuan_Huyen;
	int maTinh_TP;
	Tinh_TP ttp;
	public Tinh_TP getTtp() {
		return ttp;
	}
	public void setTtp(Tinh_TP ttp) {
		this.ttp = ttp;
	}
	public int getMaQuan_Huyen() {
		return maQuan_Huyen;
	}
	public void setMaQuan_Huyen(int maQuan_Huyen) {
		this.maQuan_Huyen = maQuan_Huyen;
	}
	public String getTenQuan_Huyen() {
		return tenQuan_Huyen;
	}
	public void setTenQuan_Huyen(String tenQuan_Huyen) {
		this.tenQuan_Huyen = tenQuan_Huyen;
	}
	public int getMaTinh_TP() {
		return maTinh_TP;
	}
	public void setMaTinh_TP(int maTinh_TP) {
		this.maTinh_TP = maTinh_TP;
	}
	public Quan_Huyen(int maQuan_Huyen, String tenQuan_Huyen,
			int maTinh_TP,Tinh_TP ttp) {
		super();
		this.maQuan_Huyen = maQuan_Huyen;
		this.tenQuan_Huyen = tenQuan_Huyen;
		this.maTinh_TP = maTinh_TP;
		this.ttp = ttp;
	}
	public Quan_Huyen() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
