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
	 * 建立连接数据库
	 * @return
	 */
	public Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(driver); //加载驱动
			try {
				conn = DriverManager.getConnection(url, username, pwd); //通过DriverManager获得数据库连接
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
	 * 关闭连接
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
	 * 执行sql语句，可以进行增、删、改的操作，不能执行查询
	 * @param sql
	 * 	预编译的sql语句
	 * @param num
	 * 	预编译的sql语句中的 '?' 参数的字符串数组
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
					ps.setObject(i+1, num[i]);  //为预编译sql传入的参数
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
