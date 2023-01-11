<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page isELIgnored="false"%>
<!--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>-->
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  	<meta name="description" content="">
  	
	<title>Live4Fun | 結帳</title>
	
	
	<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
	<script src="${webApplicationPath}/${JS_SOURCE}/checkout.js"></script>
	<link rel="stylesheet" href="../../static/css/css.css">
	
	<link rel="stylesheet" href="../../static/css/bootstrap.min.css">
	<link rel="stylesheet" href="../../static/css/font-icons.css">
	<link rel="stylesheet" href="../../static/css/style.css">
	<link rel="stylesheet" href="../../static/css/color.css">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	
	<!-- jQuery Scripts -->
	<script type="text/javascript" src="../../static/js/jquery.min.js"></script>
	<script type="text/javascript" src="../../static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../../static/js/easing.min.js"></script>
	<script type="text/javascript" src="../../static/js/jquery.magnific-popup.min.js"></script>
	<script type="text/javascript" src="../../static/js/owl-carousel.min.js"></script>  
	<script type="text/javascript" src="../../static/js/flickity.pkgd.min.js"></script>
	<script type="text/javascript" src="../../static/js/modernizr.min.js"></script>
	<script type="text/javascript" src="../../static/js/scripts.js"></script>
	<style>
	</style>
</head>

<body>

<jsp:include page="../subviews/header.jsp">
    <jsp:param name="a" value="1" />
    <jsp:param name="b" value="2" />
</jsp:include>
<!-- end navigation -->
  
    <!-- Page Title -->
    <section class="page-title text-center">
      <div class="container">
        <h1 class=" heading page-title__title">結帳</h1>
      </div>
    </section> <!-- end page title -->


    <!-- Checkout -->
    <section class="section-wrap checkout">
      <div class="container relative">
        <div class="row">

          <div class="ecommerce col">

            <div class="row mb-30">
              <!--<div class="col-md-8">
                <p class="ecommerce-info">
                  Returning Customer? 
                  <a href="#" class="showlogin">Click here to login</a>
                </p>
              </div>  -->
            </div>

            <form method='POST' action='CheckOutServlet?method=sendOrder' id="sendOrder" class="checkout ecommerce-checkout row" >

              <div class="col-lg-7" id="customer_details">
                <div>
                  <h2 class="uppercase mb-30">訂單明細</h2>

                  <p class="form-row form-row-first validate-required ecommerce-invalid ecommerce-invalid-required-field" id="billing_first_name_field">
                    <label for="billing_first_name">姓名
                      <abbr class="required" title="required">*</abbr>
                    </label>
                    <input type="text" class="input-text" placeholder="" value="" name="billing_first_name" id="billing_first_name">
                  </p>
                  
                  <p class="form-row form-row-wide address-field update_totals_on_change validate-required ecommerce-validated" id="billing_country_field">
                    <label for="billing_city">請填寫郵遞區號
                      <abbr class="required" title="required">*</abbr>
                    </label>
                    <input type="text" name="billing_postalCode" id="billing_country" class="country_to_state country_select" title="PostalCode *">
                   
                  </p>
                  
                  <p class="form-row form-row-wide address-field update_totals_on_change validate-required ecommerce-validated" id="billing_city_field">
                    <label for="billing_city">縣/市
                      <abbr class="required" title="required">*</abbr>
                    </label>
                    <select name="billing_city" id="billing_city" class="country_to_state country_select" title="City *">
                      <option>請選擇縣市…</option>
                      <option value="AF">Afghanistan</option>                    
                      <option value="EH">Western Sahara</option>
                    </select>
                  </p>
                  
                  <p class="form-row form-row-wide address-field update_totals_on_change validate-required ecommerce-validated" id="billing_district_field">
                    <label for="billing_district">鄉鎮/市區
                      <abbr class="required" title="required">*</abbr>
                    </label>
                    <select name="billing_district" id="billing_district" class="country_to_state country_select" title="District *">
                      <option>請選擇鄉鎮市區…</option>
                      <option value="AF">Afghanistan</option>          
                    </select>
                  </p>
                  
                  <p class="form-row form-row-wide address-field update_totals_on_change validate-required ecommerce-validated" id="billing_country_field">
                    <label for="billing_road">請選擇道路或街名
                      <abbr class="required" title="required">*</abbr>
                    </label>
                    <select name="billing_road" id="billing_road" class="country_to_state country_select" title="Road *">
                      <option>請選擇道路或街名…</option>
                      <option value="AF">Afghanistan</option>          
                    </select>
                  </p>

                  <p class="form-row form-row-wide address-field validate-required ecommerce-invalid ecommerce-invalid-required-field" id="billing_address_1_field">
                    <label for="billing_address_1">地址
                      <abbr class="required" title="required">*</abbr>
                    </label>
                    <input type="text" class="input-text" placeholder="Street address" value="" name="billing_address_1" id="billing_address_1">
                  </p>

                  <p class="form-row form-row-wide address-field" id="billing_address_2_field">
                    <input type="text" class="input-text" placeholder="Apartment, suite, unit etc. (optional)" value="" name="billing_address_2" id="billing_address_2">
                  </p>
                  
                  <p class="form-row form-row-last validate-required validate-phone" id="billing_phone_field">
                    <label for="billing_phone">連絡電話
                      <abbr class="required" title="required">*</abbr>
                    </label>
                    <input type="text" class="input-text" placeholder="" value="" name="billing_phone" id="billing_phone">
                  </p>
                   

                </div>

              

                <div>
           
                </div>

              </div> <!-- end col -->

              <!-- Your Order -->
              <div class="col-lg-5">
                <div class="order-review-wrap ecommerce-checkout-review-order" id="order_review">
                  <h2 class="uppercase">您的訂單</h2>
                  <table class="table shop_table ecommerce-checkout-review-order-table">
                    <tbody>
                      <tr>
                        <th>${item.productName}<span class="count"> x ${item.quantity}</span></th>
                        <td>
                          <span class="amount">$ ${item.subAmount}</span>
                        </td>
                      </tr>
                      <!--<tr>
                        <th>California Dress<span class="count"> x 1</span></th>
                        <td>
                          <span class="amount">$1299.00</span>
                        </td>
                      </tr>
                      <tr class="cart-subtotal">
                        <th>Cart Subtotal</th>
                        <td>
                          <span class="amount">$1799.00</span>
                        </td>
                      </tr>  -->
                      <tr class="shipping">
                        <th>運費</th>
                        <td>
                          <span>免運</span>
                        </td>
                      </tr>
                      <tr class="order-total">
                        <th><strong>訂單總金額</strong></th>
                        <td>
                          <strong><span class="amount">$ ${item.subAmount}</span></strong>
                        </td>
                      </tr>
                    </tbody>
                  </table>

                  <div id="payment" class="ecommerce-checkout-payment">
                    <h2 class="uppercase">付款方式</h2>
                    <ul class="payment_methods methods">

                      <li class="payment_method_bacs">
                        <input id="payment_method_bacs" type="radio" class="input-radio" name="payment_method" value="bacs" checked="checked">
                        <label for="payment_method_bacs">門市付款</label>
                        <div class="payment_box payment_method_bacs">
                        </div>
                      </li>

                      <li class="payment_method_cheque">
                        <input id="payment_method_cheque" type="radio" class="input-radio" name="payment_method" value="cheque">
                        <label for="payment_method_cheque">貨到付款</label>
                        <div class="payment_box payment_method_cheque">
                        </div>
                      </li>

                      <li class="payment_method_paypal">
                        <input id="payment_method_paypal" type="radio" class="input-radio" name="payment_method" value="paypal">
                        <label for="payment_method_paypal">超商付款</label>
                        <img src="static/picture/paypal.png" alt="">
                        <div class="payment_box payment_method_paypal">
                        </div>
                      </li>

                    </ul>
                    <div class="form-row place-order">
                      <input type="submit" name="ecommerce_checkout_place_order" class="btn btn-lg btn-color btn-button" id="place_order" value="送出">
                    </div>
                  </div>
                </div>
              </div> <!-- end order review -->
            </form>

          </div> <!-- end ecommerce -->

        </div> <!-- end row -->
      </div> <!-- end container -->
    </section> <!-- end checkout -->


<jsp:include page="../subviews/footer.jsp">
    <jsp:param name="a" value="1" />
    <jsp:param name="b" value="2" />
</jsp:include>

  </main> <!-- end main-wrapper -->

</body>
</html>