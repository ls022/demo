package view;

import client.Client;
import dao.InputUtil;
import dao.OperationDao;
import dao.SwitchOperation;
import dao.Impl.OperationDaoImpl;
/**
 * 用户租车界面
 * @author oracleOAEC
 *
 */
public class RentCarView extends Client{

	public void start(){
		OperationDao od = new OperationDaoImpl();
		od.operationCar();
		String c = InputUtil.next();
		//把数据发送到服务器
		String request  = "operation?car="+c;
		//发送请求,获取相应
		String response = sendRequest(request);
		SwitchOperation.start(c, response);
	}
	
	
}
