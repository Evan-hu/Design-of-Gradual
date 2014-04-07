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
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		//获取父亲类别
		var member = null;
		$(function(){
			item_nameList_ajax();
		});
		function addItem_ajax(){
			//请求的地址
			var url = "itemAjax/itemAjaxAction!createItem";
			var itemName = $(".span2:eq(0)").val();
			var owner = $(".span2:eq(1)").val();
			if(itemName == "" || owner == ""){
				alert("板块名或版主不能为空");
				return false;
			}
			$.post(url,{
				'itemName': itemName,
				'owner': owner
			},function(data){
				member = eval('('+data+')');
				$(".span2").attr("value","");
				item_nameList_js();
			},'json');
		}
		
		function item_nameList_ajax(){
			//请求的地址
			var url = "itemAjax/itemAjaxAction!retrieveItem";
			$.post(url,{
				'itemName': null
			},function(data){
				member = eval('('+data+')');
				item_nameList_js();
			},'json');
		}
		
		function item_nameList_js(){
			$("table[id='itemName']").empty();
			$("table[id='itemName']")
				.append("<tr>" + 
		                  "<th width='3%'>序号</th>" + 
		                  "<th width='7%'>版块名</th>" + 
		                  "<th width='7%'>版主</th>" + 
		                  "<th width='15%'>板块简介</th>" +
		                  "<th width='5%'>发帖数</th>" +
		                  "<th width='5%'>点击率</th>" +
		                  "<th width='55%'>操作</th>" + 
		                "</tr>"
				);
			for(var i = 0; i < member.length; ++i){//福类别
				$("table[id='itemName']")
					.append("<tr>" + 
		                "<td><span class='badge badge-info'>" + (i+1) + "</td>" +  
		                "<td id='itemname'>" + member[i][0] + "</td>" +
		                "<td id='profile'>" + member[i][1] + "</td>" +
		                "<td id='profile'>" + member[i][2] + "</td>" + 
		                "<td id='profile'>" + member[i][3] + "</td>" + 
		                "<td id='profile'>" + member[i][4] + "</td>" + 
		                 
		                "<td>" + 
		                	"<table id='operation' width='100%'><tr><td>" + 
	               				"<a href='javascript:deleteItem_ajax(" + i + ")' class='btn btn-primary'>删除</a>  |  " +
           						"<select width='100px' onchange='modify_js(" + i + ")'>" +
           							"<option value='-1'>---选择修改内容---</option>" +
							 		"<option value='0'>修改版块名</option>" +
							 		"<option value='1'>修改版主</option>" + 
							 		"<option value='2'>修改简介</option>" + 
							 	"</select>" + 
	               			"</td>" + 
	               			"<td></td>" + 
	               			"</tr></table>" + 	
	                	"</td>" +  
	                "</tr>"); 	
				}
			}
		var preindex = sum = 0;
		function modify_js(index){
			
			var m_style = "修改版块名";
			var select_no = $("select:eq(" + index + ")").val();//-1 未选中，0 修改版块名，1修改版主
			var add_html = "";
			$("table[id='operation']:eq(" + index + ") td:last").empty();
			if(select_no == -1){
				return false;
			}
			if(preindex != index && sum != 0){//跳行访问了
				 
				$("table[id='operation']:eq(" + preindex + ") option:last").select();
			}
			
			if(select_no == 0){
				add_html = "<input type='text' class='span2' id='m_content'>"; 
			}
			else if(select_no == 1){
				add_html = "<input type='text' class='span2' id='m_content'>";
				m_style = "修改版主";
			}else{
				add_html = "<input type='text' class='span2' id='m_content'>";
				m_style = "修改简介";
			}
			select_no = parseInt(index * 100) + parseInt(select_no); 
			$("table[id='operation']:eq(" + index + ") td:last")
				.append(add_html+ 
					"<a href='javascript:modify_ajax(" + select_no + ")' class='btn btn-primary'>" + 
						 m_style +
					 "</a>" 
				);
			preindex = index;
			++ sum;
		}
		
		function modify_ajax(index){
			
			var m_style = parseInt(index % 10);//0 版块名,1 版主
			var rol = parseInt((index - m_style) / 100);//哪一行
			var url = "itemAjax/itemAjaxAction!updateItem";
			var itemName = $("td[id='itemname']:eq(" + rol + ")").text();
			var m_content = $("input[id='m_content']").val();
			
			if(m_content == ""){
				alert("修改内容为空，无法提交");
				return false;
			}
			 
			$.post(url,{
				'itemName': itemName,
				'm_content': m_content,
				'flag': m_style
			},function(data){
				member = eval('('+data+')');
				item_nameList_ajax();
			},'json');
		}
		
		function deleteItem_ajax(index){
		
			var url = "itemAjax/itemAjaxAction!deleteItem";
			var itemName = $("td[id='itemname']:eq(" + index + ")").text();
			$.post(url,{
				'itemName': itemName,
				},function(data){
				member = eval('('+data+')');
				item_nameList_ajax();
			},'json');
		}
	</script>
  </head>
  
  <body>
    <div align="center"> 
  		登录成功 <br>
    欢迎版主：<%out.print(session.getAttribute("cur_user").toString()); %>登陆<br>
    </div>
    <div>
    	<table border="1">
  	 	<tr>
  	 		<td>
  	 			<div class="alert alert-info">
 					版块名 : <input type="text" class="span2" id='name_input'>
			  		版主 :<input type="text" class="span2" id='user_input'> 		  
			  		<button class="btn btn-primary" onclick="addItem_ajax()">添加版块</button>
				</div>
  	 		</td>
  	 	</tr>
  	 </table>
  	 <table class="table table-bordered table-striped" id="itemName" border="1"></table>
    </div>
  </body>
</html>
