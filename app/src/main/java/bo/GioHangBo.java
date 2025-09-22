package bo;

import java.util.ArrayList;

import bean.GioHangBean;
import dao.GioHangDao;

public class GioHangBo {
	GioHangDao ghd = new GioHangDao();
	public int getMaHoaDon(int MaNguoiDung) {
		return ghd.getMaHoaDon(MaNguoiDung);
	}
	public void XoaCtHoaDon(int MaNguoiDung, int MaSanPham) {
		ghd.XoaCtHoaDon(MaNguoiDung, MaSanPham);
	}
	public ArrayList<GioHangBean> getCtHoaDon(int MaNguoiDung) {
		return ghd.getCtHoaDon(MaNguoiDung);
	}
	public void CapNhatGioHang(int MaNguoiDung, int MaSanPham, Long soLuong) {
		ghd.CapNhatGioHang(MaNguoiDung, MaSanPham, soLuong);
	}
	public void CapNhatDaMua(int MaNguoiDung) {
		ghd.CapNhatDaMua(MaNguoiDung);
	}
}
