package model;

public class C_reserved {
	private Integer id;
	private String createdate; // 创建时间
	private String date; // 预约时间
	private String result;
	
	private Integer revisitid;
	private Integer clientid;
	private Integer operatorid;
	private Integer execoperatorid;
	
	private Integer type;
	private Integer status;
	private Integer execstatsu;
	
	private String revisitname;
	private String clientname;
	private String operatorname;
	private String execoperatorname;

	public static String[]statuss= {"未处理","已处理"};
	public String getStatuss() {
		return statuss[status];
	}
	public static String[]types= {"回访预约","上门预约"};
	public String getTypes() {
		return types[type];
	}
	public static String[]execstatsus= {"正常","违约","延期","下次继续"};
	public String getExecstatsus() {
		return execstatsus[execstatsu];
	}
	
	
	
	public String getRevisitname() {
		return revisitname;
	}
	public void setRevisitname(String revisitname) {
		this.revisitname = revisitname;
	}
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	public String getOperatorname() {
		return operatorname;
	}
	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}
	public String getExecoperatorname() {
		return execoperatorname;
	}
	public void setExecoperatorname(String execoperatorname) {
		this.execoperatorname = execoperatorname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRevisitid() {
		return revisitid;
	}
	public void setRevisitid(Integer revisitid) {
		this.revisitid = revisitid;
	}
	public Integer getClientid() {
		return clientid;
	}
	public void setClientid(Integer clientid) {
		this.clientid = clientid;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public Integer getOperatorid() {
		return operatorid;
	}
	public void setOperatorid(Integer operatorid) {
		this.operatorid = operatorid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getExecoperatorid() {
		return execoperatorid;
	}
	public void setExecoperatorid(Integer execoperatorid) {
		this.execoperatorid = execoperatorid;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getExecstatsu() {
		return execstatsu;
	}
	public void setExecstatsu(Integer execstatsu) {
		this.execstatsu = execstatsu;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	

}
