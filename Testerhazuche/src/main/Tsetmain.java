package main;

import java.util.List;
import java.util.Scanner;

import entity.Car;
import entity.SelectCar;
import entity.User;
import service.UserService;
import service.Impl.UserServiceImpl;

public class Tsetmain {


	public void Login(){
		Scanner se = new Scanner(System.in);
		UserService us = new UserServiceImpl();
		User users = new User();
		System.out.println("------------��¼------------>>>");
		System.out.println("�û�����");
		String name = se.next();
		users.setUsername(name);
		System.out.println("���룺");
		String pwd = se.next();
		users.setPassword(pwd);
		User ur =us.finduser(users);
		if(ur!=null){
			System.out.println("-------------------------------------");
			System.out.println("��ӭ"+ur.getUsername());
			selectCar();
		}else{
			System.err.println("��¼ʧ�ܣ�");
			Login();
		}
	}
	
	public void selectCar(){
		UserService us = new UserServiceImpl();
		List <SelectCar>  list =us.findCar();
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println("���\t"+"��������\t"+"��ע\t\t"+"Ʒ��\t"+"����\t\t"+"�۸�\t\t"+"�Ƿ����");
		//System.out.println("");
		for (SelectCar scar : list) {
			System.out.println(scar.toString());
		}
	}
}
