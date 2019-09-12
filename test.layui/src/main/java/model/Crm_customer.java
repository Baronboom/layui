package model;

public class Crm_customer {

	private Integer id;
	private String csrname;
	private String csrtel;
	private Integer csrsta;
	private Integer semid;
	private String sellname;
	
	public static String[]stas= {"没戏","考虑中","已完成"};
	public String getCsrsta() {
		return stas[csrsta];
	}
	

	public String getSellname() {
		return sellname;
	}

	public void setSellname(String sellname) {
		this.sellname = sellname;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCsrname() {
		return csrname;
	}

	public void setCsrname(String csrname) {
		this.csrname = csrname;
	}

	public String getCsrtel() {
		return csrtel;
	}

	public void setCsrtel(String csrtel) {
		this.csrtel = csrtel;
	}

	public Integer getSemid() {
		return semid;
	}

	public void setSemid(Integer semid) {
		this.semid = semid;
	}

}
