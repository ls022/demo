package view;

import client.Client;
import dao.InputUtil;
import entity.Car;
import service.UserService;
import service.Impl.UserServiceImpl;

public class UpdateView extends Client{

	public void start(int idcar){
		System.out.println("������Ҫ�޸ĵ����ݵı�ţ�");
		System.out.println("1.���޼۸�      2. �ϼ��¼�");
		int num = InputUtil.nextInt();
		if(num == 1){
			System.out.println("�������µ����޼۸�");
			String rent = InputUtil.next();
			String request = "rent?"+rent;
			String response = sendRequest(request);
			if(response !=null){
				System.out.println("�޸ĳɹ���");
				UserService us2 = new UserServiceImpl();
				Car car1 = us2.updateCar(idcar);
				System.out.println("���\t"+"��������\t\t"+"��ע\t\t\t"+"Ʒ��\t\t"+"����\t\t"+"�۸�\t"+"����\t\t"+"�Ƿ����\t\t"+"�Ƿ��ϼ�");
				System.out.println(car1.toupdateString());
				new AdminView().start();
			}else{
				System.out.println("�޸�ʧ�ܣ�");
			}
		}else if(num ==2){
			System.out.println("��ѡ���Ƿ��ϼ� ��0���ϼ�  1���¼ܣ�");
			int a = InputUtil.nextInt();
			String request = "useable?"+a;
			String response = sendRequest(request);
			if(response !=null){
				System.out.println("�޸ĳɹ���");
				UserService us2 = new UserServiceImpl();
				Car car1 = us2.updateCar(idcar);
				System.out.println("���\t"+"��������\t\t"+"��ע\t\t\t"+"Ʒ��\t\t"+"����\t\t"+"�۸�\t"+"����\t\t"+"�Ƿ����\t\t"+"�Ƿ��ϼ�");
				System.out.println(car1.toupdateString());
				new AdminView().start();
			}else{
				System.out.println("�޸�ʧ�ܣ�");
			}
		}
	}
}
