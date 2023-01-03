$(document).ready(function() {
	$('#searchButton').on("click",function(){
		var searchData = {};
		searchData[$("#order_id").attr('id')]=$("#order_id").val();
		console.log(searchData);
	})
	
	
});