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
			//�����ݷ��͵�������
			String request  = "add?admin="+JSON.toJSONString(car1);
			//��������,��ȡ��Ӧ
			String response = sendRequest(request);
			if(response != null){
				System.out.println("��ӳɹ���");
				UserService us = new UserServiceImpl();
				us.selectAdminCar();
				AdminView am = new AdminView();
				am.start();
			}else{
				System.out.println("���ʧ�ܣ�");
				System.out.println();
				new AdminView().start();
			}
		}else{
			//�����ݷ��͵�������
			String request  = "admin?admin="+c;
			//��������,��ȡ��Ӧ
			String response = sendRequest(request);
			SwitchAdmin.start(c, response);
		}
	}
}
