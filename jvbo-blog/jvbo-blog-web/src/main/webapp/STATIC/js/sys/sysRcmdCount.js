	//-----列
	  		var columns=[[
	  			{field:'loginName',title:'登录名' },
	  			{field:'userName',title:'真实姓名'},
	  			{field:'phone',title:'联系电话'},
	  			{field:'vocation',title:'所属行业'},
	  			{field:'userIdentity',title:'用户身份'},
	  			{field:'level',title:'会员等级'},
	  			{field:'addTime',title:'注册时间'},
	  			{field:'num',title:'推荐总数'},
	  			{field:'userId',title:'操作',formatter:function(value,row,index){
	  				var str="<a href=javascript:void(0); onclick=viewJf('"+value+"')>查看详情</a>";
	  				return str;
	  			}}
	  		]];
	  		var seeButtons=[{text:"关闭",iconCls:'icons-arrow-cross',handler:function(){$('#seeWin').dialog('close');}}];
	  		
	  		function viewJf(id){
//	  			location.href=ctx+"/sys/rcmd/getRcmdDtl.html?id="+id;
	  			
	  			$("#seeWin").dialog("refresh",ctx+"/sys/rcmd/getRcmdDtl.html?id="+id);
	  			$("#seeWin").dialog("open");
	  		}
	  		
	  		var seeButtons=[{text:"关闭",iconCls:'icons-arrow-cross',handler:function(){$('#seeWin').dialog('close');}}];
	  		
	  		//---初始化
	  		function init(){
	  			initDatagrid("/sys/rcmd/index.ajax","推荐数据统计",columns);
	  			initDialog("seeWin","推荐详情",600,400,seeButtons);
	  		}
	  		
	  		$(function(){
	  			init();
	  		});