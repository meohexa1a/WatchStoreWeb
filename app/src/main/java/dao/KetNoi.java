package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoi {
	private static final String CONNECTION_URL =
		    "jdbc:sqlserver://localhost:1433;databaseName=ShopDongHo;user=sa;password=123456;encrypt=false;trustServerCertificate=true;";
	
	public Connection cn;

	public void ketnoi() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		cn = DriverManager.getConnection(CONNECTION_URL);
		
		System.out.println("Kết nối thành công!");
	}
}
