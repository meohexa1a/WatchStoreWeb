package bo;

import java.util.ArrayList;

import bean.NhaSanXuatBean;
import dao.NhaSanXuatDao;

public class NhaSanXuatBo {
	NhaSanXuatDao nsxd = new NhaSanXuatDao();
	public ArrayList<NhaSanXuatBean> getNhaSanXuat() {
		nsxd.getNhaSanXuat();
		return nsxd.ds;
	}
}
