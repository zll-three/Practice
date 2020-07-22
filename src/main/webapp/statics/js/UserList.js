$(document).ready(function() {
	$("#add").click(function() {
		 $.ajax({
    		 type : "get",
    		 url: contextPath+"/add",
    		 async : false,  //同步请求
    		 cache: false,
    		 success: function(data){
    		  $("#vv").html(data);
    		 }
    		  })
	
	});
$("#fp").click(function() {
	var Checkbox=false;//默认复选框为空
	     $("input[name='userId']").each(function(){//获取复选框节点id
	      if (this.checked==true) {        
	        Checkbox=true;    //已勾选
	      }
	    });
	 if(Checkbox==false){
		 alert("请选择你要分配的用户");
		 return false;
	 }
	 obj = document.getElementsByName("userId");//将复选框定义成一个jquery对象
	        userId = [];//定义一个数组
	        for(k in obj){//k相当于i,往这个jquery对象添加勾选的id;
	            if(obj[k].checked)//选中的都放进 数组里
	                userId.push(obj[k].value);
	             
	        }
	 if(userId.length>1){
		 alert("只能同时给一个用户分配权限");
		 return false;
	 }
	 for(var j in userId){
		 sessionStorage.clear();
         console.log(userId[j]);    	
         $.ajax({
    		 type : "get",
    		 url: contextPath+"/fp",
    		 data:{userId:userId[j]},
    		 async : false,  //同步请求
    		 cache: false,
    		 success: function(data){
    		  $("#vv").html(data);
    		 }
    		  })
     }
	
    
	
});	
$("#del").click(function() {
		var Checkbox=false;//默认复选框为空
		     $("input[name='userId']").each(function(){//获取复选框节点id
		      if (this.checked==true) {        
		        Checkbox=true;    //已勾选
		      }
		    });
		
		if (Checkbox){//boolean值为true
			        var t=confirm("您确认要删除选中的内容吗？");//弹出对话进行警告
			        if (t==false) return false;    //不勾选不处理
			        obj = document.getElementsByName("userId");//将复选框定义成一个jquery对象
			        userId = [];//定义一个数组
			        for(k in obj){//k相当于i,往这个jquery对象添加勾选的id;
			            if(obj[k].checked)//选中的都放进 数组里
			                userId.push(obj[k].value);
			             
			        }
			//删除ajax请求
				$.ajax({
					type : "post",
					url : contextPath+"/delUser/"+userId,					
					dataType : "json",
					success : success,
					error : error,
				});
				// 删除成功回调函数
				var link="/UserList";
				var menuId=2;
				function success(data) {		
					if(data.delResult == "true"){
						alert("删除成功");			
						$.ajax({
							 type : "get",
							 url: contextPath+"/UserList",
							 data:{link:link,menuId:menuId},
							 async : false,  //同步请求
							 cache: false,
							 success: function(data){
							  $("#aa").html(data);
							 }
							  })
					}else if(data.delResult == "false"){
						$("#ts").html("<font>删除失败,密码或账号错误!</font>");
					}
				}
				//请求失败回调函数
				function error(date) {
					alert("请求失败!");
				}
			 
			 
		 }
	    else{
	        alert("请选择您要解除的用户!");//不勾选不提交，弹出警告框。
	        return false;
	    }
	    
		
	});



});	







	