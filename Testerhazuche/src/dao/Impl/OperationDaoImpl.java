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
 * 操作实现类
 * @author oracleOAEC
 *
 */
public class OperationDaoImpl extends BaseDao implements OperationDao{

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public void operationCar() {
		System.out.println("输入0退出");
		System.out.println("输入1+汽车编号 进入租车订单 如1+2");
		System.out.println("输入2+1  按价格降序排序  2+2  按价格升序排序");
		System.out.println("输入3+类型编号 按类型搜索");
		System.out.println("输入4+品牌编号 按品牌搜索");
		System.out.println("输入5  查看全部汽车");
		System.out.println("输入6  查看我的租车记录");
		System.out.println("输入7+汽车编号   还车");	
	}

	@Override
	public UserRentCar findCar(User users,int car_id) {
		UserRentCar urc = null;
		conn = getConnection();
		String sql = "select T_car.id as 编号,T_car.model as 汽车名字,T_car.rent as 价格 , T_car.t_comments as 备注 , T_brand.name as 品牌 , t_Category.name as 类型 ,T_record.Start_Date as 时间 "  
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
		System.out.println("输入0退出");
		System.out.println("输入1+汽车编号 查看指定汽车");
		System.out.println("输入5  查看全部汽车");
		System.out.println("输入6  添加汽车");
		System.out.println("输入7+汽车编号   修改汽车信息");
		System.out.println("输入8   查看汽车记录");
	}

}
