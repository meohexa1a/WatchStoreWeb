package bean;

public class DonDatHangBean {
	private int MaDonDatHang;
	private String HoVaTen;
	private String DiaChi;
	private String SDT;
	private Long TongTien;
	private int MaHoaDon;
	private Boolean TinhTrang;

	public DonDatHangBean() {
		super();
	}

	public DonDatHangBean(int maDonDatHang, String hoVaTen, String diaChi, String sDT, Long tongTien, int maHoaDon,
			Boolean tinhTrang) {
		super();
		MaDonDatHang = maDonDatHang;
		HoVaTen = hoVaTen;
		DiaChi = diaChi;
		SDT = sDT;
		TongTien = tongTien;
		MaHoaDon = maHoaDon;
		TinhTrang = tinhTrang;
	}

	public int getMaDonDatHang() {
		return MaDonDatHang;
	}

	public void setMaDonDatHang(int maDonDatHang) {
		MaDonDatHang = maDonDatHang;
	}

	public String getHoVaTen() {
		return HoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		HoVaTen = hoVaTen;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public Long getTongTien() {
		return TongTien;
	}

	public void setTongTien(Long tongTien) {
		TongTien = tongTien;
	}

	public int getMaHoaDon() {
		return MaHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		MaHoaDon = maHoaDon;
	}

	public Boolean getTinhTrang() {
		return TinhTrang;
	}

	public void setTinhTrang(Boolean tinhTrang) {
		TinhTrang = tinhTrang;
	}
}
