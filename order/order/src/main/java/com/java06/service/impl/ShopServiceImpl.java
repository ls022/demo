package com.java06.service.impl;

import com.java06.mapper.DetailsMapper;
import com.java06.mapper.GoodsMapper;
import com.java06.mapper.OrdersMapper;
import com.java06.mapper.TypesMapper;
import com.java06.pojo.Details;
import com.java06.pojo.Goods;
import com.java06.pojo.Orders;
import com.java06.pojo.Types;
import com.java06.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;


@Service
@Transactional
public class ShopServiceImpl implements ShopService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private TypesMapper typesMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private DetailsMapper detailsMapper;

    @Override
    public Map<String, Object> getAllList() {
        Map<String,Object> map=new HashMap<>();
        List<Goods> glist=goodsMapper.getAll(new Goods());
        List<Types> tlist=typesMapper.getAll(new Types());
        map.put("glist",glist);
        map.put("tlist",tlist);
        return map;
    }

    @Override
    public Map<String, Object> doShop(Orders orders, String[] gids,String[] cs) {
        Date date=new Date();//获取当前系统时间
        //格式化输出时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=sdf.format(date);
        orders.setTime(time);
        int status=ordersMapper.insertSelective(orders);
        //订单添加成功后，orders对象中的id属性自动获得新插入的数据的id
        //OrdersMapper.xml文件的37行里，增加了useGeneratedKeys="true" keyProperty="id"这两个属性实现的自动绑定新id的功能。
        if(status>0&&gids!=null){
            List<Details> dlist=new ArrayList<>();
            //遍历gids数组，把字符串数组转换为int数组，拿出每个商品id放入list集合。
            //cs和gids的数组长度和顺序是一致的，在shop.jsp的169行到177行存储的。
            for(int i=0;i<gids.length;i++){
                Details details=new Details();
                Integer gid=Integer.parseInt(gids[i]);
                Integer count=Integer.parseInt(cs[i]);

                //遍历到的每个商品id和商品个数，要去查询一下当前这个商品被点餐的个数是多少

                Goods goods=goodsMapper.selectByPrimaryKey(gid);
                Integer newCount=count+goods.getCount();//最新的被点数量是当前点的数量+之前被点的个数
                goods.setCount(newCount);//新的被点数量封装回去
                goodsMapper.updateByPrimaryKeySelective(goods);//修改商品被点餐个数为最新值

                //封装订单细节到实体类
                details.setOid(orders.getId());
                details.setGid(gid);
                details.setGcount(count);
                //封装到集合中，下面批量添加
                dlist.add(details);
            }
            status=detailsMapper.betchInsert(dlist);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("status",status);
        return map;
    }
}
