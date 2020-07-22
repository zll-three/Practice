<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>登录界面</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <link rel="stylesheet" href="https://ajax.aspnetcdn.com/ajax/bootstrap/4.2.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.default.css" id="theme-stylesheet">
   <script
		src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
		 <c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
    var contextPath = "${ctx}";
    var userId="${user.userId}";
</script>
  </head>
  <body>
    <div class="page login-page">
      <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
          <div class="row">
            <!-- Logo & Information Panel-->
            <div class="col-lg-6">
              <div class="info d-flex align-items-center">
                <div class="content">
                  <div class="logo">
                    <h1>欢迎登录</h1>
                  </div>
                  <p>权限练习</p>
                </div>
              </div>
            </div>
            <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/login.js"></script>
            <script src="${pageContext.request.contextPath }/statics/jquery-validation/jquery.validate.min.js"></script><!--表单验证-->
             <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery.cookie.js"></script>
    <!-- Main File-->
             <script src="${pageContext.request.contextPath }/statics/js/front.js"></script>
            <!-- Form Panel    -->
            <div class="col-lg-6 bg-white">
              <div class="form d-flex align-items-center">
                <div class="content">
                  <form method="post" action="javascript:;" class="form-validate" id="loginFrom">
                    <div class="form-group">
                     <input id="login-username" type="text" name="userName" required data-msg="请输入用户名" placeholder="用户名" value="admin" class="input-material" value="">
                     <div class="invalid-feedback">
								        	用户名不能为空
								      </div>
                    </div>
                    <div class="form-group">
                      <input id="login-password" type="password" name="passWord" required data-msg="请输入密码" placeholder="密码" class="input-material">
                    <div class="invalid-feedback">
								        	密码不能为空
								      </div>
                    </div>
                    <button id="login" type="button" class="btn btn-primary" >登录</button>
                    <div style="margin-top: -40px;"> 
                    	<!-- <input type="checkbox"  id="check1"/>&nbsp;<span>记住密码</span>
                    	<input type="checkbox" id="check2"/>&nbsp;<span>自动登录</span> -->
											<div class="custom-control custom-checkbox " style="float: right;">
											    <input type="checkbox" class="custom-control-input" id="check1" >
											    <label class="custom-control-label" for="check1">记住密码&nbsp;&nbsp;</label>
											</div> 
											 
											
                    </div>
                  </form>
                  <br />
                  <small>没有账号?</small><a href="registered" class="signup">&nbsp;注册</a>
                   <span id="ts"></span>
                </div>
              </div>
            </div>
          </div>         
        </div>
      </div>
    </div>
    <!-- JavaScript files-->
    
    
  </body>
</html>