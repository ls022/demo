<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %><%--启用jsp的el表达式功能--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="icon" href="https://v3.bootcss.com/favicon.ico">
    <title>云中城大酒店</title>
    <!-- Bootstrap core CSS -->
    <link href="/order/static/bootstrap/css/bootstrap.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/order/static/bootstrap/dashboard.css" rel="stylesheet">

    <link rel="stylesheet" href="/order/static/bootstrap-table/bootstrap-table.css">
</head>

<body>

<div id="typeModal" class="modal"><%--基层--%>
    <div class="modal-dialog"><%--遮罩层--%>
        <div class="modal-content">
        </div>
    </div>
</div>


<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">云中城大酒店</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="https://v3.bootcss.com/examples/dashboard/#">${loginUser.username}</a></li>
                <li><a href="https://v3.bootcss.com/examples/dashboard/#">退出</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="/order/user/toList.do">商品管理</a>
                </li>
                <li class="active"><a href="/order/type/toList.do">类型管理</a></li>
                <li><a href="/order/detail/toList.do">订单管理</a></li>
                <li><a href="#">报表管理</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">类型管理</h1>
            <h2 class="sub-header">类型列表</h2>
            <div class="table-responsive">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <form action="" id="searchForm" class="form-inline">
                            <div class="form-group">
                                <label for="tname">类型名称</label>
                                <input type="text" id="tname" name="tname" class="form-control" placeholder="请输入类型名称">
                            </div>
                            <div class="form-group">
                                <button type="button" id="searchBtn" class="btn btn-default">查询</button>
                                <button type="button" id="clearBtn" class="btn btn-default">清除</button>
                                <a href="/order/type/toUpdate.do" data-toggle="modal" data-target="#typeModal" id="addBtn" class="btn btn-primary">增加</a>
                            </div>
                        </form>
                    </div>
                </div>
                <table id="typeTable"></table>
            </div>
        </div>
    </div>

</div>

<script src="/order/static/Jquery/jquery-3.2.1.min.js"></script>
<script src="/order/static/bootstrap/js/bootstrap.js"></script>
<script src="/order/static/bootstrap-table/bootstrap-table.js"></script>
<script src="/order/static/bootstrap-table/bootstrap-table-zh-CN.js"></script>
<script>
    $(function () {
        $('#typeTable').bootstrapTable({
            url:'/order/type/getList.do',//请求地址
            method:'get',//请求方式
            pagination:true,//开启分页功能
            pageSize:5,//每页显示的条数
            pageList:[5,10,15,30,50,100],//分页下拉框设置（该数组首项必须是pageSize的值）
            sidePagination:'server',//分页方式
            columns:[
                {field:'id',title:'编号',align:'center',valign:'middle'},
                {field:'typename',title:'商品名称',align:'center',valign:'middle'},
                {field:'status',title:'状态',formatter:'statusFun',align:'center',valign:'middle'},
                {title:'操作',formatter:'optFun',align:'center',valign:'middle'}
            ]
        });
        
        
        $('#searchBtn').on('click',function () {
            var tname=$('#tname').val();

            $('#typeTable').bootstrapTable('refresh',{
                query:{
                    typename:tname
                }
            });
        });

        $('#clearBtn').click(function () {
            $('#tname').val('');
        });
        /*监听模态窗关闭事件*/
        $('#typeModal').on('hidden.bs.modal',function () {
            $(this).removeData('bs.modal');//清除模态窗数据
        });
        
    });

    function statusFun(value,row) {
        if(value==1){
            return '<button class="btn btn-success" onclick="updateStatus('+row.id+',0);">可用</button>';
        }else{
            return '<button class="btn btn-warning" onclick="updateStatus('+row.id+',1);">禁用</button >';
        }
    }

    function optFun(value,row) {
        return '<a href="/order/type/toUpdate.do?id='+row.id+'" class="btn btn-primary" data-toggle="modal" data-target="#typeModal">修改</a>\n' +
            '    <a href="#" class="btn btn-danger" onclick="deleteType('+row.id+')">刪除</a>';
    }

    function updateStatus(id,status) {
        if(confirm("是否更改信息？")){
            $.ajax({
                url:'/order/type/doUpdate.do',
                data:{
                    id:id,
                    status:status
                },
                method:'post',
                dataType:'json',
                success:function (res) {
                    if(res.status==1){
                        alert('信息修改成功！');
                    }else {
                        alert('信息修改失败！');
                    }
                    $('#typeTable').bootstrapTable('refresh');
                },
                error:function (e) {
                    alert('与服务器连接失败！');
                    console.log(e);
                }
            });
        }
    }


    function deleteType(id) {
        if(confirm("是否删除信息？")){
            $.ajax({
                url:'/order/type/deleteType.do',
                data:{
                    id:id
                },
                method:'post',
                dataType:'json',
                success:function (res) {
                    if(res.status==1){
                        alert('信息删除成功！');
                    }else {
                        alert('信息删除失败！');
                    }
                    $('#typeTable').bootstrapTable('refresh');
                },
                error:function (e) {
                    alert('与服务器连接失败！');
                    console.log(e);
                }
            });
        }
    }
</script>
</body>
</html>