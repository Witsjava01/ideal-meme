package life4fun.service;

import java.util.List;

import life4fun.dto.ServiceResult;
import life4fun.entity.Order;
import life4fun.entity.OrderDetails;


public interface OrderService {
	
	public ServiceResult<List<Order>> findOrder(String phoneNumber);

	public ServiceResult<List<Order>> findOrder(String phoneNumber, Integer OrderId);

	public ServiceResult<List<Order>> findOrderToDetails(String phoneNumber, Integer OrderId);

	public ServiceResult<List<OrderDetails>> findOrderetails(Integer OrderId);

	public String createOrder(Order order,List<OrderDetails> orderDetailsList);
	
}


