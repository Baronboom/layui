package service;

import java.util.List;

import model.Crm_department;
import model.Crm_sellman;
import utils.ReturnInfo;

public interface Crm_sellman_Service {
	// 查询全部
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// 查询一个
	public Crm_sellman selectById(Integer id);
	
	// 查询Crm_department
	public List<Crm_department> selectDeps();
	
	// 新增
	public void insert(Crm_sellman t);
	
	// 修改
	public void update(Crm_sellman t);
	
	// 删除
	public void delete(Integer id);
}
