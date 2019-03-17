package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {

	private String driver = "oracle.jdbc.OracleDriver";
	private  String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String username = "system";
	private String pwd = "root";
	/**
	 * �����������ݿ�
	 * @return
	 */
	public Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(driver); //��������
			try {
				conn = DriverManager.getConnection(url, username, pwd); //ͨ��DriverManager������ݿ�����
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * �ر�����
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public void closeAll(Connection conn,PreparedStatement ps , ResultSet rs){
		if(rs !=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!= null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!= null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * ִ��sql��䣬���Խ�������ɾ���ĵĲ���������ִ�в�ѯ
	 * @param sql
	 * 	Ԥ�����sql���
	 * @param num
	 * 	Ԥ�����sql����е� '?' �������ַ�������
	 * @return
	 */
	public int executSQL(String sql,Object[]  num){
		int temp = 0;
		Connection conn = null; 
		PreparedStatement  ps = null;
		conn = getConnection();
		try {
			ps = conn.prepareStatement(sql);
			if(num!= null){
				for(int i = 0;i<num.length;i++){
					ps.setObject(i+1, num[i]);  //ΪԤ����sql����Ĳ���
				}
			}
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(conn, ps, null);
		}
		return temp;
	}
}
