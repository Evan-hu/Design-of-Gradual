
var globalval1 = false;
var globalval2 = false;
var globalval3 = false;
var globalval4 = false;

//验证用户名是否可用
function validateName(){
	var username = $("#user").val();
	if(username == ""){
		$("#message").css("display","inline");
	}else{
		$.ajax({
			url:'validate!execute.action',
			data:{userName:username},
			type:'post',
			datatype:'json',
			success:function(data){
				$("#message").text(data.tip);
				$("#message").css("display","inline");	
				globalval1 = true; 
			},
			error:function(data){
				$("#message").text(data.tip);
				$("#message").css("display","inline");	
			}
			});
	}
}
//验证码刷新
function changeValidateCode(obj) {       
	var timenow = new Date().getTime();          
	obj.src="rand.action?d="+timenow;      
}	
$(function () {
	var mail = $("#checkmail").val();
	var state = false;
    $("#checkmail").focus(function () {
        if (state == false) {
            $(this).val('');
        }
    })
    $("#checkmail").blur(function () {
        if ($(this).val() == '') {
            $("#msg-mail").text("邮箱不能为空");
            $(this).focus();
        }
        else {
            if (/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test($(this).val()) == false) {
                $("#msg-mail").text("邮箱格式不正确，请重新填写");
                $(this).focus();
            }
            else {
            	$.ajax({
    				url:'validate!valMail.action',
    				data:{mail:mail},
    				type:'post',
    				datatype:'json',
    				success:function(data){
    					$("#msg-mail").text(data.tip);
    					$("#msg-mail").css("display","inline");
    					globalval2 = true; 
    				},
    				error:function(data){
    					$("#msg-mail").text(data.tip);
    					$("#msg-mail").css("display","inline");						
    				}
    				});    
            }
            }
        })
})
//查看密码长度
$(function(){
	$("#checkpasswd").focus(function(){
            $(this).val('');
        })
$("#checkpasswd").blur(function(){
	var checkpasswd = $("#checkpasswd").val();
				if(checkpasswd == "" || checkpasswd.length<6){
					$('#msg-passwd').text("密码太短，请重新输入！");
					$(this).focus();
					globalval = false;
				}else{
						if(checkpasswd.length > 12){
							$('#msg-passwd').text("密码太长，请重新输入！");
							$(this).focus();
							globalval = false;
						}else{
							globalval3 = true;
							$('#msg-passwd').text("");
						}
					}
			})
})
//查看验证码
$(function(){
	$("#code").focus(function(){
		$(this).val('');
	})
	
	$("#code").blur(function(){
		if($("#code").val() == '' || $("#code").val().length > 4){
			$("#msg-code").text("验证码错误！");
		}else{
			$.ajax({
				url:'validate!validateCode.action',
				data:{code : $("#code").val()},
				type:'post',
				datatype:'json',
				success:function(data){
					$("#msg-code").text(data.tip);
					$("#msg-code").css("display","inline");
					globalval4 = true; 
				},
				error:function(data){
					$("#msg-code").text(data.tip);
					$("#msg-code").css("display","inline");						
				}
				});
			var gol = globalval1+globalval2+globalval3+globalval4;
			alert(gol);
			if(gol != 4){
				$(".form-signin").attr("action",null);
			}
			
		}
	})
})
