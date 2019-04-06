<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="/js/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="/js/ztree/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="/js/ztree/js/jquery.ztree.excheck.js"></script>
    <script type="text/javascript" src="/js/ztree/js/jquery.ztree.exedit.js"></script>

    <script type="text/javascript">
        $(function () {
            getData()
        });
        var setting = {
            view: {
                addHoverDom: addHoverDom,
                removeHoverDom: removeHoverDom,
                selectedMulti: false
            },
            edit: {
                enable: true,
                editNameSelectAll: true,
                removeTitle: '删除',
                renameTitle: '重命名'
            },
            check: {
                enable: false
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback: {
                beforeRemove: beforeRemove,//点击删除时触发，用来提示用户是否确定删除（可以根据返回值 true|false 确定是否可以删除）
                beforeEditName: beforeEditName,//点击编辑时触发，用来判断该节点是否能编辑
                beforeRename: beforeRename,//编辑结束时触发，用来验证输入的数据是否符合要求(也是根据返回值 true|false 确定是否可以编辑完成)
                onRemove: onRemove,//(beforeRemove返回true之后可以进行onRemove)删除节点后触发，用户后台操作
                onRename: onRename,//编辑后触发，用于操作后台
                beforeDrag: beforeDrag,//用户禁止拖动节点
                onClick: clickNode//点击节点触发的事件
            }
        };

        setting.check.chkboxType = {"Y": "p", "N": "s"};

        function getData() {
            $.ajax({
                url: "<%=basePath%>dept/initDeptList.action",
                data: {},
                type: "post",
                dataType: "json",
                success: function (data) {
                    var zNodes = data;
                    zTree = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
                },
                error: function (data) {
                    alert("页面加载失败");
                    $("#cuo").html(data.responseText);
                }
            });
        }

        function beforeRemove(e, treeId, treeNode) {
            return confirm("你确定要删除吗？");
        }

        function onRemove(e, treeId, treeNode) {
            if (treeNode.isParent) {
                var childNodes = zTree.removeChildNodes(treeNode);
                var paramsArray = new Array();
                for (var i = 0; i < childNodes.length; i++) {
                    if (childNodes[i].isParent) {
                        onRemove(e, treeId, childNodes[i]);
                    }
                    paramsArray.push(childNodes[i].id);
                }
                alert("删除父节点的id为：" + treeNode.id + "\r\n他的孩子节点有：" + paramsArray.join(","));
                return;
            }
            alert("你点击要删除的节点的名称为：" + treeNode.name + "\r\n" + "节点id为：" + treeNode.id);
        }

        function beforeEditName(treeId, treeNode) {
            if (treeNode.isParent) {
                alert("不准编辑非叶子节点！");
                return false;
            }
            return true;
        }

        function beforeRename(treeId, treeNode, newName, isCancel) {
            if (newName.length < 1) {
                alert("名称不能少于1个字符！");
                return false;
            }
            return true;
        }

        function onRename(e, treeId, treeNode, isCancel) {
            alert("修改节点的id为：" + treeNode.id + "\n修改后的名称为：" + treeNode.name);
        }

        function clickNode(e, treeId, treeNode) {
            if (treeNode.id == 11) {
                location.href = treeNode.url;
            } else {
                alert("节点名称：" + treeNode.name + "\n节点id：" + treeNode.id);
            }
        }

        function beforeDrag(treeId, treeNodes) {
            return false;
        }

        var newCount = 1;

        function addHoverDom(treeId, treeNode) {
            var sObj = $("#" + treeNode.tId + "_span");
            if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0) return;
            var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
                + "' title='添加子节点' onfocus='this.blur();'></span>";
            sObj.after(addStr);
            var btn = $("#addBtn_" + treeNode.tId);
            if (btn) btn.bind("click", function () {
                //在这里向后台发送请求保存一个新建的叶子节点，父id为treeNode.id,让后将下面的100+newCount换成返回的id
                zTree.addNodes(treeNode, {id: (100 + newCount), pId: treeNode.id, name: "新建节点" + (newCount++)});
                alert("开始添加节点");
                return false;
            });
        }

        function removeHoverDom(treeId, treeNode) {
            $("#addBtn_" + treeNode.tId).unbind().remove();
        }
    </script>
</head>
<body>

<div class="zTreeDemoBackground left">
    <ul id="treeDemo" class="ztree"></ul>
</div>


</body>
</html>