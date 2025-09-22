package bo;

import java.util.ArrayList;

import bean.DoiTuongSDBean;
import dao.DoiTuongSDDao;

public class DoiTuongSDBo {
	public DoiTuongSDDao dtd = new DoiTuongSDDao();
	public ArrayList<DoiTuongSDBean> getDoiTuongSD() {
		dtd.getDoiTuongSD();
		return dtd.ds;
	}
}
