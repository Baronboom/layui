package model;

import java.util.List;

public class Crm_recode {
	private Integer id;
	private String date;
	private Integer smid;
	private Integer cmid;
	private String info;
	private String nextdate;
	private Integer status;
	private String sellname;
	private String csrname;

	public static String[]stas= {"直接关断","有事推脱","正常交流","交流很好"};
	public String getCsrstaname() {
		return stas[status];
	}
	
	public String getSellname() {
		return sellname;
	}
	public void setSellname(String sellname) {
		this.sellname = sellname;
	}
	public String getCsrname() {
		return csrname;
	}
	public void setCsrname(String csrname) {
		this.csrname = csrname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getSmid() {
		return smid;
	}
	public void setSmid(Integer smid) {
		this.smid = smid;
	}
	public Integer getCmid() {
		return cmid;
	}
	public void setCmid(Integer cmid) {
		this.cmid = cmid;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getNextdate() {
		return nextdate;
	}
	public void setNextdate(String nextdate) {
		this.nextdate = nextdate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

}
