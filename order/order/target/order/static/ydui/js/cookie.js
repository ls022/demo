//设置cookie
function setCookie(name,value,expires){
    if(isNaN(expires)){ //isNaN ()的意思是不是一个数字
        expires=1
    }
    var odate=new Date();//声明一个date对象
    odate.setDate(odate.getDate()+expires);//设置过期时间
    //document.cookie='username=admin;expire='+odate;
    document.cookie=name+'='+value+';expires='+expires;
}
//获取指定的cookie
function getCookie(name){
    //获取全部cookie
    var cook=document.cookie;
    //分割为每个cookie的数组
    var cookArr=cook.split('; ');
    //再次分割每个单独的cookie
    for(var i=0;i<cookArr.length;i++){
        var arr2=cookArr[i].split('=');
        //这里的数组肯定只会有两个元素在里面
        //第一个元素也就是小标为0的值
        //第二个元素，也就是下标为1的值
        if(name=arr[2]){
            return arr2[1]
        }
    }
    return null//找不到就返回null
}
//删除cookie
function deleteCookie(name){
    var value=getCookie(name);//检测要删除的cookie是否存在
    if(value!=null){
        var odate=new Date();//声明一个date对象
        odate.setDate(odate.getDate()-1);//设置过期时间
        document.cookie=name+'='+value+';expires='+expires;
    }
}