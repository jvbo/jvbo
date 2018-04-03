<!DOCTYPE html>
<html>
<head>
    <#include "/freemarker/control/common.ftl">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>后台管理系统 - 登录</title>
    <meta name="keywords" content="后台-登录">
    <meta name="description" content="后台-登录">
    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="${request.contextPath}/static/public/hplus/css/font-awesome.min93e3.css" rel="stylesheet">
    <link href="${request.contextPath}/static/public/hplus/css/animate.min.css" rel="stylesheet">
    <link href="${request.contextPath}/static/public/hplus/css/style.min862f.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>
                <h1 class="logo-name">Jvbo</h1>
            </div>
            <h3>欢迎使用Jvbo后台管理系统</h3>
            <form class="m-t" role="form" id="form" method="post">
                <div class="form-group">
                    <input type="email" class="form-control" name="loginName" id="username" placeholder="用户名" required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="passWord" id="password" placeholder="密码" required="">
                </div>
                <div class="input-group"> 
                    <input type="text" style="width:150px" class="form-control" name="code" id="code" size="4" placeholder="验证码" required="">
                    <span class="input-group-addon" style="padding: 0px;"><img style="width:105px;height:32px" id="code_img" align="top" onclick="changeCode()" src="$rc.contextPath/verifyCodeServlet" title="点击切换验证码"></span>
                </div>
                <div style="height:1px;margin:12px 0"></div>
                <button type="button" onclick="login()" class="btn btn-primary block full-width m-b">登 录</button>
                <p class="text-muted text-center"> <small>念念不忘</small>|必有反向</p>
            </form>
        </div>
    </div>
    <script src="${request.contextPath}/static/public/hplus/js/plugins/layer/layer.min.js"></script>
</body>

</html>
<script type="text/javascript">
$(function(){
    $('input:text:first').focus();
    $('form').keyup(function(event){
        if(event.keyCode ==13){
            login();
        }
    });
})
var changeCode = function(){
    var that = document.getElementById('code_img');
    that.src = that.src + '?' + Math.random();
}
var login = function(){
    if(!$('#username').val()){
        parent.layer.msg('请填写用户名');
        return false;
    }
    if(!$('#password').val()){
        parent.layer.msg('请填写密码');
        return false;
    }
    if(!$('#code').val()){
        parent.layer.msg('请填写验证码');
        return false;
    }
    $.post(ctx+'/VerifyCodeResultServlet',{c:$("#code").val()},function(data){
            if($.trim(data) == "false"){
                parent.layer.msg('验证码错误');
                return false;
            }else{
                $.ajax({
                    type: "post",
                    url: ctx+'/sys/login.ajax',
                    cache: false,
                    async: true,
                    data: $("#form").serialize(),
                    dataType: "json",
                    timeout: 30000,
                    beforeSend: function (XMLHttpRequest) {
                        // TODO
                    },
                    complete: function (XMLHttpRequest, textStatus) {
                        // TODO
                    },
                    success: function(data){
                        if(!data.success){
                            parent.layer.msg(data.message);
                            changeCode();
                        }else{
                            parent.layer.load(1, {shade: [0.1,'#fff'] /*0.1透明度的白色背景*/});
                            window.location.href = ctx+'/sys/index.htm';
                        }
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        console.log(XMLHttpRequest.status);
                        console.log(XMLHttpRequest.readyState);
                        console.log(textStatus);
                        parent.layer.msg('请求出现错误！');
                    }
                });
                /* $.post(ctx+'/sys/login.htm', $("#form").serialize(), function(data){
                    if(!data.success){
                        $.messager.alert('提示信息', data.message, 'error');
                        changeCode();
                    }else{
                        $.messager.progress({text:'加载中，请稍候...'});
                        window.location.href = ctx+'/sys/index.htm';
                    }
                },'json'); */
            }
    });
    return false;
}
</script>
