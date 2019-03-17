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
			System.out.println("���\t"+"���ƺ�\t\t"+"��������\t\t"+"��ɫ\t\t"+"��ע\t\t\t"+"Ʒ��\t\t"+"����\t\t\t"+"�۸�\t"+"����\t\t"+"�Ƿ����\t\t"+"�Ƿ��ϼ�");
			//System.out.println(car.getId());
			System.out.println(car.toCarString());
			System.out.println();
			new AdminView().start();
		case "5" :
			List<Car> list = JSON.parseArray(response, Car.class);
			System.out.println("���\t"+"���ƺ�\t\t"+"��������\t\t"+"��ɫ\t\t"+"��ע\t\t\t"+"Ʒ��\t\t"+"����\t\t\t"+"�۸�\t"+"����\t\t"+"�Ƿ����\t\t"+"�Ƿ��ϼ�");
			for (Car car2 : list) {
				System.out.println(car2.toString());
			}
			System.out.println();
			new AdminView().start();
		case "7" :
			Car car1 = JSON.parseObject(response, Car.class);
			System.out.println("----------------------------------------------------------------------------------------------------------");
			System.out.println("���\t"+"��������\t\t"+"��ע\t\t"+"Ʒ��\t\t"+"����\t\t\t"+"�۸�\t"+"����\t\t\t"+"�Ƿ����\t\t"+"�Ƿ��ϼ�");
			System.out.println(car1.toupdateString());
			String cc[] = c.split("\\+");
			int idcar = Integer.parseInt(cc[1]);
			new UpdateView().start(idcar);
		case "8" :
			List<UserRentListCar> list1 = JSON.parseArray(response, UserRentListCar.class);
			System.out.println("-------------------------------------------");
			System.out.println("���\t"+"�������\t"+"��������\t"+"�û����\t"+"�û���\t\t"+"���\t"+"����ܶ�\t"+"��ע\t\t\t"+"Ʒ��\t\t"+"����\t\t\t"+"�賵ʱ��\t\t\t\t\t"+"����ʱ�� ");
			//System.out.println("");
			for (UserRentListCar scar : list1) {
				System.out.println(scar.toRecord());
			}
			System.out.println();
			new AdminView().start();
		default :
			System.out.println("��������");
		}
	}
}
