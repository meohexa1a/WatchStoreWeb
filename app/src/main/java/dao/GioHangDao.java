package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.GioHangBean;

public class GioHangDao {
	
	public int getMaHoaDon(int MaNguoiDung) {
		String qry = "declare @Ma int = 0\r\n"
				+ "exec @Ma = GetMaHoaDon ?\r\n"
				+ "select @Ma as ma\r\n"
				+ "";
		KetNoi kn = new KetNoi();
		int kq = 0;
		try {
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(qry);
			ps.setInt(1, MaNguoiDung);
			System.out.println("MaNguoiDung = " + MaNguoiDung);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				kq = rs.getInt(1);
			}
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return kq;
	}
	public void XoaCtHoaDon(int MaNguoiDung, int MaSanPham) {
		int maHoaDon = getMaHoaDon(MaNguoiDung);
		String qry = "delete from ChiTietHoaDon where MaHoaDon = ? and MaSanPham = ?";
		KetNoi kn = new KetNoi();
		try {
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(qry);
			ps.setInt(1, maHoaDon);
			ps.setInt(2, MaSanPham);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<GioHangBean> getCtHoaDon(int MaNguoiDung) {
		int maHoaDon = getMaHoaDon(MaNguoiDung);
		String qry = "select SanPham.MaSanPham, TenSanPham, HinhAnh, DonGia, SoLuong \r\n"
				+ "from ChiTietHoaDon join SanPham on ChiTietHoaDon.MaSanPham = SanPham.MaSanPham\r\n"
				+ "where MaHoaDon = ?";
		KetNoi kn = new KetNoi();
		ArrayList<GioHangBean> gh = new ArrayList<GioHangBean>();
		try {
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(qry);
			ps.setInt(1, maHoaDon);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int maSanPham = rs.getInt(1);
				String tenSanPham = rs.getString(2);
				String hinhAnh = rs.getString(3);
				Long donGia = rs.getLong(4);
				int soLuong = rs.getInt(5);
				gh.add(new GioHangBean(maSanPham, tenSanPham, hinhAnh, donGia, soLuong, soLuong * donGia));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gh;
	}
	public void CapNhatGioHang(int MaNguoiDung, int MaSanPham, Long soLuong) {
		int MaHoaDon = getMaHoaDon(MaNguoiDung);
		String qry = "exec ThemVaoCTHoaDon ?, ?, ?";
		KetNoi kn = new KetNoi();
		try {
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(qry);
			ps.setInt(1, MaSanPham);
			ps.setLong(2, soLuong);
			ps.setInt(3, MaHoaDon);
			ps.execute();
			kn.cn.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	public void CapNhatDaMua(int MaNguoiDung) {
		int MaHoaDon = getMaHoaDon(MaNguoiDung);
		String qry = "update HoaDon set DaMua = 1 where MaHoaDon = ?";
		KetNoi kn = new KetNoi();
		try {
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(qry);
			ps.setInt(1, MaHoaDon);
			ps.executeUpdate();
			kn.cn.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
