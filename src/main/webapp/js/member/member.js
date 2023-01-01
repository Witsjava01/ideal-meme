function calculateAge(birthday) {
	const age = new Date(Date.now()).getFullYear() - new Date(birthday.value).getFullYear();
	$('#age').val(age);
	if (age < 12) {
		$('#age_p').prop("hidden", "");
	} else {
		$('#age_p').prop("hidden", "hidden");
	}
}

function IsEmail(email) {
	var emailRule = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z]+$/;
	if (email.search(emailRule) != -1) {
		$("#eamil_p").prop("hidden", "hidden");
	} else {
		$("#eamil_p").prop("hidden", "");
	}
}
Date.prototype.format = function(format) {
	var args = {
		"M+": this.getMonth() + 1,
		"d+": this.getDate(),
		"h+": this.getHours(),
		"m+": this.getMinutes(),
		"s+": this.getSeconds(),
		"q+": Math.floor((this.getMonth() + 3) / 3),  //quarter
		"S": this.getMilliseconds()
	};
	if (/(y+)/.test(format))
		format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	for (var i in args) {
		var n = args[i];
		if (new RegExp("(" + i + ")").test(format))
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? n : ("00" + n).substr(("" + n).length));
	}
	return format;
};
$(document).ready(function() {
	
	$('#signOutButton').on("click", function() {
		window.location.assign(webApplicationPath + "/LoginServlet");
	});
	$('#loginButton').on("click", function() {
		window.location.assign(webApplicationPath + "/LoginServlet");
	});
	$('#registerButton').on("click", function() {
		if ($('#name').val() === "" || $('#phoneNumber').val() === "" || $('#password').val() === ""
			|| $('#age').val() < 12 || $('#birthday').val() === "") {
			alert("請確認必填欄位是否為空!");
		} else if($('#phoneNumber').val() === $('#password').val()){
			alert("電話號碼與密碼不可相同!");
		} else if($('#password').val().length < 6){
			alert("密碼長度必須為6~12位!");
		} else {
			var inputData = {};
			$('.inputData').each(function() {
				inputData[$(this).attr('id')] = $(this).val();
			});
			$(".form-select option:selected").each(function() {
				if ($(this).val() === "cityDefault" || $(this).val() === "districtDefault"
					|| $(this).val() === "roadDefault") {
					inputData[$(this).parent().attr('id')] = "";
				} else if ($(this).val() === "女") {
					inputData[$(this).parent().attr('id')] = "F";
				} else if ($(this).val() === "男") {
					inputData[$(this).parent().attr('id')] = "M";
				} else {
					inputData[$(this).parent().attr('id')] = $(this).val();
				}
			})
			inputData[$('#birthday').attr('id')] = $('#birthday').val();
			inputData["create_time"] = (new Date().format("yyyy-MM-dd hh:mm:ss"));
			inputData["update_time"] = (new Date().format("yyyy-MM-dd hh:mm:ss"));
			console.log(inputData);
			$.ajax({
				url: webApplicationPath + "/LoginServlet?method=addMember",
				type: "POST",
				data: inputData,
				dataType: "json",
				contentType: "application/x-www-form-urlencoded;charset=utf-8",
				success: function(response) {
					console.log(response)
					if (response.result) {
						alert("註冊成功!");
						window.location.assign(webApplicationPath + "/LoginServlet?method=login");
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

	});
	
});