package bean;

public class NhaSanXuatBean {
	private int MaNSX;
	private String TenNSX;
	public NhaSanXuatBean() {
		super();
	}
	public NhaSanXuatBean(int maNSX, String tenNSX) {
		super();
		MaNSX = maNSX;
		TenNSX = tenNSX;
	}
	public int getMaNSX() {
		return MaNSX;
	}
	public void setMaNSX(int maNSX) {
		MaNSX = maNSX;
	}
	public String getTenNSX() {
		return TenNSX;
	}
	public void setTenNSX(String tenNSX) {
		TenNSX = tenNSX;
	}
}
