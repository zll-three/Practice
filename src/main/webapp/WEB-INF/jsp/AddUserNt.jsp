<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
    var contextPath = "${ctx}";

</script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/UserList.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/AddUserNt.js"></script>
            <!-- 顶部开始 -->
        <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="gridSystemModalLabel">增加用户</h4>
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
       <span>用户关联权限:</span>
       <c:forEach var="getRoleList" items="${getRoleList}" varStatus="status">
             <input type="checkbox" value="${getRoleList.roleId }" name="roleId">${getRoleList.roleName }&nbsp;&nbsp;&nbsp;&nbsp;
                   
       </c:forEach>
      
      
      </div>    
      <div>
       <span>用户关联菜单:</span>
       <c:forEach var="getMenu" items="${getMenu}" varStatus="status">
             
             <input type="checkbox" value="${getMenu.menuId }" name="menuId">${getMenu.menuName }&nbsp;&nbsp;&nbsp;&nbsp;
                      
        </c:forEach>
      </div>  
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" onclick="AddUser()">提交</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div><!-- /.modal-content -->
  </div>
</div>  