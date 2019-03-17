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
 * �û���¼����
 * @author oracleOAEC
 *
 */
public class LoginView extends Client{

	public void Login(){
		System.out.println("----------------��¼---------------->>>");
		System.out.println("�û���:");
		String username = InputUtil.next();
		System.out.println("����");
		String password = InputUtil.next();
		//System.out.println("�˻�����(0:��ͨ�û�  1:����Ա):");
		//int type = InputUtil.nextInt();
		User user = new User(username,password);
		//�����ݷ��͵�������              ����->Json�ַ�����ת��
		String request  = "login?user= "+JSON.toJSONString(user);
		//System.out.println(request);
		//��������,��ȡ��Ӧ
		String response = sendRequest(request);
		//��response�ַ���ת����User����
		User result = JSON.parseObject(response, User.class);
		if(result != null){
			System.out.println("��¼�ɹ�!");
			System.out.println("��ӭ"+result.getUsername());
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
			System.out.println("��¼ʧ��!");
			Login();
		}
	}
}
