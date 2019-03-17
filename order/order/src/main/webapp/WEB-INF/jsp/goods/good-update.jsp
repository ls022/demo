<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/order/static/bootstrap-validator/css/bootstrapValidator.css">

<link rel="stylesheet" href="/order/static/webUpload/webuploader.css">
<script src="/order/static/bootstrap-validator/js/bootstrapValidator.js"></script>
<script src="/order/static/bootstrap-validator/js/language/zh_CN.js"></script>
<script src="/order/static/webUpload/webuploader.js"></script>
<div class="modal-header">
    <button class="close" data-dismiss="modal" aria-label="Close" type="button">
        &times;
    </button>
    <h4>商品信息详情</h4>
</div>
<div class="modal-body">
    <form class="form-horizontal" id="myForm">

        <input type="hidden" name="id" value="${good.id}">

        <div class="form-group"><%--栅格系统--%>
            <label for="gname" class="col-sm-2 control-label">商品名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" value="${good.gname}" id="gname" name="gname" placeholder="请输入商品名称">
            </div>
        </div>
        <div class="form-group">
            <label for="gprice" class="col-sm-2 control-label">商品价格</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="gprice" value="${good.gprice}" name="gprice" placeholder="请输入价格">
            </div>
        </div>
        <div class="form-group">
            <label for="count" class="col-sm-2 control-label">库存</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="count" name="count" value="${good.count}" placeholder="请输入库存数量">
            </div>
        </div>
        <div class="form-group">
            <label for="tid" class="col-sm-2 control-label">商品类型</label>
            <div class="col-sm-10">
                <select name="tid" id="tid" class="form-control">
                    <c:forEach items="${tList}" var="t">
                    <option value="${t.id}" <c:if test="${good.tid==t.id}">selected</c:if> >${t.typename}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="gpath" class="col-sm-2 control-label">商品图片</label>
            <div class="col-sm-10">
                <div id="uploadBtn">上传图片</div>
                <div id="imgDiv">
                    <img src="/order/static/upload/${good.gpath}" alt="" id="imgUrl" class="img-rounded" width="100" height="100">
                </div>
                <input type="hidden" name="gpath" id="gpath" value="${good.gpath}">
            </div>
        </div>

        <%--<button type="submit" class="btn btn-primary">提交2</button>--%>
    </form>
</div>
<div class="modal-footer">
    <button type="button" id="goodSubmit" class="btn btn-primary">提交</button>
    <button type="button" data-dismiss="modal" aria-label="Close" class="btn btn-warning">取消</button>
</div>

<script>
    $(function () {
       $('#goodSubmit').click(function () {

           var bv=$('#myForm').data('bootstrapValidator');//获取表单的验证规则对象
            bv.validate();//启用规则
           if(bv.isValid()){//判断验证是否全部通过
               $.ajax({
                   url:'/order/good/updateUpDown.do',
                   data:$('#myForm').serialize(),//$('#myForm').serialize()序列化表单
                   method:'post',
                   dataType:'json',
                   success:function (res) {
                       if(res.status==1){
                           alert('信息更新成功！');
                           $('#goodModal').modal('hide');//关闭模态窗
                           $('#goodTable').bootstrapTable('refresh');//重新渲染表格
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
               gname:{//要验证的字段的name值
                   validators:{//验证哪些规则
                       notEmpty:{
                            message:'商品名称不能为空！'
                       }
                   }
               },
               gprice:{
                   validators:{
                       notEmpty:{
                           message:'价格不能为空！'
                       },
                       regexp:{
                           regexp:/^[0-9]+(.[0-9]{1,3})?$/,
                           message:'请输入正确的价格！'
                       }
                   }
               },
               count:{
                   validators:{
                       regexp:{
                           regexp:/^\+?[1-9][0-9]*$/,
                           message:'库存只能是正整数'
                       }
                   }
               }
           }
       });

        /*初始化上传插件*/
        var uploader=WebUploader.create({
            pick:'#uploadBtn',//绑定触发上传的按钮
            auto:true,//选择文件后自动上传
            server:'/order/upload/uploadImg.do',//上传文件的处理路径
            accept:{
                title:'Images',
                extensions:'jpg,png,jpeg,gif',//可以上传的文件类型有哪些
                mimeTypes:'image/*'//选择文件时的选项
            }
        });
        //监听上传成功
        uploader.on('uploadSuccess',function (file,res) {
            $('#imgUrl').prop("src","/order/static/upload/"+res.fileName);//预览图片
            $('#gpath').val(res.fileName);//图片名字放入表单元素中
        });

    });
</script>
