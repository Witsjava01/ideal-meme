package life4fun.entity;


public enum PaymentType {
	SHOP("門市付款", ShippingType.SHOP),
	HOME("貨到府款", 50, ShippingType.HOME);
	
	private final String description;
	private final double fee;
	private final ShippingType[] shippingTypeArray;
	
	private PaymentType(String description,
			ShippingType... shippingTypeArray) {
		this(description, 0, shippingTypeArray);		
	}
	
	private PaymentType(String description, double fee,
			ShippingType... shippingTypeArray) {
		this.description = description;
		this.fee = fee;
		this.shippingTypeArray = shippingTypeArray; 
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getFee() {
		return fee;
	}
	
	public String getShippingTypes() {
		StringBuilder dataString=new StringBuilder();
		if(shippingTypeArray!=null && shippingTypeArray.length>0) {
			for(ShippingType shType:shippingTypeArray) {
				if(dataString.length()>0) dataString.append(",");
				dataString.append(shType.name());				
			}
		}
		return dataString.toString();
	}

	@Override
	public String toString() {		
		return this.getDescription() + (fee>0?new StringBuilder(",").append(fee).append("元"):"");
	}	
}
