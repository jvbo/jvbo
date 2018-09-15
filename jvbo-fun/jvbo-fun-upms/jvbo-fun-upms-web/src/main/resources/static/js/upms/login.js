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
	if(!username){
		$("#warn").text("请填写用户名");
		return false;
	}
	if(!password){
		$("#warn").text("请填写密码");
		return false;
	}
	ajaxPost("/login", {"username": username, "password": password}, function (repData) {
		if(repData.code != 200 || repData.data != "true"){
			$("#warn").text(repData.msg);
			return false;
		}else{
			window.location.href = '/index';
		}
	});
	return false;
}