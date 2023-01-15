package life4fun.entity;

import java.util.List;

public class CartItem {

	private String productId;
	private String productName;	
	private String photoUrl1;
	private double price;
	private String size;
	private String color;
	private int stock;
	private Integer quantity;
	private List<CartItem> cartItemList;

//所有商品總計
	public double getTotalAmount(List<CartItem> cartItemList) {
		double sum = 0;
		for (CartItem item : cartItemList) {
			sum += this.getItemAmount();
		}
		return sum;
	}

//個別品項總計
	public double getItemAmount() {
		int qty = this.getQuantity();
		double amount = this.getPrice() * qty;
		return amount;
	}


	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getPhotoUrl1() {
		return photoUrl1;
	}

	public void setPhotoUrl1(String photoUrl1) {
		this.photoUrl1 = photoUrl1;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartItemList == null) ? 0 : cartItemList.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((photoUrl1 == null) ? 0 : photoUrl1.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + stock;
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
		if (cartItemList == null) {
			if (other.cartItemList != null)
				return false;
		} else if (!cartItemList.equals(other.cartItemList))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (photoUrl1 == null) {
			if (other.photoUrl1 != null)
				return false;
		} else if (!photoUrl1.equals(other.photoUrl1))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (stock != other.stock)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CartItem [productId=" + productId + ", photoUrl1=" + photoUrl1 + ", productName=" + productName
				+ ", price=" + price + ", size=" + size + ", color=" + color + ", stock=" + stock + ", quantity="
				+ quantity + ", cartItemList=" + cartItemList + "]";
	}

	

}
