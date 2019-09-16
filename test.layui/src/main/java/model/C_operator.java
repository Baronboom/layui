package model;


public class C_operator {

	private Integer id;
	private String name;
	private String pass;
	private String tel;
	private Integer groupid;
	private Integer power;
	private Integer status;
	private String groupname;
	
	
	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public static String[]powers= {"管理员","组长","组员"};
	public String getPowers() {
		return powers[power];
	}
	
	public static String[]statuss= {"状态1","状态2","状态3"};
	public String getStatuss() {
		return statuss[status];
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
