package life4fun.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import life4fun.entity.Member;
import life4fun.entity.Order;

public interface OrderDao<T> {
	
	public List<Order> findOrder(Connection conn, String phoneNumber) throws SQLException;

}
