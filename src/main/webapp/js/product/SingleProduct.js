window.onload = function() {
	function getQueryVariable(variable) {
		var query = window.location.search.substring(1);
		var vars = query.split("&");
		for (var i = 0; i < vars.length; i++) {
			var pair = vars[i].split("=");
			if (pair[0] == variable) { return pair[1]; }
		}
		return (false);
	}

	var id = getQueryVariable("id");


	var settings = {
		"url": "/life4fun/ProductServlet?method=getbyId&id=" + id,
		"method": "POST",
		"timeout": 0,

	};
	$.ajax(settings).done(function(e) {
		bestSaleList = JSON.parse(JSON.stringify(e));
		//console.log(bestSaleList);
		$.each(JSON.parse(e), (index, product) => {
			$('#singlePage').append(`
				 <div class="col-md-6 product-slider mb-50">

            <div class="flickity flickity-slider-wrap mfp-hover" id="gallery-main">

              <div class="gallery-cell">
                <a href="/life4fun/img/life4fun/${product.photoUrl1}" class="lightbox-img">
                  <img src="/life4fun/img/life4fun/${product.photoUrl1}" alt="">
                </a>
              </div>
              <div class="gallery-cell">
                <a href="/life4fun/img/life4fun/${product.photoUrl2}" class="lightbox-img">
                  <img src="/life4fun/img/life4fun/${product.photoUrl2}" alt="">
                </a>
              </div>
              <div class="gallery-cell">
                <a href="/life4fun/img/life4fun/${product.photoUrl3}" class="lightbox-img">
                  <img src="/life4fun/img/life4fun/${product.photoUrl3}" alt="">
                </a>
              </div>
              
              
            </div> <!-- end gallery main -->

            <div class="gallery-thumbs" id="gallery-thumbs">
              <div class="gallery-cell">
                <img src="/life4fun/img/life4fun/${product.photoUrl1}" alt="">
              </div>
              <div class="gallery-cell">
                <img src="/life4fun/img/life4fun/${product.photoUrl2}" alt="">
              </div>
              <div class="gallery-cell">
                <img src="/life4fun/img/life4fun/${product.photoUrl3}" alt="">
              </div>
            
            </div> <!-- end gallery thumbs -->

          </div> <!-- end col img slider -->

          <div class="col-md-6 product-single">
            <h1 class="product-single__title uppercase">${product.productName}</h1>


            <span class="product-single__price">
              <ins>
                <span class="amount">NT ${product.price}</span>
              </ins>
             
            </span>            

            <div class="colors clearfix">
              <span class="colors__label">顏色: <span class="colors__label-selected">${product.color}</span></span>
              
            </div>

            <div class="size-quantity clearfix">
              <div class="size">
                <label>Size</label>
                <select name="size" id="size__select" class="size__select">
                  <option value="xs">${product.size}</option>
                  
                </select>
              </div>
              
              <div class="quantity">
                <label>Quantity</label>                 
                <select name="quantity" id="quantity__select" class="quantity__select">
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                  <option value="4">4</option>
                  <option value="5">5</option>
                </select>
              </div>
            </div>            

            <div class="row row-10 product-single__actions clearfix">
              <div class="col">
                <a href="#" class="btn btn-lg btn-color product-single__add-to-cart">
                  <i class="ui-bag"></i>
                  <span>Add to Cart</span>
                </a>
              </div>
              <div class="col">
                <a href="#" class="btn btn-lg btn-dark product-single__add-to-wishlist">
                  <i class="ui-heart"></i>
                  <span>Wishlist</span>
                </a>
              </div>
            </div>            

            <div class="product_meta">
              <ul>
                <li>
                  <span class="product-code">庫存: <span>${product.stock}</span></span>
                </li>
              
              </ul>                              
            </div>

            <!-- Accordion -->
            <div class="accordion mb-50" id="accordion">
              <div class="accordion__panel">
                <div class="accordion__heading" id="headingOne">
                  <a data-toggle="collapse" href="#collapseOne" class="accordion__link accordion--is-open" aria-expanded="true" aria-controls="collapseOne">產品描述<span class="accordion__toggle">&nbsp;</span>
                  </a>
                </div>
                <div id="collapseOne" class="collapse show" data-parent="#accordion" role="tabpanel" aria-labelledby="headingOne">
                  <div class="accordion__body">
						${product.description}                  
				</div>
                </div>
              </div>

              <div class="accordion__panel">
                <div class="accordion__heading" id="headingTwo">
                  <a data-toggle="collapse" href="#collapseTwo" class="accordion__link accordion--is-closed" aria-expanded="false" aria-controls="collapseTwo">資訊<span class="accordion__toggle">&nbsp;</span>
                  </a>
                </div>
                <div id="collapseTwo" class="collapse" data-parent="#accordion" role="tabpanel" aria-labelledby="headingTwo">
                  <div class="accordion__body">
                    <table class="table shop_attributes">
                      <tbody>
                        <tr>
                          <th>Size:</th>
                          <td>${product.size}  </td>
                        </tr>
                        <tr>
                          <th>Colors:</th>
                          <td>${product.color}</td>
                        </tr>
                                                           
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>

              
                  </div>
                </div>
              </div>
            </div> <!-- end accordion -->

          </div> <!-- end col product description -->
				
				
				`)

			$('#ol').append(`
					<li>
            <a href="index.html">life4fun</a>
          </li>
          <li>
            <a href="index.html">${product.productCatalog}</a>
          </li>
          <li class="active">
            ${product.productName}
          </li>
					
					`)

		})



	})
	

{
var settingsArrivals = {
		"url":  "/life4fun/ProductServlet?method=getNewArrProducts",
		"method": "POST",
		"timeout": 0,

	};
		$.ajax(settingsArrivals).done(function(e) {
		bestSaleList = JSON.parse(JSON.stringify(e));
		console.log(bestSaleList);
		$.each(JSON.parse(e),(index,product) => {
			console.log(product.productName);

			$('#theLook').append(`   <div class="col-lg-2 col-sm-4 product">
            <div class="product__img-holder">
              <a href="" class="product__link">
                <img src="/life4fun/img/life4fun/${product.photoUrl1}" alt="" class="product__img"  width="200" height="200">
                
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
                <a href="">${product.productName}</a>
              </h3>
            </div>

            <span class="product__price">
              <ins>
                <span class="amount">NT ${product.price}</span>
              </ins>
            </span>
          </div> <!-- end product -->

           `)



		})

	})
	
}	
	
	
}

