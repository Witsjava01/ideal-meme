package life4fun.service;
import java.sql.*;

import life4fun.entity.Member;
import life4fun.exception.VGBDataInvalidException;
import life4fun.exception.VGBException;

public class MemberDAO {
	private final static String SELECT_MEMBER_BY_PHONENUMBER_OR_EMAIL = 
			"SELECT id,password,name,gender,email,birthday,"
			+ "city,district,address,phone_number"
			+ "FROM member WHERE (phone_number=? OR email=?)";	
	Member selectCustomerByPhoneNumberOrEmail(String phoneNumberOrEmail) throws VGBException{
		Member c = null;
		
		try(
			Connection connection = MySQLConnection.getConnection(); //1, 2. 取得連線
			PreparedStatement pstmt = connection.prepareStatement(
						 SELECT_MEMBER_BY_PHONENUMBER_OR_EMAIL);//3.準備指令
		  ) {
			//3.1 傳入?的值
			pstmt.setString(1, phoneNumberOrEmail);
			pstmt.setString(2, phoneNumberOrEmail);
			try(
					ResultSet rs = pstmt.executeQuery(); //4.執行指令
			){
				//5.處理rs
				while(rs.next()) {
					c = new Member();
					}
					c.setId(rs.getString("id"));
					c.setPassword(rs.getString("password"));
					c.setName(rs.getString("name"));
					c.setGender(rs.getString("gender").charAt(0));
					c.setEmail(rs.getString("email"));
					c.setBirthday(rs.getString("birthday"));
					c.setCity(rs.getString("city"));
					c.setDistrict(rs.getString("district"));
					c.setAddress(rs.getString("address"));					
					c.setPhoneNumber(rs.getString("phone_number"));				
				}
			
		} catch (SQLException e) {
//			Logger.getLogger("CustomersDAO").log(
//					Level.SEVERE, "查詢客戶失敗", e);
			throw new VGBException("查詢客戶失敗", e);
		} 
		return c;		
	}
	
	
	private static final String INSERT_Member="INSERT INTO member"
			+ "(id, name, password, gender, email, birthday,"
			+ "		city, district, address, phone_number)"
			+ "	VALUES(?,?,?,?,?,?,?,?,?)";
	void insert(Member c) throws VGBException{	
		try (
				Connection connection = MySQLConnection.getConnection(); //1,2 取得連線
				PreparedStatement pstmt = connection.prepareStatement(INSERT_Member); //3.準備指令
		){
			//3.1 傳入?的值
			pstmt.setString(1, c.getId());
			pstmt.setString(2, c.getName());
			pstmt.setString(3, c.getPassword());
			pstmt.setString(4, String.valueOf(c.getGender()));
			pstmt.setString(5, c.getEmail());
			pstmt.setString(6, String.valueOf(c.getBirthday()));
			
			pstmt.setString(7, c.getCity());
			pstmt.setString(8, c.getDistrict());
			pstmt.setString(9, c.getAddress());
			pstmt.setString(10, c.getPhoneNumber());
			
			pstmt.executeUpdate(); //4.執行指令
		} catch (SQLIntegrityConstraintViolationException e) {
			//1048, 1062, 1062:SQLIntegrityConstraintViolationException
			if(e.getMessage().indexOf("member.phone_number_UNIQUE")>=0) {
				throw new VGBDataInvalidException("帳號已重複註冊", e);
			}else if(e.getMessage().indexOf("member.email_UNIQUE")>=0) {
				throw new VGBDataInvalidException("email已重複註冊", e);
			}else {
				throw new VGBException("新增客戶失敗", e);
			}
		} catch (SQLException e) {
			//SQLException: 1406:MysqlDataTruncation
			throw new VGBException("新增客戶失敗", e);
		}
	}
	
	private static final String UPDATE_MEMBER="UPDATE member "
			+ " SET name=?, password=?, gender=?, email=?, birthday=?,"
			+ "	    city=?, district=?, address=?, phone_number=?"
			+ "    WHERE id=?";
	void update(Member c) throws VGBException{
		try (
				Connection connection = MySQLConnection.getConnection(); //1,2 取得連線
				PreparedStatement pstmt = connection.prepareStatement(UPDATE_MEMBER); //3.準備指令
			){
			//3.1 傳入?的值
			pstmt.setString(10, c.getId());
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getPassword());
			pstmt.setString(3, String.valueOf(c.getGender()));
			pstmt.setString(4, c.getEmail());
			pstmt.setString(5, String.valueOf(c.getBirthday()));
			
			pstmt.setString(6, c.getCity());
			pstmt.setString(7, c.getDistrict());
			pstmt.setString(8, c.getAddress());
			pstmt.setString(9, c.getPhoneNumber());
			
			pstmt.executeUpdate(); //4.執行指令
		} catch (SQLIntegrityConstraintViolationException e) {
			//1048, 1062:SQLIntegrityConstraintViolationException
			if(e.getMessage().indexOf("member.email_UNIQUE")>=0) {
				throw new VGBDataInvalidException("email已重複註冊", e);
			}else {
				throw new VGBException("修改客戶失敗", e);
			}
		} catch (SQLException e) {
			//SQLException: 1406:MysqlDataTruncation
			throw new VGBException("修改客戶失敗", e);
		}
		
	}
}
