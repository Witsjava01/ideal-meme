package life4fun.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import life4fun.dao.BaseDao;
import life4fun.dao.OrderDetailsDao;
import life4fun.entity.OrderDetails;

public class OrderDetailsDaoImpl extends BaseDao<OrderDetails> implements OrderDetailsDao<OrderDetails> {
	@Override
	public List<OrderDetails> findOrderDetails(Connection conn,Integer orderId) throws SQLException {
		String selectSql = "SELECT product_name as productName, product_color as productColor, product_size as productSize, "
				+ "price as price, quantity as quantity FROM life4fun.order_details WHERE order_id =?";
		return getBeanList(conn,selectSql,orderId);
	}
}
