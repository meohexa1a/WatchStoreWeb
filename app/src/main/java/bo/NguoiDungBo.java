package bo;

import bean.NguoiDungBean;
import dao.NguoiDungDao;

public class NguoiDungBo {
	NguoiDungDao ndd = new NguoiDungDao();
	
	public boolean KiemTraTonTai(String usr) {
		return ndd.KiemTraTonTai(usr);
	}

	public NguoiDungBean DangNhap(String usr, String pass) {
		return ndd.DangNhap(usr, pass);
	}
	
	public Boolean DangKi(String tenNguoiDung, String tenDangNhap, String pass) {
		return ndd.DangKi(tenNguoiDung, tenDangNhap, pass);
	}
}	
