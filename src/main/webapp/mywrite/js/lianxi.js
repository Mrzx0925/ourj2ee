function scommit() {
	var data = $("#form").serialize();     
	   $.ajax({ 
	    type:'post',  
	    url:"message_save", 
	    cache: false,
	    data:data,  //重点必须为一个变量如：data
	   // dataType:'json', 
	    success:function(data){  
	    	alert(data);
	    	$("input[type=reset]").trigger("click");
	    },	
	    error:function(){ 
	     alert("请求失败")
	    }
	   })
}