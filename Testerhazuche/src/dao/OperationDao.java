package dao;

import entity.User;
import entity.UserRentCar;

/**
 * �����ӿ�
 * @author oracleOAEC
 *
 */
public interface OperationDao {

	/**
	 * ��������(�û�)
	 */
	public void operationCar();
	
	/**
	 * ��������(����Ա)
	 */
	public void operationAdminCar();
	
	/**
	 * �⳵����	
	 * @param Car_id
	 * @return
	 */
	public UserRentCar findCar(User users,int car_id);
	/**
	 * �⳵
	 * @param users
	 * @param car_id
	 * @return
	 */
	public int rentCar(User users,int  car_id);
	/**
	 * ��������޸ĳ���״̬
	 * @param car_id
	 * @return
	 */
	public int statusCar(int car_id);
	
}
