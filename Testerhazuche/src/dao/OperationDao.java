package dao;

import entity.User;
import entity.UserRentCar;

/**
 * 操作接口
 * @author oracleOAEC
 *
 */
public interface OperationDao {

	/**
	 * 操作界面(用户)
	 */
	public void operationCar();
	
	/**
	 * 操作界面(管理员)
	 */
	public void operationAdminCar();
	
	/**
	 * 租车界面	
	 * @param Car_id
	 * @return
	 */
	public UserRentCar findCar(User users,int car_id);
	/**
	 * 租车
	 * @param users
	 * @param car_id
	 * @return
	 */
	public int rentCar(User users,int  car_id);
	/**
	 * 车被租后，修改车的状态
	 * @param car_id
	 * @return
	 */
	public int statusCar(int car_id);
	
}
