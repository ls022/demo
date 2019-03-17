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
</head>

<body>

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
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>商品名称</th>
                        <th>商品价格</th>
                        <th>商品类型</th>
                        <th>商品库存</th>
                        <th>上架/下架</th>
                        <th>启用/禁用</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="g" items="${gList}">
                            <tr>
                                <td>${g.id}</td>
                                <td>${g.gname}</td>
                                <td>${g.gprice}</td>
                                <td>${g.typename}</td>
                                <td>${g.count}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${g.updown==1}">上架</c:when>
                                        <c:otherwise>下架</c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${g.status==1}">可用</c:when>
                                        <c:otherwise>禁用</c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="/order/static/Jquery/jquery-3.2.1.min.js"></script>
<script src="/order/static/bootstrap/js/bootstrap.js"></script>


</body>
</html>