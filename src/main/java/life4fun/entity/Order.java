package life4fun.entity;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	private Integer order_id;
	private String phoneNumber;
	private Timestamp created_time;
	private String order_status;
	private Double order_amount;
	private String shipping_type;
	private String payment_type;
	private String recipient_name;
	private String recipient_phoneNumber;
	private String recipient_postalCode;
	private String recipient_city;
	private String recipient_district;
	private String recipient_road;
	private String recipient_address;
}
