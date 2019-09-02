package service;

import java.util.List;


import model.Type;
import utils.ReturnInfo;

public interface Type_Service {
	
	// 查询全部
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// 查询一个
	public Type selectById(Integer id);
	
	// 新增
	public void insert(Type t);
	
	// 修改
	public void update(Type t);
	
	// 删除
	public void delete(Integer id);
}
