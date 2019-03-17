package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.InputUtil;
import dao.UserDao;
import entity.Car;
import entity.SelectCar;
import entity.User;
import entity.UserRentCar;
import entity.UserRentListCar;
import service.UserService;
import service.Impl.UserServiceImpl;
/**
 * ���ݷ��ʽӿ�ʵ����
 * @author oracleOAEC
 *
 */
public class UserDaoImpl extends BaseDao implements UserDao{

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public List<User> finduser() {
		List <User> list = new ArrayList<> ();
		conn = getConnection();
		String sql = "select * from T_user";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setSex(rs.getInt(4));
				user.setId_number(rs.getString(5));
				user.setTel(rs.getString(6));
				user.setAddr(rs.getString(7));
				user.setType(rs.getInt(8));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn,ps,rs);
		}
		return list;
	}

	@Override
	public User  finduser(User user) {
		User users = null;
		conn = getConnection();
		String sql = "select * from T_user where username = ? and password = ?  ";
		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			while(rs.next()){
				users = new User();
				users.setId(rs.getInt(1));
				users.setUsername(rs.getString(2));
				users.setPassword(rs.getString(3));
				users.setSex(rs.getInt(4));
				users.setId_number(rs.getString(5));
				users.setTel(rs.getString(6));
				users.setAddr(rs.getString(7));
				users.setType(rs.getInt(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn,ps,rs);
		}
		return users;
	}

	@Override
	public int newuser(User user) {
		int temp = 0;
		conn = getConnection();
		String sql = "insert into  T_user values(t_user_id_seq.nextval,?,?,?,?,?,?,0)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getSex());
			ps.setString(4, user.getId_number());
			ps.setString(5, user.getTel());
			ps.setString(6, user.getAddr());
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn,ps,rs);
		}
		return temp;
	}
	
	public List<SelectCar> findcar() {
		List <SelectCar> list = new ArrayList<>();
		conn = getConnection();
		String sql = "select T_car.id as ���,T_car.model as ��������, T_car.t_comments as ��ע , T_brand.name||'('||T_brand.Id||')' as Ʒ�� , t_Category.name||'('||t_Category.Id||')' as ����, T_car.rent as �۸� , T_car.status as �Ƿ���� "   
				+"from T_car   inner join  T_brand  on (T_car.brand_id = T_brand.id)"+
				"inner  join t_Category  on (T_car.category_id = t_Category.id)  where T_car.status = 0  and T_car.useable = 0  order by T_car.Id ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				SelectCar sc = new SelectCar();
				sc.setId(rs.getInt(1));
				sc.setName(rs.getString(2));
				sc.setRemark(rs.getString(3));
				sc.setBrank(rs.getString(4));
				sc.setCategory(rs.getString(5));
				sc.setRent(rs.getString(6));
				sc.setStatus(rs.getInt(7));
				list.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn,ps,rs);
		}
		return list;
	}

	@Override
	public void selectCar() {
		UserService us = new UserServiceImpl();
		List <SelectCar>  list =us.findCar();
		System.out.println();
		System.out.println("-------------------�û�������ѯ����------------------------");
		System.out.println("���\t"+"��������\t"+"��ע\t\t"+"Ʒ��\t\t"+"����\t\t\t"+"�۸�\t\t\t"+"�Ƿ����");
		//System.out.println("");
		for (SelectCar scar : list) {
			System.out.println(scar.toString());
		}
		System.out.println();
		//us.operationCar();
	}

	@Override
	public List<SelectCar> findRentDescCar() {
		List <SelectCar> list = new ArrayList<>();
		conn = getConnection();
		String sql = "select T_car.id as ���,T_car.model as ��������, T_car.t_comments as ��ע ,T_brand.name||'('||T_brand.Id||')' as Ʒ�� , t_Category.name||'('||t_Category.Id||')' as ����, T_car.rent as �۸� , T_car.status as �Ƿ���� "   
				+"from T_car   inner join  T_brand  on (T_car.brand_id = T_brand.id)"+
				"inner  join t_Category  on (T_car.category_id = t_Category.id)  where T_car.status = 0  and T_car.useable = 0  order by T_car.rent DESC ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				SelectCar sc = new SelectCar();
				sc.setId(rs.getInt(1));
				sc.setName(rs.getString(2));
				sc.setRemark(rs.getString(3));
				sc.setBrank(rs.getString(4));
				sc.setCategory(rs.getString(5));
				sc.setRent(rs.getString(6));
				sc.setStatus(rs.getInt(7));
				list.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn,ps,rs);
		}
		return list;
	}

	@Override
	public List<SelectCar> findRentCar() {
		List <SelectCar> list = new ArrayList<>();
		conn = getConnection();
		String sql = "select T_car.id as ���,T_car.model as ��������, T_car.t_comments as ��ע ,T_brand.name||'('||T_brand.Id||')' as Ʒ�� , t_Category.name||'('||t_Category.Id||')' as ����, T_car.rent as �۸� , T_car.status as �Ƿ���� "   
				+"from T_car   inner join  T_brand  on (T_car.brand_id = T_brand.id)"+
				"inner  join t_Category  on (T_car.category_id = t_Category.id)  where T_car.status = 0  and T_car.useable = 0  order by T_car.rent  ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				SelectCar sc = new SelectCar();
				sc.setId(rs.getInt(1));
				sc.setName(rs.getString(2));
				sc.setRemark(rs.getString(3));
				sc.setBrank(rs.getString(4));
				sc.setCategory(rs.getString(5));
				sc.setRent(rs.getString(6));
				sc.setStatus(rs.getInt(7));
				list.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn,ps,rs);
		}
		return list;
		}

	@Override
	public List<SelectCar> findCategoryCar(int category_id) {
		List<SelectCar> list = new ArrayList<SelectCar>();
		conn = getConnection();
		String sql = "select T_car.id as ���,T_car.model as ��������, T_car.t_comments as ��ע ,T_brand.name||'('||T_brand.Id||')' as Ʒ�� , t_Category.name||'('||t_Category.Id||')' as ����, T_car.rent as �۸� , T_car.status as �Ƿ���� " 
				+"from T_car   inner join  T_brand  on (T_car.brand_id = T_brand.id)"
				+"inner  join t_Category  on (T_car.category_id = t_Category.id) "
				+"where T_car.status = 0  and T_car.useable = 0  and  T_category.Id = ?  order by T_car.Id ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, category_id);
			rs = ps.executeQuery();
			while(rs.next()){
				SelectCar sc = new SelectCar();
				sc.setId(rs.getInt(1));
				sc.setName(rs.getString(2));
				sc.setRemark(rs.getString(3));
				sc.setBrank(rs.getString(4));
				sc.setCategory(rs.getString(5));
				sc.setRent(rs.getString(6));
				sc.setStatus(rs.getInt(7));
				list.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn,ps,rs);
		}
		return list;
	}

	@Override
	public List<SelectCar> findBrankCar(int brank_id) {
		List<SelectCar> list = new ArrayList<SelectCar>();
		conn = getConnection();
		String sql = "select T_car.id as ���,T_car.model as ��������, T_car.t_comments as ��ע , T_brand.name||'('||T_brand.Id||')'  as Ʒ�� , t_Category.name||'('||t_Category.Id||')' as ����, T_car.rent as �۸� , T_car.status as �Ƿ���� " 
				+"from T_car   inner  join  T_brand  on (T_car.brand_id = T_brand.id)"
				+"inner  join t_Category  on (T_car.category_id = t_Category.id) "
				+"where T_car.status = 0  and T_car.useable = 0  and  T_brank.Id = ?  order by T_car.Id ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, brank_id);
			rs = ps.executeQuery();
			while(rs.next()){
				SelectCar sc = new SelectCar();
				sc.setId(rs.getInt(1));
				sc.setName(rs.getString(2));
				sc.setRemark(rs.getString(3));
				sc.setBrank(rs.getString(4));
				sc.setCategory(rs.getString(5));
				sc.setRent(rs.getString(6));
				sc.setStatus(rs.getInt(7));
				list.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn,ps,rs);
		}
		return list;
	}

	@Override
	public List<SelectCar> findAllCar() {
		List <SelectCar> list = new ArrayList<>();
		conn = getConnection();
		String sql = "select T_car.id as ���,T_car.model as ��������, T_car.t_comments as ��ע , T_brand.name||'('||T_brand.Id||')' as Ʒ�� , t_Category.name||'('||t_Category.Id||')' as ����, T_car.rent as �۸� , T_car.status as �Ƿ���� "   
				+"from T_car   inner join  T_brand  on (T_car.brand_id = T_brand.id)"+
				"inner  join t_Category  on (T_car.category_id = t_Category.id)  where T_car.useable = 0  order by T_car.Id ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				SelectCar sc = new SelectCar();
				sc.setId(rs.getInt(1));
				sc.setName(rs.getString(2));
				sc.setRemark(rs.getString(3));
				sc.setBrank(rs.getString(4));
				sc.setCategory(rs.getString(5));
				sc.setRent(rs.getString(6));
				sc.setStatus(rs.getInt(7));
				list.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn,ps,rs);
		}
		return list;
	}

	@Override
	public List<UserRentListCar> recordRentCar(int user_id) {
		List<UserRentListCar> list = new ArrayList<>();
		conn = getConnection();
		String sql = "select  T_record.Id as ���,T_car.id as �������,T_car.model as ��������,T_record.Payment as ����� , T_car.t_comments as ��ע , T_brand.name||'('||T_brand.Id||')' as Ʒ�� , t_Category.name||'('||t_Category.Id||')' as ���� ,T_record.Start_Date as ���ʱ�� ,T_record.Return_Date as ����ʱ�� " 
				+"from  T_record  inner join  T_car on (T_record.Car_Id = T_car.Id)"
				+"inner join  T_brand  on (T_car.brand_id = T_brand.id) "
				+"inner join t_Category  on (T_car.category_id = t_Category.id) "
				+"where T_record.User_Id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			while(rs.next()){
				UserRentListCar urlc = new UserRentListCar();
				urlc.setId(rs.getInt(1));
				urlc.setCar_id(rs.getInt(2));
				urlc.setModel(rs.getString(3));
				urlc.setPayment(rs.getString(4));
				urlc.setRemark(rs.getString(5));
				urlc.setBrank(rs.getString(6));
				urlc.setCategory(rs.getString(7));
				urlc.setRenttime(rs.getString(8));
				urlc.setRepaytime(rs.getString(9));
				list.add(urlc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn,ps,rs);
		}
		return list;
	}
	
	// �޸Ļ���ʱ��
	public int repay(int user_id, int car_id){
		String sql = "update T_record  r  set r.Return_Date = sysdate ,r.Payment = ((to_char(sysdate,'dd')"
				+"- to_char(r.Start_Date , 'dd'))*24+(to_char(sysdate,'hh')"
				+"- to_char(r.Start_Date , 'hh')))  where r.user_id = ?  and r.Car_Id = ?";
		Object[] num = {user_id,car_id};
		int temp = executSQL(sql,num);
		return temp;
	}

	@Override
	public UserRentListCar repayCar(int user_id, int car_id) {
		UserRentListCar urlc = null;
		conn = getConnection();
		String sql = "select  T_car.id as �������,T_car.model as ��������,T_car.Rent as �۸�,T_record.Payment as ����� , T_car.t_comments as ��ע , T_brand.name||'('||T_brand.Id||')' as Ʒ�� , t_Category.name||'('||t_Category.Id||')' as ���� ,T_record.Start_Date as ���ʱ�� ,T_record.Return_Date as ����ʱ�� " 
				+"from  T_record   inner join  T_car on (T_record.Car_Id = T_car.Id) "
				+"inner join  T_brand  on (T_car.brand_id = T_brand.id) "
				+"inner join t_Category  on (T_car.category_id = t_Category.id)" 
				+"where T_record.User_Id = ?  and T_record.Car_Id = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.setInt(2, car_id);
			rs = ps.executeQuery();
			while(rs.next()){
				urlc = new UserRentListCar();
				urlc.setCar_id(rs.getInt(1));
				urlc.setModel(rs.getString(2));
				urlc.setRent(rs.getString(3));
				urlc.setPayment(rs.getString(4));
				urlc.setRemark(rs.getString(5));
				urlc.setBrank(rs.getString(6));
				urlc.setCategory(rs.getString(7));
				urlc.setRenttime(rs.getString(8));
				urlc.setRepaytime(rs.getString(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn,ps,rs);
		}
		
		return urlc;
	}

	@Override
	public List<SelectCar> findAdminCar() {
		List <SelectCar> list = new ArrayList<>();
		conn = getConnection();
		String sql = "select T_car.id as ���,T_car.model as ��������, T_car.t_comments as ��ע , T_brand.name||'('||T_brand.Id||')' as Ʒ�� , t_Category.name||'('||t_Category.Id||')' as ����, T_car.rent as �۸� , T_car.status as �Ƿ����   , T_car.useable as �Ƿ��ϼ� "   
				+"from T_car   inner join  T_brand  on (T_car.brand_id = T_brand.id)"+
				"inner  join t_Category  on (T_car.category_id = t_Category.id)  order by T_car.Id ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				SelectCar sc = new SelectCar();
				sc.setId(rs.getInt(1));
				sc.setName(rs.getString(2));
				sc.setRemark(rs.getString(3));
				sc.setBrank(rs.getString(4));
				sc.setCategory(rs.getString(5));
				sc.setRent(rs.getString(6));
				sc.setStatus(rs.getInt(7));
				sc.setUseable(rs.getInt(8));
				list.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn,ps,rs);
		}
		return list;
	}

	@Override
	public void selectAdminCar() {
		UserService us = new UserServiceImpl();
		List <SelectCar>  list =us.findAdminCar();
		System.out.println();
		//System.out.println("-------------------�û�������ѯ����------------------------");
		System.out.println("���\t"+"��������\t"+"��ע\t\t"+"Ʒ��\t\t"+"����\t\t\t"+"�۸�\t\t\t"+"�Ƿ����\t\t"+"�Ƿ��ϼ�");
		//System.out.println("");
		for (SelectCar scar : list) {
			System.out.println(scar.admiantoString());
		}
		System.out.println();
		
	}

	@Override
	public Car findaCar(int car_id) {
		Car car = null;
		conn = getConnection();
		String sql = "select T_car.id as ���, T_car.car_number as ���ƺ� , T_car.model as ��������,  T_car.color as ��ɫ , T_car.t_comments as ��ע , T_brand.name||'('||T_brand.Id||')' as Ʒ�� , t_Category.name||'('||t_Category.Id||')' as ����, T_car.rent as �۸� , T_car.price as ���� ,  T_car.status as �Ƿ����   , T_car.useable as �Ƿ��ϼ� "   
				+"from T_car   inner join  T_brand  on (T_car.brand_id = T_brand.id)"+
				"inner  join t_Category  on (T_car.category_id = t_Category.id)   where T_car.id = ?  order by T_car.Id ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, car_id);
			rs = ps.executeQuery();
			while(rs.next()){
				car = new Car();
				car.setId(rs.getInt(1));
				car.setCar_number(rs.getString(2));
				car.setModel(rs.getString(3));
				car.setColor(rs.getString(4));
				car.setT_comments(rs.getString(5));
				car.setBrank(rs.getString(6));
				car.setCategory(rs.getString(7));
				car.setRent(rs.getString(8));
				car.setPrice(rs.getString(9));
				car.setStatus(rs.getInt(10));
				car.setUseable(rs.getInt(11));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn,ps,rs);
		}
		return car;
	}

	@Override
	public List<Car> findAdminAllCar() {
		List <Car> list = new ArrayList<>();
		conn = getConnection();
		String sql = "select T_car.id as ���, T_car.car_number as ���ƺ� , T_car.model as ��������,  T_car.color as ��ɫ , T_car.t_comments as ��ע , T_brand.name||'('||T_brand.Id||')' as Ʒ�� , t_Category.name||'('||t_Category.Id||')' as ����, T_car.rent as �۸� , T_car.price as ���� ,  T_car.status as �Ƿ����   , T_car.useable as �Ƿ��ϼ� "   
				+"from T_car   inner join  T_brand  on (T_car.brand_id = T_brand.id)"+
				"inner  join t_Category  on (T_car.category_id = t_Category.id)    order by T_car.Id ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
			Car	car =  new  Car();
				car.setId(rs.getInt(1));
				car.setCar_number(rs.getString(2));
				car.setModel(rs.getString(3));
				car.setColor(rs.getString(4));
				car.setT_comments(rs.getString(5));
				car.setBrank(rs.getString(6));
				car.setCategory(rs.getString(7));
				car.setRent(rs.getString(8));
				car.setPrice(rs.getString(9));
				car.setStatus(rs.getInt(10));
				car.setUseable(rs.getInt(11));
				list.add(car);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn,ps,rs);
		}
		return list;
	}

	
	public void brand(){
		System.out.println("Ʒ�����£�");
		System.out.println("Ʒ�Ʊ��     Ʒ����");
		System.out.println("1                    ����");
		System.out.println("2                    ����");
		System.out.println("3                    �µ�");
		System.out.println("4                    ����");
		System.out.println("5                    ����");
	}
	
	public void  category(){
		System.out.println("�������£�");
		System.out.println("���ͱ��     ������");
		System.out.println("1                   ������");
		System.out.println("2                   ������");
		System.out.println("3                       SUV");
		System.out.println("4                   ��Ӣ��");
	}
	
	@Override
	public Car addCar() {
		System.out.println("===========================");
		System.out.println("��ֱ�����������Ϣ��");
		System.out.println("-----------------------------------------------");
		brand();
		System.out.print("��ѡ��Ʒ�Ʊ�ţ�");
		int brand_id = InputUtil.nextInt();
		System.out.println("-----------------------------------------------");
		category();
		System.out.print("��ѡ�����ͱ�ţ�");
		int category_id = InputUtil.nextInt();
		System.out.println("-----------------------------------------------");
		System.out.print("�ͺţ�");
		String model = InputUtil.next();
		System.out.println("-----------------------------------------------");
		System.out.print("���ƺţ�");
		String car_number = InputUtil.next();
		System.out.println("-----------------------------------------------");
		System.out.print("��Ҫ��");
		String T_comments = InputUtil.next();	
		System.out.println("-----------------------------------------------");
		System.out.print("��ɫ��");
		String color = InputUtil.next();
		System.out.println("-----------------------------------------------");
		System.out.print("�����۸�");
		String price = InputUtil.next();
		System.out.println("-----------------------------------------------");
		System.out.print("ÿ�����");
		String rent = InputUtil.next();
		System.out.println("-----------------------------------------------");
		System.out.print("�Ƿ�ɽ裨0���ɽ�   1�����ɽ裩");
		int status = InputUtil.nextInt();
		System.out.println("-----------------------------------------------");
		System.out.print("�Ƿ��ϼܣ�0���ϼ�   1�����ϼܣ�");
		int useable = InputUtil.nextInt();
		Car car1 = new Car( car_number,  brand_id, model,  color,  category_id,  T_comments,
				price, rent,  status, useable);
		return car1;
	}

	@Override
	public int addAdminCar(Car car) {
		String sql = "insert  into  t_Car  values(t_car_id_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
		Object[] num = {car.getCar_number(),car.getBrand_id(),car.getModel(),car.getColor(),car.getCategory_id(),car.getT_comments(),car.getPrice(),car.getRent(),car.getStatus(),car.getUseable()};
		int temp =executSQL(sql,num);
		return temp;
	}

	@Override
	public int updateRentCar(int car_id ,String rent ) {
		String sql = "update t_car set  t_car.rent = ?  where t_car.id = ? and T_car.status = 0";
		Object[] num = {rent,car_id};
		int temp = executSQL(sql,num);
		return temp;
	}

	@Override
	public int updateUseableCar(int car_id, int useable) {
		String sql = "update t_car set  t_car.useable = ?  where t_car.id = ? and T_car.status = 0";
		Object[] num = {useable,car_id};
		int temp = executSQL(sql,num);
		return temp;
	}

	@Override
	public Car updateCar(int car_id) {
		Car car = null;
		conn = getConnection();
		String sql = "select T_car.id as ���, T_car.model as �������� , T_car.t_comments as ��ע , T_brand.name||'('||T_brand.Id||')' as Ʒ�� , t_Category.name||'('||t_Category.Id||')' as ����, T_car.rent as �۸� , T_car.price as ���� ,  T_car.status as �Ƿ����   , T_car.useable as �Ƿ��ϼ� "   
				+"from T_car   inner join  T_brand  on (T_car.brand_id = T_brand.id)"+
				"inner  join t_Category  on (T_car.category_id = t_Category.id)   where T_car.id = ?  order by T_car.Id ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, car_id);
			rs = ps.executeQuery();
			while(rs.next()){
				car = new Car();
				car.setId(rs.getInt(1));
				car.setModel(rs.getString(2));
				car.setT_comments(rs.getString(3));
				car.setBrank(rs.getString(4));
				car.setCategory(rs.getString(5));
				car.setRent(rs.getString(6));
				car.setPrice(rs.getString(7));
				car.setStatus(rs.getInt(8));
				car.setUseable(rs.getInt(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn,ps,rs);
		}
		return car;
	}

	@Override
	public int repaypayment(UserRentListCar payment) {
		int payment1 = Integer.parseInt(payment.getPayment());
		int rent1 = Integer.parseInt(payment.getRent());
		if(payment1<24){
			String sql = "update T_record  r  set  r.Payment = ?";
			Object[] num = {rent1};
			int temp = executSQL(sql,num);
			return temp;
		}else {
			int rent = (payment1/24)*rent1;
			String sql = "update T_record  r  set  r.Payment = ?";
			Object[] num = {rent};
			int temp = executSQL(sql,num);
			return temp;
		}
	}

	@Override
	public int updatestatus(int car_id) {
		String sql = "update T_car  set  T_car.status = 0  where  T_car.id = ? ";
		Object[] num = {car_id};
		int temp = executSQL(sql,num);
		return temp;
	}

	@Override
	public List<UserRentListCar> findrecord() {
		List<UserRentListCar> list = new ArrayList<>();
		conn = getConnection();
		String sql = "select  T_record.Id as ���,T_car.id as �������,T_car.model as ��������,T_user.id as �û���� , T_user.username as �û���, T_car.rent as �۸� , T_record.Payment as ����� , T_car.t_comments as ��ע , T_brand.name||'('||T_brand.Id||')' as Ʒ�� , t_Category.name||'('||t_Category.Id||')' as ���� ,T_record.Start_Date as ���ʱ�� ,T_record.Return_Date as ����ʱ�� " 
				+"from  T_record  inner join  T_car on (T_record.Car_Id = T_car.Id)"
				+"inner join  T_brand  on (T_car.brand_id = T_brand.id) "
				+"inner join t_Category  on (T_car.category_id = t_Category.id) "
				+"inner join T_user on (T_record.user_id = T_user.id)";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				UserRentListCar urlc = new UserRentListCar();
				urlc.setId(rs.getInt(1));
				urlc.setCar_id(rs.getInt(2));
				urlc.setModel(rs.getString(3));
				urlc.setUser_id(rs.getInt(4));
				urlc.setUsername(rs.getString(5));
				urlc.setRent(rs.getString(6));
				urlc.setPayment(rs.getString(7));
				urlc.setRemark(rs.getString(8));
				urlc.setBrank(rs.getString(9));
				urlc.setCategory(rs.getString(10));
				urlc.setRenttime(rs.getString(11));
				urlc.setRepaytime(rs.getString(12));
				list.add(urlc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(conn,ps,rs);
		}
		return list;
	}
		

}


