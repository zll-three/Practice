$(function(){
	obj = document.getElementsByName("rolelist");//将复选框定义成一个jquery对象
	        rolelist = [];//定义一个数组
	        for(k in obj){//k相当于i,往这
		    rolelist.push(obj[k].value);
		    
			        
	}		
	    var checkBoxAll =$("input[name^='roleid']");//获取前缀为checkbox_的所有多选框对象
	    var checkArray=rolelist;//获取多选框需要回显得对应的值集合
	    console.info("checkArray=",checkArray);
	    for(var i=0;i<checkArray.length;i++){//
	                       //获取所有复选框对象的value属性，然后，用checkArray[i]和他们匹配，如果有，则说明他应被选中
	                        $.each(checkBoxAll,function(j,checkbox){
	                            //获取复选框的value属性
	                           var checkValue=$(checkbox).val();
	                            if(checkArray[i]==checkValue){
	                                $(checkbox).attr("checked",true);
	                          }
	                       })
	                   }
	    
	    
	    
	    obj1 = document.getElementsByName("menulist");//将复选框定义成一个jquery对象
		        menulist = [];//定义一个数组
		        for(k in obj1){//k相当于i,往这
			    menulist.push(obj1[k].value);
			    
				        
		}	
		    var checkBoxall =$("input[name^='menuid']");//获取前缀为checkbox_的所有多选框对象
		    var checkarray=menulist;//获取多选框需要回显得对应的值集合
		    console.info("checkarray=",checkarray);
		    for(var i=0;i<checkarray.length;i++){//
		                       //获取所有复选框对象的value属性，然后，用checkArray[i]和他们匹配，如果有，则说明他应被选中
		                        $.each(checkBoxall,function(j,checkBox){
		                            //获取复选框的value属性
		                           var checkValue=$(checkBox).val();
		                            if(checkarray[i]==checkValue){
		                                $(checkBox).attr("checked",true);
		                          }
		                       })
		                   }
	    });

function FPnt(){
	var Checkbox=false;//默认复选框为空
	     $("input[name='menuid']").each(function(){//获取复选框节点id
	      if (this.checked==true) {        
	        Checkbox=true;    //已勾选
	      }
	    });
	var checkbox=false;//默认复选框为空
	     $("input[name='roleid']").each(function(){//获取复选框节点id
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
	 obj = document.getElementsByName("menuid");//将复选框定义成一个jquery对象
	        menuId = [];//定义一个数组
	        for(k in obj){//k相当于i,往这个jquery对象添加勾选的id;
	            if(obj[k].checked)//选中的都放进 数组里
	                menuId.push(obj[k].value);
	             
	        }
	 obj1 = document.getElementsByName("roleid");//将复选框定义成一个jquery对象
	        roleId = [];//定义一个数组
	        for(k in obj1){//k相当于i,往这个jquery对象添加勾选的id;
	            if(obj1[k].checked)//选中的都放进 数组里
	                roleId.push(obj1[k].value);
	             
	        }
	
	var userId =$("#userId").val();
	//ajax请求
			 $.ajax({
				type : "post",
				url : contextPath+"/fpUser/"+roleId+"/"+menuId+"/"+userId,
				dataType : "json",
				success : success,
				error : error,
			});
			// 成功回调函数
				var link="/UserList";
				var menuId=2;
			function success(data) {		
				if(data.fpUserResult == "true"){
					alert("分配成功");
					$.ajax({
						 type : "get",
						 url: contextPath+"/UserList",
						 data:{link:link,menuId:menuId},
						 async : false,  //同步请求
						 cache: false,
						 success: function(data){
							 
							  $("#aa").html(data);
							  $(".modal.fade").hide();
							  $(".modal-backdrop").remove();
						 }
						  })
				}else if(data.fpUserResult == "false"){
					alert("分配");
					return false;
				}
			}
			//请求失败回调函数
			function error(date) {
				alert("请求失败!");
			}
}