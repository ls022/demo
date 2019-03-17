package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.BaseDao;
import dao.OperationDao;
import entity.User;
import entity.UserRentCar;
/**
 * ����ʵ����
 * @author oracleOAEC
 *
 */
public class OperationDaoImpl extends BaseDao implements OperationDao{

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public void operationCar() {
		System.out.println("����0�˳�");
		System.out.println("����1+������� �����⳵���� ��1+2");
		System.out.println("����2+1  ���۸�������  2+2  ���۸���������");
		System.out.println("����3+���ͱ�� ����������");
		System.out.println("����4+Ʒ�Ʊ�� ��Ʒ������");
		System.out.println("����5  �鿴ȫ������");
		System.out.println("����6  �鿴�ҵ��⳵��¼");
		System.out.println("����7+�������   ����");	
	}

	@Override
	public UserRentCar findCar(User users,int car_id) {
		UserRentCar urc = null;
		conn = getConnection();
		String sql = "select T_car.id as ���,T_car.model as ��������,T_car.rent as �۸� , T_car.t_comments as ��ע , T_brand.name as Ʒ�� , t_Category.name as ���� ,T_record.Start_Date as ʱ�� "  
								+"from T_car   inner join  T_brand  on (T_car.brand_id = T_brand.id) "
								+"inner join t_Category  on (T_car.category_id = t_Category.id) "
								+"inner join T_record on (T_record.Car_Id = T_car.Id)"
								+"where T_car.status = 0  and T_car.useable = 0  and T_car.Id =? and T_record.User_Id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, car_id);
			ps.setInt(2, users.getId());
			rs = ps.executeQuery();
			while(rs.next()){
				urc = new UserRentCar();
				urc.setCar_id(rs.getInt(1));
				urc.setModel(rs.getString(2));
				urc.setRent(rs.getString(3));
				urc.setRemark(rs.getString(4));
				urc.setBrank(rs.getString(5));
				urc.setCategory(rs.getString(6));
				urc.setTime(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn,ps,rs);
		}
		return urc;
	}

	@Override
	public int rentCar(User users,int car_id) {
		int tmpe = 0;
		conn = getConnection();
		String sql = "insert into T_record  values(t_record_id_seq.nextval,?,?,sysdate,null,0)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, users.getId());
			ps.setInt(2, car_id);
			tmpe = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn,ps,null);
		}
		return tmpe;
	}

	@Override
	public int statusCar(int car_id) {
		int temps = 0;
		conn = getConnection();
		String sql = "update T_car  set  T_car.status = 1  where T_car.Id =? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, car_id);
			temps = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn,ps,null);
		}
		return temps;
	}

	@Override
	public void operationAdminCar() {
		System.out.println("����0�˳�");
		System.out.println("����1+������� �鿴ָ������");
		System.out.println("����5  �鿴ȫ������");
		System.out.println("����6  �������");
		System.out.println("����7+�������   �޸�������Ϣ");
		System.out.println("����8   �鿴������¼");
	}

}
