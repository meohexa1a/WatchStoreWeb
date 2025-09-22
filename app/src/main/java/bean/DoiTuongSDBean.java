package bean;

public class DoiTuongSDBean {
	private int MaDoiTuongSD;
	private String TenDoiTuongSD;

	public DoiTuongSDBean() {
		super();
	}

	public DoiTuongSDBean(int maDoiTuongSD, String tenDoiTuongSD) {
		super();
		MaDoiTuongSD = maDoiTuongSD;
		TenDoiTuongSD = tenDoiTuongSD;
	}

	public int getMaDoiTuongSD() {
		return MaDoiTuongSD;
	}

	public void setMaDoiTuongSD(int maDoiTuongSD) {
		MaDoiTuongSD = maDoiTuongSD;
	}

	public String getTenDoiTuongSD() {
		return TenDoiTuongSD;
	}

	public void setTenDoiTuongSD(String tenDoiTuongSD) {
		TenDoiTuongSD = tenDoiTuongSD;
	}
}
