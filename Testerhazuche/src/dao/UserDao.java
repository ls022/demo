package dao;

import java.util.List;

import entity.Car;
import entity.SelectCar;
import entity.User;
import entity.UserRentCar;
import entity.UserRentListCar;
/**
 * 
 * ���ݷ��ʽӿ�
 * @author oracleOAEC
 *
 */
public interface UserDao {

	/**
	 * 
	 * ��ѯ�����û�
	 * @return
	 */
	public List<User> finduser(); 
	/**
	 * ��¼
	 * @param user
	 * @return
	 */
	public User finduser(User user); 
	/**
	 * 
	 * �û�ע��
	 * @param user
	 * @return
	 */
	public int newuser(User user);
	
	/**
	 * 
	 * �û���ѯ����
	 */
	public  List<SelectCar> findcar();
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
	 * ����Ա�鿴������¼
	 * @return
	 */
	public List<UserRentListCar> findrecord();
	
	/**
	 * ��ʾ����(����Ա)
	 */
	public void selectAdminCar();
	
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
