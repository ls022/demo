package service;

import java.util.List;

import entity.Car;
import entity.SelectCar;
import entity.User;
import entity.UserRentCar;
import entity.UserRentListCar;
/**
 * 用户业务接口
 * @author oracleOAEC
 *
 */
public interface UserService {

	/**
	 * 查询所用用户
	 * @return
	 */
	public List <User> finduser();
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public User finduser(User user);
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	public int newuser(User user);
	/**
	 * 用户查询汽车
	 * @return
	 */
	public List<SelectCar> findCar();
	/**
	 * 显示汽车(用户)
	 */
	public void selectCar();
	
	/**
	 * 管理员查询汽车
	 * @return
	 */
	public List<SelectCar> findAdminCar();
	
	/**
	 * 管理员查看汽车记录
	 * @return
	 */
	public List<UserRentListCar> findrecord();
	
	/**
	 * 管理员查看指定汽车
	 * @return
	 */
	public Car findaCar(int car_id);
	
	/**
	 * 管理员查看全部汽车
	 * @return
	 */
	public List<Car> findAdminAllCar();
	
	/**
	 * 显示汽车(管理员)
	 */
	public void selectAdminCar();
	
	/**
	 * 显示要修改汽车的信息
	 * @return
	 */
	
	public Car updateCar(int car_id);
	
	/**
	 * 修改汽车信息(价格)
	 * @param car_id
	 * @return
	 */
	public int updateRentCar(int car_id ,String rent);
	
	/**
	 * 修改汽车信息(是否上架)
	 * @param car_id
	 * @param useable
	 * @return
	 */
	public int updateUseableCar(int car_id ,int useable);
	
	/**
	 * 添加汽车(管理员)
	 * @return
	 */
	public Car addCar();
	
	/**
	 * 为数据库添加汽车
	 * @return
	 */
	public int addAdminCar(Car car);
	
	/**
	 * 操作界面(用户)
	 */
	public void operationCar();
	/**
	 * 租车界面
	 * @param users
	 * @param car_id
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
	/**
	 * 按价格降序
	 * @return
	 */
	public List<SelectCar> findRentDescCar();
	/**
	 * 按价格升序
	 * @return
	 */
	public List<SelectCar> findRentCar();
	
	/**
	 * 按类型搜索
	 * @return
	 */
	public List<SelectCar> findCategoryCar(int category_id);
	/**
	 * 按品牌搜索
	 * @return
	 */
	public List<SelectCar> findBrankCar(int brank_id);
	/**
	 * 查询所有汽车
	 * @return
	 */
	public List<SelectCar> findAllCar();
	/**
	 * 用户租车记录
	 * @param user_id
	 * @return
	 */
	public List<UserRentListCar> recordRentCar(int user_id);
	
	/**
	 * 修改总租金
	 * @param payment
	 * @return
	 */
	public int repaypayment(UserRentListCar payment);
	
	/**
	 * 修改还车时间
	 * @param user_id
	 * @param car_id
	 * @return
	 */
	public int repay(int user_id, int car_id);
	
	/**
	 * 还车
	 * @param user_id
	 * @param car_id
	 * @return
	 */
	public UserRentListCar repayCar(int user_id ,int car_id);
	
	/**
	 * 还车后，修改车的状态
	 * @param car_id
	 * @return
	 */
	public int updatestatus(int car_id);
}
