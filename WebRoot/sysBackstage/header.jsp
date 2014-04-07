<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
if(session.getAttribute("cur_user") != null){
		String cur_user = session.getAttribute("cur_user").toString();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Admin Header</title>
<style type="text/css">
    body {
        background: #686868; 
        font-family:Arial, Helvetica, sans-serif; 
        font-size:12px; 
        margin:0px; 
        margin-bottom:2px;
        border-bottom: 1px #ccc solid;
    }
    h1 {
        color: #FFF;
    }
    a {
        color: #FFF; 
        text-decoration: none;
        position:relative;
    }
    ul { 
        list-style:none;
    }
    #all {
        width: 100%;
    }
    #banner {
        margin-top: 8px; 
        margin-left: 32px;
    }
    #main {
        width: 100%; 
        margin-bottom: 2px; 
        background:#eeeeee; 
        margin-left: 0px; 
        margin-right:0px; 
        height: 30px; 
        color: #000; 
        line-height: 2.4;
        overflow: auto;
    }
    #main a {
        color:#000;
    }
    #welcome { 
        float:left; 
        width: 40%; 
        font-weight: 800; 
        padding-left: 8px; 
        position:relative;
    }
    #adminop { 
        float:left; 
        width: 59%; 
        position:relative; 
        text-align:right; 
        line-height:1; 
        *line-height:2.2;
    }
    #adminop ul li {
        float: right;
         width: 80px;
     }
    #nav {
        width: 100%; 
        clear: both;
    }
    #nav ul li {
        float: right; 
        width:82px; 
        height:25px; 
        line-height: 2.1; 
        text-align: center;
    }
    .inactive { 
        background-image/**/:url(images/admin/nav_bg_inactive2.png) !important;
        background: none; 
        margin-left: 2px; 
        margin-right:2px;
        filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src=images/admin/nav_bg_inactive2.png);}
    .inactive a {
        color: #000;
    }
    .active {
        background:url(images/admin/nav_bg_active2.png) !important;
        background: none; 
        margin-left: 2px; 
        margin-right:2px;
        filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src=images/admin/nav_bg_active2.png);
    }
    .active a {
        color:#fff;
    }
    .blankgray {
        background:#bbb; 
        height:2px; 
        width:100%; 
        margin:0; 
        padding:0; 
        clear:both; 
        font-size:2px;
    }
</style>
<script type="text/javascript" language="javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript">
    var oplist = new Array('about', 'user', 'news', 'mars', 'jielong', 'box', 'school', 'config', 'other');
    $(document).ready(function() {
    	$('#nav').find("a").click(function() {
    		  var id = $(this).attr('id');
        		$.each(oplist, function(i, n) {
        			$('#'+n).attr('class', 'inactive');
    		    });
    		$(this).parents("li").attr('class', 'active');
    	});
    });
</script>
</head>

<body>
<div id="all">
	<div id="banner"><h1>后台管理登录</h1></div>
    <div id="nav">
    	<ul>
        	<li class="inactive" id="other"><a href="menu.jsp" target="menu">用户管理</a></li>
            <li class="inactive" id="about"><a href="menu.jsp" target="menu">帖子管理</a></li>
            <li class="inactive" id="user"><a href="menu.jsp" target="menu">回帖管理</a></li>
            <li class="inactive" id="news"><a href="menu.jsp" target="menu">版主管理</a></li>
            <li class="inactive" id="mars"><a href="menu.jsp" target="menu">板块管理</a></li>
        </ul>
    </div>
    <div id="main">
    	<div id="welcome">
    		This is my JSP page. 欢迎你回来，管理员<strong><%out.print(session.getAttribute("cur_user").toString()); %></strong>
		</div>
        <div id="adminop">
            <ul>
                <li><a href="../index.jsp" target="_parent">首页</a></li>
                <li><a href="#" onclick="alert('确认退出吗！')">安全退出</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
