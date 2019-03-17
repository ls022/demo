package dao;

import java.util.List;

import com.alibaba.fastjson.JSON;

import entity.Car;
import entity.UserRentListCar;
import service.UserService;
import service.Impl.UserServiceImpl;
import view.AdminView;
import view.LoginView;
import view.UpdateView;

public class SwitchAdmin {

	public static void start(String c , String response){
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
			Car car = JSON.parseObject(response, Car.class);
			System.out.println("编号\t"+"车牌号\t\t"+"汽车名称\t\t"+"颜色\t\t"+"备注\t\t\t"+"品牌\t\t"+"类型\t\t\t"+"价格\t"+"车价\t\t"+"是否可租\t\t"+"是否上架");
			//System.out.println(car.getId());
			System.out.println(car.toCarString());
			System.out.println();
			new AdminView().start();
		case "5" :
			List<Car> list = JSON.parseArray(response, Car.class);
			System.out.println("编号\t"+"车牌号\t\t"+"汽车名称\t\t"+"颜色\t\t"+"备注\t\t\t"+"品牌\t\t"+"类型\t\t\t"+"价格\t"+"车价\t\t"+"是否可租\t\t"+"是否上架");
			for (Car car2 : list) {
				System.out.println(car2.toString());
			}
			System.out.println();
			new AdminView().start();
		case "7" :
			Car car1 = JSON.parseObject(response, Car.class);
			System.out.println("----------------------------------------------------------------------------------------------------------");
			System.out.println("编号\t"+"汽车名称\t\t"+"备注\t\t"+"品牌\t\t"+"类型\t\t\t"+"价格\t"+"车价\t\t\t"+"是否可租\t\t"+"是否上架");
			System.out.println(car1.toupdateString());
			String cc[] = c.split("\\+");
			int idcar = Integer.parseInt(cc[1]);
			new UpdateView().start(idcar);
		case "8" :
			List<UserRentListCar> list1 = JSON.parseArray(response, UserRentListCar.class);
			System.out.println("-------------------------------------------");
			System.out.println("编号\t"+"汽车编号\t"+"汽车名称\t"+"用户编号\t"+"用户名\t\t"+"租金\t"+"租金总额\t"+"备注\t\t\t"+"品牌\t\t"+"类型\t\t\t"+"借车时间\t\t\t\t\t"+"还车时间 ");
			//System.out.println("");
			for (UserRentListCar scar : list1) {
				System.out.println(scar.toRecord());
			}
			System.out.println();
			new AdminView().start();
		default :
			System.out.println("输入有误！");
		}
	}
}
