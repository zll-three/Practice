function userList(link,menuId){
	var userName =$("#userName").val();
	$.ajax({
		 type : "get",
		 url: contextPath+link,
		 data:{link:link,userName:userName,menuId:menuId},
		 async : false,  //同步请求
		 cache: false,
		 success: function(data){
		  $("#aa").html(data);
		 }
		  })
	
	
}








































