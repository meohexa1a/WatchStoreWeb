package bean;

public class SanPhamBean {
	private int MaSanPham;
	private String TenSanPham;
	private long DonGia;
	private String HinhAnh;
	private String LoaiDongHo;
	private int MaNSX;
	private int MaDoiTuongSD;
	private boolean DaXoa;
	public SanPhamBean() {
		super();
	}
	public SanPhamBean(int maSanPham, String tenSanPham, long donGia, String hinhAnh, String loaiDongHo, int maNSX,
			int maDoiTuongSD, boolean daXoa) {
		super();
		MaSanPham = maSanPham;
		TenSanPham = tenSanPham;
		DonGia = donGia;
		HinhAnh = hinhAnh;
		LoaiDongHo = loaiDongHo;
		MaNSX = maNSX;
		MaDoiTuongSD = maDoiTuongSD;
		DaXoa = daXoa;
	}
	
	public boolean isDaXoa() {
		return DaXoa;
	}
	public void setDaXoa(boolean daXoa) {
		DaXoa = daXoa;
	}
	public int getMaSanPham() {
		return MaSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		MaSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return TenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		TenSanPham = tenSanPham;
	}
	public long getDonGia() {
		return DonGia;
	}
	public void setDonGia(long donGia) {
		DonGia = donGia;
	}
	public String getHinhAnh() {
		return HinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		HinhAnh = hinhAnh;
	}
	public String getLoaiDongHo() {
		return LoaiDongHo;
	}
	public void setLoaiDongHo(String loaiDongHo) {
		LoaiDongHo = loaiDongHo;
	}
	public int getMaNSX() {
		return MaNSX;
	}
	public void setMaNSX(int maNSX) {
		MaNSX = maNSX;
	}
	public int getMaDoiTuongSD() {
		return MaDoiTuongSD;
	}
	public void setMaDoiTuongSD(int maDoiTuongSD) {
		MaDoiTuongSD = maDoiTuongSD;
	}
}
