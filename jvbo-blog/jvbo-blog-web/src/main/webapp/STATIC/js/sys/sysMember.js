	//-----列
	  		var columns=[[
	  			{field:'loginName',title:'登录名' },
	  			{field:'userName',title:'真实姓名'},
	  			{field:'phone',title:'联系电话'},
	  			{field:'vocation',title:'所属行业'},
	  			{field:'userIdentity',title:'用户身份'},
	  			{field:'level',title:'会员等级'},
	  			{field:'local',title:'地域'},
	  			{field:'addTime',title:'注册时间'}
	  			/*{field:'userId',title:'操作',formatter:function(value,row,index){
	  				var str="<a href=javascript:void(0); onclick=viewJf('"+value+"')>查看会员详情</a>";
	  				return str;
	  			}}*/
	  		]];
	  		
	  		function viewJf(id){
	  			alert('会员详情'+id);
	  			//location.href=ctx+"/sys/member/pointIndex.html?memberId="+id;
	  		}
	  		
	  		//---按钮
	  		var buttons=[{
		  		text:'确定',
		  		iconCls:'icons-other-tick',
		  		handler:function(){ 
		  			ISubmit("myform","/sys/member/modify.ajax",null,function(data){
		  				if(data.success){
		  					$.messager.alert("系统提示","操作成功");
		  					$("#tab").datagrid("reload");
			  			}else{
			  				if(data.mark==-1){
			  					$.messager.alert("系统提示","登录名已存在");
			  				}else{
			  					$.messager.alert("系统提示","操作失败");
			  				}
			  			}
		  			});
		  		}
	  		},
    		{
	    		text:'取消',
	    		iconCls:'icons-arrow-cross',
	    		handler:function(){$('#win').dialog('close');}
    		}];
	  		
	  		
	  		var seeButtons=[{text:"关闭",iconCls:'icons-arrow-cross',handler:function(){$('#seeWin').dialog('close');}}];
	  		
	  		//---初始化
	  		function init(){
	  			initDatagrid("/sys/member/index.ajax?"+$("#queryForm").serialize(),"会员列表",columns);
	  			initDialog("win","会员信息",400,300,buttons);
	  			initDialog("seeWin","会员信息",400,300,seeButtons);
	  			
	  			$("#add").click(function(){
	  				$("#win").dialog("refresh",ctx+"/sys/member/modify.ajax");
					$("#win").dialog("open");
	  			});
	  			
	  			$("#edit").click(function(){
	  				IModify("/sys/member/modify.ajax")
	  			});
	  			
	  			$("#remove").click(function(){
	  				IRemove("/sys/member/remove.ajax");
	  				
	  			});
	  			
	  			$("#see").click(function(){
	  				ISee("seeWin","/sys/member/modify.ajax");
	  			});
	  			
	  			$("#search").click(function(){
	  				initDatagrid("/sys/member/getMemberList.ajax?"+$("#queryForm").serialize(),"会员列表",columns);
	  			});
	  		}
	  		
	  		$(function(){
	  			//init();
	  			initPage("/sys/member/","会员列表","会员信息","会员信息",columns);
	  			$("#vocation").combobox({
	  			    url:ctx+"/sys/vocation/getVacation.ajax",    
	  			    valueField:"id",    
	  			    textField:"name"
	  			});
	  		});