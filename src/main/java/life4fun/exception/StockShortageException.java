package life4fun.exception;

import life4fun.entity.OrderDetails;

public class StockShortageException extends VGBException {
	private final OrderDetails orderDetails;
	
	public StockShortageException(OrderDetails orderDetails) {
		this("購買產品庫存不足", orderDetails);	
	}

	public StockShortageException(String message, OrderDetails orderDetails) {
		super(message);	
		this.orderDetails = orderDetails;
	}
	
	public String toString() {
		return this.getClass().getName() + "-" + getMessage() + ":" 
				+ orderDetails.getProductId();
	}
	
}
