package life4fun.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import life4fun.entity.OrderDetails;
import life4fun.entity.Product;


public interface ProductDao<T> {

	public Product findStockByProductId(Connection conn,Integer productId)throws SQLException;

	public void updateStock(Connection conn, List<OrderDetails> orderDetailsList)throws SQLException;

}