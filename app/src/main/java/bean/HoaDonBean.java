package bean;

public class HoaDonBean {
	private int MaHoaDon;
	private Long makh;
	private String NgayMua;
		
	public HoaDonBean() {
		super();
	}

	public HoaDonBean(int maHoaDon, Long makh, String ngayMua) {
		super();
		MaHoaDon = maHoaDon;
		this.makh = makh;
		NgayMua = ngayMua;
	}

	public int getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		MaHoaDon = maHoaDon;
	}

	public Long getMakh() {
		return makh;
	}

	public void setMakh(Long makh) {
		this.makh = makh;
	}

	public String getNgayMua() {
		return NgayMua;
	}

	public void setNgayMua(String ngayMua) {
		NgayMua = ngayMua;
	}

}
