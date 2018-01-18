package models;

public class DiaChi {
	int mabaidang;
	String tinh_tp;
	String quan_huyen;
	String xa_phuong;
	String duong;
	String diachichinhxac;
	String toado;
	public String getToado() {
		return toado;
	}
	public void setToado(String toado) {
		this.toado = toado;
	}
	public int getMabaidang() {
		return mabaidang;
	}
	public void setMabaidang(int mabaidang) {
		this.mabaidang = mabaidang;
	}
	public String getTinh_tp() {
		return tinh_tp;
	}
	public void setTinh_tp(String tinh_tp) {
		this.tinh_tp = tinh_tp;
	}
	public String getQuan_huyen() {
		return quan_huyen;
	}
	public void setQuan_huyen(String quan_huyen) {
		this.quan_huyen = quan_huyen;
	}
	public String getXa_phuong() {
		return xa_phuong;
	}
	public void setXa_phuong(String xa_phuong) {
		this.xa_phuong = xa_phuong;
	}
	public String getDuong() {
		return duong;
	}
	public void setDuong(String duong) {
		this.duong = duong;
	}
	public String getDiachichinhxac() {
		return diachichinhxac;
	}
	public void setDiachichinhxac(String diachichinhxac) {
		this.diachichinhxac = diachichinhxac;
	}
	public DiaChi(int mabaidang, String tinh_tp, String quan_huyen,
			String xa_phuong, String duong, String diachichinhxac, String toado) {
		super();
		this.mabaidang = mabaidang;
		this.tinh_tp = tinh_tp;
		this.quan_huyen = quan_huyen;
		this.xa_phuong = xa_phuong;
		this.duong = duong;
		this.diachichinhxac = diachichinhxac;
		this.toado = toado;
	}
	public DiaChi() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	
	
}
