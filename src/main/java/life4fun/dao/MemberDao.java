package life4fun.dao;

import java.sql.Connection;
import java.sql.SQLException;

import life4fun.entity.Member;


public interface MemberDao<T> {
	public Member findMember(Connection conn, String phoneNumber) throws SQLException;

	public void addMember(Connection conn, Member member) throws SQLException;

	public void updateMember(Connection conn, Member member) throws SQLException;

	public void updatePassword(Connection conn, String newPassword, String phoneNumber) throws SQLException;

}
