<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/common/css.jsp"></jsp:include>
    <!-- 网页标题栏 -->
    <title>Title</title>

</head>
<body>
<!-- 导航条div strat -->
<nav class="navbar navbar-default navbar-static-top">
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
                <li class="active"><a href="javascript:window.location.reload();">商品管理 <span
                        class="sr-only">(current)</span></a></li>
                <li><a href="/brand/toBrandList.action">品牌管理</a></li>
                <li><a href="/user/touserMangerPage.action">用户管理</a></li>
                <li><a href="/logs/tologsMangerPage.action">日志查看</a></li>
                <li><a href="/logs/tologsMangerPage.action">会员查看</a></li>
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
        <h1>商品管理
            <small>欢迎您, ${user.userName}</small>
        </h1>
    </div>
</div>
<!-- 页面头div end -->

<!-- 搜索div strat -->
<div class="container">
    <form class="form-horizontal" id="whereForm">

        <div class="form-group">
            <label for="productName" class="col-md-2 control-label">产品名</label>
            <div class="col-md-4">
                <input type="text" class="form-control" name="productName" id="productName" placeholder="产品名">
            </div>
        </div>

        <div class="form-group">
            <label for="brandId" class="col-md-2 control-label">品牌</label>
            <div class="col-md-4">
                <select id="addBrandId" name="brandId.id" class="form-control">
                    <option value="-1">==请选择==</option>
                </select>
            </div>
        </div>
        <%----%>
        <div class="form-group">
            <label class="col-md-2 control-label">成本价</label>
            <div class="col-md-4 input-group">
                <input type="text" class="form-control" name="minCostPrice" id="minCostPrice"
                       aria-describedby="basic-addon3">
                <span class="input-group-addon">--</span>
                <input type="text" class="form-control" name="maxCostPrice" id="maxCostPrice"
                       aria-describedby="basic-addon3">
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-2 control-label">销售价</label>
            <div class="col-md-4 input-group">
                <input type="text" class="form-control" name="minMarketPrice" id="minMarketPrice"
                       aria-describedby="basic-addon3">
                <span class="input-group-addon">--</span>
                <input type="text" class="form-control" name="maxMarketPrice" id="maxMarketPrice"
                       aria-describedby="basic-addon3">
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-2 control-label">成本价</label>
            <div class="col-md-4 input-group">
                <input type="text" class="form-control" name="minRepertory" id="minRepertory"
                       aria-describedby="basic-addon3">
                <span class="input-group-addon">--</span>
                <input type="text" class="form-control" name="maxRepertory" id="maxRepertory"
                       aria-describedby="basic-addon3">
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-2 control-label">是否推荐</label>
            <div class="col-md-4 input-group">
                <div class="checkbox">
                    <label>
                        <input type="radio" name="recommend" value="-1"> 不限
                    </label>
                    <label>
                        <input type="radio" name="recommend" value="0"> 否
                    </label>
                    <label>
                        <input type="radio" name="recommend" value="1"> 是
                    </label>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-2 control-label">上架时间</label>
            <div class="col-md-4 input-group">
                <input type="text" class="form-control inputdate" name="minUpdateTime" id="minUpdateTime"
                       aria-describedby="basic-addon3">
                <span class="input-group-addon">--</span>
                <input type="text" class="form-control inputdate" name="maxUpdateTime" id="maxUpdateTime"
                       aria-describedby="basic-addon3">
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-2"></div>
            <div class="btn-group" role="group">
                <button type="button" class="btn btn-default" onclick="getData(1);">提交</button>
                <button type="reset" class="btn btn-default">重置</button>
            </div>
        </div>
    </form>

</div>
<!-- 搜索div end -->

<!-- 日期选择div -->
<!--<input input-name="entryDate" placeholder="请选择入职日期" id="blrz-entry-date-start" type="text" >-->
<!-- 页面中部面板按钮 面板体 start-->
<div class="panel panel-primary">
    <!--批量删除导出excel start-->
    <div class="panel-heading">
        <div class="container-fluid">
            <div class="col-md-9"></div>
            <div class="btn-group" role="toolbar" aria-label="...">
                <button type="button" onclick="toaddProduct()" class="btn btn-info dropdown-toggle"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"/>
                <span class="glyphicon glyphicon-plus">添加信息</span>
                <button type="button" onclick="deleteAllData()" class="btn btn-danger dropdown-toggle show-alert"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"/>
                <span class="glyphicon glyphicon-remove">批量删除</span>
                <button type="button" onclick="findExportByBrandData()" class="btn btn-info dropdown-toggle"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"/>
                <span class="glyphicon glyphicon-download-alt">导出Excel</span>
            </div>
        </div>
    </div>
    <!--批量删除导出excel end-->

    <!-- 面板体 start -->
    <div class="panel-body">
        <div class="container-fluid">

            <!-- datatable表格 strat-->
            <table id="example" class="table table-striped table-bordered table-hover" style="width:100%">
                <thead>
                <tr>
                    <th><input type="checkbox"></th>
                    <th>编号</th>
                    <th>商品名</th>
                    <th>品牌</th>
                    <th>店铺名称</th>
                    <th>商品图片</th>
                    <th>成本价</th>
                    <th>销售价</th>
                    <th>库存</th>
                    <th>是否推荐</th>
                    <th>录入时间</th>
                    <th>关闭时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
                <tfoot>
                <tr>
                    <th>选择</th>
                    <th>编号</th>
                    <th>商品名</th>
                    <th>品牌</th>
                    <th>店铺名称</th>
                    <th>商品图片</th>
                    <th>成本价</th>
                    <th>销售价</th>
                    <th>库存</th>
                    <th>是否推荐</th>
                    <th>录入时间</th>
                    <th>关闭时间</th>
                    <th>操作</th>
                </tr>
                </tfoot>
            </table>
            <!-- datatable表格 end-->
        </div>
    </div>
    <!-- 面板体 end -->
</div>

<div id="addProductDiv">
    <div class="container">
        <form class="form-horizontal">
            <input type="hidden" name="imagePath" id="imagePath">
            <input type="hidden" name="imgPath" id="imgPath">
            <table class="table table-bordered table-hover">
                <tbody>
                <tr>
                    <td>名称</td>
                    <td><input name="productName"/></td>
                </tr>
                <tr>
                    <td>品牌</td>
                    <td>
                        <select id="brandId" name="brandId.id">
                            <option value="-1">==请选择==</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>所属店铺</td>
                    <td>
                        <select id="shopId" name="shopId.id">
                            <option value="-1">==请选择==</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>成本价</td>
                    <td><input name="costPrice"/></td>
                </tr>
                <tr>
                    <td>销售价</td>
                    <td><input name="marketPrice"/></td>
                </tr>
                <tr>
                    <td>库存</td>
                    <td><input name="repertory"/></td>
                </tr>
                <tr>
                    <td>是否推荐</td>
                    <td>
                        <label><input type="radio" name="recommend" value="0"/>否</label>
                        <label><input type="radio" name="recommend" value="1"/>是</label>
                    </td>
                </tr>
                <tr>
                    <td>选择主图片</td>
                    <td>
                        <input id="uploadfile" type="file" multiple="multiple">

                    </td>
                </tr>
                <tr name="data-file">
                    <td>选择附图片</td>
                    <td>
                        <input id="uploadfileImage" type="file" multiple="multiple">
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="panel-heading">
                <div class="container-fluid">
                    <div class="col-md-9"></div>
                    <div class="btn-group" role="toolbar">
                        <button type="submit" class="btn btn-info dropdown-toggle">
                            <span class="glyphicon glyphicon-plus">添加信息</span></button>
                        <button type="reset" class="btn btn-info dropdown-toggle"
                                data-toggle="dropdown">
                            <span class="glyphicon glyphicon-alert">重置</span></button>
                    </div>
                </div>
            </div>
        </form>


    </div>
</div>



<jsp:include page="/common/script.jsp"></jsp:include>
<script>

    //id数组
    var checkboxStauts = [];
    //jquery datatable全局变量
    var table;

    //页面加载函数
    $(function () {
        //初始化表格
        initTable();
        //初始化表格点击事件
        initTableClickChangeColor();
        //加载下拉框
        initBrandList(-1);
        //初始化日期
        initDate();
    });



    //jquery datatable表格函数初始化
    function initTable() {
        //表格初始化
        table = $('#example').DataTable({
            "processing": true,
            "serverSide": true,
            //默认排序
            "order": [],
            "aoColumnDefs": [ {
                    "bSortable": false,
                    "aTargets": [0, 1, 2, 3, 4, 5, 12]
                }],
            "ajax": {
                "url": "/product/ajaxFindProductList.action",
                "type": "POST",
            },
            "type": "POST",
            "lengthMenu": [10, 15, 30],
            "language": {
                "url": "/common/datatable/Chinese.json",
            },

            "searching": false,
            "columns": [
                {
                    "data": "id",
                    "title": "选择",
                    "orderable": false,
                    "render": function (data) {
                        return "<input type='checkbox' value=" + data + " name='checks' onclick='this.checked=!this.checked'/>";
                    }
                },
                {"data": "id"},
                {"data": "productName"},
                {"data": "brandId.brandName"},
                {"data": "shopId.storeName"},
                {
                    "data": "imagePath",
                    "orderable": false,
                    render: function (data) {
                        return "<img width='50px' heigth='50px' src='" + data + "'/>"
                    }
                },
                {"data": "costPrice"},
                {"data": "marketPrice"},
                {"data": "repertory"},
                {"data": "recommend"},
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
                },
                {
                    "data": "id",
                    "render": function (data) {
                        return "<div class=\"btn-group\" role=\"group\" aria-label=\"...\">" +
                            "<button type=\"button\" class=\"btn btn-info glyphicon glyphicon-pencil\" onclick='toUpdateProduct(" + data + ")'>修改</button>\n" +
                            "<button type=\"button\" class=\"btn btn-danger glyphicon glyphicon-remove\" onclick='deleteProduct(" + data + ")'>删除</button>\n" +
                            "  <button type=\"button\" class=\"btn btn-info glyphicon glyphicon-paperclip\" onclick='toFindImgPath(" + data + ")'>查看图片</button>" +
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
    }

    //调用jquery datatable ajax获取数据
    function getData(pageIndex) {
        table.settings()[0].ajax.data = {
            "productName": $("#productName").val(),
            "brandId.id": $("#brandId").val(),
            "shopId.id": $("#shopId").val(),
            "recommend": $("[name='recommend']:checked").val(),
            "minCostPrice": $("#minCostPrice").val(),
            "maxCostPrice": $("#maxCostPrice").val(),
            "minMarketPrice": $("#minMarketPrice").val(),
            "maxMarketPrice": $("#maxMarketPrice").val(),
            "minRepertory": $("#minRepertory").val(),
            "maxRepertory": $("#maxRepertory").val(),
            "minCreateTime": $("#minCreateTime").val(),
            "maxCreateTime": $("#maxCreateTime").val(),
            "minUpdateTime": $("#minUpdateTime").val(),
            "maxUpdateTime": $("#maxUpdateTime").val(),
            "pageIndex": pageIndex,
            "flag": 1,
            "pageSize": $("#pageSize").val()
        };
        table.ajax.reload();
    }

    //删除函数
    function deleteProduct(id) {
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
                console.log('This was logged in the callback: ' + result);
                if (result) {
                    $.ajax({
                        url: "/product/deleteProduct.action",
                        data: {
                            "id": id
                        },
                        success: function (data) {
                            table.ajax.reload();
                        }

                    })
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
                    console.log('This was logged in the callback: ' + result);
                    if (result) {
                        var idstr = checkboxStauts.join(",");
                        $.ajax({
                            url: "/product/deleteAllData.action",
                            data: {
                                "ids": idstr
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

    //按品牌导出数据
    function findExportByBrandData() {
        $("#whereForm").attr("action", "<%=request.getContextPath()%>/product/exportDataByBrand.action");
        $("#whereForm").submit();
    }

    //手动提交查询表单
    function exportData() {
        $("#whereForm").attr("action", "<%=request.getContextPath()%>/product/exportData.action");
        $("#whereForm").submit();
    }

    //按品牌导出数据
    function findExportByBrandData() {
        $("#whereForm").attr("action", "<%=request.getContextPath()%>/product/exportDataByBrand.action");
        $("#whereForm").submit();
    }

    //产看图片
    function toFindImgPath(id) {
        location.href = "/product/findImagesList.action?id=" + id;
    }

    //回显
    function toUpdateProduct(id) {
        location.href = "/product/toupdateProduct.action?id=" + id;
    }

    //跳转到添加页面
    function toaddProduct() {
        location.href = "/product/toAddProduct.action"
    }
</script>
</body>
</html>