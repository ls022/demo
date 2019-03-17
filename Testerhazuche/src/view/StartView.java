package view;

import dao.InputUtil;


/**
 * 主界面
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
		System.out.println("\t\t欢迎访问二嗨租车");
		System.out.println("----------------------------------------");
		System.out.println("1.登录  2.注册   3. 退出");
		String choose = InputUtil.next();
		switch (choose) {
		case "1":
			new LoginView().Login();
			break;
		case "2":
			new RegisterView().start();
			break;
		default:
			System.out.println("欢迎再次访问");
			break;
		}
	}
}
