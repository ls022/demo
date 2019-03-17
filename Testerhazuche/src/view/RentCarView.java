package view;

import client.Client;
import dao.InputUtil;
import dao.OperationDao;
import dao.SwitchOperation;
import dao.Impl.OperationDaoImpl;
/**
 * �û��⳵����
 * @author oracleOAEC
 *
 */
public class RentCarView extends Client{

	public void start(){
		OperationDao od = new OperationDaoImpl();
		od.operationCar();
		String c = InputUtil.next();
		//�����ݷ��͵�������
		String request  = "operation?car="+c;
		//��������,��ȡ��Ӧ
		String response = sendRequest(request);
		SwitchOperation.start(c, response);
	}
	
	
}
