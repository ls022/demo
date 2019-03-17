package view;

import client.Client;
import dao.InputUtil;
import entity.Car;
import service.UserService;
import service.Impl.UserServiceImpl;

public class UpdateView extends Client{

	public void start(int idcar){
		System.out.println("请输入要修改的内容的编号：");
		System.out.println("1.租赁价格      2. 上架下架");
		int num = InputUtil.nextInt();
		if(num == 1){
			System.out.println("请输入新的租赁价格：");
			String rent = InputUtil.next();
			String request = "rent?"+rent;
			String response = sendRequest(request);
			if(response !=null){
				System.out.println("修改成功！");
				UserService us2 = new UserServiceImpl();
				Car car1 = us2.updateCar(idcar);
				System.out.println("编号\t"+"汽车名称\t\t"+"备注\t\t\t"+"品牌\t\t"+"类型\t\t"+"价格\t"+"车价\t\t"+"是否可租\t\t"+"是否上架");
				System.out.println(car1.toupdateString());
				new AdminView().start();
			}else{
				System.out.println("修改失败！");
			}
		}else if(num ==2){
			System.out.println("请选择是否上架 （0：上架  1：下架）");
			int a = InputUtil.nextInt();
			String request = "useable?"+a;
			String response = sendRequest(request);
			if(response !=null){
				System.out.println("修改成功！");
				UserService us2 = new UserServiceImpl();
				Car car1 = us2.updateCar(idcar);
				System.out.println("编号\t"+"汽车名称\t\t"+"备注\t\t\t"+"品牌\t\t"+"类型\t\t"+"价格\t"+"车价\t\t"+"是否可租\t\t"+"是否上架");
				System.out.println(car1.toupdateString());
				new AdminView().start();
			}else{
				System.out.println("修改失败！");
			}
		}
	}
}
