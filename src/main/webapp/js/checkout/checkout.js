	$(document).ready(function(){

		$("#place_order").on("click", function() {
		  	alert("place_order");		  
		  	//window.location.assign(webApplicationPath + "/jsp/product/index.jsp");
		  	location.href='../order/order.jsp';
		}); 
		
	});