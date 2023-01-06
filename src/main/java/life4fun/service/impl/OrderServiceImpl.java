package life4fun.service.impl;

import java.util.List;

import life4fun.dao.OrderDao;
import life4fun.dao.OrderDetailsDao;
import life4fun.dao.impl.OrderDaoImpl;
import life4fun.dao.impl.OrderDetailsDaoImpl;
import life4fun.dto.ServiceResult;
import life4fun.entity.Order;
import life4fun.entity.OrderDetails;
import life4fun.exception.ServiceException;
import life4fun.service.OrderService;
import life4fun.utils.JdbcUtils;
import lombok.var;

public class OrderServiceImpl implements OrderService {
	public OrderDao orderDao = new OrderDaoImpl();
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
}
