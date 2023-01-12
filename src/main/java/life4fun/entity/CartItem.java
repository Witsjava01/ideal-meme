package life4fun.entity;

import java.util.List;

public class CartItem {

	private Product product;
	private Integer quantity;
	private List<CartItem> cartItemList;

//所有商品總計
	public double getTotalAmount(List<CartItem> cartItemList) {
		double sum = 0;
		for (CartItem item : cartItemList) {
			sum += this.getItemAmount(item);
		}
		return sum;
	}

//個別品項總計
	public double getItemAmount(CartItem item) {
		int qty = this.getQuantity();
		double amount = this.getPrice() * qty;
		return amount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}

	/* 以下getter是根據cart.jsp中cartItem的欄位提供的 */
	public int getProductId() {
		if (product != null) {
			return product.getProductId();
		} else
			return -1;
	}

	public String getProductName() {
		if (product != null) {
			return product.getProductName();
		} else
			return "無產品資料";
	}

	public String getPhotoUrl1() {
		if (product != null) {
			return product.getPhotoUrl1();
		} else
			return null;
	}

	public String getProductColor() {
		if (product != null) {
			return product.getColor();
		} else
			return "";
	}

	public String getProductSize() {
		if (product != null) {
			return product.getSize();
		} else
			return "";
	}

	public double getPrice() {
		if (product != null) {
			return product.getPrice();
		} else
			return 0;
	}

	public int getStock() {
		if (product != null) {
			return product.getStock();
		} else
			return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "編號=" + getProductId() + ",\n 名稱=" + getProductName() + ",\n PhotoUrl=" + getPhotoUrl1() + ",\n 購買顏色="
				+ getProductColor() + ",\n 購買size=" + getProductSize() + ",\n 定價=" + getPrice() + ",\n 數量="
				+ getQuantity();
	}

}
