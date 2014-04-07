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
	html, body {
		height:100%;
		overflow:hidden;
		}/*兼容性设置*/
	body {
		font-family:Arial, Helvetica, sans-serif; 
		font-size:12px; 
		margin:0px; 
		text-align:center;
		border-right:1px #ccc solid;
	}
	a {
		color: #000; 
		text-decoration: none;
	}
	#menu img {_
		margin-top: 12px;
	}
	#all {
		width: 100%;
		height:100%;
	}
	#menu {
		width: 96%;
	}
	#menu ul {
		padding:0; 
		margin: 0; 
		list-style: none;
	}
	#menu ul li {
		background-image:url(/match/public/images/menu_bg.gif); 
		background-repeat: repeat-x; 
		background-position:center; 
		height: 32px;
		margin-top: 2px; 
		margin-bottom: 2px; 
		border:1px #ccc solid; 
		line-height: 2.8;
	}
</style>
</head>

<body>
<div id="all">
    <div id="menu">
        <ul>
            <li><img src="images/li.jpg" />&nbsp;&nbsp;&nbsp; <a href="#" target="main"></a></li>
            <li><img src="images/li.jpg" />&nbsp;&nbsp;&nbsp; <a href="#" target="main">操作二</a></li>
            <li><img src="images/li.jpg" />&nbsp;&nbsp;&nbsp; <a href="#" target="main">操作三</a></li>
            <li><img src="images/li.jpg" />&nbsp;&nbsp;&nbsp; <a href="#" target="main">操作四</a></li>
        </ul>
    </div>
</div>
</body>
</html>
