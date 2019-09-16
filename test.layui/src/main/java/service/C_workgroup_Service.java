package service;

import model.C_workgroup;
import utils.ReturnInfo;

public interface C_workgroup_Service {

	// 查询全部
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// 查询一个
	public C_workgroup selectById(Integer id);
	
	// 新增
	public void insert(C_workgroup t);
	
	// 修改
	public void update(C_workgroup t);
	
	// 删除
	public void delete(Integer id);
}
