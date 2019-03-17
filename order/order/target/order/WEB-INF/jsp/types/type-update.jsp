<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/order/static/bootstrap-validator/css/bootstrapValidator.css">

<script src="/order/static/bootstrap-validator/js/bootstrapValidator.js"></script>
<script src="/order/static/bootstrap-validator/js/language/zh_CN.js"></script>
<div class="modal-header">
    <button class="close" data-dismiss="modal" aria-label="Close" type="button">
        &times;
    </button>
    <h4>类型信息详情</h4>
</div>
<div class="modal-body">
    <form class="form-horizontal" id="myForm">

        <input type="hidden" name="id" value="${ttt.id}">

        <div class="form-group"><%--栅格系统--%>
            <label for="typename" class="col-sm-2 control-label">类型名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" value="${ttt.typename}" id="typename" name="typename" placeholder="请输入商品名称">
            </div>
        </div>
    </form>
</div>
<div class="modal-footer">
    <button type="button" id="typeSubmit" class="btn btn-primary">提交</button>
    <button type="button" data-dismiss="modal" aria-label="Close" class="btn btn-warning">取消</button>
</div>

<script>
    $(function () {
       $('#typeSubmit').click(function () {

           var bv=$('#myForm').data('bootstrapValidator');//获取表单的验证规则对象
            bv.validate();//启用规则
           if(bv.isValid()){//判断验证是否全部通过
               $.ajax({
                   url:'/order/type/doUpdate.do',
                   data:$('#myForm').serialize(),//$('#myForm').serialize()序列化表单
                   method:'post',
                   dataType:'json',
                   success:function (res) {
                       if(res.status==1){
                           alert('信息更新成功！');
                           $('#typeModal').modal('hide');//关闭模态窗
                           $('#typeTable').bootstrapTable('refresh');//重新渲染表格
                       }else{
                           alert('信息更新失败！');
                       }

                   },
                   error:function (err) {
                       alert('与服务器连接失败，请稍候再试...');
                       console.log(err);
                   }
               });
           }

       });
        /*初始化验证工具*/
       $('#myForm').bootstrapValidator({
            /*设置验证样式*/
           feedbackIcons:{
               valid:'glyphicon glyphicon-ok',//验证通过
               invalid:'glyphicon glyphicon-remove',//验证失败
               validating:'glyphicon glyphicon-refresh'//正在验证
           },
           fields:{//要验证的字段有哪些写在这里
               typename:{//要验证的字段的name值
                   validators:{//验证哪些规则
                       notEmpty:{
                            message:'商品名称不能为空！'
                       }
                   }
               }
           }
       });
    });
</script>
