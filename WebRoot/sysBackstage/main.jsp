<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
if(session.getAttribute("cur_user") != null){
		String cur_user = session.getAttribute("cur_user").toString();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
	body {
		font-family: Arial, Helvetica, sans-serif; 
		font-size:12px; text-align:center;
	}
	a { 
		text-decoration: none;
	}
	#all {
		widht: 100%; 
		text-align:center; 
		margin:auto;
	}
	#main {
		width: 96%; 
		line-height: 1.8; 
		margin:auto; 
		border:1px #ccc dashed; 
		text-align: left; 
		text-indent: 2em;
	}
</style>
</head>

<body>
<div id="all">
	<div id="main">
		<p><a href="#" target="_blank"></a></p>
        <p></p>
        <p></p>
    </div>
</div>
</body>
</html>
