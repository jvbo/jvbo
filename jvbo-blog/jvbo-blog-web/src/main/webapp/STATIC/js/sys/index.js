
	$(function(){
  		_menus=ajaxPost("/sys/menuList.ajax");
  		InitLeftMenu();
  		tabClose();
		tabCloseEven();
  	});