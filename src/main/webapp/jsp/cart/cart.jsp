<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page isELIgnored="false"%>
<%@page import="life4fun.entity.CartItem"%>
<%@page import="java.util.List"%>

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
	 	$("#btnCheckout").on("click", function() {
	  		location.href='../checkout/checkout.jsp';
	  		//window.location.assign("../checkout/CheckoutServlet?method=checkout");
	  		$.ajax({
	  			url: "CheckoutServlet?method=checkout",
	  			success: function(response) {
	  				alert("已修改數量!");
	  				console.log(response.msg);
	  			},
	  			error: function() {
	  				alert("失敗");
	  			}
	  		});
	  	});
	 	
	 	$("#btnUpdateCart").on("click", function() {
	  		alert("btnUpdateCart");	
	  		//window.location.assign("CartServlet?method=updateCart");
	  		
	  		quantity=$("#qty").val();
	  		console.log("quantity: "+quantity);
	  		
	  		productId=$("#productId").val();
	  		console.log("productId: "+productId);

	  		
	  		$.ajax({
	  			url: "CartServlet?method=updateCart",
	  			method: "POST",
	  			data: {
	  				"productId":productId,
	  				"quantity":quantity
	  			},
	  			success: function(response) {
	  				alert("已修改數量!");
	  				console.log(response.msg);
	  			},
	  			error: function() {
	  				alert("失敗");
	  				
	  			}
	  		});
	  	});
	 
	 	$("[name='delete']").on("click", function() {
	  		productId=$("#productId").val();
	  		console.log("productId: "+productId);

	 		alert("delete");	
	 		$.ajax({
	  			url: "CartServlet?method=deleteCart",
	  			method: "POST",
	  			data: {
	  				"productId":productId
	  			},
	  			success: function(response) {
	  				alert("已刪除商品!");
	  				console.log(response.msg);
	  			},
	  			error: function() {
	  				alert("失敗");
	  				
	  			}
	  		});
	 	});
		$("#btnBack").on("click", function() {
		  	//alert("btnBack");		  
		  	//window.location.assign(webApplicationPath + "/jsp/product/index.jsp");
		  	location.href='../product/index.jsp';
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
        				<h3>購物車是空的!</h3>		
              <c:forEach items="${cartItemList}" var="cartItem">
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
			</c:forEach>
              
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
                      <span class="amount">$<c:out value="${totalAmount}"></c:out></span>
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
                      <strong><span class="amount">$<c:out value="${totalAmount}"></c:out></span></strong>
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
  <script type="text/javascript" src="../../static/js/jquery.min.js"></script>
  <script type="text/javascript" src="../../static/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="../../static/js/easing.min.js"></script>
  <script type="text/javascript" src="../../static/js/jquery.magnific-popup.min.js"></script>
  <script type="text/javascript" src="../../static/js/owl-carousel.min.js"></script>  
  <script type="text/javascript" src="../../static/js/flickity.pkgd.min.js"></script>
  <script type="text/javascript" src="../../static/js/modernizr.min.js"></script>
  <script type="text/javascript" src="../../static/js/scripts.js"></script>
    
    
</body>
</html>