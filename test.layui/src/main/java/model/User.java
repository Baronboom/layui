package model;

public class User {
	private Integer id;
	private String name;
	private String pass;
	
	
	public User(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public User() {
		
	}
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
