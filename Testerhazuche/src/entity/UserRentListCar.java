package entity;
/**
 * 用户租车记录类
 * @author oracleOAEC
 *
 */
public class UserRentListCar {

	private int id;  //租赁表的id
	private int user_id;
	private int car_id;
	private String username;
	private String model;
	private String rent;
	private String payment;
	private String remark;
	private String  brank;
	private String category;
	private String renttime;
	private String repaytime;
	
	
	public UserRentListCar() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public UserRentListCar(int car_id, String username, String model, String rent, String payment, String remark,
			String brank, String category, String renttime, String repaytime) {
		super();
		this.car_id = car_id;
		this.username = username;
		this.model = model;
		this.rent = rent;
		this.payment = payment;
		this.remark = remark;
		this.brank = brank;
		this.category = category;
		this.renttime = renttime;
		this.repaytime = repaytime;
	}



	public UserRentListCar(int id, int car_id, String model, String payment, String remark, String brank,
			String category, String renttime, String repaytime) {
		super();
		this.id = id;
		this.car_id = car_id;
		this.model = model;
		this.payment = payment;
		this.remark = remark;
		this.brank = brank;
		this.category = category;
		this.renttime = renttime;
		this.repaytime = repaytime;
	}

	public UserRentListCar(int id, int user_id, int car_id, String username, String model, String rent, String payment,
			String remark, String brank, String category, String renttime, String repaytime) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.car_id = car_id;
		this.username = username;
		this.model = model;
		this.rent = rent;
		this.payment = payment;
		this.remark = remark;
		this.brank = brank;
		this.category = category;
		this.renttime = renttime;
		this.repaytime = repaytime;
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
	 * @return the payment
	 */
	public String getPayment() {
		return payment;
	}
	/**
	 * @param payment the payment to set
	 */
	public void setPayment(String payment) {
		this.payment = payment;
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
	 * @return the renttime
	 */
	public String getRenttime() {
		return renttime;
	}
	/**
	 * @param renttime the renttime to set
	 */
	public void setRenttime(String renttime) {
		this.renttime = renttime;
	}
	/**
	 * @return the repaytime
	 */
	public String getRepaytime() {
		return repaytime;
	}
	/**
	 * @param repaytime the repaytime to set
	 */
	public void setRepaytime(String repaytime) {
		this.repaytime = repaytime;
	}

	@Override
	public String toString() {
		return this.getId()+"\t\t\t"+this.getCar_id()+"\t\t"+this.getModel()+"\t\t"+this.getPayment()+"\t\t\t"+this.getRemark()+"\t\t"+this.getBrank()+"\t\t"+this.getCategory()+"\t\t"+this.getRenttime()+"\t\t"+this.getRepaytime();
	}
	
	public String toCar(){
		return this.getCar_id()+"\t\t\t"+this.getModel()+"\t\t"+this.getRent()+"\t\t"+this.getPayment()+"\t\t\t"+this.getRemark()+"\t\t"+this.getBrank()+"\t\t"+this.getCategory()+"\t\t"+this.getRenttime()+"\t\t"+this.getRepaytime();
	}
	
	public String toRecord() {
		return this.getId()+"\t\t\t"+this.getCar_id()+"\t\t"+this.getModel()+"\t\t"+this.getUser_id()+"\t\t\t"+this.getUsername()+"\t\t"+this.getRent()+"\t\t"+this.getPayment()+"\t\t\t"+this.getRemark()+"\t\t"+this.getBrank()+"\t\t"+this.getCategory()+"\t\t"+this.getRenttime()+"\t\t"+this.getRepaytime();
	}
	
}
