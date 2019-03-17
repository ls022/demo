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

<div id="detailModal" class="modal"><%--基层--%>
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
                <li><a href="/order/type/toList.do">类型管理</a></li>
                <li class="active"><a href="/order/detail/toList.do">订单管理</a></li>
                <li><a href="#">报表管理</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">商品管理</h1>
            <h2 class="sub-header">商品列表</h2>
            <div class="table-responsive">
                <table id="detailTable"></table>
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
        $('#detailTable').bootstrapTable({
            url:'/order/detail/getList.do',//请求地址
            method:'get',//请求方式
            pagination:true,//开启分页功能
            pageSize:5,//每页显示的条数
            pageList:[5,10,15,30,50,100],//分页下拉框设置（该数组首项必须是pageSize的值）
            sidePagination:'server',//分页方式
            columns:[
                {field:'id',title:'编号',align:'center',valign:'middle'},
                {field:'tableno',title:'桌号',align:'center',valign:'middle'},
                {field:'time',title:'下单时间',align:'center',valign:'middle'},
                {field:'price',title:'订单总价',align:'center',valign:'middle'},
                {field:'remake',title:'备注',align:'center',valign:'middle'},
                {title:'操作',formatter:'optFun',align:'center',valign:'middle'}
            ]
        });
        /*监听模态窗关闭事件*/
        $('#detailModal').on('hidden.bs.modal',function () {
            $(this).removeData('bs.modal');//清除模态窗数据
        });
    });

    function optFun(value,row) {
        return '<a href="/order/detail/getDetails.do?id='+row.id+'" class="btn btn-primary" data-toggle="modal" data-target="#detailModal">详情</a>';
    }

</script>
</body>
</html>