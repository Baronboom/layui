package model;

public class Book {
	public static String[]sexs= {"²»ÏÞ","ÄÐ","Å®"};
	
	public String getSexname() {
		return sexs[sex];
	}

	private String typename;
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	
	
	private Integer id;
	private String name;
	private int sex;

	private Integer typeid;
	
	


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Book(String name) {
		super();
		this.name = name;
	}


	public int getSex() {
		return sex;
	}


	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
