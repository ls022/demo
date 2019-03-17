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
		System.out.println("------------登录------------>>>");
		System.out.println("用户名：");
		String name = se.next();
		users.setUsername(name);
		System.out.println("密码：");
		String pwd = se.next();
		users.setPassword(pwd);
		User ur =us.finduser(users);
		if(ur!=null){
			System.out.println("-------------------------------------");
			System.out.println("欢迎"+ur.getUsername());
			selectCar();
		}else{
			System.err.println("登录失败！");
			Login();
		}
	}
	
	public void selectCar(){
		UserService us = new UserServiceImpl();
		List <SelectCar>  list =us.findCar();
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println("编号\t"+"汽车名称\t"+"备注\t\t"+"品牌\t"+"类型\t\t"+"价格\t\t"+"是否可租");
		//System.out.println("");
		for (SelectCar scar : list) {
			System.out.println(scar.toString());
		}
	}
}
