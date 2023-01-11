package life4fun.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import life4fun.entity.Member;
import life4fun.entity.Order;
import life4fun.entity.OrderDetails;

public interface OrderDao<T> {
	
	public List<Order> findOrder(Connection conn, String phoneNumber) throws SQLException;

	public List<Order> findOrderFromSearch(Connection conn, String phoneNumber, Integer orderId) throws SQLException;

	public List<Order> findOrderToDetails(Connection conn, String phoneNumber, Integer orderId) throws SQLException;
	
	public void addOrder(Connection conn,Order order)throws SQLException;
	
	
}
