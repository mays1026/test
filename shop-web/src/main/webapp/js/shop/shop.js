//下一页
function turnPage(pageIndex) {
    getData(pageIndex);
}

var rowData = 1;
var checkboxStauts = [];
//点击tr选中复选框
/*function trClickCkecked(){
$("#example tabody tr").each(function(){
    var checkedNode = $(this).children(':first').children(':first').get(0);
    for (var i = 0; i < checkboxStauts.length; i++) {
        if (checkboxStauts[i]==checkedNode.value) {
            checkedNode.checked=true;
            $(this).css("background-color","#ccc");
            break;
        }
    }
    $(this).bind({
        mouseover:function(){
            if (!checkedNode.checked) {
                $(this).css("background-color","blue");
            }
        },
        mouseout:function(){
            if (!checkedNode.checked) {
                //$(this).css("background-color","yellow");
                $(this).css("background-color","");
            }
        },
        click:function(){
            if (!checkedNode.checked) {
                checkboxStauts.push(checkedNode.value);
                checkedNode.checked=true;
                $(this).css("background-color","#ccc");
            }else{
                for (var i = 0; i < checkboxStauts.length; i++) {
                    if (checkboxStauts[i]==checkedNode.value) {
                        checkboxStauts.splice(i,1);
                    }
                }
                $(this).css("background-color","");
                checkedNode.checked=false;
            }
        }
    });
})
}*/

//初始化表格点击事件
function initTableClickChangeColor() {
    $("#example tbody").on("click", "tr", function () {
        rowData = table.row(this).data();
        console.log(rowData)
        var checkedNode = $(this).children(':first').children(':first').get(0);
        if (!checkedNode.checked) {
            checkboxStauts.push(checkedNode.value);
            checkedNode.checked = true;
            $(this).css("background-color", "#ccc");
        } else {
            for (var i = 0; i < checkboxStauts.length; i++) {
                if (checkboxStauts[i] == checkedNode.value) {
                    checkboxStauts.splice(i, 1);
                }
            }
            $(this).css("background-color", "");
            checkedNode.checked = false;
        }

    });
}


//初始化下拉框
function initBrandList(brandId) {
    $.ajax({
        url: "/brand/initBrandList.action",
        dataType: "json",
        success: function (data) {
            if (data.code == 200) {
                var list = data.data;
                for (var i = 0; i < list.length; i++) {
                    $("#brandId").append(""
                        + "<option value='" + list[i].id + "'>" + list[i].brandName + "</option>");
                }
                $("#brandId").val(brandId);
            }
        }
    })
}


//日期input框初始化
function initDate() {
    $(document).on("click", ".inputdate", function () {
        $(".inputdate").datetimepicker({//选择年月日
            format: 'yyyy-mm-dd',
            language: 'zh-CN',
            weekStart: 1,
            todayBtn: 1,//显示‘今日’按钮
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,  //Number, String. 默认值：0, 'hour'，日期时间选择器所能够提供的最精确的时间选择视图。
            clearBtn: true,//清除文本框按钮
            forceParse: 0
        });
        $(".inputdateTime").datetimepicker({//选择年月日
            format: 'yyyy-mm-dd HH:mm:ss',
            language: 'zh-CN',
            weekStart: 1,
            todayBtn: 1,//显示‘今日’按钮
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 1,  //Number, String. 默认值：0, 'hour'，日期时间选择器所能够提供的最精确的时间选择视图。
            clearBtn: true,//清除文本框按钮
            forceParse: 0
        });
    })
}

//初始化shop下拉框
/*function initShopList(shopId) {
    $.ajax({
        url:"/shop/initShopList.action",
        dataType:"json",
        success:function(data) {
            if (data.code == 200) {
                var list = data.data;
                for (var i = 0; i < list.length; i++) {
                    $("#shopId").append(""
                            +"<option value='"+list[i].id+"'>"+list[i].storeName+"</option>");
                }
                $("#shopId").val(shopId);
            }
        }
    })
}*/
