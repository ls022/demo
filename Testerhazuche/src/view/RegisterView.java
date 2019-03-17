package view;

import entity.User;
import service.UserService;
import service.Impl.UserServiceImpl;

import com.alibaba.fastjson.JSON;

import client.Client;
import dao.InputUtil;

/**
 * 用户注册界面
 * @author oracleOAEC
 *
 */
public class RegisterView extends Client{

	

	public void start(){
		int sex = 0;
		System.out.println("------------------注册-----------------");
		System.out.println("用户名:");
		String username = InputUtil.next();
		System.out.println("密码:");
		String password = InputUtil.next();
		System.out.println("性别(0:男  1:女):");
		try{
		 sex = InputUtil.nextInt();
		}catch(Exception e){
			if(sex ==10){
			System.out.println("输入有误！");
			}
		}
		System.out.println();
		System.out.println("身份证号:");
		String id_number = InputUtil.next();
		System.out.println("电话:");
		String  tel = InputUtil.next();
		System.out.println("地址:");
		String  addr = InputUtil.next();
		User user = new User(username, 
				password, sex, id_number, tel, addr);
		// 把数据发送到服务器
		String request = "new?newuser="+JSON.toJSONString(user);
		// 发送请求 ，获取相应
		String response = sendRequest(request);
		if(request != null){   //注册成功
			System.out.println("恭喜你注册成功!");
			//回到主界面
			new StartView().start();
		}else{    //注册失败
			System.out.println("注册失败!");
		}		
	}
	
	public static void main(String[] args) {
		RegisterView view = new RegisterView();
		view.start();
	}
}
