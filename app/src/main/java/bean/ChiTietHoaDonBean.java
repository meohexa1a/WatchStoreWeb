package bean;

public class ChiTietHoaDonBean {
	private int MaChiTietHoaDon;
	private SanPhamBean sp;
	private Long SoLuong;
	private boolean DaMua;
	private Long ThanhTien;

	public ChiTietHoaDonBean() {
		super();
	}

	public ChiTietHoaDonBean(int maChiTietHoaDon, SanPhamBean sp, Long soLuong, boolean daMua, Long thanhTien) {
		super();
		MaChiTietHoaDon = maChiTietHoaDon;
		this.sp = sp;
		SoLuong = soLuong;
		DaMua = daMua;
		ThanhTien = thanhTien;
	}

	public int getMaChiTietHoaDon() {
		return MaChiTietHoaDon;
	}

	public void setMaChiTietHoaDon(int maChiTietHoaDon) {
		MaChiTietHoaDon = maChiTietHoaDon;
	}

	public SanPhamBean getSp() {
		return sp;
	}

	public void setSp(SanPhamBean sp) {
		this.sp = sp;
	}

	public Long getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(Long soLuong) {
		SoLuong = soLuong;
	}

	public boolean isDaMua() {
		return DaMua;
	}

	public void setDaMua(boolean daMua) {
		DaMua = daMua;
	}

	public Long getThanhTien() {
		ThanhTien = SoLuong * this.getSp().getDonGia();
		return ThanhTien;
	}
}
