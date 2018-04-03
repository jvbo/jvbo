##set($layout = "/layout/front.vm")
<script type="text/javascript">
$(function(){
	$.extend($.fn.validatebox.defaults.rules, {    
    	equals: {    
        	validator: function(value,param){    
            	return value == $(param[0]).val();    
        	},    
        	message: '两次输入密码必须一致'   
    	} 
	}); 
});
</script>
 <form id="myform" style="margin: 50px;">
    <input type="hidden" name="id" value="$!{vo.id}"/>
    <table style="font-size: 12px;" cellspacing="6" width="100%">
    	<tbody>
    		#if($mark == 1)
    				<tr>
    					<td>登录名：</td>
    					<td>$!{vo.loginName}</td>
    				</tr>
    				<tr>
    					<td>真实姓名：</td>
    					<td>$!{vo.userName}</td>
    				</tr>
    			#else
    				<tr>
    					<td>登录名：</td>
    					<td><input type="text" name="loginName" value="$!{vo.loginName}" class="easyui-validatebox" data-options="required:true" /> </td>
    				</tr>
    				<tr>
    					<td>真实姓名：</td>
    					<td><input type="text" name="userName" value="$!{vo.userName}" /> </td>
    				</tr>
    				<tr>
    					<td>登录密码：</td>
    					<td><input type="password" id="pwd1" name="passWord" value="$!{vo.passWord}" class="easyui-validatebox" data-options="required:true"/> </td>
    				</tr>
    				<tr>
    					<td>确认密码：</td>
    					<td><input type="password" id="pwd2" value="$!{vo.passWord}" class="easyui-validatebox" required="required" validType="equals['#pwd1']" /> </td>
    				</tr>
    			#end
    	</tbody>
    </table>
    </form>