/**
 * 窗体加载事件！
 * 
 * @returns
 */
$(document).ready(function() {
	var check1s=localStorage.getItem("check1");
	var check2s=localStorage.getItem("check2");
	var oldName=localStorage.getItem("userName");
	var oldPass=localStorage.getItem("passWord");
	if(check1s=="true"){
		 $("#login-username").val(oldName);
		 $("#login-password").val(oldPass);
		 $("#check1").prop('checked',true);
	}else{
		 $("#login-username").val('');
		 $("#login-password").val('');
		 $("#check1").prop('checked',false);
	}
	if(check2s=="true"){
		$("#check2").prop('checked',true);
		$("#loginFrom").submit();
	}else{
		$("#check2").prop('checked',false);
	}
	/**
	 * 登陆按钮点击事件！
	 */
	$("#login").click(function() {
		var userName=$("#login-username").val();
		var passWord=$("#login-password").val();
		/*获取当前输入的账号密码*/
		localStorage.setItem("userName",userName)
		localStorage.setItem("passWord",passWord)
		/*获取记住密码  自动登录的 checkbox的值*/
		var check1 = $("#check1").prop('checked');
		var check2 = $('#check2').prop('checked');
		localStorage.setItem("check1",check1);
		localStorage.setItem("check2",check2);
		loginCheck();
	});
	/**
	 * 回车键点击事件！
	 */
	$('form').on('keypress', function(event) {
		if (event.keyCode == 13) {
			loginCheck();
		}
	});
	
	/**
	 * 登录验证！
	 */
	function loginCheck() {
		var userCode = $("#login-username").val();
		var password = $("#login-password").val();
		if (userCode == "" || userCode == null) {
			
			$("#login-username").removeClass("form-control is-valid")
			$("#login-username").addClass("form-control is-invalid");
			return;
		} else if (password == "" || password == null) {
			$("#login-password").removeClass("form-control is-valid")
			$("#login-password").addClass("form-control is-invalid");
			return;
		} else {
		
          //登录ajax请求
			$.ajax({
				type : "post",
				url : contextPath+"/login",
				data:{userName:userCode,password:password},
				dataType : "json",
				success : success,
				error : error,
			});
			// 登录成功回调函数
			function success(data) {		
				if(data.loginResult == "true"){
					alert("登录成功");
					window.location.href = contextPath+"/index";
				}else if(data.loginResult == "false"){
					$("#ts").html("<font>登陆失败,密码或账号错误!</font>");
				}
			}
			//请求失败回调函数
			function error(date) {
				alert("请求失败!");
			}
			
		}
	}
	
});
