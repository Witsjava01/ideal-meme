package life4fun.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import life4fun.dao.BaseDao;
import life4fun.dao.OrderDetailsDao;
import life4fun.entity.Order;
import life4fun.entity.OrderDetails;

public class OrderDetailsDaoImpl extends BaseDao<OrderDetails> implements OrderDetailsDao<OrderDetails> {
	@Override
	public List<OrderDetails> findOrderDetails(Connection conn,String phoneNumber) throws SQLException {
		
	}
}
