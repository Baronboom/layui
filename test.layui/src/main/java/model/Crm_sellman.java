package model;


public class Crm_sellman {

	private Integer id;
	private String name;
	private Integer depid;
	
	private String depname;
	public String getDepname() {
		return depname;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}
	
	public Integer getId() {
		return id;
	}

	public void setIrd(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDepid() {
		return depid;
	}

	public void setDepid(Integer depid) {
		this.depid = depid;
	}

}
