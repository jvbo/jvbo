<#import "/freemarker/layout/admin.ftl" as admin>
<@admin.admin>
<body class="gray-bg">
    <div class="col-sm-12">
        <!-- Example Toolbar -->
        <div class="example-wrap">
            <div class="example">
                <div class="btn-group hidden-xs" id="exampleToolbar" role="group">
                    <div id="toolbar">
                        <form id="queryForm">
                            <button id="add" type="button" class="btn btn-outline btn-default">
                                <i class="glyphicon glyphicon-plus" aria-hidden="true">添加</i>
                            </button>
                            <button id="edit" type="button" class="btn btn-outline btn-default">
                                <i class="glyphicon glyphicon-pencil" aria-hidden="true">编辑</i>
                            </button>
                            <button id="remove" type="button" class="btn btn-outline btn-default">
                                <i class="glyphicon glyphicon-trash" aria-hidden="true">删除</i>
                            </button>
                            <button id="find" type="button" class="btn btn-outline btn-default">
                                <i class="glyphicon glyphicon-search" aria-hidden="true">查看</i>
                            </button>
                            <input  placeholder="登录名" name="loginName" id="loginName" style="margin-top: 1px;" />
                            <button id="search" type="button" class="btn btn-outline btn-default">
                                <i class="glyphicon glyphicon-search" aria-hidden="true">搜索</i>
                            </button>
                        </form>
                    </div>
                </div>
                <table id="tb" class="table table-striped table-bordered table-hover dataTables-example"></table>
            </div>
        </div>
        <!-- End Example Toolbar -->
    </div>
    <!-- 添加 -->
    <div class="modal inmodal fade" id="addModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title">添加</h4>
                    <small class="font-bold">这里可以显示副标题。
                </div>
                <div class="modal-body">
                    <p><strong>H+</strong>
                                        是一个完全响应式，基于Bootstrap3.3.6最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术，她提供了诸多的强大的可以重新组合的UI组件，并集成了最新的jQuery版本(v2.1.1)，当然，也集成了很多功能强大，用途广泛的jQuery插件，她可以用于所有的Web应用程序，如网站管理后台，网站会员中心，CMS，CRM，OA等等，当然，您也可以对她进行深度定制，以做出更强系统。
                    </p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary">保存</button>
                </div>
            </div>
        </div>
    </div>
    <!-- 编辑 -->
    <div class="modal inmodal fade" id="modifyModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title">添加</h4>
                    <small class="font-bold">这里可以显示副标题。
                </div>
                <div class="modal-body">
                    <p><strong>H+</strong>
                                        是一个完全响应式，基于Bootstrap3.3.6最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术，她提供了诸多的强大的可以重新组合的UI组件，并集成了最新的jQuery版本(v2.1.1)，当然，也集成了很多功能强大，用途广泛的jQuery插件，她可以用于所有的Web应用程序，如网站管理后台，网站会员中心，CMS，CRM，OA等等，当然，您也可以对她进行深度定制，以做出更强系统。
                    </p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary">保存</button>
                </div>
            </div>
        </div>
    </div>
    
    <!-- 查看 -->
    <div class="modal inmodal fade" id="findModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title">添加</h4>
                    <small class="font-bold">这里可以显示副标题。
                </div>
                <div class="modal-body">
                    <p><strong>H+</strong>
                                        是一个完全响应式，基于Bootstrap3.3.6最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术，她提供了诸多的强大的可以重新组合的UI组件，并集成了最新的jQuery版本(v2.1.1)，当然，也集成了很多功能强大，用途广泛的jQuery插件，她可以用于所有的Web应用程序，如网站管理后台，网站会员中心，CMS，CRM，OA等等，当然，您也可以对她进行深度定制，以做出更强系统。
                    </p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary">保存</button>
                </div>
            </div>
        </div>
    </div>
</body>
<script>
$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb').empty();
        $('#tb').bootstrapTable('destroy').bootstrapTable({
            url: ctx + '/sys/user/index', //请求后台的URL（*）
            method: 'post', //请求方式（*）
            toolbar: '#toolbar', //工具按钮用哪个容器
            striped: true, //是否显示行间隔色
            cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true, //是否显示分页（*）
            sortable: false, //是否启用排序
            sortOrder: "asc", //排序方式
            contentType: "application/x-www-form-urlencoded",
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1, //初始化加载第一页，默认第一页
            pageSize: 10, //每页的记录行数（*）
            pageList: [10, 25, 50, 100], //可供选择的每页的行数（*）
            search: false, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true, //是否显示所有的列
            showRefresh: true, //是否显示刷新按钮
            minimumCountColumns: 2, //最少允许的列数
            clickToSelect: true, //是否启用点击选中行
            //height: 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id", //每一行的唯一标识，一般为主键列
            showToggle:true, //是否显示详细视图和列表视图的切换按钮
            cardView: false, //是否显示详细视图
            detailView: false, //是否显示父子表
            columns: [
                {checkbox: true},
                {field: 'loginName',title: '登录名'},
                {field: 'userName',title: '真实姓名'},
                {field: 'addTime',title: '添加时间'},
                {field: 'updTime',title: '排序'}
            ],
            onLoadSuccess: function (data) {
                //加载成功时执行
                //console.log(data);
            },
            onLoadError: function (res) {
                //加载失败时执行
                console.warn(res);
            }
        });
    };
    
    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            rows: params.limit, //页面大小
            page: Math.ceil(params.offset / params.limit) + 1, //页码
            loginName: $("#loginName").val()
        };
        return temp;
    };
    
    return oTableInit;
};

var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};
    oInit.Init = function () {
    //初始化页面上面的按钮事件
    };
    return oInit;
};
</script>
</@admin.admin>
