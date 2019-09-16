package service;

import java.util.List;
import model.Crm_customer;
import model.Crm_recode;
import model.Crm_sellman;
import utils.ReturnInfo;

public interface Crm_recode_Service {
	
	// 查询总的
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// 查询Crm_recode
	public Crm_recode selectByid(Integer id);
	
	// 查询Crm_sellman
	public List<Crm_sellman> selectsellman();
	
	// 查询Crm_customer
	public List<Crm_customer> selectcus();
	
	// 新增
	public void insert(Crm_recode b);
	
	// 修改
	public void update(Crm_recode b);
	
	// 删除
	public void delete(Crm_recode b);
}
