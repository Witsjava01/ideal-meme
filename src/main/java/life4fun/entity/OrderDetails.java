package life4fun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
	private Integer order_id;
	private Integer product_id;
	private String product_name;
	private String product_color;
	private Integer product_size;
	private Double price;
	private Integer quantity;
}
