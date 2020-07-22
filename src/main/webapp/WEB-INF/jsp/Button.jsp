<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/Button.js"></script>
<br>
<c:forEach var="getMenuList" items="${getMenuList}" varStatus="status">
  <c:forEach var="buttonList" items="${getMenuList.buttonList}" varStatus="status">
   ${buttonList.button}
  </c:forEach>
  </c:forEach>
<br>
<br>
<table class="layui-table">
  <thead>
    <tr>
      <th>选择</th>
      <th>按钮名称</th>
      <th>按钮代码</th>
    </tr> 
  </thead>
  <tbody>
    <c:forEach var="getButtonList" items="${getButtonList}" varStatus="status">
      <tr>
        <td><input type="checkbox" value="${getButtonList.buttonId  }" name="buttonId" id="buttonId"></td>
        <td>${getButtonList.buttonName }</td>
        <td><c:out value="${getButtonList.button }"/></td>
      </tr>
    
    </c:forEach>
  </tbody>
</table>



  