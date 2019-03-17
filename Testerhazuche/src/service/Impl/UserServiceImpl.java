package service.Impl;

import java.util.List;

import dao.OperationDao;
import dao.UserDao;
import dao.Impl.OperationDaoImpl;
import dao.Impl.UserDaoImpl;
import entity.Car;
import entity.SelectCar;
import entity.User;
import entity.UserRentCar;
import entity.UserRentListCar;
import service.UserService;
/**
 * 
 * 用户业务接口实现类
 * @author oracleOAEC
 *
 */
public class UserServiceImpl implements UserService{

	OperationDao op = new OperationDaoImpl();
	UserDao ud = new UserDaoImpl();
	@Override
	public List<User> finduser() {
		return ud.finduser();
	}

	@Override
	public User finduser(User user) {
		return ud.finduser(user);
	}

	@Override
	public int newuser(User user) {
		return ud.newuser(user);
	}

	@Override
	public List<SelectCar> findCar() {
		return ud.findcar();
	}

	@Override
	public UserRentCar findCar(User users,int car_id) {
		return op.findCar(users,car_id);
	}

	@Override
	public void selectCar() {
		UserDao ud = new UserDaoImpl();
		ud.selectCar();
	}

	@Override
	public int rentCar(User users,int  car_id){
		return op.rentCar(users,car_id);
	}

	@Override
	public void operationCar() {	
	}

	@Override
	public List<SelectCar> findRentDescCar() {
		return ud.findRentDescCar();
	}

	@Override
	public List<SelectCar> findRentCar() {
		return ud.findRentCar();
	}

	@Override
	public int statusCar(int car_id) {
		return op.statusCar(car_id);
	}

	@Override
	public List<SelectCar> findCategoryCar(int category_id) {
		return ud.findCategoryCar(category_id);
	}

	@Override
	public List<SelectCar> findBrankCar(int brank_id) {
		return  ud.findBrankCar(brank_id);
	}

	@Override
	public List<SelectCar> findAllCar() {
		return ud.findAllCar();
	}

	@Override
	public List<UserRentListCar> recordRentCar(int user_id) {
		return ud.recordRentCar(user_id);
	}

	@Override
	public List<SelectCar> findAdminCar() {
		return ud.findAdminCar();
	}

	@Override
	public void selectAdminCar() {
		UserDao ud = new UserDaoImpl();
		ud.selectAdminCar();
	}

	@Override
	public Car findaCar(int car_id) {
		return ud.findaCar(car_id);
	}

	@Override
	public List<Car> findAdminAllCar() {
		return ud.findAdminAllCar();
	}

	@Override
	public Car addCar() {
		return ud.addCar();
	}

	@Override
	public int addAdminCar(Car car) {
		return ud.addAdminCar(car);
	}

	@Override
	public Car updateCar(int car_id) {
		return ud.updateCar(car_id);
	}

	@Override
	public int updateRentCar(int car_id, String rent) {
		return ud.updateRentCar(car_id, rent);
	}

	@Override
	public int updateUseableCar(int car_id, int useable) {
		return ud.updateUseableCar(car_id, useable);
	}

	@Override
	public int repaypayment(UserRentListCar payment) {
		return ud.repaypayment(payment);
	}

	@Override
	public int repay(int user_id, int car_id) {
		return ud.repay(user_id, car_id);
	}

	@Override
	public UserRentListCar repayCar(int user_id, int car_id) {
		return ud.repayCar(user_id, car_id);
	}

	@Override
	public int updatestatus(int car_id) {
		return ud.updatestatus(car_id);
	}

	@Override
	public List<UserRentListCar> findrecord() {
		return ud.findrecord();
	}

}
