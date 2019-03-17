package server;

import java.net.Socket;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import entity.Car;
import entity.SelectCar;
import entity.User;
import entity.UserRentCar;
import entity.UserRentListCar;
import service.UserService;
import service.Impl.UserServiceImpl;

public class ServerDispatchRequest extends HandleRunnable {

	static User result = null;
	static Car admincar = null;
	
	public ServerDispatchRequest(Socket accept) {
		super(accept);
		// TODO Auto-generated constructor stub
	}
	
	//����������Ҫ�Ķ��ľ���������dispatchRequest()����
	@Override
	public String dispatchRequest(String request) {
		//��ȡ����ͷ����������ͷ��ͬ������ͬ�Ĵ���
		//��ȡ����ͷ
		String header =  Util.getHeader(request);
		// ��������ͬ������ͬ�Ĵ���
		switch( header){
			case "login": // ��¼
				return dispatchLogin(request);
			case "new" : // ע��
				return dispatchNew(request);
			case "operation": // ����
				return dispatchOperation(request);
			case "admin" : //����Ա����
				return dispatchAdmin(request);
			case "add" :  //  �������
				return  dispatchaddcar(request);
			case "rent" :  // �޸����޼۸�
				String aa[] = request.split("\\?");
				UserService us = new UserServiceImpl();
				//int car_id = Integer.parseInt(aa[1]);
				int temp = us.updateRentCar(admincar.getId(), aa[1]);
				if(temp>0){
					return "yes";
				}else{
					return null;
				}
			case "useable" :  // �޸������Ƿ��ϼ�
				String dd[] = request.split("\\?");
				UserService us1 = new UserServiceImpl();
				//int carid = Integer.parseInt(dd[1]);
				int useable= Integer.parseInt(dd[1]);
				int temps = us1.updateUseableCar(admincar.getId(), useable);
				if(temps>0){
					return "yes";
				}else{
					return null;
				}
			default:
				return "bye";
		}
		//return�Ľ������д���ͻ��˵Ľ��
	}

	//�����¼
	private String dispatchLogin(String request){
		// ��ȡ����������һ��Map ,װ�ľ���ƴ�ӳ����Ķ����ֵ��
		Map<String , String> params = Util.getParams(request);
		String userJson  = params.get("user");
		// ��json�ַ���ת���ɶ���
		User user = JSON.parseObject(userJson, User.class);
		UserService userService = new  UserServiceImpl();
		 result = userService.finduser(user);
		return JSON.toJSONString(result);
	}
	
	//����ע��
	private String dispatchNew(String request){
		String aa = null;
		Map<String , String> params = Util.getParams(request);
		String userJson  = params.get("newuser");
		User user = JSON.parseObject(userJson, User.class);
		UserService userService = new UserServiceImpl();
		 int result = userService.newuser(user);
		 if(result>0){
			  aa = "yes";
		 }
		return aa;
	}
	
	//����
	private String dispatchOperation(String request){
		User users = result;
		Map<String , String> params = Util.getParams(request);
		String userJson  = params.get("car");
		String aa = null;
		String[] array =userJson.split("\\+");
		if(array.length == 2){
			aa= array[0];
		}else{
			aa = userJson;
		}
		switch(aa){
			case "0":
				break;
			case "1":
				int idcar = Integer.parseInt(array[1]);
				UserService us = new UserServiceImpl();
				UserRentCar urc = null;
				int ss=us.rentCar(users, idcar);
				if(ss>0){
					urc =us.findCar(users, idcar);
					int cc=us.statusCar(idcar);
					if(cc>0){
						return JSON.toJSONString(urc);
					}
				}
			case "2":
				int rent = 0;
				try{
				 rent = Integer.parseInt(array[1]);
				}catch(Exception e){
					return null;
				}
				if(rent ==1){
				UserService us1 = new UserServiceImpl();
				List<SelectCar> list =us1.findRentDescCar();
				return JSON.toJSONString(list);
				}else if(rent ==2){
					UserService us2 = new UserServiceImpl();
					List<SelectCar> list1 = us2.findRentCar();
					return JSON.toJSONString(list1);
				}else{
					return null;
				}
			case "3":
				int category_id = 0;
				try{
				 category_id = Integer.parseInt(array[1]);
				}catch(Exception e){
					return null;
				}
				if(category_id == 1||category_id == 2||category_id == 3||category_id == 4 ){
				UserService us2 = new UserServiceImpl();
				List<SelectCar> list = us2.findCategoryCar(category_id);
				return JSON.toJSONString(list);
				}else{
					return null;
				}
			case "4":
				int brank_id = 0;
				try{
				brank_id = Integer.parseInt(array[1]);
				}catch(Exception e){
					return null;
				}
				//if(brank_id ==1||brank_id==2||brank_id==3||brank_id==4||brank_id==5){
				UserService us3 = new UserServiceImpl();
				List<SelectCar> list2 = us3.findBrankCar(brank_id);
				return JSON.toJSONString(list2);
				/*}else{
					return null;
				}*/
			case "5":
				UserService us4 = new UserServiceImpl();
				List<SelectCar> list3 = us4.findAllCar();
				return JSON.toJSONString(list3);
			case "6":
				UserService  us5 = new UserServiceImpl();
				List<UserRentListCar> list4 = us5.recordRentCar(result.getId());
				return JSON.toJSONString(list4);
			case "7":
				int car_id = 0;
				try{
					car_id = Integer.parseInt(array[1]);
				}catch(Exception e){
					return null;
				}
				UserService  us6 = new UserServiceImpl();
				int a = us6.repay(result.getId(), car_id);
				if(a>0){
					UserRentListCar urlc = us6.repayCar(result.getId(), car_id);
					if(urlc!=null){
						int b = us6.repaypayment(urlc);
						if(b>0){
							int c = us6.updatestatus(car_id);
							if(c>0){
								return result.getId()+"";
							}
							return null;
						}
						return null;
					}
					return null;
				}
				return null;
		}
		return null;
	}
	
	//����Ա����
	private String dispatchAdmin(String request){
		Map<String , String> params = Util.getParams(request);
		String userJson  = params.get("admin");
		String aa = null;
		String[] array =userJson.split("\\+");
		if(array.length  >= 2){
			aa= array[0];
		}else{
			aa = userJson;
		}
		switch(aa){
		case "0" :
			break;
		case "1" :
			int idcar = Integer.parseInt(array[1]);
			UserService us = new UserServiceImpl();
			Car car = us.findaCar(idcar);
			return JSON.toJSONString(car);
		case "5" :
			UserService us1 = new UserServiceImpl();
			List<Car> list = us1.findAdminAllCar();
			return JSON.toJSONString(list);
		case "7" :
			int idcar1 = Integer.parseInt(array[1]);
			UserService us2 = new UserServiceImpl();
			admincar = us2.updateCar(idcar1);
			return JSON.toJSONString(admincar);
		case "8" :
			UserService us3 = new UserServiceImpl();
			List<UserRentListCar> list1 = us3.findrecord();
			return JSON.toJSONString(list1);
		}
		return null;
	}
	
	// �������
	private String dispatchaddcar(String request){
		Map<String , String> params = Util.getParams(request);
		String userJson  = params.get("admin");
		Car car = JSON.parseObject(userJson, Car.class);
		UserService us2 = new UserServiceImpl();
		int cc = us2.addAdminCar(car);
		if(cc>0){
			return "Yes";
		}else{
			return null;
		}
	}
}
