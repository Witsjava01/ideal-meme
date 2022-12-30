function calculateAge(birthday) {
	const age = new Date(Date.now()).getFullYear() - new Date(birthday.value).getFullYear();
	$('#age').val(age);
}
$(document).ready(function() {
	if (isUpdate) {
		$('#memberList').css('display', '');
		$('#signOut').css('display', '');
		$('#phoneNumber').attr("disabled", "disabled");
		$('#revise').css('display', '');
		$('#register').css('display', 'none');
		$("#passwordDiv").css('display', 'none');
		$("#SignIn_A").text("會員中心");
	} else {
		$("#passwordDiv").css('display', '');
		$('#memberList').css('display', 'none');
		$('#signOut').css('display', 'none');
		$('#phoneNumber').removeAttr("disabled");
		$('#revise').css('display', 'none');
		$('#register').css('display', '');
	}
	$('#signOutButton').on("click", function() {
		window.location.assign(webApplicationPath + "/LoginServlet");
	});
	$('#loginButton').on("click", function() {
		window.location.assign(webApplicationPath + "/LoginServlet");
	});
	$('#registerButton').on("click", function() {
		if ($('#name').val() === "" || $('#phoneNumber').val() === "" || $('#password').val() === "") {
			alert("姓名、電話及密碼必填!");
		} else {
			var inputData = {};
			$('.inputData').each(function() {
				inputData[$(this).attr('id')] = $(this).val();
			});
			$(".form-select option:selected").each(function() {
				inputData[$(this).parent().attr('id')] = $(this).val()
			})
			inputData[$('#birthday').attr('id')] = $('#birthday').val();
			inputData["create_time"] = Math.round(+new Date() / 1000);
			inputData["update_time"] = Math.round(+new Date() / 1000);
			console.log(inputData);
		}

	});
});