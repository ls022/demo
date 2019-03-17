package entity;
/**
 * 查询汽车类
 * @author oracleOAEC
 *
 */
public class SelectCar {

	private int id;
	private String name;
	private String  remark;
	private String brank;
	private String category;
	private String rent;
	private int status;
	private int useable;
	
	public SelectCar() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public SelectCar(int id, String name, String remark, String brank, String category, String rent, int status) {
		super();
		this.id = id;
		this.name = name;
		this.remark = remark;
		this.brank = brank;
		this.category = category;
		this.rent = rent;
		this.status = status;
	}


	
	
	public SelectCar(int id, String name, String remark, String brank, String category, String rent, int status,
			int useable) {
		super();
		this.id = id;
		this.name = name;
		this.remark = remark;
		this.brank = brank;
		this.category = category;
		this.rent = rent;
		this.status = status;
		this.useable = useable;
	}


	public int getUseable() {
		return useable;
	}


	public void setUseable(int useable) {
		this.useable = useable;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String a = "";
		String b = "";
		String c = "";
		if(this.getId()==2){
			c = this.getCategory()+"\t";
		}else{
			c = this.getCategory();
		}
		if(this.getId()==3||this.getId()==4){
			 a=this.getName()+"\t";
		}else{
			 a =this.getName();
		}
		if(this.getStatus()==0){
			b = "可租";
		}else{
			b = "不可租";
		}
		return this.getId()+"\t\t"+a+"\t\t"+this.getRemark()+"\t"+this.getBrank()+"\t\t"+c+"\t\t"+this.getRent()+"元/天"+"\t\t"+b;
	}
	
	public String admiantoString() {
		String a = "";
		String b = "";
		String c = "";
		String d = "";
		if(this.getId() ==2){
			c = this.getCategory()+"\t";
		}else{
			c = this.getCategory();
		}
		if(this.getId()==3||this.getId()==4){
			 a=this.getName()+"\t";
		}else{
			 a =this.getName();
		}
		if(this.getStatus()==0){
			b = "可租";
		}else{
			b = "不可租";
		}
		if(this.getUseable()==0) {
			d = "上架";
		}else {
			d = "不上架";
		}
		return this.getId()+"\t\t"+a+"\t\t"+this.getRemark()+"\t"+this.getBrank()+"\t\t"+c+"\t\t"+this.getRent()+"元/天"+"\t\t"+b+"\t\t\t"+d;
	}
	
	
}
