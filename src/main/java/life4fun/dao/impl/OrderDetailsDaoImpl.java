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

	@Override
	public void addOrderDetails(Connection conn, Integer orderId, List<OrderDetails> orderDetailsList)
			throws SQLException {
		String insertDetailsSql ="INSERT INTO order_details (order_id, product_id, product_name, product_color, product_size, price, quantity) "
				+ "VALUES (?,?,?,?,?,?,?)";
		for(OrderDetails orderDetail:orderDetailsList ) {
			insert(conn, insertDetailsSql,
					orderId,
					orderDetail.getProductId(),
					orderDetail.getProductName(),
					orderDetail.getProductColor(),
					orderDetail.getProductSize(),
					orderDetail.getPrice(),
					orderDetail.getQuantity());
		}		
	}
	
}
