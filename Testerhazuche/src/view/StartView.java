package view;

import dao.InputUtil;


/**
 * ������
 * @author oracleOAEC
 *
 */
public class StartView {

	public static void main(String[] args) {
		StartView view = new StartView();
		view.start();
	}
	
	public void start(){
		System.out.println("----------------------------------------");
		System.out.println("\t\t��ӭ���ʶ����⳵");
		System.out.println("----------------------------------------");
		System.out.println("1.��¼  2.ע��   3. �˳�");
		String choose = InputUtil.next();
		switch (choose) {
		case "1":
			new LoginView().Login();
			break;
		case "2":
			new RegisterView().start();
			break;
		default:
			System.out.println("��ӭ�ٴη���");
			break;
		}
	}
}
