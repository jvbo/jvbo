
/**
 * ajax
 */
function ajax(type, url, params, dataType, isAsync){
	if(dataType == undefined || dataType == null){
		dataType='json';
	}
    if(isAsync == undefined || isAsync == null){
        isAsync = false;
    }
	var returnVal = null;
	$.ajax({
		type: type,
		url: ctx+url,
		cache: false,
        async: isAsync,
        data: params,
        dataType: dataType,
        timeout: 30000,
        success:function(data){
        	returnVal=data;
        }
	});
	return returnVal;
	
}

var ajaxGet = function(url, params, dataType, isAsync){
    return ajax('GET', url, params, dataType, isAsync);
}

var ajaxPost = function(url, params, dataType, isAsync) {
  return ajax('POST', url, params, dataType, isAsync);
}

var ajaxPut = function(url, params, dataType, isAsync) {
  return ajax('PUT', url, params, dataType, isAsync);
}

var ajaxDelete = function(url, params, dataType, isAsync) {
  return ajax('DELETE', url, params, dataType, isAsync);
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

