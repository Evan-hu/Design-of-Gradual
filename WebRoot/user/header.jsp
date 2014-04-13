<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'header.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    	<div>
    		功能分类
    	</div>
    	<div>
    		<ul>
    			<li><a href="<%=basePath%>user/userindex.jsp">发表贴子</a></li>
    			<li><a href='postAction!viewPost?userId=<s:property value="#session.user.userId"'/>我的主贴</a></li>
    			<li><a href="<%=basePath%>">我的回复</a></li>
    			<li><a href="<%=basePath%>">个人信息</a></li>
    			<li><a href="<%=basePath%>">图片管理</a></li>
    			
    		</ul>
    	</div>
  </body>
</html>
