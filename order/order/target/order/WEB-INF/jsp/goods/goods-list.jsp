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

<div id="goodModal" class="modal"><%--基层--%>
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
                <li class="active"><a href="/order/user/toList.do">商品管理</a>
                </li>
                <li><a href="/order/type/toList.do">类型管理</a></li>
                <li><a href="/order/detail/toList.do">订单管理</a></li>
                <li><a href="#">报表管理</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">商品管理</h1>
            <h2 class="sub-header">商品列表</h2>
            <div class="table-responsive">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <form action="" id="searchForm" class="form-inline">
                            <div class="form-group">
                                <label for="goodName">商品名称</label>
                                <input type="text" id="goodName" name="goodName" class="form-control" placeholder="请输入商品名称">
                            </div>
                            <div class="form-group">
                                <label for="goodType">商品类型</label>
                                <select name="goodType" id="goodType" class="form-control">
                                    <option value="0">[请选择]</option>
                                    <option value="1">盖浇饭</option>
                                    <option value="2">汉堡</option>
                                    <option value="3">面食</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="isUpDown">上架/下架</label>
                                <select name="isUpDown" id="isUpDown" class="form-control">
                                    <option value="-1">[请选择]</option>
                                    <option value="1">上架</option>
                                    <option value="0">下架</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="isStatus">状态</label>
                                <select name="isStatus" id="isStatus" class="form-control">
                                    <option value="-1">[请选择]</option>
                                    <option value="1">可用</option>
                                    <option value="0">禁用</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <button type="button" id="searchBtn" class="btn btn-default">查询</button>
                                <button type="button" id="clearBtn" class="btn btn-default">清除</button>
                                <a href="/order/good/toUpdate.do" data-toggle="modal" data-target="#goodModal" id="addBtn" class="btn btn-primary">增加</a>
                            </div>
                        </form>
                    </div>
                </div>
                <table id="goodTable"></table>
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
        $('#goodTable').bootstrapTable({
            url:'/order/good/getList.do',//请求地址
            method:'get',//请求方式
            pagination:true,//开启分页功能
            pageSize:5,//每页显示的条数
            pageList:[5,10,15,30,50,100],//分页下拉框设置（该数组首项必须是pageSize的值）
            sidePagination:'server',//分页方式
            columns:[
                // {checkbox:true},
                {field:'id',title:'编号',align:'center',valign:'middle'},
                {field:'gname',title:'商品名称',align:'center',valign:'middle'},
                {field:'gprice',title:'商品价格',align:'center',valign:'middle'},
                {field:'gpath',title:'商品图片',formatter:'imgFun',align:'center',valign:'middle'},
                {field:'typename',title:'商品类型',align:'center',valign:'middle'},
                {field:'count',title:'库存',align:'center',valign:'middle'},
                {field:'updown',title:'上架/下架',formatter:'upDownFun',align:'center',valign:'middle'},
                {field:'status',title:'状态',formatter:'statusFun',align:'center',valign:'middle'},
                {title:'操作',formatter:'optFun',align:'center',valign:'middle'}
            ]
        });
        
        
        $('#searchBtn').on('click',function () {
            var goodName=$('#goodName').val();
            var goodType=$('#goodType').val();
            var isUpDown=$('#isUpDown').val();
            var isStatus=$('#isStatus').val();

            $('#goodTable').bootstrapTable('refresh',{
                query:{
                    gname:goodName,
                    tid:goodType,
                    updown:isUpDown,
                    status:isStatus
                }
            });
        });
        /*监听模态窗关闭事件*/
        $('#goodModal').on('hidden.bs.modal',function () {
            $(this).removeData('bs.modal');//清除模态窗数据

            /*
            * this和$(this)的区别：this是DOM对象，$(this)是Jquery对象。
            *
            *
            * DOM对象和Jquery对象怎么互相转换。
            * DOM对象转jq对象使用jq的工厂函数$();
            * jq对象转DOM对象数组下标方式或者jq对象.get(i)
            *
            *
            *
            *
            * */


        });
        
    });
    function upDownFun(value,row) {
        if(value==1){
            return '<button class="btn btn-success" onclick="updateUpDown('+row.id+',0);">上架</button>';
        }else{
            return '<button class="btn btn-warning" onclick="updateUpDown('+row.id+',1);">下架</button >';
        }
    }

    function statusFun(value,row) {
        if(value==1){
            return '<i>可用</i>';
        }else{
            return '<i>禁用</i>';
        }
    }

    function optFun(value,row) {
        return '<a href="/order/good/toUpdate.do?id='+row.id+'" class="btn btn-primary" data-toggle="modal" data-target="#goodModal">修改</a>\n' +
            '    <a href="#" class="btn btn-danger" onclick="deleteGood('+row.id+')">刪除</a>';
    }

    function updateUpDown(id,updown) {
        if(confirm("是否更改信息？")){
            $.ajax({
                url:'/order/good/updateUpDown.do',
                data:{
                    id:id,
                    updown:updown
                },
                method:'post',
                dataType:'json',
                success:function (res) {
                    if(res.status==1){
                        alert('信息修改成功！');
                    }else {
                        alert('信息修改失败！');
                    }
                    $('#goodTable').bootstrapTable('refresh');
                },
                error:function (e) {
                    alert('与服务器连接失败！');
                    console.log(e);
                }
            });
        }
    }


    function deleteGood(id) {
        if(confirm("是否删除信息？")){
            $.ajax({
                url:'/order/good/deleteGood.do',
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
                    $('#goodTable').bootstrapTable('refresh');
                },
                error:function (e) {
                    alert('与服务器连接失败！');
                    console.log(e);
                }
            });
        }
    }

    function imgFun(value,row) {
        return '<img src="/order/static/upload/'+value+'" alt="图片无法加载" title="'+row.gname+'" class="img-rounded" width="80" height="80" />';
    }
</script>
</body>
</html>