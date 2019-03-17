package entity;
/**
 * 用户租赁汽车类
 * @author oracleOAEC
 *
 */
public class UserRentCar {

	private int user_id;
	private int car_id;
	private String username;
	private String model;
	private String rent;
	private String remark;
	private String  brank;
	private String category;
	private String time;
	private int status;
	
	
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}


	public UserRentCar() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public UserRentCar(int car_id, String model, String rent, String remark, String brank, String category,
			String time) {
		super();
		this.car_id = car_id;
		this.model = model;
		this.rent = rent;
		this.remark = remark;
		this.brank = brank;
		this.category = category;
		this.time = time;
	}

	

	public UserRentCar(int car_id, String model, String rent, String remark, String brank, String category,
			int status) {
		super();
		this.car_id = car_id;
		this.model = model;
		this.rent = rent;
		this.remark = remark;
		this.brank = brank;
		this.category = category;
		this.status = status;
	}


	public UserRentCar(int user_id, int car_id, String username, String model, String rent, String remark, String brank,
			String category, String time,int status) {
		super();
		this.user_id = user_id;
		this.car_id = car_id;
		this.username = username;
		this.model = model;
		this.rent = rent;
		this.remark = remark;
		this.brank = brank;
		this.category = category;
		this.time = time;
		this.status =status;
	}


	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the car_id
	 */
	public int getCar_id() {
		return car_id;
	}
	/**
	 * @param car_id the car_id to set
	 */
	public void setCar_id(int car_id) {
		this.car_id = car_id;
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
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the rent
	 */
	public String getRent() {
		return rent;
	}
	/**
	 * @param rent the rent to set
	 */
	public void setRent(String rent) {
		this.rent = rent;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the brank
	 */
	public String getBrank() {
		return brank;
	}
	/**
	 * @param brank the brank to set
	 */
	public void setBrank(String brank) {
		this.brank = brank;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getCar_id()+"\t\t"+this.getModel()+"\t\t\t"+this.getRent()+"\t\t\t"+this.getRemark()+"\t\t"+this.getBrank()+"\t\t"+this.getCategory()+"\t\t"+this.getTime();
	}
	
	
}
