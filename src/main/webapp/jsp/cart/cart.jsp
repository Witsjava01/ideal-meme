<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Live4Fun | 購物車</title>

  <meta charset="utf-8">
  <!--[if IE]><meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><![endif]-->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">

  <!-- Google Fonts -->
  <link href='../../static/css/css.css' rel='stylesheet'>

  <!-- Css -->
  <link rel="stylesheet" href="${webApplicationPath}/static/css/bootstrap.min.css">
  <link rel="stylesheet" href="${webApplicationPath}/static/css/font-icons.css">
  <link rel="stylesheet" href="${webApplicationPath}/static/css/style.css">
  <link rel="stylesheet" href="${webApplicationPath}/static/css/color.css">

  <!-- Favicons -->
  <script src="${webApplicationPath}/js/cart/cart.js"></script>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
	$(document).ready(function(){

		var cart = [];
		if (localStorage.getItem("cart")) {
		 	cart = JSON.parse(localStorage.getItem("cart"));//[object Object]
			console.log("localstorage中取得："+cart);
		    showcart();
		}else{
			alert("尚未加入商品");
			$("#cart_item_table").append("<tr>尚未加入商品</tr>");//
		}
		
		function showcart(){
		  var cartList = "", s_price = 0, total = 0;
			    console.log("cart"+JSON.stringify(cart));
			    console.log("cart.length："+cart.length);
		  for (let $i = 0; $i < cart.length; $i++) {

				var object = cart[$i];
				console.log('item ' + $i + ': ' +object.name + ',' + object.price.replace("NT","").trim()+ ',' + object.quantity);
				var price =  parseInt(object.price.replace("NT","").trim());
				var quantity =  parseInt(object.quantity);
				var maxQuantity =  parseInt(object.stock.replace("庫存:","").trim());//設定可購數量的上限
				s_price = price * quantity;
			    console.log("itemamount: "+s_price);
			    total += s_price;
			    console.log("totalamount: "+total);
			    //console.log(`\${name} Says hello \${s_price}`);
			    cartList +=
			    	`
							<tr class="cart_item">
			                <td class="product-thumbnail">
			                  <a href="#">
			                    <img src=' \${object.photoUrl1}' alt="">
			                  </a>
			                </td>
			                <td class="product-name">
			                  <a href="#"> \${object.name} </a>
			                  <ul>
			                    <li>尺寸: \${object.size} </li>
			                    <li>顏色: \${object.color}</li>
			                  </ul>
			                </td>
			                <td class="product-price">
			                  <span class="productPrice">$ \${price}</span>
			                </td>
			                <td class="product-quantity">
			                  <div class="quantity buttons_added">
			                    <input type="button" value="-" class="minus">
			                    <input type="number" step="1" min="0" max="\${maxQuantity}" value='\${quantity}' title="qty" class="input-text qty text cartItem" name="qty" id="qty\${$i}">
			                    <input type="button" value="+" class="plus">
			                  </div>
			                </td>
			                <td class="product-subtotal">
			                <span class="itemAmount">$ \${s_price} </span>
			                </td>
			                <td class="product-remove">
			                  <a href="#" class="remove cartItem" name="\${object.productId}" title="Remove this item">
			                    <i class="ui-close"></i>
			                  </a>
			                </td>
			             	</tr>
			              `;
		        }    
		  		$("#cart_item_table").empty().append(cartList);
		        console.log("cartList:"+cartList);
				$(".amount").text(total);
		}
		
		
	 	$("#btnCheckout").on("click", function() {
	 		var carData = [];
	 		$(".qty").each(function(){
	 			
	 		var cartItem = {}
	 			cartItem["quantity"] = $(this).val();
	 			cartItem["productId"] = $(this).parents("td").next().next().children().attr("name");
	 			carData.push(cartItem);
	 			
	 		})
	 		console.log(carData);
	 		console.log("carData:"+JSON.stringify(carData));
			
		  	$.ajax({
				url: "/life4fun/CheckOutServlet?method=checkout",
				type: "POST",
				data: //JSON.stringify(cartItemList),
				{"carData":JSON.stringify(carData)},
				success: function(response) {
					console.log(response)
					alert("取得購物車內容!");
				},
				error: function(jqXHR, textStatus, errorThrown) {
					alert("失敗");
				}
			});
				
		});
	 
	 	
	 	$("#btnUpdateCart").on("click", function() {//updateQuantity
	  		
	  		alert("已修改數量");	
	  		quantity=$(".qty").val();
	  		console.log("要修改的數量: "+quantity);

	  		productId=$(".remove").attr("name");
	  		console.log("productId: "+productId);

	  		for(let product of cart){
	  			if(product.productId == productId){
	  				console.log("原本數量:"+product.quantity);
	  				product.quantity = quantity;
	  				console.log("修改後；"+product.quantity);
	  			}
	  		}
	 		localStorage.setItem("cart",JSON.stringify(cart));
	  		showcart();
	  	});
	 
	 	
		$("#btnBack").on("click", function() {
		  	location.href='${webApplicationPath}/jsp/product/index.jsp';
		}); 
		
	 	$(".remove").on("click", function() {//removeItemFromCart
	 		  
	 		  productId=$(this).attr("name");
	 		  console.log($(this).attr("name"));

	 		  var temp = cart.filter(item => item.productId != productId);
	 		  console.log(JSON.stringify(temp));
		 	  localStorage.setItem("cart",JSON.stringify(temp));

		 	  showcart();
		 	  location.reload(); //  
	 		  alert("下次再購買");
	 	});
	});
	</script>


</head>

<body>
	<!-- header start -->
	  <%@ include file="../subviews/header.jsp" %>
	<!-- header end -->
    <!-- Page Title ------------------------------------------------------------ -->
    <section class="page-title text-center">
      <div class="container">
        <h1 class=" heading page-title__title">購物車</h1>
      </div>
    </section> <!-- end page title -->


    <!-- Cart -->
    <section class="section-wrap cart pt-50 pb-40">
      <div class="container relative">

        <!-- <form method='POST' action='CheckOutServlet?method=checkout' id='cartForm'> -->
		<div>
        <div class="table-wrap">
          <table class="shop_table cart table">
            <thead>
              <tr>
                <th class="product-name" colspan="2">品項</th>
                <th class="product-price">定價</th>
                <th class="product-quantity">數量</th>
                <th class="product-subtotal" colspan="2">小計</th>
              </tr>
            </thead>
            <tbody id="cart_item_table">
              
           
              
            </tbody>
          </table>
        </div>

        <div class="row mb-30">
          <div class="col-lg-5">
            
          </div>

          <div class="col-lg-7">
            <div class="actions">
              <button type="submit" id="btnBack" value="繼續購物" class="btn btn-md btn-dark btn-button" >繼續購物</button>
              <button type="submit" id="btnUpdateCart" value="修改購物車" class="btn btn-md btn-dark btn-button">修改購物車</button>
              <div class="wc-proceed-to-checkout">
                <button type="submit" id="btnCheckout" value="去結帳" class="btn btn-md btn-color btn-button">去結帳</button>
              </div>
            </div>
          </div>
        </div>
        <div class="row justify-content-between">
		<!-- </form> -->
		</div>

          <div class="col-lg-4">
            <div class="cart_totals">
              <h2 class="uppercase mb-20">購物車總計</h2>

              <table class="table shop_table">
                <tbody>
                
                  <tr class="cart-subtotal">
                    <th>購物車小計</th>
                    <td>
                      <span class="amount" ></span>
                    </td>
                  </tr>
                  <tr class="shipping">
                    <th>運費</th>
                    <td>
                      <span>免運</span>
                    </td>
                  </tr>
                  <tr class="order-total">
                    <th>訂單總金額</th>
                    <td>
                      <strong><span class="amount" ></span></strong>
                    </td>
                  </tr>
                </tbody>
              </table>

            </div>
          </div> <!-- end col cart totals -->

        </div> <!-- end row -->     

        
      </div> <!-- end container -->
    </section> <!-- end cart -->


    <!-- Footer -->
		<%@ include file="../subviews/footer.jsp" %>
	<!-- end footer -->



  </main> <!-- end main-wrapper -->
	
  <!-- jQuery Scripts -->
  <script type="text/javascript" src="${webApplicationPath}/static/js/jquery.min.js"></script>
  <script type="text/javascript" src="${webApplicationPath}/static/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="${webApplicationPath}/static/js/easing.min.js"></script>
  <script type="text/javascript" src="${webApplicationPath}/static/js/jquery.magnific-popup.min.js"></script>
  <script type="text/javascript" src="${webApplicationPath}/static/js/owl-carousel.min.js"></script>  
  <script type="text/javascript" src="${webApplicationPath}/static/js/flickity.pkgd.min.js"></script>
  <script type="text/javascript" src="${webApplicationPath}/static/js/modernizr.min.js"></script>
  <script type="text/javascript" src="${webApplicationPath}/static/js/scripts.js"></script>
    
    
</body>
</html>