	$(document).ready(function(){
		
		var cart = [];
		if (localStorage.getItem("cart")) {
		 	cart = JSON.parse(localStorage.getItem("cart"));//[object Object]
			console.log("localstorage中取得："+cart);
		}
		var checkcartItem = "", totalPart="", s_price = 0, total = 0;
		console.log("cart"+JSON.stringify(cart));
		console.log("cart.length："+cart.length);
		  for (let $i = 0; $i < cart.length; $i++) {
			var object = cart[$i];
			console.log('item ' + $i + ': ' +object.name + ',' + object.price.replace("NT","").trim()+ ',' + object.quantity);
			var price =  parseInt(object.price.replace("NT","").trim());
			console.log("price"+price);
			console.log(typeof price); 
			var quantity =  parseInt(object.quantity);
			console.log("quantity"+quantity);
			console.log(typeof quantity); 
			s_price = price * quantity;
			console.log("s_price"+s_price); 
			total += s_price;
			checkcartItem += `
							<tr>
		                        <th> ${object.name}<span class="count"> x ${object.quantity}</span></th>
		                        <td>
		                          <span class="amount">$ ${s_price}</span>
		                        </td>
		                    </tr>
		                    `;
		     }
		     
		 $("#checkcart").empty().append(checkcartItem).append(totalPart);
		 $("#total").text(total);
		
		
		
		 $("#place_order").on("click", function() {
		  	alert("place_order");		  
		  
		  	var inputData = {};
			$('.inputData').each(function() {
				inputData[$(this).attr('name')] = $(this).val();
				inputData["paymentType"] = "臨櫃付款";
				inputData["shippingType"] = "到店取貨";
			});
			console.log("inputData:"+inputData);
			console.log("inputData:"+JSON.stringify(inputData));
				location.href="/life4fun/CheckOutServlet?method=sendOrder";
		  	$.ajax({
				//url: "CheckOutServlet?method=sendOrder",
				url: "/life4fun/CheckOutServlet?method=sendOrder",
				type: "POST",
				data: inputData,
				dataType: "json",
				contentType: "application/x-www-form-urlencoded;charset=utf-8",
				success: function(response) {
					console.log(response)
					alert("完成訂單!");
					window.location.assign(webApplicationPath + "/OrderServlet?method=order");
				},
				error: function(jqXHR, textStatus, errorThrown) {
					alert("失敗");
				}
				});
				
			});
		
		
		
	});