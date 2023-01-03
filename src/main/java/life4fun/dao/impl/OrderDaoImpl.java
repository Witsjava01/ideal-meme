package life4fun.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import life4fun.dao.BaseDao;
import life4fun.dao.OrderDao;
import life4fun.entity.Order;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao<Order> {
	@Override
	public List<Order> findOrder(Connection conn,String phoneNumber) throws SQLException {
		String selectSql = "SELECT order_id, created_time, order_status, order_amount, shipping_type, payment_type FROM order WHERE phoneNumber=?";
		return findAll(conn,selectSql,phoneNumber);
		
	}
}
