package entity;
/**
 * ”√ªß¿‡
 * @author oracleOAEC
 *
 */
public class User {

	private  int id;
	private String username;
	private String password;
	private int sex;
	private String id_number;
	private String tel;
	private String addr;
	private int type;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	

	public User(String username, String password, int sex, String id_number, String tel, String addr) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.id_number = id_number;
		this.tel = tel;
		this.addr = addr;
	}


	public User(int id, String username,String password, int sex, String id_number, String  tel, String addr, int type) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.id_number = id_number;
		this.tel = tel;
		this.addr = addr;
		this.type = type;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the sex
	 */
	public int  getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}

	/**
	 * @return the id_number
	 */
	public String getId_number() {
		return id_number;
	}

	/**
	 * @param id_number the id_number to set
	 */
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the addr
	 */
	public String getAddr() {
		return addr;
	}

	/**
	 * @param addr the addr to set
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", id_number="
				+ id_number + ", tel=" + tel + ", addr=" + addr + ", type=" + type + "]";
	}
	
	
	
}
