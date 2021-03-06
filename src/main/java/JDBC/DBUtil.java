package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/hotel_reservation?serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
	private static final String USER = "root";
	private static final String PASSWORD = "021098";
	
	private static Connection conn = null;
	
	static{
		try {
			//1.加载驱动程序
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.获取数据库的连接	
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("classNamenotfound");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
        return conn;
	}
}
