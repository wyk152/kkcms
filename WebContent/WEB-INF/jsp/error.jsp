<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>用户管理</title>
    <script type="text/javascript" src="${basePath }/js/datepicker/WdatePicker.js"></script>
</head>
  
  <body>
  	<img src="<%=request.getContextPath() %>/images/common/error.jpg">
    <br>
    
    	操作失败！${exception.message}
    
  </body>
</html>
