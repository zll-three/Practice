<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
 <c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
    var contextPath = "${ctx}";

</script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/Homepage.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/UserList.js"></script>
  
 <br>
 <div id="cc">
  <c:forEach var="getMenuList" items="${getMenuList}" varStatus="status">
  <c:forEach var="buttonList" items="${getMenuList.buttonList}" varStatus="status">
   ${buttonList.button}
  </c:forEach>
 
  </c:forEach>
  <br>
  <br>
 <form class="form-inline">
  <div class="form-group">
    <label for="exampleInputName2">用户姓名</label>
    <input type="text" class="form-control" id="userName" placeholder="用户姓名" name="userName" value="">
  </div> 
  <button type="button" class="btn btn-default" onclick="userList('${link}','${menuId}')">查询</button>
</form>
 
<table class="table table-bordered table-hover">
    <tr class="info"><td>选择</td>
      <td>用户姓名</td>
      <td>用户角色</td>
      <td>角色编号</td>
  </tr>
  <c:forEach var="getUserLst" items="${getUserLst}" varStatus="status">
           <tr><td><input type="checkbox" value="${getUserLst.userId }" name="userId" id="userid"></td>  
           <td>${getUserLst.userName }</td>          
           <td><c:forEach var="roleList" items="${getUserLst.roleList}" varStatus="status">${roleList.roleName }&nbsp;&nbsp;&nbsp;</c:forEach></td>
           <td><c:forEach var="roleList" items="${getUserLst.roleList}" varStatus="status">${roleList.numbering }&nbsp;&nbsp;&nbsp;</c:forEach></td></tr> 
          
          
                          
                        
  

      
        </c:forEach>
  
</table>

</div>
   
    
    
    
    
    
        
