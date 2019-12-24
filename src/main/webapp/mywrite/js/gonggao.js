$(document).ready(function() {

	$.ajax({
		type : 'get',
		url : "notice_info",
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
			var trData = "<tbody><td>"+ data[i].ntitle +"</td><td>"+ getDate(data[i].ntime)+"</td><td><button  class=\"btn btn-info btn-xs\" data-toggle=\"modal\" data-target=\"#findModal\"  onclick=\"getNotice("+data[i].nid+")\">查看</button></td></tbody>";
				thedata.append(trData);
			}
		},
		error : function() {
			alert("请求失败")
		}
	})
});


function getNotice(id) {
	$.ajax({
		type : 'get',
		url : "notice_infobyid?nid="+id,
		cache : false,
		type:"json",
		success : function(data) {
			$("#findTitle").val(data[0].ntitle);
			$("#findContent").val(data[0].ncontent);
			//editor.html("111");		//	给在线编辑器设置内容		
		},
		error : function() {
			alert("请求失败")
		}
	});	
}

function search() {
		var data = $("#title").serialize();     
	   $.ajax({ 
	    type:'post',  
	    url:"notice_infobytitle", 
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
				var trData = "<tbody><td>"+ data[i].ntitle +"</td><td>"+ getDate(data[i].ntime)+"</td><td><button  class=\"btn btn-info btn-xs\" data-toggle=\"modal\" data-target=\"#findModal\"  onclick=\"getNotice("+data[i].nid+")\">查看</button></td></tbody>";
					thedata.append(trData);
				}
	    },	
	    error:function(){ 
	     alert("请求失败")
	    }
	   })
}

function getDate(time) {
	var  flag = ""+time.day;
	if(flag.length == 1){
		var ss = time.year+"-"+time.month+"-0"+time.day;
	}else{
		var ss = time.year+"-"+time.month+"-"+time.day;
	}
	
	
	return "20"+ss.substr(1) ;
}