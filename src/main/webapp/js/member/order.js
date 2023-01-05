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
	$('.orderId').click(function() {
		var orderIdData = {};
		orderIdData["orderId"]=$(this).text().replace(/\s+/g,'');
		console.log(orderIdData)
		$.ajax({
			url: webApplicationPath + "/MemberServlet?method=findOrderDetails",
			type: "POST",
			data: orderIdData,
			dataType: "json",
			contentType: "application/x-www-form-urlencoded;charset=utf-8",
			success: function() {
				console.log("成功")
				window.location.assign(webApplicationPath + "/MemberServlet?method=showOrderDetails");
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
		
	});
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
											<td class="product-thumbnail"><a class="orderId" id="${data.orderId}" style="color:black;" href="">${data.orderId}</a></td>
											<td ><p class="createdTime" name="${data.createdTime}">${data.createdTime}</p></td>
											<td><p class="orderStatus">${data.orderStatus}</p></td>
											<td><p class="orderAmount">$${data.orderAmount}</p></td>
											<td><p class="shippingType">${data.shippingType}</p></td>
											<td><p class="paymentType">${data.paymentType}</p></td>
										</tr>
									`;

						rootTag.append(temp);
					});
				} else {
					alert(response.msg);
				}
				$('.createdTime').each(function() {
					$('.createdTime').text(formatDate(new Date($(this).attr('name'))));
				})
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
	})


});