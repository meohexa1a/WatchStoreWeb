package bo;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import bean.SanPhamBean;
import dao.KetNoi;
import dao.SanPhamDao;

public class SanPhamBo {
	SanPhamDao spd = new SanPhamDao();
	public Integer getNumProducts() {
		return spd.numOfProducts;
	}
	public ArrayList<SanPhamBean> getSanPham() {
		return spd.getSanPham();
	}
	public ArrayList<SanPhamBean> getSanPham(String pt) {
		return spd.getSanPham(pt);
	}
	public ArrayList<SanPhamBean> getSanPham(int page, String[] dtsd, String[] price, String[] type, String[] nsx) {
		return spd.getSanPham(page, dtsd, price, type, nsx);
	}
	public ArrayList<SanPhamBean> getSanPham(int page, ArrayList<String> dtsd, ArrayList<String> price, ArrayList<String> type, ArrayList<String> nsx) {
		return spd.getSanPham(page, dtsd, price, type, nsx);
	}
	public SanPhamBean get1SanPham(int msp) {
		return spd.get1SanPham(msp);
	}
	public void CapNhatSanPham(String tenSanPham, String MaSanPham, String DonGia) {
		spd.CapNhatSanPham(MaSanPham, tenSanPham, DonGia);
	}
	public void xoaSanPham(String tenSanPham) {
		spd.XoaSanPham(tenSanPham);
	}
	public void ThemSanPham(String tenSanPham, long donGia, String hinhAnh, String loaiDongHo, int maNSX, int maDoiTuongSD) {
		spd.ThemSanPham(tenSanPham, donGia, hinhAnh, loaiDongHo, maNSX, maDoiTuongSD);
	}
	public int getMaSanPhamMax() {
		return spd.getMaSanPhamMax();
	}
}
