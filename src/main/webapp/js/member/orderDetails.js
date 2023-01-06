$(document).ready(function() {
	$('#signOutButton').on("click", function() {
		window.location.assign(webApplicationPath + "/MemberServlet");
	});
});