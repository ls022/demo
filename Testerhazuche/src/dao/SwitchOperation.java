package dao;

import java.util.List;

import com.alibaba.fastjson.JSON;

import entity.SelectCar;
import entity.UserRentCar;
import entity.UserRentListCar;
import service.UserService;
import service.Impl.UserServiceImpl;
import view.LoginView;
import view.RentCarView;

public class SwitchOperation {

	public static void start(String c,String response){
		String aa = null;
		String[] array =c.split("\\+");
		if(array.length == 2){
			aa= array[0];
		}else{
			aa = c;
		}
		switch(aa){
			case "0" :
				new LoginView().Login();
				break;
			case "1" :
				//把response字符串转换成User对象
				UserRentCar urc = JSON.parseObject(response, UserRentCar.class);
				System.out.println("-----------------------------------------------");
				if(urc !=null){
					System.out.println("借车成功！ 租车信息如下：");
					System.out.println("编号\t"+"汽车名称\t"+"每日租金\t\t"+"备注\t\t\t"+"品牌\t\t"+"类型\t\t\t"+"借车时间");
					System.out.println(urc.toString());
					System.out.println();
					 new RentCarView().start();
				}else{
					System.out.println("借车失败！");
					System.out.println();
					 new RentCarView().start();
				}
				break;
			case "2" :
				if(response.equals(null)){
					System.out.println("输入有误！");
					System.out.println();
					 new RentCarView().start();
				}else{
					List<SelectCar> list = JSON.parseArray(response, SelectCar.class);
					System.out.println();
					System.out.println("-------------------用户汽车查询界面------------------------");
					System.out.println("编号\t"+"汽车名称\t"+"备注\t\t"+"品牌\t\t"+"类型\t\t\t"+"价格\t\t"+"是否可租");
					//System.out.println("");
					for (SelectCar scar : list) {
						System.out.println(scar.toString());
					}
					System.out.println();
					 new RentCarView().start();
				}
				 break;
			case "3" :
				if(response.equals(null)){
					System.out.println("输入有误！");
					System.out.println();
					 new RentCarView().start();
				}else{
					List<SelectCar> list1 = JSON.parseArray(response, SelectCar.class);
					System.out.println();
					System.out.println("-------------------用户汽车查询界面------------------------");
					System.out.println("编号\t"+"汽车名称\t"+"备注\t\t"+"品牌\t\t"+"类型\t\t\t"+"价格\t\t"+"是否可租");
					//System.out.println("");
					for (SelectCar scar : list1) {
						System.out.println(scar.toString());
					}
					System.out.println();
					 new RentCarView().start();
				}
				break;
			case "4" :
				if(response.equals(null)){
					System.out.println("输入有误！");
					System.out.println();
					 new RentCarView().start();
				}else{
					List<SelectCar> list2 = JSON.parseArray(response, SelectCar.class);
					System.out.println();
					System.out.println("-------------------用户汽车查询界面------------------------");
					System.out.println("编号\t"+"汽车名称\t"+"备注\t\t"+"品牌\t\t"+"类型\t\t\t"+"价格\t\t"+"是否可租");
					//System.out.println("");
					for (SelectCar scar : list2) {
						System.out.println(scar.toString());
					}
					System.out.println();
					 new RentCarView().start();
				}
				 break;
			case "5" :
				List<SelectCar> list3 = JSON.parseArray(response, SelectCar.class);
				System.out.println();
				System.out.println("-------------------用户汽车查询界面------------------------");
				System.out.println("编号\t"+"汽车名称\t"+"备注\t\t"+"品牌\t\t"+"类型\t\t\t"+"价格\t\t"+"是否可租");
				//System.out.println("");
				for (SelectCar scar : list3) {
					System.out.println(scar.toString());
				}
				System.out.println();
				 new RentCarView().start();
				 break;
			 case "6" :
				 List<UserRentListCar> list4 = JSON.parseArray(response, UserRentListCar.class);
					System.out.println("-------------------------------------------");
					System.out.println("编号\t"+"汽车编号\t"+"汽车名称\t"+"租金总额\t"+"备注\t\t\t"+"品牌\t\t"+"类型\t\t\t"+"借车时间\t\t\t\t\t"+"还车时间 ");
					//System.out.println("");
					for (UserRentListCar scar : list4) {
						System.out.println(scar.toString());
					}
					System.out.println();
					 new RentCarView().start();
					 break;
			 case "7" :
				 int user_id = 0;
				 int car_id  = 0;
				 if(response.equals(null)){
					 System.out.println("---------------------------------------");
					 System.out.println("还车失败！");
					 System.out.println();
					 new RentCarView().start();
					 break;
				 }else{
					 try{
					 user_id =Integer.parseInt(response);
					 car_id = Integer.parseInt(array[1]);
					 }catch(Exception e){
						 System.out.println("输入有误！");
					 }
					 System.out.println("---------------------------------------");
					 System.out.println("还车成功！ 还车信息如下：");
					 UserService us = new  UserServiceImpl();
					 UserRentListCar urlc = us.repayCar(user_id, car_id);
					 System.out.println("汽车编号\t"+"汽车名称\t"+"租金\t"+"租金总额\t"+"备注\t\t\t"+"品牌\t\t"+"类型\t\t\t"+"借车时间\t\t\t\t\t"+"还车时间 ");
					 System.out.println(urlc.toCar());
					 System.out.println();
					 new RentCarView().start();
				 }
			default :
				System.out.println("输入有误！");
		}
	}
}
