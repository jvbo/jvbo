/**
 * Created by jvbo
 */

$(function(){
	_menus=ajaxPost("/sys/menuList");
	InitLeftMenu();
	tabClose();
	tabCloseEven();
});



//初始化左侧
function InitLeftMenu() {
	$.each(_menus.menus, function(i, n) {//$.each 遍历_menu中的元素
		var menulist ='';
		menulist +='<ul>';
		$.each(n.childenManus, function(j, o) {
			menulist += '<li><div><a ref="'+o.id+'" href="javascript:void(0);" rel="' + ctx + o.url + '" ><span class="icon icon-log" >&nbsp;</span><span class="nav">' + o.name + '</span></a></div></li> ';
		});
		menulist += '</ul>';

		$('#nav').accordion('add', {
			title: n.name,
			content: menulist,
			iconCls: 'icon icon-log'
		});

	});

	$('.easyui-accordion li a').click(function(){//当单击菜单某个选项时，在右边出现对用的内容
		var tabTitle = $(this).children('.nav').text();//获取超链里span中的内容作为新打开tab的标题

		var url = $(this).attr("rel");
		var id = $(this).attr("ref");//获取超链接属性中ref中的内容
		var icon = getIcon(id,icon);

		addTab(tabTitle,url,icon);//增加tab
		$('.easyui-accordion li div').removeClass("selected");
		$(this).parent().addClass("selected");
	}).hover(function(){
		$(this).parent().addClass("hover");
	},function(){
		$(this).parent().removeClass("hover");
	});

	//选中第一个
	var panels = $('#nav').accordion('panels');
	var t = panels[0].panel('options').title;
	$('#nav').accordion('select', t);
}
//获取左侧导航的图标
function getIcon(id){
	var icon = 'icon icon-log';
	/*$.each(_menus.menus, function(i, n) {
	 $.each(n.childenManus, function(j, o) {
	 if(o.id==id){
	 icon += o.icon;
	 }
	 })
	 })*/

	return icon;
}

function addTab(subtitle,url,icon){
	if(!$('#tabs').tabs('exists',subtitle)){
		$('#tabs').tabs('add',{
			title:subtitle,
			content:createFrame(url),
			closable:true,
			icon:icon
		});
	}else{
		$('#tabs').tabs('select',subtitle);
		$('#mm-tabupdate').click();
	}
	tabClose();
}

function createFrame(url)
{
	var s = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	return s;
}

function tabClose()
{
	/*双击关闭TAB选项卡*/
	$(".tabs-inner").dblclick(function(){
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close',subtitle);
	})
	/*为选项卡绑定右键*/
	$(".tabs-inner").bind('contextmenu',function(e){
		$('#mm').menu('show', {
			left: e.pageX,
			top: e.pageY
		});

		var subtitle =$(this).children(".tabs-closable").text();

		$('#mm').data("currtab",subtitle);
		$('#tabs').tabs('select',subtitle);
		return false;
	});
}
//绑定右键菜单事件
function tabCloseEven()
{
	//刷新
	$('#mm-tabupdate').click(function(){
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		$('#tabs').tabs('update',{
			tab:currTab,
			options:{
				content:createFrame(url)
			}
		})
	})
	//关闭当前
	$('#mm-tabclose').click(function(){
		var currtab_title = $('#mm').data("currtab");
		$('#tabs').tabs('close',currtab_title);
	})
	//全部关闭
	$('#mm-tabcloseall').click(function(){
		$('.tabs-inner span').each(function(i,n){
			var t = $(n).text();
			$('#tabs').tabs('close',t);
		});
	});
	//关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function(){
		$('#mm-tabcloseright').click();
		$('#mm-tabcloseleft').click();
	});
	//关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function(){
		var nextall = $('.tabs-selected').nextAll();
		if(nextall.length==0){
			//msgShow('系统提示','后边没有啦~~','error');
			alert('后边没有啦~~');
			return false;
		}
		nextall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});
	//关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function(){
		var prevall = $('.tabs-selected').prevAll();
		if(prevall.length==0){
			alert('到头了，前边没有啦~~');
			return false;
		}
		prevall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});

	//退出
	$("#mm-exit").click(function(){
		$('#mm').menu('hide');
	})
}

//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function msgShow(title, msgString, msgType) {
	$.messager.alert(title, msgString, msgType);
}
