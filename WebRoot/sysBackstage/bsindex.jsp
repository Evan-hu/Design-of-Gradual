<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
</head>

<frameset cols="*" rows="136, *" id="frame_main"  border="0">
    <frame src="sysBackstage/header.jsp" noresize="noresize" name="header">
    
    <frameset cols="240, *">
    	<frame src="sysBackstage/menu.jsp" name="menu" />
    	<frame src="sysBackstage/main.jsp" name="main">
    </frameset>
</frameset>

<noframes>
	<body>
	</body>
</noframes>
</html>
