<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page isELIgnored="false"%>
<!--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">

<title>Live4Fun | 會員訂單明細</title>

<script>
	var webApplicationPath = "${webApplicationPath}";
</script>

<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script src="${webApplicationPath}/${JS_SOURCE}/orderDetails.js"></script>
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
					<li><a href="#" class="sidenav__menu-link">All accessories</a>
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
							<li><a href="#" class="sidenav__menu-link">Smart Watches</a>
							</li>
							<li><a href="#" class="sidenav__menu-link">Diving
									Watches</a></li>
							<li><a href="#" class="sidenav__menu-link">Sport Watches</a>
							</li>
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
					<li><a href="catalog.html" class="sidenav__menu-link">Catalog</a></li>
					<li><a href="single-product.html" class="sidenav__menu-link">Single
							Product</a></li>
					<li><a href="" class="sidenav__menu-link">Cart</a></li>
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




					<!-- Sign in / Wishlist / Cart -->
					<div class="top-bar__right">

						<!-- Sign In -->
							<a href="login.html" class="top-bar__item top-bar__sign-in" id="top-bar__sign-in">
							<i class="ui-user"></i><a href="${webApplicationPath}/MemberServlet?method=member" id="SignIn_A">會員中心</a></a>


						<div class="top-bar__item nav-cart">
							<a href="${webApplicationPath}/CartServlet?method=showCart"> <i class="ui-bag"></i>(2)
							</a>
						</div>
					</div>

				</div>
				<!-- end top bar -->

				<div class="flex-parent">

					<!-- Mobile Menu Button -->
					<button class="nav-icon-toggle" id="nav-icon-toggle"
						aria-label="Open mobile menu">
						<span class="nav-icon-toggle__box"> <span
							class="nav-icon-toggle__inner"></span>
						</span>
					</button>
					<!-- end mobile menu button -->

					<!-- Logo -->
					<a href="${webApplicationPath}/jsp/product/index.jsp" class="logo">
						<img class="logo__img"
						src="${webApplicationPath}/static/picture/logo_life4fun.png"
						alt="logo" width="100" height="300">

					</a>


					<!-- Nav-wrap -->
					<nav class="flex-child nav__wrap d-none d-lg-block">
						<ul class="nav__menu">

							<li class="nav__dropdown active"><a
								href="${webApplicationPath}/jsp/product/catalog.jsp?catalog=A">飾品</a>

							</li>

							<li class="nav__dropdown"><a
								href="${webApplicationPath}/jsp/product/catalog.jsp?catalog=H">居家小物</a>

							</li>

							<li class="nav__dropdown"><a href="catalog.html">美妝保養</a></li>

							<li class="nav__dropdown"><a href="#">男士保養</a></li>

							<li class="nav__dropdown"><a href="contact.html">其他</a></li>

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
					<a href="#" class="nav__mobile-wishlist d-lg-none"
						aria-label="Mobile wishlist"> <i class="ui-heart"></i>
					</a>

					<!-- Mobile Cart -->
					<a href="${webApplicationPath}/CartServlet?method=showCart"
						class="nav__mobile-cart d-lg-none"> 
						<i class="ui-bag"></i> 
						<span class="nav__mobile-cart-amount"></span>
					</a>
				</div>
				<!-- end flex-parent -->
			</div>
			<!-- end container -->

		</div>

	</header>
	<!-- end navigation -->


	<main class="main oh" id="main">

		<!-- Catalog -->
		<section class="section-wrap pt-60 pb-30 catalog">
			<div class="container">

				<!-- Breadcrumbs -->

				<div class="row">
					<div class="col-lg-9 order-lg-2 mb-40">

						<!-- Filter -->
						<section class="">
							<div class="container">
								<h1 class=" heading page-title__title" style="margin-bottom: 30px">訂單明細</h1>
								<div class="container relative">
									<div class="table-wrap ">
										<table class="table">
											<thead>
												<tr>
													<th class="">訂單編號</th>
													<th class="">訂購日期及時間</th>
													<th class="">訂單狀態</th>
													<th class="">訂單總金額</th>
													<th class="">取貨方式</th>
													<th class="">付款方式</th>
												</tr>
											</thead>
											<tbody id="order_tbody">
												<c:forEach var="order" items="${orderItem}">
													<tr class="orderItem">
														<td class="product-thumbnail">
															<p class="orderId">${order.orderId}</p>
														</td>
														<td>
															<p class="createdTime">
																<fmt:formatDate value="${order.createdTime}" pattern="yyyy-MM-dd HH:mm:ss" />
															</p>
														</td>
														<td class="orderStatus">
															<p>${order.orderStatus}</p>
														</td>
														<td class="orderAmount">
															<p>$${order.orderAmount}</p>
														</td>
														<td class="shippingType">
															<p>${order.shippingType}</p>
														</td>
														<td class="paymentType">
															<p>${order.paymentType}</p>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<div class="container">
								<h1 class=" heading page-title__title" style="margin-bottom: 30px">產品資訊</h1>
								<div class="container relative">
									<div class="table-wrap ">
										<table class="table">
											<thead>
												<tr>
													<th class="">產品名稱</th>
													<th class="">顏色</th>
													<th class="">尺寸</th>
													<th class="">單價</th>
													<th class="">數量</th>
												</tr>
											</thead>
											<tbody id="order_tbody">
												<c:forEach var="orderDetails" items="${orderDetailsItem}">
													<tr class="orderItem">
														<td>
															<p class="productName">${orderDetails.productName}</p>
														</td>
														<td>
															<p class="productColor">${orderDetails.productColor}</p>
														</td>
														<td>
															<p class="productSize">${orderDetails.productSize}</p>
														</td>
														<td>
															<p class="price">${orderDetails.price}</p>
														</td>
														<td>
															<p class="quantity">${orderDetails.quantity}</p>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<div class="container">
								<h1 class=" heading page-title__title" style="margin-bottom: 30px">收件人資訊</h1>
								<div class="container relative">
									<div class="table-wrap ">
										<table class="table">
											<thead>
												<tr>
													<th class="">姓名</th>
													<th class="">電話</th>
													<th class="">郵遞區號</th>
													<th class="">縣/市</th>
													<th class="">區域</th>
													<th class="">路/街</th>
													<th class="">地址</th>
												</tr>
											</thead>
											<tbody id="order_tbody">
												<c:forEach var="order" items="${orderItem}">
													<tr class="orderItem">
														<td>
															<p class="recipientName">${order.recipientName}</p>
														</td>
														<td>
															<p class="recipientPhoneNumber">${order.recipientPhoneNumber}</p>
														</td>
														<td>
															<p class="recipientPostalCode">${order.recipientPostalCode}</p>
														</td>
														<td>
															<p class="recipientCity">${order.recipientCity}</p>
														</td>
														<td>
															<p class="recipientDistrict">${order.recipientDistrict}</p>
														</td>
														<td>
															<p class="recipientRoad">${order.recipientRoad}</p>
														</td>
														<td>
															<p class="recipientAddress">${order.recipientAddress}</p>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</section>

						<div class="row row-6">

							<div class="col-md col-sm-6"></div>
						</div>
						<!-- end row -->
					</div>
					<!-- end col -->


					<!-- Sidebar -->
					<aside class="col-lg-3 sidebar left-sidebar">

						<!-- member -->
						<div class="widget widget_categories widget--bottom-line"
							id="memberList">
							<h4 class="widget-title">會員中心</h4>
							<ul>
								<li><a
									href="${webApplicationPath}/MemberServlet?method=member">個人資料</a></li>
								<li><a
									href="${webApplicationPath}/MemberServlet?method=password">修改密碼</a></li>
								<li style="color: orange"><a
									href="${webApplicationPath}/OrderServlet?method=order">訂單查詢</a></li>
							</ul>
						</div>
						<div id="signOut">
							<input type="submit" id="signOutButton" name="signOutButton"
								value="登出" class="btn btn-md btn-dark btn-button">
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
	
</script>
</html>