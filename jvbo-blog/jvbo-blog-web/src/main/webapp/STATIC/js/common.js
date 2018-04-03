
/**
 * ajax
 */
var ajaxPost=function(url,params,dataType){
	if(dataType==undefined||dataType==null){
		dataType='json';
	}
	
	var returnVal;
	$.ajax({
		type:"post",
		url:ctx+url,
		cache: false,
        async: false,
        data:params,
        dataType:dataType,
        timeout:30000,
        success:function(data){
        	returnVal=data;
        }
	});
	return returnVal;
	
}



function fileUpload(ob,method){
	
	ob=$(ob);
	$.ajaxfileupload({
		 url:ctx+"/file/uploadImgFile.ajax",
		 secureuri: false,
		 fileElementId:ob.attr("id"),
		 dataType:'json',
		 success:function(data){
			 if(method==undefined||method==null)
				 if(data.success){
					 $.messager.alert("系统提示","上传成功!");
				 }else{
					 $.messager.alert("系统提示","上传失败!");
				 }
			 else{
				 method(data);
			 }
		 },
		 error: function (data) {
    		$.messager.alert("系统提示","上传失败!");
		 }
	
	});

}

