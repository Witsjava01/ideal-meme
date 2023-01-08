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
			$.each(JSON.parse(e), (index, product) => {
				//console.log(product.productName);

				$('#productView').append(` <div class="col-lg-2 col-sm-4 product">
                <div class="product__img-holder">
                <a href="${webApplicationPath}/jsp/product/SingleProduct.jsp?id=${product.productId}" class="product__link" aria-label="Product">
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




			})













		})
	}
{
var settingsArrivals = {
		"url": webApplicationPath + "/ProductServlet?method=getNewArrProducts",
		"method": "POST",
		"timeout": 0,

	};
		$.ajax(settingsArrivals).done(function(e) {
		bestSaleList = JSON.parse(JSON.stringify(e));
		console.log(bestSaleList);
		$.each(JSON.parse(e),(index,product) => {
			console.log(product.productName);

			$('#newArrivalsProduct').append(` <div class="col-lg-2 col-sm-4 product">
            <div class="product__img-holder">
              <a href="${webApplicationPath}/jsp/product/SingleProduct.jsp?id=${product.productId}" class="product__link" aria-label="Product">
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
          </div> `)



		})

	})
	
}

};