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
  	
	<title>Live4Fun | Login</title>
	
	<script>
		var webApplicationPath = "${webApplicationPath}";
	</script>
	
	<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
	<script src="${webApplicationPath}/${JS_SOURCE}/login.js"></script>
	<link rel="stylesheet" href="${STATIC_SOURCE}/css/css.css">
	
	<link rel="stylesheet" href="${webApplicationPath}/${STATIC_SOURCE}/css/bootstrap.min.css">
	<link rel="stylesheet" href="${webApplicationPath}/${STATIC_SOURCE}/css/font-icons.css">
	<link rel="stylesheet" href="${webApplicationPath}/${STATIC_SOURCE}/css/style.css">
	<link rel="stylesheet" href="${webApplicationPath}/${STATIC_SOURCE}/css/color.css">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	
	<!-- jQuery Scripts -->
	<script type="text/javascript" src="${webApplicationPath}/${STATIC_SOURCE}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${webApplicationPath}/${STATIC_SOURCE}/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${webApplicationPath}/${STATIC_SOURCE}/js/easing.min.js"></script>
	<script type="text/javascript" src="${webApplicationPath}/${STATIC_SOURCE}/js/jquery.magnific-popup.min.js"></script>
	<script type="text/javascript" src="${webApplicationPath}/${STATIC_SOURCE}/js/owl-carousel.min.js"></script>  
	<script type="text/javascript" src="${webApplicationPath}/${STATIC_SOURCE}/js/flickity.pkgd.min.js"></script>
	<script type="text/javascript" src="${webApplicationPath}/${STATIC_SOURCE}/js/modernizr.min.js"></script>
	<script type="text/javascript" src="${webApplicationPath}/${STATIC_SOURCE}/js/scripts.js"></script>
	<style>
	</style>
</head>
<body>
<!-- header start -->
   <%@ include file="../subviews/header.jsp" %>
 <!-- header end -->

    <!-- Page Title -->
    <section class="page-title text-center">
      <div class="container">
        <h1 class=" heading page-title__title">Login</h1>
      </div>
    </section> <!-- end page title -->


    <!-- Login -->
    <section class="section-wrap cart pt-50 pb-40">
      <div class="container relative">
        <div class="row justify-content-content">
          <div class="col-lg-4" style="margin:0px auto;">
            <div class="row row-12">
              <div class="col-md-12">
              <p class="form-row form-row-wide">帳號</p>
                <p class="form-row form-row-wide">
                  <input type="number" class="input-text" value=""
                  placeholder="account" name="account" id="account"
                  oninput="if(value.length>15)value=value.slice(0,15)"
                  onkeypress="return event.charCode>=48 && event.charCode<=57"
                  >
                </p>
              </div>
              <div class="col-md-12">
              <p class="form-row form-row-wide">密碼</p>
                <p class="form-row form-row-wide">
                  <input type="password" class="input-text" value=""
                  placeholder="password" name="password" id="password"
                  oninput="if(value.length>12)value=value.slice(0,12)">
                </p>
              </div>
            </div>
              <div class="row justify-content-between">
			    <div class="col-4">
			      <input type="submit" id="loginButton" name="loginButton" value="登入" class="btn btn-md btn-dark btn-button">
			    </div>
			    <div class="col-4" align="right">
			      <input type="submit" id="register" name="register" value="註冊" class="btn btn-md btn-color btn-button ">
			    </div>
			  </div>
            
          </div> <!-- end col shipping calculator -->
      </div> <!-- end container -->
    </section> 
    <!-- end Login -->


    <!-- Footer -->
    <footer class="footer">
      <div class="container">
        <div class="footer__widgets">
          <div class="row">

            <div class="col-lg-4 col-md-6">
              <div class="widget widget__about">
                <h4 class="widget-title white">about us</h4>
                <p class="widget__about-text">Namira is a very slick and clean e-commerce template with endless possibilities.</p>
              </div>
            </div>

            <div class="col-lg-4 col-md-6">
              <div class="widget widget__newsletter">
                <h4 class="widget-title white">get exclusive offers &amp; updates</h4>

                <form class="mc4wp-form">
                  <div class="mc4wp-form-fields">
                    <p><input type="email" placeholder="Please enter your email address"></p>
                    <p><input type="submit" value="Subscribe"></p>
                  </div>
                </form>

                <div class="socials socials--white mt-20">
                  <a href="#" class="facebook"><i class="ui-facebook"></i></a>
                  <a href="#" class="twitter"><i class="ui-twitter"></i></a>
                  <a href="#" class="snapchat"><i class="ui-snapchat"></i></a>
                  <a href="#" class="instagram"><i class="ui-instagram"></i></a>
                  <a href="#" class="pinterest"><i class="ui-pinterest"></i></a>
                </div>
              </div>
            </div>

            <div class="col-lg-2 col-md-6">
              <div class="widget widget_nav_menu">
                <h4 class="widget-title white">help</h4>
                <ul>
                  <li><a href="#">Contact Us</a></li>
                  <li><a href="#">Tract Order</a></li>
                  <li><a href="#">Returns &amp; Refunds</a></li>
                  <li><a href="#">Private Policy</a></li>
                  <li><a href="#">Shipping Info</a></li>
                  <li><a href="#">FAQ</a></li>
                </ul>
              </div>
            </div>

            <div class="col-lg-2 col-md-6">
              <div class="widget widget_nav_menu">
                <h4 class="widget-title white">information</h4>
                <ul>
                  <li><a href="#">Our Stores</a></li>
                  <li><a href="#">Careers</a></li>
                  <li><a href="#">Delivery Info</a></li>
                  <li><a href="#">Terms &amp; Conditions</a></li>
                  <li><a href="#">Site Map</a></li>
                  <li><a href="#">Namira Reviews</a></li>
                </ul>
              </div>
            </div>

          </div>
        </div>    
      </div> <!-- end container -->

      <div class="footer__bottom">
        <div class="container">
          <div class="row">
            <div class="col-md-6 text-sm-center">
              <span class="copyright">
                Copyright &copy; 2022.Company name All rights reserved.<a target="_blank" href="https://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
              </span>
            </div>

            <div class="col-md-6 footer__payment-systems text-right text-sm-center mt-sml-10">
              <i class="ui-paypal"></i>
              <i class="ui-visa"></i>
              <i class="ui-mastercard"></i>
              <i class="ui-discover"></i>
              <i class="ui-amex"></i>
            </div>
          </div>
        </div>
      </div> <!-- end bottom footer -->
    </footer> <!-- end footer -->

    <div id="back-to-top">
      <a href="#top"><i class="ui-arrow-up"></i></a>
    </div>

  </main> <!-- end main-wrapper -->

  
    
</body>
<script>
</script>
</html>