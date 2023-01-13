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
		String selectSql = 
		"SELECT od.order_id as orderId , od.created_time as createdTime, os.order_status_details as orderStatus, od.order_amount as orderAmount, od.shipping_type as shippingType, od.payment_type as paymentType "
		+ "FROM life4fun.order as od "
		+ "left join life4fun.order_status as os "
		+ "ON od.order_status = os.order_status "
		+ "WHERE od.phoneNumber=?";
		return findAll(conn,selectSql,phoneNumber);
		
	}
	@Override
	public List<Order> findOrderFromSearch(Connection conn,String phoneNumber,Integer orderId) throws SQLException {
		String selectSql = 
				"SELECT od.order_id as orderId , od.created_time as createdTime, os.order_status_details as orderStatus, od.order_amount as orderAmount, od.shipping_type as shippingType, od.payment_type as paymentType "
				+ "FROM life4fun.order as od "
				+ "left join life4fun.order_status as os "
				+ "ON od.order_status = os.order_status "
				+ "WHERE od.phoneNumber=? "
				+ "AND od.order_id=? ";
		return getBeanList(conn,selectSql,phoneNumber,orderId);
		
	}
	@Override
	public List<Order> findOrderToDetails(Connection conn, String phoneNumber, Integer orderId) throws SQLException {
		String selectSql = "SELECT "
				+ "od.order_id as orderID, "
				+ "od.phoneNumber, "
				+ "od.created_time as createdTime, "
				+ "os.order_status_details as orderStatus, "
				+ "od.order_amount as orderAmount, "
				+ "od.shipping_type as shippingType, "
				+ "od.payment_type as paymentType, "
				+ "od.recipient_name as recipientName, "
				+ "od.recipient_phoneNumber as recipientPhoneNumber, "
				+ "od.recipient_postalCode as recipientPostalCode, "
				+ "od.recipient_city as recipientCity,"
				+ "od.recipient_district as recipientDistrict,"
				+ "od.recipient_road as recipientRoad, "
				+ "od.recipient_address as recipientAddress "
				+ "FROM life4fun.order as od "
				+ "left join life4fun.order_status as os "
				+ "ON od.order_status = os.order_status "
				+ "WHERE phoneNumber=? AND order_id=? ";
		
		return getBeanList(conn,selectSql,phoneNumber,orderId);
	}
	
	
	
	@Override
	public Integer addOrder(Connection conn, Order order) throws SQLException {
		String insertOrderSql ="INSERT INTO `order` (phoneNumber, created_time, order_status, order_amount, shipping_type, payment_type,"
				+ " recipient_name, recipient_phoneNumber, recipient_postalCode, recipient_city, recipient_district, recipient_road, recipient_address) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
		return insert(conn,insertOrderSql,
				order.getPhoneNumber(),
				order.getCreatedTime(),
				order.getOrderStatus(),
				order.getOrderAmount(),
				order.getShippingType(),
				order.getPaymentType(),
				order.getRecipientName(),
				order.getRecipientPhoneNumber(),
				order.getRecipientPostalCode(),
				order.getRecipientCity(),
				order.getRecipientDistrict(),
				order.getRecipientRoad(),
				order.getRecipientAddress()
				);
		 
	}
}
