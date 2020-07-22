$(function(){
	$("#username").blur(function(){
		//判断用户名是否一致
		var userName =$("#username").val();
		if(userName==""){
			$("#ts").html("<span class='glyphicon glyphicon-remove' aria-hidden='true'></span>");
			return false;
		}
		//ajax请求
		$.ajax({
			type : "post",
			url : contextPath+"/count",
			data:{userName:userName},
			dataType : "json",
			success : success,
			error : error,
		});
		// 成功回调函数
		function success(data) {		
			if(data.countResult == "true"){
				$("#ts").html("<span class='glyphicon glyphicon-remove' aria-hidden='true'></span>");	
				return false;
			}else if(data.countResult == "false"){
				$("#ts").html("<span class='glyphicon glyphicon-ok' aria-hidden='true'></span>");
				
			}
		}
		//请求失败回调函数
		function error(date) {
			alert("请求失败!");
		}
		
		
		
		});
	
	
	
});
function AddUser(){
	var userName =$("#username").val();
	var password =$("#password").val();
	if(userName==""){
		alert("用户姓名不能为空!");
		$("#ts").html("<span class='glyphicon glyphicon-remove' aria-hidden='true'></span>");	
		return false;
	}
	if(password==""){
		alert("密码不能为空!");
		return false;
	}
	$.ajax({
		type : "post",
		url : contextPath+"/count",
		data:{userName:userName},
		dataType : "json",
		success : success,
		error : error,
	});
	// 成功回调函数
	function success(data) {		
		if(data.countResult == "true"){
			$("#ts").html("<span class='glyphicon glyphicon-remove' aria-hidden='true'></span>");	
			return false;
		}else if(data.countResult == "false"){
			$("#ts").html("<span class='glyphicon glyphicon-ok' aria-hidden='true'></span>");
			if(userName==""){
				alert("用户姓名不能为空!");
				$("#ts").html("<span class='glyphicon glyphicon-remove' aria-hidden='true'></span>");	
				return false;
			}
			if(password==""){
				alert("密码不能为空!");
				return false;
			}
			var Checkbox=false;//默认复选框为空
			     $("input[name='menuId']").each(function(){//获取复选框节点id
			      if (this.checked==true) {        
			        Checkbox=true;    //已勾选
			      }
			    });
			var checkbox=false;//默认复选框为空
			     $("input[name='roleId']").each(function(){//获取复选框节点id
			      if (this.checked==true) {        
			        checkbox=true;    //已勾选
			      }
			    });
			if(Checkbox==false){
				alert("请给用户关联菜单");
				return false;
			}
			if(checkbox==false){
				alert("请给用户关联权限");
				return false;
			}
			
			 obj = document.getElementsByName("menuId");//将复选框定义成一个jquery对象
			        menuId = [];//定义一个数组
			        for(k in obj){//k相当于i,往这个jquery对象添加勾选的id;
			            if(obj[k].checked)//选中的都放进 数组里
			                menuId.push(obj[k].value);
			             
			        }
			 obj1 = document.getElementsByName("roleId");//将复选框定义成一个jquery对象
			        roleId = [];//定义一个数组
			        for(k in obj1){//k相当于i,往这个jquery对象添加勾选的id;
			            if(obj1[k].checked)//选中的都放进 数组里
			                roleId.push(obj1[k].value);
			             
			        }
			
			
			

			
			//ajax请求
				$.ajax({
					type : "post",
					url : contextPath+"/addUser/"+roleId+"/"+menuId+"/"+userName+"/"+password,
					dataType : "json",
					success : success,
					error : error,
				});
				// 成功回调函数
				var link="/UserList";
				var menuId=2;
				function success(data) {		
					if(data.addUserResult == "true"){
						alert("增加成功");
						$.ajax({
							 type : "get",
							 url: contextPath+"/UserList",
							 data:{link:link,menuId:menuId},
							 async : false,  //同步请求
							 cache: false,
							 success: function(data){
							  $("#aa").html(data);
							  $(".modal").modal("hide");
							  $(".modal-backdrop").remove();
							 }
							  })			
					}else if(data.addUserResult == "false"){
						alert("增加失败");
						return false;
					}
				}
				//请求失败回调函数
				function error(date) {
					alert("请求失败!");
				}
		}
	}
	//请求失败回调函数
	function error(date) {
		alert("请求失败!");
	}
	
	
}
