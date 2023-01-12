package life4fun.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import life4fun.dao.MemberDao;
import life4fun.dao.OrderDao;
import life4fun.dao.OrderDetailsDao;
import life4fun.dao.ProductDao;
import life4fun.entity.Member;
import life4fun.entity.Order;
import life4fun.entity.OrderDetails;
import life4fun.entity.Product;
import life4fun.enumerate.PaymentType;
import life4fun.enumerate.ShippingType;
import life4fun.exception.VGBException;
import life4fun.service.OrderService;
import life4fun.service.ProductService;
import life4fun.service.impl.OrderServiceImpl;
import life4fun.utils.JdbcUtils;
import lombok.var;

public class TestOrderDao {

	public static void main(String[] args) throws SQLException, VGBException {
		
		ProductDao productDao = new ProductDaoImpl();
		OrderDao orderDao = new OrderDaoImpl();
		ProductService productService = new ProductService();
		OrderDetailsDao orderDetailsDao = new OrderDetailsDaoImpl();
		var conn = JdbcUtils.getConnection();
		Product p = new Product();
		Product p2 = new Product();
		
		
		//test findStockByProductId:ok
		p =productService.getProductById("1");
		p2 =productService.getProductById("2");
		Integer stock = p.getStock();
		System.out.println("stock: "+stock);
		System.out.println("ProductName: "+p.getProductName());
		System.out.println("Color: "+p.getColor());
		
		//test updateStock:ok
		List<OrderDetails> orderDetailsList = new ArrayList<>();
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setProductId(1);
		orderDetails.setQuantity(2);
		orderDetails.setOrderId(14);
		orderDetails.setProductName(p.getProductName());
		orderDetails.setProductColor(p.getColor());
		orderDetails.setProductSize(p.getSize());
		orderDetails.setPrice(p.getPrice());
		orderDetailsList.add(orderDetails);
		
		OrderDetails orderDetails2 = new OrderDetails();
		orderDetails2.setProductId(2);
		orderDetails2.setQuantity(2);	
		orderDetails2.setOrderId(14);
		orderDetails2.setProductName(p2.getProductName());
		orderDetails2.setProductColor(p2.getColor());
		orderDetails2.setProductSize(p2.getSize());
		orderDetails2.setPrice(p2.getPrice());
		orderDetailsList.add(orderDetails2);
		
		//productDao.updateStock(conn,orderDetailsList);		
		System.out.println("updateStock: "+orderDetailsList);
		
		// test addOrderDetails:ok
		//orderDetailsDao.addOrderDetails(conn,16,orderDetailsList);
		System.out.println("addOrderDetails: "+orderDetailsList);
		
		// test addOrder:ok
		Order order = new Order();
		order.setPhoneNumber("0911122233");
		order.setCreatedTime(null);//todo
		order.setOrderStatus("OD003");
		order.setOrderAmount(8000.0);//double
		order.setShippingType(ShippingType.SHOP);//todo，沒顯示中文
		order.setPaymentType(PaymentType.SHOP);//todo，沒顯示中文
		order.setRecipientName("ann");//todo
		order.setRecipientPhoneNumber("0977666777");
		order.setRecipientPostalCode("201");
		order.setRecipientCity("台北市");
		order.setRecipientDistrict("信義區");
		order.setRecipientRoad("忠孝東路５段");
		order.setRecipientAddress(null);
		
		//orderDao.addOrder(conn,order);
		System.out.println("addOrder: "+order);
		
		
		//test createOrder:Column 'order_id' cannot be null Query????
		OrderService orderService = new OrderServiceImpl();
		String msgString =orderService.createOrder(order,orderDetailsList);
		System.out.println(msgString);
		
		//test findMemberById
		MemberDao memberDao = new MemberDaoImpl();
		Member member = memberDao.findMemberById(conn,1);
		Integer age = member.getAge();
		System.out.println(age);
	}

}
