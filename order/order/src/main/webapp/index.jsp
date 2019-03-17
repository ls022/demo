<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.css">
    <script src="static/Jquery/jquery-3.2.1.min.js"></script>
    <script src="static/bootstrap/js/bootstrap.js"></script>
</head>
<body>
    <div id="div1">
        <form id="loginForm">
            <p>
                <label for="username">用户名</label>
                <input type="text" id="username" name="username" placeholder="请输入用户名">
            </p>
            <p>
                <label for="pwd">密码</label>
                <input type="password" id="pwd" name="password" placeholder="请输入用户名">
            </p>
            <p>
                <button type="button" id="loginBtn">登录</button>
            </p>
        </form>
    </div>
</body>
<script>
    /*ready函数*/
    /*js的onload事件和jq的ready函数区别：*/
    /*1.js的onload事件在页面资源全部加载完毕后才会执行，jq的ready函数在dom层渲染完毕就执行*/
    /*2.js的onload事件一个页面只能存在一个，如果有多个，后面的会覆盖前面的，jq的ready函数，可以有多个依次执行*/
        $(function () {
            $('#loginBtn').click(function () {

                var username=$('#username').val();//获取input框的值
                var password=$('#pwd').val();//获取密码框的值

                if(!username){
                    alert('请输入用户名！');
                    return;
                }
                if(!password){
                    alert('请输入密码！');
                    return;
                }


                $.ajax({
                    url:'/order/user/login.do',
                    method:'post',
                    data:{
                        username:username,
                        password:password
                    },
                    dataType:'json',
                    success:function (res) {
                        if(res.status==1){
                            location.href='/order/user/toList.do';
                        }else {
                            alert('用户名或密码不正确！');
                        }
                    },
                    error:function (err) {
                        alert('与服务器连接失败，请稍候再试...');
                        console.log(err);
                    }
                });
            });
    });
</script>
</html>
