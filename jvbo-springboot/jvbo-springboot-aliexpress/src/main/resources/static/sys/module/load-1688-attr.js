function loadCategoryAttribute(categoryID){
    //女士休闲裤:1031871
    //categoryID = 1031871;
    var url = "/ali1688/findCategoryAttributeByCateId21688";
    $.ajax({
        type: "get",
        url: url,
        async: 'false',
        dataType: 'json',
        param: {'categoryID':categoryID},
        beforeSend: function () {
        },
        error: function () {
        },
        success: function (n) {
            console.info(n);
            var JsonAttr = n["attributes"];
            var divGoodNomal= $(".cate-attr-good-normal");
            var divGoodSaleInfo= $(".cate-attr-good-saleInfo");
            var divGoodSpuInfo= $(".cate-attr-good-spuInfol");
            var attrHtml = "";
            var seeName = "";
            for(var i = 0;i<JsonAttr.length;i++){
                var JsonAttrInner = JsonAttr[i];
                var attrName = JsonAttrInner["name"];
                seeName+=attrName;
                seeName+=",";
            }
            for(var i = 0;i<JsonAttr.length;i++){
                var JsonAttrInner = JsonAttr[i];
                var aspect = JsonAttrInner["aspect"];
                if(aspect == "0;"){
                    
                }
                if(aspect == "3;"){
                    
                }
                if(aspect == "5;"){
                    
                }
            }
            console.log(seeName);
        }
    });
}





//TODO inputType=-1
function loadNumber(htmlUi, name, value){
    var numberForm = name +":<input class='' type='text' name='' value=''/>";
}

//TODO inputType=0
function loadInput(htmlUi, name, value){
    var inputForm = name +":<input class='' type='text' name='' value=''/>";
}

//TODO inputType=1
function loadDropDown(htmlUi, name, value){
    var dropDownForm = name +":<select class='' name=''></select>";
}


//TODO inputType=2
function loadCheckBox(htmlUi, name, value){
    var checkBoxForm = name +":<input class='' type='checkbox' name='' value=''/>";
}

//TODO inputType=3
function loadRadio(htmlUi, name, value){
    var radioForm = name +":<input class='' type='radio' name='' value=''/>";
}

//TODO inputType=4
function loadDropDownList(htmlUi, name, value){
    var dropDownListForm = name +":<select class='' name=''></select>";
}

//TODO inputType=5
function loadDate(htmlUi, name, value){
    var dateForm = name +":<input class='' type='text' name='' value=''/>";
}