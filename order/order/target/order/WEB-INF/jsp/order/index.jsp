<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %><%--启用jsp的el表达式功能--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/order/static/ydui/css/ydui.css">
    <script src="/order/static/ydui/js/ydui.flexible.js"></script>
</head>
<body>
<div class="g-flexview">
    <header class="m-navbar">
        <div class="navbar-item">
            <i class="back-ico"></i>
        </div>
        <div class="navbar-center">
            <span class="navbar-title">云中城餐厅</span>
        </div>
        <div class="navbar-item">
            <i class="next-ico"></i>
        </div>
    </header>
    <div class="g-scrollview" id="J_list">
        <article class="m-list list-theme3" id="J_ListContent">

        </article>
        <div id="shop"></div>
    </div>
    <footer class="m-tabbar">
        <a href="/order/shop/index.do" class="tabbar-item tabbar-active">
            <span class="tabbar-icon"> <i class="icon-good"></i></span>
            <span class="tabbar-txt">热销</span>
        </a>
        <a href="/order/shop/menu.do" class="tabbar-item">
            <span class="tabbar-icon"> <i class="icon-order"></i></span>
            <span class="tabbar-txt">分类</span>
        </a>
        <a href="/order/shop/shop.do" class="tabbar-item" id="shopping">
            <input type="hidden" id="hide">
            <span class="tabbar-icon"> <i class="icon-shopcart-outline"><span class="badge badge-danger"></span></i></span>
            <span class="tabbar-txt">购物车</span>
        </a>
    </footer>
</div>
<script src="/order/static/Jquery/jquery-3.2.1.min.js"></script>
<script src="/order/static/ydui/js/ydui.js"></script>

<script>
    /*无限加载*/
    var page = 1,pageSize = 11;
    $('#J_list').infiniteScroll({
        binder:'#J_list',
        pageSize: pageSize,
        initLoad: true,
        loadingHtml: '<strong>加载中...</strong>', /* 当然也可以<img src="../img/loading.gif" /> */
        loadListFn: function () {
            var def = $.Deferred();
            /* 通过自定义的方法获取数据 */
            $.ajax({
                url: '/order/shop/getHot.do',
                method:'get',
                data: { page: page, pagesize: pageSize },
                success: function (ret) {
                    /* 用你喜欢的方法将获取到的数据拼接成HTML，然后插入；*/
                    /* 建议使用模板引擎，示例使用artTemplate；https://github.com/aui/artTemplate */
                    for(var i=0;i<ret.length;i++){
                        var  html ='<a href="#" class="list-item">\n' +
                                '                    <div class="list-img">\n' +
                                '                        <img src="/order/static/upload/'+ret[i].gpath+'" alt="" height="330px">\n' +
                                '                    </div>\n' +
                                '                    <div class="list-mes">\n' +
                                '                        <div class="list-title">'+ret[i].gname+'</div>\n' +
                                '                        <div class="list-mes-item">\n' +
                                '                            <span class="list-price"><em>￥</em>'+ret[i].gprice+'</span>\n' +
                                '                            <span class="m-spinner">\n' +
                                '                                <i class="J_Del"></i>\n' +
                                '                                <input type="text" class="J_Input" placeholder=""  id="count'+ret[i].id+'"/>\n' +
                                '                                <i class="J_Add"></i>\n' +
                                '                            </span>\n' +
                                '                        </div>\n' +
                                '                    </div>\n' +
                                '                </a>';
                        $('#J_ListContent').append(html);
                    }
                    //每条信息input框的id值为count+数字
                    //获取本地存储中input框中的数值 写入到input框里
                    for(var i=0;i<localStorage.length;i++){
                        var good=localStorage.key(i);  //得到key值
                        var goods=localStorage.getItem(good);   //得到本地存储数据
                        var number=JSON.parse(goods).count;    //把数据转化成对象 取到里面的count值
                        var a=JSON.parse(goods).key;     //取到本地数据的key值 和id值一样
                        var numbers=parseInt(number);     //把count值转化成数值
                        $('#'+a+'').val(numbers)       //如果数值大于0，把数值写入input框里
                    }
                    //实例化
                    $('.m-spinner').spinner({
                        input: '.J_Input',
                        add: '.J_Add',
                        minus: '.J_Del',
                        min:0,
                        callback: function (value, $ele){
                            //如果input框值为0，它和减号都隐藏 并删除本地存储的这条数据
                            if(value==0){
                                $($ele).hide();
                                $($ele).siblings().eq(0).hide();
                                localStorage.removeItem($ele.prop('id'));
                            }
                            if(value>0){
                                //如果input框值大于0，它和减号都显示
                                $($ele).show();
                                $($ele).siblings().show();
                                //获取页面中要存入本地存储的信息
                                var title=$ele.parent().parent().siblings().html();  //标题
                                var price =$ele.parent().siblings().eq(0).text();  //价格
                                var count=$ele.val();    //数量
                                var countid=$ele.attr("id");   //input框的id值
                                var img=$ele.parent().parent().parent().siblings().children().attr("src");  //图片
                                var prices=price.replace("￥","");    //价格取数字
                                //把所有内容写入一个对象
                                var lists={
                                    title:title,
                                    price:price,
                                    img:img,
                                    count:count,
                                    total:parseInt(prices*value),
                                    key:countid
                                };
                                lists=JSON.stringify(lists);  //把对象解析成字符串
                                localStorage.setItem(countid,lists);  //写入本地存储
                            }
                            var num=localStorage.length;  //获取本地存储的长度
                            var sums=0;      //角标计算 声明变量 接收角标
                            //遍历本地存储的数组  获取里面的count值 把数量值加起来 用sums接收
                            for(var i=0;i<num;i++){
                                var good=localStorage.key(i);
                                var goods=localStorage.getItem(good);
                                var number=JSON.parse(goods).count;
                                var numbers=parseInt(number);
                                sums=sums+numbers;
                            }
                            //如果数量总数为0 角标隐藏
                            if(sums==0){
                                $('.badge-danger').hide();
                            }
                            //如果数量大于0，角标显示
                            if(sums>0){
                                $('.badge-danger').show().html(sums)
                            }
                        }
                    });
                    /* 获取数据，并插入页面后，调用resole，并传入当前获取的记录列表集合 */
                    def.resolve(ret);
                    /* 页码自增1 */
                }
            });
            return def.promise();
        }
    });
</script>
</body>
</html>