/**
 * Created by jvbo
 */

$(function(){
	$("input:text:first").focus();
	$("#loginForm").keyup(function(event){
		if(event.keyCode ==13){
			login();
		}
	});
})
var login = function(){
	var username = $("#username").val();
	var password = $("#password").val();
	var appName = "jvbo.fun.upms";
	if(!username){
		$("#warn").text("请填写用户名");
		return false;
	}
	if(!password){
		$("#warn").text("请填写密码");
		return false;
	}
	ajaxPost("/sso/login", {"username": username, "password": password, "appName": appName}, function (repData) {
		if(repData.code != 200){
			$("#warn").text(repData.msg);
			return false;
		}else{
			var backUrl = repData.data;
			window.location.href = backUrl;
		}
	});
	return false;
}