$(function(){
	_menus = ajaxPost("/sys/menuList");
	InitLeftMenu();
});
//初始化左侧
function InitLeftMenu() {
	$.each(_menus.menus, function(i, n) {//$.each 遍历_menu中的元素
		var menulist ='';
		menulist += '<li><a href="#"><i class="fa fa-home"></i><span class="nav-label">'+n.name+'</span><span class="fa arrow"></span></a>';
		menulist += '<ul class="nav nav-second-level">';
		$.each(n.childenManus, function(j, o) {
			menulist += '<li><a class="J_menuItem" href="'+ ctx + o.url +'" data-index="'+ o.sort +'">' + o.name + '</a></li>';
		});
		menulist += '</ul>';
		menulist += '</li>';
		$('.nav-header').after(menulist);
	});
}