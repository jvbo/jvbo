var appkey = "";
$('input[name="go"]').click(function(){
    appkey=$('input[name="appkey"]').val();
    loadclass(0,0);
});
var proclass = -1;
$('.s1').on('change','select[name="sel"]',function(){
    var can = $(this).find("option:selected").attr("isLeaf");
    var id = $(this).val();
    if (id >= -1) {
        $('select[name="se2"]').html('');
        $('select[name="se3"]').html('');
        $('select[name="se4"]').html('');
        $('select[name="se5"]').html('');
        if (can == "false") {
            loadclass(id, 1);
        } else {
            proclass = id;
            $('.add-info-button').show();
            $('.s2').hide();
            $('.s3').hide();
            $('.s4').hide();
            $('.s5').hide();
        }
    }else {
        $('.s2').hide();
        $('.s3').hide();
        $('.s4').hide();
        $('.s5').hide();
    }
});
$('.s2').on('change','select[name="se2"]',function(){
    var can = $(this).find("option:selected").attr("isLeaf");
    var id = $(this).val();
    if (id >= -1) {
        $('select[name="se3"]').html('');
        $('select[name="se4"]').html('');
        $('select[name="se5"]').html('');
        if (can == "false") {
            loadclass(id, 2);
        } else {
            proclass = id;
            $('.add-info-button').show();
            $('.s3').hide();
            $('.s4').hide();
            $('.s5').hide();
        }
    }else {
        $('.s3').hide();
        $('.s4').hide();
        $('.s5').hide();
    }
});
$('.s3').on('change','select[name="se3"]',function(){
    var can = $(this).find("option:selected").attr("isLeaf");
    var id = $(this).val();
    if (id >= -1) {
        $('select[name="se4"]').html('');
        $('select[name="se5"]').html('');
        if (can == "false") {
            loadclass(id, 3);
        } else {
            proclass = id;
            $('.add-info-button').show();
            $('.s4').hide();
            $('.s5').hide();
        }
    }else {
        $('.s4').hide();
        $('.s5').hide();
    }
});
$('.s4').on('change','select[name="se4"]',function(){
    var can = $(this).find("option:selected").attr("isLeaf");
    var id = $(this).val();
    if (id >= -1) {
        $('select[name="se5"]').html('');
        if (can == "false") {
            loadclass(id, 4);
        } else {
            proclass = id;
            $('.add-info-button').show();
            $('.s5').hide();
        }
    }else {
        $('.s5').hide();
    }
});
function loadclass(id,num){
    var Url = "https://gw.open.1688.com/openapi/param2/1/com.alibaba.product/alibaba.category.get/"+appkey+"?categoryID="+id+"&webSite=1688";
    $.ajax({
        type: "get",
        url: Url,
        async: 'false',
        dataType: 'json',
        beforeSend: function () {
        },
        error: function () {
        },
        success: function (e) {
            var JsonVal = e["categoryInfo"][0]["childIDs"];
            var htmlt ="";
            for(var i = 0;i<JsonVal.length;i++){
                var nextid= JsonVal[i];
                var Url1 = "https://gw.open.1688.com/openapi/param2/1/com.alibaba.product/alibaba.category.get/"+appkey+"?categoryID="+nextid+"&webSite=1688";
                $.ajax({
                    type: "get",
                    url: Url1,
                    async: 'false',
                    dataType: 'json',
                    beforeSend: function () {
                    },
                    error: function () {
                    },
                    success: function (n) {
                        var JsonVal1 = n["categoryInfo"][0];
                        var isLeaf="";
                        htmlt="<option isLeaf='"+JsonVal1["isLeaf"]+"' value='"+JsonVal1["categoryID"]+"'>"+JsonVal1['name']+"</option>";
                        if(num == 0){
                            $('.s1').show();
                            $('.s2').hide();
                            $('.s3').hide();
                            $('.s4').hide();
                            $('.s4').hide();
                            $('select[name="sel"]').append(htmlt);
                        }
                        if(num == 1){
                            $('.s2').show();
                            $('.s3').hide();
                            $('.s4').hide();
                            $('.s4').hide();
                            $('select[name="se2"]').append(htmlt);
                        }
                        if(num == 2){
                            $('.s3').show();
                            $('.s4').hide();
                            $('select[name="se3"]').append(htmlt);
                        }
                        if(num == 3){
                            $('.s4').show();
                            $('.s5').hide();
                            $('select[name="se4"]').append(htmlt);
                        }
                        if(num == 4){
                            $('.s5').show();
                            $('select[name="se5"]').append(htmlt);
                        }
                    }
                });
            }
        }
    });
}

$('input[name="add"]').click(function(){
    loadCategoryAttribute(proclass);
});