<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %><%--启用jsp的el表达式功能--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/order/static/bootstrap/css/bootstrap.css">
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
            <span class="navbar-title">我的购物车</span>
        </div>
        <div class="navbar-item">
            <i class="next-ico"></i>
        </div>
    </header>
    <div class="g-scrollview">
       <article class="m-list list-theme4" id="table">
       </article>
        <div class="m-grids-3">
            <div class="grids-item">
                <div class="grids-txt">总计：</div>
            </div>
            <div class="grids-item" id="total"></div>
            <div class="m-keyboard" id="keyboard"></div>
            <div class="m-button">
                <button id="safe" class="btn btn-danger" style="float: right">结算</button>
            </div>
        </div>
    </div>
    <footer class="m-tabbar">
        <a href="/order/shop/index.do" class="tabbar-item">
            <span class="tabbar-icon"> <i class="icon-good"></i></span>
            <span class="tabbar-txt">热销</span>
        </a>
        <a href="/order/shop/menu.do" class="tabbar-item">
            <span class="tabbar-icon"> <i class="icon-order"></i></span>
            <span class="tabbar-txt">分类</span>
        </a>
        <a href="/order/shop/shop.do" class="tabbar-item tabbar-active" id="shopping">
            <input type="hidden" id="hide">
            <span class="tabbar-icon"> <i class="icon-shopcart-outline"><span class="badge badge-danger"></span></i></span>
            <span class="tabbar-txt">购物车</span>
        </a>
    </footer>
</div>
<script src="/order/static/Jquery/jquery-3.2.1.min.js"></script>
<script src="/order/static/ydui/js/ydui.js"></script>
<script>
    $(function(){
        var num=localStorage.length;  //本地存储数据长度
        var sum=0;  //价格总数存储
        var sums=0; //数量总数存储 角标
        for(var i=0;i<num;i++){
            var list=localStorage.key(i);   //获取本地存储的key值
            var lists=localStorage.getItem(list);   //获取本地存储的value值
            var prices=JSON.parse(lists).price.replace('￥','');  //本地存储价格
            var count=JSON.parse(lists).count; //本地存储数量
            var counts=parseInt(count);  //本地存储数量取整
            var total=JSON.parse(lists).total;    //本地存储总价
            var a=JSON.parse(lists).key;    //本地存储的id值
            //插入点菜的菜单
            if(count>0){
                var html='<a href="#" class="list-item">\n' +
                    '                            <div class="list-img">\n' +
                    '                                <img src="'+JSON.parse(lists).img+'" alt="">\n' +
                    '                            </div>\n' +
                    '                            <div class="list-mes">\n' +
                    '                                <div class="list-title">'+JSON.parse(lists).title+'</div>\n' +
                    '                                <div class="list-mes-item">\n' +
                    '                                    <span class="list-price"><em>￥</em>'+prices+'</span>\n' +
                    '                                    <span class="m-spinner">\n' +
                    '                                        <i class="J_Del"></i>\n' +
                    '                                         <input type="text" class="J_Input" placeholder="" id="'+a+'" value="'+count+'"/>\n' +
                    '                                         <i class="J_Add"></i>\n' +
                    '                                    </span>\n' +
                    '                                    <span>'+total+'</span>\n' +
                    '                                </div>\n' +
                    '                            </div>\n' +
                    '                        </a>';
                $('#table').append(html); //插入点入菜单节点
            }
            sum=sum+total;   //sum为价格总数
            sums=sums+counts;   //sums为count数量总数
        }
        //实例化
        $('.m-spinner').spinner({
            input: '.J_Input',
            add: '.J_Add',
            minus: '.J_Del',
            min: 0,
            callback:function (value,$ele) {
                var title = $($ele).parent().parent().siblings().html();  //标题
                var price = $($ele).parent().siblings().eq(0).text();  //价格
                var count = $($ele).val();   //数量
                var countid = $($ele).attr("id");  //id值
                var img = $($ele).parent().parent().parent().siblings().children().attr("src");   //图片
                var prices = price.replace("￥", "");      //价格取数字
                if (value == 0) {
                    $($ele).parents(".list-item").hide();    //如果数量为零 从列表删除
                }
                //把所有内容写入一个对象
                var lists = {
                    title: title,
                    price: price,
                    img: img,
                    count: count,
                    total: parseInt(prices * value),
                    key: countid
                };
                lists = JSON.stringify(lists);  //把对象解析成字符窜
                localStorage.setItem(countid, lists);   //写入本地存储
                $($ele).parent().next().html(parseInt(prices * value));//计算价格
                //如果发生变化 重新计算
               var summ=0;    //价格总数
               var summs=0;   //角标计算
                for(var i=0;i<localStorage.length;i++) {
                    var val=JSON.parse(localStorage.getItem(localStorage.key(i))).total;    //本地存储每个菜品的总价
                    var vals=parseInt(JSON.parse(localStorage.getItem(localStorage.key(i))).count);  //本地存储中每个菜品的数量
                    //如果大于0 总价加在一起 角标加在一起
                    if(val>0) {
                        summ=val+summ;
                        summs=vals+summs;
                    }
                }
                var s = '<div class="grids-txt"><em>￥</em>' + summ + '</div>';  //另s=价格总数
                $('#total').html(s);      //里面的价格值
                //如果当前的value值为0，删除这一条的本地数据
                if(value==0){
                    localStorage.removeItem($ele.prop('id'));
                }
                //如果本地存储长度为0 角标隐藏 并且结算一栏隐藏
                //本地存储长度大于0 角标和结算一栏显示
                if(localStorage.length>0){
                    $('.badge-danger').show().html(summs) ;
                    $('.m-grids-3').show();
                }
                if(localStorage.length==0){
                    $('.m-grids-3').hide();
                    $('.badge-danger').hide();
                }
            }
        });
        //计算总价格 并把总价格插入页面中
        if(sums==0){
            $('.badge-danger').hide();
            $('.m-grids-3').hide()
        }
        if(sums>0){
            $('.badge-danger').show().html(sums);

        }
    });

    $('#safe').click(function(){
        var sumprice=0;//初始化总价
        var goods,price;
        var gids=[];//初始化存放商品id的数组
        var cs=[];//初始化存放商品个数的数组
        for (var i=0;i<localStorage.length;i++){
            goods=localStorage.getItem(localStorage.key(i));//本地存储中拿到所有被选择的商品信息
            var key=JSON.parse(goods).key;//获取商品的key信息，这个key信息中存有商品id，格式count11，则表示id为11
            var id=key.replace("count","");//替换count为空字符，则得到id
            gids.push(id);//得到的id值放入数组的最后一位
            cs.push(JSON.parse(goods).count);
            var prices=JSON.parse(goods).price;//计算总价格
            price=prices.replace("￥","");
            sumprice+=parseInt(price)*parseInt(JSON.parse(goods).count);
        }
        gids=gids+'';//数组无法通过请求传递，转换成字符串
        cs=cs+'';
        $.ajax({
            url:'/order/shop/doShop.do',
            data:{
                price:sumprice,
                gids:gids,
                cs:cs
            },
            method:'post',
            dataType:'json',
            success:function (res) {
                if(res.status>0){
                    YDUI.dialog.toast('下单成功！', 'success');
                    localStorage.clear();
                    window.location.href='/order/shop/index.do';
                }else{
                    YDUI.dialog.toast('下单失败！', 'error');
                }
            }
        });
    });

</script>
</body>
</html>