	
//alert("456");
var webApplicationPath="${webApplicationPath}";
var productId=null;
var quantity=null;
quantity=function(value){
	console.log("value: "+value);
	quantity=value;
	console.log("quantity: "+quantity);
}



addtoCart=function(id){
	console.log("id: "+id);
	productId=id;
	console.log("productId: "+productId);

	
	$.ajax({
		url: "/life4fun/CartServlet?method=addCart",
		method: "POST",
		data: {
			"productId":productId,
			"quantity":quantity
		},
		//dataType: "json",
		//contentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(response) {
			console.log(response)
			alert("此商品已新增至購物車");
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("失敗");
		}
	});
}
checkCart=function(id){
	console.log("id: "+id);
	productId=id;
	console.log("productId: "+productId);

	
	$.ajax({
		url: "/life4fun/CartServlet?method=cart",
		method: "POST",
		data: {
			"productId":productId,
			"quantity":quantity
		},
		//dataType: "json",
		//contentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(response) {
			alert("進入結帳!");
			console.log(response.msg);
			window.location.assign("/life4fun/jsp/cart/cart.jsp");			
		},
		error: function() {
			alert("失敗");
			
		}
	});
}



	
