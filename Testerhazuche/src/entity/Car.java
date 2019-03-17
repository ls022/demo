package entity;

public class Car {

	private int id;
	private String car_number;
	private int brand_id;
	private String model;
	private String color;
	private int category_id;
	private String T_comments;
	private String price;
	private  String rent;
	private  int  status;
	private int useable;
	private String brank;
	private String category;
	
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

	public Car() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @return the car_number
	 */
	public String getCar_number() {
		return car_number;
	}

	/**
	 * @param car_number the car_number to set
	 */
	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}

	/**
	 * @return the brand_id
	 */
	public int getBrand_id() {
		return brand_id;
	}

	/**
	 * @param brand_id the brand_id to set
	 */
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
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
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the category_id
	 */
	public int getCategory_id() {
		return category_id;
	}

	/**
	 * @param category_id the category_id to set
	 */
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	/**
	 * @return the t_comments
	 */
	public String getT_comments() {
		return T_comments;
	}

	/**
	 * @param t_comments the t_comments to set
	 */
	public void setT_comments(String t_comments) {
		T_comments = t_comments;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
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

	/**
	 * @return the useable
	 */
	public int getUseable() {
		return useable;
	}

	/**
	 * @param useable the useable to set
	 */
	public void setUseable(int useable) {
		this.useable = useable;
	}

	
	
	public Car(int id, String model, String t_comments, String price, String rent, int status, int useable,
			String brank, String category) {
		super();
		this.id = id;
		this.model = model;
		T_comments = t_comments;
		this.price = price;
		this.rent = rent;
		this.status = status;
		this.useable = useable;
		this.brank = brank;
		this.category = category;
	}

	public Car(String car_number, int brand_id, String model, String color, int category_id, String t_comments,
			String price, String rent, int status, int useable) {
		super();
		this.car_number = car_number;
		this.brand_id = brand_id;
		this.model = model;
		this.color = color;
		this.category_id = category_id;
		T_comments = t_comments;
		this.price = price;
		this.rent = rent;
		this.status = status;
		this.useable = useable;
	}

	public Car(int id, String car_number, int brand_id, String model, String color, int category_id, String t_comments,
			String price, String rent, int status, int useable) {
		super();
		this.id = id;
		this.car_number = car_number;
		this.brand_id = brand_id;
		this.model = model;
		this.color = color;
		this.category_id = category_id;
		T_comments = t_comments;
		this.price = price;
		this.rent = rent;
		this.status = status;
		this.useable = useable;
	}

	public Car(int id, String car_number, String model, String color, String t_comments, String price, String rent,
			int status, int useable, String brank, String category) {
		super();
		this.id = id;
		this.car_number = car_number;
		this.model = model;
		this.color = color;
		T_comments = t_comments;
		this.price = price;
		this.rent = rent;
		this.status = status;
		this.useable = useable;
		this.brank = brank;
		this.category = category;
	}
	
	
	public String toString() {
		String a = "";
		String b = "";
		String c = "";
		String d = "";
		if(this.getStatus()==0){
			a = "可租";
		}else{
			a = "不可租";
		}
		if(this.getUseable()==0){
			b = "上架";
		}else{
			b = "不上架";
		}
		if(this.getId()==3 || this.getId() == 4){
			c = this.getModel() + "\t";
		}else{
			c = this.getModel();
		}
		if(this.getId()==2){
			d = this.getCategory()+"\t";
		}else{
			d = this.getCategory();
		}
		return  this.getId()+"\t\t"+this.getCar_number()+"\t\t"+c+"\t\t"+this.getColor()+"\t\t"+this.getT_comments()+"\t\t"+this.getBrank()+"\t\t"+d+"\t\t"+this.getRent()+"\t\t"+this.getPrice()+"\t\t\t"+a+"\t\t\t"+b;
	}

	public String  toCarString(){
		String a = "";
		String b = "";
		if(this.getStatus()==0){
			a = "可租";
		}else{
			a = "不可租";
		}
		if(this.getUseable()==0){
			b = "上架";
		}else{
			b = "不上架";
		}
		return  this.getId()+"\t\t"+this.getCar_number()+"\t\t"+this.getModel()+"\t\t"+this.getColor()+"\t\t"+this.getT_comments()+"\t\t"+this.getBrank()+"\t\t"+this.getCategory()+"\t\t"+this.getRent()+"\t\t"+this.getPrice()+"\t\t\t"+a+"\t\t\t"+b;
	}
	
	public String toupdateString(){
		String a = "";
		String b = "";
		if(this.getStatus()==0){
			a = "可租";
		}else{
			a = "不可租";
		}
		if(this.getUseable()==0){
			b = "上架";
		}else{
			b = "不上架";
		}
		return  this.getId()+"\t\t"+this.getModel()+"\t\t"+this.getT_comments()+"\t\t"+this.getBrank()+"\t\t"+this.getCategory()+"\t\t"+this.getRent()+"\t\t"+this.getPrice()+"\t\t\t"+a+"\t\t\t"+b;
	}
}
