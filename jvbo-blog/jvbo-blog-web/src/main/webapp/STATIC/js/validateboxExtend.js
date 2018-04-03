var phoneRes = /^1[3,5,8][0-9][0-9]{8}$/;//phone


$.extend($.fn.validatebox.defaults.rules,{
	length : {
		validator : function(value, param) {
			if (value.length < param[0] || value.length > param[1]) {
				return false;
			} else {
				return true;
			}
		},
		message : '请输入 {0} 到 {1} 位的 {2} '
	},
	equals : {
		validator : function(value, param) {
			if (value != $(param[0]).val()) {
				return false;
			} else {
				return true;
			}
		},
		message : '两次 {1} 不一致 '

	},phone : {
		validator : function(value, param) {
			if (!phoneRes.test(value))
				return false;
			else
				return true;
		},
		message : '请检查手机号码格式'

	}
	
});