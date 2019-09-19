package model;

public class C_revisit {
	private Integer id;
	private String createdate;
	private String askinfo;
	private String followinfo;
	private String probleminfo;
	private String comments;
	private String name;
	
	private Integer operatorid;
	private Integer clientid;
	private Integer status;
	private Integer linkstatus;
	private Integer clientstatus;
	private Integer purposestatus;
	private Integer assessstatus;
	private Integer execstatus;
	
	private String clientname;
	private String operatorname;
	

	public static String[]statuss= {"����","����"};
	public String getStatuss() {
		return statuss[status];
	}
	public static String[]linkstatuss= {"���","δ��ͨ","�н���","���뽻��"};
	public String getLinkstatuss() {
		return linkstatuss[linkstatus];
	}
	public static String[]clientstatuss= {"�ų�","����","����","�Ϻ�"};
	public String getClientstatuss() {
		return clientstatuss[clientstatus];
	}
	public static String[]purposestatuss= {"��ȫûϷ","�ȹ۲���","������Ȥ","�ǳ�������","�Ѿ�ȷ��"};
	public String getPurposestatuss() {
		return purposestatuss[purposestatus];
	}
	public static String[]assessstatuss= {"����","�޹�","��ԤԼ"};
	public String getAssessstatuss() {
		return assessstatuss[assessstatus];
	}
	public static String[]execstatuss= {"����","ת��","���"};
	public String getExecstatuss() {
		return execstatuss[execstatus];
	}
	
	public String getOperatorname() {
		return operatorname;
	}

	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}
	
	public Integer getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(Integer operatorid) {
		this.operatorid = operatorid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getAskinfo() {
		return askinfo;
	}
	public void setAskinfo(String askinfo) {
		this.askinfo = askinfo;
	}
	public String getFollowinfo() {
		return followinfo;
	}
	public void setFollowinfo(String followinfo) {
		this.followinfo = followinfo;
	}
	public String getProbleminfo() {
		return probleminfo;
	}
	public void setProbleminfo(String probleminfo) {
		this.probleminfo = probleminfo;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Integer getClientid() {
		return clientid;
	}
	public void setClientid(Integer clientid) {
		this.clientid = clientid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
