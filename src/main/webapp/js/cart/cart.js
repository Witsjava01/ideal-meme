var webApplicationPath="${webApplicationPath}";
var productId=null;
var quantity=null;
quantity=function(value){
	console.log("value: "+value);
	quantity=value;
	console.log("quantity: "+quantity);
}

//-----------

var cart = [];

if (localStorage.getItem("cart")) {
 cart = JSON.parse(localStorage.getItem("cart"));
 console.log("localStorage已有"+cart);
}

addtoCart=function(id){
	//console.log("id: "+id);
	productId=id;
	console.log("addProductId: "+productId);
	console.log("stock: "+$("#singlePage").find("#stock").text());

  let product = $("#singlePage");
  let newItem = {
    productId: productId,
    name: product.find("#productName").text(),
    photoUrl1: product.find("#photoUrl1").attr("src"),
    size: product.find("#size__select").val(),
    color: product.find(".colors__label-selected").text(),
    price: product.find(".amount").text(),
    quantity: product.find("#quantity__select").val(),
    stock: product.find("#stock").text()
  };
  cart.push(newItem);
  localStorage.setItem("cart", JSON.stringify(cart));
  console.log("localStorage.setItem: "+JSON.stringify(cart));
  alert("此商品已新增至購物車");

};



checkCart=function(id){
	productId=id;
	alert("進入結帳!");
	location.href="/life4fun/CartServlet?method=showCart";

}

//------------

/*

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
		success: function(response) {
			console.log(response)
			alert("此商品已新增至購物車");
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("失敗");
		}
	});
}*/
/*
checkCart=function(id){
	console.log("id: "+id);
	productId=id;
	console.log("productId: "+productId);

	
	$.ajax({
		url: "/life4fun/CartServlet?method=showCart",
		method: "POST",
		data: {
			"productId":productId,
			"quantity":quantity
		},
		success: function(response) {
			alert("進入結帳!");
			console.log(response.msg);
			window.location.assign("/life4fun/CartServlet?method=showCart");	
			let resData = response.data;
			let rootTag = $('#cart_item_table');
			rootTag.empty();
			resData.forEach(cartItem => {
				let temp = `
		              <tr class="cart_item">
		                <td class="product-thumbnail">
		                  <a href="#">
		                    <img src="../../img/life4fun/<c:out value="${cartItem.photoUrl1}"></c:out>" alt="">
		                  </a>
		                </td>
		                <td class="product-name">
		                  <a href="#"><c:out value="${cartItem.productName}"></c:out></a>
		                  <ul>
		                    <li>尺寸: <c:out value="${cartItem.size}"></c:out></li>
		                    <li>顏色: <c:out value="${cartItem.color}"></c:out></li>
		                  </ul>
		                </td>
		                <td class="product-price">
		                  <span class="amount">$<c:out value="${cartItem.price}"></c:out></span>
		                </td>
		                <td class="product-quantity">
		                  <div class="quantity buttons_added">
		                    <input type="button" value="-" class="minus">
		                    <input type="number" step="1" min="0" value="<c:out value="${cartItem.quantity}"></c:out>" title="qty" class="input-text qty text" name="qty" id="qty">
		                    <input type="button" value="+" class="plus">
		                  </div>
		                </td>
		                <td class="product-subtotal">
		                  <span class="amount">$<c:out value="${itemAmount}"></c:out></span>
		                </td>
		                <td class="product-remove">
		                  <a href="#" class="remove" name="delete" title="Remove this item">
		                    <i class="ui-close"></i>
		                  </a>
		                </td>
		              </tr>
              `;

			rootTag.append(temp);
			});
		},
		error: function() {
			alert("失敗");
			
		}
	});
}*/