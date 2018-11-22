/**
 * Created by jvbo
 */

var AJAX_TIMEOUT = 10000;

/*function ajax(type, url, reqData, callback, async) {
	var ajaxObj = $.ajax({
		type: type,
		url: url,
		dataType: 'JSON',
		data: reqData,
		async: async == undefined ? true : async,
		timeout: AJAX_TIMEOUT,
		beforeSend: function (XMLHttpRequest) {
			// TODO
		},
		complete: function (XMLHttpRequest, textStatus) {
			// TODO
		},
		success: function(repData){
			console.info(repData);
			return repData;
		},
		error: function (XMLHttpRequest, textStatus, errorThrown) {
			console.log(XMLHttpRequest.status);
			console.log(XMLHttpRequest.readyState);
			console.log(textStatus);
		}
	});
	return ajaxObj;
}*/

function ajax(type, url, reqData, callback, async) {
	var ajaxObj = $.ajax({
		type: type,
		url: url,
		dataType: 'JSON',
		data: reqData,
		async: async == undefined ? true : async,
		timeout: AJAX_TIMEOUT,
		success: function (data) {
			if (data.code) {
				if (data.code === '200') {
					callback(null, data);
					return;
				}
				callback(data);
				return;
			}
			callback(null, data);
		},
		error: function (jqXHR, textStatus, errorThrown) {
			console.log(jqXHR);
			console.log(textStatus);
			console.log(errorThrown);
			var obj = {};
			callback(obj);
		}
	});
	return ajaxObj;
}

function ajaxGet(url, data, callback, async) {
	return ajax('GET', url, data, callback, async);
}

function ajaxPost(url, data, callback, async) {
	return ajax('POST', url, data, callback, async);
}

function ajaxPut(url, data, callback) {
	ajax('PUT', url, data, callback);
}

function ajaxDelete(url, data, callback) {
	ajax('DELETE', url, data, callback);
}