package dao;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import bean.NguoiDungBean;

public class NguoiDungDao {
	public static String ecrypt(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String enrtext;
		MessageDigest msd = MessageDigest.getInstance("MD5");
		byte[] srctextbyte = text.getBytes("UTF-8");
		byte[] enrtextbyte = msd.digest(srctextbyte);
		BigInteger big = new BigInteger(1, enrtextbyte);
		enrtext = big.toString(16);
		return enrtext;
	}

	public boolean KiemTraTonTai(String usr) {
		KetNoi kn = new KetNoi();
		String qry = "select * from NguoiDung where TenDangNhap = ?";
		PreparedStatement ps;
		try {
			kn.ketnoi();
			ps = kn.cn.prepareStatement(qry);
			ps.setString(1, usr);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return true;
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public NguoiDungBean DangNhap(String usr, String pass) {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			pass = ecrypt(pass);
			String qry = "select * from NguoiDung where TenDangNhap = ? and MatKhau = ?";
			PreparedStatement ps = kn.cn.prepareStatement(qry);
			ps.setString(1, usr);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int maNguoiDung = rs.getInt(1);
				String tenNguoiDung = rs.getNString(2);
				String tenDangNhap = rs.getString(3);
				String MatKhau = rs.getString(4);
				boolean Quyen = rs.getBoolean(5);
				rs.close();
				kn.cn.close();
				return new NguoiDungBean(maNguoiDung, tenNguoiDung, tenDangNhap, MatKhau, Quyen);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean DangKi(String tenNguoiDung, String tenDangNhap, String matKhau) {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			System.out.println(matKhau);
			matKhau = ecrypt(matKhau);
			System.out.println(matKhau);
			String qry = "insert into NguoiDung(TenNguoiDung, TenDangNhap, MatKhau, Quyen) values(?, ?, ?, 0)";
			PreparedStatement ps = kn.cn.prepareStatement(qry);
			ps.setNString(1, tenNguoiDung);
			ps.setString(2, tenDangNhap);
			ps.setString(3, matKhau);
			ps.executeUpdate();
			kn.cn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
