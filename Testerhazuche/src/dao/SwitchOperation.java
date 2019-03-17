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
				//��response�ַ���ת����User����
				UserRentCar urc = JSON.parseObject(response, UserRentCar.class);
				System.out.println("-----------------------------------------------");
				if(urc !=null){
					System.out.println("�賵�ɹ��� �⳵��Ϣ���£�");
					System.out.println("���\t"+"��������\t"+"ÿ�����\t\t"+"��ע\t\t\t"+"Ʒ��\t\t"+"����\t\t\t"+"�賵ʱ��");
					System.out.println(urc.toString());
					System.out.println();
					 new RentCarView().start();
				}else{
					System.out.println("�賵ʧ�ܣ�");
					System.out.println();
					 new RentCarView().start();
				}
				break;
			case "2" :
				if(response.equals(null)){
					System.out.println("��������");
					System.out.println();
					 new RentCarView().start();
				}else{
					List<SelectCar> list = JSON.parseArray(response, SelectCar.class);
					System.out.println();
					System.out.println("-------------------�û�������ѯ����------------------------");
					System.out.println("���\t"+"��������\t"+"��ע\t\t"+"Ʒ��\t\t"+"����\t\t\t"+"�۸�\t\t"+"�Ƿ����");
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
					System.out.println("��������");
					System.out.println();
					 new RentCarView().start();
				}else{
					List<SelectCar> list1 = JSON.parseArray(response, SelectCar.class);
					System.out.println();
					System.out.println("-------------------�û�������ѯ����------------------------");
					System.out.println("���\t"+"��������\t"+"��ע\t\t"+"Ʒ��\t\t"+"����\t\t\t"+"�۸�\t\t"+"�Ƿ����");
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
					System.out.println("��������");
					System.out.println();
					 new RentCarView().start();
				}else{
					List<SelectCar> list2 = JSON.parseArray(response, SelectCar.class);
					System.out.println();
					System.out.println("-------------------�û�������ѯ����------------------------");
					System.out.println("���\t"+"��������\t"+"��ע\t\t"+"Ʒ��\t\t"+"����\t\t\t"+"�۸�\t\t"+"�Ƿ����");
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
				System.out.println("-------------------�û�������ѯ����------------------------");
				System.out.println("���\t"+"��������\t"+"��ע\t\t"+"Ʒ��\t\t"+"����\t\t\t"+"�۸�\t\t"+"�Ƿ����");
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
					System.out.println("���\t"+"�������\t"+"��������\t"+"����ܶ�\t"+"��ע\t\t\t"+"Ʒ��\t\t"+"����\t\t\t"+"�賵ʱ��\t\t\t\t\t"+"����ʱ�� ");
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
					 System.out.println("����ʧ�ܣ�");
					 System.out.println();
					 new RentCarView().start();
					 break;
				 }else{
					 try{
					 user_id =Integer.parseInt(response);
					 car_id = Integer.parseInt(array[1]);
					 }catch(Exception e){
						 System.out.println("��������");
					 }
					 System.out.println("---------------------------------------");
					 System.out.println("�����ɹ��� ������Ϣ���£�");
					 UserService us = new  UserServiceImpl();
					 UserRentListCar urlc = us.repayCar(user_id, car_id);
					 System.out.println("�������\t"+"��������\t"+"���\t"+"����ܶ�\t"+"��ע\t\t\t"+"Ʒ��\t\t"+"����\t\t\t"+"�賵ʱ��\t\t\t\t\t"+"����ʱ�� ");
					 System.out.println(urlc.toCar());
					 System.out.println();
					 new RentCarView().start();
				 }
			default :
				System.out.println("��������");
		}
	}
}
