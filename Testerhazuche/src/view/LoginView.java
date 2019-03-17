package view;

import java.util.List;

import com.alibaba.fastjson.JSON;

import client.Client;
import dao.InputUtil;
import entity.SelectCar;
import entity.User;
import service.UserService;
import service.Impl.UserServiceImpl;
/**
 * 用户登录界面
 * @author oracleOAEC
 *
 */
public class LoginView extends Client{

	public void Login(){
		System.out.println("----------------登录---------------->>>");
		System.out.println("用户名:");
		String username = InputUtil.next();
		System.out.println("密码");
		String password = InputUtil.next();
		//System.out.println("账户类型(0:普通用户  1:管理员):");
		//int type = InputUtil.nextInt();
		User user = new User(username,password);
		//把数据发送到服务器              对象->Json字符串的转换
		String request  = "login?user= "+JSON.toJSONString(user);
		//System.out.println(request);
		//发送请求,获取相应
		String response = sendRequest(request);
		//把response字符串转换成User对象
		User result = JSON.parseObject(response, User.class);
		if(result != null){
			System.out.println("登录成功!");
			System.out.println("欢迎"+result.getUsername());
			if(result.getType() == 0) {
				UserService us = new UserServiceImpl();
				us.selectCar();
				RentCarView rcv =new RentCarView();
				rcv.start();
			}else if(result.getType() == 1) {
				UserService us = new UserServiceImpl();
				us.selectAdminCar();
				AdminView am = new AdminView();
				am.start();
			}
			
		}else{
			System.out.println("登录失败!");
			Login();
		}
	}
}
