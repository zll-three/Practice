<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


 <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="gridSystemModalLabel">增加菜单</h4>
      </div>
      <div class="modal-body">
        <div class="form-group">
      <label for="exampleInputName2">用户姓名</label>
     <input type="text" class="form-control" id="username" placeholder="用户姓名" name="username" value=""><i id="ts"></i>
      </div> 
         <div class="form-group">
      <label for="exampleInputName2">用户密码</label>
    <input type="password" class="form-control" id="password" placeholder="密码" name="password" value="">

      </div> 
        
       <div>
      
       
      </div>  
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" onclick="AddUser()">提交</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div><!-- /.modal-content -->
    </div>
    </div>