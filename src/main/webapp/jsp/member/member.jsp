<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page isELIgnored="false"%>
<!--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>-->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">

<title>Live4Fun | 會員編輯個人資料</title>

<script>
	var webApplicationPath = "${webApplicationPath}";
	var isUpdate = ${isUpdate};
</script>

<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script src="${webApplicationPath}/${JS_SOURCE}/member.js"></script>
<link rel="stylesheet" href="${STATIC_SOURCE}/css/css.css">

<link rel="stylesheet"
	href="${webApplicationPath}/${STATIC_SOURCE}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${webApplicationPath}/${STATIC_SOURCE}/css/font-icons.css">
<link rel="stylesheet"
	href="${webApplicationPath}/${STATIC_SOURCE}/css/style.css">
<link rel="stylesheet"
	href="${webApplicationPath}/${STATIC_SOURCE}/css/color.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>

<!-- jQuery Scripts -->
<script type="text/javascript"
	src="${webApplicationPath}/${STATIC_SOURCE}/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${webApplicationPath}/${STATIC_SOURCE}/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${webApplicationPath}/${STATIC_SOURCE}/js/easing.min.js"></script>
<script type="text/javascript"
	src="${webApplicationPath}/${STATIC_SOURCE}/js/jquery.magnific-popup.min.js"></script>
<script type="text/javascript"
	src="${webApplicationPath}/${STATIC_SOURCE}/js/owl-carousel.min.js"></script>
<script type="text/javascript"
	src="${webApplicationPath}/${STATIC_SOURCE}/js/flickity.pkgd.min.js"></script>
<script type="text/javascript"
	src="${webApplicationPath}/${STATIC_SOURCE}/js/modernizr.min.js"></script>
<script type="text/javascript"
	src="${webApplicationPath}/${STATIC_SOURCE}/js/scripts.js"></script>
<style>
</style>
</head>
<body>

	<!-- Preloader -->
	<div class="loader-mask">
		<div class="loader">
			<div></div>
		</div>
	</div>


	<!-- Mobile Sidenav -->
	<header class="sidenav" id="sidenav">
		<!-- Search -->
		<div class="sidenav__search-mobile">
			<form method="get" class="sidenav__search-mobile-form">
				<input type="search" class="sidenav__search-mobile-input"
					placeholder="Search...">
				<button type="submit" class="sidenav__search-mobile-submit">
					<i class="ui-search"></i>
				</button>
			</form>
		</div>

		<nav>
			<ul class="sidenav__menu">
				<li><a href="#" class="sidenav__menu-link">Men</a>
					<button class="sidenav__menu-toggle">
						<i class="ui-arrow-down"></i>
					</button>
					<ul class="sidenav__menu-dropdown">
						<li><a href="#" class="sidenav__menu-link">T-shirt</a></li>
						<li><a href="#" class="sidenav__menu-link">Hoodie &amp;
								Jackets</a></li>
						<li><a href="#" class="sidenav__menu-link">Suits</a></li>
						<li><a href="#" class="sidenav__menu-link">Shorts</a></li>
					</ul></li>

				<li><a href="#" class="sidenav__menu-link">Women</a>
					<button class="sidenav__menu-toggle">
						<i class="ui-arrow-down"></i>
					</button>
					<ul class="sidenav__menu-dropdown">
						<li><a href="#" class="sidenav__menu-link">Underwear</a></li>
						<li><a href="#" class="sidenav__menu-link">Hipster</a></li>
						<li><a href="#" class="sidenav__menu-link">Dress</a></li>
						<li><a href="#" class="sidenav__menu-link">Hoodie &amp;
								Jackets</a></li>
						<li><a href="#" class="sidenav__menu-link">Tees</a></li>
					</ul></li>

				<li><a href="#" class="sidenav__menu-link">Accessories</a>
					<button class="sidenav__menu-toggle">
						<i class="ui-arrow-down"></i>
					</button>
					<ul class="sidenav__menu-dropdown">
						<li><a href="#" class="sidenav__menu-link">All
								accessories</a>
							<button class="sidenav__menu-toggle">
								<i class="ui-arrow-down"></i>
							</button>
							<ul class="sidenav__menu-dropdown">
								<li><a href="#" class="sidenav__menu-link">Wallets</a></li>
								<li><a href="#" class="sidenav__menu-link">Scarfs</a></li>
								<li><a href="#" class="sidenav__menu-link">Shirt</a></li>
								<li><a href="#" class="sidenav__menu-link">Shoes</a></li>
							</ul></li>

						<li><a href="#" class="sidenav__menu-link">for her</a>
							<button class="sidenav__menu-toggle">
								<i class="ui-arrow-down"></i>
							</button>
							<ul class="sidenav__menu-dropdown">
								<li><a href="#" class="sidenav__menu-link">Underwear</a></li>
								<li><a href="#" class="sidenav__menu-link">Hipster</a></li>
								<li><a href="#" class="sidenav__menu-link">Dress</a></li>
								<li><a href="#" class="sidenav__menu-link">Hoodie &amp;
										Jackets</a></li>
								<li><a href="#" class="sidenav__menu-link">Tees</a></li>
							</ul></li>

						<li><a href="#" class="sidenav__menu-link">for him</a>
							<button class="sidenav__menu-toggle">
								<i class="ui-arrow-down"></i>
							</button>
							<ul class="sidenav__menu-dropdown">
								<li><a href="#" class="sidenav__menu-link">T-shirt</a></li>
								<li><a href="#" class="sidenav__menu-link">Hoodie &amp;
										Jackets</a></li>
								<li><a href="#" class="sidenav__menu-link">Dress</a></li>
								<li><a href="#" class="sidenav__menu-link">Suits</a></li>
								<li><a href="#" class="sidenav__menu-link">Shorts</a></li>
							</ul></li>

						<li><a href="#" class="sidenav__menu-link">Watches</a>
							<button class="sidenav__menu-toggle">
								<i class="ui-arrow-down"></i>
							</button>
							<ul class="sidenav__menu-dropdown">
								<li><a href="#" class="sidenav__menu-link">Smart
										Watches</a></li>
								<li><a href="#" class="sidenav__menu-link">Diving
										Watches</a></li>
								<li><a href="#" class="sidenav__menu-link">Sport
										Watches</a></li>
								<li><a href="#" class="sidenav__menu-link">Classic
										Watches</a></li>
							</ul></li>

					</ul></li>

				<li><a href="#" class="sidenav__menu-link">News</a>
					<button class="sidenav__menu-toggle">
						<i class="ui-arrow-down"></i>
					</button>
					<ul class="sidenav__menu-dropdown">
						<li><a href="blog-standard.html" class="sidenav__menu-link">Blog
								Standard</a></li>
						<li><a href="blog-single.html" class="sidenav__menu-link">Single
								Post</a></li>
					</ul></li>

				<li><a href="#" class="sidenav__menu-link">Pages</a>
					<button class="sidenav__menu-toggle">
						<i class="ui-arrow-down"></i>
					</button>
					<ul class="sidenav__menu-dropdown">
						<li><a href="" class="sidenav__menu-link">Catalog</a></li>
						<li><a href="single-product.html" class="sidenav__menu-link">Single
								Product</a></li>
						<li><a href="cart.html" class="sidenav__menu-link">Cart</a></li>
						<li><a href="checkout.html" class="sidenav__menu-link">Checkout</a></li>
						<li><a href="about.html" class="sidenav__menu-link">About</a></li>
						<li><a href="contact.html" class="sidenav__menu-link">Contact</a></li>
						<li><a href="login.html" class="sidenav__menu-link">Login</a></li>
						<li><a href="faq.html" class="sidenav__menu-link">FAQ</a></li>
						<li><a href="404.html" class="sidenav__menu-link">404</a></li>
					</ul></li>

				<li><a href="#" class="sidenav__menu-link">Sign In</a></li>
			</ul>
		</nav>
	</header>
	<!-- end mobile sidenav -->


	<main class="main oh" id="main">

		<!-- Navigation -->
		<header class="nav">

			<div class="nav__holder nav--sticky">
				<div class="container relative">

					<!-- Top Bar -->
					<div class="top-bar d-none d-lg-flex">

						<!-- Currency / Language -->
						<ul class="top-bar__currency-language">
							<li class="top-bar__language"><a href="#">English</a>
								<div class="top-bar__language-dropdown">
									<ul>
										<li><a href="#">English</a></li>
										<li><a href="#">Spanish</a></li>
										<li><a href="#">German</a></li>
										<li><a href="#">Chinese</a></li>
									</ul>
								</div></li>
							<li class="top-bar__currency"><a href="#">USD</a>
								<div class="top-bar__currency-dropdown">
									<ul>
										<li><a href="#">USD</a></li>
										<li><a href="#">EUR</a></li>
									</ul>
								</div></li>
						</ul>

						<!-- Promo -->
						<p class="top-bar__promo text-center">Free shipping on orders
							over $50</p>

						<!-- Sign in / Wishlist / Cart -->
						<div class="top-bar__right">

							<!-- Sign In -->
							<a href="login.html" class="top-bar__item top-bar__sign-in" id="top-bar__sign-in">
							<i class="ui-user"></i><a href="${webApplicationPath}/MemberServlet?method=member" id="SignIn_A">會員中心</a></a>

							<!-- Wishlist -->
							<a href="#" class="top-bar__item"><i class="ui-heart"></i></a>

							<div class="top-bar__item nav-cart">
								<a href="cart.html"> <i class="ui-bag"></i>(2)
								</a>
								<div class="nav-cart__dropdown">
									<div class="nav-cart__items">

										<div class="nav-cart__item clearfix">
											<div class="nav-cart__img">
												<a href="#"> <img src="static/picture/cart_small_1.jpg"
													alt="">
												</a>
											</div>
											<div class="nav-cart__title">
												<a href="#"> Classic White Tailored Shirt </a>
												<div class="nav-cart__price">
													<span>1 x</span> <span>19.99</span>
												</div>
											</div>
											<div class="nav-cart__remove">
												<a href="#"><i class="ui-close"></i></a>
											</div>
										</div>

										<div class="nav-cart__item clearfix">
											<div class="nav-cart__img">
												<a href="#"> <img src="static/picture/cart_small_2.jpg"
													alt="">
												</a>
											</div>
											<div class="nav-cart__title">
												<a href="#"> Sport Hi Adidas </a>
												<div class="nav-cart__price">
													<span>1 x</span> <span>29.00</span>
												</div>
											</div>
											<div class="nav-cart__remove">
												<a href="#"><i class="ui-close"></i></a>
											</div>
										</div>

									</div>
									<!-- end cart items -->

									<div class="nav-cart__summary">
										<span>Cart Subtotal</span> <span class="nav-cart__total-price">$1799.00</span>
									</div>

									<div class="nav-cart__actions mt-20">
										<a href="javascript:;" class="btn btn-md btn-light"><span>View
												Cart</span></a> <a href="javascript:;"
											class="btn btn-md btn-color mt-10"><span>Proceed
												to Checkout</span></a>
									</div>
								</div>
							</div>
						</div>

					</div>
					<!-- end top bar -->

					<div class="flex-parent">

						<!-- Mobile Menu Button -->
						<button class="nav-icon-toggle" id="nav-icon-toggle">
							<span class="nav-icon-toggle__box"> <span
								class="nav-icon-toggle__inner"></span>
							</span>
						</button>
						<!-- end mobile menu button -->

						<!-- Logo -->
						<a href="index.html" class="logo"> <img class="logo__img"
							src="static/picture/logo_light.png" alt="logo">
						</a>

						<!-- Nav-wrap -->
						<nav class="flex-child nav__wrap d-none d-lg-block">
							<ul class="nav__menu">

								<li class="nav__dropdown active"><a href="">Men</a>
									<ul class="nav__dropdown-menu">
										<li><a href="#">T-shirt</a></li>
										<li><a href="#">Hoodie &amp; Jackets</a></li>
										<li><a href="#">Suits</a></li>
										<li><a href="#">Shorts</a></li>
									</ul></li>

								<li class="nav__dropdown"><a href="">Women</a>
									<ul class="nav__dropdown-menu">
										<li><a href="#">Underwear</a></li>
										<li><a href="#">Hipster</a></li>
										<li><a href="#">Dress</a></li>
										<li><a href="#">Hoodie &amp; Jackets</a></li>
										<li><a href="#">Tees</a></li>
									</ul></li>

								<li class="nav__dropdown"><a href="">Accessories</a>
									<ul class="nav__dropdown-menu nav__megamenu">
										<li>
											<div class="nav__megamenu-wrap">
												<div class="row">

													<div class="col nav__megamenu-item">
														<a href="#" class="nav__megamenu-title">All
															accessories</a>
														<ul class="nav__megamenu-list">
															<li><a href="#">Wallets</a></li>
															<li><a href="#">Scarfs</a></li>
															<li><a href="#">Belts</a></li>
															<li><a href="#">Shoes</a></li>
														</ul>
													</div>

													<div class="col nav__megamenu-item">
														<a href="#" class="nav__megamenu-title">for her</a>
														<ul class="nav__megamenu-list">
															<li><a href="#">Underwear</a></li>
															<li><a href="#">Hipster</a></li>
															<li><a href="#">Dress</a></li>
															<li><a href="#">Hoodie &amp; Jackets</a></li>
															<li><a href="#">Tees</a></li>
														</ul>
													</div>

													<div class="col nav__megamenu-item">
														<a href="#" class="nav__megamenu-title">for him</a>
														<ul class="nav__megamenu-list">
															<li><a href="#">T-shirt</a></li>
															<li><a href="#">Hoodie &amp; Jackets</a></li>
															<li><a href="#">Suits</a></li>
															<li><a href="#">Shorts</a></li>
														</ul>
													</div>

													<div class="col nav__megamenu-item">
														<a href="#" class="nav__megamenu-title">watches</a>
														<ul class="nav__megamenu-list">
															<li><a href="#">Smart Watches</a></li>
															<li><a href="#">Diving Watches</a></li>
															<li><a href="#">Sport Watches</a></li>
															<li><a href="#">Classic Watches</a></li>
														</ul>
													</div>

													<div class="col nav__megamenu-item">
														<a href="#"><img
															src="static/picture/megamenu_banner.png" alt=""></a>
													</div>

												</div>
											</div>
										</li>
									</ul></li>

								<li class="nav__dropdown"><a href="#">News</a>
									<ul class="nav__dropdown-menu">
										<li><a href="blog-standard.html">Blog Standard</a></li>
										<li><a href="blog-single.html">Single Post</a></li>
									</ul></li>

								<li class="nav__dropdown"><a href="contact.html">Pages</a>
									<ul class="nav__dropdown-menu">
										<li><a href="">Catalog</a></li>
										<li><a href="single-product.html">Single Product</a></li>
										<li><a href="cart.html">Cart</a></li>
										<li><a href="checkout.html">Checkout</a></li>
										<li><a href="about.html">About</a></li>
										<li><a href="contact.html">Contact</a></li>
										<li><a href="faq.html">FAQ</a></li>
										<li><a href="404.html">404</a></li>
									</ul></li>

							</ul>
							<!-- end menu -->

						</nav>
						<!-- end nav-wrap -->


						<!-- Search -->
						<div class="flex-child nav__search d-none d-lg-block">
							<form method="get" class="nav__search-form">
								<input type="search" class="nav__search-input"
									placeholder="Search">
								<button type="submit" class="nav__search-submit">
									<i class="ui-search"></i>
								</button>
							</form>
						</div>


						<!-- Mobile Wishlist -->
						<a href="#" class="nav__mobile-wishlist d-lg-none"> <i
							class="ui-heart"></i>
						</a>

						<!-- Mobile Cart -->
						<a href="cart.html" class="nav__mobile-cart d-lg-none"> <i
							class="ui-bag"></i> <span class="nav__mobile-cart-amount">(2)</span>
						</a>




					</div>
					<!-- end flex-parent -->
				</div>
				<!-- end container -->

			</div>
		</header>
		<!-- end navigation -->

		<!-- Catalog -->
		<section class="section-wrap pt-60 pb-30 catalog">
			<div class="container">

				<!-- Breadcrumbs -->

				<div class="row">
					<div class="col-lg-9 order-lg-2 mb-40">

						<!-- Filter -->
						<section class="">
							<div class="container">
								<div class="row justify-content-content">
									<div class="col-lg-7">
										<div class="row row-12">
											<div class="col-md-12">
												<div class="row row-12">
													<p style="color:red;margin-left:15px">*</p>
													<p>姓名</p>
												</div>
												<input type="text" class="input-text inputData" value="" maxlength="5"
													placeholder="name" name="name" id="name"onkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')" 
													onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\u4E00-\u9FA5]/g,''))" 
													required="required">
											</div>
											<div class="col-md-12">
												<div class="row row-12">
													<p style="color:red;margin-left:15px">*</p>
													<p>電話號碼</p>
												</div>
												<input type="text" class="input-text inputData" value=""
													placeholder="phoneNumber" name="phoneNumber" id="phoneNumber" maxlength="15"
													oninput="if(value.length>15)value=value.slice(0,15)"
                  									onkeypress="return event.charCode>=48 && event.charCode<=57" disabled>
											</div>
											<div class="col-md-12" id="passwordDiv">
												<div class="row row-12">
													<p style="color:red;margin-left:15px">*</p>
													<p>密碼</p>
												</div>
												<input type="password" class="input-text inputData" value="" maxlength="12"
													placeholder="password" name="password" id="password"
													oninput="if(value.length>12)value=value.slice(0,12)"
													onKeyUp="value=value.replace(/[\W]/g,'')" required="required">
											</div>
											<div class="col-md-4">
												<p class="form-row form-row-wide">性別</p>
												<select id="gender" class="form-select">
													<option name="Female" id="Female">女</option>
													<option name="male" id="male">男</option>
												</select>
											</div>
											<div class="col-md-4">
												<p class="form-row form-row-wide">年齡</p>
												<input
													type="text" class="form-control inputData" id="age"
													placeholder="age" disabled>
											</div>
											<div class="col-md-12">
												<div class="row row-12">
													<p style="color:red;margin-left:15px">*</p>
													<p>生日</p>
												</div>
												<p style="color:red;" id="age_p" hidden="hidden">年齡不可小於12歲!</p>
												<input type="date" class="input-text inputData" value=""
													placeholder="YYYY-MM-DD" name="birthday" id="birthday"
													oninput="calculateAge(this)" required="required">
											</div>
											<div class="col-md-12">
												<p>E-mail</p>
												<p style="color:red;" id="eamil_p" hidden="hidden">E-mail格式不正確!</p>
												<input type="text" class="input-text inputData" value=""
													placeholder="E-mail" name="email" id="email" maxlength="30"
													oninput="IsEmail(this.value)">
											</div>
											<div class="col-md-12">
												<p class="form-row form-row-wide">郵遞區號</p>
												<input
													type="text" class="form-control inputData" id="postalCode"
													placeholder="郵遞區號" value="" disabled>
											</div>
											<div class="col-md-4">
												<p class="form-row form-row-wide">縣/市</p>
												<select id="city" class="form-select">
													<option id="cityOption" value="cityDefault" selected>請選擇縣/市</option>
												</select>
											</div>
											<div class="col-md-4">
												<p class="form-row form-row-wide">區域</p>
												<select id="district" class="form-select">
													<option id="districtOption" value="districtDefault" selected>請選擇區域</option>
												</select>
											</div>
											<div class="col-md-4">
												<p class="form-row form-row-wide">路/街</p>
												<select id="road" class="form-select">
													<option id="roadOption" value="roadDefault" selected>請選擇路/街</option>
												</select>
											</div>
											<div class="col-md-12">
												<label for="" class="form-label">地址</label> 
												<input type="text" class="form-control inputData" id="address" placeholder="地址" maxlength="30"
												onkeyup="this.value=this.value.replace(/\s+/g,'')">
											</div>
										</div>
									</div>
									<!-- end col shipping calculator -->
								</div>
								<!-- end container -->
						</section>

						<div class="row row-6">

							<div class="col-md col-sm-6">
								<div class="" id="revise">
									<p>
						              <input type="submit" id="reviseButton" name="reviseButton" value="修改" class="btn btn-md btn-dark btn-button" style="margin-left :15px;">
						            </p>    
								</div>
								<div class="row justify-content" id="register">
								    <div class="col-4">
								      <input type="submit" id="registerButton" name="registerButton" value="註冊" class="btn btn-md btn-dark btn-button" style="margin-left :15px;">
						             </div>
								    <div class="col-4" align="center">
								      <input type="submit" id="loginButton" name="loginButton" value="上一頁" class="btn btn-md btn-color btn-button" style="margin-right :15px;">
						            </div>
								 </div>
							</div>
						</div>
						<!-- end row -->
					</div>
					<!-- end col -->


					<!-- Sidebar -->
					<aside class="col-lg-3 sidebar left-sidebar">

						<!-- member -->
						<div class="widget widget_categories widget--bottom-line" id="memberList">
							<h4 class="widget-title">會員中心</h4>
							<ul>
								<li style="color:orange">個人資料</li>
								<li><a href="${webApplicationPath}/MemberServlet?method=password">修改密碼</a></li>
								<li><a href="${webApplicationPath}/OrderServlet?method=order">訂單查詢</a></li>
							</ul>
						</div>
						<div id="signOut">
						<input type="submit" id="signOutButton" name="signOutButton" value="登出" class="btn btn-md btn-dark btn-button">
						</div>
						
					</aside>
					<!-- end sidebar -->
					
				</div>
				<!-- end row -->
			</div>
			<!-- end container -->
		</section>
		<!-- end catalog -->

		<!-- Footer -->
		<footer class="footer">
			<div class="container">
				<div class="footer__widgets">
					<div class="row">

						<div class="col-lg-4 col-md-6">
							<div class="widget widget__about">
								<h4 class="widget-title white">about us</h4>
								<p class="widget__about-text">Namira is a very slick and
									clean e-commerce template with endless possibilities.</p>
							</div>
						</div>

						<div class="col-lg-4 col-md-6">
							<div class="widget widget__newsletter">
								<h4 class="widget-title white">get exclusive offers &amp;
									updates</h4>

								<form class="mc4wp-form">
									<div class="mc4wp-form-fields">
										<p>
											<input type="email"
												placeholder="Please enter your email address">
										</p>
										<p>
											<input type="submit" value="Subscribe">
										</p>
									</div>
								</form>

								<div class="socials socials--white mt-20">
									<a href="#" class="facebook"><i class="ui-facebook"></i></a> <a
										href="#" class="twitter"><i class="ui-twitter"></i></a> <a
										href="#" class="snapchat"><i class="ui-snapchat"></i></a> <a
										href="#" class="instagram"><i class="ui-instagram"></i></a> <a
										href="#" class="pinterest"><i class="ui-pinterest"></i></a>
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
			</div>
			<!-- end container -->

			<div class="footer__bottom">
				<div class="container">
					<div class="row">
						<div class="col-md-6 text-sm-center">
							<span class="copyright"> Copyright &copy; 2022.Company
								name All rights reserved.<a target="_blank"
								href="https://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
							</span>
						</div>

						<div
							class="col-md-6 footer__payment-systems text-right text-sm-center mt-sml-10">
							<i class="ui-paypal"></i> <i class="ui-visa"></i> <i
								class="ui-mastercard"></i> <i class="ui-discover"></i> <i
								class="ui-amex"></i>
						</div>
					</div>
				</div>
			</div>
			<!-- end bottom footer -->
		</footer>
		<!-- end footer -->

		<div id="back-to-top">
			<a href="#top"><i class="ui-arrow-up"></i></a>
		</div>

	</main>
	<!-- end main-wrapper -->
</body>
<script>
$(document).ready(function() {
	
	var streetName = new Map();
	var cityList = new Set();
	<c:forEach var="streetName" items="${streetNameList}">
		streetName.set(['${streetName.postalCode}',
				'${streetName.city}', '${streetName.district}',
				'${streetName.road}' ]);
		cityList.add('${streetName.city}');
	</c:forEach>
	
	cityList.forEach(function (value) {
		  $("select[id=city]")
			.append($("<option></option>")
			.attr("value",value)
			.text(value));
	});
	var districtList = new Set();
	var roadList = new Set();
	$("select[id=city]").change(function() {
		$("input[id='postalCode']").val("");
		districtList.clear();
		roadList.clear();
		$("option[class='districtList']").remove();
		$("option[class='roadList']").remove();
		for (let key of streetName.keys()) {
			if(key[1]===$("select[id=city]").val()){
				districtList.add(key[2]);
			}
		}
		districtList.forEach(function (value) {
			  $("select[id=district]")
				.append($("<option class='districtList'></option>")
				.attr("value",value)
				.text(value));
		});
	});
	
	
	$("select[id=district]").change(function() {
		$("input[id='postalCode']").val("");
		roadList.clear();
		$("option[class='roadList']").remove();
		for (let key of streetName.keys()) {
			if(key[2]===$("select[id=district]").val()){
				roadList.add(key[3]);
				$("input[id='postalCode']").val(key[0]);
			}
		}
		roadList.forEach(function (value) {
			  $("select[id=road]")
				.append($("<option class='roadList'></option>")
				.attr("value",value)
				.text(value));
		});
		if(roadList.size === 1){
			$("option[id='roadDefault']").prop("selected",'');
			$("option[class='roadList']").prop("selected",'selected');
			$("select[id=road]").prop('disabled', 'disabled');
		}else{
			$("option[id='roadDefault']").prop("selected",'selected');
			$("select[id=road]").prop('disabled', false);
		}
		
	});
	
	if (isUpdate) {
		$('#memberList').css('display', '');
		$('#signOut').css('display', '');
		$('#phoneNumber').attr("disabled", "disabled");
		$('#phoneNumber').removeAttr("required");
		$('#revise').css('display', '');
		$('#register').css('display', 'none');
		$("#passwordDiv").css('display', 'none');
		$("#SignIn_A").text("會員中心");
		if('${member}' != null )
		//取登入者資料 自動填入
		$('#name').val('${member.name}');
		$('#email').val('${member.email}');
		$('#address').val('${member.address}');
		$('#phoneNumber').val('${member.phoneNumber}');
		$('#birthday').val('${member.birthday}');
		$('#age').val('${member.age}');
		var password = '${member.password}';
		if('${member.gender}' === 'F'){
			$('#gender').val('女');
		}else{
			$('#gender').val('男');
		}
		if('${member.city}' === ""){
			$('option[value="cityDefault"]').attr('selected', 'selected')
		}else{
			$('#city').val('${member.city}');
		}
		
		for (let key of streetName.keys()) {
			if(key[1]===$("select[id=city]").val()){
				districtList.add(key[2]);
			}
		}
		districtList.forEach(function (value) {
			  $("select[id=district]")
				.append($("<option class='districtList'></option>")
				.attr("value",value)
				.text(value));
		});
		$("option[class='districtList']").each(function(){
			if($(this).val()=== '${member.district}'){
				$(this).attr('selected', 'selected')
			}
		});
		for (let key of streetName.keys()) {
			if(key[2]===$("select[id=district]").val()){
				roadList.add(key[3]);
				$("input[id='postalCode']").val(key[0]);
			}
		}
		roadList.forEach(function (value) {
			  $("select[id=road]")
				.append($("<option class='roadList'></option>")
				.attr("value",value)
				.text(value));
		});
		if(roadList.size === 1){
			$("option[id='roadDefault']").prop("selected",'');
			$("option[class='roadList']").prop("selected",'selected');
			$("select[id=road]").prop('disabled', 'disabled');
		}else{
			$("option[id='roadDefault']").prop("selected",'selected');
			$("select[id=road]").prop('disabled', false);
		}
		$("option[class='roadList']").each(function(){
			if($(this).val()=== '${member.road}'){
				$(this).attr('selected', 'selected')
			}
		});
		$('#postalCode').val('${member.postalCode}');
		
		
	} else {
		$("#passwordDiv").css('display', '');
		$('#memberList').css('display', 'none');
		$('#signOut').css('display', 'none');
		$('#phoneNumber').removeAttr("disabled");
		$('#phoneNumber').attr("required", "required");
		$('#revise').css('display', 'none');
		$('#register').css('display', '');
	}
	$('#reviseButton').on("click",function(){
		var updateData = {};
		if ($('#name').val() === "" || $('#phoneNumber').val() === "" || $('#age').val() < 12 || $('#birthday').val() === "") {
			alert("請確認必填欄位是否為空!");
		} else if($('#phoneNumber').val() === $('#password').val()){
			alert("電話號碼與密碼不可相同!");
		} else {
			$('.inputData').each(function() {
				updateData[$(this).attr('id')] = $(this).val();
			});
			$(".form-select option:selected").each(function() {
				if ($(this).val() === "cityDefault" || $(this).val() === "districtDefault"
					|| $(this).val() === "roadDefault") {
					updateData[$(this).parent().attr('id')] = "";
				} else if ($(this).val() === "女") {
					updateData[$(this).parent().attr('id')] = "F";
				} else if ($(this).val() === "男") {
					updateData[$(this).parent().attr('id')] = "M";
				} else {
					updateData[$(this).parent().attr('id')] = $(this).val();
				}
			})
			updateData[$('#birthday').attr('id')] = $('#birthday').val();
			updateData["update_time"] = (new Date().format("yyyy-MM-dd hh:mm:ss"));
			updateData["create_time"] = '${member.create_time}';
			updateData["password"] = '${member.password}';
			$.ajax({
				url: webApplicationPath + "/MemberServlet?method=updateMember",
				type: "POST",
				data: updateData,
				dataType: "json",
				contentType: "application/x-www-form-urlencoded;charset=utf-8",
				success: function(response) {
					console.log(response)
					if (response.result) {
						alert("更新成功!");
						window.location.reload();
					} else {
						alert(response.msg);
					}
				},
				error: function(jqXHR, textStatus, errorThrown) {
					alert("失敗");
					/*弹出jqXHR对象的信息*/
					console.log(jqXHR.responseText);
					console.log(jqXHR.status);
					console.log(jqXHR.readyState);
					console.log(jqXHR.statusText);
					/*弹出其他两个参数的信息*/
					console.log(textStatus);
					console.log(errorThrown);
				}
			});

			
		}
	})
});
</script>
</html>