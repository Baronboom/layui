package service;

import model.Crm_department;
import utils.ReturnInfo;

public interface Crm_department_Service {
	// 查询全部
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// 查询一个
	public Crm_department selectById(Integer id);
	
	// 新增
	public void insert(Crm_department t);
	
	// 修改
	public void update(Crm_department t);
	
	// 删除
	public void delete(Integer id);
}
