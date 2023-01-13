package life4fun.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import life4fun.enumerate.PaymentType;
import life4fun.enumerate.ShippingType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order", schema = "life4fun")
public class Order {
	@Id
	@Column(name="order_id")
	private Integer orderId;
	@Id
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="created_time")
	private Timestamp createdTime;
	
	@Column(name="order_status")
	private String orderStatus;
	
	@Column(name="order_amount")
	private Double orderAmount;
	
	@Column(name="shipping_type")
	private String shippingType;
	
	@Column(name="payment_type")
	private String paymentType;
	
	@Column(name="recipient_name")
	private String recipientName;
	
	@Column(name="recipient_phoneNumber")
	private String recipientPhoneNumber;
	
	@Column(name="recipient_postalCode")
	private String recipientPostalCode;
	
	@Column(name="recipient_city")
	private String recipientCity;
	
	@Column(name="recipient_district")
	private String recipientDistrict;
	
	@Column(name="recipient_road")
	private String recipientRoad;
	
	@Column(name="recipient_address")
	private String recipientAddress;
	
}
