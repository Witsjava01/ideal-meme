package life4fun.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import life4fun.exception.VGBException;

class MySQLConnection {
	private static final String driver = System.getProperty("driver", "com.mysql.cj.jdbc.Driver");
	private static final String url = System.getProperty("url", "jdbc:mysql://localhost:3306/life4fun");
	private static final String userid = System.getProperty("userid", "root");
	private static final String pwd = System.getProperty("pwd", "root");
	
	static Connection getConnection() throws VGBException{
		try {
			Class.forName(driver); //1.載入Driver			
			try {
				Connection connection = 
					DriverManager.getConnection(url, userid, pwd);//2.建立連線
				return connection;
			} catch (SQLException e) {				
				throw new VGBException("建立連線失敗", e);
			}
		} catch (ClassNotFoundException e) {
//			Logger.getLogger("MSQLConnection").log(
//					Level.SEVERE, "載入Driver失敗", e);
			throw new VGBException("載入JDBC Driver失敗", e);
		}
	}	
}