	$(document).ready(function(){

		$("#place_order").on("click", function() {
		  	alert("place_order");		  
		  	$.ajax({
				url: "/life4fun/CheckOutServlet?method=sendOrder",
				method: "POST",
				data: {
					"productId":productId,
					"quantity":quantity
				},
				success: function(response) {
					console.log(response)
					alert("完成訂單");
				},
				error: function(jqXHR, textStatus, errorThrown) {
					alert("失敗");
				}
			});
		});
	});