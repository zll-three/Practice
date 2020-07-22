<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="//res.layui.com/layui/dist/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<script src="//res.layui.com/layui/dist/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/Menu.js"></script>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
    var contextPath = "${ctx}";

</script>
<body>
<br>
<c:forEach var="getMenuList" items="${getMenuList}" varStatus="status">
  <c:forEach var="buttonList" items="${getMenuList.buttonList}" varStatus="status">
   ${buttonList.button}
  </c:forEach>
 
  </c:forEach>
  <br>
  <br>
  <c:forEach var="getUmList" items="${getUmList}" varStatus="status">
         <c:forEach var="menulist" items="${getUmList.menulist}" varStatus="status">
          <input type="hidden" value="${menulist.menuId }" name="menulist">
                </c:forEach>
           </c:forEach>
  
  
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend>基本演示</legend>
</fieldset>
<div class="layui-btn-container">
  <button type="button" class="layui-btn layui-btn-sm" lay-demo="getChecked">获取选中节点数据</button>
  <button type="button" class="layui-btn layui-btn-sm" lay-demo="setChecked">勾选指定节点</button>
  <button type="button" class="layui-btn layui-btn-sm" lay-demo="reload">重载实例</button>
</div>
 
<div id="test12" class="demo-tree-more"></div>
         
<table class="layui-table">
  <colgroup>
    <col width="150">
    <col width="200">
    <col>
  </colgroup>
  <thead>
    <tr>
      <th>选择</th>
      <th>菜单名称</th>
      <th>菜单标识</th>
      <th>菜单链接</th>
    </tr> 
  </thead>
  <tbody>
     <c:forEach var="getMenu" items="${getMenu}" varStatus="status">
      <tr>
        <td><input type="checkbox" value="${getMenu.menuId   }" name="menuId" id="menuId"></td>
        <td>${getMenu.menuName }</td>
        <td>${getMenu.menuIdentification }</td>
        <td>${getMenu.link }</td>
      </tr>
    
    </c:forEach>
  </tbody>
</table>

 

        


</body>
</html>      