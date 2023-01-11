	
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
			alert("成功加入購物車");
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
			alert("跳轉購物車!");
			console.log(response.msg);
			window.location.assign("/life4fun/jsp/cart/cart.jsp");
			$('#singlePage').append(`
			<tr class="cart_item">
                <td class="product-thumbnail">
                  <a href="#">
                    <img src="static/picture/product_1.jpg" alt="">
                  </a>
                </td>
                <td class="product-name">
                  <a href="#">Joeby Tailored Trouser</a>
                  <ul>
                    <li>尺寸: XL</li>
                    <li>顏色: White</li>
                  </ul>
                </td>
                <td class="product-price">
                  <span class="amount">$1250.00</span>
                </td>
                <td class="product-quantity">
                  <div class="quantity buttons_added">
                    <input type="button" value="-" class="minus">
                    <input type="number" step="1" min="0" value="1" title="Qty" class="input-text qty text">
                    <input type="button" value="+" class="plus">
                  </div>
                </td>
                <td class="product-subtotal">
                  <span class="amount">$1250.00</span>
                </td>
                <td class="product-remove">
                  <a href="#" class="remove" title="Remove this item">
                    <i class="ui-close"></i>
                  </a>
                </td>
              </tr>`);
			
		},
		error: function() {
			alert("失敗");
			
		}
	});
}


	
