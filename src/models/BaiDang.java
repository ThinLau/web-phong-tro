package models;


public class BaiDang {
	int mabd;
	String tieude;
	String ngaydang;
	String ngayhethan;
	String giodang;
	int soluongphong;
	String mota;
	String giaphong;
	String anhbia;
	public String getNgayhethan() {
		return ngayhethan;
	}
	public void setNgayhethan(String ngayhethan) {
		this.ngayhethan = ngayhethan;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	int dientich;
	int songuoi;
	String loaitin;
	String doituong;
	String trangthai;
	
	ChuTro chutro;
	DiaChi diachi;
	
	
	
	public ChuTro getChutro() {
		return chutro;
	}
	public void setChutro(ChuTro chutro) {
		this.chutro = chutro;
	}
	public DiaChi getDiachi() {
		return diachi;
	}
	public void setDiachi(DiaChi diachi) {
		this.diachi = diachi;
	}
	public BaiDang(int mabd, String tieude, String ngaydang, String giodang,
			int soluongphong, String mota, String giaphong, String anhbia,
			int dientich, int songuoi, String loaitin, String doituong, String trangthai,
			ChuTro chutro, DiaChi diachi,String ngayhethan) {
		super();
		this.mabd = mabd;
		this.tieude = tieude;
		this.ngaydang = ngaydang;
		this.giodang = giodang;
		this.soluongphong = soluongphong;
		this.mota = mota;
		this.giaphong = giaphong;
		this.anhbia = anhbia;
		this.dientich = dientich;
		this.songuoi = songuoi;
		this.loaitin = loaitin;
		this.doituong = doituong;
		this.chutro = chutro;
		this.diachi = diachi;
		this.trangthai = trangthai;
		this.ngayhethan = ngayhethan;
	}
	public int getMabd() {
		return mabd;
	}
	public void setMabd(int mabd) {
		this.mabd = mabd;
	}
	public String getTieude() {
		return tieude;
	}
	public void setTieude(String tieude) {
		this.tieude = tieude;
	}
	public String getNgaydang() {
		return ngaydang;
	}
	public void setNgaydang(String ngaydang) {
		this.ngaydang = ngaydang;
	}
	public String getGiodang() {
		return giodang;
	}
	public void setGiodang(String giodang) {
		this.giodang = giodang;
	}
	public int getSoluongphong() {
		return soluongphong;
	}
	public void setSoluongphong(int soluongphong) {
		this.soluongphong = soluongphong;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getGiaphong() {
		return giaphong;
	}
	public void setGiaphong(String giaphong) {
		this.giaphong = giaphong;
	}
	public String getAnh() {
		return anhbia;
	}
	public void setAnh(String anh) {
		this.anhbia = anh;
	}
	public int getDientich() {
		return dientich;
	}
	public void setDientich(int dientich) {
		this.dientich = dientich;
	}
	public int getSonguoi() {
		return songuoi;
	}
	public void setSonguoi(int songuoi) {
		this.songuoi = songuoi;
	}
	public String getLoaitin() {
		return loaitin;
	}
	public void setLoaitin(String loaitin) {
		this.loaitin = loaitin;
	}
	public String getDoituong() {
		return doituong;
	}
	public void setDoituong(String doituong) {
		this.doituong = doituong;
	}
	
	public BaiDang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
