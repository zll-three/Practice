<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    var roleIdList = "${roleIdList}";
</script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/FPNt.js"></script>
            <!-- 顶部开始 -->
        <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="gridSystemModalLabel">用户分配权限</h4>
      </div>
      <div class="modal-body">
        <div class="form-group">
           <c:forEach var="getList" items="${getList}" varStatus="status">
            <input type="hidden" value="${getList.userId }" name="userId" id="userId">
                  用户姓名:${getList.userName}
           </c:forEach>
        <c:forEach var="getList" items="${getList}" varStatus="status">
         <c:forEach var="rolelist" items="${getList.roleList}" varStatus="status">
          <input type="hidden" value="${rolelist.roleId }" name="rolelist">
  
                </c:forEach>
           </c:forEach>
           <c:forEach var="getUmList" items="${getUmList}" varStatus="status">
         <c:forEach var="menulist" items="${getUmList.menulist}" varStatus="status">
          <input type="hidden" value="${menulist.menuId }" name="menulist">
                </c:forEach>
           </c:forEach>
          </div> 
        
       <div>
       <span>用户关联权限:</span>
              
        
          <c:forEach var="getRoleList" items="${getRoleList}" varStatus="status">
           <input type="checkbox" value="${getRoleList.roleId }" name="roleid">${getRoleList.roleName }&nbsp;&nbsp;&nbsp;&nbsp;
                   
       </c:forEach>
      
      
      </div>    
      <div>
       <span>用户关联菜单:</span>
       
       
       <c:forEach var="getMenu" items="${getMenu}" varStatus="status">
             
             <input type="checkbox" value="${getMenu.menuId }" name="menuid">${getMenu.menuName }&nbsp;&nbsp;&nbsp;&nbsp;
                      
        </c:forEach>
      </div>  
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" onclick="FPnt()">提交</button>
       <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div><!-- /.modal-content -->
  </div>
</div> 