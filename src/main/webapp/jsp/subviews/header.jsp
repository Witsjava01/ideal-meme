<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
						<a href="login.html" class="top-bar__item top-bar__sign-in"
							id="top-bar__sign-in"> 
						<i class="ui-user"></i>
						<a href="${webApplicationPath}/MemberServlet?method=login"
							id="SignIn_A">Sign In</a></a>


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