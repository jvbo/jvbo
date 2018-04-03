/**
 * 
 */
var zeroData = '<tr><td align="center" colspan="10">没有可显示的内容</td></tr>';
function loading() {
    //$.blockUI({message: '<img src="' + base + '/images/large-loading.gif" alt=\"请等待，正在加载数据...\">'});
}

function unloading() {
    //$.unblockUI();
}

function getUrlVars(url) {
    var vars = {};
    url.replace(/[?&]+([^=&]+)=([^&]*)/gi,
        function(m,key,value) {
            vars[key] = value;
        });
    return vars;
}

/**
 * 首页加载完后
 */
$(document).ready(function () {
    //ajax menu link
    $('a.ajax-link').click(function (e) {
        e.preventDefault();
        var $this = $(this);
        var href = $this.attr("href");
        var params = getUrlVars(href);
        $.ajax({
            type: "POST",
            dataType: "html",
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            async: false,
            cache: false,
            url: encodeURI(encodeURI(href))+'?_='+new Date().getTime().toString(),
            beforeSend: function (request) {
                loading();
            },
            complete: function () {
                unloading();
            },
            success: function (msg) {
                $("#content").html(msg);
            }
        });
    });
});

/**
 * ajax请求url替换div content
 * @param url 请求地址
 * @param data 参数
 * @param callback 回调
 */
function ajaxContent(url, data) {
    $("#content").attr('url', '');
    if (!url) {
        return;
    }
    $.ajax({
        type: "POST",
        url: encodeURI(encodeURI(url)),
        data: data,
        dataType: "html",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        async: false,
        cache: false,
        beforeSend: function (request) {
            loading();
        },
        success: function (returnData) {
            $("#content").html(returnData);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            // 这个方法有三个参数：XMLHttpRequest 对象，错误信息，（可能）捕获的错误对象。
            // 通常情况下textStatus和errorThown只有其中一个有值
            console.log(XMLHttpRequest.status);
            console.log(XMLHttpRequest.readyState);
            console.log(textStatus);
            alert("请求出现错误！");
        },
        complete: function (XMLHttpRequest, textStatus) {
            // 请求完成后回调函数 (请求成功或失败时均调用)。参数： XMLHttpRequest 对象，成功信息字符串。
            // 调用本次AJAX请求时传递的options参数
            unloading();
        }
    });
}

function delContent(url) {
    confirm("删除后无法恢复,确定删除吗?",function(){
        ajaxContent(url);
    });
}
/**
 * 重要操作提示
 * @param msg 提示文字
 * @param callback 回调
 */
function confirm(msg, callback) {
    var d = dialog({
        title: '操作提示',
        content: msg,
        zIndex:9999,
        okValue: '确定',
        ok: callback,
        cancelValue: '关闭',
        cancel: function () {
        }
    });
    d.show();
    console.log(this);
}


function ajaxBoxForm(divId, formId, callback) {
    $("#" + formId).ajaxSubmit({
        cache: false,
        success: function (data) {
            if (data != "") {
                $("#" + divId).parent().html(data);
            }
            //扩展回调函数
            if (callback != null) {
                callback();
            }
        }
    });
}

/**
 * ajax提交form替换content
 * @param divId 返回替换div
 * @param formId 提交formid
 * @param callback 回调
 */
function ajaxForm(divId, formId, callback) {
    $("#" + formId).ajaxSubmit({
        cache: false,
        beforeSubmit: function (request) {
            loading();
        },
        complete: function (XMLHttpRequest, textStatus) {
            unloading();
        },
        success: function (data) {
            if (data != "") {
                $("#" + divId).html(data);
            }
            //扩展回调函数
            if (callback != null) {
                callback();
            }
        }
    });
}

/**
 * ajax请求url替换指定div
 * @param shade 是否开启遮罩层
 * @param divId 返回替换div
 * @param url 请求地址
 * @param data 参数
 * @param callback 回调
 */
function ajaxDiv(shade, divId, url, data, callback) {
    $.ajax({
        type: "post",
        url: encodeURI(encodeURI(url)),
        data: data,
        dataType: "html",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        async: false,
        cache: false,
        beforeSend: function (request) {
            if (shade) {
                loading();
            }
        },
        success: function (returnData) {
            $("#" + divId).html(returnData);
            //扩展回调函数
            if (callback != null) {
                callback();
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("请求出现错误！");
        },
        complete: function (XMLHttpRequest, textStatus) {
            if (shade) {
                unloading();
            }
        }
    });
}

/**
 * ajax请求url替换DiaLog
 * @param url 请求地址
 * @param data 参数
 * @param callback 回调
 */
function ajaxDiaLog(url, data) {
    //loading();
    $("#content").attr('url', '');
    $.ajax({
        type: "post",
        url: encodeURI(encodeURI(url)),
        data: data,
        dataType: "html",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        async: false,
        cache: false,
        beforeSend: function (request) {
            loading();
        },
        error: function () {
            alert("服务器请求失败!");
        },
        success: function (returnData) {
            var u;
            (data == undefined) ? u = undefined : u = JSON.stringify(data);
            $("#content").attr('url', u);
            var modal = $('#myModal');
            //var modalContent=$("#modalContent");
            modal.html(returnData);
            modal.modal("show");
            $('#myModal').off('hidden.bs.modal');
            $('#myModal').on('hidden.bs.modal', function (e) {
                $('#myModal').empty();
            });
        },
        complete: function () {
            unloading();
        }
    });
}

function closeAjaxDiaLog() {
    $('#myModal').modal('hide');
}

//分页组件
function loadPagingBar(options) {
    this.defaults = {
        total: 0,
        currentPage: 1,
        callback: null,
        visiblePages: 7,
        id: "#widget_pagination"
    };
    var data = $.extend(this.defaults, options);
    pageWrap = $(data.id);
    pageWrap.html('');
    pageWrap.html('<ul class="pagination pagination-sm no-margin pull-right" id="pager-ext" ></ul>');
    pageWrap.find('#pager-ext').twbsPagination({
        totalPages: data.total,
        visiblePages: data.visiblePages,
        startPage: data.currentPage,
        first: '第一页',
        prev: '上一页',
        next: '下一页',
        last: '最后页',
        onPageClick: function (event, page) {
            if(data.currentPage!=page){
            	console.log("data.currentPage:"+data.currentPage+"===page:"+page);
            	data.callback(page);
            }
        }
    });
}

var Common = {
    showPageCount: function (opt) {
        this.defaults = {
            dom: "",
            count: ""
        };
        var opts = $.extend(this.defaults, opt);
        var html= '<div class="col-xs-6 pull-left" style="margin-left: 10px;">总共<span style="color: #f00;" id="J_dataCount">'+opts.count+'</span>条记录</div>';
        $(opts.dom).html(html);
    },
    showPagingBar: function (total, page, pages, callback) {
        this.showPageCount({dom: '#J_pageCount', count: total});
        if (pages > 0) {
            loadPagingBar({
                total: pages,
                currentPage: page,
                callback: callback
            });
        }else{
            $('#widget_pagination').hide();
        }
    }
};

function postFun(url, data, handle) {
    $.ajax({
        type: 'POST',
        url: url,
        data: data,
        dataType: 'json',
        success: function (reply) {
            if (handle) {
                if (reply) {
                	handle(reply.total, reply.page, reply.pages,reply.rows, reply.info);
                } else {
                	handle(null, null, null, null, '系统异常,无返回!');
                }
            }
        },
        error: function (xhr, type) {
            alert('服务器连接失败!')
            console.error("ajax error",url, xhr, type);
        }
    })
}