package life4fun.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import life4fun.dao.BaseDao;
import life4fun.dao.MemberDao;
import life4fun.entity.Member;

public class MemberDaoImpl  extends BaseDao<Member> implements MemberDao<Member> {
	@Override
	public Member findMember(Connection conn, String phoneNumber) throws SQLException {
		String selectSql = "SELECT * from member WHERE phoneNumber = '"+phoneNumber+"'";
		
		return getBean(conn, selectSql);
		
	}
	@Override
	public void addMember (Connection conn, Member member) throws SQLException {
		String insterSql = "insert into member (name,password,gender,email,birthday,postalCode,city,district,road,address,phoneNumber,age,create_time,update_time) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		
		insert(conn, insterSql, member.getName(),member.getPassword(),member.getGender(),member.getEmail(),member.getBirthday(),member.getPostalCode(),member.getCity(),member.getDistrict(),member.getRoad()
				,member.getAddress(),member.getPhoneNumber(),member.getAge(),member.getCreate_time(),member.getUpdate_time());
	}
	@Override
	public void updateMember (Connection conn, Member member) throws SQLException {
		String updateSql = "update member set name=?, password=?, gender=?, email=?, birthday=?, postalCode=?, city=?, district=?, road=?, address=?, age=?, create_time=?, update_time=? where phoneNumber=?";
		
		update(conn, updateSql, member.getName(),member.getPassword(),member.getGender(),member.getEmail(),member.getBirthday(),member.getPostalCode(),member.getCity(),member.getDistrict(),member.getRoad()
				,member.getAddress(),member.getAge(),member.getCreate_time(),member.getUpdate_time(),member.getPhoneNumber());
		
	}
	@Override
	public void updatePassword (Connection conn, String phoneNumber, String newPassword) throws SQLException {
		String updateSql = "update member set password=? where phoneNumber=?";
		
		update(conn, updateSql, newPassword, phoneNumber);
		
	}
}
