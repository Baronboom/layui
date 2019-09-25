package model;

public class Status {

	private Integer id;
	private Integer count=0;
	private Integer status;
	private Integer linkstatus;
	private Integer clientstatus;
	private Integer purposestatus;
	private Integer assessstatus;
	private Integer execstatus;
	
	public Integer getStatus() {
		return status;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLinkstatus() {
		return linkstatus;
	}
	public void setLinkstatus(Integer linkstatus) {
		this.linkstatus = linkstatus;
	}
	public Integer getClientstatus() {
		return clientstatus;
	}
	public void setClientstatus(Integer clientstatus) {
		this.clientstatus = clientstatus;
	}
	public Integer getPurposestatus() {
		return purposestatus;
	}
	public void setPurposestatus(Integer purposestatus) {
		this.purposestatus = purposestatus;
	}
	public Integer getAssessstatus() {
		return assessstatus;
	}
	public void setAssessstatus(Integer assessstatus) {
		this.assessstatus = assessstatus;
	}
	public Integer getExecstatus() {
		return execstatus;
	}
	public void setExecstatus(Integer execstatus) {
		this.execstatus = execstatus;
	}
	
	
}
