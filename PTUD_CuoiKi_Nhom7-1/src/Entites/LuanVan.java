package Entites;
 
public class LuanVan {
	private SinhVien SinhVien;
	private GiangVien giangVien;
	private String tenLuanVan;
	private String linhVuc;
	private String tomTatLuanVan;
	private String noiDung;
	private String mssv;
	private String maGiangVien;
	public LuanVan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LuanVan(Entites.SinhVien sinhVien, GiangVien giangVien, String tenLuanVan, String linhVuc,
			String tomTatLuanVan, String noiDung, String mssv, String maGiangVien) {
		super();
		SinhVien = sinhVien;
		this.giangVien = giangVien;
		this.tenLuanVan = tenLuanVan;
		this.linhVuc = linhVuc;
		this.tomTatLuanVan = tomTatLuanVan;
		this.noiDung = noiDung;
		this.mssv = mssv;
		this.maGiangVien = maGiangVien;
	}
	public SinhVien getSinhVien() {
		return SinhVien;
	}
	public void setSinhVien(SinhVien sinhVien) {
		SinhVien = sinhVien;
	}
	public GiangVien getGiangVien() {
		return giangVien;
	}
	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}
	public String getTenLuanVan() {
		return tenLuanVan;
	}
	public void setTenLuanVan(String tenLuanVan) {
		this.tenLuanVan = tenLuanVan;
	}
	public String getLinhVuc() {
		return linhVuc;
	}
	public void setLinhVuc(String linhVuc) {
		this.linhVuc = linhVuc;
	}
	public String getTomTatLuanVan() {
		return tomTatLuanVan;
	}
	public void setTomTatLuanVan(String tomTatLuanVan) {
		this.tomTatLuanVan = tomTatLuanVan;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getMssv() {
		return mssv;
	}
	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	public String getMaGiangVien() {
		return maGiangVien;
	}
	public void setMaGiangVien(String maGiangVien) {
		this.maGiangVien = maGiangVien;
	}
	@Override
	public String toString() {
		return "LuanVan [SinhVien=" + SinhVien + ", giangVien=" + giangVien + ", tenLuanVan=" + tenLuanVan
				+ ", linhVuc=" + linhVuc + ", tomTatLuanVan=" + tomTatLuanVan + ", noiDung=" + noiDung + ", mssv="
				+ mssv + ", maGiangVien=" + maGiangVien + "]";
	}
	
	
	
}
