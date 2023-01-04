function padTo2Digits(num) {
  return num.toString().padStart(2, '0');
}
function formatDate(date) {
  return (
    [
      date.getFullYear(),
      padTo2Digits(date.getMonth() + 1),
      padTo2Digits(date.getDate()),
    ].join('-') +
    ' ' +
    [
      padTo2Digits(date.getHours()),
      padTo2Digits(date.getMinutes()),
      padTo2Digits(date.getSeconds()),
    ].join(':')
  );
}
$(document).ready(function() {
	$('#searchButton').on("click", function() {
		var searchData = {};
		searchData[$("#order_id").attr('id')] = $("#order_id").val();
		console.log(searchData);
		$.ajax({
			url: webApplicationPath + "/MemberServlet?method=orderSearch",
			type: "POST",
			data: searchData,
			dataType: "json",
			contentType: "application/x-www-form-urlencoded;charset=utf-8",
			success: function(response) {
				if (response.result) {
					alert("查詢完成");
					let resData = response.data;
					let rootTag = $('#order_tbody');
					rootTag.empty();
					resData.forEach(data => {
						let temp = `
										<tr class="cart_item">
											<td class="product-thumbnail orderId"><a href="#"><p>${data.orderId}</p></a></td>
											<td ><p class="createdTime" name="${data.createdTime}">${data.createdTime}</p></td>
											<td class="orderStatus"><p>${data.orderStatus}</p></td>
											<td class="orderAmount"><p>$${data.orderAmount}</p></td>
											<td class="shippingType"><p>${data.shippingType}</p></td>
											<td class="paymentType"><p>${data.paymentType}</p></td>
										</tr>
									`;
						
						rootTag.append(temp);
					});
				} else {
					alert(response.msg);
				}
				$('.createdTime').each(function(){
					$('.createdTime').text(formatDate(new Date($(this).attr('name'))));
				})
			},
			error: function(jqXHR, textStatus, errorThrown) {
				alert("失敗" + searchData);
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
	})
	

});