package view;

import com.alibaba.fastjson.JSON;

import client.Client;
import dao.InputUtil;
import dao.OperationDao;
import dao.SwitchAdmin;
import dao.Impl.OperationDaoImpl;
import entity.Car;
import service.UserService;
import service.Impl.UserServiceImpl;

public class AdminView extends Client {

	public void start(){
		OperationDao od = new OperationDaoImpl();
		od.operationAdminCar();
		String c = InputUtil.next();
		if(c.equals("6")){
			UserService us2 = new UserServiceImpl();
			Car car1 = us2.addCar();
			//把数据发送到服务器
			String request  = "add?admin="+JSON.toJSONString(car1);
			//发送请求,获取相应
			String response = sendRequest(request);
			if(response != null){
				System.out.println("添加成功！");
				UserService us = new UserServiceImpl();
				us.selectAdminCar();
				AdminView am = new AdminView();
				am.start();
			}else{
				System.out.println("添加失败！");
				System.out.println();
				new AdminView().start();
			}
		}else{
			//把数据发送到服务器
			String request  = "admin?admin="+c;
			//发送请求,获取相应
			String response = sendRequest(request);
			SwitchAdmin.start(c, response);
		}
	}
}
