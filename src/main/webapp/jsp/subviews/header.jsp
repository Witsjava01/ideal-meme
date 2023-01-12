<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <input type="search" class="sidenav__search-mobile-input" placeholder="Search...">
        <button type="submit" class="sidenav__search-mobile-submit">
          <i class="ui-search"></i>
        </button>
      </form>
    </div>

    <nav>
      <ul class="sidenav__menu">
        <li>
          <a href="#" class="sidenav__menu-link">飾品</a>
          <button class="sidenav__menu-toggle"><i class="ui-arrow-down"></i></button>
          <ul class="sidenav__menu-dropdown">
            <li><a href="#" class="sidenav__menu-link">T-shirt</a></li>
            <li><a href="#" class="sidenav__menu-link">Hoodie &amp; Jackets</a></li>
            <li><a href="#" class="sidenav__menu-link">Suits</a></li>
            <li><a href="#" class="sidenav__menu-link">Shorts</a></li>
          </ul>
        </li>
      
        <li>
          <a href="#" class="sidenav__menu-link">居家小物</a>
          <button class="sidenav__menu-toggle"><i class="ui-arrow-down"></i></button>
          <ul class="sidenav__menu-dropdown">
            <li><a href="#" class="sidenav__menu-link">Underwear</a></li>
            <li><a href="#" class="sidenav__menu-link">Hipster</a></li>
            <li><a href="#" class="sidenav__menu-link">Dress</a></li>
            <li><a href="#" class="sidenav__menu-link">Hoodie &amp; Jackets</a></li>
            <li><a href="#" class="sidenav__menu-link">Tees</a></li>
          </ul>
        </li>
        
        <li>
          <a href="#" class="sidenav__menu-link">美妝保養</a>
          <button class="sidenav__menu-toggle"><i class="ui-arrow-down"></i></button>
          <ul class="sidenav__menu-dropdown">
            <li>
              <a href="#" class="sidenav__menu-link">All accessories</a>
              <button class="sidenav__menu-toggle"><i class="ui-arrow-down"></i></button>
              <ul class="sidenav__menu-dropdown">
                <li>
                  <a href="#" class="sidenav__menu-link">Wallets</a>
                </li>
                <li>
                  <a href="#" class="sidenav__menu-link">Scarfs</a>
                </li>
                <li>
                  <a href="#" class="sidenav__menu-link">Shirt</a>
                </li>
                <li>
                  <a href="#" class="sidenav__menu-link">Shoes</a>
                </li>
              </ul>
            </li>
            
            <li>
              <a href="#" class="sidenav__menu-link">for her</a>
              <button class="sidenav__menu-toggle"><i class="ui-arrow-down"></i></button>
              <ul class="sidenav__menu-dropdown">
                <li>
                  <a href="#" class="sidenav__menu-link">Underwear</a>
                </li>
                <li>
                  <a href="#" class="sidenav__menu-link">Hipster</a>
                </li>
                <li>
                  <a href="#" class="sidenav__menu-link">Dress</a>
                </li>
                <li>
                  <a href="#" class="sidenav__menu-link">Hoodie &amp; Jackets</a>
                </li>
                <li>
                  <a href="#" class="sidenav__menu-link">Tees</a>
                </li>
              </ul>
            </li>

            <li>
              <a href="#" class="sidenav__menu-link">for him</a>
              <button class="sidenav__menu-toggle"><i class="ui-arrow-down"></i></button>
              <ul class="sidenav__menu-dropdown">
                <li>
                  <a href="#" class="sidenav__menu-link">T-shirt</a>
                </li>
                <li>
                  <a href="#" class="sidenav__menu-link">Hoodie &amp; Jackets</a>
                </li>
                <li>
                  <a href="#" class="sidenav__menu-link">Dress</a>
                </li>
                <li>
                  <a href="#" class="sidenav__menu-link">Suits</a>
                </li>
                <li>
                  <a href="#" class="sidenav__menu-link">Shorts</a>
                </li>
              </ul>
            </li>

            <li>
              <a href="#" class="sidenav__menu-link">Watches</a>
              <button class="sidenav__menu-toggle"><i class="ui-arrow-down"></i></button>
              <ul class="sidenav__menu-dropdown">
                <li>
                  <a href="#" class="sidenav__menu-link">Smart Watches</a>
                </li>
                <li>
                  <a href="#" class="sidenav__menu-link">Diving Watches</a>
                </li>
                <li>
                  <a href="#" class="sidenav__menu-link">Sport Watches</a>
                </li>
                <li>
                  <a href="#" class="sidenav__menu-link">Classic Watches</a>
                </li>
              </ul>
            </li>
            
          </ul>
        </li>
        
        <li>
          <a href="#" class="sidenav__menu-link">男士保養</a>
          <button class="sidenav__menu-toggle"><i class="ui-arrow-down"></i></button>
          <ul class="sidenav__menu-dropdown">
            <li><a href="blog-standard.html" class="sidenav__menu-link">Blog Standard</a></li>
            <li><a href="blog-single.html" class="sidenav__menu-link">Single Post</a></li>
          </ul>
        </li>

        <li>
          <a href="#" class="sidenav__menu-link">其他</a>
          <button class="sidenav__menu-toggle"><i class="ui-arrow-down"></i></button>
          <ul class="sidenav__menu-dropdown">
            <li><a href="catalog.html" class="sidenav__menu-link">Catalog</a></li>
            <li><a href="single-product.html" class="sidenav__menu-link">Single Product</a></li>
            <li><a href="" class="sidenav__menu-link">Cart</a></li>
            <li><a href="checkout.html" class="sidenav__menu-link">Checkout</a></li>
            <li><a href="about.html" class="sidenav__menu-link">About</a></li>
            <li><a href="contact.html" class="sidenav__menu-link">Contact</a></li>
            <li><a href="login.html" class="sidenav__menu-link">Login</a></li>
            <li><a href="faq.html" class="sidenav__menu-link">FAQ</a></li>
            <li><a href="404.html" class="sidenav__menu-link">404</a></li>
          </ul>
        </li>

        <li>
          <a href="#" class="sidenav__menu-link">登入</a>
        </li>
      </ul>
    </nav>
  </header> <!-- end mobile sidenav -->



    <!-- Navigation -->
    <header class="nav">

      <div class="nav__holder nav--sticky">
        <div class="container relative">

          <!-- Top Bar -->
          <div class="top-bar d-none d-lg-flex">

            <!-- Currency / Language -->
            <ul class="top-bar__currency-language">
              <li class="top-bar__language">
                <a href="#"></a>
                <div class="top-bar__language-dropdown">
                  <ul>
                    <li><a href="#">English</a></li>
                    <li><a href="#">Spanish</a></li>
                    <li><a href="#">German</a></li>
                    <li><a href="#">Chinese</a></li>
                  </ul>
                </div>
              </li>
              <li class="top-bar__currency">
                <a href="#"></a>
                <div class="top-bar__currency-dropdown">
                  <ul>
                    <li><a href="#">USD</a></li>
                    <li><a href="#">EUR</a></li>
                  </ul>
                </div>
              </li>              
            </ul>

            <!-- Promo -->
            <p class="top-bar__promo text-center"></p>

            <!-- Sign in / Wishlist / Cart -->
            <div class="top-bar__right">

              <!-- Sign In -->
              <a href="login.html" class="top-bar__item top-bar__sign-in" id="top-bar__sign-in">
              <i class="ui-user"></i><a href="../member/login.jsp" id="SignIn_A">登入</a></a>

              <!-- Wishlist -->
              <a href="#" class="top-bar__item"><i class="ui-heart"></i></a>

              <div class="top-bar__item nav-cart">                
                <a href="">
                  <a href="../cart/cart.jsp" id="Cart"><i class="ui-bag"></i></a><c:out value="${cartItemCount}"></c:out>
                </a>
                <div class="nav-cart__dropdown">
                  <div class="nav-cart__items">
					<c:forEach items="${cartItemList}" var="item" >
                    <div class="nav-cart__item clearfix">
                      <div class="nav-cart__img">
                        <a href="#">
                          <img src="static/picture/${item[p].photoUrl1}" alt="">
                        </a>
                      </div>
                      <div class="nav-cart__title">
                        <a href="#">
                        
                        </a>
                        <div class="nav-cart__price">
                          <span><c:out value="${item.quantity}"></c:out> x</span>
                          <span><c:out value="${item[p].price}"></c:out></span>
                        </div>
                      </div>
                      <div class="nav-cart__remove">
                        <a href="#"><i class="ui-close"></i></a>
                      </div>
                    </div>
					</c:forEach>
                    

                  </div> <!-- end cart items -->

                  <div class="nav-cart__summary">
                    <span>Cart Subtotal</span>
                    <span class="nav-cart__total-price">$1799.00</span>
                  </div>

                  <div class="nav-cart__actions mt-20">
                    <a href="javascript:;" class="btn btn-md btn-light"><span>查看購物車</span></a>
                    <a href="javascript:;" class="btn btn-md btn-color mt-10"><span>進入結帳</span></a>
                  </div>
                </div>
              </div>
            </div>

          </div> <!-- end top bar -->

          <div class="flex-parent">

            <!-- Mobile Menu Button -->
            <button class="nav-icon-toggle" id="nav-icon-toggle">
              <span class="nav-icon-toggle__box">
                <span class="nav-icon-toggle__inner"></span>
              </span>
            </button> <!-- end mobile menu button -->

            <!-- Logo -->
            <a href="index.html" class="logo">
              <img class="logo__img" src="/life4fun/static/picture/logo_life4fun.png" alt="logo">
            </a>

            <!-- Nav-wrap -->
            <nav class="flex-child nav__wrap d-none d-lg-block">              
              <ul class="nav__menu">

                <li class="nav__dropdown active">
                  <a href="catalog.html">飾品</a>
                  <ul class="nav__dropdown-menu">
                    <li><a href="#">T-shirt</a></li>
                    <li><a href="#">Hoodie &amp; Jackets</a></li>
                    <li><a href="#">Suits</a></li>
                    <li><a href="#">Shorts</a></li>
                  </ul>
                </li>

                <li class="nav__dropdown">
                  <a href="catalog.html">居家小物</a>
                  <ul class="nav__dropdown-menu">
                    <li><a href="#">Underwear</a></li>
                    <li><a href="#">Hipster</a></li>
                    <li><a href="#">Dress</a></li>
                    <li><a href="#">Hoodie &amp; Jackets</a></li>
                    <li><a href="#">Tees</a></li>
                  </ul>
                </li>

                <li class="nav__dropdown">
                  <a href="catalog.html">美妝保養</a>
                  <ul class="nav__dropdown-menu nav__megamenu">
                    <li>
                      <div class="nav__megamenu-wrap">
                        <div class="row">

                          <div class="col nav__megamenu-item">
                            <a href="#" class="nav__megamenu-title">美妝保養</a>
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
                            <a href="#"><img src="static/picture/megamenu_banner.png" alt=""></a>
                          </div>

                        </div>
                      </div>
                    </li>
                  </ul>
                </li>

                <li class="nav__dropdown">
                  <a href="#">男士保養</a>
                  <ul class="nav__dropdown-menu">
                    <li><a href="blog-standard.html">Blog Standard</a></li>
                    <li><a href="blog-single.html">Single Post</a></li>
                  </ul>
                </li>
                
                <li class="nav__dropdown">
                  <a href="contact.html">其他</a>
                  <ul class="nav__dropdown-menu">
                    <li><a href="catalog.html">Catalog</a></li>
                    <li><a href="single-product.html">Single Product</a></li>
                    <li><a href="">Cart</a></li>
                    <li><a href="checkout.html">Checkout</a></li>
                    <li><a href="about.html">About</a></li>
                    <li><a href="contact.html">Contact</a></li>
                    <li><a href="faq.html">FAQ</a></li>
                    <li><a href="404.html">404</a></li>
                  </ul>
                </li>

              </ul> <!-- end menu -->

            </nav> <!-- end nav-wrap -->


            <!-- Search -->
            <div class="flex-child nav__search d-none d-lg-block">
              <form method="get" class="nav__search-form">
                <input type="search" class="nav__search-input" placeholder="查詢">
                <button type="submit" class="nav__search-submit">
                  <i class="ui-search"></i>
                </button>
              </form>
            </div>


            <!-- Mobile Wishlist -->
            <a href="#" class="nav__mobile-wishlist d-lg-none">
              <i class="ui-heart"></i>
            </a>

            <!-- Mobile Cart -->
            <a href="" class="nav__mobile-cart d-lg-none">
              <i class="ui-bag"></i>
              <span class="nav__mobile-cart-amount"></span>
            </a>

            
         
        
          </div> <!-- end flex-parent -->
        </div> <!-- end container -->

      </div>
    </header> <!-- end navigation -->
