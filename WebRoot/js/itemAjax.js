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
							"<table id='operation' width='100%'>" +
									"<tr><td>"+
										"<a href= 'javascript:deldeteItem_ajax("+ i +") ' class= ' '>删除</a>"+
										"<select  width= '100px' onchange= 'modify_js("+i+")'>"+
										"<option value='0'>修改板块名</option>"+
										"</select>"+
										"</td>"+
									"</tr>"+
							"</table>"+
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
	