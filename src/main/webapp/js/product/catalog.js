window.onload = function() {
	{

		var settings = {
			"url": webApplicationPath + "/ProductServlet?method=getAllProducts",
			"method": "POST",
			"timeout": 0,

		};
		$.ajax(settings).done(function(e) {
			bestSaleList = JSON.parse(JSON.stringify(e));
			//console.log(bestSaleList);
			var count = 1;
			$.each(JSON.parse(e), (index, product) => {
				//console.log(product.productName);
				if (product.productCatalog == "Accessories") {

					if (count % 4 == 0) {
						$('#catalogProduct').append(`<div class=" col-sm-3 product">
                <div class="product__img-holder">
                  <a href="${webApplicationPath}/jsp/product/SingleProduct.jsp?id=${product.productId}"  >
                <img src="${webApplicationPath}/img/life4fun/${product.photoUrl1}" alt="" class="product__img" width="200" height="200" onclick="ToSinglePage(${product.productId})">
                
                  </a>
                  <div class="product__actions">
                    <a href="quickview.html" class="product__quickview">
                      <i class="ui-eye"></i>
                      <span>Quick View</span>
                    </a>
                    <a href="#" class="product__add-to-wishlist">
                      <i class="ui-heart"></i>
                      <span>Wishlist</span>
                    </a>
                  </div>
                </div>

                <div class="product__details">
                  <h3 class="product__title">
                    <a href="${webApplicationPath}/jsp/product/SingleProduct.jsp?id=${product.productId}">${product.productName} </a>
                  </h3>
                </div>

                <span class="product__price">
                  <ins>
                    <span class="amount">NT ${product.price}</span>
                  </ins>
                </span>
              </div>
              <div class="w-100"></div> `)
					} else {
						$('#catalogProduct').append(`  <div class=" col-sm-3 product">
                <div class="product__img-holder">
                  <a href="${webApplicationPath}/jsp/product/SingleProduct.jsp?id=${product.productId}"  >
                <img src="${webApplicationPath}/img/life4fun/${product.photoUrl1}" alt="" class="product__img" width="200" height="200">
                
                  </a>
                  <div class="product__actions">
                    <a href="quickview.html" class="product__quickview">
                      <i class="ui-eye"></i>
                      <span>Quick View</span>
                    </a>
                    <a href="#" class="product__add-to-wishlist">
                      <i class="ui-heart"></i>
                      <span>Wishlist</span>
                    </a>
                  </div>
                </div>

                <div class="product__details">
                  <h3 class="product__title">
                    <a href="${webApplicationPath}/jsp/product/SingleProduct.jsp?id=${product.productId}">${product.productName}</a>
                  </h3>
                </div>

                <span class="product__price">
                  <ins>
                    <span class="amount">NT${product.price}</span>
                  </ins>
                </span>
              </div>`)

					}

				}

				count++;
			})

		})
	}


};
function report(value) {
	
	
	switch(value){
		case "price-high-to-low":
		var settings = {
		"url": webApplicationPath + "/ProductServlet?method=getPriceHightoLow",
		"method": "POST",
		"timeout": 0,
		};
		break;
		
		case "price-low-to-high":
		var settings = {
		"url": webApplicationPath + "/ProductServlet?method=getPriceLowtoHigh",
		"method": "POST",
		"timeout": 0,
		};
		break;
		
		case "default-sorting":
		var settings = {
		"url": webApplicationPath + "/ProductServlet?method=getAllProducts",
		"method": "POST",
		"timeout": 0,
		};
		break;
		
		
		case "date":
		var settings = {
		"url": webApplicationPath + "/ProductServlet?method=getnewOnshelf",
		"method": "POST",
		"timeout": 0,
		};
		break;
		
		case "stock":
		var settings = {
		"url": webApplicationPath + "/ProductServlet?method=getStock",
		"method": "POST",
		"timeout": 0,
		};
		break;
	}
	
	$('#catalogProduct').empty();

	$.ajax(settings).done(function(e) {
		bestSaleList = JSON.parse(JSON.stringify(e));
	
		
		$.each(JSON.parse(e), (index, product) => {

			if (product.productCatalog == "Accessories") {

				var count = 1;

				if (count % 4 == 0) {
					$('#catalogProduct').append(`<div class=" col-sm-3 product">
                <div class="product__img-holder">
                  <a href="${webApplicationPath}/jsp/product/SingleProduct.jsp?id=${product.productId}"  >
                <img src="${webApplicationPath}/img/life4fun/${product.photoUrl1}" alt="" class="product__img" width="200" height="200">
                
                  </a>
                  <div class="product__actions">
                    <a href="quickview.html" class="product__quickview">
                      <i class="ui-eye"></i>
                      <span>Quick View</span>
                    </a>
                    <a href="#" class="product__add-to-wishlist">
                      <i class="ui-heart"></i>
                      <span>Wishlist</span>
                    </a>
                  </div>
                </div>

                <div class="product__details">
                  <h3 class="product__title">
                    <a href="${webApplicationPath}/jsp/product/SingleProduct.jsp?id=${product.productId}">${product.productName}</a>
                  </h3>
                </div>

                <span class="product__price">
                  <ins>
                    <span class="amount">NT ${product.price}</span>
                  </ins>
                </span>
              </div>
              <div class="w-100"></div> `)
				} else {
					$('#catalogProduct').append(`  <div class=" col-sm-3 product">
                <div class="product__img-holder">
                  <a href="${webApplicationPath}/jsp/product/SingleProduct.jsp?id=${product.productId}"  >
                <img src="${webApplicationPath}/img/life4fun/${product.photoUrl1}" alt="" class="product__img" width="200" height="200">
                
                  </a>
                  <div class="product__actions">
                    <a href="quickview.html" class="product__quickview">
                      <i class="ui-eye"></i>
                      <span>Quick View</span>
                    </a>
                    <a href="#" class="product__add-to-wishlist">
                      <i class="ui-heart"></i>
                      <span>Wishlist</span>
                    </a>
                  </div>
                </div>

                <div class="product__details">
                  <h3 class="product__title">
                    <a href="${webApplicationPath}/jsp/product/SingleProduct.jsp?id=${product.productId}">${product.productName}</a>
                  </h3>
                </div>

                <span class="product__price">
                  <ins>
                    <span class="amount">NT${product.price}</span>
                  </ins>
                </span>
              </div>`)

				}

			}

			count++;
		})
	
	})

}



