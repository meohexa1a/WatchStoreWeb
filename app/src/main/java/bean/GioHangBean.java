package bean;

public class GioHangBean {
	private int MaSanPham;
	private String TenSanPham;
	private String HinhAnh;
	private Long DonGia;
	private int SoLuong;
	private long ThanhTien;

	public GioHangBean() {
		super();
	}

	public GioHangBean(int maSanPham, String tenSanPham, String hinhAnh, Long donGia, int soLuong, long thanhTien) {
		super();
		MaSanPham = maSanPham;
		TenSanPham = tenSanPham;
		HinhAnh = hinhAnh;
		DonGia = donGia;
		SoLuong = soLuong;
		ThanhTien = thanhTien;
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

	public String getHinhAnh() {
		return HinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		HinhAnh = hinhAnh;
	}

	public Long getDonGia() {
		return DonGia;
	}

	public void setDonGia(Long donGia) {
		DonGia = donGia;
	}

	public int getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}

	public long getThanhTien() {
		ThanhTien = SoLuong * DonGia;
		return ThanhTien;
	}
}
