package model;

public class C_client {
	private Integer id;
	private String name;
	private String tel;
	private String qq;
	private String email;
	private String infos;
	private String operatorids;
	private String createdate;
	private Integer count;
	private String comments;
	
	private Integer clienttypeid;
	private Integer createoperatorid;
	private Integer srcid;
	private String clienttypename;
	private String createoperatorname;
	private String srcname;
	
	private Integer sex;
	private Integer status;
	private Integer linkstatus;
	private Integer clientstatus;
	private Integer purposestatus;
	private Integer assessstatus;
	private Integer execstatus;
	
	public static String[]sexss= {"不限","男","女"};
	public String getSexss() {
		return sexss[sex];
	}
	public static String[]statuss= {"正常","公共","资料不全","无效"};
	public String getStatuss() {
		return statuss[status];
	}
	public static String[]linkstatuss= {"未指定","秒挂","未接通","有交流","深入交流"};
	public String getLinkstatuss() {
		return linkstatuss[linkstatus];
	}
	public static String[]clientstatuss= {"未指定","排斥","推脱","后续","较好"};
	public String getClientstatuss() {
		return clientstatuss[clientstatus];
	}
	public static String[]purposestatuss= {"未指定","完全没戏","先观察着","较有兴趣","非常有意向","已经确定"};
	public String getPurposestatuss() {
		return purposestatuss[purposestatus];
	}
	public static String[]assessstatuss= {"未指定","截至","无果","有预约"};
	public String getAssessstatuss() {
		return assessstatuss[assessstatus];
	}
	public static String[]execstatuss= {"正常","转出","完成"};
	public String getExecstatuss() {
		return execstatuss[execstatus];
	}
	
	
	
	
	
	
	
	public String getClienttypename() {
		return clienttypename;
	}
	public void setClienttypename(String clienttypename) {
		this.clienttypename = clienttypename;
	}
	public String getCreateoperatorname() {
		return createoperatorname;
	}
	public void setCreateoperatorname(String createoperatorname) {
		this.createoperatorname = createoperatorname;
	}
	public String getSrcname() {
		return srcname;
	}
	public void setSrcname(String srcname) {
		this.srcname = srcname;
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
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInfos() {
		return infos;
	}
	public void setInfos(String infos) {
		this.infos = infos;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getClienttypeid() {
		return clienttypeid;
	}
	public void setClienttypeid(Integer clienttypeid) {
		this.clienttypeid = clienttypeid;
	}
	public String getOperatorids() {
		return operatorids;
	}
	public void setOperatorids(String operatorids) {
		this.operatorids = operatorids;
	}
	public Integer getCreateoperatorid() {
		return createoperatorid;
	}
	public void setCreateoperatorid(Integer createoperatorid) {
		this.createoperatorid = createoperatorid;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public Integer getSrcid() {
		return srcid;
	}
	public void setSrcid(Integer srcid) {
		this.srcid = srcid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	
}
