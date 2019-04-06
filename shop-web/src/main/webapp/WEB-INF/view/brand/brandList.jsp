<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- bootstrap引入要求 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 引入css -->
    <link rel="stylesheet" href="/js/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/js/DataTables-1.10.15/media/css/dataTables.bootstrap.min.css"/>
    <link rel="stylesheet" href="/js/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css">
    <!-- 网页标题栏 -->
    <title>Title</title>

</head>
<body onkeydown="kedown()">

<!-- 导航条div strat -->
<nav class="navbar navbar-default">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <!-- 主页div strat -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/index.jsp">主页</a>
        </div>
        <!-- 主页div strat -->
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/product/toproductList.action">商品管理 <span
                        class="sr-only">(current)</span></a></li>
                <li class="active"><a href="javascript:window.location.reload();">品牌管理</a></li>
                <li><a href="/user/touserMangerPage.action">用户管理</a></li>
                <li><a href="/logs/tologsMangerPage.action">日志查看</a></li>
            </ul>
            <!-- 导航条右侧按钮ul start -->
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/login.jsp" class="glyphicon glyphicon-off">退出</a></li>
                <%--<li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>--%>
            </ul>
            <!-- 导航条右侧按钮ul end -->
        </div><!-- /.navbar-collapse -->

    </div><!-- /.container-fluid -->
</nav>
<!-- 导航条div end -->

<!-- 页面头div strat -->
<div class="container">
    <div class="page-header">
        <h1>品牌管理
            <small>欢迎您, ${user.userName}</small>
        </h1>
    </div>
</div>
<!-- 页面头div end -->


<!-- form表单 -->
<div class="container">
    <div class="row">
        <%--<a href="javaScript:addBrandDivShow()" tabindex="1">添加</a>
        <a href="javaScript:deleteAllProduct()">批量删除</a>--%>
        <div class="row"></div>
        <div class="container">
            <form class="form-horizontal col-md-8">
                <table class="table table-hover">
                    <div class="form-group">
                        <label class="col-md-2 control-label">名称</label>
                        <div class="col-md-4 input-group">
                            <input type="text" class="form-control" name="brandName" id="brandName"
                                   aria-describedby="basic-addon3">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">录入时间</label>
                        <div class="col-md-4 input-group">
                            <input type="text" class="form-control inputdate" name="minCreateTime" id="minCreateTime"
                                   aria-describedby="basic-addon3">
                            <span class="input-group-addon">--</span>
                            <input type="text" class="form-control inputdate" name="maxCreateTime" id="maxCreateTime"
                                   aria-describedby="basic-addon3">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">修改时间</label>
                        <div class="col-md-4 input-group">
                            <input type="text" class="form-control inputdate" name="minUpdateTime" id="minUpdateTime"
                                   aria-describedby="basic-addon3">
                            <span class="input-group-addon">--</span>
                            <input type="text" class="form-control inputdate" name="maxUpdateTime" id="maxUpdateTime"
                                   aria-describedby="basic-addon3">
                        </div>
                    </div>
                </table>
                <input type="button" value="查询" onclick="getData(1)">
                <input type="reset" value="重置">
            </form>
        </div>
    </div>
    <%--<div class="row" id="dataPage">
        <jsp:include page="/WEB-INF/view/brand/brandPage.jsp"></jsp:include>
    </div>--%>
    <div class="panel-heading">
        <div class="container-fluid">
            <div class="col-md-8"></div>
            <div class="btn-group" role="toolbar">
                <button type="button" onclick="addBrandDivShow();" class="btn btn-info dropdown-toggle"
                        data-toggle="dropdown"/>
                <span class="glyphicon glyphicon-plus">添加信息</span>
                <button type="button" onclick="deleteAllData();" class="btn btn-danger dropdown-toggle show-alert"
                        data-toggle="dropdown"/>
                <span class="glyphicon glyphicon-remove">批量删除</span>
            </div>
        </div>
    </div>
    <div class="panel-body">
        <!-- 表格数据 strat-->
        <table id="example" class="table table-hover">
    </div>
    </table>
    <!-- 表格数据 end-->

    <!-- 新增div strat -->
    <div class="container" id="addBrandDiv">
        <form class="form-control" id="fileUpload" method="post">
            <div class="form-group">
                <div class="row">
                    <span class="col-md-2"> 名称</span>
                    <input class="input-control" id="addBrandName" tabindex="1">
                </div>
            </div>
            <!--<input type="button" onclick="springUpload();">-->
            <div class="form-group">
                <button type="button" class="btn btn-default" onclick="addBrand()">
                    <span class="glyphicon glyphicon-plus">新增</span>
                </button>
            </div>
        </form>
    </div>
    <!-- 新增div end -->
</div>
<jsp:include page="/common/script.jsp"></jsp:include>
<script type="text/javascript">

    $(function () {
        $("#addBrandDiv").hide();
        initTable();
        initTableClickChangeColor();
        //初始化日期
        initDate();
    })

    //日期input框初始化
    function initDate() {
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
    }

    var table;

    //jquery datatable表格函数初始化
    function initTable() {
        table = $('#example').DataTable({
            "processing": true,
            "serverSide": true,
            "ajax": {
                "url": "/brand/findBrandList.action",
                "type": "POST",
            },
            "type": "POST",
            "lengthMenu": [10, 15, 30, 45],
            "language": {
                "url": "/common/datatable/Chinese.json",
            },
            "columnDefs": [ {
                //单元格的下标
                "targets": 2,
                //创建此单元时的回调函数
                "createdCell": function (td, cellData, rowData, row, col) {
                    // if ( cellData < 1 ) {
                    // console.log(col)
                        $(td).attr('data-id', rowData.id);
                        $(td).attr('data-brandName', rowData.brandName);

                    // }
                }
            } ],
            "searching": false,/*
            "createdRow": function (row, data, dataIndex, cells){

            },*/
            "columns": [
                {
                    "data": "id", "title": "选择", "render": function (data) {
                        return "<input type='checkbox' value=" + data + " name='checks' onclick='this.checked=!this.checked'/>";
                    }
                },
                {"data": "id", "title": "编号"},
                {
                    "data": "brandName",
                    "title": "产品名称",

                },
                {
                    "data": "createTime", "title": "创建时间", render: function (data, type, row, meta) {
                        if (data != null) {
                            var unixTimestamp = new Date(data);
                            commonTime = unixTimestamp.toLocaleString();
                            return commonTime;
                            11
                        }
                        return data;
                    }
                },
                {
                    "data": "updateTime", "title": "修改时间", render: function (data, type, row, meta) {
                        if (data != null) {
                            var unixTimestamp = new Date(data);
                            commonTime = unixTimestamp.toLocaleString();
                            return commonTime;
                        }
                        return data;
                    }
                },
                /*{"data": "brandId.brandName"},
                {"data": "shopId.storeName"},
                {"data": "costPrice"},
                {"data": "marketPrice"},
                {"data": "repertory"},
                {"data": "recommend"},
                {
                    "data": "imagePath", render: function (data) {
                        return "<img width='50px' heigth='50px' src='" + data + "'/>"
                    }
                },
                {
                    "data": "createTime", render: function (data, type, row, meta) {
                        if (data != null) {
                            var unixTimestamp = new Date(data);
                            commonTime = unixTimestamp.toLocaleString();
                            return commonTime;
                            11
                        }
                        return data;
                    }
                },
                {
                    "data": "updateTime", render: function (data, type, row, meta) {
                        if (data != null) {
                            var unixTimestamp = new Date(data);
                            commonTime = unixTimestamp.toLocaleString();
                            return commonTime;
                        }
                        return data;
                    }
                },*/
                {
                    "data": "id", "title": "操作",
                    "render": function (data) {
                        return "<div class=\"btn-group\" role=\"group\" aria-label=\"...\">" +
                            "<button type=\"button\" class=\"btn btn-info glyphicon glyphicon-pencil\" onclick='toUpdateBrand(" + data + ")'>修改</button>\n" +
                            "<button type=\"button\" class=\"btn btn-danger glyphicon glyphicon-remove\" onclick='deleteBrand(" + data + ")'>删除</button>\n" +
                            "</div>";
                    }
                }
            ],
            "createdRow": function (row, data, dataIndex) {
                for (var i = 0; i < checkboxStauts.length; i++) {
                    if (data.id == checkboxStauts[i]) {
                        $(row).css("background-color", "#ccc");
                        var checkedNode = $(row).children(':first').children(':first').get(0);
                        checkedNode.checked = true;
                    }
                }
            }
        });
        /*点击事件*/
        /*$("#table tbody").on("click", "tr", function () {
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
        })*/

        /*鼠标移上事件*/
        /*$("#table tbody").on("mouseover", "tr", function () {
            var checkedNode = $(this).children(':first').children(':first').get(0);
            if (!checkedNode.checked) {
                $(this).css("background-color", "#ddd");
            }
        });*/

        /*鼠标移除事件*/
        /*$("#table tbody").on("mouseout", "tr", function () {
            var checkedNode = $(this).children(':first').children(':first').get(0);
            if (!checkedNode.checked) {
                $(this).css("background-color", "");
            }
        });*/
    }

    //查询
    function getData(cpage) {
        table.settings()[0].ajax.data =  {
                "brandName": $("#brandName").val(),
                "pageIndex": cpage,
                "minCreateTime": $("#minCreateTime").val(),
                "maxCreateTime": $("#maxCreateTime").val(),
                "minUpdateTime": $("#minUpdateTime").val(),
                "maxUpdateTime": $("#maxUpdateTime").val()
            }
        table.ajax.reload();
    }

    //删除
    function deleteBrand(id) {
        $.ajax({
            url: "/brand/deleteBrandById.action",
            data: {
                "id": id
            },
            type: "post",
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    getData(1);
                } else {
                    alert(data.message);
                }
            }
        });
    }

    //删除
    function deleteAllData() {
        if (checkboxStauts.length != 0) {
            bootbox.confirm({
                message: "你确认删除这些数据?",
                buttons: {
                    confirm: {
                        label: '是的',
                        className: 'btn-success'
                    },
                    cancel: {
                        label: '不，手滑了',
                        className: 'btn-danger'
                    }
                },
                callback: function (result) {
                    if (result) {
                        var ids = checkboxStauts.join(",");
                        $.ajax({
                            url: "/brand/deleteAllData.action",
                            data: {
                                "ids": ids
                            },
                            type: "post",
                            dataType: "json",
                            success: function (data) {
                                if (data.code == 200) {
                                    getData(1);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    //回显
    function toUpdateBrand(brandId) {
        var brandName = $("td[data-id='" + brandId + "']").attr("data-brandName");
        $("td[data-id='" + brandId + "']").html("<input value='" + brandName + "'/>"
            + "<input type='button' value='取消' onclick='cancel(\"" + brandId + "\",\"" + brandName + "\");'>"
            + "<input type='button' value='保存' id='updataBrandButton' onclick='updateBrand(\"" + brandId + "\", \"" + brandName + "\")'>");
    }

    //取消修改
    function cancel(brandId, brandName) {
        console.log(brandId + ":" + brandName);
        $("td[data-id='" + brandId + "']").html(brandName);
    }

    //修改
    function updateBrand(brandId, oldBrandName) {
        //console.log(value)
        var valueupdate = $("td[data-id='" + brandId + "'] input").val();
        $("td[data-id='" + brandId + "']").attr("data-brandName", valueupdate);
        $.ajax({
            url: "/brand/updateBrand.action",
            data: {
                "id": brandId,
                "brandName": valueupdate
            },
            type: "post",
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    $("td[data-id='" + brandId + "']").html(valueupdate);
                } else {
                    $("td[data-id='" + brandId + "']").html(oldBrandName);
                    alert(data.message);
                }
            }
        });
    }

    //变色回填
    var checkboxState = [];

    //tr点击事件绑定匿名函数
    function trCheckState() {
        $("#dataTbody tr").each(function () {
            var check = $(this).children(':first').children(':first').get(0);
            for (var i = 0; i < checkboxState.length; i++) {
                if (check.value == checkboxState[i]) {
                    check.checked = true;
                    $(this).css("backgroundColor", "#ccc");
                }
            }
            $(this).bind({
                mouseover: function () {
                    if (!check.checked) {
                        $(this).css("backgroundColor", "#ddd");
                    }
                },
                mouseout: function () {
                    if (!check.checked) {
                        $(this).css("backgroundColor", "");
                    }
                },
                click: function () {
                    if (check.checked) {
                        $(this).css("backgroundColor", "");
                        check.checked = false;
                        deleteCheckboxState(check.value);
                    } else {
                        $(this).css("backgroundColor", "#ccc");
                        check.checked = true;
                        checkboxState.push(check.value);
                    }
                }
            });
        });
    }

    //删除数组中已有的值
    function deleteCheckboxState(val) {
        for (var i = checkboxState.length - 1; i >= 0; i--) {
            if (checkboxState[i] == val) {
                checkboxState.splice(i, 1);
            }
        }
    }

    //展示新增div
    function addBrandDivShow() {
        $("#addBrandDiv").show();
    }

    //新增
    function addBrand() {
        $.ajax({
            url: "/brand/addBrand.action",
            data: {
                "brandName": $("#addBrandName").val()
            },
            type: "post",
            dataType: "json",
            success: function (data) {
                $("#addBrandDiv").hide();
                table.ajax.reload();
            }
        });
    }

    function kedown() {
        if (event.keyCode == 13) {  //回车键的键值为13
            document.getElementById("updataBrandButton").click(); //调用登录按钮的登录事件
        }
    }

    function springUpload() {
        var formFile = $("#fileUpload");
        formFile.attr("action", "/brand/springUpload.action");
        formFile.submit();
    }
</script>
</body>
</html>