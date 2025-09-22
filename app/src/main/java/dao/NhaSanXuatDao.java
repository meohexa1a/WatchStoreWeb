package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.NhaSanXuatBean;

public class NhaSanXuatDao {
	public ArrayList<NhaSanXuatBean> ds = new ArrayList<NhaSanXuatBean>();
	
	public ArrayList<NhaSanXuatBean> getNhaSanXuat() {
		ds.clear();
		String qry = "select * from NhaSanXuat";
		KetNoi kn = new KetNoi();
		try {
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(qry);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int MaNSX = rs.getInt(1);
				String TenNSX = rs.getString(2);
				ds.add(new NhaSanXuatBean(MaNSX, TenNSX));
			}
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}
