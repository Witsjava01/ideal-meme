package life4fun.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import life4fun.entity.OrderDetails;

public interface OrderDetailsDao<T> {

	public List<OrderDetails> findOrderDetails(Connection conn, String phoneNumber) throws SQLException;

}
