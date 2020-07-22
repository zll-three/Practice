$(function(){
	$("#add").click(function() {
		 $("#vv").html("");
		 $.ajax({
  		 type : "get",
  		 url: contextPath+"/addButton",
  		 async : false,  //同步请求
  		 cache: false,
  		 success: function(data){
  		  $("#vv").html(data);
  		 }
  		  })
	
	});

});