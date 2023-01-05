package life4fun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_details", schema = "life4fun")
public class OrderDetails {
	@Id
	@Column(name="order_id")
	private Integer orderId;
	@Id
	@Column(name="product_id")
	private Integer productId;
	@Column(name="product_name")
	private String productName;
	@Column(name="product_color")
	private String productColor;
	@Column(name="product_size")
	private Integer productSize;
	@Column(name="price")
	private Double price;
	@Column(name="quantity")
	private Integer quantity;
}
