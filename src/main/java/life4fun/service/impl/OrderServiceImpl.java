package life4fun.service.impl;

import java.sql.SQLException;
import java.util.List;

import life4fun.dao.OrderDao;
import life4fun.dao.OrderDetailsDao;
import life4fun.dao.ProductDao;
import life4fun.dao.impl.OrderDaoImpl;
import life4fun.dao.impl.OrderDetailsDaoImpl;
import life4fun.dao.impl.ProductDaoImpl;
import life4fun.dto.ServiceResult;
import life4fun.entity.Order;
import life4fun.entity.OrderDetails;
import life4fun.entity.Product;
import life4fun.exception.ServiceException;
import life4fun.exception.StockShortageException;
import life4fun.service.OrderService;
import life4fun.utils.JdbcUtils;
import lombok.var;

public class OrderServiceImpl implements OrderService {
	public OrderDao orderDao = new OrderDaoImpl();
	public ProductDao productDao = new ProductDaoImpl();
	public OrderDetailsDao orderDetailsDao = new OrderDetailsDaoImpl();
	
	@Override
	public ServiceResult<List<Order>> findOrder(String phoneNumber) {
		String msg ="";
		// 獲取資料庫連接對象
		var conn = JdbcUtils.getConnection();
		List<Order> orderList = null;
		ServiceResult<List<Order>> result = new ServiceResult<>();
		try {
			// 事務開始
			orderList = orderDao.findOrder(conn, phoneNumber);
			result.setData(orderList);
			return result;
			// 事務結束，提交事務
		} catch (Exception e) { // SQL例外處理
			// 取得錯誤訊息
			e.printStackTrace();
			// 回滾事務
			throw new ServiceException(e);
		} finally {
			// 釋放資源<
			JdbcUtils.release(conn);
		}
	}
	
	@Override
	public ServiceResult<List<Order>> findOrder(String phoneNumber,Integer OrderId) {
		String msg ="";
		// 獲取資料庫連接對象
		var conn = JdbcUtils.getConnection();
		List<Order> orderList = null;
		ServiceResult<List<Order>> result = new ServiceResult<>();
		try {
			// 事務開始
			orderList = orderDao.findOrderFromSearch(conn, phoneNumber,OrderId);
			result.setData(orderList);
			return result;
			// 事務結束，提交事務
		} catch (Exception e) { // SQL例外處理
			// 取得錯誤訊息
			e.printStackTrace();
			// 回滾事務
			throw new ServiceException(e);
		} finally {
			// 釋放資源<
			JdbcUtils.release(conn);
		}
		
	}
	
	@Override
	public ServiceResult<List<Order>> findOrderToDetails(String phoneNumber,Integer OrderId) {
		String msg ="";
		// 獲取資料庫連接對象
		var conn = JdbcUtils.getConnection();
		List<Order> order = null;
		ServiceResult<List<Order>> result = new ServiceResult<>();
		try {
			// 事務開始
			order = orderDao.findOrderToDetails(conn, phoneNumber,OrderId);
			result.setData(order);
			return result;
			// 事務結束，提交事務
		} catch (Exception e) { // SQL例外處理
			// 取得錯誤訊息
			e.printStackTrace();
			// 回滾事務
			throw new ServiceException(e);
		} finally {
			// 釋放資源<
			JdbcUtils.release(conn);
		}
		
	}
	
	@Override
	public ServiceResult<List<OrderDetails>> findOrderetails(Integer OrderId) {
		String msg ="";
		// 獲取資料庫連接對象
		var conn = JdbcUtils.getConnection();
		List<OrderDetails> order = null;
		ServiceResult<List<OrderDetails>> result = new ServiceResult<>();
		try {
			// 事務開始
			order = orderDetailsDao.findOrderDetails(conn, OrderId);
			result.setData(order);
			return result;
			// 事務結束，提交事務
		} catch (Exception e) { // SQL例外處理
			// 取得錯誤訊息
			e.printStackTrace();
			// 回滾事務
			throw new ServiceException(e);
		} finally {
			// 釋放資源<
			JdbcUtils.release(conn);
		}
	}

	

	@Override
	public String createOrder(Order order, List<OrderDetails> orderDetailsList) {
		
		if(order.getPhoneNumber()==null) {
			throw new IllegalArgumentException("建立訂單時phoneNumber不得為null");
		}		
		if(order==null) {
			throw new IllegalArgumentException("建立訂單時order物件不得為null");
		}
		
		String msg ="";
		// 獲取資料庫連接對象
		var conn = JdbcUtils.getConnection();			
		
		try {
			// 事務開始
			JdbcUtils.beginTransaction(conn);
			
			// 執行insert DB的方法
			
			// 修改庫存
			for(OrderDetails item: orderDetailsList) {
				Product p= productDao.findStockByProductId(conn, item.getProductId());
				Integer stock =p.getStock();
				if(item.getQuantity() <= stock ) {
					productDao.updateStock(conn, orderDetailsList);					
				}else {
					throw new StockShortageException(item);
				}
			}
			
			//新增訂單
			double sum = 0;
			if (orderDetailsList != null && orderDetailsList.size() > 0) {

				for (OrderDetails item : orderDetailsList) {
					sum += item.getPrice() * item.getQuantity();
				}
				sum =Math.round(sum);
			}
			order.setOrderAmount(sum);
			orderDao.addOrder(conn, order);
			
			
			//新增訂單明細
			Integer orderId = order.getOrderId();
			orderDetailsDao.addOrderDetails(conn, orderId, orderDetailsList);			
			
			// 事務結束，提交事務
			JdbcUtils.commitTransaction(conn);
			msg="訂單新增成功";
					
		} catch (StockShortageException e) {
			e.printStackTrace();
			msg = e.getMessage();
			JdbcUtils.rollbackTransaction(conn);
		
		} catch (SQLException e) { // SQL例外處理
			e.printStackTrace();
			// 取得錯誤訊息
			msg = e.getMessage();
			// 回滾事務
			JdbcUtils.rollbackTransaction(conn);
		
		} finally {
			// 釋放資源
			JdbcUtils.release(conn);
		}
		return msg;
	}
	
	
	
	
	
}
