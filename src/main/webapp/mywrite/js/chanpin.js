$(document).ready(function() {
	$.ajax({
		type : 'get',
		url : "product_info",
		cache : false,
		type:"json",
		success : function(data) {
			 if(data.length == 0){
		    		let thedata = $("#table");
					let trData = "<tbody><td>暂无数据</td><td>暂无数据</td><td>暂无数据</td></tbody>";
						thedata.append(trData);
			}
			for (var i in data) {
			var thedata = $("#table");
			var trData = "<tbody><td><img style='width:100px;height:100px' src='"+data[i].img +"'></img></td><td>"+ data[i].pname	+"</td><td>"+data[i].pdesc+"</td></tbody>";
				thedata.append(trData);
			}
			
		},
		error : function() {
			alert("请求失败")
		}
	})
	
});



function search() {
	  var data = $("#pform").serialize();     
	   $.ajax({ 
	    type:'get',  
	    url:"product_infobyname", 
	    cache: false,
	    data:data,  //重点必须为一个变量如：data
	   // dataType:'json', 
	    success:function(data){  
	    $("#table tbody").html("");
	     if(data.length == 0){
	    		let thedata = $("#table");
				let trData = "<tbody><td>暂无数据</td><td>暂无数据</td><td>暂无数据</td></tbody>";
					thedata.append(trData);
		}
	    for (var i in data) {
	    	var thedata = $("#table");
			var trData = "<tbody><td><img style='width:100px;height:100px' src='"+data[i].img +"'></img></td><td>"+ data[i].pname	+"</td><td>"+data[i].pdesc+"</td></tbody>";
				thedata.append(trData);
				}
	    },	
	    error:function(){ 
	     alert("请求失败")
	    }
	   })
}
