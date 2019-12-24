$(function() {
	$('#myCarousel').carousel('cycle');
});

$(document).ready(function() {

	$.ajax({
		type : 'get',
		url : "index_companyInfo",
		cache : false,
		success : function(data) {
			$("#phone").html(data.phone);
			$("#email").html(data.email);
			$("#location").html(data.location);
			$("#cdesc").html(data.cdesc);
		},
		error : function() {
			alert("请求失败")
		}
	})
	
	
	$.ajax({
		type : 'get',
		url : "index_article",
		cache : false,
		success : function(data) {
			$("#articleTitle").html("<h2 style='font-weight:bold;'>"+data.atitle+"</h2>");
		},
		error : function() {
			alert("请求失败")
		}
	})
	
	$.ajax({
		type : 'get',
		url : "index_notice",
		cache : false,
		success : function(data) {
			$("#noticeTitle").html("<h2 style='font-weight:bold;'>"+data.ntitle+"</h2>");
		},
		error : function() {
			alert("请求失败")
		}
	})
	
	
	
});