/**
 * Created by jvbo
 */

function logout(){
	// TODO 退出前前端可以做一些操作
	ajaxGet("/sso/logout", {}, function (repData) {
		if(repData.code != 200){
			// TODO
			console.info(repData);
		}else{
			window.location.href="/sso/login";
		}
	});
}