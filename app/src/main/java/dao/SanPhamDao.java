package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.SanPhamBean;

public class SanPhamDao {
	public Integer numOfProducts;
	public int getMaSanPhamMax() {
		String qry = "select max(MaSanPham) from SanPham";
		KetNoi kn = new KetNoi();
		try {
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(qry);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public SanPhamBean get1SanPham(int msp) {
		String qry = "select * from SanPham where MaSanPham = ?";
		KetNoi kn = new KetNoi();
		try {
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(qry);
			ps.setInt(1, msp);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int maSanPham = rs.getInt(1);
				String tenSanPham = rs.getNString(2);
				long donGia = rs.getLong(3);
				String hinhAnh = rs.getString(4);
				String loaiDongHo = rs.getString(5);
				int maNSX = rs.getInt(6);
				int maDoiTuongSD = rs.getInt(7);
				boolean daXoa = rs.getBoolean(8);
				return new SanPhamBean(maSanPham, tenSanPham, donGia, hinhAnh, loaiDongHo, maNSX, maDoiTuongSD, daXoa);
			}
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<SanPhamBean> getSanPham() {
		ArrayList<SanPhamBean> sp = new ArrayList<SanPhamBean>();
		String qry = "select * from SanPham";
		KetNoi kn = new KetNoi();
		try {
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(qry);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int maSanPham = rs.getInt(1);
				String tenSanPham = rs.getNString(2);
				long donGia = rs.getLong(3);
				String hinhAnh = rs.getString(4);
				String loaiDongHo = rs.getString(5);
				int maNSX = rs.getInt(6);
				int maDoiTuongSD = rs.getInt(7);
				Boolean daXoa = rs.getBoolean(8);
				sp.add(new SanPhamBean(maSanPham, tenSanPham, donGia, hinhAnh, loaiDongHo, maNSX, maDoiTuongSD, daXoa));
			}
			// lấy tổng số sản phẩm
			{
				qry = "select count(*) from SanPham";
				ps = kn.cn.prepareStatement(qry);
				rs = ps.executeQuery();
				while (rs.next())
					numOfProducts = rs.getInt(1);
			}
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sp;
	}
	public ArrayList<SanPhamBean> getSanPham(String pt) {
		ArrayList<SanPhamBean> sp = new ArrayList<SanPhamBean>();
		String qry = "select * from SanPham where TenSanPham like N'%" + pt + "%'";
		KetNoi kn = new KetNoi();
		try {
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(qry);
//			ps.setNString(1, pt);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int maSanPham = rs.getInt(1);
				String tenSanPham = rs.getNString(2);
				long donGia = rs.getLong(3);
				String hinhAnh = rs.getString(4);
				String loaiDongHo = rs.getString(5);
				int maNSX = rs.getInt(6);
				int maDoiTuongSD = rs.getInt(7);
				Boolean daXoa = rs.getBoolean(8);
				sp.add(new SanPhamBean(maSanPham, tenSanPham, donGia, hinhAnh, loaiDongHo, maNSX, maDoiTuongSD, daXoa));
			}
			// lấy tổng số sản phẩm
			{
				qry = "select count(*) from SanPham";
				ps = kn.cn.prepareStatement(qry);
				rs = ps.executeQuery();
				while (rs.next())
					numOfProducts = rs.getInt(1);
			}
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sp;
	}
	public ArrayList<SanPhamBean> getSanPham(int page) {
		ArrayList<SanPhamBean> sp = new ArrayList<SanPhamBean>();
		int skip = (page - 1) * 9;
		String qry = "select * from SanPham order by MaSanPham offset ? rows fetch next 9 rows only";
		KetNoi kn = new KetNoi();
		try {
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(qry);
			ps.setInt(1, skip);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int maSanPham = rs.getInt(1);
				String tenSanPham = rs.getNString(2);
				long donGia = rs.getLong(3);
				String hinhAnh = rs.getString(4);
				String loaiDongHo = rs.getString(5);
				int maNSX = rs.getInt(6);
				int maDoiTuongSD = rs.getInt(7);
				Boolean daXoa = rs.getBoolean(8);
				sp.add(new SanPhamBean(maSanPham, tenSanPham, donGia, hinhAnh, loaiDongHo, maNSX, maDoiTuongSD, daXoa));
			}
			// lấy tổng số sản phẩm
			{
				qry = "select count(*) from SanPham";
				ps = kn.cn.prepareStatement(qry);
				rs = ps.executeQuery();
				while (rs.next())
					numOfProducts = rs.getInt(1);
			}

			rs.close();
			kn.cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sp;
	}
	public ArrayList<SanPhamBean> getSanPham(int page, ArrayList<String> dtsd, ArrayList<String> price, ArrayList<String> type, ArrayList<String> nsx) {
		ArrayList<SanPhamBean> sp = new ArrayList<SanPhamBean>();
		String sql = "select * from SanPham where ((1 = 1)";
		String sql_count = "select count(*) from SanPham where 1 = 1 ";
		if (dtsd != null && dtsd.size() != 0) {
			boolean ok = false;
			for (int i = 0; i < dtsd.size(); i++) {
				if (!dtsd.get(i).equals("")) {
					ok = true;
					break;
				}
			}
			if (ok) {
				sql += " and (";
				sql_count += " and (";
				for (int i = 0; i < dtsd.size(); i++) {
					if (dtsd.get(i).equals(""))
						continue;
					System.out.println("dtsd: " + dtsd.get(i));
					sql += "MaDoiTuongSD=" + dtsd.get(i) + " or ";
					sql_count += "MaDoiTuongSD=" + dtsd.get(i) + " or ";
				}
				sql_count += " 0 = 1)";
				sql += " 0 = 1)";
			}
		}
		if (type != null && type.size() != 0) {
			boolean ok = false;
			for (int i = 0; i < type.size(); i++) {
				if (!type.get(i).equals("")) {
					ok = true;
					break;
				}
			}
			if (ok) {
				sql += " and (";
				sql_count += " and (";
				for (int i = 0; i < type.size(); i++) {
					if (type.get(i) == "")
						continue;
					System.out.println("type: " + type.get(i));
					sql += "LoaiDongHo = '" + type.get(i) + "' or ";
					sql_count += "LoaiDongHo = '" + type.get(i) + "' or ";
				}
				sql += "0 = 1)";
				sql_count += "0 = 1)";
			}
		}
		if (price != null && price.size() != 0) {
			boolean ok = false;
			for (int i = 0; i < price.size(); i++) {
				if (!price.get(i).equals("")) {
					ok = true;
					break;
				}
			}
			if (ok) {
				sql += " and (";
				sql_count += " and (";
				for (int i = 0; i < price.size(); i++) {
					if (price.get(i) == "")
						continue;
					System.out.println("price = " + price.get(i));
					if (price.get(i).equals("1")) {
						sql += " (DonGia >= 0 and DonGia <= 1000000) or ";
						sql_count += " (DonGia >= 0 and DonGia <= 1000000) or ";
					} else if (price.get(i).equals("2")) {
						sql += " (DonGia >= 1000000 and DonGia <= 5000000) or ";
						sql_count += " (DonGia >= 1000000 and DonGia <= 5000000) or ";
					} else if (price.get(i).equals("3")){
						sql += " (DonGia >= 5000000 and DonGia <= 20000000) or ";
						sql_count += " (DonGia >= 5000000 and DonGia <= 20000000) or ";
					}
				}
				sql += " 0 = 1)";
				sql_count += " 0 = 1)";
			}
		}
		if (nsx != null && nsx.size() != 0) {
			boolean ok = false;
			for (int i = 0; i < nsx.size(); i++) {
				if (!nsx.get(i).equals("")) {
					ok = true;
					break;
				}
			}
			if (ok) {
				sql += " and (";
				sql_count += " and (";
				for (int i = 0; i < nsx.size(); i++) {
					if (nsx.get(i) == "")
						continue;
					System.out.println("nsx = " + nsx.get(i));
					sql += " MaNSX = " + nsx.get(i) + " or ";
					sql_count += " MaNSX = " + nsx.get(i) + " or ";

				}
				sql += "0 = 1)";
				sql_count += "0 = 1)";
			}
		}
		sql += ") order by MaSanPham offset ? rows fetch next 9 rows only";
		System.out.println(sql);
		KetNoi kn = new KetNoi();
		try {
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			int skip = (page - 1) * 9;
			ps.setInt(1, skip);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int maSanPham = rs.getInt(1);
				String tenSanPham = rs.getNString(2);
				long donGia = rs.getLong(3);
				String hinhAnh = rs.getString(4);
				String loaiDongHo = rs.getString(5);
				int maNSX = rs.getInt(6);
				int maDoiTuongSD = rs.getInt(7);
				boolean daXoa = rs.getBoolean(8);
				sp.add(new SanPhamBean(maSanPham, tenSanPham, donGia, hinhAnh, loaiDongHo, maNSX, maDoiTuongSD, daXoa));
			}
			// lấy tổng số sản phẩm
			{
				ps = kn.cn.prepareStatement(sql_count);
				System.err.println("ok1 = " + sql_count);
				rs = ps.executeQuery();
				while (rs.next())
					numOfProducts = rs.getInt(1);
			}
			rs.close();
			kn.cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sp;
	}
	public ArrayList<SanPhamBean> getSanPham(int page, String[] dtsd, String[] price, String[] type, String[] nsx) {
		ArrayList<SanPhamBean> sp = new ArrayList<SanPhamBean>();
		String sql = "select * from SanPham where ((1 = 1)";
		String sql_count = "select count(*) from SanPham where 1 = 1 ";
		if (dtsd != null && dtsd.length != 0) {
			boolean ok = false;
			for (int i = 0; i < dtsd.length; i++) {
				if (!dtsd[i].equals("")) {
					ok = true;
					break;
				}
			}
			if (ok) {
				sql += " and (";
				sql_count += " and (";
				for (int i = 0; i < dtsd.length; i++) {
					if (dtsd[i] == "")
						continue;
					System.out.println("dtsd: " + dtsd[i]);
					sql += "MaDoiTuongSD=" + dtsd[i] + " or ";
					sql_count += "MaDoiTuongSD=" + dtsd[i] + " or ";
				}
				sql_count += " 0 = 1)";
				sql += " 0 = 1)";
			}
		}
		if (type != null && type.length != 0) {
			boolean ok = false;
			for (int i = 0; i < type.length; i++) {
				if (!type[i].equals("")) {
					ok = true;
					break;
				}
			}
			if (ok) {
				sql += " and (";
				sql_count += " and (";
				for (int i = 0; i < type.length; i++) {
					if (type[i] == "")
						continue;
					System.out.println("type: " + type[i]);
					sql += "LoaiDongHo = '" + type[i] + "' or ";
					sql_count += "LoaiDongHo = '" + type[i] + "' or ";
				}
				sql += "0 = 1)";
				sql_count += "0 = 1)";
			}
		}
		if (price != null && price.length != 0) {
			boolean ok = false;
			for (int i = 0; i < price.length; i++) {
				if (!price[i].equals("")) {
					ok = true;
					break;
				}
			}
			if (ok) {
				sql += " and (";
				sql_count += " and (";
				for (int i = 0; i < price.length; i++) {
					if (price[i] == "")
						continue;
					System.out.println("price = " + price[i]);
					if (price[i].equals("1")) {
						sql += " (DonGia >= 0 and DonGia <= 1000000) or ";
						sql_count += " (DonGia >= 0 and DonGia <= 1000000) or ";
					} else if (price[i].equals("2")) {
						sql += " (DonGia >= 1000000 and DonGia <= 5000000) or ";
						sql_count += " (DonGia >= 1000000 and DonGia <= 5000000) or ";
					} else if (price[i].equals("3")){
						sql += " (DonGia >= 5000000 and DonGia <= 20000000) or ";
						sql_count += " (DonGia >= 5000000 and DonGia <= 20000000) or ";
					}
				}
				sql += " 0 = 1)";
				sql_count += " 0 = 1)";
			}
		}
		if (nsx != null && nsx.length != 0) {
			boolean ok = false;
			for (int i = 0; i < nsx.length; i++) {
				if (!nsx[i].equals("")) {
					ok = true;
					break;
				}
			}
			if (ok) {
				sql += " and (";
				sql_count += " and (";
				for (int i = 0; i < nsx.length; i++) {
					if (nsx[i] == "")
						continue;
					System.out.println("nsx = " + nsx[i]);
					sql += " MaNSX = " + nsx[i] + " or ";
					sql_count += " MaNSX = " + nsx[i] + " or ";

				}
				sql += "0 = 1)";
				sql_count += "0 = 1)";
			}
		}
		sql += ") order by MaSanPham offset ? rows fetch next 9 rows only";
		System.out.println(sql);
		KetNoi kn = new KetNoi();
		try {
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			int skip = (page - 1) * 9;
			ps.setInt(1, skip);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int maSanPham = rs.getInt(1);
				String tenSanPham = rs.getNString(2);
				long donGia = rs.getLong(3);
				String hinhAnh = rs.getString(4);
				String loaiDongHo = rs.getString(5);
				int maNSX = rs.getInt(6);
				int maDoiTuongSD = rs.getInt(7);
				boolean daXoa = rs.getBoolean(8);
				sp.add(new SanPhamBean(maSanPham, tenSanPham, donGia, hinhAnh, loaiDongHo, maNSX, maDoiTuongSD, daXoa));
			}
			// lấy tổng số sản phẩm
			{
				ps = kn.cn.prepareStatement(sql_count);
				System.err.println("ok = " + sql_count);
				rs = ps.executeQuery();
				while (rs.next())
					numOfProducts = rs.getInt(1);
			}
			rs.close();
			kn.cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sp;
	}
	public void CapNhatSanPham(String MaSanPham, String TenSanPham, String DonGia) {
		int maSanPham = Integer.valueOf(MaSanPham);
		long donGia = Long.valueOf(DonGia);
		String qry = "update SanPham set TenSanPham = ?, DonGia = ? where MaSanPham = ?";
		KetNoi kn = new KetNoi();
		try {
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(qry);
			ps.setNString(1, TenSanPham);
			ps.setLong(2, donGia);
			ps.setInt(3, maSanPham);
			ps.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	public void XoaSanPham(String MaSanPham) {
		int maSanPham = Integer.valueOf(MaSanPham);
		String qry = "update SanPham set DaXoa = 1 where MaSanPham = ?";
		KetNoi kn = new KetNoi();
		try {
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(qry);
			ps.setInt(1, maSanPham);
			ps.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	public void ThemSanPham(String tenSanPham, long donGia, String hinhAnh, String loaiDongHo, int maNSX, int maDoiTuongSD) {
		String qry = "insert into SanPham(TenSanPham, DonGia, HinhAnh, LoaiDongHo, MaNSX, MaDoiTuongSD, DaXoa) values(?, ?, ?, ?, ?, ?, 0)";
		KetNoi kn = new KetNoi();
		try {
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(qry);
			ps.setNString(1, tenSanPham);
			ps.setLong(2, donGia);
			ps.setString(3, hinhAnh);
			ps.setString(4, loaiDongHo);
			ps.setInt(5, maNSX);
			ps.setInt(6, maDoiTuongSD);
			ps.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
