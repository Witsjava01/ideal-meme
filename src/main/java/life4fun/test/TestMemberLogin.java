package life4fun.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import life4fun.entity.Member;


public class TestMemberLogin {
	private static final String driver = System.getProperty("driver", "com.mysql.jdbc.Driver");
	private static final String url = System.getProperty("url", "jdbc:mysql://localhost:3306/life4fun?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false");
	private static final String userid = System.getProperty("userid", "root");
	private static final String pwd = System.getProperty("pwd", "1234");
	private static String SELECT_MEMBER = "SELECT id,password,name,gender,email,birthday,"
			+ "city,district,address,phone_number"
			+ "FROM member";	

	public static void main(String[] args){
		//1.輸入
		Scanner scanner = new Scanner(System.in);		
		System.out.println("請輸入帳號:");		
		String phoneNumber = scanner.next(); // 'OR''='
		
		System.out.println("請輸入密碼:");
		String password =scanner.next(); // 'OR''='
		
		//2.執行商業邏輯(以下為JDBC 查詢)
		String sql = SELECT_MEMBER + " WHERE phone_number='" + phoneNumber + "' AND password='" + password + "'"; 
		Member c = null;
		try {
			Class.forName(driver);//1.載入Driver			 
			
			try (
					Connection connection = DriverManager.getConnection(url,userid, pwd);	//2.建立連線
					Statement stmt = connection.createStatement();				//3.建立指令(Statement)
					ResultSet rs = stmt.executeQuery(sql); //4. 執行指令
				){				
				System.out.println("以下為查詢結果:");
				//5.處理rs
				while(rs.next()) {
					c = new Member();
					c.setId(rs.getString("id"));
					c.setPhoneNumber(rs.getString("phoneNumber"));
					c.setPassword(rs.getString("password"));					
					c.setName(rs.getString("name"));
					
					c.setGender(rs.getString("gender").charAt(0));
					
					c.setEmail(rs.getString("email"));
					c.setBirthday(rs.getString("birthday"));
					c.setAddress(rs.getString("city"));	
					c.setAddress(rs.getString("district"));	
					c.setAddress(rs.getString("address"));						
					System.out.println("********************************");
				}
			} catch (SQLException e) {
				Logger.getLogger("查詢全部客戶示範").log(Level.SEVERE, "資料庫連線|執行指令|讀取rs失敗", e);
			}
			
			//3.1 輸出正確結果
			System.out.println(c);
			
		} catch (ClassNotFoundException e) {
			//3.2 log錯誤訊息
			Logger.getLogger("查詢全部客戶示範").log(Level.SEVERE, "資料庫Driver載入失敗", e); //e.printStackTrace();
		}
	}
}
