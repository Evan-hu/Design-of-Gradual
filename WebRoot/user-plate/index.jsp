<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
if(session.getAttribute("cur_user") != null){
		String cur_user = session.getAttribute("cur_user").toString();
	}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/registe.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
	var member = null;//取值设置
	//创建item
	function addItem_ajax(){
		var itemname = $(".item").val();
		var owner = $(".owner").val();
			if(itemname == "" || owner == ""){
				alert("板块名或者版主不能为空");
				return false;
			}else {
				$.ajax({
					url: "itemAjaxAction!createItem.action",
					data: {
					itemname: itemname,
					owner: owner},
					datatype: 'json',
					success: function(data){
						member = eval('('+data+')');
						//获取已有的item
						item_nameListjs();
					},
					error:function(){
						$("#mesg").text("产生未知错误");
					}
				});
			}
	}
	
	//在table[id=‘itemname’]的表中添加数据
	function item_nameListjs(){
		$("table[id='itemName']").empty();
		$("table[id='itemName']")
			.append(
				"<tr>"+
				"<th width='10%'>序&nbsp&nbsp号</th>"+
				"<th width='30%'>板块名</th>"+
				"<th width='20%'>版&nbsp&nbsp主</th>"+
				"<th width='50%'>操&nbsp&nbsp作</th>"+
				"</tr>"
			);
		//父类
		for(var i=0; i<member.length; i++){
			$("table[id='itemName']")
				.append(
					"<tr>"+
						"<td class=''>"+(i+1)+"</td>"+
						"<td id='itemname'>"+ member[i][0] +"</td>"+
						"<td id=''>"+ member[i][1]  +"</td>"+
						"<td>"+
							"<table id='operation' width='100%'><tr><td>"+
								+"<a href='javascript:deldeteItem_ajax("+ i +")' class=''>删除</a>"+
								+"<select width='100px' onchange='modify_js("+i+")'>"+
								+"<option value='0'>修改板块名</option>"+
								+"</select>"+
								+"</td>"+
								+"<td></td>"+
								+"</tr></table>"+
						"</td>"+
					"</tr>"
				);
		}	
		
	}
	//修改板块名
	var prindex = sum = 0;
	function modify_js(prindex){
		//修改内容
	}
	
	//删除板块
	function deldeteItem_ajax(index){
		var url = "";
		var itemname = "";
		$.ajax({
		
		});
	}
	
	</script>
  <style type="text/css" media="screen">
	.header {
		margin-top: 20px;
		margin-left: 100px;
		padding: 20px;
		width: 100%;
	}
	.content {
		margin-top: 20px;
		margin-left: 100px;
		padding: 20px;
		width: 100%;
	}
		
	</style>
</head>
  
<body>
   <div class="header"> 
  		登录成功<br>
    欢迎版主：<%out.print(session.getAttribute("cur_user").toString()); %>登陆<br>
    </div>
    
    <div class="content">
    	<table border="0">
  	 		<tr>
  	 			<td>
  	 				<div>
 						版块名 : <input type="text" class="item" id='name_input'>
			  			版主 :<input type="text" class="owner" id='user_input'> 		  
			  			<button class="btn btn-primary" onclick="addItem_ajax()">添加版块</button>
					</div>
  	 			</td>
  	 			<td>
  	 				<span id="mesg"></span>
  	 			</td>
  	 		</tr>
  	 	</table>
  		 <table class="table table-bordered table-striped" id="itemName" border="1"></table>
    </div>
    </body>
</html>
