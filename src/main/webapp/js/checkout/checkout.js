	$(document).ready(function(){
		var webApplicationPath = "${webApplicationPath}";
		$("#place_order").on("click", function() {
		  	alert("place_order");		  
		  
		  	var inputData = {};
			$('.inputData').each(function() {
				inputData[$(this).attr('name')] = $(this).val();
			});
			console.log(inputData);
			
		  	$.ajax({
				url: webApplicationPath + "/OrderServlet?method=orderSearch",
				type: "POST",
				data: inputData,
				dataType: "json",
				contentType: "application/x-www-form-urlencoded;charset=utf-8",
				success: function(response) {
					console.log(response)
					if (response.result) {
						alert("註冊成功!");
						window.location.assign(webApplicationPath + "/OrderServlet?method=order");
					} else {
						alert(response.msg);
					}
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
	});