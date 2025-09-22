package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.DoiTuongSDBean;

public class DoiTuongSDDao {
	public ArrayList<DoiTuongSDBean> ds = new ArrayList<DoiTuongSDBean>();
	
	public ArrayList<DoiTuongSDBean> getDoiTuongSD() {
		ds.clear();
		String qry = "select * from DoiTuongSD";
		KetNoi kn = new KetNoi();
		try {
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(qry);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int maDoiTuongSD = rs.getInt(1);
				String tenDoiTuongSD = rs.getString(2);
				ds.add(new DoiTuongSDBean(maDoiTuongSD, tenDoiTuongSD));
			}
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}
