$(document).ready(function() {
	$('#signOutButton').on("click", function() {
		window.location.assign(webApplicationPath + "/LoginServlet");
	});
	$('#reviseButton').on("click",function(){
		
		if($('#password').val()==="" || $('#newPassword').val() ===""){
			alert("新密碼與舊密碼不能為空!")
		}else if($('#password').val() === $('#newPassword').val()){
			alert("新密碼與舊密碼不可相同!")
		}else{
			var passwordData = {};
			$('.inputData').each(function(){
				passwordData[$(this).attr('id')] = $(this).val();
			})
			$.ajax({
				url: webApplicationPath + "/LoginServlet?method=updatePassword",
				type: "POST",
				data: passwordData,
				dataType: "json",
				contentType: "application/x-www-form-urlencoded;charset=utf-8",
				success: function(response) {
					console.log(response)
					if (response.result) {
						alert("更新密碼成功!");
						window.location.reload();
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
		}
	})
});