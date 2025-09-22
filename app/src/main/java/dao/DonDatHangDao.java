package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.DonDatHangBean;

public class DonDatHangDao {

	public void DatHang(String HoVaTen, String DiaChi, String SDT, Long TongTien, int MaHoaDon) {
		String qry = "insert into DonDatHang(HoVaTen, DiaChi, SDT, TongTien, MaHoaDon, TinhTrang) values(?, ?, ?, ?, ?, 0)";
		KetNoi kn = new KetNoi();
		try {
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(qry);
			ps.setString(1, HoVaTen);
			ps.setString(2, DiaChi);
			ps.setString(3, SDT);
			ps.setLong(4, TongTien);
			ps.setInt(5, MaHoaDon);
			ps.executeUpdate();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// lay tat ca ma hoa don cua nguoi dung x
	public ArrayList<Integer> GetAllMaHoaDon(int MaNguoiDung) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		String qry = "select MaHoaDon from HoaDon where MaNguoiDung = ?";
		KetNoi kn = new KetNoi();
		try {
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(qry);
			ps.setInt(1, MaNguoiDung);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				ret.add(rs.getInt(1));
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public ArrayList<DonDatHangBean> GetDonDatHang(int MaNguoiDung) {
		ArrayList<Integer> maHoaDon = GetAllMaHoaDon(MaNguoiDung);
		ArrayList<DonDatHangBean> donDatHang = new ArrayList<DonDatHangBean>();
		KetNoi kn = new KetNoi();
		System.err.println("MaNguoiDung = " + MaNguoiDung);
		if (maHoaDon != null)
			for (Integer x : maHoaDon) {
				System.err.println(x);
				try {
					kn.ketnoi();
					String qry = "select * from DonDatHang where MaHoaDon = ?";
					PreparedStatement ps = kn.cn.prepareStatement(qry);
					ps.setInt(1, x);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						int maDonDatHang = rs.getInt("MaDonDatHang");
						String hoVaTen = rs.getString("HoVaTen");
						String diaChi = rs.getString("DiaChi");
						String sDT = rs.getString("SDT");
						Long tongTien = rs.getLong("TongTien");
						int maHoaDonn = rs.getInt("MaHoaDon");
						Boolean tinhTrang = rs.getBoolean("TinhTrang");
						System.err.println(maDonDatHang + " " + maHoaDonn);
						donDatHang.add(
								new DonDatHangBean(maDonDatHang, hoVaTen, diaChi, sDT, tongTien, maHoaDonn, tinhTrang));
					}
					rs.close();
					kn.cn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		return donDatHang;
	}

	public ArrayList<DonDatHangBean> adminDDHChuaXacNhan() {
		ArrayList<DonDatHangBean> ddh = new ArrayList<DonDatHangBean>();
		String qry = "select * from DonDatHang where TinhTrang = 0";
		KetNoi kn = new KetNoi();
		try {
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(qry);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int maDonDatHang = rs.getInt("MaDonDatHang");
				String hoVaTen = rs.getString("HoVaTen");
				String diaChi = rs.getString("DiaChi");
				String sDT = rs.getString("SDT");
				Long tongTien = rs.getLong("TongTien");
				int maHoaDonn = rs.getInt("MaHoaDon");
				Boolean tinhTrang = rs.getBoolean("TinhTrang");
				ddh.add(new DonDatHangBean(maDonDatHang, hoVaTen, diaChi, sDT, tongTien, maHoaDonn, tinhTrang));
			}
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ddh;
	}

	public void adminXacNhanDDH(int MaDonDatHang) {
		String qry = "update DonDatHang set TinhTrang = 1 where MaDonDatHang = ?";
		KetNoi kn = new KetNoi();
		try {
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(qry);
			ps.setInt(1, MaDonDatHang);
			ps.executeUpdate();
			kn.cn.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
