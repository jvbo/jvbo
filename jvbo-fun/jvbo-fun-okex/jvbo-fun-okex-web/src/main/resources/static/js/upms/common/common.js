/**
 * Created by jvbo
 */

$.fn.serializeObject = function()
{
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [o[this.name]];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};



/**
 * 列表
 * @param url
 * @param title
 * @param columns
 * @param toolbar
 */
function initDatagrid(url,title,columns,toolbar){
	url=ctx+url;
	$("#tab").datagrid({
		url : url,
		method: 'POST',
		title : title,
		height : '545',
		idField : 'id', //在删除的时候，可以翻页选择，框架能知道选了哪些
		pagination:true,
		frozenColumns : [ [ // 和列的特性一样，但是这些列将被冻结在左边。
			{
				field : 'id',
				checkbox : true
			} ] ],
		columns : columns,
		toolbar:toolbar
	});
}
function initDatagrids(tname,url,title,columns){
	url=ctx+url;
	$("#"+tname).datagrid({
		url : url,
		method: 'POST',
		title : title,
		width : '600',
		height : '450',
		idField : 'id', //在删除的时候，可以翻页选择，框架能知道选了哪些
		pagination:true,
		frozenColumns : [ [ // 和列的特性一样，但是这些列将被冻结在左边。
			{
				field : 'id',
				checkbox : true
			} ] ],
		columns : columns
	});
}
/**
 * 树形列表
 * @param url
 * @param title
 * @param columns
 * @param treeField
 * @param toolbar
 * @param method
 */
function initTreegrid(url,title,columns,treeField,toolbar,method){

	$("#tab").treegrid({
		url:ctx+url,
		idField:'id',
		treeField:treeField,
		width : '979',
		height : '545',
		pagination:true,
		animate:true,
		singleSelect:false,
		onBeforeLoad:function(row){

			if(method!=undefined&&method!=null){
				method(row);
			}else{
				if(row){
					$(this).treegrid("options").url=ctx+url+"?id="+row.id;
				}else{
					$(this).treegrid("options").url=ctx+url;

				}
			}

		},
		frozenColumns : [ [ // 和列的特性一样，但是这些列将被冻结在左边。
			{
				field : 'id',
				checkbox : true
			} ] ],
		columns:columns
	});


}


/**
 * dialog
 * @param id
 * @param title
 * @param width
 * @param height
 * @param buttons
 */
function initDialog(id,title,width,height,buttons){
	$("#"+id).dialog({
		title:title,
		modal:true,
		closed:true,
		iconCls:'icons-application-application_add',
		width:width,
		height:height,
		buttons:buttons
	});
}


/**
 * 完成页面默认初始化操作
 * @param url
 */
var winWidth=400;
var winHeight=300;
function initPage(url,listName,winName,seeWinName,columns,buttons,seeButtons){
	initDatagrid(url+"index.ajax",listName,columns);

	if(typeof(IWidht)!="undefined"&&IWidht!=null){
		winWidth=IWidht;
	}
	if(typeof(IHeight)!="undefined"&&IHeight!=null){
		winHeight=IHeight;
	}

	if(buttons!=undefined&&buttons!=null)
		initDialog("win",winName,winWidth,winHeight,buttons);
	else{
		initDialog("win",winName,winWidth,winHeight,[{ text:'确定', iconCls:'icons-other-tick', handler:function(){  ISubmit("myform",url+"modify.ajax");}
		},
			{
				text:'取消',
				iconCls:'icons-arrow-cross',
				handler:function(){$('#win').dialog('close');}
			}]);
	}

	if(seeButtons!=undefined&&seeButtons!=null)
		initDialog("seeWin",seeWinName,winWidth,winHeight,seeButtons);
	else{
		initDialog("seeWin",seeWinName,winWidth,winHeight,[{text:"关闭",iconCls:'icons-arrow-cross',handler:function(){$('#seeWin').dialog('close');}}]);
	}

	$("#search").click(function(){
		$("#tab").datagrid("load",$("#queryForm").serializeObject());
	});

	$("#add").click(function(){
		IAdd("win",url+"modify.ajax");
	});

	$("#edit").click(function(){
		IModify(url+"modify.ajax")
	});

	$("#remove").click(function(){
		IRemove(url+"remove.ajax");
	});

	$("#see").click(function(){
		ISee("seeWin",url+"modify.ajax");
	});
}

/**
 * sys submit
 * @param id
 * @param url
 */
function ISubmit(id,url,method){
	if($("#"+id).form("validate")){

		if(typeof(window.editor)!="undefined"){
			window.editor.sync();
		}

		var data= ajaxPost(url,$("#"+id).serialize());
		if(method==undefined){
			if(data.success){
				$.messager.alert("系统提示","操作成功");
				$("#win").dialog("close");
				$("#tab").datagrid("reload");
				$("#tab").datagrid("clearSelections");
			}else{
				if(repeat!=undefined&&repeat==1&&data.mark==-1){
					$.messager.alert("系统提示",repeatContent+"已存在");
				}else{
					$.messager.alert("系统提示","操作失败");
				}
			}

		}else{
			method(data);
		}
	}
}

/**
 * sys modify
 */
function IModify(url){
	var rows=$("#tab").datagrid("getSelections");
	if(rows.length<1){
		$.messager.alert("系统提示","请选择要修改的信息");
	}else if(rows.length>1){
		$.messager.alert("系统提示","一次只能修改一条信息");
	}else{
		$("#win").dialog("refresh",ctx+url+"?id="+rows[0].id);
		$("#win").dialog("open");
	}
}

function IAdd(id,url){
	$("#"+id).dialog("refresh",ctx+url);
	$("#"+id).dialog("open");
}


function IRemove(url,method){
	var rows=$("#tab").datagrid("getSelections");
	if(rows.length<1){
		$.messager.alert("系统提示","请选择要删除的信息");
		//return null;
	}else{
		var str="条";
		if(rows.length>1)
			str="些";
		$.messager.confirm("系统提示","您确定要删除这"+str+"信息吗?",function(t){
			if(t){
				var arr = new Array();
				for (var i = 0; i < rows.length; i++) {
					arr.push(rows[i].id);
				}
				$("#tab").datagrid("clearSelections");
				var data=ajaxPost(url,{ids:arr});

				if(method==undefined){
					if(data!=undefined&&data!=null){
						if(IMsuccess(data.success)){
							$("#tab").datagrid("reload");
						}
					}
				}else{
					method(data);
				}


			}else{
				//return null;
			}
		});

	}

}

function ISee(id,url){
	var rows=$("#tab").datagrid("getSelections");
	if(rows.length<1){
		$.messager.alert("系统提示","请选择查看的信息");
	}else if(rows.length>1){
		$.messager.alert("系统提示","一次只能查看一条信息");
	}else{
		$("#"+id).dialog("refresh",ctx+url+"?mark=1&id="+ rows[0].id);
		$("#"+id).dialog("open");
	}
}

function IMsuccess(type){
	if(type)
		$.messager.alert("系统提示","操作成功");
	else{
		$.messager.alert("系统提示","操作失败");
	}
	return type;
}



/**
 * ------
 */
var IOBJ=null;
var apc=0;
function IUploadImg(obj){
	apc=0;
	IOBJ=$(obj);
	$('#file').click();
}
function appendImgsm(){
	apc=1;
	$('#file').click();
}

function upload(obj){
	fileUpload(obj,function(data){
		if(data.success){
			if(apc==0){
				IOBJ.attr("src",data.url);
				IOBJ.prev().val(data.url);
			}else{
				$("#appendImg").before('<span><input type="hidden" value="'+data.url+'" name="imgsm"/>'+
					'<img id="img" src="'+data.url+'" width="120px" height="120px;" onclick="IUploadImg(this)" ></span>');
			}
		}else{
			$.messager.alert("系统提示","上传失败");
		}
	});
}

function Ialert(value){
	$.messager.alert("系统提示",value);
}



