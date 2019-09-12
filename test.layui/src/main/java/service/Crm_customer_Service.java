package service;

import java.util.List;

import model.Crm_customer;
import model.Crm_sellman;
import utils.ReturnInfo;

public interface Crm_customer_Service {
	// 查询总的
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// 查询Crm_customer
	public Crm_customer selectByid(Integer id);
	
	// 查询Crm_sellman
	public List<Crm_sellman> selectsellman();
	
	// 新增
	public void insert(Crm_customer b);
	
	// 修改
	public void update(Crm_customer b);
	
	// 删除
	public void delete(Crm_customer b);
}
