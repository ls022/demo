package view;

import entity.User;
import service.UserService;
import service.Impl.UserServiceImpl;

import com.alibaba.fastjson.JSON;

import client.Client;
import dao.InputUtil;

/**
 * �û�ע�����
 * @author oracleOAEC
 *
 */
public class RegisterView extends Client{

	

	public void start(){
		int sex = 0;
		System.out.println("------------------ע��-----------------");
		System.out.println("�û���:");
		String username = InputUtil.next();
		System.out.println("����:");
		String password = InputUtil.next();
		System.out.println("�Ա�(0:��  1:Ů):");
		try{
		 sex = InputUtil.nextInt();
		}catch(Exception e){
			if(sex ==10){
			System.out.println("��������");
			}
		}
		System.out.println();
		System.out.println("���֤��:");
		String id_number = InputUtil.next();
		System.out.println("�绰:");
		String  tel = InputUtil.next();
		System.out.println("��ַ:");
		String  addr = InputUtil.next();
		User user = new User(username, 
				password, sex, id_number, tel, addr);
		// �����ݷ��͵�������
		String request = "new?newuser="+JSON.toJSONString(user);
		// �������� ����ȡ��Ӧ
		String response = sendRequest(request);
		if(request != null){   //ע��ɹ�
			System.out.println("��ϲ��ע��ɹ�!");
			//�ص�������
			new StartView().start();
		}else{    //ע��ʧ��
			System.out.println("ע��ʧ��!");
		}		
	}
	
	public static void main(String[] args) {
		RegisterView view = new RegisterView();
		view.start();
	}
}
