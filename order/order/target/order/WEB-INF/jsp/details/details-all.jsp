<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %><%--启用jsp的el表达式功能--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal-header">
    <button class="close" data-dismiss="modal" aria-label="Close" type="button">
        &times;
    </button>
    <h4>订单详情</h4>
</div>
<div class="modal-body">
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12 main">
            <div class="table-responsive">
                <table id="detailTable"></table>
            </div>
        </div>
    </div>
</div>
</div>
<div class="modal-footer">
    <button type="button" data-dismiss="modal" aria-label="Close" class="btn btn-warning">取消</button>
</div>
<script>
    $(function () {
        $('#detailTable').bootstrapTable({
            url:'/order/detail/getAll.do?id=${gid}',//请求地址
            method:'get',//请求方式
            pagination:true,//开启分页功能
            pageSize:5,//每页显示的条数
            pageList:[5,10,15,30,50,100],//分页下拉框设置（该数组首项必须是pageSize的值）
            sidePagination:'server',//分页方式
            columns:[
                {field:'id',title:'编号',align:'center',valign:'middle'},
                {field:'gname',title:'商品名称',align:'center',valign:'middle'},
                {field:'gcount',title:'商品总数',align:'center',valign:'middle'},
                {title:'总价',formatter:'sumPrice',align:'center',valign:'middle'}
            ]
        });
    });

    function sumPrice(value,row) {
        return row.gcount*row.gprice;
    }

</script>
