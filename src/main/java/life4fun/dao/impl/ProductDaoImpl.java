package life4fun.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import life4fun.dao.BaseDao;
import life4fun.dao.ProductDao;
import life4fun.entity.OrderDetails;
import life4fun.entity.Product;

public class ProductDaoImpl extends BaseDao<Product> implements ProductDao<Product>{

	@Override
	public Product findStockByProductId(Connection conn, Integer productId) throws SQLException {
		String updateStockSql ="SELECT product_id, photo_url_1, product_name, brand, price, size, color, stock, description, photo_url_2, photo_url_3, photo_url_4, Onshelf, product_catalog FROM product WHERE product_id = ?";
		return getBean(conn, updateStockSql, productId);
	}
	
	@Override
	public void updateStock(Connection conn, List<OrderDetails> orderDetailsList) throws SQLException {
		String updateStockSql ="UPDATE product SET stock = stock-? WHERE product_id = ?";
		for(OrderDetails orderDetails : orderDetailsList) {			
			update(conn, updateStockSql,orderDetails.getQuantity(), orderDetails.getProductId());
		}
	}

}
