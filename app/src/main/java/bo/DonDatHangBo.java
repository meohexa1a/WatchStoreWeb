package bo;

import java.util.ArrayList;

import bean.DonDatHangBean;
import dao.DonDatHangDao;

public class DonDatHangBo {
	DonDatHangDao dd = new DonDatHangDao();
	public void DatHang(String HoVaTen, String DiaChi, String SDT, Long TongTien, int MaHoaDon) {
		dd.DatHang(HoVaTen, DiaChi, SDT, TongTien, MaHoaDon);
	}
	// lay tat ca ma hoa don cua nguoi dung x
	public ArrayList<Integer> GetAllMaHoaDon(int MaNguoiDung) {
		return dd.GetAllMaHoaDon(MaNguoiDung);
	}
	public ArrayList<DonDatHangBean> GetDonDatHang(int MaNguoiDung) {
		return dd.GetDonDatHang(MaNguoiDung);
	}
	public ArrayList<DonDatHangBean> adminDDHChuaXacNhan() {
		return dd.adminDDHChuaXacNhan();
	}
	public void adminXacNhanDDH(int MaDonDatHang) {
		dd.adminXacNhanDDH(MaDonDatHang);
	}
}
