package service;

import java.util.List;

import entity.Car;
import entity.SelectCar;
import entity.User;
import entity.UserRentCar;
import entity.UserRentListCar;
/**
 * �û�ҵ��ӿ�
 * @author oracleOAEC
 *
 */
public interface UserService {

	/**
	 * ��ѯ�����û�
	 * @return
	 */
	public List <User> finduser();
	/**
	 * ��¼
	 * @param user
	 * @return
	 */
	public User finduser(User user);
	/**
	 * ע���û�
	 * @param user
	 * @return
	 */
	public int newuser(User user);
	/**
	 * �û���ѯ����
	 * @return
	 */
	public List<SelectCar> findCar();
	/**
	 * ��ʾ����(�û�)
	 */
	public void selectCar();
	
	/**
	 * ����Ա��ѯ����
	 * @return
	 */
	public List<SelectCar> findAdminCar();
	
	/**
	 * ����Ա�鿴������¼
	 * @return
	 */
	public List<UserRentListCar> findrecord();
	
	/**
	 * ����Ա�鿴ָ������
	 * @return
	 */
	public Car findaCar(int car_id);
	
	/**
	 * ����Ա�鿴ȫ������
	 * @return
	 */
	public List<Car> findAdminAllCar();
	
	/**
	 * ��ʾ����(����Ա)
	 */
	public void selectAdminCar();
	
	/**
	 * ��ʾҪ�޸���������Ϣ
	 * @return
	 */
	
	public Car updateCar(int car_id);
	
	/**
	 * �޸�������Ϣ(�۸�)
	 * @param car_id
	 * @return
	 */
	public int updateRentCar(int car_id ,String rent);
	
	/**
	 * �޸�������Ϣ(�Ƿ��ϼ�)
	 * @param car_id
	 * @param useable
	 * @return
	 */
	public int updateUseableCar(int car_id ,int useable);
	
	/**
	 * �������(����Ա)
	 * @return
	 */
	public Car addCar();
	
	/**
	 * Ϊ���ݿ��������
	 * @return
	 */
	public int addAdminCar(Car car);
	
	/**
	 * ��������(�û�)
	 */
	public void operationCar();
	/**
	 * �⳵����
	 * @param users
	 * @param car_id
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
	/**
	 * ���۸���
	 * @return
	 */
	public List<SelectCar> findRentDescCar();
	/**
	 * ���۸�����
	 * @return
	 */
	public List<SelectCar> findRentCar();
	
	/**
	 * ����������
	 * @return
	 */
	public List<SelectCar> findCategoryCar(int category_id);
	/**
	 * ��Ʒ������
	 * @return
	 */
	public List<SelectCar> findBrankCar(int brank_id);
	/**
	 * ��ѯ��������
	 * @return
	 */
	public List<SelectCar> findAllCar();
	/**
	 * �û��⳵��¼
	 * @param user_id
	 * @return
	 */
	public List<UserRentListCar> recordRentCar(int user_id);
	
	/**
	 * �޸������
	 * @param payment
	 * @return
	 */
	public int repaypayment(UserRentListCar payment);
	
	/**
	 * �޸Ļ���ʱ��
	 * @param user_id
	 * @param car_id
	 * @return
	 */
	public int repay(int user_id, int car_id);
	
	/**
	 * ����
	 * @param user_id
	 * @param car_id
	 * @return
	 */
	public UserRentListCar repayCar(int user_id ,int car_id);
	
	/**
	 * �������޸ĳ���״̬
	 * @param car_id
	 * @return
	 */
	public int updatestatus(int car_id);
}
