$(document).ready(function() {
	$('#register').on("click", function() {
		window.location.assign(webApplicationPath + "/MemberServlet?method=register");
	});
	$('#loginButton').on("click", function() {
		var inputData = {};
		if ($('input[id="account"]').val() === "" || $('input[id="password"]').val() === "" ||
			$('input[id="account"]').val() === null || $('input[id="password"]').val() === null) {
			alert('請輸入帳號密碼!')
			return false;
		} else {
			$('input[class="input-text"]').each(function() {
				inputData[$(this).attr('id')] = $(this).val();
			});
			$.ajax({
				url: webApplicationPath + "/MemberServlet?method=findMember",
				type: "POST",
				data: inputData,
				dataType: "json",
				contentType: "application/x-www-form-urlencoded;charset=utf-8",
				success: function(response) {
					if (response.result) {
						console.log(response);
						alert("登入成功");
						$("#SignIn_A").text("會員中心");
						window.location.assign(webApplicationPath + "/MemberServlet?method=member");
					} else {
						alert(response.msg);
					}
				},
				error: function(jqXHR, textStatus, errorThrown) {
					alert("失敗");
					console.log("response:" + response);
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
		}

	});


});