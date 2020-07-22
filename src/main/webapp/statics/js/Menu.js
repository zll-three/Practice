$(function(){
	$("#add").click(function() {
		 $("#vv").html("");
		 $.ajax({
   		 type : "get",
   		 url: contextPath+"/addMenu",
   		 async : false,  //同步请求
   		 cache: false,
   		 success: function(data){
   		  $("#vv").html(data);
   		 }
   		  })
	
	});
	//ajax请求
		$.ajax({
			type : "post",
			url : contextPath+"/menulist",
			dataType : "json",
			success : success,
			error : error,
		});
		// 成功回调函数
		function success(data1) {		
			 obj = document.getElementsByName("menulist");//将复选框定义成一个jquery对象
				        menulist = [];//定义一个数组
				        for(k in obj){//k相当于i,往这
					    menulist.push(obj[k].value);
					    
						        
				}	
			
			var getUmList=getUmList;//用户绑定的菜单id
			var getMenulist=data1.getMenulist;//一级菜单
			var getMenulist2=data1.getMenulist2;//二级菜单
			var getMenulist3=data1.getMenulist3;//三级菜单	

			layui.use(['tree', 'util'], function(){
				  var tree = layui.tree
				  ,layer = layui.layer
				  ,util = layui.util
				  
				  //模拟数据
				  ,data = [];
			
			
			
			for (var i = 0; i < getMenulist.length; i++) { //循环一级菜单
	        	var checked = false;	//复选框声明
	        	for(var a = 0; a < getMenulist.length; a++){
	        		
	        		
	        	}
	        	  data.push({	//添加一级菜单数据
			        	title: getMenulist[i].menuName,
						id: getMenulist[i].menuId,
						children: [],
						checked: checked
						/* mparentId: menu[i].mparentId,
						mtype: menu[i].mtype,
						mresurl: menu[i].mresurl, */
						
					});	      
	        	  
	        	  //循环二级菜单  
	        	  for (var x = 0; x < getMenulist2.length; x++) { 
	        		  
	        	    	  		
	        	  

	        	  			if(getMenulist2[x].correlationId == getMenulist[i].menuId){  //绑定一级和对应的二级菜单
	        	  		        data[i].children.push({	//添加二级菜单数据
	        	  		        	title: getMenulist2[x].menuName,
	        	  					id: getMenulist2[x].menuId,
	        	  					children: [],
	        	  					checked: checked
	        	  				
	        	  				});
	        	  			}
	        	  		
	        	  			
			}
	        		  //循环三级菜单 
	        	  for (var v = 0; v < getMenulist3.length; v++) { 
  	  				for (var c = 0; c < data[i].children.length; c++) { 
     	  		
   	        	  			if(getMenulist3[v].correlationId == getMenulist2[c].menuId){  //绑定一级和对应的二级菜单
   	        	  		        data[i].children[c].children.push({	//添加二级菜单数据
   	        	  		        	title: getMenulist3[v].menuName,
   	        	  					id: getMenulist3[v].menuId,
   	        	  					children: [],
   	        	  					checked: checked
   	        	  				
   	        	  				});
   	        	  			}		
    	  			 }		
  	  			} 
		
			}
				
			 //基本演示
			  tree.render({
			    elem: '#test12'
			    ,data: data
			    ,showCheckbox: true  //是否显示复选框
			    ,id: 'demoId1'
			    ,isJump: true //是否允许点击节点时弹出新窗口跳转
			    ,click: function(obj){
			      var data = obj.data;  //获取当前点击的节点数据
			      layer.msg('状态：'+ obj.state + '<br>节点数据：' + JSON.stringify(data));
			    }
			  });
			  
			  //按钮事件
			  util.event('lay-demo', {
			    getChecked: function(othis){
			      var checkedData = tree.getChecked('demoId1'); //获取选中节点的数据
			      
			      layer.alert(JSON.stringify(checkedData), {shade:0});
			      console.log(checkedData);
			    }
			    ,setChecked: function(){
			      tree.setChecked('demoId1', [12, 16]); //勾选指定节点
			    }
			    ,reload: function(){
			      //重载实例
			      tree.reload('demoId1', {
			        
			      });
			      
			    }
			  });
			 
			  
			
			});
			
				
			
		}
		//请求失败回调函数
		function error(date) {
			alert("请求失败!");
		}

	
	
	
		  
		 
		 
	
	
});