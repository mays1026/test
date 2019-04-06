<%--
  Created by IntelliJ IDEA.
  User: MYS
  Date: 2019/03/03
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <jsp:include page="/common/css.jsp"></jsp:include>
    <title>Title</title>
</head>
<body>

    <div class="container-fluid">

        <!-- datatable表格 strat-->
        <table id="example" class="table table-striped table-bordered table-hover" style="width:100%">
        </table>
        <!-- datatable表格 end-->
    </div>
    <jsp:include page="/common/script.jsp"></jsp:include>
    <script>
        $(function(){
            initTable();
        });

        var table;
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
                    "aTargets": []
                }],
                "ajax": {
                    "url": "/dept/findDeptList.action",
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
                    {"data": "industryTitle"},
                    {"data": "pid"},
                    {"data": "remark"}
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

    </script>
</body>
</html>
