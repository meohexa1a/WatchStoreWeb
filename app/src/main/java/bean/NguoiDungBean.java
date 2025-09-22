package bean;

public class NguoiDungBean {
	private int MaNguoiDung;
	private String TenNguoiDung;
	private String TenDangNhap;
	private String MatKhau;
	private Boolean Quyen;
	public NguoiDungBean() {
		super();
	}
	
	public NguoiDungBean(int maNguoiDung, String tenNguoiDung, String tenDangNhap, String matKhau, Boolean quyen) {
		super();
		MaNguoiDung = maNguoiDung;
		TenNguoiDung = tenNguoiDung;
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
		Quyen = quyen;
	}

	public int getMaNguoiDung() {
		return MaNguoiDung;
	}

	public void setMaNguoiDung(int maNguoiDung) {
		MaNguoiDung = maNguoiDung;
	}

	public String getTenNguoiDung() {
		return TenNguoiDung;
	}
	public void setTenNguoiDung(String tenNguoiDung) {
		TenNguoiDung = tenNguoiDung;
	}
	public String getTenDangNhap() {
		return TenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public Boolean getQuyen() {
		return Quyen;
	}
	public void setQuyen(Boolean quyen) {
		Quyen = quyen;
	}
}
