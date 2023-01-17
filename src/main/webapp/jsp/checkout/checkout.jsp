<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  	<meta name="description" content="">
  	
	<title>Live4Fun | 結帳</title>
	
	
	<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
	<script src="${webApplicationPath}/${JS_SOURCE}/checkout.js"></script>
	<link rel="stylesheet" href="${webApplicationPath}/static/css/css.css">
	
	<link rel="stylesheet" href="${webApplicationPath}/static/css/bootstrap.min.css">
	<link rel="stylesheet" href="${webApplicationPath}/static/css/font-icons.css">
	<link rel="stylesheet" href="${webApplicationPath}/static/css/style.css">
	<link rel="stylesheet" href="${webApplicationPath}/static/css/color.css">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	
	<!-- jQuery Scripts -->
	<script type="text/javascript" src="${webApplicationPath}/static/js/jquery.min.js"></script>
	<script type="text/javascript" src="${webApplicationPath}/static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${webApplicationPath}/static/js/easing.min.js"></script>
	<script type="text/javascript" src="${webApplicationPath}/static/js/jquery.magnific-popup.min.js"></script>
	<script type="text/javascript" src="${webApplicationPath}/static/js/owl-carousel.min.js"></script>  
	<script type="text/javascript" src="${webApplicationPath}/static/js/flickity.pkgd.min.js"></script>
	<script type="text/javascript" src="${webApplicationPath}/static/js/modernizr.min.js"></script>
	<script type="text/javascript" src="${webApplicationPath}/static/js/scripts.js"></script>
	<script>
	var webApplicationPath = "${webApplicationPath}";
	</script>

</head>

<body>

	<!-- header start -->
	  <%@ include file="../subviews/header.jsp" %>
	<!-- header end -->
  
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

            <div class="checkout ecommerce-checkout row" >

              <div class="col-lg-7" id="customer_details">
                <div>
                  <h2 class="uppercase mb-30">訂單明細</h2>       

                  <p class="form-row form-row-first validate-required ecommerce-invalid ecommerce-invalid-required-field" id="billing_first_name_field">
                    <label for="billing_first_name">姓名
                      <abbr class="required" title="required">*</abbr>
                    </label>
                    <input type="text" class="input-text inputData" placeholder="" value="${member.name}" name="recipientName" id="recipientName">
                  </p>
                  <p class="form-row form-row-wide address-field update_totals_on_change validate-required ecommerce-validated" id="billing_country_field">
                    <label for="billing_postalCode">請填寫郵遞區號
                      <abbr class="required" title="required">*</abbr>
                    </label>
                    <input type="text" name="recipientPostalCode" id="recipientPostalCode" class="country_to_state country_select inputData" title="PostalCode *" value="${member.postalCode}">
                  </p>
                  <p class="form-row form-row-wide address-field update_totals_on_change validate-required ecommerce-validated" id="billing_city_field">
                    <label for="billing_city">縣/市
                      <abbr class="required" title="required">*</abbr>
                    </label>
                    <input type="text" name="recipientCity" id="recipientCity" class="country_to_state country_select inputData" title="City *" value="${member.city}">
                  </p>
                  <p class="form-row form-row-wide address-field update_totals_on_change validate-required ecommerce-validated" id="billing_district_field">
                    <label for="billing_district">鄉鎮/市區
                      <abbr class="required" title="required">*</abbr>
                    </label>
                    <input type="text" name="recipientDistrict" id="recipientDistrict" class="country_to_state country_select inputData" title="District *" value="${member.district}">
                  </p>
                  <p class="form-row form-row-wide address-field update_totals_on_change validate-required ecommerce-validated" id="billing_country_field">
                    <label for="billing_road">請選擇道路或街名
                      <abbr class="required" title="required">*</abbr>
                    </label>
                    <input type="text" name="recipientRoad" id="recipientRoad" class="country_to_state country_select inputData" title="Road *" value="${member.road}">
                  </p>
                  <p class="form-row form-row-wide address-field validate-required ecommerce-invalid ecommerce-invalid-required-field" id="billing_address_1_field">
                    <label for="billing_address_1">地址
                      <abbr class="required" title="required">*</abbr>
                    </label>
                    <input type="text" class="input-text inputData" placeholder="" value="${member.address}" name="recipientAddress" id="recipientAddress">
                  </p>
                  <p class="form-row form-row-last validate-required validate-phone" id="billing_phone_field">
                    <label for="billing_phone">連絡電話
                      <abbr class="required" title="required">*</abbr>
                    </label>
                    <input type="text" class="input-text inputData" placeholder="" value="${member.phoneNumber}" name="recipientPhoneNumber" id="recipientPhoneNumber">
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
                    <tbody id="checkcart">
                   	
                   
                      <tr>
                        <th><span class="count"> x </span></th>
                        <td>
                          <span class="amount">$ </span>
                        </td>
                      </tr>
               

                      <tr class="shipping">
                        <th>運費</th>
                        <td>
                          <span>免運</span>
                        </td>
                      </tr>
                      <tr class="order-total">
                        <th><strong>訂單總金額</strong></th>
                        <td>
                          <strong><span class="amount" id="total">$ </span></strong>
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
                      <input type="button" name="ecommerce_checkout_place_order" class="btn btn-lg btn-color btn-button" id="place_order" value="送出">
                    </div>
                  </div>
                </div>
              </div> <!-- end order review -->
            </div>

          </div> <!-- end ecommerce -->

        </div> <!-- end row -->
      </div> <!-- end container -->
    </section> <!-- end checkout -->

	<!-- Footer -->
		<%@ include file="../subviews/footer.jsp" %>
	<!-- end footer -->

  </main> <!-- end main-wrapper -->

</body>
</html>